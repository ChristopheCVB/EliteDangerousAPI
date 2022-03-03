package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.Modification;
import com.christophecvb.elitedangerous.models.engineer.Ingredient;
import java.util.List;

public class EngineerCraftEvent extends Event {

  public String engineer;
  public String blueprintName;
  public String slot;
  public String module;
  public Integer engineerID;
  public Integer blueprintID;
  public Integer level;
  public Double quality;
  public List<Ingredient> ingredients;
  public List<Modification> modifiers;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onEngineerCraftEventTriggered((EngineerCraftEvent) event);
    }

    void onEngineerCraftEventTriggered(EngineerCraftEvent engineerCraftEvent);
  }
}
