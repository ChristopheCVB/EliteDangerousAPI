package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import java.util.List;

public class Conflict {
	
	private String status, warType;
	private List<ConflicFaction> cFactionList;
	
	public Conflict(String status, String warType, List<ConflicFaction> cFactionList) {
		this.status = status;
		this.warType = warType;
		this.cFactionList = cFactionList;
	}

	public String getStatus() {
		return status;
	}

	public String getWarType() {
		return warType;
	}

	public List<ConflicFaction> getcFactionList() {
		return cFactionList;
	}

}
