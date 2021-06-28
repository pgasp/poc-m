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

public class Erreur
{
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("type")
    private String type;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("detail")
    @Valid
    private List<ErreurDetail> detail;
    
    public Erreur() {
        this.detail = null;
    }
    
    public Erreur uuid(final String uuid) {
        this.uuid = uuid;
        return this;
    }
    
    @ApiModelProperty("Identifiant de l'erreur")
    public String getUuid() {
        return this.uuid;
    }
    
    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }
    
    public Erreur type(final String type) {
        this.type = type;
        return this;
    }
    
    @ApiModelProperty("type de l'erreur (fonctionnelle, technique, validation, ...)")
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public Erreur code(final String code) {
        this.code = code;
        return this;
    }
    
    @ApiModelProperty("le code de l'erreur")
    public String getCode() {
        return this.code;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public Erreur message(final String message) {
        this.message = message;
        return this;
    }
    
    @ApiModelProperty("Le message d'erreur")
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public Erreur detail(final List<ErreurDetail> detail) {
        this.detail = detail;
        return this;
    }
    
    public Erreur addDetailItem(final ErreurDetail detailItem) {
        if (this.detail == null) {
            this.detail = new ArrayList<ErreurDetail>();
        }
        this.detail.add(detailItem);
        return this;
    }
    
    @ApiModelProperty("Les erreurs d\u00e9taill\u00e9es")
    @Valid
    public List<ErreurDetail> getDetail() {
        return this.detail;
    }
    
    public void setDetail(final List<ErreurDetail> detail) {
        this.detail = detail;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Erreur erreur = (Erreur)o;
        return Objects.equals(this.uuid, erreur.uuid) && Objects.equals(this.type, erreur.type) && Objects.equals(this.code, erreur.code) && Objects.equals(this.message, erreur.message) && Objects.equals(this.detail, erreur.detail);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.uuid, this.type, this.code, this.message, this.detail);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class Erreur {\n");
        sb.append("    uuid: ").append(this.toIndentedString(this.uuid)).append("\n");
        sb.append("    type: ").append(this.toIndentedString(this.type)).append("\n");
        sb.append("    code: ").append(this.toIndentedString(this.code)).append("\n");
        sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
        sb.append("    detail: ").append(this.toIndentedString(this.detail)).append("\n");
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
