package com.github.ChristopheCVB.EliteDangerous.utils.localiser;

public class FederationRank {
	
	private static String[] localisedNames = {"None", "Recruit", "Cadet", "Midshipman", "Petty Officer", "Chief Petty Officer", "Warrant Officer", "Ensign",
			"Lieutenant", "Lt. Commander", "Post Commander",	"Post Captain", "Rear Admiral", "Vice Admiral", "Admiral"};
	
	public static String getLocalisedName(int rank) {
		return localisedNames[rank];
	}
	
	public static int getRank(String rankName) {
		int rank = 0;
		for(int i = 0; i < localisedNames.length; i++) {
			if(localisedNames[i].equals(rankName)) {
				rank = i;
			}
		}
		
		return rank;
	}

}
