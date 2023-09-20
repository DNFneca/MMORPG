package me.dnfneca.plugin.utilities.managers.Abilities;


import me.dnfneca.plugin.Abilities.*;
import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

import static me.dnfneca.plugin.utilities.managers.Statistics.PlayerStatCalc.updatePlayerActionBar;

public enum AbilitiesManager {
	;

	public static void getAbility(String[] abilityName, PlayerStats player) {
		if(abilityName.length < 2) {
			return;
		}
		if(Float.parseFloat(abilityName[1]) > player.getCurrentMana()) {
			NotEnoughMana(player);
			return;
		}
		ability(abilityName, player);
	}

	public static void NotEnoughMana(PlayerStats p) {
		p.setManaTimer(-6);
		updatePlayerActionBar(p);
	}

	public static void ability(String[] AbilityName, PlayerStats p) {
		switch (AbilityName[0]) {
			case "Wave":
				if (Wave.Wave(p, Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
				break;
			case "Helix":
				if (Helix.Helix(p, Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
				break;
			case "Fireball":
				if (Fireball.Fireball(p, Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
				break;
			case "TrueShield":
				if(ShieldAbility.TrueShieldAbility(p, 1, Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
				break;
			case "LaserPointer":
				if(LaserPointer.LaserPointer(p, Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
				break;
			case "Tangle":
				if(Tangle.Tangle(p,Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
				break;
			case "Teleport":
			case "Reality_Warp":
				if(Teleport.Teleport(p, Float.parseFloat(AbilityName[1]), Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
				break;
			case "Hook":
				if(Hook.Hook(p, Float.parseFloat(AbilityName[1]))) {
					updatePlayerActionBar(p);
				}
		}

	}
	public static LivingEntity HitDetection(Location location, double distance, PlayerStats player) {
		Collection<Entity> NearbyEntities = location.getWorld().getNearbyEntities(location, distance, distance, distance);
		LivingEntity MobsNearby = null;
		for (Entity e : NearbyEntities) {
			if (e instanceof LivingEntity && e != player.getPlayer()) {
				MobsNearby = (LivingEntity) e;
				break;
			}
		}
		return MobsNearby;
	}
}
