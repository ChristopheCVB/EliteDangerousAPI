package com.github.ChristopheCVB.EliteDangerous.events;

import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MusicEvent extends Event {

    private String musicTrack;

    public MusicEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.musicTrack = JsonUtils.pullString(jsonEvent, "MusicTrack");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

    public String getMusicTrack() {
        return this.musicTrack;
    }
}
