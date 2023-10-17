package me.dnfneca.plugin.utilities.GUI;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Plugin.Players;


public enum GUI {
	;

	public static void MainMenu(Player p) {
		List<String> lore = new ArrayList<>();


		Inventory inv = Bukkit.createInventory(null, 54, "Main Menu");

		ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
		ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
		ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);
		ItemStack classes = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		ItemStack levels = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);

		SkullMeta headdata = (SkullMeta) player_head.getItemMeta();
		headdata.setOwningPlayer(p);
		headdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		headdata.setDisplayName(ChatColor.RED + "Stats");
		player_head.setItemMeta(headdata);

		ItemMeta levelsData = levels.getItemMeta();
		levelsData.setDisplayName(ChatColor.BLUE + "Levels");
		levels.setItemMeta(levelsData);

		LeatherArmorMeta classesdata = (LeatherArmorMeta) classes.getItemMeta();
		classesdata.setDisplayName(ChatColor.GREEN + "Class");
		classesdata.setColor(Color.PURPLE);
		classesdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DYE);
		classes.setItemMeta(classesdata);

		ItemMeta data1 = purple_glass.getItemMeta();
		data1.setDisplayName("   ");
		purple_glass.setItemMeta(data1);
		ItemMeta data2 = blue_glass.getItemMeta();
		data2.setDisplayName("   ");
		blue_glass.setItemMeta(data2);


		for (int i = 0; 53 >= i; i++) {
			if (8 >= i || 11 == i || 15 == i || 20 == i || 24 == i || 36 == i || 40 == i || 44 == i || 45 == i || 49 == i || 53 == i) {
				inv.setItem(i, purple_glass);
			} else if (22 == i) {
				inv.setItem(22, player_head);
			} else if (38 == i) {
				inv.setItem(38, classes);
			} else if (42 == i) {
				inv.setItem(42, levels);
			} else {
				inv.setItem(i, blue_glass);
			}
		}
//        ItemStack clay = new ItemStack(CLAY, 64);
//        ItemMeta clayMeta = clay.getItemMeta();
//        lore.add(ChatColor.DARK_PURPLE + "Staff");
//        clayMeta.setLore(lore);
//        clay.setItemMeta(clayMeta);
//        inv.addItem(clay);
		p.openInventory(inv);
	}

	public static void StatsMenu(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "Stats");


		ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
		ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
		ItemStack arrow = new ItemStack(Material.ARROW, 1);
		ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);
		ItemStack damage = new ItemStack(Material.IRON_SWORD, 1);
		ItemStack defence = new ItemStack(Material.SHIELD, 1);
		ItemStack strength = new ItemStack(Material.IRON_AXE, 1);
		ItemStack speed = new ItemStack(Material.POTION, 1);
		ItemStack mana = new ItemStack(Material.POTION, 1);
		ItemStack critdamage = new ItemStack(Material.POTION, 1);
		ItemStack critchance = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemStack stealth = new ItemStack(Material.RABBIT_FOOT, 1);


		PlayerStats p = PlayerStats.getPlayerStats(player.getUniqueId());

		SkullMeta healthdata = (SkullMeta) player_head.getItemMeta();
		healthdata.setOwningPlayer(player);
		healthdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + p.getHealth());
		player_head.setItemMeta(healthdata);


		ItemMeta arrowmeta = arrow.getItemMeta();
		arrowmeta.setDisplayName(ChatColor.GRAY + "Back to Main Menu");
		arrow.setItemMeta(arrowmeta);


		ItemMeta damagemeta = damage.getItemMeta();
		damagemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + p.getDamage());
		damage.setItemMeta(damagemeta);

		ItemMeta defencemeta = defence.getItemMeta();
		defencemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + p.getDefence());
		defence.setItemMeta(defencemeta);

		ItemMeta strengthmeta = strength.getItemMeta();
		strengthmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		strengthmeta.setDisplayName(ChatColor.GRAY + "Strength: " + ChatColor.RED + p.getStrength());
		strength.setItemMeta(strengthmeta);

		PotionMeta speedmeta = (PotionMeta) speed.getItemMeta();
		speedmeta.setBasePotionData(new PotionData(PotionType.SPEED));
		speedmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + p.getSpeed());
		speed.setItemMeta(speedmeta);

		PotionMeta manameta = (PotionMeta) mana.getItemMeta();
		manameta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
		manameta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		manameta.setDisplayName(ChatColor.GRAY + "Mana: " + ChatColor.AQUA + p.getMana());
		mana.setItemMeta(manameta);

		PotionMeta critdmeta = (PotionMeta) critdamage.getItemMeta();
		critdmeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
		critdmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + p.getCritDamage() + "%");
		critdamage.setItemMeta(critdmeta);

		ItemMeta critcmeta = critchance.getItemMeta();
		critcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + p.getCritChance() + "%");
		critchance.setItemMeta(critcmeta);

		ItemMeta stealthdata = stealth.getItemMeta();
		stealthdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		stealthdata.setDisplayName(ChatColor.GRAY + "Stealth: " + ChatColor.DARK_GRAY + p.getStealth() + "%");
		stealth.setItemMeta(stealthdata);


		ItemMeta data1 = purple_glass.getItemMeta();
		data1.setDisplayName("   ");
		purple_glass.setItemMeta(data1);
		ItemMeta data2 = blue_glass.getItemMeta();
		data2.setDisplayName("   ");
		blue_glass.setItemMeta(data2);

		for (int i = 0; 53 >= i; i++) {
			if (45 == i) {
				inv.setItem(45, arrow);
			} else if (2 >= i || 6 == i || 7 == i || 8 == i || 9 == i || 17 == i || 18 == i || 26 == i || 27 == i || 42 < i || 35 == i || 36 == i || 37 == i) {
				inv.setItem(i, purple_glass);
			} else if (13 == i) {
				inv.setItem(13, player_head);
			} else if (20 == i) {
				inv.setItem(20, damage);
			} else if (21 == i) {
				inv.setItem(21, defence);
			} else if (22 == i) {
				inv.setItem(22, strength);
			} else if (23 == i) {
				inv.setItem(23, speed);
			} else if (24 == i) {
				inv.setItem(24, mana);
			} else if (30 == i) {
				inv.setItem(30, critdamage);
			} else if (31 == i) {
				inv.setItem(31, critchance);
			} else if (32 == i) {
				inv.setItem(32, stealth);
			} else {
				inv.setItem(i, blue_glass);
			}
		}
//        ItemStack clay = new ItemStack(CLAY, 64);
//        ItemMeta clayMeta = clay.getItemMeta();
//        lore.add(ChatColor.DARK_PURPLE + "Staff");
//        clayMeta.setLore(lore);
//        clay.setItemMeta(clayMeta);
//        inv.addItem(clay);
		player.openInventory(inv);
	}

	public static void ChooseClassesMenu(Player p) {
		ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
		ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
		ItemStack green_glass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
		ItemStack mage = new ItemStack(Material.POTION, 1);
		ItemStack warrior = new ItemStack(Material.IRON_SWORD, 1);
		ItemStack ranger = new ItemStack(Material.BOW, 1);
		ArrayList<String> Lore = new ArrayList<>();


		ItemMeta meta1 = red_glass.getItemMeta();
		meta1.setDisplayName("   ");
		red_glass.setItemMeta(meta1);

		ItemMeta meta2 = blue_glass.getItemMeta();
		meta2.setDisplayName("   ");
		blue_glass.setItemMeta(meta2);

		ItemMeta meta3 = green_glass.getItemMeta();
		meta3.setDisplayName("   ");
		green_glass.setItemMeta(meta3);

		PotionMeta magemeta = (PotionMeta) mage.getItemMeta();

		Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Mana");
		Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Health");
		magemeta.setLore(Lore);
		Lore.clear();
		magemeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
		magemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		magemeta.setDisplayName(ChatColor.AQUA + "Mage");
		mage.setItemMeta(magemeta);

		ItemMeta warriormeta = warrior.getItemMeta();
		Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health");
		Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage");
		Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence");
		warriormeta.setLore(Lore);
		Lore.clear();
		warriormeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		warriormeta.setDisplayName(ChatColor.RED + "Warrior");
		warrior.setItemMeta(warriormeta);



		ItemMeta rangermeta = ranger.getItemMeta();
		rangermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		rangermeta.setDisplayName(ChatColor.DARK_GREEN + "Ranger");
		Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage");
		Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Stealth");
		Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Defence");
		rangermeta.setLore(Lore);
		Lore.clear();
		ranger.setItemMeta(rangermeta);

		MenuChoice(p);


		Inventory inv = Bukkit.createInventory(null, 27, "Choose a Class");

		for (int i = 0; 28 > i; i++) {
			if (10 > i || 11 == i || 12 == i || 14 == i || 15 == i || 17 == i || 17 < i) {
				if (0 == i || 1 == i || 2 == i || 9 == i || 11 == i || 18 == i || 19 == i || 20 == i) {
					inv.setItem(i, blue_glass);
				} else if (3 == i || 4 == i || 5 == i || 12 == i || 14 == i || 21 == i || 22 == i || 23 == i) {
					inv.setItem(i, red_glass);
				} else if (6 == i || 7 == i || 8 == i || 15 == i || 17 == i || 24 == i || 25 == i || 26 == i) {
					inv.setItem(i, green_glass);
				}
			} else if (10 == i) {
				inv.setItem(10, mage);
			} else if (13 == i) {
				inv.setItem(13, warrior);
			} else if (16 == i) {
				inv.setItem(16, ranger);
			}
		}
		p.openInventory(inv);
	}

	public static void MenuChoice(Player p) {
		for (PlayerStats player : Players) {
			if (player.getUUID().toString().equals(p.getPlayer().getUniqueId().toString())) {
				player.setChoiceCD(1);
				new BukkitRunnable() {
					@Override
					public void run() {
						player.setChoiceCD(0);
					}
				}.runTaskLater(Plugin.getInstance(), 5L);
			}
		}


	}
}
