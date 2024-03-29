package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.EliteDangerousAPI;
import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.utils.GameFiles;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ShipyardEvent extends Event {

  public Long marketID;
  public String stationName, starSystem;
  public Boolean horizons;
  public Boolean allowCobraMkIV;
  public List<PriceItem> priceList;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipyardEventTriggered((ShipyardEvent) event);
    }

    void onShipyardEventTriggered(ShipyardEvent shipyardEvent);
  }

  public static ShipyardEvent loadFromFile() {
    ShipyardEvent shipyardEvent = null;

    File shipyardFile = GameFiles.getExistingInstance().getShipyardFile();
    if (shipyardFile != null && shipyardFile.exists()) {
      try {
        shipyardEvent = EliteDangerousAPI.GSON.fromJson(
            String.join("", Files.readAllLines(shipyardFile.toPath(), StandardCharsets.UTF_8)),
            ShipyardEvent.class);
      } catch (IOException ignored) {
      }
    }

    return shipyardEvent;
  }

  public static class PriceItem {

    public Long id;
    public String shipType;
    public String shipTypeLocalised;
    public Long shipPrice;
  }
}
