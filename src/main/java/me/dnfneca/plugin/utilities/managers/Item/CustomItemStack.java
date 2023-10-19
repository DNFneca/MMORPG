package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.utilities.managers.Item.Item.*;

public class CustomItemStack {

	public static ItemStack NewItem(String CodeName) {
		for (Item item: CustomItems) {
			if(item.getCodeName().contains(CodeName)) {
				ItemStack newItem = new ItemStack(item.ItemMaterial);
				ItemMeta newItemMeta = newItem.getItemMeta();
				newItemMeta.getPersistentDataContainer().set(customItemNamespaceKey, PersistentDataType.BOOLEAN, true);
				newItemMeta.getPersistentDataContainer().set(customItemHealthNamespaceKey, PersistentDataType.DOUBLE, item.getHealth());
				newItemMeta.getPersistentDataContainer().set(customItemDamageNamespaceKey, PersistentDataType.DOUBLE, item.getDamage());
				newItemMeta.getPersistentDataContainer().set(customItemDefenceNamespaceKey, PersistentDataType.DOUBLE, item.getDefence());
				newItemMeta.getPersistentDataContainer().set(customItemStrengthNamespaceKey, PersistentDataType.DOUBLE, item.getStrength());
				newItemMeta.getPersistentDataContainer().set(customItemSpeedNamespaceKey, PersistentDataType.DOUBLE, item.getSpeed());
				newItemMeta.getPersistentDataContainer().set(customItemCritDamageNamespaceKey, PersistentDataType.DOUBLE, item.getCritDamage());
				newItemMeta.getPersistentDataContainer().set(customItemCritChanceNamespaceKey, PersistentDataType.DOUBLE, item.getCritChance());
				newItemMeta.getPersistentDataContainer().set(customItemStealthNamespaceKey, PersistentDataType.DOUBLE, item.getStealth());
				newItemMeta.getPersistentDataContainer().set(customItemAbilityNamespaceKey, PersistentDataType.STRING, item.getAbility());
				newItemMeta.getPersistentDataContainer().set(customItemFullSetBonusNamespaceKey, PersistentDataType.STRING, item.getFullSetBonus());
				newItemMeta.getPersistentDataContainer().set(customItemRarityNamespaceKey, PersistentDataType.STRING, item.getRarity());
				newItemMeta.getPersistentDataContainer().set(customItemCodeNameNamespaceKey, PersistentDataType.STRING, item.getCodeName());
				newItemMeta.getPersistentDataContainer().set(customItemCustomLookCodeNamespaceKey, PersistentDataType.INTEGER, item.getCustomLookCode());
				newItemMeta.getPersistentDataContainer().set(customItemTypeNamespaceKey, PersistentDataType.STRING, item.getType());
				newItemMeta.getPersistentDataContainer().set(customItemMinimalLevelForUsageNamespaceKey, PersistentDataType.INTEGER, item.getMinimalLevelForUsage());
				newItemMeta.getPersistentDataContainer().set(customItemManaNamespaceKey, PersistentDataType.DOUBLE, item.getMana());
				newItemMeta.getPersistentDataContainer().set(customItemAttackSpeedNamespaceKey, PersistentDataType.DOUBLE, item.getAttackSpeed());
				newItemMeta.getPersistentDataContainer().set(customItemRarityUpgradedNamespaceKey, PersistentDataType.BOOLEAN, false);
				newItemMeta.getPersistentDataContainer().set(customItemReforgeNamespaceKey, PersistentDataType.STRING, "None");
				newItemMeta.getPersistentDataContainer().set(customItemNameNamespaceKey, PersistentDataType.STRING, item.getName());
				newItem.setItemMeta(newItemMeta);
				return newItem;
			}
		}
		return null;
	}


	public static String getItemName(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemNameNamespaceKey, PersistentDataType.STRING);
	}

	public static double getItemHealth(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemHealthNamespaceKey, PersistentDataType.DOUBLE);
	}

	public static double getItemDamage(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemDamageNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static double getItemDefence(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemDefenceNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static double getItemStrength(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemStrengthNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static double getItemSpeed(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemSpeedNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static double getItemCritDamage(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemCritDamageNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static double getItemCritChance(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemCritChanceNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static double getItemStealth(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemStealthNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static String getItemAbility(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemAbilityNamespaceKey, PersistentDataType.STRING);
	}

	public static String getAbilityName(ItemStack itemStack) {
		String[] Split = getItemAbility(itemStack).split(" ")[0].split("_");
		String Result = new String();
		if (Split[0].equals("none")) {
			return "none";
		}
		for(String s : Split) {
			Result = Result.concat(s.toUpperCase());
		}
		return Result;
	}
	public static String getItemFullSetBonus(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemFullSetBonusNamespaceKey, PersistentDataType.STRING);
	}
	public static String getItemRarity(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemRarityNamespaceKey, PersistentDataType.STRING);
	}
	public static String getItemCodeName(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemCodeNameNamespaceKey, PersistentDataType.STRING);
	}

	public static int getItemCustomLookCode(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemCustomLookCodeNamespaceKey, PersistentDataType.INTEGER);
	}

	public static String getItemType(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemTypeNamespaceKey, PersistentDataType.STRING);
	}
	public static Integer getItemMinimalLevelForUsage(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemMinimalLevelForUsageNamespaceKey, PersistentDataType.INTEGER);
	}
	public static double getItemMana(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemManaNamespaceKey, PersistentDataType.DOUBLE);
	}

	public static double getItemAttackSpeed(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return 0;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemAttackSpeedNamespaceKey, PersistentDataType.DOUBLE);
	}
	public static Boolean getItemRarityUpgraded(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemRarityUpgradedNamespaceKey, PersistentDataType.BOOLEAN);
	}

	public static String getItemReforge(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemReforgeNamespaceKey, PersistentDataType.STRING);
	}


	public static boolean isItemCustomItem(ItemStack itemStack) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		if(itemMeta == null) {
			return false;
		}
		return itemMeta.getPersistentDataContainer().has(customItemNamespaceKey, PersistentDataType.BOOLEAN);
	}
}
