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

@ApiModel(description = "Un statut")
public class Statut
{
    @JsonProperty("code")
    private String cdSttCtr;
    @JsonProperty("dateDebutEffet")
    private String dtDebEffCtrHis;
    @JsonProperty("dtFinEffCtrHis")
    private String dtFinEffCtrHis;
    @JsonProperty("codeMotif")
    private String cdMtfSttCtr;
    @JsonProperty("codePrecisionMotif")
    private String cdPrecMtfSttCtr;
    @JsonProperty("precisionMotifStatutAutre")
    private String precMtfSttAutre;
    
    public Statut cdSttCtr(final String cdSttCtr) {
        this.cdSttCtr = cdSttCtr;
        return this;
    }
    
    @ApiModelProperty("Code statut contrat")
    public String getCode() {
        return this.cdSttCtr;
    }
    
    public void setCode(final String cdSttCtr) {
        this.cdSttCtr = cdSttCtr;
    }
    
    public Statut dtDebEffCtrHis(final String dtDebEffCtrHis) {
        this.dtDebEffCtrHis = dtDebEffCtrHis;
        return this;
    }
    
    @ApiModelProperty("Date d\u00e9but d'effet statut")
    @Valid
    public String getDateDebutEffet() {
        return this.dtDebEffCtrHis;
    }
    
    public void setDateDebutEffet(final String dtDebEffCtrHis) {
        this.dtDebEffCtrHis = dtDebEffCtrHis;
    }
    
    public Statut dtFinEffCtrHis(final String dtFinEffCtrHis) {
        this.dtFinEffCtrHis = dtFinEffCtrHis;
        return this;
    }
    
    @ApiModelProperty("Date fin d'effet statut")
    @Valid
    public String getDateFinEffet() {
        return this.dtFinEffCtrHis;
    }
    
    public void setDateFinEffet(final String dtFinEffCtrHis) {
        this.dtFinEffCtrHis = dtFinEffCtrHis;
    }
    
    public Statut cdMtfSttCtr(final String cdMtfSttCtr) {
        this.cdMtfSttCtr = cdMtfSttCtr;
        return this;
    }
    
    @ApiModelProperty("Code motif statut")
    public String getCodeMotif() {
        return this.cdMtfSttCtr;
    }
    
    public void setCodeMotif(final String cdMtfSttCtr) {
        this.cdMtfSttCtr = cdMtfSttCtr;
    }
    
    public Statut cdPrecMtfSttCtr(final String cdPrecMtfSttCtr) {
        this.cdPrecMtfSttCtr = cdPrecMtfSttCtr;
        return this;
    }
    
    @ApiModelProperty("Code pr\u00e9cision motif statut")
    public String getCodePrecisionMotif() {
        return this.cdPrecMtfSttCtr;
    }
    
    public void setCodePrecisionMotif(final String cdPrecMtfSttCtr) {
        this.cdPrecMtfSttCtr = cdPrecMtfSttCtr;
    }
    
    public Statut precMtfSttAutre(final String precMtfSttAutre) {
        this.precMtfSttAutre = precMtfSttAutre;
        return this;
    }
    
    @ApiModelProperty("Pr\u00e9cision motif statut autre")
    public String getPrecisionMotifStatutAutre() {
        return this.precMtfSttAutre;
    }
    
    public void setPrecisionMotifStatutAutre(final String precMtfSttAutre) {
        this.precMtfSttAutre = precMtfSttAutre;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Statut statut = (Statut)o;
        return Objects.equals(this.cdSttCtr, statut.cdSttCtr) && Objects.equals(this.dtDebEffCtrHis, statut.dtDebEffCtrHis) && Objects.equals(this.dtFinEffCtrHis, statut.dtFinEffCtrHis) && Objects.equals(this.cdMtfSttCtr, statut.cdMtfSttCtr) && Objects.equals(this.cdPrecMtfSttCtr, statut.cdPrecMtfSttCtr) && Objects.equals(this.precMtfSttAutre, statut.precMtfSttAutre);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.cdSttCtr, this.dtDebEffCtrHis, this.dtFinEffCtrHis, this.cdMtfSttCtr, this.cdPrecMtfSttCtr, this.precMtfSttAutre);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class Statut {\n");
        sb.append("    cdSttCtr: ").append(this.toIndentedString(this.cdSttCtr)).append("\n");
        sb.append("    dtDebEffCtrHis: ").append(this.toIndentedString(this.dtDebEffCtrHis)).append("\n");
        sb.append("    dtFinEffCtrHis: ").append(this.toIndentedString(this.dtFinEffCtrHis)).append("\n");
        sb.append("    cdMtfSttCtr: ").append(this.toIndentedString(this.cdMtfSttCtr)).append("\n");
        sb.append("    cdPrecMtfSttCtr: ").append(this.toIndentedString(this.cdPrecMtfSttCtr)).append("\n");
        sb.append("    precMtfSttAutre: ").append(this.toIndentedString(this.precMtfSttAutre)).append("\n");
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
