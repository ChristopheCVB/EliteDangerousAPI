package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.Mission;

import java.util.List;

public class MissionsEvent extends Event {
	public List<Mission> active;
	public List<Mission> failed;
	public List<Mission> complete;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onMissionsEventTriggered((MissionsEvent) event);
		}

		void onMissionsEventTriggered(MissionsEvent missionsEvent);
	}
}
