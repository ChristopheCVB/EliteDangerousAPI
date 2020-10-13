package com.github.ChristopheCVB.EliteDangerous.models.toreadable;

public class CQCRank {
	private static final String[] LOCALISED_NAMES = {"Helpless", "Mostly Helpless", "Amateur", "Semi Professional", "Professional", "Champion", "Hero", "Legend", "Elite"};

	public static String getReadableName(int rank) {
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
