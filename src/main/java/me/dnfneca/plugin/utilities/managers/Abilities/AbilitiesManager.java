package me.dnfneca.plugin.utilities.managers.Abilities;


import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum AbilitiesManager {
	;

	public static void getAbility(final String abilityName, final PlayerStats player) {
		switch (abilityName) {
			case "Wave", "Fireball", "TrueShield", "Helix":
				if (25 > player.getCurrentMana()) {
					AbilitiesManager.NotEnoughMana(player.getPlayer());
					break;
				}
				AbilitiesManager.ability(abilityName, player);
				break;
		}
	}

	public static void NotEnoughMana(final Player p) {
		p.sendMessage(ChatColor.RED + "NOT ENOUGH MANA!");
	}

	public static void ability(final String AbilityName, final PlayerStats p) {
		switch (AbilityName) {
			case "Wave":
				Wave.Wave(p);
				break;
			case "Helix":
				Helix.Helix(p);
				break;
			case "Fireball":
				Fireball.Fireball(p);
				break;
			case "TrueShield":
				ShieldAbility.TrueShieldAbility(p, 1);
		}

	}
}
