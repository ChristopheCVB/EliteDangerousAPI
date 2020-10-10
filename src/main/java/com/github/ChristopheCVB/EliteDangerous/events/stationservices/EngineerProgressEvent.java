package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.EngineerProgress;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.EngineerProgressStartup;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.EngineerProgressUpdate;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.EngineerProgressInfo;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class EngineerProgressEvent extends Event {

    public String engineer;
    public String progress;
    public Integer engineerId;
    public Integer rank;
    public Double rankProgress;
    public JsonArray engineersArray;

    public EngineerProgressEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        if (jsonEvent.has("Engineers")) {
            this.engineersArray = JsonUtils.pullJsonArray(jsonEvent, "Engineers");
        }
        else {
            this.engineer = JsonUtils.pullString(jsonEvent, "Engineer");
            this.progress = JsonUtils.pullString(jsonEvent, "Progress");
            this.engineerId = JsonUtils.pullInt(jsonEvent, "EngineerID");
            this.rank = JsonUtils.pullInt(jsonEvent, "Rank");
            this.rankProgress = JsonUtils.pullDouble(jsonEvent, "RankProgress");
        }

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

    public EngineerProgressInfo getEngineerProgressInfo() {
        if (engineersArray != null) {
            return new EngineerProgressStartup(GameFilesUtils.createEngineerProgressList(engineersArray));
        }
        return new EngineerProgressUpdate(new EngineerProgress(engineer, progress, engineerId, rank, rankProgress));
    }

}
