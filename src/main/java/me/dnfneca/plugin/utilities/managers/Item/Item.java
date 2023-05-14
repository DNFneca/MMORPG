// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.Material;

public class Item
{
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
    
    public Item(final String Name, final double Health, final double Damage, final double Defence, final double Strength, final double Speed, final double Mana, final double CritDamage, final double CritChance, final double Stealth, final String Ability, final String FullSetBonus, final String Rarity, final Material ItemMaterial, final String CodeName, final int CustomLookCode, final String Type, final int MinimalLevelForUsage) {
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
    
    public int getMinimalLevelForUsage() {
        return this.MinimalLevelForUsage;
    }
    
    public String getType() {
        return this.Type;
    }
    
    public String getCodeName() {
        return this.CodeName;
    }
    
    public Material getItemMaterial() {
        return this.ItemMaterial;
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
    }
    
    public String getAbility() {
        return this.Ability;
    }
    
    public String getFullSetBonus() {
        return this.FullSetBonus;
    }
}
