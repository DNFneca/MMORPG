package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomReforgeByName;

public class SetItemReforgeLore {
	public static void SetLore(List<String> Lore, ItemStack itemStack, String reforge) {
		Reforge reforgeStats = getCustomReforgeByName(reforge.replace(" ", ""));
		if (0 < reforgeStats.Health) {
			if (0 < CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemHealth(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Health + ")");
			} else if (0 > CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemHealth(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Health + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GRAY + " " + (int) CustomItemStack.getItemHealth(itemStack) + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Health + ")");
			}
		} else if (0 > reforgeStats.Health) {
			if (0 < CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemHealth(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemHealth(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemHealth(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemHealth(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GRAY + " " + (int) CustomItemStack.getItemHealth(itemStack) + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemHealth(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemHealth(itemStack));
			} else if (0 > CustomItemStack.getItemHealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemHealth(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.getDamage()) {
			if (0 < CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDamage(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Damage + ")");
			} else if (0 > CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDamage(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Damage + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Damage + ")");
			}
		} else if (0 > reforgeStats.getDamage()) {
			if (0 < CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDamage(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDamage(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDamage(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDamage(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDamage(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDamage(itemStack));
			} else if (0 > CustomItemStack.getItemDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemDamage(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.getDefence()) {
			if (0 < CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDefence(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Defence + ")");
			} else if (0 > CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDefence(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Defence + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Defence + ")");
			}
		} else if (0 > reforgeStats.getDefence()) {
			if (0 < CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDefence(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDefence(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDefence(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDefence(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDefence(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDefence(itemStack));
			} else if (0 > CustomItemStack.getItemDefence(itemStack)) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemDefence(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.getStrength()) {
			if (0 < CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStrength(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Strength + ")");
			} else if (0 > CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStrength(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Strength + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Strength + ")");
			}
		} else if (0 > reforgeStats.getStrength()) {
			if (0 < CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStrength(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStrength(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStrength(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStrength(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStrength(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStrength(itemStack));
			} else if (0 > CustomItemStack.getItemStrength(itemStack)) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemStrength(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.getSpeed()) {
			if (0 < CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemSpeed(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Speed + ")");
			} else if (0 > CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemSpeed(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Speed + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Speed + ")");
			}
		} else if (0 > reforgeStats.getSpeed()) {
			if (0 < CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemSpeed(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemSpeed(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemSpeed(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemSpeed(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemSpeed(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemSpeed(itemStack));
			} else if (0 > CustomItemStack.getItemSpeed(itemStack)) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemSpeed(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.getMana()) {
			if (0 < CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemMana(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Mana + ")");
			} else if (0 > CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemMana(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Mana + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Mana + ")");
			}
		} else if (0 > reforgeStats.getMana()) {
			if (0 < CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemMana(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemMana(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemMana(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemMana(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemMana(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemMana(itemStack));
			} else if (0 > CustomItemStack.getItemMana(itemStack)) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemMana(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.getCritDamage()) {
			if (0 < CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritDamage(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.CritDamage + ")");
			} else if (0 > CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritDamage(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.CritDamage + ")");
			} else {
				Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.CritDamage + ")");
			}
		} else if (0 > reforgeStats.getCritDamage()) {
			if (0 < CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritDamage(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritDamage(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritDamage(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritDamage(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritDamage(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritDamage(itemStack));
			} else if (0 > CustomItemStack.getItemCritDamage(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemCritDamage(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.CritChance) {
			if (0 < CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritChance(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.CritChance + ")");
			} else if (0 > CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritChance(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.CritChance + ")");
			} else {
				Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.CritChance + ")");
			}
		} else if (0 > reforgeStats.CritChance) {
			if (0 < CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritChance(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritChance(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritChance(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritChance(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritChance(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritChance(itemStack));
			} else if (0 > CustomItemStack.getItemCritChance(itemStack)) {
				Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemCritChance(itemStack)).replace("-", ""));
			}
		}
		if (0 < reforgeStats.Stealth) {
			if (0 < CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStealth(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Stealth + ")");
			} else if (0 > CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStealth(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Stealth + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforgeStats.Stealth + ")");
			}
		} else if (0 > reforgeStats.Stealth) {
			if (0 < CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStealth(itemStack) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStealth(itemStack)) + ")");
			} else if (0 > CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStealth(itemStack)) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStealth(itemStack)) + ")");
			} else {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStealth(itemStack)) + ")");
			}
		} else {
			if (0 < CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStealth(itemStack));
			} else if (0 > CustomItemStack.getItemStealth(itemStack)) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) CustomItemStack.getItemStealth(itemStack)).replace("-", ""));
			}
		}
	}
}
