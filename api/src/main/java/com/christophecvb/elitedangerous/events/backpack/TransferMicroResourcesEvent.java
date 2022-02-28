package com.christophecvb.elitedangerous.events.backpack;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.MicroResource;

import java.util.List;

public class TransferMicroResourcesEvent extends Event {
    public List<MicroResourceTransfer> transfers;

    public static class MicroResourceTransfer extends MicroResource {
        public String direction;
    }
}
