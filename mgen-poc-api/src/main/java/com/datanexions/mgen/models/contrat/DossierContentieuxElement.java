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
import java.util.Objects;

@ApiModel(description = "Objet racine. Repr\u00e9sente un Dossier Contentieux d'unContrat chez MGEN. Cette objet ne contient que les informations de base (sans les objets de niveau 2 et plus). Il est donc fait pour \u00eatre inclu dans les r\u00e9sultats d'une collection.  ")
public class DossierContentieuxElement
{
    @JsonProperty("codeNature")
    private String codeNature;
    @JsonProperty("dateCreation")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateCreation;
    @JsonProperty("dateCreationDossierGft")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateCreationDossierGft;
    
    public DossierContentieuxElement codeNature(final String codeNature) {
        this.codeNature = codeNature;
        return this;
    }
    
    @ApiModelProperty("Code nature contentieux")
    public String getCodeNature() {
        return this.codeNature;
    }
    
    public void setCodeNature(final String codeNature) {
        this.codeNature = codeNature;
    }
    
    public DossierContentieuxElement dateCreation(final LocalDate dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }
    
    @ApiModelProperty("Date de cr\u00e9ation du contentieux")
    @Valid
    public LocalDate getDateCreation() {
        return this.dateCreation;
    }
    
    public void setDateCreation(final LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public DossierContentieuxElement dateCreationDossierGft(final LocalDate dateCreationDossierGft) {
        this.dateCreationDossierGft = dateCreationDossierGft;
        return this;
    }
    
    @ApiModelProperty("Date de cr\u00e9ation du dossier GFT")
    @Valid
    public LocalDate getDateCreationDossierGft() {
        return this.dateCreationDossierGft;
    }
    
    public void setDateCreationDossierGft(final LocalDate dateCreationDossierGft) {
        this.dateCreationDossierGft = dateCreationDossierGft;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final DossierContentieuxElement dossierContentieuxElement = (DossierContentieuxElement)o;
        return Objects.equals(this.codeNature, dossierContentieuxElement.codeNature) && Objects.equals(this.dateCreation, dossierContentieuxElement.dateCreation) && Objects.equals(this.dateCreationDossierGft, dossierContentieuxElement.dateCreationDossierGft);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.codeNature, this.dateCreation, this.dateCreationDossierGft);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class DossierContentieuxElement {\n");
        sb.append("    codeNature: ").append(this.toIndentedString(this.codeNature)).append("\n");
        sb.append("    dateCreation: ").append(this.toIndentedString(this.dateCreation)).append("\n");
        sb.append("    dateCreationDossierGft: ").append(this.toIndentedString(this.dateCreationDossierGft)).append("\n");
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
