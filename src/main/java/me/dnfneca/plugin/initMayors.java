package me.dnfneca.plugin;

import me.dnfneca.plugin.utilities.managers.Mayors.Mayor;
import me.dnfneca.plugin.utilities.managers.Mayors.MayorEvent;

import static me.dnfneca.plugin.Plugin.Mayors;

public enum initMayors {
	;

	public static void init() {
		new Mayor(
				"test",
				"test",
				MayorEvent.getEventByName("Dig")
		);
	}
}
