/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:36
*/

package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class StoredModule {
	
	private String name, nameLocalised, starSystem;
	private Integer storageSlot;
	private Long marketId, transferCost, transferTime, buyPrice;
	private Boolean hot;
	
	public StoredModule(String name, String nameLocalised, String starSystem, Integer storageSlot, Long marketId,
			Long transferCost, Long transferTime, Long buyPrice, Boolean hot) {
		this.name = name;
		this.nameLocalised = nameLocalised;
		this.starSystem = starSystem;
		this.storageSlot = storageSlot;
		this.marketId = marketId;
		this.transferCost = transferCost;
		this.transferTime = transferTime;
		this.buyPrice = buyPrice;
		this.hot = hot;
	}

	public String getName() {
		return name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Integer getStorageSlot() {
		return storageSlot;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Long getTransferCost() {
		return transferCost;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public Boolean getHot() {
		return hot;
	}

}
