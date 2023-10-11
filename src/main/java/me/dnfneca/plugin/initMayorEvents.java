package me.dnfneca.plugin;

import me.dnfneca.plugin.utilities.managers.Mayors.Mayor;
import me.dnfneca.plugin.utilities.managers.Mayors.MayorEvent;

public enum initMayorEvents {
	;

	public static void init() {
		new MayorEvent(
				"Dig"
		);
	}
}
