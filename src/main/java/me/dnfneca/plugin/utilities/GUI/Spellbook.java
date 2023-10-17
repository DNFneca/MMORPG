package me.dnfneca.plugin.utilities.GUI;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.dnfneca.plugin.utilities.ItemStackType;
import me.dnfneca.plugin.utilities.UUIDType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import static me.dnfneca.plugin.Commands.test.itemMetaUUIDNamespaceKey;
import static me.dnfneca.plugin.Commands.test.itemUUIDNamespaceKey;
import static me.dnfneca.plugin.Plugin.connection;
import static me.dnfneca.plugin.utilities.InventoryConverter.fromBase64;

public enum Spellbook{
	;

	public static void OpenMenu(Player p) {
		{
			ItemStack item = p.getInventory().getItemInMainHand();
			ItemMeta meta = item.getItemMeta();
			if(meta.getPersistentDataContainer().has(itemUUIDNamespaceKey, new UUIDType())) {
				System.out.println(meta.getPersistentDataContainer().get(itemUUIDNamespaceKey, new UUIDType()));
				Inventory inv = Bukkit.createInventory(null, 27, "");

				String itemStack = meta.getPersistentDataContainer().get(itemMetaUUIDNamespaceKey, PersistentDataType.STRING);

				Inventory i = null;

				try {
					i = fromBase64(itemStack);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}


				Inventory inventory = Bukkit.createInventory(null, i.getSize(), meta.getDisplayName());

				inventory.setContents(i.getContents());

				p.openInventory(inventory);
//				inv.setContents(itemStack);

//				p.openInventory(inv);

//				if(connection != null) {
//					try {
//						Statement statement = connection.createStatement();
//						if (statement.execute("SELECT `xpAmount` FROM `userdata` WHERE `UUID` = '" + p.getUUID() + "'")) {
//							ResultSet results = statement.getResultSet();
//							int classIndex = results.findColumn("xpAmount");
//							while (results.next()) {
//								lastPlayerXp = results.getInt(classIndex);
//							}
//							if(lastPlayerXp > p.getXp()) {
//								p.setXp(p.getXp());
//							} else {
//								p.setXp(p.getXp() + lastPlayerXp);
//							}
//						}
//					} catch (SQLException e) {
//						throw new RuntimeException(e);
//					}
//				}
			}
//
//			ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
//			ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
//			ItemStack green_glass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
//			ItemStack mage = new ItemStack(Material.POTION, 1);
//			ItemStack warrior = new ItemStack(Material.IRON_SWORD, 1);
//			ItemStack ranger = new ItemStack(Material.BOW, 1);
//			ArrayList<String> Lore = new ArrayList<>();
//
//
//			ItemMeta meta1 = red_glass.getItemMeta();
//			meta1.setDisplayName("   ");
//			red_glass.setItemMeta(meta1);
//
//			ItemMeta meta2 = blue_glass.getItemMeta();
//			meta2.setDisplayName("   ");
//			blue_glass.setItemMeta(meta2);
//
//			ItemMeta meta3 = green_glass.getItemMeta();
//			meta3.setDisplayName("   ");
//			green_glass.setItemMeta(meta3);
//
//			PotionMeta magemeta = (PotionMeta) mage.getItemMeta();
//
//			Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Mana");
//			Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Health");
//			magemeta.setLore(Lore);
//			Lore.clear();
//			magemeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
//			magemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
//			magemeta.setDisplayName(ChatColor.AQUA + "Mage");
//			mage.setItemMeta(magemeta);
//
//			ItemMeta warriormeta = warrior.getItemMeta();
//			Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Health");
//			Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage");
//			Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Defence");
//			warriormeta.setLore(Lore);
//			Lore.clear();
//			warriormeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
//			warriormeta.setDisplayName(ChatColor.RED + "Warrior");
//			warrior.setItemMeta(warriormeta);
//
//
//
//			ItemMeta rangermeta = ranger.getItemMeta();
//			rangermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
//			rangermeta.setDisplayName(ChatColor.DARK_GREEN + "Ranger");
//			Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Damage");
//			Lore.add(ChatColor.GREEN + "⬆" + ChatColor.GRAY + " Stealth");
//			Lore.add(ChatColor.RED + "⬇" + ChatColor.GRAY + " Defence");
//			rangermeta.setLore(Lore);
//			Lore.clear();
//			ranger.setItemMeta(rangermeta);
//
//			MenuChoice(p);
//
//
//			Inventory inv = Bukkit.createInventory(null, 27, "Choose a Class");
//
//			for (int i = 0; 28 > i; i++) {
//				if (10 > i || 11 == i || 12 == i || 14 == i || 15 == i || 17 == i || 17 < i) {
//					if (0 == i || 1 == i || 2 == i || 9 == i || 11 == i || 18 == i || 19 == i || 20 == i) {
//						inv.setItem(i, blue_glass);
//					} else if (3 == i || 4 == i || 5 == i || 12 == i || 14 == i || 21 == i || 22 == i || 23 == i) {
//						inv.setItem(i, red_glass);
//					} else if (6 == i || 7 == i || 8 == i || 15 == i || 17 == i || 24 == i || 25 == i || 26 == i) {
//						inv.setItem(i, green_glass);
//					}
//				} else if (10 == i) {
//					inv.setItem(10, mage);
//				} else if (13 == i) {
//					inv.setItem(13, warrior);
//				} else if (16 == i) {
//					inv.setItem(16, ranger);
//				}
//			}
//			p.openInventory(inv);
		}
	}
}
