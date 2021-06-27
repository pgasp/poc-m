package com.datanexions.mgen.repositories;

import com.datanexions.mgen.models.contrat.ContratPartial;
import com.datanexions.mgen.models.contrat.DomiciliationBancaire;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DomiciliationBancaireRepository  {
   
	List<DomiciliationBancaire>  findByContrat(String id);
}
