package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.meta.ItemMeta;

public class Reforge {

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
    public Reforge(String Name, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, String Rarity, ItemMeta ReforgeItemMeta, String ReforgeName, int CustomLookCode, String Type, int MinimalLevelForUsage) {
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
    }
}
