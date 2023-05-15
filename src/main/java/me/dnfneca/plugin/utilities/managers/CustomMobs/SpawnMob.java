package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.listeners.PlayerJoin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpawnMob {

	public static void spawnMob(String Type, Location location) {
		LivingEntity entity = null;
		switch (Type) {
			case "Ghoul":
				entity = location.getWorld().spawn(location, Zombie.class);
				PlayerJoin.CustomMobs.add(new MobStats(entity.getUniqueId(),
						"Ghoul",
						100,
						10,
						10,
						10,
						1,
						10,
						10,
						10,
						10,
						entity));
				break;
			case "Oni":
				entity = location.getWorld().spawn(location, ZombieVillager.class);
				PlayerJoin.CustomMobs.add(new MobStats(entity.getUniqueId(),
						"Oni",
						10000,
						50,
						20,
						5,
						5,
						100,
						5,
						10,
						1000,
						entity));
				break;
			case "ent.player.Human.Reflect":
				entity = location.getWorld().spawn(location, Zombie.class);
				PlayerJoin.CustomMobs.add(new MobStats(entity.getUniqueId(),
					"ent.player.Human.Reflect",
						(Math.random() * ((300 - 5) + 1)) + 5,
						(Math.random()),
						(Math.random() * ((300 - 5) + 1)) + 5,
						(Math.random() * ((300 - 5) + 1)) + 5,
						(Math.random() * ((300 - 5) + 1)) + 5,
						(Math.random() * ((300 - 5) + 1)) + 5,
						(Math.random() * ((300 - 5) + 1)) + 5,
						(Math.random() * ((300 - 5) + 1)) + 5,
						1000,
								entity));
			break;

		}

		entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
		entity.setCustomNameVisible(true);
		entity.setAI(true);
		final Attributable creatureAt = entity;
		final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		attribute.setBaseValue(100);
		entity.setHealth(100);
		final String[] getScores = entity.getScoreboardTags().toArray(new String[10]);
		final String level = getScores[0];
		entity.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + Dummy.Level + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Dummy ");
	}
	public static int MaxHealth = 1200;
	public static int Level = 90;
	public static String Type = "Ghoul";
	public static String Name = "Ghoul";
	public static int Defence = 50;
	public static int Strength = 85;
	public static int Damage = 100;

}
