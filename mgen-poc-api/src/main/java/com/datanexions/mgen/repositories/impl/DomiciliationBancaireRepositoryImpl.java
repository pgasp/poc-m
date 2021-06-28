package com.datanexions.mgen.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryScanConsistency;
import com.datanexions.mgen.models.contrat.DomiciliationBancaire;
import com.datanexions.mgen.repositories.DomiciliationBancaireRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class DomiciliationBancaireRepositoryImpl implements DomiciliationBancaireRepository {
	@Autowired
	private CouchbaseOperations couchbaseOperations;
	@Value("${couchbase.bucketName}")
	private String bucketName;

	@Override
	public List<DomiciliationBancaire> findByContrat(String id) {

		String query = "SELECT dmB.cdTypDom codeTypeDomiciliation,\n" + "       dmB.typPerPorteur,\n" + "       dmB.idPerPorteur identifiantPersonnePorteur,\n"
				+ "       dmB.cdBq as codeBanque,\n" + "       dmB.cdGuichet codeGuichet,\n" + "       dmB.noCptBq numeroCompteBanquaire,\n" + "       dmB.cleRib,\n"
				+ "       dmB.iban,\n" + "       dmB.tituCpt titulaireCompte,\n" + "       dmB.libBq libelleBanque,\n" + "       dmB.dtDebValDomBq dateDebutValidite,\n"
				+ "       dmB.dtFinValDomBq dateFinValidite,\n" + "       dmB.dtRecod dateRecodification,\n" + "       dmB.cdEtaDom codeEtat,\n"
				+ "       dmB.topBqRef topBanqueReferencee,\n" + "       dmB.idDomBq\n" + "FROM `" + bucketName + "` AS contrat\n"
				+ "UNNEST contrat.domBank AS domBankCtr\n" + "    JOIN `" + bucketName
				+ "` AS dmB ON domBankCtr.idDomBq=dmB.idDomBq\n"
				+ "WHERE contrat.metaDoc.docType=\"CONTRATINDIVSANTE\"\n"
				+ "    AND dmB.metaDoc.docType=\"DOMICILIATIONBANCAIRE\"\n" + "    AND contrat.idCtr=\"" + id + "\"";

		QueryOptions options = QueryOptions.queryOptions().scanConsistency(QueryScanConsistency.NOT_BOUNDED)
				.adhoc(false);

		return couchbaseOperations.getCouchbaseClientFactory().getCluster().query(query, options)
				.rowsAs(DomiciliationBancaire.class);

	}

}
