package com.christophecvb.elitedangerous.utils.deserializer;

import com.christophecvb.elitedangerous.events.combat.DiedByPVPEvent;
import com.christophecvb.elitedangerous.events.combat.DiedByWingEvent;
import com.christophecvb.elitedangerous.events.combat.DiedEvent;
import com.google.gson.*;

import java.lang.reflect.Type;

public class DiedEventDeserializer implements JsonDeserializer<DiedEvent> {
    @Override
    public DiedEvent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        DiedEvent event;

        JsonObject jsonEvent = json.getAsJsonObject();
        if (jsonEvent.has("Killers")) {
            event = context.deserialize(json, DiedByPVPEvent.class);
        }
        else {
            event = context.deserialize(json, DiedByWingEvent.class);
        }

        return event;
    }
}
