package com.datanexions.mgen.repositories.impl;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.kv.GetResult;
import com.datanexions.mgen.models.contrat.Contrat;
import com.datanexions.mgen.models.contrat.DomiciliationBancaire;
import com.datanexions.mgen.repositories.ContratRepository;
import reactor.core.publisher.Flux;

@Component
public class ContratRepositoryImpl implements ContratRepository {

	@Autowired
	private CouchbaseOperations couchbaseOperations;
	private final String TYPE = "CONTRATINDIVSANTE::";
	private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyymmdd");

	@Override
	public Optional<Contrat> findById(String id) {

		var key = TYPE + id;
		GetResult result = couchbaseOperations.getCouchbaseClientFactory().getDefaultCollection().get(key);
		JsonObject obj = result.contentAsObject();
		Contrat contrat = new Contrat();
		contrat.setCodeNature(obj.getString("cdNatCtr"));
		contrat.setIdentifiant(obj.getString("idCtr"));
		contrat.setDateDebut(obj.getString("dtDebCtr"));
		contrat.setDateFin(obj.getString("dtFinCtr"));
		

		return Optional.of(contrat);
	}

}
