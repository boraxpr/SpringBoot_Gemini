package com.gemini.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemini.ocs.model.Lens;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@DynamicUpdate
public class lens {
    private static AtomicInteger count = new AtomicInteger(0);
    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("year")
    private int year;
    @Id
    private int id;

    public lens(){
    }
    public lens(String make,String model,String manufacturer,int year){
        this.make = make;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.id = count.incrementAndGet();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
