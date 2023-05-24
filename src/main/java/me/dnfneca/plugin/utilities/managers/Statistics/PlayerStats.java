package me.dnfneca.plugin.utilities.managers.Statistics;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Item.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

import static me.dnfneca.plugin.Plugin.Players;


public class PlayerStats {


	java.util.UUID UUID;
	double Health;
	double Damage;
	double Defence;
	double Strength;
	double Speed;
	double Mana;
	double CritDamage;
	double CritChance;
	double Stealth;
	int Xp;
	String Class;
	int ChoiceCD;
	int ManaTimer;
	double CurrentHealth;
	double CurrentMana;
	double ManaSpent;
	int HealthRegenTime;
	int ManaRegenTime;

	public PlayerStats(UUID UUID, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, int Xp, String Class) {
		this.UUID = UUID;
		this.Health = Health;
		this.Damage = Damage;
		this.Defence = Defence;
		this.Strength = Strength;
		this.Speed = Speed;
		this.Mana = Mana;
		this.CritDamage = CritDamage;
		this.CritChance = CritChance;
		this.Stealth = Stealth;
		this.Xp = Xp;
		this.Class = Class;
		this.ChoiceCD = 0;
		this.ManaTimer = 0;
		this.HealthRegenTime = 4;
		this.ManaRegenTime = 4;
        main();
	}

	public void main() {
        CurrentHealth = Health;
        CurrentMana = Mana;
		Plugin plugin = Plugin.getInstance();
		if (!"none".equals(this.Class.replace("\"", ""))) {
            ChoiceCD = 1;
		}
		//
		new BukkitRunnable() {
			@Override
			public void run() {
				if (0 > PlayerStats.this.ChoiceCD) {
                    ChoiceCD = 0;
				}
				if (0 > PlayerStats.this.ManaTimer) {
                    ManaTimer--;
				}
			}
		}.runTaskTimer(plugin, 0L, 20L);

		// Calculate

		new BukkitRunnable() {
			@Override
			public void run() {
				if (null == PlayerStats.this.getPlayer()) {
					this.cancel();
					return;
				}

				PlayerStatCalc.Calculate(getPlayerStats(UUID));
				getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1019, 255, false, false));
				getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1019, 255, false, false));

				int Slots = getPlayer().getInventory().getSize();
				for (int i = 0; i < Slots; i++) {
					if (null != PlayerStats.this.getPlayer().getInventory().getItem(i) && null != PlayerStats.this.getPlayer().getInventory().getItem(i).getItemMeta() && getPlayer().getInventory().getItem(i).hasItemMeta() && getPlayer().getInventory().getItem(i).getItemMeta().hasDisplayName()) {
						ItemMeta meta = getPlayer().getInventory().getItem(i).getItemMeta();
						Items.setItemLore(getPlayer().getInventory(), meta, i);
					}
				}
			}
		}.runTaskTimer(plugin, 0L, 5L);


	}


	// Set


	public void setHealthRegenTime(int healthRegenTime) {
        HealthRegenTime = healthRegenTime;
	}

	public void setManaRegenTime(int manaRegenTime) {
        ManaRegenTime = manaRegenTime;
	}

	public void setCurrentHealth(double currentHealth) {
        CurrentHealth = currentHealth;
	}

	public void setCurrentMana(double currentMana) {
        CurrentMana = currentMana;
	}

	public void setChoiceCD(int ChoiceCD) {
		this.ChoiceCD = ChoiceCD;
	}

	public void setManaTimer(int ManaTimer) {
		this.ManaTimer = ManaTimer;
	}

	public void setUUID(UUID UUID) {
		this.UUID = UUID;
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

	public void setMana(double mana) {
        Mana = mana;
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

	public void setXp(int xp) {
        Xp = xp;
	}

	public void setClass(String aClass) {
        Class = aClass;
	}

	public void setManaSpent(double manaSpent) {
        ManaSpent = manaSpent;
	}
	// Get


	public int getHealthRegenTime() {
		return HealthRegenTime;
	}

	public int getManaRegenTime() {
		return ManaRegenTime;
	}

	public double getManaSpent() {
		return ManaSpent;
	}

	public double getCurrentHealth() {
		return CurrentHealth;
	}

	public double getCurrentMana() {
		return CurrentMana;
	}

	public Player getPlayer(UUID UUID) {
		return Bukkit.getPlayer(UUID);
	}

	public Player getPlayer() {
		return Bukkit.getPlayer(this.UUID);
	}

	public static PlayerStats getPlayerStats(UUID UUID) {
		for (PlayerStats player : Players) {
			if (player.UUID.equals(UUID)) {
				return player;
			}
		}
		return null;
	}

	public UUID getUUID() {
		return UUID;
	}

	public int getManaTimer() {
		return ManaTimer;
	}

	public int getChoiceCD() {
		return ChoiceCD;
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

	public double getMana() {
		return Mana;
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

	public int getXp() {
		return Xp;
	}

	public String getPlayerClass() {
		return Class;
	}

}
