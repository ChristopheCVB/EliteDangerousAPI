/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:33
*/

package com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty;

public class FactionBounty {
	
	private String faction;
	private Long amount;
	
	public FactionBounty(String faction, Long amount) {
		this.faction = faction;
		this.amount = amount;
	}

	public String getFaction() {
		return faction;
	}

	public Long getAmount() {
		return amount;
	}

}
