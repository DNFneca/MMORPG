package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.Material;

public class Item {

    double Health;
    double Damage;
    double Defence;
    double Strength;
    double Speed;
    double Mana;
    double CritDamage;
    double CritChance;
    double Stealth;
    String Ability;
    String FullSetBonus;
    String Name;
    String Rarity;
    Material ItemMaterial;
    String CodeName;
    int CustomLookCode;
    String Type;
    int MinimalLevelForUsage;
    public Item(String Name, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, String Ability, String FullSetBonus, String Rarity, Material ItemMaterial, String CodeName, int CustomLookCode, String Type, int MinimalLevelForUsage) {
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
        this.Ability = Ability;
        this.FullSetBonus = FullSetBonus;
        this.Rarity = Rarity;
        this.ItemMaterial = ItemMaterial;
        this.CodeName = CodeName;
        this.CustomLookCode = CustomLookCode;
        this.Type = Type;
        this.MinimalLevelForUsage = MinimalLevelForUsage;
    }
    // Get


    public int getMinimalLevelForUsage() {
        return MinimalLevelForUsage;
    }
    public String getType() {
        return Type;
    }
    public String getCodeName() {
        return CodeName;
    }
    public Material getItemMaterial() {
        return ItemMaterial;
    }

    public int getCustomLookCode() {
        return CustomLookCode;
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
    public String getAbility() {
        return Ability;
    }
    public String getFullSetBonus() {
        return FullSetBonus;
    }
}
