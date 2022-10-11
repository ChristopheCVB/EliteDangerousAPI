package com.christophecvb.elitedangerous.utils.deserializer;

import com.christophecvb.elitedangerous.events.combat.ShipTargetedEvent;
import com.christophecvb.elitedangerous.events.combat.ShipTargetedStage0Event;
import com.christophecvb.elitedangerous.events.combat.ShipTargetedStage1Event;
import com.christophecvb.elitedangerous.events.combat.ShipTargetedStage2Event;
import com.christophecvb.elitedangerous.events.combat.ShipTargetedStage3Event;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ShipTargetedEventDeserializer implements JsonDeserializer<ShipTargetedEvent> {

  @Override
  public ShipTargetedEvent deserialize(JsonElement json, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    ShipTargetedEvent event = null;

    JsonObject jsonEvent = json.getAsJsonObject();
    boolean targetLocked = jsonEvent.get("TargetLocked").getAsBoolean();
    if (!targetLocked) {
      event = context.deserialize(json, ShipTargetedEvent.class);
    } else {
      int scanStage = jsonEvent.get("ScanStage").getAsInt();
      switch (scanStage) {
        case 0:
          event = context.deserialize(json, ShipTargetedStage0Event.class);
          break;

        case 1:
          event = context.deserialize(json, ShipTargetedStage1Event.class);
          break;

        case 2:
          event = context.deserialize(json, ShipTargetedStage2Event.class);
          break;

        case 3:
          event = context.deserialize(json, ShipTargetedStage3Event.class);
          break;
      }
    }

    return event;
  }
}
