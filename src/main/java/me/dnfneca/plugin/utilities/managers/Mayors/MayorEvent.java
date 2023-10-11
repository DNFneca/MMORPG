package me.dnfneca.plugin.utilities.managers.Mayors;

import me.dnfneca.plugin.utilities.managers.Mayors.util.RunMayorEventRunEvent;

import static me.dnfneca.plugin.Plugin.MayorEvents;

public class MayorEvent {

	String eventName;
	public MayorEvent(String eventName) {
		this.eventName = eventName;
		MayorEvents.add(this);
	}

	public String getEventName() {
		return this.eventName;
	}

	public static MayorEvent getEventByName(String eventName) {
		for (MayorEvent event : MayorEvents) {
			if(event.eventName.equals(eventName)) {
				return event;
			}
		}
		return null;
	}
}
