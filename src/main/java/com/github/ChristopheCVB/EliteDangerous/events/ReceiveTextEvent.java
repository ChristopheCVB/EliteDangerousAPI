package com.github.ChristopheCVB.EliteDangerous.events;

import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ReceiveTextEvent extends Event {
    private String from, fromLocalized, message, messageLocalized, channel;

    public ReceiveTextEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.from = JsonUtils.pullString(jsonEvent, "From");
        this.fromLocalized = JsonUtils.pullString(jsonEvent, "From_Localised");
        this.message = JsonUtils.pullString(jsonEvent, "Message");
        this.messageLocalized = JsonUtils.pullString(jsonEvent, "Message_Localised");
        this.channel = JsonUtils.pullString(jsonEvent, "Channel");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }
}
