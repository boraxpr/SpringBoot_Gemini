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

    public dataProc(String fileType, double fileQuality
            , String COLOR_TYPE, double contrast
            , double brightness, double saturation){
        super(DataProcRequirement.TYPE.valueOf(fileType)
                , fileQuality
                , DataProcRequirement.COLOR_TYPE.valueOf(COLOR_TYPE)
                , contrast, brightness, saturation);
    }
}
