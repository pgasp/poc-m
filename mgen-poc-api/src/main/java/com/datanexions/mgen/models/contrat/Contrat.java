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

@ApiModel(description = "Un contrat")
public class Contrat extends ContratPartial
{
    @JsonProperty("dossiersContentieux")
    @Valid
    private List<DossierContentieux> dossiersContentieux;
    @JsonProperty("domiciliationsBancaires")
    @Valid  
    private List<DomiciliationBancaire> domiciliationsBancaires;

    public Contrat() {
        this.dossiersContentieux = null;
        this.domiciliationsBancaires = null;
    }

    public Contrat dossiersContentieux(final List<DossierContentieux> dossiersContentieux) {
        this.dossiersContentieux = dossiersContentieux;
        return this;
    }
    
    public Contrat addDossiersContentieuxItem(final DossierContentieux dossiersContentieuxItem) {
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
    
    public Contrat domiciliationsBancaires(final List<DomiciliationBancaire> domiciliationsBancaires) {
        this.domiciliationsBancaires = domiciliationsBancaires;
        return this;
    }
    
    public Contrat addDomiciliationsBancairesItem(final DomiciliationBancaire domiciliationsBancairesItem) {
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

        final Contrat contrat = (Contrat)o;
        return Objects.equals(this.dossiersContentieux, contrat.dossiersContentieux) && Objects.equals(this.domiciliationsBancaires, contrat.domiciliationsBancaires);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.idCtr, this.dtDebCtr, this.dtFinCtr, this.cdNatCtr, this.dossiersContentieux, this.domiciliationsBancaires, this.getStatuts());
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class Contrat {\n");
        sb.append("    identifiant: ").append(this.toIndentedString(this.idCtr)).append("\n");
        sb.append("    dateDebut: ").append(this.toIndentedString(this.dtDebCtr)).append("\n");
        sb.append("    dateFin: ").append(this.toIndentedString(this.dtFinCtr)).append("\n");
        sb.append("    codeNature: ").append(this.toIndentedString(this.cdNatCtr)).append("\n");
        sb.append("    dossiersContentieux: ").append(this.toIndentedString(this.dossiersContentieux)).append("\n");
        sb.append("    domiciliationsBancaires: ").append(this.toIndentedString(this.domiciliationsBancaires)).append("\n");
        sb.append("    statuts: ").append(this.toIndentedString(this.getStatuts())).append("\n");
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
