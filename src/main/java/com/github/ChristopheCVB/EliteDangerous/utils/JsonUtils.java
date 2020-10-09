package com.github.ChristopheCVB.EliteDangerous.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtils {
    public static String pullString(JsonObject jsonObject, String memberName) {
        String value = null;
        if (jsonObject != null) {
            JsonElement jsonValue = jsonObject.remove(memberName);
            if (jsonValue != null) {
                value = jsonValue.getAsString();
            }
        }
        return value;
    }

    public static Integer pullInt(JsonObject jsonObject, String memberName) {
        Integer value = null;
        if (jsonObject != null) {
            JsonElement jsonValue = jsonObject.remove(memberName);
            if (jsonValue != null) {
                value = jsonValue.getAsInt();
            }
        }
        return value;
    }

    public static JsonArray pullJsonArray(JsonObject jsonObject, String memberName) {
        JsonArray value = null;
        if (jsonObject != null) {
            JsonElement jsonValue = jsonObject.remove(memberName);
            if (jsonValue != null) {
                value = jsonValue.getAsJsonArray();
            }
        }
        return value;
    }

    public static JsonObject pullJsonObject(JsonObject jsonObject, String memberName) {
        JsonObject value = null;
        if (jsonObject != null) {
            JsonElement jsonValue = jsonObject.remove(memberName);
            if (jsonValue != null) {
                value = jsonValue.getAsJsonObject();
            }
        }
        return value;
    }

    public static Long pullLong(JsonObject jsonObject, String memberName) {
        Long value = null;
        if (jsonObject != null) {
            JsonElement jsonValue = jsonObject.remove(memberName);
            if (jsonValue != null) {
                value = jsonValue.getAsLong();
            }
        }
        return value;
    }

    public static Double pullDouble(JsonObject jsonObject, String memberName) {
        Double value = null;
        if (jsonObject != null) {
            JsonElement jsonValue = jsonObject.remove(memberName);
            if (jsonValue != null) {
                value = jsonValue.getAsDouble();
            }
        }
        return value;
    }

    public static Boolean pullBoolean(JsonObject jsonObject, String memberName) {
        Boolean value = null;
        if (jsonObject != null) {
            JsonElement jsonValue = jsonObject.remove(memberName);
            if (jsonValue != null) {
                value = jsonValue.getAsBoolean();
            }
        }
        return value;
    }
}
