package com.github.ChristopheCVB.EliteDangerous.utils.localiser;

public class TradeRank {
	private static String[] LOCALISED_NAMES = {"Penniless", "Mostly Pennliess", "Peddler", "Dealer", "Merchant", "Broker", "Entrepreneur", "Tycoon", "Elite"};

	public static String getLocalisedName(int rank) {
		return LOCALISED_NAMES[rank];
	}

	public static int getRank(String rankName) {
		int rank = 0;

		for (int i = 0; i < LOCALISED_NAMES.length; i++) {
			if (LOCALISED_NAMES[i].equals(rankName)) {
				rank = i;
			}
		}

		return rank;
	}
}
