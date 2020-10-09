package com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer;

public class EngineerProgress {
	
	private String engineer, progress;
	private Integer engineerID, rank;
	private Double rankProgress;
	
	public EngineerProgress(String engineer, String progress, Integer engineerID, Integer rank, Double rankProgress) {
		this.engineer = engineer;
		this.progress = progress;
		this.engineerID = engineerID;
		this.rank = rank;
		this.rankProgress = rankProgress;
	}

	public String getEngineer() {
		return engineer;
	}

	public String getProgress() {
		return progress;
	}

	public Integer getEngineerID() {
		return engineerID;
	}

	public Integer getRank() {
		return rank;
	}

	public Double getRankProgress() {
		return rankProgress;
	}

}
