package com.github.ChristopheCVB.EliteDangerous.events.datastorage.market;

import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MarketFile {

    public Integer marketID;
    public String stationName, starSystem;
    public ArrayList<Item> items;

    public MarketFile() {
        File file = GameFilesUtils.getMarketFile();
        if (file != null) {
            try {
                String marketFileContent = String.join("", Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
                // TODO: idk how to do this with the createItemList
                this.items = GameFilesUtils.createItemList(JsonParser.parseString(marketFileContent).getAsJsonObject().getAsJsonArray("Items"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer getMarketID() {
        return marketID;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStarSystem() {
        return starSystem;
    }

    public List<Item> getItems() {
        return items;
    }

}
