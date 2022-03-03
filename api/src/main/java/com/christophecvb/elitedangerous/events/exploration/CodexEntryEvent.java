package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class CodexEntryEvent extends Event {

  public String name;
  public String nameLocalised;
  public String subCategory;
  public String subCategoryLocalised;
  public String category;
  public String categoryLocalised;
  public String region;
  public String system;
  public Integer entryID;
  public Long systemAddress;
  public Boolean isNewEntry;
  public Boolean newTraitsDiscovered;
  public String[] traits;
  public String nearestDestination;
  public String nearestDestinationLocalised;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCodexEntryEventTriggered((CodexEntryEvent) event);
    }

    void onCodexEntryEventTriggered(CodexEntryEvent codexEntryEvent);
  }
}
