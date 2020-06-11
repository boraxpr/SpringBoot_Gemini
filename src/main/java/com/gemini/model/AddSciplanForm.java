package com.gemini.model;

import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;

@XmlRootElement
public class AddSciplanForm {
    Boolean validated;
    String creator;
    String submitter;
    double fundingInUSD;
    String objectives;
    String starSystem;
    String startDate;
    String endDate;
    String TELESCOPELOC;
    ArrayList<String> dataProcRequirements;
    ArrayList<String> observingProgram;
    String status;
    
    public AddSciplanForm(){}
    
    public AddSciplanForm(String creator
            , String submitter, double fundingInUSD
            , String objectives, String starSystem
            , String startDate, String endDate
            , String telescopeLocation, ArrayList<String> dataProcRequirements
            , ArrayList<String> observingProgram, String status){
                this.creator = creator;
        this.submitter = submitter;
        this.fundingInUSD = fundingInUSD;
        this.objectives = objectives;
        this.starSystem = starSystem;
        this.startDate = startDate;
        this.endDate = endDate;
        this.TELESCOPELOC = telescopeLocation;
        this.dataProcRequirements = dataProcRequirements;
        this.observingProgram = observingProgram;
        this.status = status;
        this.validated = Boolean.FALSE;
    }

    public String getCreator() {
        return creator;
    }

    public String getSubmiter() {
        return submitter;
    }

    public double getFundingInUSD() {
        return fundingInUSD;
    }

    public String getObjectives() {
        return objectives;
    }

    public String getStarSystem() {
        return starSystem;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTELESCOPELOC() {
        return TELESCOPELOC;
    }

    public ArrayList<String> getDataProcRequirements() {
        return dataProcRequirements;
    }

    public ArrayList<String> getObservingProgram() {
        return observingProgram;
    }

    public String getStatus() {
        return status;
    }
}
