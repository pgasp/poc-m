// 
// Decompiled by Procyon v0.5.36
// 

package com.datanexions.mgen.models.contrat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContratAllOf
{
    @JsonProperty("dossiersContentieux")
    @Valid
    private List<DossierContentieux> dossiersContentieux;
    @JsonProperty("domiciliationsBancaires")
    @Valid
    private List<DomiciliationBancaire> domiciliationsBancaires;
    @JsonProperty("statuts")
    @Valid
    private List<Statut> statuts;
    
    public ContratAllOf() {
        this.dossiersContentieux = null;
        this.domiciliationsBancaires = null;
        this.statuts = null;
    }
    
    public ContratAllOf dossiersContentieux(final List<DossierContentieux> dossiersContentieux) {
        this.dossiersContentieux = dossiersContentieux;
        return this;
    }
    
    public ContratAllOf addDossiersContentieuxItem(final DossierContentieux dossiersContentieuxItem) {
        if (this.dossiersContentieux == null) {
            this.dossiersContentieux = new ArrayList<DossierContentieux>();
        }
        this.dossiersContentieux.add(dossiersContentieuxItem);
        return this;
    }
    
    @ApiModelProperty("")
    @Valid
    public List<DossierContentieux> getDossiersContentieux() {
        return this.dossiersContentieux;
    }
    
    public void setDossiersContentieux(final List<DossierContentieux> dossiersContentieux) {
        this.dossiersContentieux = dossiersContentieux;
    }
    
    public ContratAllOf domiciliationsBancaires(final List<DomiciliationBancaire> domiciliationsBancaires) {
        this.domiciliationsBancaires = domiciliationsBancaires;
        return this;
    }
    
    public ContratAllOf addDomiciliationsBancairesItem(final DomiciliationBancaire domiciliationsBancairesItem) {
        if (this.domiciliationsBancaires == null) {
            this.domiciliationsBancaires = new ArrayList<DomiciliationBancaire>();
        }
        this.domiciliationsBancaires.add(domiciliationsBancairesItem);
        return this;
    }
    
    @ApiModelProperty("")
    @Valid
    public List<DomiciliationBancaire> getDomiciliationsBancaires() {
        return this.domiciliationsBancaires;
    }
    
    public void setDomiciliationsBancaires(final List<DomiciliationBancaire> domiciliationsBancaires) {
        this.domiciliationsBancaires = domiciliationsBancaires;
    }
    
    public ContratAllOf statuts(final List<Statut> statuts) {
        this.statuts = statuts;
        return this;
    }
    
    public ContratAllOf addStatutsItem(final Statut statutsItem) {
        if (this.statuts == null) {
            this.statuts = new ArrayList<Statut>();
        }
        this.statuts.add(statutsItem);
        return this;
    }
    
    @ApiModelProperty(readOnly = true, value = "")
    @Valid
    public List<Statut> getStatuts() {
        return this.statuts;
    }
    
    public void setStatuts(final List<Statut> statuts) {
        this.statuts = statuts;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ContratAllOf contratAllOf = (ContratAllOf)o;
        return Objects.equals(this.dossiersContentieux, contratAllOf.dossiersContentieux) && Objects.equals(this.domiciliationsBancaires, contratAllOf.domiciliationsBancaires) && Objects.equals(this.statuts, contratAllOf.statuts);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.dossiersContentieux, this.domiciliationsBancaires, this.statuts);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class ContratAllOf {\n");
        sb.append("    dossiersContentieux: ").append(this.toIndentedString(this.dossiersContentieux)).append("\n");
        sb.append("    domiciliationsBancaires: ").append(this.toIndentedString(this.domiciliationsBancaires)).append("\n");
        sb.append("    statuts: ").append(this.toIndentedString(this.statuts)).append("\n");
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
