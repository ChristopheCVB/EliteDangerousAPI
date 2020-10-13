package com.github.ChristopheCVB.EliteDangerous.utils.deserializer;

import com.github.ChristopheCVB.EliteDangerous.events.combat.BountyDefaultEvent;
import com.github.ChristopheCVB.EliteDangerous.events.combat.BountyEvent;
import com.github.ChristopheCVB.EliteDangerous.events.combat.BountySkimmerEvent;
import com.google.gson.*;

import java.lang.reflect.Type;

public class BountyEventDeserializer implements JsonDeserializer<BountyEvent> {
    @Override
    public BountyEvent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BountyEvent event;

        JsonObject jsonEvent = json.getAsJsonObject();
        if (jsonEvent.has("Target") && jsonEvent.get("Target").getAsString().equals("Skimmer")) {
            event = context.deserialize(json, BountySkimmerEvent.class);
        }
        else {
            event = context.deserialize(json, BountyDefaultEvent.class);
        }

        return event;
    }
}
