package com.github.ChristopheCVB.EliteDangerous.utils;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Mission;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredModule;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredShipHere;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredShipRemote;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.inventory.Transfer;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.AtmosphereComposition;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.Composition;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.Parent;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.Ring;
import com.github.ChristopheCVB.EliteDangerous.utils.exceptions.UnusedEventDataException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class GameFilesUtils {
    public static String getFileExtension(File file) {
        String extension = null;
        if (file != null) {
            String filename = file.getName();
            extension = Optional.of(filename)
                    .filter(f -> f.contains("."))
                    .map(f -> f.substring(filename.lastIndexOf(".") + 1))
                    .orElse(null);
        }
        return extension;
    }
    
    public static File getJournalDirectory() {
        return Paths.get(System.getProperty("user.home") + "/Saved Games/Frontier Developments/Elite Dangerous/").toFile();
    }

    public static File getLatestJournalFile() {
        File latest = null;

        File[] edFiles = GameFilesUtils.getJournalDirectory().listFiles();
        if (edFiles == null) {
            System.out.println("No PlayerJournals were found, waiting for game.");
        }
        else {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().contains("Journal") && getFileExtension(file).equals("log")) {
                        if (latest == null) {
                            latest = file;
                        }
                        else {
                            if (latest.lastModified() < file.lastModified()) {
                                latest = file;
                            }
                        }
                    }
                }
            }
        }

        return latest;
    }

    public static File getShipyardFile() {
        File shipyardFile = null;

        File[] edFiles = GameFilesUtils.getJournalDirectory().listFiles();
        if (edFiles != null) {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().contains("Shipyard")) {
                        shipyardFile = file;
                    }
                }
            }
        }

        return shipyardFile;
    }

    public static File getCargoFile() {
        File cargoFile = null;

        File[] edFiles = GameFilesUtils.getJournalDirectory().listFiles();
        if (edFiles != null) {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().contains("Cargo")) {
                        cargoFile = file;
                    }
                }
            }
        }

        return cargoFile;
    }

    public static File getMarketFile() {
        File marketFile = null;

        File[] edFiles = GameFilesUtils.getJournalDirectory().listFiles();
        if (edFiles != null) {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().contains("Market")) {
                        marketFile = file;
                    }
                }
            }
        }

        return marketFile;
    }

    public static File getModulesInfo() {
        File modulesInfoFile = null;

        File[] edFiles = GameFilesUtils.getJournalDirectory().listFiles();
        if (edFiles != null) {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().contains("ModulesInfo")) {
                        modulesInfoFile = file;
                    }
                }
            }
        }

        return modulesInfoFile;
    }

    public static File getOutfittingFile() {
        File outfittingFile = null;

        File[] edFiles = GameFilesUtils.getJournalDirectory().listFiles();
        if (edFiles != null) {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().contains("Outfitting")) {
                        outfittingFile = file;
                    }
                }
            }
        }

        return outfittingFile;
    }

    public static File getStatusFile() {
        File statusFile = null;

        File[] edFiles = GameFilesUtils.getJournalDirectory().listFiles();
        if (edFiles != null) {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().contains("Status")) {
                        statusFile = file;
                    }
                }
            }
        }

        return statusFile;
    }

    public static String getFormattedDate(long timestamp) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Date date = new Date(timestamp);
        return outputFormat.format(date);
    }

    public static void isAllEventDataProcessed(Event event, JsonObject jsonObject) {
        try {
            if (jsonObject.size() > 0) {
                throw new UnusedEventDataException();
            }
        }
        catch (UnusedEventDataException e) {
            sendUnusedEventData(event.getClass().getSimpleName(), jsonObject.toString());
        }
    }

    public static void sendUnprocessedEvent(String eventName, JsonObject jsonEvent) {
        System.out.println("UNPROCESSED EVENT: " + eventName + " with Json " + jsonEvent.toString());
    }

    private static void sendUnusedEventData(String eventName, String s) {
        System.out.println("UNUSED DATA: " + eventName + " with Data " + s);
    }

    public static long getTimeMillis(String timestamp) {
        long millis = 0;

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            millis = inputFormat.parse(timestamp).getTime();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return millis;
    }

    public static List<com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.Material> createMaterialList(JsonArray array) {
        List<com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.Material> materials = null;

        if (array != null) {
            materials = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                materials.add(new com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.Material(JsonUtils.pullString(json, "Name"), JsonUtils.pullDouble(json, "Percent")));

            }
        }

        return materials;
    }

    public static List<Parent> createParentList(JsonArray array) {
        List<Parent> parents = null;

        if (array != null) {
            parents = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                for (String s : json.keySet()) {

                    parents.add(new Parent(s, json.get(s).getAsInt()));
                }
            }
        }

        return parents;
    }

    public static List<Ring> createRingsList(JsonArray array) {
        List<Ring> rings = null;

        if (array != null) {
            rings = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                rings.add(new Ring(JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "RingClass"), JsonUtils.pullLong(json, "MassMT"), JsonUtils.pullLong(json, "InnerRad"), JsonUtils.pullLong(json, "OuterRad")));
            }
        }

        return rings;
    }

    public static List<Composition> createCompositionList(JsonObject jsonObject) {
        List<Composition> compositions = null;

        if (jsonObject != null) {
            compositions = new ArrayList<>();

            for (String s : jsonObject.keySet()) {
                compositions.add(new Composition(s, jsonObject.get(s).getAsDouble()));
            }
        }

        return compositions;
    }

    public static List<AtmosphereComposition> createAtmosphereCompositionList(JsonArray array) {
        List<AtmosphereComposition> atmosphereCompositions = null;

        if (array != null) {
            atmosphereCompositions = new ArrayList<>();

            for (JsonElement comp : array) {
                JsonObject obj = comp.getAsJsonObject();

                atmosphereCompositions.add(new AtmosphereComposition(JsonUtils.pullString(obj, "Name"), JsonUtils.pullDouble(obj, "Percent")));
            }
        }

        return atmosphereCompositions;
    }

    public static List<Transfer> createTransferList(JsonArray array) {
        List<Transfer> transferList = null;

        if (array != null) {
            transferList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();

                transferList.add(new Transfer(JsonUtils.pullString(json, "Type"), JsonUtils.pullString(json, "Type_Localised"), JsonUtils.pullString(json, "Direction"), JsonUtils.pullInt(json, "Count")));
            }
        }
        return transferList;
    }
}
