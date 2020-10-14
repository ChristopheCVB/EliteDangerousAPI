package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.EliteDangerousAPI;
import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class OutfittingEvent extends Event {
    public Long marketID;
    public String stationName, starSystem;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onOutfittingEventTriggered((OutfittingEvent) event);
        }

        void onOutfittingEventTriggered(OutfittingEvent outfittingEvent);
    }

    public static OutfittingEvent loadFromFile() {
        OutfittingEvent outfittingEvent = null;

        File outfittingFile = GameFiles.getOutfittingFile();
        if (outfittingFile != null && outfittingFile.exists()) {
            try {
                outfittingEvent = EliteDangerousAPI.GSON.fromJson(String.join("", Files.readAllLines(outfittingFile.toPath(), StandardCharsets.UTF_8)), OutfittingEvent.class);
            }
            catch (IOException ignored) {}
        }

        return outfittingEvent;
    }
}
