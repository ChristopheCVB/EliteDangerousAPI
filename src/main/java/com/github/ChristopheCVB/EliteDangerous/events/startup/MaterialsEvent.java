package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Material;

import java.util.ArrayList;

public class MaterialsEvent extends Event {
	public ArrayList<Material> raw;
	public ArrayList<Material> manufactured;
	public ArrayList<Material> encoded;
}
