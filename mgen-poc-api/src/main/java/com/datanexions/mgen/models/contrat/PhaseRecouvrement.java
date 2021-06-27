// 
// Decompiled by Procyon v0.5.36
// 

package com.datanexions.mgen.models.contrat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.util.Objects;

@ApiModel(description = "Phase de recouvrement d'un dossier contentieux rattach\u00e9 \u00e0 un contrat")
public class PhaseRecouvrement
{
    @JsonProperty("code")
    private String codphaserecouv;
    @JsonProperty("codeStatutMouvement")
    private String codstatmouv;
    @JsonProperty("codeMotif")
    private String codmtfphaserecouv;
    @JsonProperty("dateCreation")
    private String datcrephaserecouv;
    @JsonProperty("dateDebutEffet")
    private String datdebeffphaserecouv;
    @JsonProperty("dateFinEffet")
    private String datfineffphaserecouv;
    
    public PhaseRecouvrement codphaserecouv(final String codphaserecouv) {
        this.codphaserecouv = codphaserecouv;
        return this;
    }
    
    @ApiModelProperty("Code phase de recouvrement")
    public String getCode() {
        return this.codphaserecouv;
    }
    
    public void setCode(final String codphaserecouv) {
        this.codphaserecouv = codphaserecouv;
    }
    
    public PhaseRecouvrement codstatmouv(final String codstatmouv) {
        this.codstatmouv = codstatmouv;
        return this;
    }
    
    @ApiModelProperty("Code statut mouvement")
    public String getCodeStatutMouvement() {
        return this.codstatmouv;
    }
    
    public void setCodeStatutMouvement(final String codstatmouv) {
        this.codstatmouv = codstatmouv;
    }
    
    public PhaseRecouvrement codmtfphaserecouv(final String codmtfphaserecouv) {
        this.codmtfphaserecouv = codmtfphaserecouv;
        return this;
    }
    
    @ApiModelProperty("Code motif de fin de la phase de recouvrement")
    public String getCodeMotif() {
        return this.codmtfphaserecouv;
    }
    
    public void setCodeMotif(final String codmtfphaserecouv) {
        this.codmtfphaserecouv = codmtfphaserecouv;
    }
    
    public PhaseRecouvrement datcrephaserecouv(final String datcrephaserecouv) {
        this.datcrephaserecouv = datcrephaserecouv;
        return this;
    }
    
    @ApiModelProperty("Date de cr\u00e9ation de la phase de recouvrement")
    @Valid
    public String getDateCreation() {
        return this.datcrephaserecouv;
    }
    
    public void setDateCreation(final String datcrephaserecouv) {
        this.datcrephaserecouv = datcrephaserecouv;
    }
    
    public PhaseRecouvrement datdebeffphaserecouv(final String datdebeffphaserecouv) {
        this.datdebeffphaserecouv = datdebeffphaserecouv;
        return this;
    }
    
    @ApiModelProperty("Date de d\u00e9but d'efet de la phase de recouvrement")
    @Valid
    public String getDateDebutEffet() {
        return this.datdebeffphaserecouv;
    }
    
    public void setDateDebutEffet(final String datdebeffphaserecouv) {
        this.datdebeffphaserecouv = datdebeffphaserecouv;
    }
    
    public PhaseRecouvrement datfineffphaserecouv(final String datfineffphaserecouv) {
        this.datfineffphaserecouv = datfineffphaserecouv;
        return this;
    }
    
    @ApiModelProperty("Date de fin d'effet de la phase de recouvrement")
    @Valid
    public String getDateFinEffet() {
        return this.datfineffphaserecouv;
    }
    
    public void setDateFinEffet(final String datfineffphaserecouv) {
        this.datfineffphaserecouv = datfineffphaserecouv;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final PhaseRecouvrement phaseRecouvrement = (PhaseRecouvrement)o;
        return Objects.equals(this.codphaserecouv, phaseRecouvrement.codphaserecouv) && Objects.equals(this.codstatmouv, phaseRecouvrement.codstatmouv) && Objects.equals(this.codmtfphaserecouv, phaseRecouvrement.codmtfphaserecouv) && Objects.equals(this.datcrephaserecouv, phaseRecouvrement.datcrephaserecouv) && Objects.equals(this.datdebeffphaserecouv, phaseRecouvrement.datdebeffphaserecouv) && Objects.equals(this.datfineffphaserecouv, phaseRecouvrement.datfineffphaserecouv);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.codphaserecouv, this.codstatmouv, this.codmtfphaserecouv, this.datcrephaserecouv, this.datdebeffphaserecouv, this.datfineffphaserecouv);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class PhaseRecouvrement {\n");
        sb.append("    codphaserecouv: ").append(this.toIndentedString(this.codphaserecouv)).append("\n");
        sb.append("    codstatmouv: ").append(this.toIndentedString(this.codstatmouv)).append("\n");
        sb.append("    codmtfphaserecouv: ").append(this.toIndentedString(this.codmtfphaserecouv)).append("\n");
        sb.append("    datcrephaserecouv: ").append(this.toIndentedString(this.datcrephaserecouv)).append("\n");
        sb.append("    datdebeffphaserecouv: ").append(this.toIndentedString(this.datdebeffphaserecouv)).append("\n");
        sb.append("    datfineffphaserecouv: ").append(this.toIndentedString(this.datfineffphaserecouv)).append("\n");
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
