package com.datanexions.mgen.controllers;

import com.couchbase.client.java.json.JsonObject;
import com.datanexions.mgen.ContratsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Controller
@Api(value = "contrats", description = "the contrats API")
public class ContratsApiController {
    @Autowired
    ContratsService contratsService;

    /*
    @GetMapping("/{path}")
    public ResponseEntity<?> contratsAPI0Param(@PathVariable String path) throws Exception {
        var contract = contratsService.contratsAPI(path, null, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @GetMapping("/{path}/{id}")
    public ResponseEntity<?> monroeAPI1Param(@PathVariable String path, @PathVariable String id) throws Exception {
        var contract = contratsService.contratsAPI(path + "/{id-contrat}", id, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }
    */

    @ApiOperation(value = "R\u00e9cup\u00e8re une collection de contrats", produces = "application/json")
    @GetMapping("/contrats")
    public ResponseEntity<?> monroeAPIContrats() throws Exception {
        var contract = contratsService.contratsAPI("contrats", null, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @ApiOperation(value = "D\u00e9tail partiel d'un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}")
    public ResponseEntity<?> monroeAPIContrat(@PathVariable String id_contrat) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id-contrat}", id_contrat, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @ApiOperation(value = "D\u00e9tail complet d'un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}/full")
    public ResponseEntity<?> monroeAPIContratFull(@PathVariable String id_contrat) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id-contrat}/full", id_contrat, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @GetMapping("/contrats/{id_contrat}/domiciliations-bancaires")
    public ResponseEntity<?> monroeAPIContratsDomiciliationsBancaires(@PathVariable String id_contrat) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id-contrat}/domiciliations-bancaires", id_contrat, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @ApiOperation(value = "Nombre de domiciliations bancaires associ\u00e9es \u00e0 un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}/domiciliations-bancaires/count")
    public ResponseEntity<?> monroeAPIContratsDomiciliationsBancairesCount(@PathVariable String id_contrat) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id-contrat}/domiciliations-bancaires/count", id_contrat, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @ApiOperation(value = "Informations d\u00e9taill\u00e9es d'un dossier contentieux d'un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}/domiciliations-bancaires/{index_domiciliation_bancaire}")
    public ResponseEntity<?> monroeAPIContratsDomiciliationsBancairesAtIndex(@PathVariable String id_contrat, @PathVariable String index_domiciliation_bancaire) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id_contrat}/domiciliations-bancaires/{index_domiciliation_bancaire}", id_contrat, index_domiciliation_bancaire, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @ApiOperation(value = "Informations de dossiers contententieux d'un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}/dossiers-contentieux")
    public ResponseEntity<?> monroeAPIContratsDossiersContentieux(@PathVariable String id_contrat) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id-contrat}/dossiers-contentieux", id_contrat, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @ApiOperation(value = "Nombre de dossiers contentieux associ\u00e9es \u00e0 un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}/dossiers-contentieux/count")
    public ResponseEntity<?> monroeAPIContratsDossiersContentieuxCount(@PathVariable String id_contrat) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id-contrat}/dossiers-contentieux/count", id_contrat, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @ApiOperation(value = "Informations d\u00e9taill\u00e9es d'un dossier contentieux d'un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}/dossiers-contentieux/{index_dossier_contentieux}")
    public ResponseEntity<?> monroeAPIContratsDossiersContentieuxAtIndex(@PathVariable String id_contrat, @PathVariable String index_dossier_contentieux) throws Exception {
        var contract = contratsService.contratsAPI("contrats/{id-contrat}/dossiers-contentieux/{index-dossier-contentieux}", id_contrat, index_dossier_contentieux, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

}
