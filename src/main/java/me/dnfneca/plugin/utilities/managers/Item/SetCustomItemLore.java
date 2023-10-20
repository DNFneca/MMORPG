package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomReforgeByName;

public class SetCustomItemLore {
	public static void SetLore(ItemStack itemStack, PlayerStats playerStats) {
		ChatColor color;
		ItemMeta itemMeta = itemStack.getItemMeta();
		String itemName = itemMeta.getDisplayName();



//		if (null != itemInQ && itemInQ.getItemMeta().hasLore() && null == reforge) {
//			return;
//		}
//
//
//


		switch (CustomItemStack.getItemRarity(itemStack)) {
			case "Rare":
				color = ChatColor.BLUE;
				break;
			case "Uncommon":
				color = ChatColor.GREEN;
				break;
			case "Epic":
				color = ChatColor.DARK_PURPLE;
				break;
			case "Legendary":
				color = ChatColor.GOLD;
				break;
			case "Mythic":
				color = ChatColor.DARK_RED;
				break;
			case "Exotic":
				color = ChatColor.LIGHT_PURPLE;
				break;
			default:
				color = ChatColor.GRAY;
				break;
		}
		itemMeta.setDisplayName(color + itemMeta.getDisplayName());
		List<String> Lore = new ArrayList<>();

		if(CustomItemStack.getItemType(itemStack).equals("Bag")) {
			Lore.add("");
			Lore.add(color + CustomItemStack.getItemRarity(itemStack));
			itemMeta.setLore(Lore);
			itemStack.setItemMeta(itemMeta);
			return;
		}
		Lore.add("");

		String reforge = CustomItemStack.getItemReforgeName(itemStack);

		if (reforge == null) {
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
			} else if (0 > CustomItemStack.getItemSpeed(itemStack)) {
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
		} else {
			SetItemReforgeLore.SetLore(Lore, itemStack, reforge);
		}




		if (!CustomItemStack.getItemAbility(itemStack).equals("none")) {
			ItemAbilityLore.getItemAbilityLore(Lore, itemStack);
			if (CustomItemStack.getAbilityName(itemStack).split(" ").length > 0) {
				Lore.add(ChatColor.GRAY + "Mana Cost: " + ChatColor.AQUA + CustomItemStack.getItemAbility(itemStack).split(" ")[1]);
			}
		}

		if(playerStats.getLevel() < CustomItemStack.getItemMinimalLevelForUsage(itemStack)) {
			Lore.add("");
			Lore.add(ChatColor.RED + "THIS ITEM REQUIRES LEVEL " + CustomItemStack.getItemMinimalLevelForUsage(itemStack));
			Lore.add(ChatColor.RED + "YOU ARE LEVEL " + playerStats.getLevel() + ".");
		}

		Lore.add("");
		Lore.add(color + CustomItemStack.getItemRarity(itemStack));
		itemMeta.setLore(Lore);

		if (itemStack.getItemMeta().getLore() != null) {
			if (itemMeta.getDisplayName().equals(itemStack.getItemMeta().getDisplayName()) && itemStack.getItemMeta().getLore().equals(Lore)) {
				return;
			}
		}

		if (!CustomItemStack.isItemCustomReforge(itemStack)) {
			if (0 != CustomItemStack.getItemAttackSpeed(itemStack)) {
				itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "attack_speed", (CustomItemStack.getItemAttackSpeed(itemStack) * 1), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
			}
		}
//        itemMeta.setAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED = 0);


		itemMeta.setUnbreakable(true);
		itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		itemStack.setItemMeta(itemMeta);
	}
}
