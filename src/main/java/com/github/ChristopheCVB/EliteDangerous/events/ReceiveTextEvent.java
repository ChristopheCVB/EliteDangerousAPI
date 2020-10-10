package com.github.ChristopheCVB.EliteDangerous.events;

import com.google.gson.annotations.SerializedName;

public class ReceiveTextEvent extends Event {
    public String from;
    @SerializedName("From_Localised")
    public String fromLocalized;
    public String message;
    @SerializedName("Message_Localised")
    public String messageLocalized;
    public String channel;

    public ReceiveTextEvent(String timestamp) {
        super(timestamp);
    }
}
