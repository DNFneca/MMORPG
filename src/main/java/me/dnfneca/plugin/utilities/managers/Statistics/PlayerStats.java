package me.dnfneca.plugin.utilities.managers.Statistics;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Item.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

import static me.dnfneca.plugin.listeners.PlayerJoin.Players;

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

	public PlayerStats(final UUID UUID, final double Health, final double Damage, final double Defence, final double Strength, final double Speed, final double Mana, final double CritDamage, final double CritChance, final double Stealth, final int Xp, final String Class) {
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
		ChoiceCD = 0;
		ManaTimer = 0;
		HealthRegenTime = 4;
		ManaRegenTime = 4;
        this.main();
	}

	public void main() {
        this.CurrentHealth = this.Health;
        this.CurrentMana = this.Mana;
		final Plugin plugin = Plugin.getInstance();
		if (!"none".equals(Class.replace("\"", ""))) {
            this.ChoiceCD = 1;
		}
		//
		new BukkitRunnable() {
			@Override
			public void run() {
				if (0 > ChoiceCD) {
                    PlayerStats.this.ChoiceCD = 0;
				}
				if (0 > ManaTimer) {
                    PlayerStats.this.ManaTimer--;
				}
			}
		}.runTaskTimer(plugin, 0L, 20L);

		// Calculate

		new BukkitRunnable() {
			@Override
			public void run() {
				if (null == getPlayer()) {
					cancel();
					return;
				}

				StatCalc.Calculate(PlayerStats.getPlayerStats(PlayerStats.this.UUID));


				final int Slots = PlayerStats.this.getPlayer().getInventory().getSize();
				for (int i = 0; i < Slots; i++) {
					if (null != getPlayer().getInventory().getItem(i) && null != getPlayer().getInventory().getItem(i).getItemMeta() && PlayerStats.this.getPlayer().getInventory().getItem(i).hasItemMeta() && PlayerStats.this.getPlayer().getInventory().getItem(i).getItemMeta().hasDisplayName()) {
						final ItemMeta meta = PlayerStats.this.getPlayer().getInventory().getItem(i).getItemMeta();
						Items.setItemLore(PlayerStats.this.getPlayer().getInventory(), meta, i);
					}
				}
			}
		}.runTaskTimer(plugin, 0L, 5L);


	}


	// Set


	public void setHealthRegenTime(final int healthRegenTime) {
        this.HealthRegenTime = healthRegenTime;
	}

	public void setManaRegenTime(final int manaRegenTime) {
        this.ManaRegenTime = manaRegenTime;
	}

	public void setCurrentHealth(final double currentHealth) {
        this.CurrentHealth = currentHealth;
	}

	public void setCurrentMana(final double currentMana) {
        this.CurrentMana = currentMana;
	}

	public void setChoiceCD(final int ChoiceCD) {
		this.ChoiceCD = ChoiceCD;
	}

	public void setManaTimer(final int ManaTimer) {
		this.ManaTimer = ManaTimer;
	}

	public void setUUID(final UUID UUID) {
		this.UUID = UUID;
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

	public void setMana(final double mana) {
        this.Mana = mana;
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

	public void setXp(final int xp) {
        this.Xp = xp;
	}

	public void setClass(final String aClass) {
        this.Class = aClass;
	}

	public void setManaSpent(final double manaSpent) {
        this.ManaSpent = manaSpent;
	}
	// Get


	public int getHealthRegenTime() {
		return this.HealthRegenTime;
	}

	public int getManaRegenTime() {
		return this.ManaRegenTime;
	}

	public double getManaSpent() {
		return this.ManaSpent;
	}

	public double getCurrentHealth() {
		return this.CurrentHealth;
	}

	public double getCurrentMana() {
		return this.CurrentMana;
	}

	public Player getPlayer(final UUID UUID) {
		return Bukkit.getPlayer(UUID);
	}

	public Player getPlayer() {
		return Bukkit.getPlayer(UUID);
	}

	public static PlayerStats getPlayerStats(final UUID UUID) {
		for (final PlayerStats player : Players) {
			if (player.UUID.equals(UUID)) {
				return player;
			}
		}
		return null;
	}

	public UUID getUUID() {
		return this.UUID;
	}

	public int getManaTimer() {
		return this.ManaTimer;
	}

	public int getChoiceCD() {
		return this.ChoiceCD;
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

	public double getMana() {
		return this.Mana;
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

	public int getXp() {
		return this.Xp;
	}

	public String getPlayerClass() {
		return this.Class;
	}

}
