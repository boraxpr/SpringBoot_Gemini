package com.gemini.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddSciplanForm {

    Boolean validated;
    double fundingInUSD;
    String creator;
    String objectives;
    String starSystem;
    String startDate;
    String endDate;
    String telescopeLoc;
    DataProc dataProc;
    ObservingProgram observingProgram;

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public void setFundingInUSD(double fundingInUSD) {
        this.fundingInUSD = fundingInUSD;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public void setStarSystem(String starSystem) {
        this.starSystem = starSystem;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTelescopeLoc(String telescopeLoc) {
        this.telescopeLoc = telescopeLoc;
    }

    public void setDataProcRequirements(DataProc dataProc) {
        this.dataProc = dataProc;
    }

    public void setObservingProgram(ObservingProgram observingProgram) {
        this.observingProgram = observingProgram;
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

    public String getTelescopeLoc() {
        return telescopeLoc;
    }

    public DataProc getDataProcRequirements() {
        return dataProc;
    }

    public ObservingProgram getObservingProgram() {
        return observingProgram;
    }
}
