package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.localiser.*;
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
		return CombatRank.getLocalisedName(this.combat);
	}

	public String getTradeRankName() {
		return TradeRank.getLocalisedName(this.trade);
	}

	public String getExplorerRankName() {
		return ExplorationRank.getLocalisedName(this.explore);
	}

	public String getEmpireRankName() {
		return EmpireRank.getLocalisedName(this.empire);
	}

	public String getFederationRankName() {
		return FederationRank.getLocalisedName(this.federation);
	}

	public String getCQCRankName() {
		return CQCRank.getLocalisedName(this.cqc);
	}

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onRankEventTriggered((RankEvent) event);
		}

		void onRankEventTriggered(RankEvent rankEvent);
	}
}
