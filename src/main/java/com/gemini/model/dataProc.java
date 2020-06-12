package com.gemini.model;

import com.gemini.ocs.model.DataProcRequirement;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class dataProc extends DataProcRequirement {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    public dataProc(){
        super();
    }
}
