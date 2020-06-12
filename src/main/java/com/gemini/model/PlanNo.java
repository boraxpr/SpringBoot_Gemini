package com.gemini.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlanNo {
    @JsonProperty("PlanNo")
    private int planNo;

    public int getPlanNo(){
        return planNo;
    }
}
