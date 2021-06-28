package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.DomiciliationBancaire;
import com.datanexions.mgen.models.contrat.DossierContentieux;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.Optional;

public interface DossierContentieuxRepository extends CouchbaseRepository<DossierContentieux, String> {
    @Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"DOSSIERCONTENTIEUX\" AND numdoscontgft=$1")
    Optional<DossierContentieux> findByNumdoscontgft(String id);
}
