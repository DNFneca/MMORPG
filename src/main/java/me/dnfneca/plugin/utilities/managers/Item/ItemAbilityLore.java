package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public enum ItemAbilityLore {
	;

	public static void getItemAbilityLore(List<String> Lore, ItemStack item) {
		Lore.add("");
		if ("test".equals(CustomItemStack.getItemAbility(item).split(" ")[0])) {
			Lore.add(ChatColor.GOLD + "RIGHT CLICK: test");
			Lore.add(ChatColor.GRAY + "Ability Description");
			Lore.add(ChatColor.GRAY + "Mana Cost:" + ChatColor.BLUE + " 25");
		} else {
			Lore.add(ChatColor.GOLD + "RIGHT CLICK: " + CustomItemStack.getItemAbility(item).split(" ")[0].replace("_", " "));

			switch (CustomItemStack.getAbilityName(item)) {
				case "Reality_Warp":
					Lore.add(ChatColor.LIGHT_PURPLE + "Teleport" + ChatColor.GRAY + " yourself 10 blocks in");
					Lore.add(ChatColor.GRAY + "the direction you're looking in");
					break;
				case "Hook":
					Lore.add(ChatColor.GRAY + "Throw a hook at an enemy, when en enemy is hit");
					Lore.add(ChatColor.GRAY + "he get's " + ChatColor.LIGHT_PURPLE + "pulled " + ChatColor.GRAY + "toward you and " + ChatColor.LIGHT_PURPLE + "stunned "+ ChatColor.GRAY + "for 2 seconds");
					Lore.add(ChatColor.DARK_GRAY + "(Hitting an enemy refunds 75% of the mana cost)");
					break;
			}
		}
	}
}
