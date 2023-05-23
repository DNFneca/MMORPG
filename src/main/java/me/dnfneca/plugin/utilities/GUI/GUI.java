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
		magemeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
		magemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		magemeta.setDisplayName(ChatColor.AQUA + "Mage");
		mage.setItemMeta(magemeta);

		ItemMeta warriormeta = warrior.getItemMeta();
		warriormeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		warriormeta.setDisplayName(ChatColor.RED + "Warrior");
		warrior.setItemMeta(warriormeta);

		ItemMeta rangermeta = ranger.getItemMeta();
		rangermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
		rangermeta.setDisplayName(ChatColor.DARK_GREEN + "Ranger");
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


		switch (SubclassNumber) {
			case 1:
				ItemStack battle_mage = new ItemStack(Material.IRON_SWORD, 1);
				ItemStack wizard = new ItemStack(Material.POTION, 1);
				ItemStack healer = new ItemStack(Material.POTION, 1);
				ItemStack necromancer = new ItemStack(Material.TOTEM_OF_UNDYING, 1);


				ItemMeta battle_magemeta = battle_mage.getItemMeta();
				battle_magemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				battle_magemeta.setDisplayName(ChatColor.GREEN + "Battle Mage");
				battle_mage.setItemMeta(battle_magemeta);

				PotionMeta wizardmeta = (PotionMeta) wizard.getItemMeta();
				wizardmeta.setBasePotionData(new PotionData(PotionType.SPEED));
				wizardmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				wizardmeta.setDisplayName(ChatColor.GOLD + "Wizard");
				wizard.setItemMeta(wizardmeta);

				PotionMeta healermeta = (PotionMeta) healer.getItemMeta();
				healermeta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL));
				healermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				healermeta.setDisplayName(ChatColor.RED + "Healer");
				healer.setItemMeta(healermeta);

				ItemMeta necromancermeta = necromancer.getItemMeta();
				necromancermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				necromancermeta.setDisplayName(ChatColor.DARK_RED + "Necromancer");
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
				barbarian.setItemMeta(barbarianmeta);

				ItemMeta samuraimeta = samurai.getItemMeta();
				samuraimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				samuraimeta.setDisplayName(ChatColor.GREEN + "Samurai");
				samurai.setItemMeta(samuraimeta);

				ItemMeta paladinmeta = paladin.getItemMeta();
				paladinmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				paladinmeta.setDisplayName(ChatColor.GOLD + "Paladin");
				paladin.setItemMeta(paladinmeta);

				ItemMeta vikingmeta = viking.getItemMeta();
				vikingmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				vikingmeta.setDisplayName(ChatColor.DARK_RED + "Viking");
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
