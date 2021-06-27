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

public class DossierContentieuxAllOf
{
    @JsonProperty("phasesRecouvrement")
    @Valid
    private List<PhaseRecouvrement> phasesRecouvrement;
    
    public DossierContentieuxAllOf() {
        this.phasesRecouvrement = null;
    }
    
    public DossierContentieuxAllOf phasesRecouvrement(final List<PhaseRecouvrement> phasesRecouvrement) {
        this.phasesRecouvrement = phasesRecouvrement;
        return this;
    }
    
    public DossierContentieuxAllOf addPhasesRecouvrementItem(final PhaseRecouvrement phasesRecouvrementItem) {
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
        final DossierContentieuxAllOf dossierContentieuxAllOf = (DossierContentieuxAllOf)o;
        return Objects.equals(this.phasesRecouvrement, dossierContentieuxAllOf.phasesRecouvrement);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.phasesRecouvrement);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class DossierContentieuxAllOf {\n");
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
