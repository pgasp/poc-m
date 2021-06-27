package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.ContratElement;
import com.datanexions.mgen.models.contrat.Statut;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContratStatutRepository extends CouchbaseRepository<Statut, String> {
    @Query("#{#n1ql.selectEntity} WHERE metaDoc.docType=\"CONTRATHISTO\" AND idCtr=$1")
    List<Statut> findStatusByContratId(String contrat_id);
}
