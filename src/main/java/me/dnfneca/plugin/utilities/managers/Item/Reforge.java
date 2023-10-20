package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.ItemStack;
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
	int CustomLookCode;
	String Name;
	String Rarity;
	String CodeName;
	ItemStack ReforgeItemStack;
	String ReforgeName;
	int MinimalLevelForUsage;
	String Type;

	public Reforge(String Name, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, String Rarity, ItemStack ReforgeItemStack, String ReforgeName, int CustomLookCode, String CodeName , String Type, int MinimalLevelForUsage) {
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
		this.ReforgeItemStack = ReforgeItemStack;
		this.ReforgeName = ReforgeName;
		this.MinimalLevelForUsage = MinimalLevelForUsage;
		this.CustomLookCode = CustomLookCode;
		this.Type = Type;
		this.CodeName = CodeName;
	}
	// Get

//	public static String getReforge
	public String getType() {
		return Type;
	}

	public String getCodeName() {
		return this.CodeName;
	}

	public int getMinimalLevelForUsage() {
		return MinimalLevelForUsage;
	}

	public String getReforgeName() {
		return ReforgeName;
	}

	public int getCustomLookCode() {
		return CustomLookCode;
	}

	public ItemStack getReforgeItemStack() {
		return ReforgeItemStack;
	}

	public ItemMeta getReforgeItemMeta() {
		return ReforgeItemStack.getItemMeta();
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
