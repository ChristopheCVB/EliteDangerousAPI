package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.station.Discovered;

import java.util.List;

public class MultiSellExplorationDataEvent extends Event {
	public List<Discovered> discovered;
	public Integer baseValue, totalEarnings, bonus;
}
