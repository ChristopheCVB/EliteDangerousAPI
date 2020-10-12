package com.github.ChristopheCVB.EliteDangerous.utils.localiser;

public class EmpireRank {
	private static final String[] LOCALISED_NAMES = {"None", "Outsider", "Serf", "Master", "Squire", "Knight", "Lord", "Baron", "Viscount ", "Count", "Earl", "Marquis", "Duke", "Prince", "King"};

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
