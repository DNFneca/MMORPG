<<<<<<< Updated upstream
// 
// Decompiled by Procyon v0.5.36
// 

=======
>>>>>>> Stashed changes
package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.meta.ItemMeta;

<<<<<<< Updated upstream
public class Reforge
{
=======
public class Reforge {

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
    String Name;
    String Rarity;
    ItemMeta ReforgeItemMeta;
    String ReforgeName;
    int MinimalLevelForUsage;
    String Type;
<<<<<<< Updated upstream
    
    public Reforge(final String Name, final double Health, final double Damage, final double Defence, final double Strength, final double Speed, final double Mana, final double CritDamage, final double CritChance, final double Stealth, final String Rarity, final ItemMeta ReforgeItemMeta, final String ReforgeName, final int CustomLookCode, final String Type, final int MinimalLevelForUsage) {
=======
    public Reforge(String Name, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, String Rarity, ItemMeta ReforgeItemMeta, String ReforgeName, int CustomLookCode, String Type, int MinimalLevelForUsage) {
>>>>>>> Stashed changes
        this.Name = Name;
        this.Health = Health;
        this.Damage = Damage;
        this.Defence = Defence;
        this.Strength = Strength;
        this.Speed = Speed;
        this.Mana = Mana;
        this.CritDamage = CritDamage;
        this.CritChance = CritChance;
        this.Stealth = Stealth;
        this.Rarity = Rarity;
        this.ReforgeItemMeta = ReforgeItemMeta;
        this.ReforgeName = ReforgeName;
        this.MinimalLevelForUsage = MinimalLevelForUsage;
        this.Type = Type;
    }
<<<<<<< Updated upstream
    
    public String getType() {
        return this.Type;
    }
    
    public int getMinimalLevelForUsage() {
        return this.MinimalLevelForUsage;
    }
    
    public String getReforgeName() {
        return this.ReforgeName;
    }
    
    public ItemMeta getReforgeItemMeta() {
        return this.ReforgeItemMeta;
    }
    
    public String getName() {
        return this.Name;
    }
    
    public String getRarity() {
        return this.Rarity;
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
=======
    // Get


    public String getType() {
        return Type;
    }
    public int getMinimalLevelForUsage() {
        return MinimalLevelForUsage;
    }
    public String getReforgeName() {
        return ReforgeName;
    }
    public ItemMeta getReforgeItemMeta() {
        return ReforgeItemMeta;
    }
    public String getName() {
        return Name;
    }
    public String getRarity() {
        return Rarity;
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
>>>>>>> Stashed changes
    }
}
