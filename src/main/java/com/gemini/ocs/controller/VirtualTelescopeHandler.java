/*
 * Copyright (c) 2020. Chaiyong Ragkhitwetsagul
 * All rights reserved.
 */

package com.gemini.ocs.controller;

import com.gemini.ocs.model.VirtualTelescope;

public class VirtualTelescopeHandler {
    private static VirtualTelescope vt1;
    private static VirtualTelescope vt2;

    public static VirtualTelescope getVirtualTelescope(String name) {
        if (name == VirtualTelescope.NORTH) {
            return vt1.getInstance();
        } else {
            return vt2.getInstance();
        }
    }
}
