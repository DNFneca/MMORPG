package me.dnfneca.plugin.CustomMobs.HitEffects;

import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum HitEffects {
	;

	public static void applyMobHitEffect(MobStats mobStats, PlayerStats playerStats) {
		Player player = playerStats.getPlayer();
		switch (mobStats.getName()) {
			case "Ghoul":
				playerStats.setStunDuration(10);
				break;
		}
	}
}
