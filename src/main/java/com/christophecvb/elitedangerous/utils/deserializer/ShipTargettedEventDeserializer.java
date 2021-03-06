package com.christophecvb.elitedangerous.utils.deserializer;

import com.christophecvb.elitedangerous.events.combat.*;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ShipTargettedEventDeserializer implements JsonDeserializer<ShipTargettedEvent> {
    @Override
    public ShipTargettedEvent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ShipTargettedEvent event = null;

        JsonObject jsonEvent = json.getAsJsonObject();
        boolean targetLocked = jsonEvent.get("TargetLocked").getAsBoolean();
        if (!targetLocked) {
            event = context.deserialize(json, ShipTargettedEvent.class);
        }
        else {
            int scanStage = jsonEvent.get("ScanStage").getAsInt();
            switch (scanStage) {
                case 0:
                    event = context.deserialize(json, ShipTargettedStage0Event.class);
                    break;

                case 1:
                    event = context.deserialize(json, ShipTargettedStage1Event.class);
                    break;

                case 2:
                    event = context.deserialize(json, ShipTargettedStage2Event.class);
                    break;

                case 3:
                    event = context.deserialize(json, ShipTargettedStage3Event.class);
                    break;
            }
        }

        return event;
    }
}
