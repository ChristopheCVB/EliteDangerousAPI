package com.christophecvb.elitedangerous.models.toreadable;

public class Reputation {
    public static String getReadableName(Double reputation) {
        String repName = "Neutral";

        if (reputation >= 90) {
            repName = "Allied";
        }
        else if (reputation >= 35) {
            repName = "Friendly";
        }
        else if (reputation >= 4) {
            repName = "Cordinal";
        }
        else if (reputation <= -90) {
            repName = "Hostile";
        }
        else if (reputation <= -35) {
            repName = "Unfriendly";
        }

        return repName;
    }
}
