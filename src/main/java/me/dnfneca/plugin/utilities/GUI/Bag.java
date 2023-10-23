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

public enum Bag {
	;

	public static void OpenMenu(Player p) {

		ItemStack item = p.getInventory().getItemInMainHand();
		ItemMeta meta = item.getItemMeta();
		if(meta.getPersistentDataContainer().has(itemUUIDNamespaceKey, new UUIDType()) && !CustomItemStack.isItemCustomReforge(item) && CustomItemStack.getItemType(item).equals("Bag")) {
			Inventory inv = Bukkit.createInventory(null, 27, "");
			String itemStack = meta.getPersistentDataContainer().get(itemMetaUUIDNamespaceKey, PersistentDataType.STRING);
			Inventory i = null;
			try {
				i = fromBase64(itemStack);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			int Size = i.getSize();
			ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
			ItemMeta itemM = blue_glass.getItemMeta();
			itemM.setDisplayName("   ");
			blue_glass.setItemMeta(itemM);
			if (Size == 27 && (CustomItemStack.getItemRarity(item).equals("EPIC") || CustomItemStack.getItemRarity(item).equals("LEGENDARY") || CustomItemStack.getItemRarity(item).equals("MYTHIC"))) {
				System.out.println(CustomItemStack.getItemRarity(item));
				Size = 54;
				for (int iterator = 0; iterator < 54; iterator++) {
					if (i.getItem(iterator) == null) {
						i.setItem(iterator, blue_glass);
					}
				}
			}
			Inventory inventory = Bukkit.createInventory(null, i.getSize(), meta.getDisplayName());
			inventory.setContents(i.getContents());
			p.openInventory(inventory);
		}
	}
	public static void OpenMenu(Player p, ItemStack item) {

		ItemMeta meta = item.getItemMeta();
		if(meta.getPersistentDataContainer().has(itemUUIDNamespaceKey, new UUIDType()) && !CustomItemStack.isItemCustomReforge(item) && CustomItemStack.getItemType(item).equals("Bag")) {
			Inventory inv = Bukkit.createInventory(null, 27, "");
			String itemStack = meta.getPersistentDataContainer().get(itemMetaUUIDNamespaceKey, PersistentDataType.STRING);
			Inventory i = null;
			try {
				i = fromBase64(itemStack);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			int Size = i.getSize();
			ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
			ItemMeta itemM = blue_glass.getItemMeta();
			itemM.setDisplayName("   ");
			blue_glass.setItemMeta(itemM);
			if (Size == 27 && (CustomItemStack.getItemRarity(item).equals("EPIC") || CustomItemStack.getItemRarity(item).equals("LEGENDARY") || CustomItemStack.getItemRarity(item).equals("MYTHIC"))) {
				Size = 54;
				for (int iterator = 0; iterator < 54; iterator++) {
					if (i.getItem(iterator) == null) {
						i.setItem(iterator, blue_glass);
					}
				}
			}
			Inventory inventory = Bukkit.createInventory(null, i.getSize(), meta.getDisplayName());
			inventory.setContents(i.getContents());
			String rarity = CustomItemStack.getItemRarity(item);
			switch (rarity) {
				case "COMMON":
					for(int iter = 1; iter < 27; iter++) {
						if(inventory.getItem(iter) != null && inventory.getItem(iter).getItemMeta() != null && iter != 1 && iter != 7 &&iter!= 8 &&iter!= 9 &&iter!= 10 &&iter!= 16 &&iter!= 17 &&iter!= 18 &&iter!= 19 &&iter!= 25 &&iter!= 26 && inventory.getItem(iter).getItemMeta().getDisplayName().equals("   ")) {
							inventory.setItem(iter, null);
						}
					}
					break;
				case "UNCOMMON":
					for(int iter= 1;iter< 27; iter++) {
						if(inventory.getItem(iter) != null && inventory.getItem(iter).getItemMeta() != null && iter != 8 && iter != 9 && iter != 17 && iter != 18 && iter != 26 && inventory.getItem(iter).getItemMeta().getDisplayName().equals("   ")) {
							inventory.setItem(iter, null);
						}
					}
					break;
				case "RARE":
					for(int iter = 0; iter < 27 ; iter++) {
						if(inventory.getItem(iter) != null && inventory.getItem(iter).getItemMeta() != null && inventory.getItem(iter).getItemMeta().getDisplayName().equals("   ")) {
							inventory.setItem(iter, null);
						}
					}
					break;
				case "EPIC":
					for(int iter = 0; iter < 36 ; iter++) {
						if(inventory.getItem(iter) != null && inventory.getItem(iter).getItemMeta() != null && inventory.getItem(iter).getItemMeta().getDisplayName().equals("   ")) {
							inventory.setItem(iter, null);
						}
					}
					break;
				case "LEGENDARY":
					for(int iter = 0; iter < 45 ; iter++) {
						if(inventory.getItem(iter) != null && inventory.getItem(iter).getItemMeta() != null && inventory.getItem(iter).getItemMeta().getDisplayName().equals("   ")) {
							inventory.setItem(iter, null);
						}
					}
					break;
				case "MYTHIC":
					for(int iter = 0; iter < 54 ; iter++) {
						if(inventory.getItem(iter) != null && inventory.getItem(iter).getItemMeta() != null && inventory.getItem(iter).getItemMeta().getDisplayName().equals("   ")) {
							inventory.setItem(iter, null);
						}
					}
					break;
			}
			p.openInventory(inventory);
		}
	}
}
