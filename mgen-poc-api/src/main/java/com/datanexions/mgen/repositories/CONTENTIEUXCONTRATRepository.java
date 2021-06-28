package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.internal.CONTENTIEUXCONTRAT;
import com.datanexions.mgen.models.contrat.internal.USAGECOTISATION;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.List;

public interface CONTENTIEUXCONTRATRepository extends CouchbaseRepository<CONTENTIEUXCONTRAT, String> {
    @Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"CONTENTIEUXCONTRAT\" AND idCtr=$1")
    List<CONTENTIEUXCONTRAT> findItemsByContratId(String contrat_id);
}
