package com.datanexions.mgen;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;

@Service
public class FileService {


    @Autowired
    @Qualifier("apiCollection")
    Collection bucket;


    @Autowired
    @Qualifier("loopbackCollection")
    Collection bucketLoopback;

    
    @Autowired
    @Qualifier("apiCluster") 
    Cluster cluster;
    
    @Autowired
    @Qualifier("loopbackCluster") 
    Cluster clusterLoopback;
    
    @Value("${couchbase.bucketName}")
    private  String bucketName ;

    @Value("${couchbase.bucketNameLoopback}")
    private  String bucketNameLoopback ;
    
    public FileService(){
    	super();
        // Main bucket
    	/*
        cluster = Cluster.connect(host, userName, password);
        Bucket bucketObj = cluster.bucket(bucketName);
        bucket = bucketObj.defaultCollection();

        // Loopback bucket
        clusterLoopback = Cluster.connect(host, userName, password);
        Bucket bucketObjLoopback = clusterLoopback.bucket(bucketNameLoopback);
        bucketLoopback = bucketObjLoopback.defaultCollection();
        */
    }

    public void uploadFile(MultipartFile file) {
        try {
            String csvString = new String(file.getBytes(), StandardCharsets.UTF_8);
            String name = "File_Upload";
            processCSVData(csvString, name);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Failed to import file \"" + file.getOriginalFilename() + "\". Please check file format.");
        }
    }

    public void processCSVData(String csvString, String name) {
        try {
            var props = getCSVProperties();
            if (props == null) {
                throw new FileStorageException("Failed to read Metadata::Properties. Please check the database.");
            }
            var separator = (String) props.get("separator");
            if (separator == null) {
                throw new FileStorageException("Failed to read Metadata::Properties. Please check the database.");
            }
            if (separator.equals("|")) {
                separator = "\\|";
            }

            var headerColumnsMap = (JsonArray) props.get("headerColumns");
            var linesTypes = (JsonArray) props.get("linesTypes");
            var lines = csvString.split("\n");
            if (lines.length == 1) {
                lines = csvString.split("\r");
            }

            Boolean isFirstLine = true;
            var metaDoc = JsonObject.create();

            for (String line : lines) {
                String trimmedLine = line.trim();
                if (trimmedLine.length() > 0) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        // Process the first line
                        var origin = JsonObject.create();
                        var headerCols = trimmedLine.split(separator);
                        for (Integer i = 0; i < headerCols.length; i++) {
                            var headerCol = headerCols[i].trim();
                            var headerName = headerNameForColumnAtIndex(headerColumnsMap, i + 1);
                            if (headerName != null) {
                                origin.put(headerName, headerCol);
                            }
                        }
                        metaDoc.put("origin", origin);
                    } else {
                        var headerCols = trimmedLine.split(separator);
                        String type = null;
                        var columns = JsonArray.create();
                        var identifiers = JsonArray.create();
                        var jsonObject = JsonObject.create();
                        String documentId = null;
                        for (Integer i = 0; i < headerCols.length; i++) {
                            if (i == 0) {
                                type = headerCols[i];
                                if (type != null) {
                                    if (linesTypes != null){
                                        if (!linesTypes.contains(type)){
                                            break;
                                        }
                                    }
                                    metaDoc.put("docType", type);

                                    var metadataId = "Metadata::" + type;
                                    try {
                                        var metadata = bucket.get(metadataId);
                                        if (metadata != null) {
                                            columns = (JsonArray) metadata.contentAsObject().get("columns");
                                            identifiers = (JsonArray) metadata.contentAsObject().get("identifiers");
                                            if ((columns == null) || (identifiers == null)) {
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                // Find Metadata::<type>
                                if (columns != null) {
                                    var columnIn = headerNameForColumnAtIndex(columns, i + 1);
                                    if (columnIn != null) {
                                        jsonObject.put(columnIn, headerCols[i]);
                                    }
                                }
                            }
                        }

                        if (identifiers.size() > 0) {
                            documentId = type;
                            for (var id : identifiers) {
                                Integer idx = (Integer) id;
                                if ((idx != null) && (idx > 0) && (idx <= headerCols.length)) {
                                    documentId += "::";
                                    documentId += headerCols[idx - 1];
                                }
                            }
                        }
                        if (documentId != null) {
                            String createDate = null;
                            String createdBy = null;

                            try {
                                var current = bucket.get(documentId).contentAsObject();
                                if (current != null) {
                                    var currentMetaDoc = (JsonObject) current.get("metaDoc");
                                    if (currentMetaDoc != null) {
                                        createDate = (String)metaDoc.get("createDate");
                                        createdBy = (String)metaDoc.get("createdBy");
                                    }
                                }
                            }
                            catch (Exception e){
                                // Nothing
                            }

                            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
                            Date currentDate = new Date();

                            Boolean isUpdate = false;

                            if (createdBy == null){
                                metaDoc.put("createdBy", name);
                            }
                            else {
                                isUpdate = true;
                            }

                            if (createDate == null) {
                                metaDoc.put("createDate", dateFormatter.format(currentDate));
                            }
                            else {
                                isUpdate = true;
                            }

                            if (isUpdate) {
                                metaDoc.put("lastUpdateBy", name);
                                metaDoc.put("lastUpdateDate", dateFormatter.format(currentDate));
                            }


                            jsonObject.put("metaDoc", metaDoc);
                            bucket.upsert(documentId, jsonObject);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Failed to import file \"" + name + "\". Please check file format.");
        }
    }

    private String headerNameForColumnAtIndex(JsonArray cols, Integer index){
        for (var c : cols){
            var col = (JsonObject)c;
            if (col != null) {
                Integer colIdx = (Integer) col.get("order");
                if ((colIdx != null) && (colIdx == index)) {
                    return (String) col.get("columnOut");
                }
            }
        }
        return null;
    }

    private JsonObject getCSVProperties(){
        Map<String, String> result = new HashMap<>();

        var prop = bucket.get("Metadata::Properties");
        if (prop != null){
            return prop.contentAsObject();
        }
        return null;
    }

    public List<Map<String, Object>> monroeAPI(String path, String param1, String param2, String param3) {
        try {
            // Get API definition
            String apiId = "API::" + path;
            var apiDefine = bucket.get(apiId);
            if (apiDefine != null) {
                var content = apiDefine.contentAsObject();
                if (content != null) {
                    var query = (JsonObject)content.get("query");
                    if (query != null){
                        var N1QL = (String) query.get("N1QL");
                        var stringN1QL = N1QL;
                        var params = (JsonArray) query.get("parameters");
                        if ((params != null) && (params.size() > 0)){
                            var paramsList = new String[params.size()];
                            Integer idx = 0;
                            for (var p: params){
                                var pString = (String)p;
                                if (pString != null){
                                    var prefix = "%queryParameters[";
                                    if (pString.startsWith(prefix) && pString.endsWith("]")){
                                        var endIdx = pString.indexOf("]");
                                        if (endIdx > 0){
                                            var paramIdxString = pString.substring(prefix.length(), endIdx);
                                            if (paramIdxString.length() > 0){
                                                var paramIdx = Integer.parseInt(paramIdxString);
                                                if (paramIdx == 1){
                                                    paramsList[idx++] = param1;
                                                }
                                                else if (paramIdx == 2){
                                                    paramsList[idx++] = param2;
                                                }
                                                else if (paramIdx == 3){
                                                    paramsList[idx++] = param3;
                                                }
                                            }
                                        }
                                    }
                                    else if (pString.equals("%bucketName")){
                                        paramsList[idx++] = bucketName;
                                    }
                                    else {
                                        paramsList[idx++] = pString;
                                    }
                                }
                            }

                            if (idx > 0){
                                stringN1QL =  String.format(N1QL, paramsList);
                            }

                            QueryResult result = cluster.query(
                                    stringN1QL,
                                    QueryOptions.queryOptions().parameters(JsonArray.create())
                            );
                            // Print each found Row
                            var rows = result.rowsAsObject();
                            if (rows.size() > 0) {
                                List<Map<String, Object>> responseContent = new ArrayList<>();
                                for (JsonObject row : result.rowsAsObject()) {
                                    System.out.println(row);
                                    responseContent.add(row.toMap());
                                }

                                return responseContent;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<JsonObject> getLastUpdatedDocuments() {
        try {
            Long lastTime = 0L;
            List<String> linesTypes = new ArrayList<>();
            try {
                JsonObject loopbackInfo = bucket.get("LOOPBACK::info").contentAsObject();
                if (loopbackInfo != null) {
                    lastTime = loopbackInfo.getLong("lastImportTime");
                }

                JsonObject properties = bucket.get("Metadata::Properties").contentAsObject();
                if (properties != null) {
                    var linesTypesArray = properties.getArray("linesTypes");
                    if (linesTypesArray != null) {
                        for (var type : linesTypesArray) {
                            var typeString = (String) type;
                            if (typeString != null) {
                                linesTypes.add(typeString);
                            }
                        }
                    }
                }
            } catch (Exception e) {

            }

            List<JsonObject> targetRows = new ArrayList<>();
            if (linesTypes.size() > 0) {
                var parameters = JsonArray.create();
                parameters.add(lastTime * 1000000);

                QueryResult result = clusterLoopback.query(
                        String.format("SELECT meta(d).id, * FROM `%s` AS d WHERE META(d).cas > $1", bucketNameLoopback),
                        QueryOptions.queryOptions().parameters(parameters)
                );
                // Print each found Row
                var rows = result.rowsAsObject();

                // Update LOOPBACK::info
                var jsonObject = JsonObject.create();
                jsonObject.put("lastImportTime", System.currentTimeMillis());
                bucket.upsert("LOOPBACK::info", jsonObject);

                for (var row : rows) {
                    var id = row.getString("id");
                    if (id != null) {
                        var elements = id.split("::");
                        if (linesTypes.contains(elements[0])){
                            targetRows.add(row);
                        }
                    }
                }
            }

            return targetRows;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void upsertLoopbackDocument(JsonObject doc, String id){
        var metaDoc = JsonObject.create();
        try {
            var current = bucket.get(id).contentAsObject();
            if (current != null) {
                var currentMetaDoc = (JsonObject) current.get("metaDoc");
                if (currentMetaDoc != null) {
                    metaDoc = currentMetaDoc;
                }
            }else {
            	var currentMetaDoc = (JsonObject) doc.get("metaDoc");
                if (currentMetaDoc != null) {
                    metaDoc = currentMetaDoc;
                }
            	
            }
        }
        catch (Exception e){
            // Nothing
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
        Date currentDate = new Date();

        Boolean isUpdate = false;

        if (metaDoc.get("createdBy") == null){
            metaDoc.put("createdBy", "Evt_Kafka");
        }
        else {
            isUpdate = true;
        }
        if (metaDoc.get("createDate") == null) {
            metaDoc.put("createDate", dateFormatter.format(currentDate));
        }
        else {
            isUpdate = true;
        }

        if (isUpdate) {
            metaDoc.put("lastUpdateBy", "Evt_Kafka");
            metaDoc.put("lastUpdateDate", dateFormatter.format(currentDate));
        }

        doc.put("metaDoc", metaDoc);

        bucket.upsert(id, doc);
    }
}
