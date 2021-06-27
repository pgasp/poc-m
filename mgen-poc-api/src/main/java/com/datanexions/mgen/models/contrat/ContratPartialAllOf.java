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

public class ContratPartialAllOf
{
    @JsonProperty("statuts")
    @Valid
    private List<Statut> statuts;
    
    public ContratPartialAllOf() {
        this.statuts = null;
    }
    
    public ContratPartialAllOf statuts(final List<Statut> statuts) {
        this.statuts = statuts;
        return this;
    }
    
    public ContratPartialAllOf addStatutsItem(final Statut statutsItem) {
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
        final ContratPartialAllOf contratPartialAllOf = (ContratPartialAllOf)o;
        return Objects.equals(this.statuts, contratPartialAllOf.statuts);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.statuts);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class ContratPartialAllOf {\n");
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
