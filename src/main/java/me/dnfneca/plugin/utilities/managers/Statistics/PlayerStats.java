<<<<<<< Updated upstream
// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Statistics;

import java.util.Iterator;
import me.dnfneca.plugin.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import me.dnfneca.plugin.utilities.managers.Item.Items;
import org.bukkit.scheduler.BukkitRunnable;
import me.dnfneca.plugin.Plugin;
import java.util.UUID;

public class PlayerStats
{
    UUID UUID;
=======
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    
    public PlayerStats(final UUID UUID, final double Health, final double Damage, final double Defence, final double Strength, final double Speed, final double Mana, final double CritDamage, final double CritChance, final double Stealth, final int Xp, final String Class) {
=======
    public PlayerStats(UUID UUID, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, int Xp, String Class) {
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        this.main();
    }
    
    public void main() {
        this.CurrentHealth = this.Health;
        this.CurrentMana = this.Mana;
        final Plugin plugin = Plugin.getInstance();
        if (!this.Class.replace("\"", "").equals("none")) {
            this.ChoiceCD = 1;
        }
        new BukkitRunnable() {
            public void run() {
                if (PlayerStats.this.ChoiceCD < 0) {
                    PlayerStats.this.ChoiceCD = 0;
                }
                if (PlayerStats.this.ManaTimer < 0) {
                    final PlayerStats this$0 = PlayerStats.this;
                    --this$0.ManaTimer;
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)plugin, 0L, 20L);
        new BukkitRunnable() {
            public void run() {
                if (PlayerStats.this.getPlayer() == null) {
                    this.cancel();
                    return;
                }
                StatCalc.Calculate(PlayerStats.getPlayerStats(PlayerStats.this.UUID));
                for (int Slots = PlayerStats.this.getPlayer().getInventory().getSize(), i = 0; i < Slots; ++i) {
                    if (PlayerStats.this.getPlayer().getInventory().getItem(i) != null && PlayerStats.this.getPlayer().getInventory().getItem(i).getItemMeta() != null && PlayerStats.this.getPlayer().getInventory().getItem(i).hasItemMeta() && PlayerStats.this.getPlayer().getInventory().getItem(i).getItemMeta().hasDisplayName()) {
                        final ItemMeta meta = PlayerStats.this.getPlayer().getInventory().getItem(i).getItemMeta();
                        Items.setItemLore((Inventory)PlayerStats.this.getPlayer().getInventory(), meta, i);
                    }
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)plugin, 0L, 5L);
    }
    
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
        return Bukkit.getPlayer(this.UUID);
    }
    
    public static PlayerStats getPlayerStats(final UUID UUID) {
        for (final PlayerStats player : PlayerJoin.Players) {
            if (player.getUUID().equals(UUID)) {
=======
        main();
    }

    public void main() {
        CurrentHealth = Health;
        CurrentMana = Mana;
        Plugin plugin = Plugin.getInstance();
        if(!Class.replace("\"", "").equals("none")) {
            ChoiceCD = 1;
        }
        //
        new BukkitRunnable() {
            @Override
            public void run() {
                if(ChoiceCD < 0) {
                    ChoiceCD = 0;
                }
                if(ManaTimer < 0) {
                    ManaTimer--;
                }
            }
        }.runTaskTimer(plugin , 0L, 20L);

        // Calculate

        new BukkitRunnable() {
            @Override
            public void run() {
                    if(getPlayer() == null) {
                        this.cancel();
                        return;
                    }

                    StatCalc.Calculate(getPlayerStats(UUID));


                    int Slots = getPlayer().getInventory().getSize();
                    for (int i = 0; i < Slots; i++) {
                        if(getPlayer().getInventory().getItem(i) != null && getPlayer().getInventory().getItem(i).getItemMeta() != null && getPlayer().getInventory().getItem(i).hasItemMeta() && getPlayer().getInventory().getItem(i).getItemMeta().hasDisplayName()) {
                                ItemMeta meta = getPlayer().getInventory().getItem(i).getItemMeta();
                            Items.setItemLore(getPlayer().getInventory(), meta, i);
                        }
                    }
            }
        }.runTaskTimer(plugin , 0L, 5L);


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
            if(player.getUUID().equals(UUID)) {
>>>>>>> Stashed changes
                return player;
            }
        }
        return null;
    }
<<<<<<< Updated upstream
    
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
=======

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

>>>>>>> Stashed changes
}
