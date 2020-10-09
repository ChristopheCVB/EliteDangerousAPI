package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class Modifier {
	
	private String label;
	private Double value, originalValue;
	private Integer lessIsGood;
	
	public Modifier(String label, Double value, Double originalValue, Integer lessIsGood) {
		this.label = label;
		this.value = value;
		this.originalValue = originalValue;
		this.lessIsGood = lessIsGood;
	}

	public String getLabel() {
		return label;
	}

	public Double getValue() {
		return value;
	}

	public Double getOriginalValue() {
		return originalValue;
	}

	public Integer getLessIsGood() {
		return lessIsGood;
	}
	
}
