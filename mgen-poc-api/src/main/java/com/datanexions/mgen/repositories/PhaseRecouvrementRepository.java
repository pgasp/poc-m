package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.DossierContentieux;
import com.datanexions.mgen.models.contrat.PhaseRecouvrement;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhaseRecouvrementRepository extends CouchbaseRepository<PhaseRecouvrement, String> {
    @Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"PHASERECOUVCX\" AND numdoscontgft=$1")
    List<PhaseRecouvrement> findItemsByNumdoscontgft(String id);
}
