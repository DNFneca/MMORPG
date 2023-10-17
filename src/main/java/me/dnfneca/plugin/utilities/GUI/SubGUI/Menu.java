package me.dnfneca.plugin.utilities.GUI.SubGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

import static me.dnfneca.plugin.utilities.GUI.GUI.MenuChoice;

public class Menu {
	public static void MageSubclassMenu(Player p) {


		SubclassMenu(p, 1);

	}

	public static void WarriorSubclassMenu(Player p) {


		SubclassMenu(p, 2);

	}

	public static void RangerSubclassMenu(Player p) {


		SubclassMenu(p, 3);

	}

	public static void areYouSureClassMenu(Player p) {

		ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);

		ItemMeta meta2 = blue_glass.getItemMeta();
		meta2.setDisplayName("   ");
		blue_glass.setItemMeta(meta2);

		ItemStack yes = new ItemStack(Material.GREEN_CONCRETE, 1);
		ItemStack no = new ItemStack(Material.RED_CONCRETE, 1);


		ItemMeta yesmeta = yes.getItemMeta();
		yesmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		yesmeta.setDisplayName(ChatColor.GREEN + "Yes");
		yes.setItemMeta(yesmeta);

		ItemMeta nometa = no.getItemMeta();
		nometa.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		nometa.setDisplayName(ChatColor.GOLD + "No");
		no.setItemMeta(nometa);

		Inventory inv = Bukkit.createInventory(null, 27, "Are you sure. Confirm your class");

		for (int i = 0; 27 > i; i++) {
			if (11 == i) {
				inv.setItem(11, yes);
			} else if (15 == i) {
				inv.setItem(15, no);
			} else {
				inv.setItem(i, blue_glass);
			}
		}
		p.openInventory(inv);
	}

	public static void SubclassMenu(Player p, int SubclassNumber) {
		MenuChoice(p);

		ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);

		ItemStack back = new ItemStack(Material.ARROW, 1);
		ItemMeta arrowmeta = back.getItemMeta();
		arrowmeta.setDisplayName(ChatColor.GRAY + "Back");
		back.setItemMeta(arrowmeta);

		Inventory inv = null;

		ItemMeta meta2 = blue_glass.getItemMeta();
		meta2.setDisplayName("   ");
		blue_glass.setItemMeta(meta2);

		ArrayList<String> Lore = new ArrayList<>();


		switch (SubclassNumber) {
			case 1:
				ItemStack battle_mage = new ItemStack(Material.IRON_SWORD, 1);
				ItemStack wizard = new ItemStack(Material.POTION, 1);
				ItemStack healer = new ItemStack(Material.POTION, 1);
				ItemStack necromancer = new ItemStack(Material.TOTEM_OF_UNDYING, 1);


				ItemMeta battle_magemeta = battle_mage.getItemMeta();
				battle_magemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				battle_magemeta.setDisplayName(ChatColor.GREEN + "Battle Mage");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Health: " + ChatColor.RED + "-15%");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Damage: " + ChatColor.RED + "-10%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence: " + ChatColor.GREEN + "+10%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Mana: " + ChatColor.GREEN + "+25%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "+20%");
				battle_magemeta.setLore(Lore);
				Lore.clear();
				battle_mage.setItemMeta(battle_magemeta);

				PotionMeta wizardmeta = (PotionMeta) wizard.getItemMeta();
				wizardmeta.setBasePotionData(new PotionData(PotionType.SPEED));
				wizardmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				wizardmeta.setDisplayName(ChatColor.GOLD + "Wizard");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health: " + ChatColor.GREEN + "+5%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Mana: " + ChatColor.GREEN + "+50%");
				wizardmeta.setLore(Lore);
				Lore.clear();
				wizard.setItemMeta(wizardmeta);

				PotionMeta healermeta = (PotionMeta) healer.getItemMeta();
				healermeta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL));
				healermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				healermeta.setDisplayName(ChatColor.RED + "Healer");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health: " + ChatColor.GREEN + "+10%");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Damage: " + ChatColor.RED + "-10%");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Defence: " + ChatColor.RED + "-15%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Mana: " + ChatColor.GREEN + "+50%");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "-30%");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Critical Chance: " + ChatColor.GREEN + "-10%");
				healermeta.setLore(Lore);
				Lore.clear();
				healer.setItemMeta(healermeta);

				ItemMeta necromancermeta = necromancer.getItemMeta();
				necromancermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				necromancermeta.setDisplayName(ChatColor.DARK_RED + "Necromancer");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health: " + ChatColor.GREEN + "+10%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Mana: " + ChatColor.GREEN + "+60%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "+5%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Critical Chance: " + ChatColor.GREEN + "+10%");
				necromancermeta.setLore(Lore);
				Lore.clear();
				necromancer.setItemMeta(necromancermeta);

				inv = Bukkit.createInventory(null, 27, "Choose a Mage Subclass");

				for (int i = 0; 27 > i; i++) {
					if (10 == i) {
						inv.setItem(10, battle_mage);
					} else if (12 == i) {
						inv.setItem(12, wizard);
					} else if (14 == i) {
						inv.setItem(14, healer);
					} else if (16 == i) {
						inv.setItem(16, necromancer);
					} else if (i == inv.getSize() - 9) {
						inv.setItem(i, back);
					} else {
						inv.setItem(i, blue_glass);
					}
				}
				break;
			case 2:
				ItemStack barbarian = new ItemStack(Material.NETHERITE_AXE, 1);
				ItemStack samurai = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemStack paladin = new ItemStack(Material.SHIELD, 1);
				ItemStack viking = new ItemStack(Material.IRON_AXE, 1);


				ItemMeta barbarianmeta = barbarian.getItemMeta();
				barbarianmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				barbarianmeta.setDisplayName(ChatColor.RED + "Barbarian");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage: " + ChatColor.GREEN + "+20%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Speed: " + ChatColor.GREEN + "+10%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "+25%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Chance: " + ChatColor.GREEN + "+10%");
				barbarianmeta.setLore(Lore);
				Lore.clear();
				barbarian.setItemMeta(barbarianmeta);

				ItemMeta samuraimeta = samurai.getItemMeta();
				samuraimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				samuraimeta.setDisplayName(ChatColor.GREEN + "Samurai");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health: " + ChatColor.GREEN + "+10%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage: " + ChatColor.GREEN + "+5%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Speed: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Chance: " + ChatColor.GREEN + "+15%");
				samuraimeta.setLore(Lore);
				Lore.clear();
				samurai.setItemMeta(samuraimeta);

				ItemMeta paladinmeta = paladin.getItemMeta();
				paladinmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				paladinmeta.setDisplayName(ChatColor.GOLD + "Paladin");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage: " + ChatColor.GREEN + "+10%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence: " + ChatColor.GREEN + "+20%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Chance: " + ChatColor.GREEN + "+10%");
				paladinmeta.setLore(Lore);
				Lore.clear();
				paladin.setItemMeta(paladinmeta);

				ItemMeta vikingmeta = viking.getItemMeta();
				vikingmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				vikingmeta.setDisplayName(ChatColor.DARK_RED + "Viking");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health: " + ChatColor.GREEN + "+10%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence: " + ChatColor.GREEN + "+5%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Strenght: " + ChatColor.GREEN + "+20%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Speed: " + ChatColor.GREEN + "+20%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "+5%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Chance: " + ChatColor.GREEN + "+20%");
				vikingmeta.setLore(Lore);
				Lore.clear();
				viking.setItemMeta(vikingmeta);

				inv = Bukkit.createInventory(null, 27, "Choose a Warrior Subclass");

				for (int i = 0; 27 > i; i++) {
					if (10 == i) {
						inv.setItem(10, barbarian);
					} else if (12 == i) {
						inv.setItem(12, samurai);
					} else if (14 == i) {
						inv.setItem(14, paladin);
					} else if (16 == i) {
						inv.setItem(16, viking);
					} else if (i == inv.getSize() - 9) {
						inv.setItem(i, back);
					} else {
						inv.setItem(i, blue_glass);
					}
				}
				break;

			case 3:
				ItemStack sniper = new ItemStack(Material.CROSSBOW, 1);
				ItemStack hunter = new ItemStack(Material.BOW, 1);
				ItemStack scout = new ItemStack(Material.RABBIT_FOOT, 1);
				ItemStack assassin = new ItemStack(Material.IRON_SWORD, 1);


				ItemMeta snipermeta = sniper.getItemMeta();
				snipermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				snipermeta.setDisplayName(ChatColor.DARK_GRAY + "Sniper");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Health: " + ChatColor.RED + "-10%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage: " + ChatColor.RED + "+20%");
				Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Defence: " + ChatColor.GREEN + "-5%");
				Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Speed: " + ChatColor.GREEN + "+15%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Damage: " + ChatColor.GREEN + "+5%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Critical Chance: " + ChatColor.GREEN + "+25%");
				Lore.add(ChatColor.RED + "⬆" + ChatColor.GRAY + " Stealth: " + ChatColor.GREEN + "+10%");
				snipermeta.setLore(Lore);
				Lore.clear();
				sniper.setItemMeta(snipermeta);

				ItemMeta huntermeta = hunter.getItemMeta();
				huntermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				huntermeta.setDisplayName(ChatColor.RED + "Hunter");
				hunter.setItemMeta(huntermeta);

				ItemMeta scoutmeta = scout.getItemMeta();
				scoutmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				scoutmeta.setDisplayName(ChatColor.GREEN + "Scout");
				scout.setItemMeta(scoutmeta);

				ItemMeta assassinmeta = assassin.getItemMeta();
				assassinmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				assassinmeta.setDisplayName(ChatColor.DARK_RED + "Assassin");
				assassin.setItemMeta(assassinmeta);

				inv = Bukkit.createInventory(null, 27, "Choose a Ranger Subclass");

				for (int i = 0; 27 > i; i++) {
					if (10 == i) {
						inv.setItem(10, sniper);
					} else if (12 == i) {
						inv.setItem(12, hunter);
					} else if (14 == i) {
						inv.setItem(14, scout);
					} else if (16 == i) {
						inv.setItem(16, assassin);
					} else if (i == inv.getSize() - 9) {
						inv.setItem(i, back);
					} else {
						inv.setItem(i, blue_glass);
					}
				}
				break;
		}
		p.openInventory(inv);
	}
}
