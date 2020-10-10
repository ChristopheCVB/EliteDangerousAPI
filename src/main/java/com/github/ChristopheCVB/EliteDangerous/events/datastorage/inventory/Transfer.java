package com.github.ChristopheCVB.EliteDangerous.events.datastorage.inventory;

public class Transfer {
	
	private String type, typeLocalised, direction;
	private Integer count;
	
	public Transfer(String type, String typeLocalised, String direction, Integer count) {
		this.type = type;
		this.typeLocalised = typeLocalised;
		this.direction = direction;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

	public String getDirection() {
		return direction;
	}

	public Integer getCount() {
		return count;
	}

}
