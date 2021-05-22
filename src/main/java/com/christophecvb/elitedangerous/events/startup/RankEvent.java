package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.toreadable.*;
import com.google.gson.annotations.SerializedName;

public class RankEvent extends Event {
	public Integer combat;
	public Integer trade;
	public Integer explore;
	public Integer empire;
	public Integer federation;
	@SerializedName("CQC")
	public Integer cqc;

	public String getCombatRankName() {
		return CombatRank.getReadableName(this.combat);
	}

	public String getTradeRankName() {
		return TradeRank.getReadableName(this.trade);
	}

	public String getExplorerRankName() {
		return ExplorationRank.getReadableName(this.explore);
	}

	public String getEmpireRankName() {
		return EmpireRank.getReadableName(this.empire);
	}

	public String getFederationRankName() {
		return FederationRank.getReadableName(this.federation);
	}

	public String getCQCRankName() {
		return CQCRank.getReadableName(this.cqc);
	}

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onRankEventTriggered((RankEvent) event);
		}

		void onRankEventTriggered(RankEvent rankEvent);
	}
}
