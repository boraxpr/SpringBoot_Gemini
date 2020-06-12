package com.gemini.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemini.ocs.model.Filter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class filter {
    private static AtomicInteger count = new AtomicInteger(0);
    @Id
    private int id;
    @JsonProperty("make")
    private String make;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("model")
    private String model;
    @JsonProperty("year")
    private int year;
    @JsonProperty("size")
    private double size;
    @JsonProperty("weight")
    private double weight;

    public filter(){}

    public filter(String make, String manufacturer, String model
            , int year, double size, double weight) {
        this.id = count.incrementAndGet();
        this.make = make;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.size = size;
        this.weight = weight;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
