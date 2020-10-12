package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.market.MarketItem;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.Gson;

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
        MarketEvent market = null;

        File marketFile = GameFilesUtils.getMarketFile();
        if (marketFile != null && marketFile.exists()) {
            try {
                market = new Gson().fromJson(String.join("", Files.readAllLines(marketFile.toPath(), StandardCharsets.UTF_8)), MarketEvent.class);
            }
            catch (IOException ignored) {}
        }

        return market;
    }

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMarketEventTriggered((MarketEvent) event);
        }

        void onMarketEventTriggered(MarketEvent marketEvent);
    }
}
