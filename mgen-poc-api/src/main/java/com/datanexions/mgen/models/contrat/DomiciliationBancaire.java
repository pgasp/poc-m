// 
// Decompiled by Procyon v0.5.36
// 

package com.datanexions.mgen.models.contrat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.util.Objects;

@ApiModel(description = "Un contrat")
@Document
public class DomiciliationBancaire
{
    @JsonProperty("typePersonnePorteur")
    private String typPerPorteur="PP";
    @JsonProperty("identifiantPersonnePorteur")
    private String idPerPorteur;
    @JsonProperty("codeTypeDomiciliation")
    private String cdTypDom;
    @JsonProperty("codeBanque")
    private String cdBq;
    @JsonProperty("codeGuichet")
    private String cdGuichet;
    @JsonProperty("numeroCompteBanquaire")
    private String noCptBq;
    @JsonProperty("cleRib")
    private String cleRib;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("titulaireCompte")
    private String tituCpt;
    @JsonProperty("libelleBanque")
    private String libBq;
    @JsonProperty("dateDebutValidite")
    private String dtDebValDomBq;
    @JsonProperty("dateFinValidite")
    private String dtFinValDomBq;
    @JsonProperty("dateRecodification")
    private String dtRecod;
    @JsonProperty("codeEtat")
    private String cdEtaDom;
    @JsonProperty("topBanqueReferencee")
    private String topBqRef;
    @JsonProperty("idDomBq")
    private String idDomBq;
    
    public String getIdDomBq() {
		return idDomBq;
	}

	public void setIdDomBq(String idDomBq) {
		this.idDomBq = idDomBq;
	}

	public DomiciliationBancaire typPerPorteur(final String typPerPorteur) {
        this.typPerPorteur = typPerPorteur;
        return this;
    }
    
    public DomiciliationBancaire idDomBq(final String idDomBq) {
        this.idDomBq = idDomBq;
        return this;
    }
    
    @ApiModelProperty("Code type porteur de la domiciliation")
    public String getTypePersonnePorteur() {
        return this.typPerPorteur;
    }
    
    public void setTypePersonnePorteur(final String typPerPorteur) {
        this.typPerPorteur = typPerPorteur;
    }
    
    public DomiciliationBancaire idPerPorteur(final String idPerPorteur) {
        this.idPerPorteur = idPerPorteur;
        return this;
    }
    
    @ApiModelProperty("Num\u00e9ro identifiant porteur de la domiciliation")
    public String getIdentifiantPersonnePorteur() {
        return this.idPerPorteur;
    }
    
    public void setIdentifiantPersonnePorteur(final String idPerPorteur) {
        this.idPerPorteur = idPerPorteur;
    }
    
    public DomiciliationBancaire cdTypDom(final String cdTypDom) {
        this.cdTypDom = cdTypDom;
        return this;
    }
    
    @ApiModelProperty("Code type domiciliation")
    public String getCodeTypeDomiciliation() {
        return this.cdTypDom;
    }
    
    public void setCodeTypeDomiciliation(final String cdTypDom) {
        this.cdTypDom = cdTypDom;
    }
    
    public DomiciliationBancaire cdBq(final String cdBq) {
        this.cdBq = cdBq;
        return this;
    }
    
    @ApiModelProperty("Code banque")
    public String getCodeBanque() {
        return this.cdBq;
    }
    
    public void setCodeBanque(final String cdBq) {
        this.cdBq = cdBq;
    }
    
    public DomiciliationBancaire cdGuichet(final String cdGuichet) {
        this.cdGuichet = cdGuichet;
        return this;
    }
    
    @ApiModelProperty("Code guichet")
    public String getCodeGuichet() {
        return this.cdGuichet;
    }
    
    public void setCodeGuichet(final String cdGuichet) {
        this.cdGuichet = cdGuichet;
    }
    
    public DomiciliationBancaire noCptBq(final String noCptBq) {
        this.noCptBq = noCptBq;
        return this;
    }
    
    @ApiModelProperty("Num\u00e9ro de compte bancaire")
    public String getNumeroCompteBanquaire() {
        return this.noCptBq;
    }
    
    public void setNumeroCompteBanquaire(final String noCptBq) {
        this.noCptBq = noCptBq;
    }
    
    public DomiciliationBancaire cleRib(final String cleRib) {
        this.cleRib = cleRib;
        return this;
    }
    
    @ApiModelProperty("Cl\u00e9 RIB")
    public String getCleRib() {
        return this.cleRib;
    }
    
    public void setCleRib(final String cleRib) {
        this.cleRib = cleRib;
    }
    
    public DomiciliationBancaire iban(final String iban) {
        this.iban = iban;
        return this;
    }
    
    @ApiModelProperty("IBAN")
    public String getIban() {
        return this.iban;
    }
    
    public void setIban(final String iban) {
        this.iban = iban;
    }
    
    public DomiciliationBancaire tituCpt(final String tituCpt) {
        this.tituCpt = tituCpt;
        return this;
    }
    
    @ApiModelProperty("Titulaire du compte")
    public String getTitulaireCompte() {
        return this.tituCpt;
    }
    
    public void setTitulaireCompte(final String tituCpt) {
        this.tituCpt = tituCpt;
    }
    
    public DomiciliationBancaire libBq(final String libBq) {
        this.libBq = libBq;
        return this;
    }
    
    @ApiModelProperty("Libell\u00e9 de la banque")
    public String getLibelleBanque() {
        return this.libBq;
    }
    
    public void setLibelleBanque(final String libBq) {
        this.libBq = libBq;
    }
    
    public DomiciliationBancaire dtDebValDomBq(final String dtDebValDomBq) {
        this.dtDebValDomBq = dtDebValDomBq;
        return this;
    }
    
    @ApiModelProperty("Date de d\u00e9but de validit\u00e9")
    @Valid
    public String getDateDebutValidite() {
        return this.dtDebValDomBq;
    }
    
    public void setDateDebutValidite(final String dtDebValDomBq) {
        this.dtDebValDomBq = dtDebValDomBq;
    }
    
    public DomiciliationBancaire dtFinValDomBq(final String dtFinValDomBq) {
        this.dtFinValDomBq = dtFinValDomBq;
        return this;
    }
    
    @ApiModelProperty("Date de fin de validit\u00e9")
    @Valid
    public String getDateFinValidite() {
        return this.dtFinValDomBq;
    }
    
    public void setDateFinValidite(final String dtFinValDomBq) {
        this.dtFinValDomBq = dtFinValDomBq;
    }
    
    public DomiciliationBancaire dtRecod(final String dtRecod) {
        this.dtRecod = dtRecod;
        return this;
    }
    
    @ApiModelProperty("Date recodification")
    @Valid
    public String getDateRecodification() {
        return this.dtRecod;
    }
    
    public void setDateRecodification(final String dtRecod) {
        this.dtRecod = dtRecod;
    }
    
    public DomiciliationBancaire cdEtaDom(final String cdEtaDom) {
        this.cdEtaDom = cdEtaDom;
        return this;
    }
    
    @ApiModelProperty("Code \u00e9tat domiciliation")
    public String getCodeEtat() {
        return this.cdEtaDom;
    }
    
    public void setCodeEtat(final String cdEtaDom) {
        this.cdEtaDom = cdEtaDom;
    }
    
    public DomiciliationBancaire topBqRef(final String topBqRef) {
        this.topBqRef = topBqRef;
        return this;
    }
    
    @ApiModelProperty("Top banque r\u00e9f\u00e9renc\u00e9e")
    public Boolean getTopBanqueReferencee() {
    	var topBp=Integer.parseInt(this.topBqRef);
        return topBp==1?true:false;
    }
    
    public void setTopBanqueReferencee(final String topBqRef) {
        this.topBqRef = topBqRef;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final DomiciliationBancaire domiciliationBancaire = (DomiciliationBancaire)o;
        return Objects.equals(this.typPerPorteur, domiciliationBancaire.typPerPorteur) && Objects.equals(this.idPerPorteur, domiciliationBancaire.idPerPorteur) && Objects.equals(this.cdTypDom, domiciliationBancaire.cdTypDom) && Objects.equals(this.cdBq, domiciliationBancaire.cdBq) && Objects.equals(this.cdGuichet, domiciliationBancaire.cdGuichet) && Objects.equals(this.noCptBq, domiciliationBancaire.noCptBq) && Objects.equals(this.cleRib, domiciliationBancaire.cleRib) && Objects.equals(this.iban, domiciliationBancaire.iban) && Objects.equals(this.tituCpt, domiciliationBancaire.tituCpt) && Objects.equals(this.libBq, domiciliationBancaire.libBq) && Objects.equals(this.dtDebValDomBq, domiciliationBancaire.dtDebValDomBq) && Objects.equals(this.dtFinValDomBq, domiciliationBancaire.dtFinValDomBq) && Objects.equals(this.dtRecod, domiciliationBancaire.dtRecod) && Objects.equals(this.cdEtaDom, domiciliationBancaire.cdEtaDom) && Objects.equals(this.topBqRef, domiciliationBancaire.topBqRef);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.typPerPorteur,this.idDomBq,this.idPerPorteur, this.cdTypDom, this.cdBq, this.cdGuichet, this.noCptBq, this.cleRib, this.iban, this.tituCpt, this.libBq, this.dtDebValDomBq, this.dtFinValDomBq, this.dtRecod, this.cdEtaDom, this.topBqRef);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class DomiciliationBancaire {\n");
        sb.append("    typPerPorteur: ").append(this.toIndentedString(this.typPerPorteur)).append("\n");
        sb.append("    idDomBq: ").append(this.toIndentedString(this.idDomBq)).append("\n");
        sb.append("    idPerPorteur: ").append(this.toIndentedString(this.idPerPorteur)).append("\n");
        sb.append("    cdTypDom: ").append(this.toIndentedString(this.cdTypDom)).append("\n");
        sb.append("    cdBq: ").append(this.toIndentedString(this.cdBq)).append("\n");
        sb.append("    cdGuichet: ").append(this.toIndentedString(this.cdGuichet)).append("\n");
        sb.append("    noCptBq: ").append(this.toIndentedString(this.noCptBq)).append("\n");
        sb.append("    cleRib: ").append(this.toIndentedString(this.cleRib)).append("\n");
        sb.append("    iban: ").append(this.toIndentedString(this.iban)).append("\n");
        sb.append("    tituCpt: ").append(this.toIndentedString(this.tituCpt)).append("\n");
        sb.append("    libBq: ").append(this.toIndentedString(this.libBq)).append("\n");
        sb.append("    dtDebValDomBq: ").append(this.toIndentedString(this.dtDebValDomBq)).append("\n");
        sb.append("    dtFinValDomBq: ").append(this.toIndentedString(this.dtFinValDomBq)).append("\n");
        sb.append("    dtRecod: ").append(this.toIndentedString(this.dtRecod)).append("\n");
        sb.append("    cdEtaDom: ").append(this.toIndentedString(this.cdEtaDom)).append("\n");
        sb.append("    topBqRef: ").append(this.toIndentedString(this.topBqRef)).append("\n");
        sb.append("}");
        return sb.toString();
    }
    
    private String toIndentedString(final Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
