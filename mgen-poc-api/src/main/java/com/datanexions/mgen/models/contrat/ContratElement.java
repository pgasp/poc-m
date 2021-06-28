// 
// Decompiled by Procyon v0.5.36
// 

package com.datanexions.mgen.models.contrat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@ApiModel(description = "Objet racine. Repr\u00e9sente un Contrat chez MGEN. Cette objet ne contient que les informations de base (sans les objets de niveau 2 et plus). Il est donc fait pour \u00eatre inclu dans les r\u00e9sultats d'une collection.  ")
public class ContratElement
{
    @JsonProperty("identifiant")
    protected String idCtr;
    @JsonProperty("dateDebut")
    protected String dtDebCtr;
    @JsonProperty("dateFin")
    protected String dtFinCtr;
    @JsonProperty("codeNature")
    protected String cdNatCtr;
    
    
    
    
    public ContratElement identifiant(final String identifiant) {
        this.idCtr = identifiant;
        return this;
    }

    @ApiModelProperty("Identifiant du contrat")
    public String getIdentifiant() {
        return this.idCtr;
    }

    public void setIdentifiant(final String identifiant) {
        this.idCtr = identifiant;
    }

    public ContratElement dtDebCtr(final String dtDebCtr) {
        this.dtDebCtr = dtDebCtr;
        return this;
    }

    @ApiModelProperty("Date de souscription")
    @Valid
    public String getDateDebut() {
        return this.dtDebCtr;
    }

    public void setDateDebut(final String dtDebCtr) {
        this.dtDebCtr = dtDebCtr;
    }

    public ContratElement dtFinCtr(final String dtFinCtr) {
        this.dtFinCtr = dtFinCtr;
        return this;
    }

    @ApiModelProperty("Date de fin")
    @Valid
    public String getDateFin() {
        return this.dtFinCtr;
    }

    public void setDateFin(final String dtFinCtr) {
        this.dtFinCtr = dtFinCtr;
    }

    public ContratElement cdNatCtr(final String cdNatCtr) {
        this.cdNatCtr = cdNatCtr;
        return this;
    }

    @ApiModelProperty("Code de la nature du contrat")
    public String getCodeNature() {
        return this.cdNatCtr;
    }

    public void setCodeNature(final String cdNatCtr) {
        this.cdNatCtr = cdNatCtr;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ContratElement contratElement = (ContratElement)o;
        return Objects.equals(this.idCtr, contratElement.idCtr) && Objects.equals(this.dtDebCtr, contratElement.dtDebCtr) && Objects.equals(this.dtFinCtr, contratElement.dtFinCtr) && Objects.equals(this.cdNatCtr, contratElement.cdNatCtr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idCtr, this.dtDebCtr, this.dtFinCtr, this.cdNatCtr);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class ContratElement {\n");
        sb.append("    identifiant: ").append(this.toIndentedString(this.idCtr)).append("\n");
        sb.append("    dtDebCtr: ").append(this.toIndentedString(this.dtDebCtr)).append("\n");
        sb.append("    dtFinCtr: ").append(this.toIndentedString(this.dtFinCtr)).append("\n");
        sb.append("    cdNatCtr: ").append(this.toIndentedString(this.cdNatCtr)).append("\n");
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
