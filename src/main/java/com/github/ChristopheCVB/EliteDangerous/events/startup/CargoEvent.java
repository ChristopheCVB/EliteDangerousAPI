package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.CargoItem;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class CargoEvent extends Event {
    public String vessel;
    public Integer count;
    public List<CargoItem> inventory;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCargoEventTriggered((CargoEvent) event);
        }

        void onCargoEventTriggered(CargoEvent cargoEvent);
    }

    public CargoEvent loadFromFile() {
        CargoEvent cargoEvent = this;

        if (this.inventory == null) {
            File cargoFile = GameFilesUtils.getCargoFile();
            if (cargoFile != null && cargoFile.exists()) {
                try {
                    cargoEvent = new Gson().fromJson(String.join("", Files.readAllLines(cargoFile.toPath(), StandardCharsets.UTF_8)), CargoEvent.class);
                }
                catch (IOException ignored) {}
            }
        }

        return cargoEvent;
    }
}
