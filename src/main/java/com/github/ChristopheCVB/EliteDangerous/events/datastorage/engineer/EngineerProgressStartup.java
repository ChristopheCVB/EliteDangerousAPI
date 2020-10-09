package com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.EngineerProgressInfo;

import java.util.List;

public class EngineerProgressStartup implements EngineerProgressInfo {

	private List<EngineerProgress> engineerProgressList;

	public EngineerProgressStartup(List<EngineerProgress> engineerProgressList) {
		this.engineerProgressList = engineerProgressList;
	}

	public List<EngineerProgress> getEngineerProgress() {
		return engineerProgressList;
	}

}
