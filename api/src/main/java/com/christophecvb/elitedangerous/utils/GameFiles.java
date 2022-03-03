package com.christophecvb.elitedangerous.utils;

import com.google.gson.JsonObject;
import java.io.File;
import java.nio.file.Paths;
import java.util.Optional;

public class GameFiles {

  private static final String GAME_FILE_EXTENSION = "json";

  private static GameFiles instance = null;

  public static GameFiles getInstance(File directory) {
    if (GameFiles.instance == null || !GameFiles.instance.directory.equals(directory)) {
      GameFiles.instance = new GameFiles();
      if (directory != null && directory.exists()) {
        GameFiles.instance.directory = directory;
      } else {
        GameFiles.instance.directory = Paths.get(
                System.getProperty("user.home") + "/Saved Games/Frontier Developments/Elite Dangerous/")
            .toFile();
      }
    }

    return GameFiles.instance;
  }

  public static GameFiles getExistingInstance() {
    return GameFiles.instance;
  }

  private File directory = null;

  public File getDirectory() {
    return this.directory;
  }

  public File getLatestJournalFile() {
    File latest = null;

    File[] edFiles = this.getDirectory().listFiles();
    if (edFiles == null) {
      System.out.println("No PlayerJournals were found, waiting for game.");
    } else {
      for (File file : edFiles) {
        if (!file.isDirectory()) {
          if (file.getName().startsWith("Journal") && "log".equals(getFileExtension(file))) {
            if (latest == null) {
              latest = file;
            } else {
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

  private File getGameFile(String namePrefix) {
    File gameFile = null;

    File[] edFiles = this.getDirectory().listFiles();
    if (edFiles != null) {
      for (File file : edFiles) {
        if (!file.isDirectory()) {
          if (file.getName().startsWith(namePrefix) && GameFiles.GAME_FILE_EXTENSION.equals(
              getFileExtension(file))) {
            gameFile = file;
          }
        }
      }
    }

    return gameFile;
  }

  public File getShipyardFile() {
    return this.getGameFile("Shipyard");
  }

  public File getCargoFile() {
    return this.getGameFile("Cargo");
  }

  public File getMarketFile() {
    return this.getGameFile("Market");
  }

  public File getModulesInfoFile() {
    return this.getGameFile("ModulesInfo");
  }

  public File getOutfittingFile() {
    return this.getGameFile("Outfitting");
  }

  public File getStatusFile() {
    return this.getGameFile("Status");
  }

  public File getBackpackFile() {
    return this.getGameFile("Backpack");
  }

  public File getRouteFile() {
    return this.getGameFile("Route");
  }

  public static void onUnprocessedEvent(JsonObject jsonEvent) {
    System.out.println("UNPROCESSED EVENT: " + jsonEvent.toString());
  }

  private static String getFileExtension(File file) {
    String extension = null;
    if (file != null) {
      String filename = file.getName();
      extension = GameFiles.getFileNameExtension(filename);
    }
    return extension;
  }

  private static String getFileNameExtension(String filename) {
    String extension = null;
    if (filename != null) {
      extension = Optional.of(filename)
          .filter(f -> f.contains("."))
          .map(f -> f.substring(filename.lastIndexOf(".") + 1))
          .orElse(null);
    }
    return extension;
  }
}
