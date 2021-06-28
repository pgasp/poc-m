package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.Statut;
import com.datanexions.mgen.models.contrat.internal.USAGECOTISATION;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.List;

public interface USAGECOTISATIONRepository extends CouchbaseRepository<USAGECOTISATION, String> {
    @Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"USAGECOTISATION\" AND NOCTR=$1")
    List<USAGECOTISATION> findItemsByContratId(String contrat_id);
}
