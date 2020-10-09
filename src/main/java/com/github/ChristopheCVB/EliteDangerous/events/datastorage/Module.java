package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class Module {
	
	private String slot, item;
	private Boolean on;
	private Integer priority, ammoInClip, ammoInHopper;
	private Double health;
	private Engineering engineering;
	
	public Module(String slot, String item, Boolean on, Integer priority, Integer ammoInClip, Integer ammoInHopper, Double health, Engineering engineering) {
		this.slot = slot;
		this.item = item;
		this.on = on;
		this.priority = priority;
		this.ammoInClip = ammoInClip;
		this.ammoInHopper = ammoInHopper;
		this.health = health;
		this.engineering = engineering;
	}
	
	public Module(String slot, String item, Boolean on, Integer priority, Integer ammoInClip, Integer ammoInHopper, Double health) {
		this.slot = slot;
		this.item = item;
		this.on = on;
		this.priority = priority;
		this.ammoInClip = ammoInClip;
		this.ammoInHopper = ammoInHopper;
		this.health = health;
	}

	public String getSlot() {
		return slot;
	}

	public String getItem() {
		return item;
	}

	public Boolean getOn() {
		return on;
	}

	public Integer getPriority() {
		return priority;
	}

	public Integer getAmmoInClip() {
		return ammoInClip;
	}

	public Integer getAmmoInHopper() {
		return ammoInHopper;
	}

	public Double getHealth() {
		return health;
	}

	public Engineering getEngineering() {
		return engineering;
	}

}
