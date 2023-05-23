package me.dnfneca.plugin.CustomMobs;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

import static me.dnfneca.plugin.Plugin.CustomMobs;

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
	Class<LivingEntity> entityType;
	double CurrentHealth;
	int HealthRegenTime;

	double BaseHealth;
	double BaseDamage;
	double BaseDefence;
	double BaseStrength;
	double BaseSpeed;
	double BaseCritDamage;
	double BaseCritChance;
	UUID UUID;

	int Level;

	public MobStats(final UUID UUID, final String Name, final double Health, double Damage, double Defence, double Strength, double Speed, double CritDamage, double CritChance, double Stealth, final int xpDropAmount, final Class<LivingEntity> entityType, final int Level) {
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
		this.HealthRegenTime = 4;
		this.BaseHealth = Health;
		this.BaseDamage = Damage;
		this.BaseDefence = Defence;
		this.BaseStrength = Strength;
		this.BaseSpeed = Speed;
		this.BaseCritDamage = CritDamage;
		this.BaseCritChance = CritChance;
		this.Level = Level;
		this.main();
	}

	public void main() {
		CurrentHealth = Health;
		Plugin plugin = Plugin.getInstance();
		//
		// Calculate

		new BukkitRunnable() {
			@Override
			public void run() {
				for (MobStats customMob : CustomMobs) {
					if(customMob.getUUID().equals(UUID)) {
						MobStatsCalc.Calculate(MobStats.this.getMobStats());
						break;
					}
					cancel();
				}
			}
		}.runTaskTimer(plugin, 0L, 5L);


	}


	// Set


	public void setHealthRegenTime(int healthRegenTime) {
		HealthRegenTime = healthRegenTime;
	}



	public void setCurrentHealth(double currentHealth) {
		CurrentHealth = currentHealth;
	}
	public void setHealth(double health) {
		Health = health;
	}

	public void setDamage(double damage) {
		Damage = damage;
	}

	public void setDefence(double defence) {
		Defence = defence;
	}

	public void setStrength(double strength) {
		Strength = strength;
	}

	public void setSpeed(double speed) {
		Speed = speed;
	}

	public void setCritDamage(double critDamage) {
		CritDamage = critDamage;
	}

	public void setCritChance(double critChance) {
		CritChance = critChance;
	}

	public void setStealth(double stealth) {
		Stealth = stealth;
	}


	// Get


	public double getBaseCritChance() {
		return BaseCritChance;
	}

	public double getBaseCritDamage() {
		return BaseCritDamage;
	}

	public double getBaseDamage() {
		return BaseDamage;
	}

	public double getBaseDefence() {
		return BaseDefence;
	}

	public double getBaseHealth() {
		return BaseHealth;
	}

	public double getBaseSpeed() {
		return BaseSpeed;
	}

	public double getBaseStrength() {
		return BaseStrength;
	}

	public static MobStats getMob(final UUID mobUUID) {
		for (final MobStats mob : CustomMobs) {
			if(mob.UUID.equals(mobUUID)) {
				return mob;
			}
		}

		return null;
	}
	public static LivingEntity getEntity(final UUID UUID) {
		return (LivingEntity) Bukkit.getEntity(UUID);
	}
	public MobStats getMobStats() {
		return MobStats.getMob(this.UUID);
	}
	public int getHealthRegenTime() {
		return HealthRegenTime;
	}

	public String getName() {
		return Name;
	}
	public double getCurrentHealth() {
		return CurrentHealth;
	}

	public int getLevel() {
		return Level;
	}

	public java.util.UUID getUUID() {
		return UUID;
	}

	public double getHealth() {
		return Health;
	}

	public double getDamage() {
		return Damage;
	}

	public double getDefence() {
		return Defence;
	}

	public double getStrength() {
		return Strength;
	}

	public double getSpeed() {
		return Speed;
	}

	public double getCritDamage() {
		return CritDamage;
	}

	public double getCritChance() {
		return CritChance;
	}

	public double getStealth() {
		return Stealth;
	}

	public int getXpDropAmount() {
		return xpDropAmount;
	}

	public Class<LivingEntity> getEntityType() {
		return entityType;
	}
	public MobStats getStatsByEntity(final LivingEntity entity) {
		for (final MobStats customMob : CustomMobs) {
			if(customMob.entityType.equals(entity)) {
				return customMob;
			}
		}
		return null;
	}
}
