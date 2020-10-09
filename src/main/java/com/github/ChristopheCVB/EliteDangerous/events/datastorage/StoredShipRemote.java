package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class StoredShipRemote {
	
	private Boolean hot;
	private String name, shipType, shipTypeLocalised, starSystem;
	private Long value, shipMarketId, transferTime, transferrice;
	private Integer shipId;
	
	public StoredShipRemote(Boolean hot, String name, String shipType, String shipTypeLocalised, String starSystem,
			Long value, Long shipMarketId, Long transferTime, Long transferrice, Integer shipId) {
		this.hot = hot;
		this.name = name;
		this.shipType = shipType;
		this.shipTypeLocalised = shipTypeLocalised;
		this.starSystem = starSystem;
		this.value = value;
		this.shipMarketId = shipMarketId;
		this.transferTime = transferTime;
		this.transferrice = transferrice;
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

	public String getStarSystem() {
		return starSystem;
	}

	public Long getValue() {
		return value;
	}

	public Long getShipMarketId() {
		return shipMarketId;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public Long getTransferrice() {
		return transferrice;
	}

	public Integer getShipId() {
		return shipId;
	}

}
