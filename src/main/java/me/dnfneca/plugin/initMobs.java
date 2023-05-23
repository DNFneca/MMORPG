package me.dnfneca.plugin;

import me.dnfneca.plugin.CustomMobs.MobStats;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.*;

import java.util.UUID;

import static me.dnfneca.plugin.Plugin.CustomMobs;
import static me.dnfneca.plugin.Plugin.CustomMobsAvailable;

public class initMobs {
	public static void init() {
		CustomMobsAvailable.add(new MobStats(UUID.randomUUID(),
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
				(Class<LivingEntity>) EntityType.ZOMBIE.getEntityClass(),
				10));

		CustomMobsAvailable.add(new MobStats(UUID.randomUUID(),
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
				(Class<LivingEntity>) EntityType.ZOMBIE_VILLAGER.getEntityClass(),
				100));
		CustomMobsAvailable.add(new MobStats(UUID.randomUUID(),
				"Ghoul mage",
				120,
				25,
				5,
				5,
				1,
				15,
				5,
				10,
				15,
				(Class<LivingEntity>) EntityType.ZOMBIE.getEntityClass(),
				15));
		CustomMobsAvailable.add(new MobStats(UUID.randomUUID(),
				"Ghoul rouge",
				140,
				45,
				0,
				15,
				2,
				10,
				25,
				15,
				20,
				(Class<LivingEntity>) EntityType.ZOMBIE.getEntityClass(),
				20));
	}

}
