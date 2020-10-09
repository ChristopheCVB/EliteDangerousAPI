package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

public class Ring {
	
	private String name, ringClass;
	private Long massMT, innerRad, outerRad;
    
	public Ring(String name, String ringClass, Long massMT, Long innerRad, Long outerRad) {
		this.name = name;
		this.ringClass = ringClass;
		this.massMT = massMT;
		this.innerRad = innerRad;
		this.outerRad = outerRad;
	}

	public String getName() {
		return name;
	}

	public String getRingClass() {
		return ringClass;
	}

	public Long getMassMT() {
		return massMT;
	}

	public Long getInnerRad() {
		return innerRad;
	}

	public Long getOuterRad() {
		return outerRad;
	}

}
