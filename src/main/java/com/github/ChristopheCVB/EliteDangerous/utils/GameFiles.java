package com.github.ChristopheCVB.EliteDangerous.utils;

import com.google.gson.JsonObject;

import java.io.File;
import java.nio.file.Paths;
import java.util.Optional;

public class GameFiles {
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

    public static File getDirectory() {
        return Paths.get(System.getProperty("user.home") + "/Saved Games/Frontier Developments/Elite Dangerous/").toFile();
    }

    public static File getLatestJournalFile() {
        File latest = null;

        File[] edFiles = GameFiles.getDirectory().listFiles();
        if (edFiles == null) {
            System.out.println("No PlayerJournals were found, waiting for game.");
        }
        else {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().startsWith("Journal") && "log".equals(getFileExtension(file))) {
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

    private static File getGameFile(String namePrefix, String extension) {
        File gameFile = null;

        File[] edFiles = GameFiles.getDirectory().listFiles();
        if (edFiles != null) {
            for (File file : edFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().startsWith(namePrefix) && extension.equals(getFileExtension(file))) {
                        gameFile = file;
                    }
                }
            }
        }

        return gameFile;
    }

    public static File getShipyardFile() {
        return GameFiles.getGameFile("Shipyard", "json");
    }

    public static File getCargoFile() {
        return GameFiles.getGameFile("Cargo", "json");
    }

    public static File getMarketFile() {
        return GameFiles.getGameFile("Market", "json");
    }

    public static File getModulesInfoFile() {
        return GameFiles.getGameFile("ModulesInfo", "json");
    }

    public static File getOutfittingFile() {
        return GameFiles.getGameFile("Outfitting", "json");
    }

    public static File getStatusFile() {
        return GameFiles.getGameFile("Status", "json");
    }

    public static File getRouteFile() {
        return GameFiles.getGameFile("Route", "json");
    }

    public static void onUnprocessedEvent(JsonObject jsonEvent) {
        System.out.println("UNPROCESSED EVENT: " + jsonEvent.toString());
    }
}
