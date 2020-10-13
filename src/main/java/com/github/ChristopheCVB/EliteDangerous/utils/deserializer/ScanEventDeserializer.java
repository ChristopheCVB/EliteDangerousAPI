package com.github.ChristopheCVB.EliteDangerous.utils.deserializer;

import com.github.ChristopheCVB.EliteDangerous.events.exploration.ScanEvent;
import com.github.ChristopheCVB.EliteDangerous.events.exploration.ScanPlanetOrMoonEvent;
import com.github.ChristopheCVB.EliteDangerous.events.exploration.ScanStarEvent;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ScanEventDeserializer implements JsonDeserializer<ScanEvent> {
    @Override
    public ScanEvent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ScanEvent event;

        JsonObject jsonEvent = json.getAsJsonObject();
        if (jsonEvent.has("StarType")) {
            event = context.deserialize(json, ScanStarEvent.class);
        }
        else {
            event = context.deserialize(json, ScanPlanetOrMoonEvent.class);
        }

        return event;
    }
}
