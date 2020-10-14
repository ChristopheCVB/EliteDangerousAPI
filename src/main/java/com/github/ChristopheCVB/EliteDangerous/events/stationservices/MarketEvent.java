package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.EliteDangerousAPI;
import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.market.MarketItem;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class MarketEvent extends Event {
    public String stationName;
    public String starSystem;
    public String stationType;
    public String carrierDockingAccess;
    public Integer marketID;
    public List<MarketItem> items;

    public static MarketEvent loadFromFile() {
        MarketEvent marketEvent = null;

        File marketFile = GameFiles.getMarketFile();
        if (marketFile != null && marketFile.exists()) {
            try {
                marketEvent = EliteDangerousAPI.GSON.fromJson(String.join("", Files.readAllLines(marketFile.toPath(), StandardCharsets.UTF_8)), MarketEvent.class);
            }
            catch (IOException ignored) {}
        }

        return marketEvent;
    }

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMarketEventTriggered((MarketEvent) event);
        }

        void onMarketEventTriggered(MarketEvent marketEvent);
    }
}
