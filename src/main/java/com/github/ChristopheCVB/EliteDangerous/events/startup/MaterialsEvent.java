package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Encoded;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Manufactured;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Raw;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class MaterialsEvent extends Event {
	//TODO: Can you do this to? i havent changed anything besides making the fields public
	public List<Raw> raw;
	public List<Manufactured> manufactured;
	public List<Encoded> encoded;
	
	public MaterialsEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.raw = GameFilesUtils.createRawMaterialList(JsonUtils.pullJsonArray(jsonEvent, "Raw"));
        this.manufactured = GameFilesUtils.createManufacturedMaterialList(JsonUtils.pullJsonArray(jsonEvent, "Manufactured"));
        this.encoded = GameFilesUtils.createEncodedMaterialList(JsonUtils.pullJsonArray(jsonEvent, "Encoded"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public List<Raw> getRaw() {
		return raw;
	}

	public List<Manufactured> getManufactured() {
		return manufactured;
	}

	public List<Encoded> getEncoded() {
		return encoded;
	}
	
}
