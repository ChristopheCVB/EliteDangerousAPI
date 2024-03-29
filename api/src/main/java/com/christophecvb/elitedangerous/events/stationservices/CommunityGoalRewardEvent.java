package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CommunityGoalRewardEvent extends Event {

  @SerializedName("CGID")
  public Integer cgid;
  public Integer reward;
  public String name;
  public String system;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCommunityGoalRewardEventTriggered((CommunityGoalRewardEvent) event);
    }

    void onCommunityGoalRewardEventTriggered(CommunityGoalRewardEvent communityGoalRewardEvent);
  }
}
