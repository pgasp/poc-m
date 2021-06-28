package com.datanexions.mgen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.datanexions.mgen.models.contrat.ContratElement;
import com.datanexions.mgen.services.ContratsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ExampleProperty;

@Controller
@Api(value = "contrats", description = "the contrats API")
public class ContratsApiController {
   

    @Autowired
    ContratsService contratsService;

    // Expected response
    /*
    [{"identifiant" : "012345",
        "dateDebut" : "2011-10-05T14:48:00.000Z",
        "dateFin" : "2011-10-05T14:48:00.000Z",
        "codeNature" : "XYZ"}
    ]
    */
    @ApiOperation(value = "R\u00e9cup\u00e8re une collection de contrats", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            response = ContratElement.class,
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "[\n" +
                                            "    {\n" +
                                            "        \"identifiant\": \"012345\",\n" +
                                            "        \"dateDebut\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "        \"dateFin\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "        \"codeNature\": \"XYZ\"\n" +
                                            "    }\n" +
                                            "]", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats")
    public ResponseEntity<?> contrats() throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats", null, null, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.contrats();
    }


    // Expected response
    /*
    {"identifiant" : "012345",
        "dateDebut" : "2011-10-05T14:48:00.000Z",
        "dateFin" : "2011-10-05T14:48:00.000Z",
        "codeNature" : "XYZ",
        "statuts": [{
            "code": "123",
            "dateDebutEffet": "2011-10-05T14:48:00.000Z",
            "dateFinEffet": "2011-10-05T14:48:00.000Z",
            "codeMotif": "ABC",
            "codePrecisionMotif": "DEF",
            "precisionMotifStatutAutre": "MNO"
        }]
    }
    */
    @ApiOperation(value = "D\u00e9tail partiel d'un contrat", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "{\n" +
                                            "    \"identifiant\": \"012345\",\n" +
                                            "    \"dateDebut\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"dateFin\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"codeNature\": \"XYZ\",\n" +
                                            "    \"statuts\": [\n" +
                                            "        {\n" +
                                            "            \"code\": \"123\",\n" +
                                            "            \"dateDebutEffet\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"dateFinEffet\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"codeMotif\": \"ABC\",\n" +
                                            "            \"codePrecisionMotif\": \"DEF\",\n" +
                                            "            \"precisionMotifStatutAutre\": \"MNO\"\n" +
                                            "        }\n" +
                                            "    ]\n" +
                                            "}", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats/{id_contrat}")
    public ResponseEntity<?> getContrat(@PathVariable String id_contrat) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id-contrat}", id_contrat, null, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.contratById(id_contrat);

    }

    // Expected response
    /*
    {"identifiant" : "012345",
        "dateDebut" : "2011-10-05T14:48:00.000Z",
        "dateFin" : "2011-10-05T14:48:00.000Z",
        "codeNature" : "XYZ",
        "dossiersContentieux": [{
            "codeNature": "CNT",
            "dateCreation":"2011-10-05T14:48:00.000Z",
            "dateCreationDossierGft":"2011-10-05T14:48:00.000Z",
            "phasesRecouvrement": [
                {
                "code": "ABC",
                "codeStatutMouvement": "DEF",
                "codeMotif": "HGJ",
                "dateCreation": "2011-10-05T14:48:00.000Z",
                "dateDebutEffet": "2011-10-05T14:48:00.000Z",
                "dateFinEffet": "2011-10-05T14:48:00.000Z"
                }
                ]
            }
            ],
        "domiciliationsBancaires": [{
            "typePersonnePorteur": "TYPE",
            "identifiantPersonnePorteur": "ID",
            "codeTypeDomiciliation": "CODE",
            "codeBanque": "CODEB",
            "codeGuichet": "CODEG",
            "numeroCompteBanquaire": "NUM",
            "cleRib": "CLE",
            "iban": "IBAN",
             "titulaireCompte": "COMP",
             "libelleBanque": "BANQ",
             "dateDebutValidite": "2011-10-05T14:48:00.000Z",
             "dateFinValidite": "2011-10-05T14:48:00.000Z",
             "dateRecodification": "2011-10-05T14:48:00.000Z",
             "codeEtat": "CODE",
             "topBanqueReferencee": true
            }],
        "statuts": [{
            "code": "123",
            "dateDebutEffet": "2011-10-05",
            "dateFinEffet": "2011-10-05",
            "codeMotif": "ABC",
            "codePrecisionMotif": "DEF",
            "precisionMotifStatutAutre": "MNO"
        }]
    }
    */
    @ApiOperation(value = "D\u00e9tail complet d'un contrat", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "{\n" +
                                            "    \"identifiant\": \"012345\",\n" +
                                            "    \"dateDebut\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"dateFin\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"codeNature\": \"XYZ\",\n" +
                                            "    \"dossiersContentieux\": [\n" +
                                            "        {\n" +
                                            "            \"codeNature\": \"CNT\",\n" +
                                            "            \"dateCreation\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"dateCreationDossierGft\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"phasesRecouvrement\": [\n" +
                                            "                {\n" +
                                            "                    \"code\": \"ABC\",\n" +
                                            "                    \"codeStatutMouvement\": \"DEF\",\n" +
                                            "                    \"codeMotif\": \"HGJ\",\n" +
                                            "                    \"dateCreation\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "                    \"dateDebutEffet\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "                    \"dateFinEffet\": \"2011-10-05T14:48:00.000Z\"\n" +
                                            "                }\n" +
                                            "            ]\n" +
                                            "        }\n" +
                                            "    ],\n" +
                                            "    \"domiciliationsBancaires\": [\n" +
                                            "        {\n" +
                                            "            \"typePersonnePorteur\": \"TYPE\",\n" +
                                            "            \"identifiantPersonnePorteur\": \"ID\",\n" +
                                            "            \"codeTypeDomiciliation\": \"CODE\",\n" +
                                            "            \"codeBanque\": \"CODEB\",\n" +
                                            "            \"codeGuichet\": \"CODEG\",\n" +
                                            "            \"numeroCompteBanquaire\": \"NUM\",\n" +
                                            "            \"cleRib\": \"CLE\",\n" +
                                            "            \"iban\": \"IBAN\",\n" +
                                            "            \"titulaireCompte\": \"COMP\",\n" +
                                            "            \"libelleBanque\": \"BANQ\",\n" +
                                            "            \"dateDebutValidite\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"dateFinValidite\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"dateRecodification\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"codeEtat\": \"CODE\",\n" +
                                            "            \"topBanqueReferencee\": true\n" +
                                            "        }\n" +
                                            "    ],\n" +
                                            "    \"statuts\": [\n" +
                                            "        {\n" +
                                            "            \"code\": \"123\",\n" +
                                            "            \"dateDebutEffet\": \"2011-10-05\",\n" +
                                            "            \"dateFinEffet\": \"2011-10-05\",\n" +
                                            "            \"codeMotif\": \"ABC\",\n" +
                                            "            \"codePrecisionMotif\": \"DEF\",\n" +
                                            "            \"precisionMotifStatutAutre\": \"MNO\"\n" +
                                            "        }\n" +
                                            "    ]\n" +
                                            "}", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats/{id_contrat}/full")
    public ResponseEntity<?> getContratFull(@PathVariable String id_contrat) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id-contrat}/full", id_contrat, null, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.fullContratById(id_contrat);
    }


    // Expected response
    /*
    [{
            "typePersonnePorteur": "TYPE",
            "identifiantPersonnePorteur": "ID",
            "codeTypeDomiciliation": "CODE",
            "codeBanque": "CODEB",
            "codeGuichet": "CODEG",
            "numeroCompteBanquaire": "NUM",
            "cleRib": "CLE",
            "iban": "IBAN",
             "titulaireCompte": "COMP",
             "libelleBanque": "BANQ",
             "dateDebutValidite": "2011-10-05T14:48:00.000Z",
             "dateFinValidite": "2011-10-05T14:48:00.000Z",
             "dateRecodification": "2011-10-05T14:48:00.000Z",
             "codeEtat": "CODE",
             "topBanqueReferencee": true
    }]
    */
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "[\n" +
                                            "    {\n" +
                                            "        \"typePersonnePorteur\": \"TYPE\",\n" +
                                            "        \"identifiantPersonnePorteur\": \"ID\",\n" +
                                            "        \"codeTypeDomiciliation\": \"CODE\",\n" +
                                            "        \"codeBanque\": \"CODEB\",\n" +
                                            "        \"codeGuichet\": \"CODEG\",\n" +
                                            "        \"numeroCompteBanquaire\": \"NUM\",\n" +
                                            "        \"cleRib\": \"CLE\",\n" +
                                            "        \"iban\": \"IBAN\",\n" +
                                            "        \"titulaireCompte\": \"COMP\",\n" +
                                            "        \"libelleBanque\": \"BANQ\",\n" +
                                            "        \"dateDebutValidite\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "        \"dateFinValidite\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "        \"dateRecodification\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "        \"codeEtat\": \"CODE\",\n" +
                                            "        \"topBanqueReferencee\": true\n" +
                                            "    }\n" +
                                            "]", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @ApiOperation(value = "Informations de domiciliations bancaires d'un contrat", produces = "application/json")
    @GetMapping("/contrats/{id_contrat}/domiciliations-bancaires")
    public ResponseEntity<?> getContratDomiciliationsBancaires(@PathVariable String id_contrat) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id-contrat}/domiciliations-bancaires", id_contrat, null, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.domiciliationBancairesByContratId(id_contrat);
    }

    // Expected response
    /*
    10
     */
    @ApiOperation(value = "Nombre de domiciliations bancaires associ\u00e9es \u00e0 un contrat", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "10", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats/{id_contrat}/domiciliations-bancaires/count")
    public ResponseEntity<?> getContratsDomiciliationsBancairesCount(@PathVariable String id_contrat) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id-contrat}/domiciliations-bancaires/count", id_contrat, null, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.domiciliationBancairesCountByContratId(id_contrat);
    }

    // Expected response
    /*
    {
            "typePersonnePorteur": "TYPE",
            "identifiantPersonnePorteur": "ID",
            "codeTypeDomiciliation": "CODE",
            "codeBanque": "CODEB",
            "codeGuichet": "CODEG",
            "numeroCompteBanquaire": "NUM",
            "cleRib": "CLE",
            "iban": "IBAN",
             "titulaireCompte": "COMP",
             "libelleBanque": "BANQ",
             "dateDebutValidite": "2011-10-05T14:48:00.000Z",
             "dateFinValidite": "2011-10-05T14:48:00.000Z",
             "dateRecodification": "2011-10-05T14:48:00.000Z",
             "codeEtat": "CODE",
             "topBanqueReferencee": true
    }
    */
    @ApiOperation(value = "Informations d\u00e9taill\u00e9es d'un dossier contentieux d'un contrat", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "{\n" +
                                            "    \"typePersonnePorteur\": \"TYPE\",\n" +
                                            "    \"identifiantPersonnePorteur\": \"ID\",\n" +
                                            "    \"codeTypeDomiciliation\": \"CODE\",\n" +
                                            "    \"codeBanque\": \"CODEB\",\n" +
                                            "    \"codeGuichet\": \"CODEG\",\n" +
                                            "    \"numeroCompteBanquaire\": \"NUM\",\n" +
                                            "    \"cleRib\": \"CLE\",\n" +
                                            "    \"iban\": \"IBAN\",\n" +
                                            "    \"titulaireCompte\": \"COMP\",\n" +
                                            "    \"libelleBanque\": \"BANQ\",\n" +
                                            "    \"dateDebutValidite\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"dateFinValidite\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"dateRecodification\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"codeEtat\": \"CODE\",\n" +
                                            "    \"topBanqueReferencee\": true\n" +
                                            "}", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats/{id_contrat}/domiciliations-bancaires/{index_domiciliation_bancaire}")
    public ResponseEntity<?> getContratDomiciliationBancaireDetail(@PathVariable String id_contrat, @PathVariable String index_domiciliation_bancaire) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id_contrat}/domiciliations-bancaires/{index_domiciliation_bancaire}", id_contrat, index_domiciliation_bancaire, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.domiciliationBancaireDetailByContratId(id_contrat, index_domiciliation_bancaire);
    }

    // Expected response
    /*
    [{
            "codeNature": "CNT",
            "dateCreation":"2011-10-05T14:48:00.000Z",
            "dateCreationDossierGft":"2011-10-05T14:48:00.000Z",
            "phasesRecouvrement": [
                {
                "code": "ABC",
                "codeStatutMouvement": "DEF",
                "codeMotif": "HGJ",
                "dateCreation": "2011-10-05T14:48:00.000Z",
                "dateDebutEffet": "2011-10-05T14:48:00.000Z",
                "dateFinEffet": "2011-10-05T14:48:00.000Z"
                }
                ]
            }
     ]
    */
    @ApiOperation(value = "Informations de dossiers contententieux d'un contrat", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "[\n" +
                                            "    {\n" +
                                            "        \"codeNature\": \"CNT\",\n" +
                                            "        \"dateCreation\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "        \"dateCreationDossierGft\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "        \"phasesRecouvrement\": [\n" +
                                            "            {\n" +
                                            "                \"code\": \"ABC\",\n" +
                                            "                \"codeStatutMouvement\": \"DEF\",\n" +
                                            "                \"codeMotif\": \"HGJ\",\n" +
                                            "                \"dateCreation\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "                \"dateDebutEffet\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "                \"dateFinEffet\": \"2011-10-05T14:48:00.000Z\"\n" +
                                            "            }\n" +
                                            "        ]\n" +
                                            "    }\n" +
                                            "]", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats/{id_contrat}/dossiers-contentieux")
    public ResponseEntity<?> getContratDossiersContentieux(@PathVariable String id_contrat) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id-contrat}/dossiers-contentieux", id_contrat, null, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.dossiersContentieuxsByContratId(id_contrat);
    }

    // Expected response
    /*
    10
     */
    @ApiOperation(value = "Nombre de dossiers contentieux associ\u00e9es \u00e0 un contrat", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "10", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats/{id_contrat}/dossiers-contentieux/count")
    public ResponseEntity<?> getContratsDossiersContentieuxCount(@PathVariable String id_contrat) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id-contrat}/dossiers-contentieux/count", id_contrat, null, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.dossiersContentieuxsCountByContratId(id_contrat);
    }

    // Expected response
    /*
    {
            "codeNature": "CNT",
            "dateCreation":"2011-10-05T14:48:00.000Z",
            "dateCreationDossierGft":"2011-10-05T14:48:00.000Z",
            "phasesRecouvrement": [
                {
                "code": "ABC",
                "codeStatutMouvement": "DEF",
                "codeMotif": "HGJ",
                "dateCreation": "2011-10-05T14:48:00.000Z",
                "dateDebutEffet": "2011-10-05T14:48:00.000Z",
                "dateFinEffet": "2011-10-05T14:48:00.000Z"
                }
                ]
    }
    */
    @ApiOperation(value = "Informations d\u00e9taill\u00e9es d'un dossier contentieux d'un contrat", produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voici la liste des contrats correspondant \u00e0 la recherche.",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value =
                                    "{\n" +
                                            "    \"codeNature\": \"CNT\",\n" +
                                            "    \"dateCreation\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"dateCreationDossierGft\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "    \"phasesRecouvrement\": [\n" +
                                            "        {\n" +
                                            "            \"code\": \"ABC\",\n" +
                                            "            \"codeStatutMouvement\": \"DEF\",\n" +
                                            "            \"codeMotif\": \"HGJ\",\n" +
                                            "            \"dateCreation\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"dateDebutEffet\": \"2011-10-05T14:48:00.000Z\",\n" +
                                            "            \"dateFinEffet\": \"2011-10-05T14:48:00.000Z\"\n" +
                                            "        }\n" +
                                            "    ]\n" +
                                            "}", mediaType = "application/json")
                    }),
            responseContainer = "List") })
    @GetMapping("/contrats/{id_contrat}/dossiers-contentieux/{index_dossier_contentieux}")
    public ResponseEntity<?> getContratDossierContentieuxDetail(@PathVariable String id_contrat, @PathVariable String index_dossier_contentieux) throws Exception {
        //var contract = contratsGenericService.contratsAPI("contrats/{id-contrat}/dossiers-contentieux/{index-dossier-contentieux}", id_contrat, index_dossier_contentieux, null);
        //return new ResponseEntity<>(contract, HttpStatus.OK);
        return contratsService.dossiersContentieuxDetailByContratId(id_contrat, index_dossier_contentieux);
    }

}
