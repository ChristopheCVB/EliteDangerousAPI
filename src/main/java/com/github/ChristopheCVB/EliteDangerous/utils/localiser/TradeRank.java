package com.github.ChristopheCVB.EliteDangerous.utils.localiser;

public class TradeRank {
	
	private static String[] localisedNames = {"Penniless", "Mostly Pennliess", "Peddler", "Dealer", "Merchant", "Broker", "Entrepreneur", "Tycoon", "Elite"};
	
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
