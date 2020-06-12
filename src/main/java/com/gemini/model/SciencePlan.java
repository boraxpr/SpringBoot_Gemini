package com.gemini.model;

import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicUpdate
public class SciencePlan {
    private static AtomicInteger count = new AtomicInteger(0);
    private String creator;
    private double fundingInUSD;
    private String objectives;
    private String starSystem;
    private Date startDate;
    private Date endDate;
    private String telescopeLocation;
    private String status;
    private Boolean validated;

    @OneToOne(cascade=CascadeType.ALL)
    ObservingProgram observingProgram;

    @OneToOne(cascade=CascadeType.ALL)
    DataProc dataProcRequirements;
    @Id
    private int planNo;

    public SciencePlan(String creator
            , double fundingInUSD
            , String objectives, String starSystem
            , Date startDate, Date endDate
            , String telescopeLocation, DataProc dataProcRequirements
            , ObservingProgram observingProgram, String status){
        this.creator = creator;
        this.fundingInUSD = fundingInUSD;
        this.objectives = objectives;
        this.starSystem = starSystem;
        this.startDate = startDate;
        this.endDate = endDate;
        this.telescopeLocation = telescopeLocation;
        this.dataProcRequirements = dataProcRequirements;
        this.observingProgram = observingProgram;
        this.status = status;
        this.validated = Boolean.FALSE;
        this.planNo = count.incrementAndGet();
    }
    public SciencePlan(){}

    //    When humanValidation and checking with OCS are True
    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

//    To check enum
    public String getTelescopeLocation() {
        return telescopeLocation;
    }
    
//    To check enum
    public String getStatus() {
        return status;
    }
//    To check enum
    public String getStarSystem() {
        return starSystem;
    }

    public String getCreator() {
        return creator;
    }

    public double getFundingInUSD() {
        return fundingInUSD;
    }

    public String getObjectives() {
        return objectives;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Boolean getValidated() {
        return validated;
    }

    public ObservingProgram getObservingProgram() {
        return observingProgram;
    }

    public DataProc getDataProcRequirements() {
        return dataProcRequirements;
    }

    public int getPlanNo() {
        return planNo;
    }
}
