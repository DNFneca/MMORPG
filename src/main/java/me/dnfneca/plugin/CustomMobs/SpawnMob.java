package me.dnfneca.plugin.CustomMobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.dnfneca.plugin.Plugin.CustomMobs;
import static me.dnfneca.plugin.Plugin.CustomMobsAvailable;

public class SpawnMob {

	public static void spawnMob(final String Type, final Location location) {
		LivingEntity entity = null;

		for (MobStats mobStats : CustomMobsAvailable) {
			if(Type.equals(mobStats.getName().replace(" ", "_"))) {
				Class<LivingEntity> entityType = mobStats.getEntityType();
				entity = location.getWorld().spawn(location, entityType);
				CustomMobs.add(new MobStats(entity.getUniqueId(),
						mobStats.getName(),
						mobStats.getHealth(),
						mobStats.getDamage(),
						mobStats.getDefence(),
						mobStats.getStrength(),
						mobStats.getSpeed(),
						mobStats.getCritDamage(),
						mobStats.getCritChance(),
						mobStats.getStealth(),
						mobStats.getXpDropAmount(),
						entityType,
						mobStats.getLevel()));
			}
		}

		entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
		entity.setCustomNameVisible(true);
		entity.setAI(true);
		Attributable creatureAt = entity;
		AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		attribute.setBaseValue(100);
		entity.setHealth(100);
		String[] getScores = entity.getScoreboardTags().toArray(new String[10]);
		String level = getScores[0];
		entity.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + Dummy.Level + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Dummy ");
		return;
	}
}
