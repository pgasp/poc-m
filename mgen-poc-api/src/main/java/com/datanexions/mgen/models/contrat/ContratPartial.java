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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApiModel(description = "Un d\u00e9tail partiel d'un contrat")
public class ContratPartial extends ContratElement
{
    @JsonProperty("statuts")
    @Valid
    private List<Statut> statuts;
    
    public ContratPartial() {
        this.statuts = null;
    }

    public ContratPartial statuts(final List<Statut> statuts) {
        this.statuts = statuts;
        return this;
    }
    
    public ContratPartial addStatutsItem(final Statut statutsItem) {
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

        if (!super.equals(o)){
            return false;
        }
        final ContratPartial contratPartial = (ContratPartial)o;
        return Objects.equals(this.statuts, contratPartial.statuts);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.idCtr, this.dtDebCtr, this.dtFinCtr, this.cdNatCtr, this.statuts);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class ContratPartial {\n");
        sb.append("    identifiant: ").append(this.toIndentedString(this.idCtr)).append("\n");
        sb.append("    dateDebut: ").append(this.toIndentedString(this.dtDebCtr)).append("\n");
        sb.append("    dateFin: ").append(this.toIndentedString(this.dtFinCtr)).append("\n");
        sb.append("    codeNature: ").append(this.toIndentedString(this.cdNatCtr)).append("\n");
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
