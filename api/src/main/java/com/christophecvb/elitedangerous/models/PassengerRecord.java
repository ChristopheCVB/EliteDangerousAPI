package com.christophecvb.elitedangerous.models;

import com.google.gson.annotations.SerializedName;

public class PassengerRecord {

  public String type;
  public Integer count;
  @SerializedName("VIP")
  public Boolean vip;
  public Boolean wanted;
  public Long missionID;
}
