package com.github.ChristopheCVB.EliteDangerous.utils;

import com.google.gson.JsonObject;

import java.io.File;
import java.nio.file.Paths;
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
                    if (file.getName().startsWith("Journal") && GameFilesUtils.getFileExtension(file).equals("log")) {
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
                    if (file.getName().startsWith("Shipyard") && GameFilesUtils.getFileExtension(file).equals("json")) {
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
                    if (file.getName().startsWith("Cargo") && GameFilesUtils.getFileExtension(file).equals("json")) {
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
                    if (file.getName().startsWith("Market") && GameFilesUtils.getFileExtension(file).equals("json")) {
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
                    if (file.getName().startsWith("ModulesInfo") && GameFilesUtils.getFileExtension(file).equals("json")) {
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
                    if (file.getName().startsWith("Outfitting") && GameFilesUtils.getFileExtension(file).equals("json")) {
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
                    if (file.getName().startsWith("Status") && GameFilesUtils.getFileExtension(file).equals("json")) {
                        statusFile = file;
                    }
                }
            }
        }

        return statusFile;
    }

    public static void sendUnprocessedEvent(JsonObject jsonEvent) {
        System.out.println("UNPROCESSED EVENT: " + jsonEvent.toString());
    }
}
