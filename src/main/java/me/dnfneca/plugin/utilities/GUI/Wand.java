package me.dnfneca.plugin.utilities.GUI;

import me.dnfneca.plugin.utilities.UUIDType;
import me.dnfneca.plugin.utilities.managers.Item.CustomItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;

import static me.dnfneca.plugin.Commands.test.itemMetaUUIDNamespaceKey;
import static me.dnfneca.plugin.Commands.test.itemUUIDNamespaceKey;
import static me.dnfneca.plugin.utilities.InventoryConverter.fromBase64;

public class Wand {
	public static void OpenMenu(Player p) {

		ItemStack item = p.getInventory().getItemInMainHand();
		ItemMeta meta = item.getItemMeta();
		if(!CustomItemStack.isItemCustomReforge(item) && CustomItemStack.getItemType(item).equals("Wand")) {
			Inventory inv = Bukkit.createInventory(null, 27, "");
			String itemStack = meta.getPersistentDataContainer().get(itemMetaUUIDNamespaceKey, PersistentDataType.STRING);
			Inventory i = null;
			try {
				i = fromBase64(itemStack);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
			ItemMeta itemM = blue_glass.getItemMeta();
			itemM.setDisplayName("   ");
			blue_glass.setItemMeta(itemM);
			Inventory inventory = Bukkit.createInventory(null, i.getSize(), meta.getDisplayName());
			inventory.setContents(i.getContents());
			p.openInventory(inventory);
		}
	}
}
