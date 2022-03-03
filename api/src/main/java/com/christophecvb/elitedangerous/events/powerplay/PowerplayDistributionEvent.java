package com.christophecvb.elitedangerous.events.powerplay;

import com.christophecvb.elitedangerous.events.Event;

public abstract class PowerplayDistributionEvent extends Event {

  public String power;
  public String type;
  public Integer count;
}
