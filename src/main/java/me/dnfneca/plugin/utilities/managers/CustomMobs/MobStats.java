package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Item.Items;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import me.dnfneca.plugin.utilities.managers.Statistics.StatCalc;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.dnfneca.plugin.listeners.PlayerJoin.CustomMobs;
import static me.dnfneca.plugin.listeners.PlayerJoin.Players;

public class MobStats {


	String Name;
	double Health;
	double Damage;
	double Defence;
	double Strength;
	double Speed;
	double CritDamage;
	double CritChance;
	double Stealth;
	int xpDropAmount;
	LivingEntity entityType;
	double CurrentHealth;
	int HealthRegenTime;

	double BaseHealth = 0;
	double BaseDamage = 0;
	double BaseDefence = 0;
	double BaseStrength = 0;
	double BaseSpeed = 0;
	double BaseCritDamage = 0;
	double BaseCritChance = 0;
	static UUID UUID;

	public MobStats(UUID UUID, String Name, double Health, final double Damage, final double Defence, final double Strength, final double Speed, final double CritDamage, final double CritChance, final double Stealth, int xpDropAmount, LivingEntity entityType) {
		this.Name = Name;
		this.UUID = UUID;
		this.Health = Health;
		this.Damage = Damage;
		this.Defence = Defence;
		this.Strength = Strength;
		this.Speed = Speed;
		this.CritDamage = CritDamage;
		this.CritChance = CritChance;
		this.Stealth = Stealth;
		this.xpDropAmount = xpDropAmount;
		this.entityType = entityType;
		HealthRegenTime = 4;
		this.BaseHealth = Health;
		this.BaseDamage = Damage;
		this.BaseDefence = Defence;
		this.BaseStrength = Strength;
		this.BaseSpeed = Speed;
		this.BaseCritDamage = CritDamage;
		this.BaseCritChance = CritChance;
		this.main();
	}

	public void main() {
		this.CurrentHealth = this.Health;
		final Plugin plugin = Plugin.getInstance();
		//
		// Calculate

		new BukkitRunnable() {
			@Override
			public void run() {
				if(getEntity(UUID) == null) {
					CustomMobs.remove(getMobStats());
					this.cancel();
				}
				MobStatsCalc.Calculate(getMobStats());
			}
		}.runTaskTimer(plugin, 0L, 5L);


	}


	// Set


	public void setHealthRegenTime(final int healthRegenTime) {
		this.HealthRegenTime = healthRegenTime;
	}



	public void setCurrentHealth(final double currentHealth) {
		this.CurrentHealth = currentHealth;
	}
	public void setHealth(final double health) {
		this.Health = health;
	}

	public void setDamage(final double damage) {
		this.Damage = damage;
	}

	public void setDefence(final double defence) {
		this.Defence = defence;
	}

	public void setStrength(final double strength) {
		this.Strength = strength;
	}

	public void setSpeed(final double speed) {
		this.Speed = speed;
	}

	public void setCritDamage(final double critDamage) {
		this.CritDamage = critDamage;
	}

	public void setCritChance(final double critChance) {
		this.CritChance = critChance;
	}

	public void setStealth(final double stealth) {
		this.Stealth = stealth;
	}


	// Get


	public double getBaseCritChance() {
		return this.BaseCritChance;
	}

	public double getBaseCritDamage() {
		return this.BaseCritDamage;
	}

	public double getBaseDamage() {
		return this.BaseDamage;
	}

	public double getBaseDefence() {
		return this.BaseDefence;
	}

	public double getBaseHealth() {
		return this.BaseHealth;
	}

	public double getBaseSpeed() {
		return this.BaseSpeed;
	}

	public double getBaseStrength() {
		return this.BaseStrength;
	}

	public static MobStats getMob(UUID mobUUID) {
		for (MobStats mob : CustomMobs) {
			if(mob.getUUID().equals(mobUUID)) {
				return mob;
			}
		}

		return null;
	}
	public static LivingEntity getEntity(UUID UUID) {
		return (LivingEntity) Bukkit.getEntity(UUID);
	}
	public MobStats getMobStats() {
		return getMob(UUID);
	}
	public int getHealthRegenTime() {
		return this.HealthRegenTime;
	}

	public String getName() {
		return this.Name;
	}
	public double getCurrentHealth() {
		return this.CurrentHealth;
	}


	public static MobStats getMobEntity() {
		for (MobStats player : CustomMobs) {
			if (player.getUUID().equals(UUID)) {
				return player;
			}
		}
		return null;
	}


	public java.util.UUID getUUID() {
		return this.UUID;
	}

	public double getHealth() {
		return this.Health;
	}

	public double getDamage() {
		return this.Damage;
	}

	public double getDefence() {
		return this.Defence;
	}

	public double getStrength() {
		return this.Strength;
	}

	public double getSpeed() {
		return this.Speed;
	}

	public double getCritDamage() {
		return this.CritDamage;
	}

	public double getCritChance() {
		return this.CritChance;
	}

	public double getStealth() {
		return this.Stealth;
	}

	public int getXpDropAmount() {
		return this.xpDropAmount;
	}

	public LivingEntity getEntityType() {
		return this.entityType;
	}
}
