package com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.EngineerProgressInfo;

public class EngineerProgressUpdate implements EngineerProgressInfo {
	
	private EngineerProgress progress;

	public EngineerProgressUpdate(EngineerProgress progress) {
		this.progress = progress;
	}

	public EngineerProgress getProgress() {
		return progress;
	}

}
