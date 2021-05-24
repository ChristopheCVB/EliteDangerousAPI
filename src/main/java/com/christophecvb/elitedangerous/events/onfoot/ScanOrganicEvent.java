package com.christophecvb.elitedangerous.events.onfoot;

import com.christophecvb.elitedangerous.events.Event;

public class ScanOrganicEvent extends Event {
    public ScanType scanType;
    public String genus;
    public String species;
    public Long systemAddress;
    public Long body;

    public enum ScanType {
        Log,
        Sample,
        Analyse
    }
}
