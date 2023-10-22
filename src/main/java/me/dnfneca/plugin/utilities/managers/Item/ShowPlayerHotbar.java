package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.utilities.InventoryConverter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static me.dnfneca.plugin.Plugin.connection;

public class ShowPlayerHotbar {
	public static void ShowHotbar(Player player) {
		try {

			Statement statement = connection.createStatement();
			if (statement.execute("SELECT `Inventory` FROM `player inventories` WHERE `UUID` = '" + player.getUniqueId() + "'")) {
				ResultSet results = statement.getResultSet();
				int xpIndex = results.findColumn("Inventory");
				ItemStack[] newInv = new ItemStack[9];
				Inventory playerInventory = player.getInventory();
				while (results.next()) {
					newInv = InventoryConverter.itemStackArrayFromBase64(results.getString(xpIndex));
				}

//				System.out.println(newInv[0]);


				for (int i = 0; i < 8; i++) {
					if(playerInventory.getItem(i) == null || !(CustomItemStack.isItemCustomItem(playerInventory.getItem(i)) && CustomItemStack.getItemType(playerInventory.getItem(i)).equals("Wand"))) {
						playerInventory.setItem(i, newInv[i]);
					} else if (CustomItemStack.isItemCustomItem(playerInventory.getItem(i)) && CustomItemStack.getItemType(playerInventory.getItem(i)).equals("Wand")) {
						for (ItemStack item : newInv) {
							if(playerInventory.getItem(i) != null && playerInventory.getItem(i).equals(item)) {
								playerInventory.setItem(i, newInv[i]);
							}
						}
					}
					ItemStack newitem = new ItemStack(Material.AIR);
					newitem.setItemMeta(null);
					player.getInventory().setItemInOffHand(newitem);
				}
				ItemStack newitem = new ItemStack(Material.AIR);
				newitem.setItemMeta(null);
				player.getInventory().setItemInOffHand(newitem);
			}
			statement.close();
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void ShowHotbar(Player player, ItemStack checkForDuplicate) {
		try {

			Statement statement = connection.createStatement();
			if (statement.execute("SELECT `Inventory` FROM `player inventories` WHERE `UUID` = '" + player.getUniqueId() + "'")) {
				ResultSet results = statement.getResultSet();
				int xpIndex = results.findColumn("Inventory");
				ItemStack[] newInv = new ItemStack[9];
				Inventory playerInventory = player.getInventory();
				while (results.next()) {
					newInv = InventoryConverter.itemStackArrayFromBase64(results.getString(xpIndex));
				}

//				System.out.println(newInv[0]);

				for (int i = 0; i < 8; i++) {

					if(playerInventory.getItem(i) == null || !(CustomItemStack.isItemCustomItem(playerInventory.getItem(i)) && CustomItemStack.getItemType(playerInventory.getItem(i)).equals("Wand"))) {
						if(newInv[i] == null){
							playerInventory.setItem(i, newInv[i]);
						}else if(!checkForDuplicate.getItemMeta().getLore().equals(newInv[i].getItemMeta().getLore())){
							playerInventory.setItem(i, newInv[i]);
						}
					} else if (CustomItemStack.isItemCustomItem(playerInventory.getItem(i)) && CustomItemStack.getItemType(playerInventory.getItem(i)).equals("Wand")) {
						for (ItemStack item : newInv) {
							if(playerInventory.getItem(i) != null && playerInventory.getItem(i).equals(item)) {
								if(!checkForDuplicate.getItemMeta().getLore().equals(newInv[i].getItemMeta().getLore())) {
									playerInventory.setItem(i, newInv[i]);
								}
							}
						}
					}
					ItemStack newitem = new ItemStack(Material.AIR);
					newitem.setItemMeta(null);
					player.getInventory().setItemInOffHand(newitem);
				}
				ItemStack newitem = new ItemStack(Material.AIR);
				newitem.setItemMeta(null);
				player.getInventory().setItemInOffHand(newitem);
			}
			statement.close();
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
