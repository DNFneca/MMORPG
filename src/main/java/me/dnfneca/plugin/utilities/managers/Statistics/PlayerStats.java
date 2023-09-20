package me.dnfneca.plugin.utilities.managers.Statistics;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Item.Items;
import me.dnfneca.plugin.utilities.managers.Social.PlayerFiles;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import static me.dnfneca.plugin.Plugin.*;


public class PlayerStats {


	java.util.UUID UUID;

	double BonusHealth;
	int BonusHealthTimer;
	int BonusManaTimer;
	double BonusMana;
	double Health;
	double Damage;
	double Defence;
	double Strength;
	double Speed;
	double Mana;
	double CritDamage;
	double CritChance;
	double Stealth;
	int EnchantingXp;

	int xp;
	String Class;
	int ChoiceCD;
	int ManaTimer;
	double CurrentHealth;
	double CurrentMana;
	double ManaSpent;
	int HealthRegenTime;
	int ManaRegenTime;
	double StunDuration;

	public PlayerStats(UUID UUID, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, int EnchantingXp, int xp, String Class) {
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
		this.EnchantingXp = EnchantingXp;
		this.Class = Class;
		this.xp = xp;
		this.ChoiceCD = 0;
		this.ManaTimer = 0;
		this.HealthRegenTime = 4;
		this.ManaRegenTime = 4;
		this.StunDuration = 0;
		this.BonusHealth = 0;
		this.BonusMana = 0;
		this.BonusManaTimer = 0;
		this.BonusHealthTimer = 0;
		main();
	}

	private void main() {
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
				if (ChoiceCD < 0) {
					ChoiceCD = 0;
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
				getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1019, 255, true, false));
				getPlayer().setFoodLevel(20);
				getPlayer().setSaturatedRegenRate(1000);
				getPlayer().setUnsaturatedRegenRate(1000);
			}
		}.runTaskTimer(plugin, 0L, 5L);

		new BukkitRunnable() {
			@Override
			public void run() {
				if (null == PlayerStats.this.getPlayer()) {
					this.cancel();
					return;
				}

				int Slots = getPlayer().getInventory().getSize();
				for (int i = 0; i < Slots; i++) {
					if (null != PlayerStats.this.getPlayer().getInventory().getItem(i) && null != PlayerStats.this.getPlayer().getInventory().getItem(i).getItemMeta() && getPlayer().getInventory().getItem(i).hasItemMeta() && getPlayer().getInventory().getItem(i).getItemMeta().hasDisplayName()) {
						ItemMeta meta = getPlayer().getInventory().getItem(i).getItemMeta();
						Items.setItemLore(getPlayer().getInventory(), meta, i);
					}
				}
			}
		}.runTaskTimer(plugin, 0L, 200L);

	}


	// Set


	public void setBonusHealth(double bonusHealth) {
		this.BonusHealth = bonusHealth;
		this.CurrentHealth = CurrentHealth + bonusHealth;
	}

	public void setXp(int xp) {
		this.xp = xp;
		try {
			if(connection == null) {
				ConnectToServer();
				return;
			}
			Statement statement = connection.createStatement();
			statement.execute("UPDATE `userdata` SET `xpAmount` = '" + xp + "' WHERE `userdata`.`UUID` = '" + UUID + "'");
		} catch (SQLException err) {
			System.out.println(err);
		}
	}

	public void setBonusHealthTimer(int bonusHealthTimer) {
		this.BonusHealthTimer = bonusHealthTimer;
	}

	public void setBonusMana(double bonusMana) {
		this.BonusMana = bonusMana;
		this.CurrentMana = CurrentMana + bonusMana;
	}

	public void setBonusManaTimer(int bonusManaTimer) {
		this.BonusManaTimer = bonusManaTimer;
	}

	public void setStunDuration(double stunDuration) {
		this.StunDuration = stunDuration;
	}

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

	public void setEnchantingXp(int enchantingXp) {
		EnchantingXp = enchantingXp;
	}

	public void setClass(String aClass) {
		Class = aClass;
		try {
			if(connection != null) {
				Statement statement = connection.createStatement();;
				statement.execute("UPDATE `userdata` SET `class` = '" + aClass +"' WHERE `UUID` = '" + UUID + "'");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println(new RuntimeException(e));
		}
	}

	public void setManaSpent(double manaSpent) {
		ManaSpent = manaSpent;
	}
	// Get


	public double getStunDuration() {
		return this.StunDuration;
	}

	public double getBonusHealth() {
		return this.BonusHealth;
	}

	public double getBonusMana() {
		return this.BonusMana;
	}

	public int getBonusHealthTimer() {
		return this.BonusHealthTimer;
	}

	public int getBonusManaTimer() {
		return this.BonusManaTimer;
	}

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

	public int getEnchantingXp() {
		return EnchantingXp;
	}

	public String getPlayerClass() {
		return Class;
	}

	public int getLevel() {
		return PlayerLevels.getLevel(getPlayer());
	}

	public int getXp() {
		return xp;
	}

	public void removeMana(float amount) {
		if(BonusMana - amount < 0) {
			BonusMana = 0;
			CurrentMana = CurrentMana + BonusMana - amount;
		} else {
			BonusMana = BonusMana - amount;
		}
	}

}
