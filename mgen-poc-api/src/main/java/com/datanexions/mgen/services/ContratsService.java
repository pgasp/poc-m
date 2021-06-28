package com.datanexions.mgen.services;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;
import com.datanexions.mgen.models.contrat.DomiciliationBancaire;
import com.datanexions.mgen.models.contrat.DossierContentieux;
import com.datanexions.mgen.repositories.*;

import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class ContratsService {
    @Autowired
    ContratElementRepository contratElementRepository;
    @Autowired
    ContratPartialRepository contratPartialRepository;
    @Autowired
    ContratStatutRepository contratStatutRepository;
    @Autowired
    USAGECOTISATIONRepository usageCOTISATIONRepository;
    @Autowired
    DomiciliationBancaireRepository domiciliationBancaireRepository;
    @Autowired
    CONTENTIEUXCONTRATRepository contentieuxcontratRepository;
    @Autowired
    DossierContentieuxRepository dossierContentieuxRepository;
    @Autowired
    PhaseRecouvrementRepository phaseRecouvrementRepository;
    @Autowired
    ContratRepository contratRepository;

    public ContratsService() {
    }

    public ResponseEntity contrats() {
        try {
            var contrats = contratElementRepository.findAll();
            return new ResponseEntity<>(contrats, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity contratById(String id_contrat) {
        try {
            var contrat = contratPartialRepository.findById(id_contrat).orElse(null);
            if (contrat != null) {
                // Find status
                var statuts = contratStatutRepository.findStatusByContratId(id_contrat);
                if (statuts != null) {
                    contrat.setStatuts(statuts);
                }
            }
            return new ResponseEntity<>(contrat, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity fullContratById(String id_contrat) {
        try {
            var contrat = contratRepository.findById(id_contrat).orElse(null);
            if (contrat != null) {
                // Find status
                var statuts = contratStatutRepository.findStatusByContratId(id_contrat);
                if (statuts != null) {
                    contrat.setStatuts(statuts);
                }
                
                List<DomiciliationBancaire> domBancaires=  domiciliationBancaireRepository.findByContrat(id_contrat);
                contrat.setDomiciliationsBancaires(domBancaires);

                // DossierContentieux
                List <DossierContentieux> dossierContentieuxes = new ArrayList<>();
                var contentieuxcontrats = contentieuxcontratRepository.findItemsByContratId(id_contrat);
                for (var contentieuxcontrat: contentieuxcontrats){
                    var item = dossierContentieuxRepository.findByNumdoscontgft(contentieuxcontrat.getNumdoscontgft()).orElse(null);
                    if (item != null){
                        var phases = phaseRecouvrementRepository.findItemsByNumdoscontgft(contentieuxcontrat.getNumdoscontgft());
                        item.setPhasesRecouvrement(phases);
                        dossierContentieuxes.add(item);
                    }
                }
                contrat.setDossiersContentieux(dossierContentieuxes);
            }
            return new ResponseEntity<>(contrat, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity domiciliationBancairesByContratId(String id_contrat) {
        try {
        	 List<DomiciliationBancaire> domiciliationBancaires= domiciliationBancaireRepository.findByContrat(id_contrat);

            return new ResponseEntity<>(domiciliationBancaires, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity domiciliationBancairesCountByContratId(String id_contrat) {
        try {
        	List<DomiciliationBancaire> domiciliationBancaires= domiciliationBancaireRepository.findByContrat(id_contrat);
            return new ResponseEntity<>(domiciliationBancaires.size(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity domiciliationBancaireDetailByContratId(String id_contrat, String index_domiciliation_bancaire) {
        try {
            var index = Integer.parseInt(index_domiciliation_bancaire);
            List<DomiciliationBancaire> domBancaires= domiciliationBancaireRepository.findByContrat(id_contrat);
            DomiciliationBancaire domiciliationBancaire=null;
            if(domBancaires!=null && domBancaires.size()<= index) {
            	domiciliationBancaire=domBancaires.get(index);
            	return new ResponseEntity<>(domiciliationBancaire, HttpStatus.OK);
            }else
            	return new ResponseEntity<>("Index to large", HttpStatus.OK);

            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity dossiersContentieuxsByContratId(String id_contrat) {
        try {
            List <DossierContentieux> list = new ArrayList<>();
            var contentieuxcontrats = contentieuxcontratRepository.findItemsByContratId(id_contrat);
            for (var contentieuxcontrat: contentieuxcontrats){
                var item = dossierContentieuxRepository.findByNumdoscontgft(contentieuxcontrat.getNumdoscontgft()).orElse(null);
                if (item != null){
                    var phases = phaseRecouvrementRepository.findItemsByNumdoscontgft(contentieuxcontrat.getNumdoscontgft());
                    item.setPhasesRecouvrement(phases);
                    list.add(item);
                }
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity dossiersContentieuxsCountByContratId(String id_contrat) {
        try {
            Integer count = 0;
            var contentieuxcontrats = contentieuxcontratRepository.findItemsByContratId(id_contrat);
            for (var contentieuxcontrat: contentieuxcontrats){
                var item = dossierContentieuxRepository.findByNumdoscontgft(contentieuxcontrat.getNumdoscontgft()).orElse(null);
                if (item != null){
                    count += 1;
                }
            }

            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity dossiersContentieuxDetailByContratId(String id_contrat, String index_dossier_contentieux) {
        try {
            var index = Integer.parseInt(index_dossier_contentieux);
            Integer currentIndex = 0;
            DossierContentieux target = null;
            var contentieuxcontrats = contentieuxcontratRepository.findItemsByContratId(id_contrat);
            for (var contentieuxcontrat: contentieuxcontrats){
                var item = dossierContentieuxRepository.findByNumdoscontgft(contentieuxcontrat.getNumdoscontgft()).orElse(null);
                if (item != null){
                    if (currentIndex == index) {
                        var phases = phaseRecouvrementRepository.findItemsByNumdoscontgft(contentieuxcontrat.getNumdoscontgft());
                        item.setPhasesRecouvrement(phases);
                        target = item;
                        break;
                    }

                    currentIndex += 1;
                }
            }

            return new ResponseEntity<>(target, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
