package me.dnfneca.plugin.utilities.managers.Mayors;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MayorBuff {
	public static void applyMayorBuff(Mayor mayor, Player player) {
		switch (mayor.Buff) {
			case "test":
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 255, true, false, false));
				break;
		}
	}
	public static void applyMayorBuff(Mayor mayor, PlayerStats p) {
		Player player = p.getPlayer();
		switch (mayor.Buff) {
			case "test":
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 255, true, false, false));
				break;
		}
	}
}
