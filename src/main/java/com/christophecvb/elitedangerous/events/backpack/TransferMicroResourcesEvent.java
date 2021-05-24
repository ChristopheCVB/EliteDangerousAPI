package com.christophecvb.elitedangerous.events.backpack;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.MicroResource;

import java.util.ArrayList;

public class TransferMicroResourcesEvent extends Event {
    public ArrayList<transfer> transfers;

    public static class transfer extends MicroResource {
        public String direction;
    }
}
