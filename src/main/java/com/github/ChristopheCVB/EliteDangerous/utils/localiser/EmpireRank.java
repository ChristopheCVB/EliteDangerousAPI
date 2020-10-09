package com.github.ChristopheCVB.EliteDangerous.utils.localiser;

public class EmpireRank {
	
	private static String[] localisedNames = {"None", "Outsider", "Serf", "Master", "Squire", "Knight", "Lord", "Baron", "Viscount ", "Count", "Earl",
			"Marquis", "Duke", "Prince", "King"};
	
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
