package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.utilities.InventoryConverter;
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

import static me.dnfneca.plugin.Commands.test.itemMetaUUIDNamespaceKey;
import static me.dnfneca.plugin.Plugin.connection;

public class ShowPlayerSpells {
	public static void ShowSpells(Player player, int slot) {
		try {
			Inventory playerInv = player.getInventory();
			ItemMeta newItemMeta = player.getInventory().getItemInOffHand().getItemMeta();
			for (int i = 0; i < 8; i++) {
				playerInv.setItem(i, new ItemStack(Material.AIR));
			}
			ItemStack[] newInventory = InventoryConverter.itemStackArrayFromBase64(newItemMeta.getPersistentDataContainer().get(itemMetaUUIDNamespaceKey, PersistentDataType.STRING));
			int playerSlot = 0;
			switch (slot) {
				case 0:
					for (int i = 0; i < 9; i++) {
						if(newInventory[i] != null && !newInventory[i].getItemMeta().getDisplayName().equals("   ")) {
							playerInv.setItem(playerSlot, newInventory[i]);
							playerSlot++;
						}
					}
					break;
				case 1:
					for (int i = 9; i < 18; i++) {
						if(newInventory[i] != null && !newInventory[i].getItemMeta().getDisplayName().equals("   ")) {
							playerInv.setItem(playerSlot, newInventory[i]);
							playerSlot++;
						}
					}
					break;
				case 2:
					for (int i = 18; i < 27; i++) {
						if(newInventory[i] != null && !newInventory[i].getItemMeta().getDisplayName().equals("   ")) {
							playerInv.setItem(playerSlot, newInventory[i]);
							playerSlot++;
						}
					}
					break;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
