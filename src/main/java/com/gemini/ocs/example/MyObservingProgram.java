/*
 * Copyright (c) 2020. Chaiyong Ragkhitwetsagul
 * All rights reserved.
 */

package com.gemini.ocs.example;

import com.gemini.ocs.model.BaseObservingProgram;

public class MyObservingProgram extends BaseObservingProgram {
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
