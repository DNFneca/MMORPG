package me.dnfneca.plugin.utilities.managers.Item;


import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.Plugin.CustomReforges;

public enum Items {
    ;

	public static ItemStack getItemStackByName(String itemName) {
		for (Item customItem : CustomItems) {
			if(ChatColor.stripColor(itemName).contains(customItem.getName())) {
				ItemStack givenItem = new ItemStack(customItem.getItemMaterial());
				ItemMeta givenItemMeta = givenItem.getItemMeta();
				givenItemMeta.setDisplayName(customItem.getName());
				givenItemMeta.setCustomModelData(customItem.getCustomLookCode());
				givenItem.setItemMeta(givenItemMeta);
				return givenItem;
			}
		}
		return null;
	}

    public static Item getCustomItemByName(String ItemName) {
		for (Item item : CustomItems) {
			if (ItemName.contains(item.Name)) {
				return item;
			}
		}
		return null;
	}

	public static Reforge getCustomReforgeByName(String ItemName) {
		for (Reforge reforge : CustomReforges) {
			if (reforge.getReforgeName().equals(ChatColor.stripColor(ItemName))) {
				return reforge;
			}
		}
		return null;
	}

	public static boolean isItemReforged(String ItemName) {
		ItemName = ChatColor.stripColor(ItemName);
		for (Item customItem : CustomItems) {
			if(ItemName.contains(customItem.getName())) {
				String reforgeName = ItemName.replace(customItem.getName(), "").replace(" ", "");
				if(null == reforgeName) return false;
				for (Reforge reforge : CustomReforges) {
					if (reforge.getReforgeName().equals(reforgeName)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static String getItemReforge(String ItemName) {
		ItemName = ChatColor.stripColor(ItemName);
		for (Item customItem : CustomItems) {
			if(ItemName.contains(customItem.getName())) {
				String reforgeName = ItemName.replace(customItem.getName(), "").replace(" ", "");
				if(null == reforgeName) return null;
				for (Reforge reforge : CustomReforges) {
					if (reforge.getReforgeName().equals(reforgeName)) {
						return reforge.getReforgeName();
					}
				}
			}
		}
		return null;
	}

	public static void setItemLore(ItemStack itemStack, PlayerStats playerStats) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		if(itemMeta == null) {
			return;
		}
		String itemName = ChatColor.stripColor(itemMeta.getDisplayName());
		if (itemName.contains("Menu") || !CustomItemStack.isItemCustomItem(itemStack)) {
			return;
		}

		if (CustomItemStack.isItemCustomReforge(itemStack)) {
			SetReforgeStoneLore.SetLore(itemStack, playerStats);
		} else {
			SetCustomItemLore.SetLore(itemStack, playerStats);
		}


	}

	public static void setItemLore(ItemStack itemStack, Player player) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		if(itemMeta == null) {
			return;
		}
		String itemName = ChatColor.stripColor(itemMeta.getDisplayName());
		if (itemName.contains("Menu") || !CustomItemStack.isItemCustomItem(itemStack)) {
			return;
		}

		if(PlayerStats.getPlayerStats(player.getUniqueId()) == null) {
			return;
		}

		if (CustomItemStack.isItemCustomReforge(itemStack)) {
			SetReforgeStoneLore.SetLore(itemStack, PlayerStats.getPlayerStats(player.getUniqueId()));
		} else {
			SetCustomItemLore.SetLore(itemStack, PlayerStats.getPlayerStats(player.getUniqueId()));
		}


	}
}
