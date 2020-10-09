package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum Engineer {
	
	Didi_Vatermann(300000), Bill_Turner(300010), Broo_Tarquin(300030), The_Sarge(300040), Zachariah_Nemo(300050), Liz_Ryder(300080), Hera_Tani(300090), Felicity_Farseer(300100),
	Ram_Tah(300110), Lei_Cheung(300120), Colonel_Bris_Dekker(300140), Elvira_Martuuk(300160), The_Dweller(300180), Marco_Quent(300200), Selene_Jean(300210), Professor_Palin(300220),
	Lori_Jameson(300230), Juri_Ishmaak(300250), Tod_$The_Blaster$_McQuinn(300260), Tiana_Fortune(300270);
	
	private int engineerID;
	
	Engineer(int id) {
		engineerID = id;
	}
	
	public int getEngineerID() {
		return engineerID;
	} 
	
	public String getEngineerName(int engineerID) {
		String name = "null";
		for(Engineer engineerId : values()) {
			if(engineerId.getEngineerID() == engineerID) {
				name = engineerId.name().replace("_", " ");
				name = engineerId.name().replace("$", "'");
			}
		}
		return name;
	}

}
