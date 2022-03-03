package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.material.Encoded;
import com.christophecvb.elitedangerous.models.material.Manufactured;
import com.christophecvb.elitedangerous.models.material.Material;
import java.util.List;

public class MaterialsEvent extends Event {

  public List<Material> raw;
  public List<Manufactured> manufactured;
  public List<Encoded> encoded;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onMaterialsEventTriggered((MaterialsEvent) event);
    }

    void onMaterialsEventTriggered(MaterialsEvent materialsEvent);
  }
}
