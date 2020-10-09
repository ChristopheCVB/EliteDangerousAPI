package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class StoredShipHere {
	
	private Boolean hot;
	private String name, shipType, shipTypeLocalised;
	private Long value;
	private Integer shipId;
	
	public StoredShipHere(Boolean hot, String name, String shipType, String shipTypeLocalised, Long value, Integer shipId) {
		this.hot = hot;
		this.name = name;
		this.shipType = shipType;
		this.shipTypeLocalised = shipTypeLocalised;
		this.value = value;
		this.shipId = shipId;
	}

	public Boolean getHot() {
		return hot;
	}

	public String getName() {
		return name;
	}

	public String getShipType() {
		return shipType;
	}

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public Long getValue() {
		return value;
	}

	public Integer getShipId() {
		return shipId;
	}

}
