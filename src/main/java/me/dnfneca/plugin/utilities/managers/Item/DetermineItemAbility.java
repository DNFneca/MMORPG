package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;

import java.util.List;

public enum DetermineItemAbility {
	;

	public static void getItemAbilityLore(final List<String> Lore, final Item item) {
		Lore.add("");
		if (item.getAbility().equals("test")) {
			Lore.add(ChatColor.GOLD + "RIGHT CLICK: test");
			Lore.add(ChatColor.GRAY + "Ability Description");
			Lore.add(ChatColor.GRAY + "Mana Cost:" + ChatColor.BLUE + " 25");
		} else {
			Lore.add(ChatColor.GOLD + "RIGHT CLICK: Unknown");
			Lore.add(ChatColor.GRAY + "This has an ability (we don't know what it is either)");
		}
	}
}
