package com.gemini.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gemini.ocs.model.DataProcRequirement;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@DynamicUpdate
public class DataProc {
    private static AtomicInteger count = new AtomicInteger(0);
    @JsonProperty("saturation")
    private double saturation;
    @JsonProperty("brightness")
    private double brightness;
    @JsonProperty("contrast")
    private double contrast;
    @JsonProperty("fileQuality")
    private double fileQuality;
    @Id
    private int id;
    @JsonProperty("fileType")
    private String fileType;
    @JsonProperty("colorType")
    private String COLOR_TYPE;

    public DataProc(){}

    public DataProc(String fileType, double fileQuality
            , String COLOR_TYPE, double contrast
            , double brightness, double saturation){
        this.fileType=fileType;
        this.fileQuality=fileQuality;
        this.COLOR_TYPE=COLOR_TYPE;
        this.contrast=contrast;
        this.brightness=brightness;
        this.saturation=saturation;
        this.id = count.incrementAndGet();
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public double getBrightness() {
        return brightness;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public double getContrast() {
        return contrast;
    }

    public void setContrast(double contrast) {
        this.contrast = contrast;
    }

    public double getFileQuality() {
        return fileQuality;
    }

    public void setFileQuality(double fileQuality) {
        this.fileQuality = fileQuality;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getCOLOR_TYPE() {
        return COLOR_TYPE;
    }

    public void setCOLOR_TYPE(String COLOR_TYPE) {
        this.COLOR_TYPE = COLOR_TYPE;
    }
}
