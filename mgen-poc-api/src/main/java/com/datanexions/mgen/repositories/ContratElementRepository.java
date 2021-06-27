package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.ContratElement;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContratElementRepository extends CouchbaseRepository<ContratElement, String> {
    @Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"CONTRATINDIVSANTE\"")
    List<ContratElement> findAll();

    //@Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"CONTRATINDIVSANTE\" AND idCtr=$1")
    //Optional<ContratElement> findById(String id);
}
