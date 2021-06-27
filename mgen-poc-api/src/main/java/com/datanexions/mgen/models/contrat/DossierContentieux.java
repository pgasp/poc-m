// 
// Decompiled by Procyon v0.5.36
// 

package com.datanexions.mgen.models.contrat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.couchbase.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Dossier contentieux rattach\u00e9 \u00e0 un contrat")
@Document
public class DossierContentieux
{
    @JsonProperty("codeNature")
    private String codnatcont;
    @JsonProperty("dateCreation")
    private String dateCreation;
    @JsonProperty("dateCreationDossierGft")
    private String datcredoscontgft;
    @JsonProperty("phasesRecouvrement")
    @Valid
    private List<PhaseRecouvrement> phasesRecouvrement;
    
    public DossierContentieux() {
        this.phasesRecouvrement = null;
    }
    
    public DossierContentieux codnatcont(final String codnatcont) {
        this.codnatcont = codnatcont;
        return this;
    }
    
    @ApiModelProperty("Code nature contentieux")
    public String getCodeNature() {
        return this.codnatcont;
    }
    
    public void setCodeNature(final String codnatcont) {
        this.codnatcont = codnatcont;
    }
    
    public DossierContentieux dateCreation(final String dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }
    
    @ApiModelProperty("Date de cr\u00e9ation du contentieux")
    @Valid
    public String getDateCreation() {
        return this.dateCreation;
    }
    
    public void setDateCreation(final String dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public DossierContentieux datcredoscontgft(final String datcredoscontgft) {
        this.datcredoscontgft = datcredoscontgft;
        return this;
    }
    
    @ApiModelProperty("Date de cr\u00e9ation du dossier GFT")
    @Valid
    public String getDateCreationDossierGft() {
        return this.datcredoscontgft;
    }
    
    public void setDateCreationDossierGft(final String datcredoscontgft) {
        this.datcredoscontgft = datcredoscontgft;
    }
    
    public DossierContentieux phasesRecouvrement(final List<PhaseRecouvrement> phasesRecouvrement) {
        this.phasesRecouvrement = phasesRecouvrement;
        return this;
    }
    
    public DossierContentieux addPhasesRecouvrementItem(final PhaseRecouvrement phasesRecouvrementItem) {
        if (this.phasesRecouvrement == null) {
            this.phasesRecouvrement = new ArrayList<PhaseRecouvrement>();
        }
        this.phasesRecouvrement.add(phasesRecouvrementItem);
        return this;
    }
    
    @ApiModelProperty(readOnly = true, value = "")
    @Valid
    public List<PhaseRecouvrement> getPhasesRecouvrement() {
        return this.phasesRecouvrement;
    }
    
    public void setPhasesRecouvrement(final List<PhaseRecouvrement> phasesRecouvrement) {
        this.phasesRecouvrement = phasesRecouvrement;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final DossierContentieux dossierContentieux = (DossierContentieux)o;
        return Objects.equals(this.codnatcont, dossierContentieux.codnatcont) && Objects.equals(this.dateCreation, dossierContentieux.dateCreation) && Objects.equals(this.datcredoscontgft, dossierContentieux.datcredoscontgft) && Objects.equals(this.phasesRecouvrement, dossierContentieux.phasesRecouvrement);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.codnatcont, this.dateCreation, this.datcredoscontgft, this.phasesRecouvrement);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class DossierContentieux {\n");
        sb.append("    codnatcont: ").append(this.toIndentedString(this.codnatcont)).append("\n");
        sb.append("    dateCreation: ").append(this.toIndentedString(this.dateCreation)).append("\n");
        sb.append("    datcredoscontgft: ").append(this.toIndentedString(this.datcredoscontgft)).append("\n");
        sb.append("    phasesRecouvrement: ").append(this.toIndentedString(this.phasesRecouvrement)).append("\n");
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
