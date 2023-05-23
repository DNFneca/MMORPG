package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;

public enum ShieldAbility {
	;

	public static void TrueShieldAbility(PlayerStats p, int AmountOfStacks) {
		p.setManaSpent(25);
		p.setManaTimer(6);
	}
}
