package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomReforges;

public class SetReforgeStoneLore {
	public static void SetLore(ItemStack itemStack, PlayerStats playerStats) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		String itemName = ChatColor.stripColor(itemMeta.getDisplayName());
		if (CustomItemStack.getItemName(itemStack).contains(itemName) && !itemMeta.hasLore()) {
			ChatColor color;
			List<String> Lore = new ArrayList<>();
			switch (CustomItemStack.getItemRarity(itemStack)) {
				case "Rare":
					color = ChatColor.BLUE;
					break; case "Uncommon": color = ChatColor.GREEN;
					break; case "Epic": color = ChatColor.DARK_PURPLE;
					break; case "Legendary": color = ChatColor.GOLD;
					break; case "Mythic": color = ChatColor.DARK_RED;
					break; case "Exotic": color = ChatColor.LIGHT_PURPLE;
					break; default: color = ChatColor.GRAY;
					break;
			}
			Lore.add("");
			if ("Any".equals(CustomItemStack.getItemReforgeType(itemStack))) {
				Lore.add(ChatColor.GRAY + "When applied to " + ChatColor.DARK_PURPLE + "anything" + ChatColor.GRAY + ": " + color + CustomItemStack.getItemReforgeName(itemStack));
			} else if ("Staff".equals(CustomItemStack.getItemReforgeType(itemStack))) {
				Lore.add(ChatColor.GRAY + "When applied to a staff: " + color + CustomItemStack.getItemReforgeName(itemStack));
			} else if ("Melee".equals(CustomItemStack.getItemReforgeType(itemStack))) {
				Lore.add(ChatColor.GRAY + "When applied to a melee weapon: " + color + CustomItemStack.getItemReforgeName(itemStack));
			} else if ("Bow".equals(CustomItemStack.getItemReforgeType(itemStack))) {
				Lore.add(ChatColor.GRAY + "When applied to a bow: " + color + CustomItemStack.getItemReforgeName(itemStack));
			}
			if (0 < CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemHealth(itemStack));
			} else if (0 > CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemHealth(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDamage(itemStack));
			} else if (0 > CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemDamage(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDefence(itemStack));
			} else if (0 > CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemDefence(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStrength(itemStack));
			} else if (0 > CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemStrength(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemSpeed(itemStack));
			} else if (0 > CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemSpeed(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemMana(itemStack));
			} else if (0 > CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemMana(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritDamage(itemStack));
			} else if (0 > CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemCritDamage(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritChance(itemStack));
			} else if (0 > CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemCritChance(itemStack)).replace("-", ""));
			}
			if (0 < CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStealth(itemStack));
			} else if (0 > CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemStealth(itemStack)).replace("-", ""));
			}

			if(playerStats.getLevel() < CustomItemStack.getItemMinimalLevelForUsage(itemStack)) {
				Lore.add("");
				Lore.add(ChatColor.RED + "THIS ITEM REQUIRES LEVEL " + CustomItemStack.getItemMinimalLevelForUsage(itemStack));
				Lore.add(ChatColor.RED + "YOU ARE LEVEL " + playerStats.getLevel() + ".");
			}

			Lore.add("");
			Lore.add(color + CustomItemStack.getItemRarity(itemStack));
			itemMeta.setLore(Lore);
			itemMeta.setDisplayName(color + ChatColor.stripColor(itemMeta.getDisplayName()));
			itemMeta.setUnbreakable(true);
			itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
			itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
			itemStack.setItemMeta(itemMeta);
		}
		return;
	}
}
