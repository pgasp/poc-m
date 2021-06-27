// 
// Decompiled by Procyon v0.5.36
// 

package com.datanexions.mgen.models.contrat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class ErreurDetail
{
    @JsonProperty("field")
    private String field;
    @JsonProperty("message")
    private String message;
    @JsonProperty("value")
    private String value;
    
    public ErreurDetail field(final String field) {
        this.field = field;
        return this;
    }
    
    @ApiModelProperty("Nom du champ sur lequel s'applique l'erreur")
    public String getField() {
        return this.field;
    }
    
    public void setField(final String field) {
        this.field = field;
    }
    
    public ErreurDetail message(final String message) {
        this.message = message;
        return this;
    }
    
    @ApiModelProperty("Message d'erreur associ\u00e9 au champ")
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public ErreurDetail value(final String value) {
        this.value = value;
        return this;
    }
    
    @ApiModelProperty("Valeur qui a pos\u00e9 probl\u00e8me")
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String value) {
        this.value = value;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ErreurDetail erreurDetail = (ErreurDetail)o;
        return Objects.equals(this.field, erreurDetail.field) && Objects.equals(this.message, erreurDetail.message) && Objects.equals(this.value, erreurDetail.value);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.field, this.message, this.value);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class ErreurDetail {\n");
        sb.append("    field: ").append(this.toIndentedString(this.field)).append("\n");
        sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
        sb.append("    value: ").append(this.toIndentedString(this.value)).append("\n");
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
