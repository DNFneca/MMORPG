package me.dnfneca.plugin.utilities.managers.Abilities;


import me.dnfneca.plugin.Abilities.*;
import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public enum AbilitiesManager {
	;

	public static void getAbility(String abilityName, PlayerStats player) {
		switch (abilityName) {
			case "Wave", "Fireball", "TrueShield", "Helix", "LaserPointer", "Tangle":
				if (25 > player.getCurrentMana()) {
					NotEnoughMana(player.getPlayer());
					break;
				}
				ability(abilityName, player);
				break;
		}
	}

	public static void NotEnoughMana(Player p) {
		p.sendMessage(ChatColor.RED + "NOT ENOUGH MANA!");
	}

	public static void ability(String AbilityName, PlayerStats p) {
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
				break;
			case "LaserPointer":
				LaserPointer.LaserPointer(p);
				break;
			case "Tangle":
				Tangle.Tangle(p);
				break;
		}

	}
	public static boolean HitDetection(Location location, double distance, PlayerStats player) {
		Collection<Entity> NearbyEntities = location.getWorld().getNearbyEntities(location, distance, distance, distance);
		LivingEntity MobsNearby = null;
		for (Entity e : NearbyEntities) {
			if (e instanceof LivingEntity) {
				System.out.println(e);
				MobsNearby = (LivingEntity) e;
				break;
			}
		}
		if (null == MobsNearby) {
			return false;
		} else {
			player.getPlayer().sendMessage("Hit " + MobsNearby.getCustomName() + "at " + MobsNearby.getLocation());

		}

		return true;
	}

	public static boolean HitDetection(Location location, double distance, PlayerStats player, float stunDuration) {
		Collection<Entity> NearbyEntities = location.getWorld().getNearbyEntities(location, distance, distance, distance);
		LivingEntity MobsNearby = null;
		for (Entity e : NearbyEntities) {
			if (MobStats.getMob(e.getUniqueId()) != null) {
				MobsNearby = (LivingEntity) e;
				break;
			}
		}
		if (null == MobsNearby) {
			return false;
		} else {
			MobsNearby.setAI(false);
			LivingEntity finalMobsNearby = MobsNearby;
			MobsNearby.getWorld().playSound(MobsNearby, Sound.ITEM_ARMOR_EQUIP_CHAIN, 10, 1.5F);
			new BukkitRunnable() {

				@Override
				public void run() {
					finalMobsNearby.setAI(true);
					finalMobsNearby.getWorld().playSound(finalMobsNearby, Sound.BLOCK_CHAIN_BREAK, 10, 2);
				}
			}.runTaskLater(Plugin.getInstance(), (long) (stunDuration*20));
			player.getPlayer().sendMessage("Hit " + MobsNearby.getCustomName() + "at " + MobsNearby.getLocation());

		}

		return true;
	}
}
