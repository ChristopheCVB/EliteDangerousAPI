package com.christophecvb.elitedangerous.models;

public class MicroResource {

  public String name;
  public String nameLocalised;
  public Category category;
  public Integer count;

  public enum Category {
    Encoded,
    Raw,
    Manufactured,
    Item,
    Component,
    Data,
    Consumable,
  }
}