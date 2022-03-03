package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.AsteroidMaterial;
import java.util.List;

public class ProspectedAsteroidEvent extends Event {

  public static final String[] CONTENTS = {"High", "Medium", "Low"};

  public List<AsteroidMaterial> materials;
  public String content;
  public String motherlodeMaterial;
  public Float remaining;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onProspectedAsteroidEventTriggered((ProspectedAsteroidEvent) event);
    }

    void onProspectedAsteroidEventTriggered(ProspectedAsteroidEvent prospectedAsteroidEvent);
  }
}
