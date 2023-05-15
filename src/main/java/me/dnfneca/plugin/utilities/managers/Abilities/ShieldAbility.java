package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;

public enum ShieldAbility {
	;

	public static void TrueShieldAbility(final PlayerStats p, final int AmountOfStacks) {
		p.setManaSpent(25);
		p.setManaTimer(6);
	}
}
