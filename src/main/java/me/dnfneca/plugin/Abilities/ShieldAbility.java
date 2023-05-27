package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;

public enum ShieldAbility {
	;

	public static boolean TrueShieldAbility(PlayerStats p, int AmountOfStacks, float cost) {
		p.removeMana(cost);
		p.setManaSpent(cost);
		p.setManaTimer(6);
		return true;
	}
}
