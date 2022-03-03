package com.christophecvb.elitedangerous.utils.deserializer;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
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

  public void registerEventType(Class<? extends Event> eventType) {
    this.eventTypeRegistry.put(eventType.getSimpleName().replaceFirst("Event$", ""), eventType);
  }

  @Override
  public Event deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
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
