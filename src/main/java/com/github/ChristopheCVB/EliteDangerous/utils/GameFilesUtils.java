package com.github.ChristopheCVB.EliteDangerous.utils;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.*;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.FactionBounty;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.EngineerProgress;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.Ingredient;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.inventory.Transfer;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.market.Item;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Encoded;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Manufactured;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Raw;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.*;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.station.Discovered;
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

    //EventData Generators
    public static List<Item> createItemList(JsonArray array) {
        List<Item> itemsList = null;

        if (array != null) {
            itemsList = new ArrayList<>();

            for (JsonElement comp : array) {
                JsonObject json = comp.getAsJsonObject();

                Item item = new Item(JsonUtils.pullInt(json, "id"), JsonUtils.pullInt(json, "BuyPrice"), JsonUtils.pullInt(json, "SellPrice"), JsonUtils.pullInt(json, "MeanPrice"), JsonUtils.pullInt(json, "StockBracket"), JsonUtils.pullInt(json, "DemandBracket"),
                        JsonUtils.pullInt(json, "Stock"), JsonUtils.pullInt(json, "Demand"), JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "Category"), JsonUtils.pullBoolean(json, "Consumer"), JsonUtils.pullBoolean(json, "Producer"), JsonUtils.pullBoolean(json, "Rare"));

                itemsList.add(item);
            }
        }

        return itemsList;
    }

    public static List<EngineerProgress> createEngineerProgressList(JsonArray array) {
        List<EngineerProgress> engineerProgressList = null;

        if (array != null) {
            engineerProgressList = new ArrayList<>();

            for (JsonElement comp : array) {
                JsonObject json = comp.getAsJsonObject();

                EngineerProgress engineerProgress = new EngineerProgress(JsonUtils.pullString(json, "Engineer"), JsonUtils.pullString(json, "Progress"), JsonUtils.pullInt(json, "Rank"), JsonUtils.pullInt(json, "EngineerID"), JsonUtils.pullDouble(json, "RankProgress"));

                engineerProgressList.add(engineerProgress);
            }
        }

        return engineerProgressList;
    }

    public static List<Ingredient> createIngredientsList(JsonArray array) {
        List<Ingredient> ingredients = null;

        if (array != null) {
            ingredients = new ArrayList<>();

            for (JsonElement comp : array) {
                Ingredient ingredient;
                JsonObject json = comp.getAsJsonObject();

                ingredient = new Ingredient(JsonUtils.pullString(json, "Name"), JsonUtils.pullInt(json, "Count"));

                ingredients.add(ingredient);
            }
        }

        return ingredients;
    }

    public static List<Material> createMaterialList(JsonArray array) {
        List<Material> materials = null;

        if (array != null) {
            materials = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                materials.add(new Material(JsonUtils.pullString(json, "Name"), JsonUtils.pullDouble(json, "Percent")));

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

    public static String[] createTraitsList(JsonArray array) {
        String[] traits = null;

        if (array != null) {
            traits = new String[array.size()];

            int arrayPos = 0;

            for (JsonElement trait : array) {
                traits[arrayPos] = trait.getAsString();
                arrayPos++;
            }
        }

        return traits;
    }

    public static Double[] createPositionArray(JsonArray array) {
        Double[] pos = null;

        if (array != null) {
            pos = new Double[array.size()];

            int arrayPos = 0;
            for (JsonElement num : array) {
                pos[arrayPos] = num.getAsDouble();
                arrayPos++;
            }
        }

        return pos;
    }

    public static List<String> createPowersArray(JsonArray array) {
        List<String> powers = null;

        if (array != null) {
            powers = new ArrayList<>();

            for (JsonElement power : array) {
                powers.add(power.getAsString());
            }
        }

        return powers;
    }

    public static List<PassengerManifest> createPassengerManifest(JsonArray array) {
        List<PassengerManifest> passengers = null;

        if (array != null) {
            passengers = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();

                passengers.add(new PassengerManifest(JsonUtils.pullString(json, "Type"), JsonUtils.pullInt(json, "Count"), JsonUtils.pullBoolean(json, "VIP"), JsonUtils.pullBoolean(json, "Wanted"), JsonUtils.pullLong(json, "MissionID")));
            }
        }

        return passengers;
    }

    public static List<StationEconomy> createStationEconomiesList(JsonArray array) {
        List<StationEconomy> stationEconomiesList = null;

        if (array != null) {
            stationEconomiesList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                StationEconomy stationEconomy = new StationEconomy(JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "Name_Localised"), JsonUtils.pullDouble(json, "Proportion"));

                stationEconomiesList.add(stationEconomy);

            }
        }

        return stationEconomiesList;
    }

    public static List<Module> createModuleList(JsonArray array) {
        List<Module> modules = null;

        if (array != null) {
            modules = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                Module module;

                if (json.has("Engineering")) {
                    JsonObject engineer = JsonUtils.pullJsonObject(json, "Engineering");
                    module = new Module(JsonUtils.pullString(json, "Slot"), JsonUtils.pullString(json, "Item"), JsonUtils.pullBoolean(json, "On"), JsonUtils.pullInt(json, "Priority"),
                            JsonUtils.pullInt(json, "AmmoInClip"), JsonUtils.pullInt(json, "AmmoInHopper"), JsonUtils.pullDouble(json, "Health"),
                            new Engineering(JsonUtils.pullString(engineer, "Engineer"), JsonUtils.pullString(engineer, "BlueprintName"), JsonUtils.pullString(engineer, "ExperimentalEffect"),
                                    JsonUtils.pullString(engineer, "ExperimentalEffect_Localised"), JsonUtils.pullInt(engineer, "EngineerID"),
                                    JsonUtils.pullInt(engineer, "BlueprintID"), JsonUtils.pullInt(engineer, "Level"),
                                    JsonUtils.pullDouble(engineer, "Quality"), createModifierList(JsonUtils.pullJsonArray(engineer, "Modifiers"))));
                }
                else {
                    module = new Module(JsonUtils.pullString(json, "Slot"), JsonUtils.pullString(json, "Item"), JsonUtils.pullBoolean(json, "On"), JsonUtils.pullInt(json, "Priority"), JsonUtils.pullInt(json, "AmmoInClip"),
                            JsonUtils.pullInt(json, "AmmoInHopper"), JsonUtils.pullDouble(json, "Health"));
                }

                modules.add(module);
            }
        }

        return modules;
    }

    public static List<Mission> createMissionList(JsonArray array) {
        List<Mission> missions = null;

        if (array != null) {
            missions = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();

                missions.add(new Mission(JsonUtils.pullInt(json, "MissionID"), JsonUtils.pullString(json, "Name"), JsonUtils.pullBoolean(json, "PassengerMission"), JsonUtils.pullInt(json, "Expires")));
            }
        }

        return missions;
    }

    public static List<Modifier> createModifierList(JsonArray array) {
        List<Modifier> modifier = null;

        if (array != null) {
            modifier = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                Modifier mod;

                mod = new Modifier(JsonUtils.pullString(json, "Label"), JsonUtils.pullDouble(json, "Value"), JsonUtils.pullDouble(json, "OriginalValue"), JsonUtils.pullInt(json, "LessIsGood"));

                modifier.add(mod);
            }
        }

        return modifier;
    }

    public static List<Raw> createRawMaterialList(JsonArray array) {
        List<Raw> raw = null;

        if (array != null) {
            raw = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                Raw rawMat;

                rawMat = new Raw(JsonUtils.pullString(json, "Name"), JsonUtils.pullInt(json, "Count"));

                raw.add(rawMat);
            }
        }

        return raw;
    }

    public static List<Manufactured> createManufacturedMaterialList(JsonArray array) {
        List<Manufactured> manufactured = null;

        if (array != null) {
            manufactured = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                Manufactured manufacturedMat;

                manufacturedMat = new Manufactured(JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "Name_Localised"), JsonUtils.pullInt(json, "Count"));

                manufactured.add(manufacturedMat);
            }
        }

        return manufactured;
    }

    public static List<Encoded> createEncodedMaterialList(JsonArray array) {
        List<Encoded> encoded = null;

        if (array != null) {
            encoded = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                Encoded encodedMat;

                encodedMat = new Encoded(JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "Name_Localised"), JsonUtils.pullInt(json, "Count"));

                encoded.add(encodedMat);
            }
        }

        return encoded;
    }

    public static List<CargoInventory> createCargoInventory(JsonArray jsonArray) {
        List<CargoInventory> inv = null;

        if (jsonArray != null) {
            inv = new ArrayList<>();

            for (JsonElement jsonElement : jsonArray) {
                JsonObject json = jsonElement.getAsJsonObject();
                CargoInventory cargoInv;

                if (!json.has("MissionID")) {
                    String name = JsonUtils.pullString(json, "Name");
                    int count = JsonUtils.pullInt(json, "Count");
                    int stolen = JsonUtils.pullInt(json, "Stolen");
                    if (json.has("Name_Localised")) {
                        name = JsonUtils.pullString(json, "Name_Localised");
                    }

                    cargoInv = new CargoInventory(name, count, stolen);
                }
                else {
                    String name = JsonUtils.pullString(json, "Name");
                    int count = JsonUtils.pullInt(json, "Count");
                    int stolen = JsonUtils.pullInt(json, "Stolen");
                    int missionId = JsonUtils.pullInt(json, "MissionID");
                    if (json.has("Name_Localised")) {
                        name = JsonUtils.pullString(json, "Name_Localised");
                    }

                    cargoInv = new CargoInventory(name, count, stolen, missionId);
                }

                inv.add(cargoInv);
            }
        }

        return inv;
    }

    public static List<ModuleItem> createModuleItemsList(JsonArray array) {
        List<ModuleItem> itemList = null;

        if (array != null) {
            itemList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                String slot = JsonUtils.pullString(json, "Slot");
                String name = JsonUtils.pullString(json, "Name");
                String nameLocalised = JsonUtils.pullString(json, "Name_Localised");
                Boolean hot = JsonUtils.pullBoolean(json, "Hot");
                String engineerModifications = JsonUtils.pullString(json, "EngineerModifications");
                Integer engineeredLevel = JsonUtils.pullInt(json, "Level");
                Double quality = JsonUtils.pullDouble(json, "Quality");

                itemList.add(new ModuleItem(slot, name, nameLocalised, engineerModifications, hot, engineeredLevel, quality));
            }
        }

        return itemList;
    }

    public static TradeData createTradeData(JsonObject json) {
        return json != null ? new TradeData(JsonUtils.pullString(json, "Material"), JsonUtils.pullString(json, "Material_Localised"), JsonUtils.pullString(json, "Category"), JsonUtils.pullString(json, "Category_Localised"), JsonUtils.pullInt(json, "Quantity")) : null;
    }

    public static List<FactionBounty> createFactionBountyList(JsonArray array) {
        List<FactionBounty> factionBountyList = null;

        if (array != null) {
            factionBountyList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                factionBountyList.add(new FactionBounty(JsonUtils.pullString(json, "Faction"), JsonUtils.pullLong(json, "Amount")));
            }
        }

        return factionBountyList;
    }

    public static List<StoredModule> createStoredModuleList(JsonArray array) {
        List<StoredModule> storedModuleList = null;

        if (array != null) {
            storedModuleList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                storedModuleList.add(new StoredModule(JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "Name_Localised"), JsonUtils.pullString(json, "StarSystem"), JsonUtils.pullInt(json, "StorageSlot"), JsonUtils.pullLong(json, "MarketID"),
                        JsonUtils.pullLong(json, "TransferCost"), JsonUtils.pullLong(json, "TransferTime"), JsonUtils.pullLong(json, "BuyPrice"), JsonUtils.pullBoolean(json, "Hot")));
            }
        }

        return storedModuleList;
    }

    public static List<String> createStationServiceList(JsonArray array) {
        List<String> stationServiceList = null;

        if (array != null) {
            stationServiceList = new ArrayList<>();

            for (Object str : array) {
                stationServiceList.add(str.toString());
            }
        }
        return stationServiceList;
    }

    public static List<Faction> createFactionsList(JsonArray array) {
        List<Faction> factionsList = null;

        if (array != null) {
            factionsList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                JsonArray activeStatesArray = JsonUtils.pullJsonArray(json, "ActiveStates");
                JsonArray recoveringStatesArray = JsonUtils.pullJsonArray(json, "RecoveringStates");
                JsonArray pendingStatesArray = JsonUtils.pullJsonArray(json, "PendingStates");

                factionsList.add(new Faction(JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "FactionState"), JsonUtils.pullString(json, "Government"), JsonUtils.pullString(json, "Allegiance"), JsonUtils.pullString(json, "Happiness"),
                        JsonUtils.pullDouble(json, "MyReputation"), JsonUtils.pullDouble(json, "Influence"), GameFilesUtils.createFactionStates(activeStatesArray), GameFilesUtils.createFactionStates(pendingStatesArray),
                        GameFilesUtils.createFactionStates(recoveringStatesArray), JsonUtils.pullBoolean(json, "SquadronSystem"), JsonUtils.pullBoolean(json, "HappiestSystem"), JsonUtils.pullBoolean(json, "HomeSystem")));
            }
        }

        return factionsList;
    }

    private static FactionState createFactionStates(JsonArray array) {
        if (array != null) {
            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();
                return new FactionState(JsonUtils.pullString(json, "State"), JsonUtils.pullDouble(json, "Trend"));
            }
        }
        return null;
    }

    public static Conflict createConflict(JsonArray array) {
        if (array == null) {
            return null;
        }

        List<ConflicFaction> conflictFactionList = new ArrayList<>();

        JsonObject json = array.get(0).getAsJsonObject();
        JsonObject faction1 = JsonUtils.pullJsonObject(json, "Faction1");
        JsonObject faction2 = JsonUtils.pullJsonObject(json, "Faction2");

        String status = JsonUtils.pullString(json, "Status");
        String warType = JsonUtils.pullString(json, "WarType");

        ConflicFaction cf1 = new ConflicFaction(JsonUtils.pullString(faction1, "Name"), JsonUtils.pullString(faction1, "Stake"), JsonUtils.pullInt(faction1, "WonDays"));
        ConflicFaction cf2 = new ConflicFaction(JsonUtils.pullString(faction2, "Name"), JsonUtils.pullString(faction2, "Stake"), JsonUtils.pullInt(faction2, "WonDays"));

        conflictFactionList.add(cf1);
        conflictFactionList.add(cf2);

        return new Conflict(status, warType, conflictFactionList);
    }

    public static List<StoredShipHere> createStoredShipsHereList(JsonArray array) {
        List<StoredShipHere> storedShipHereList = null;

        if (array != null) {
            storedShipHereList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();

                storedShipHereList.add(new StoredShipHere(JsonUtils.pullBoolean(json, "Hot"), JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "ShipType"), JsonUtils.pullString(json, "ShipType_Localised"),
                        JsonUtils.pullLong(json, "Value"), JsonUtils.pullInt(json, "ShipID")));
            }
        }

        return storedShipHereList;
    }

    public static List<StoredShipRemote> createStoredShipsRemoteList(JsonArray array) {
        List<StoredShipRemote> storedShipRemoteList = null;

        if (array != null) {
            storedShipRemoteList = new ArrayList<>();

            for (JsonElement o : array) {
                JsonObject json = o.getAsJsonObject();

                storedShipRemoteList.add(new StoredShipRemote(JsonUtils.pullBoolean(json, "Hot"), JsonUtils.pullString(json, "Name"), JsonUtils.pullString(json, "ShipType"), JsonUtils.pullString(json, "ShipType_Localised"),
                        JsonUtils.pullString(json, "StarSystem"), JsonUtils.pullLong(json, "Value"), JsonUtils.pullLong(json, "ShipMarketID"), JsonUtils.pullLong(json, "TransferTime"), JsonUtils.pullLong(json, "TransferPrice"), JsonUtils.pullInt(json, "ShipID")));
            }
        }

        return storedShipRemoteList;
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
