package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static me.dnfneca.plugin.Plugin.CustomItems;

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
	double AttackSpeed;

	public Item(String Name, double Health, double Damage, double Defence, double Strength, double Speed, double Mana, double CritDamage, double CritChance, double Stealth, String Ability, String FullSetBonus, String Rarity, Material ItemMaterial, String CodeName, int CustomLookCode, String Type, int MinimalLevelForUsage, double AttackSpeed) {
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
		this.AttackSpeed = AttackSpeed;
	}
	// Get


	public double getAttackSpeed() {
		return this.AttackSpeed;
	}

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

	public String getAbilityName() {
		String[] Split = Ability.split(" ")[0].split("_");
		String Result = new String();
		if (Split[0].equals("none")) {
			return "none";
		}
		for(String s : Split) {
			Result = Result.concat(s.toUpperCase());
		}
		return Result;
	}

	public int getAbilityCost() {
		String[] Split = Ability.replace(" ", "_").split("_");
		if(Split.length == 0 || Split[0].contains("none")) {
			return 0;
		}
		return Integer.parseInt(Split[Split.length - 1]);
	}

	public String getFullSetBonus() {
		return FullSetBonus;
	}


}
