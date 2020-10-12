package com.github.ChristopheCVB.EliteDangerous.events.datastorage.market;

import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Market {
    public Integer marketID;
    public String stationName, starSystem;
    public List<Item> items;

    public static Market load() {
        Market market = null;
        File file = GameFilesUtils.getMarketFile();
        if (file != null) {
            try {
                String marketFileContent = String.join("", Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
                market = new Gson().fromJson(marketFileContent, Market.class);
            }
            catch (IOException ignored) {}
        }

        return market;
    }
}
