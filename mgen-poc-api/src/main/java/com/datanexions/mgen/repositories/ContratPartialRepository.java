package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.ContratElement;
import com.datanexions.mgen.models.contrat.ContratPartial;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContratPartialRepository extends CouchbaseRepository<ContratPartial, String> {
    @Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"CONTRATINDIVSANTE\" AND idCtr=$1")
    Optional<ContratPartial> findById(String id);
}
