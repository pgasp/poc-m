package com.datanexions.mgen;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ContratsService {
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

    public ContratsService(){
    }

    public List<Map<String, Object>> contratsAPI(String path, String param1, String param2, String param3) {
        try {
            // Get API definition
            String apiId = "Metadata::Properties";
            var apiDefine = bucket.get(apiId);
            if (apiDefine != null) {
                var content = apiDefine.contentAsObject();
                if (content != null) {
                    // Get API section
                    var apis = (JsonArray)content.get("API");
                    if (apis != null) {
                        // Find API for "path"
                        JsonObject targetAPI = null;
                        for (var api: apis) {
                            var apiObj = (JsonObject)api;
                            if (apiObj != null) {
                                var apiName = (String) apiObj.get("queryName");
                                if (apiName.equals(path)){
                                    var apiDocId = (String) apiObj.get("api");
                                    if (apiDocId  != null){
                                        targetAPI = bucket.get(apiDocId).contentAsObject();
                                    }
                                    break;
                                }
                            }
                        }

                        if (targetAPI != null) {
                            var query = (JsonObject) targetAPI.get("query");
                            if (query != null) {
                                var N1QL = (String) query.get("N1QL");
                                var stringN1QL = N1QL;
                                var params = (JsonArray) query.get("parameters");
                                if ((params != null) && (params.size() > 0)) {
                                    var paramsList = new String[params.size()];
                                    Integer idx = 0;
                                    for (var p : params) {
                                        var pString = (String) p;
                                        if (pString != null) {
                                            var prefix = "%queryParameters[";
                                            if (pString.startsWith(prefix) && pString.endsWith("]")) {
                                                var endIdx = pString.indexOf("]");
                                                if (endIdx > 0) {
                                                    var paramIdxString = pString.substring(prefix.length(), endIdx);
                                                    if (paramIdxString.length() > 0) {
                                                        var paramIdx = Integer.parseInt(paramIdxString);
                                                        if (paramIdx == 1) {
                                                            paramsList[idx++] = param1;
                                                        } else if (paramIdx == 2) {
                                                            paramsList[idx++] = param2;
                                                        } else if (paramIdx == 3) {
                                                            paramsList[idx++] = param3;
                                                        }
                                                    }
                                                }
                                            } else if (pString.equals("%bucketName")) {
                                                paramsList[idx++] = bucketName;
                                            } else {
                                                paramsList[idx++] = pString;
                                            }
                                        }
                                    }

                                    if (idx > 0) {
                                        stringN1QL = String.format(N1QL, paramsList);
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
