package com.github.ChristopheCVB.EliteDangerous.utils.deserializer;

import com.github.ChristopheCVB.EliteDangerous.models.scan.Parent;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ParentDeserializer implements JsonDeserializer<Parent> {
    @Override
    public Parent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Parent parent = null;

        JsonObject jsonParent = json.getAsJsonObject();
        for (String s : jsonParent.keySet()) {
            parent = new Parent(s, jsonParent.get(s).getAsInt());
            break;
        }

        return parent;
    }
}
