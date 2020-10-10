package com.github.ChristopheCVB.EliteDangerous.utils;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class EventDeserializer implements JsonDeserializer<Event> {
    String eventTypeElementName;
    Map<String, Class<? extends Event>> eventTypeRegistry;

    public EventDeserializer(String eventTypeElementName) {
        this.eventTypeElementName = eventTypeElementName;
        this.eventTypeRegistry = new HashMap<>();
    }

    public void registerEventType(String eventTypeName, Class<? extends Event> eventType) {
        this.eventTypeRegistry.put(eventTypeName, eventType);
    }

    @Override
    public Event deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Event event = null;
        JsonObject jsonEvent = json.getAsJsonObject();
        JsonElement eventTypeElement = jsonEvent.get(this.eventTypeElementName);
        String type = eventTypeElement.getAsString();
        Class<? extends Event> eventClass = this.eventTypeRegistry.get(type);
        if (eventClass != null) {
            event = context.deserialize(json, eventClass);
        }
        return event;
    }
}
