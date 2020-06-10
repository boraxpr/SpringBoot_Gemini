package com.gemini.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

import com.gemini.ocs.model.BaseObservingProgram;
import com.gemini.ocs.model.BaseSciencePlan;
import com.gemini.ocs.model.DataProcRequirement;
import jparsec.ephem.Target;


@Entity
public class SciencePlan {
    @Id
    private int planNo;

    private String creator;
    private String submitter;
    private double fundingInUSD;
    private String objectives;
    private String starSystem;
    private Date startDate;
    private Date endDate;
    private String telescopeLocation;
    private String dataProcRequirements;
    private String observingProgram;
    private String status;
}
