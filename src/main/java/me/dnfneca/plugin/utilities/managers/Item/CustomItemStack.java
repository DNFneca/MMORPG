package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.InventoryConverter;
import me.dnfneca.plugin.utilities.UUIDType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

import static me.dnfneca.plugin.Commands.test.itemMetaUUIDNamespaceKey;
import static me.dnfneca.plugin.Commands.test.itemUUIDNamespaceKey;
import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.Plugin.CustomReforges;
import static me.dnfneca.plugin.utilities.managers.Item.Item.*;

public class CustomItemStack {

	public static NamespacedKey customItemNamespaceKey = new NamespacedKey(Plugin.getInstance(), "isCustomItem");
	public static NamespacedKey customItemHealthNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemHealth");
	public static NamespacedKey customItemDamageNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemDamage");
	public static NamespacedKey customItemDefenceNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemDefence");
	public static NamespacedKey customItemStrengthNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemStrength");
	public static NamespacedKey customItemSpeedNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemSpeed");
	public static NamespacedKey customItemManaNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemMana");
	public static NamespacedKey customItemCritDamageNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemCritDamage");
	public static NamespacedKey customItemCritChanceNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemCritChance");
	public static NamespacedKey customItemStealthNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemStealth");
	public static NamespacedKey customItemAbilityNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemAbility");
	public static NamespacedKey customItemFullSetBonusNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemFullSetBonus");
	public static NamespacedKey customItemNameNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemName");
	public static NamespacedKey customItemRarityNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemRarity");
	public static NamespacedKey customItemCodeNameNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemCodeName");
	public static NamespacedKey customItemCustomLookCodeNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemCustomLookCode");
	public static NamespacedKey customItemTypeNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemType");
	public static NamespacedKey customItemMinimalLevelForUsageNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemMinimalLevelForUsage");
	public static NamespacedKey customItemAttackSpeedNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemAttackSpeed");
	public static NamespacedKey customItemRarityUpgradedNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemRarityUpgraded");
	public static NamespacedKey customItemReforgeNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemReforge");
	public static NamespacedKey customReforgeNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customReforge");
	public static NamespacedKey customItemReforgedNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemReforged");
	public static NamespacedKey customItemReforgeNameNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemReforgeName");
	public static NamespacedKey customItemReforgeTypeNamespaceKey = new NamespacedKey(Plugin.getInstance(), "customItemReforgeType");

	public static ItemStack NewItem(String CodeName) {
		for (Item item: CustomItems) {
			if(item.getCodeName().contains(CodeName)) {
				ItemStack newItem = new ItemStack(item.ItemMaterial);
				ItemMeta newItemMeta = newItem.getItemMeta();
				newItemMeta.getPersistentDataContainer().set(customItemNamespaceKey, PersistentDataType.BOOLEAN, true);
				newItemMeta.getPersistentDataContainer().set(customReforgeNamespaceKey, PersistentDataType.BOOLEAN, false);
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
				newItemMeta.getPersistentDataContainer().set(customItemReforgeTypeNamespaceKey, PersistentDataType.STRING, "none");
				newItemMeta.getPersistentDataContainer().set(customItemMinimalLevelForUsageNamespaceKey, PersistentDataType.INTEGER, item.getMinimalLevelForUsage());
				newItemMeta.getPersistentDataContainer().set(customItemManaNamespaceKey, PersistentDataType.DOUBLE, item.getMana());
				newItemMeta.getPersistentDataContainer().set(customItemAttackSpeedNamespaceKey, PersistentDataType.DOUBLE, item.getAttackSpeed());
				newItemMeta.getPersistentDataContainer().set(customItemRarityUpgradedNamespaceKey, PersistentDataType.BOOLEAN, false);
				newItemMeta.getPersistentDataContainer().set(customItemReforgeNamespaceKey, PersistentDataType.STRING, "none");
				newItemMeta.getPersistentDataContainer().set(customItemNameNamespaceKey, PersistentDataType.STRING, item.getName());
				newItemMeta.getPersistentDataContainer().set(customItemReforgedNamespaceKey, PersistentDataType.BOOLEAN, false);

				if(item.getCodeName().contains("_BAG")) {
					UUID uuid = UUID.randomUUID();
					Inventory inv = null;
					ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
					ItemMeta itemM = blue_glass.getItemMeta();
					itemM.setDisplayName("   ");
					blue_glass.setItemMeta(itemM);
					if(item.getRarity().equals("Epic") || item.getRarity().equals("Legendary") || item.getRarity().equals("Mythic")) {
						inv = Bukkit.createInventory(null, 54, "Bag");
						for (int i = 0; i < 54; i++) {
							inv.setItem(i, blue_glass);
						}
					} else {
						inv = Bukkit.createInventory(null, 27, "Bag");
						for (int i = 0; i < 27; i++) {
							inv.setItem(i, blue_glass);
						}
					}


					newItemMeta.getPersistentDataContainer().set(itemUUIDNamespaceKey, new UUIDType(), uuid);
					newItemMeta.getPersistentDataContainer().set(itemMetaUUIDNamespaceKey, PersistentDataType.STRING, InventoryConverter.toBase64(inv));
				}

				if(item.getType().equals("Wand")) {
					UUID uuid = UUID.randomUUID();
					Inventory inv = null;
					ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
					ItemMeta itemM = blue_glass.getItemMeta();
					itemM.setDisplayName("   ");
					blue_glass.setItemMeta(itemM);
					inv = Bukkit.createInventory(null, 27, "Bag");
					for (int i = 0; i < 27; i++) {
						inv.setItem(i, blue_glass);
					}

					newItemMeta.getPersistentDataContainer().set(itemUUIDNamespaceKey, new UUIDType(), uuid);
					newItemMeta.getPersistentDataContainer().set(itemMetaUUIDNamespaceKey, PersistentDataType.STRING, InventoryConverter.toBase64(inv));
				}
				newItem.setItemMeta(newItemMeta);
				return newItem;
			}
		}
		for(Reforge reforge:CustomReforges) {
			if(reforge.getCodeName().contains(CodeName)) {
				ItemStack newItem = new ItemStack(reforge.getReforgeItemStack());
				UUID uuid = UUID.randomUUID();
				ItemMeta newItemMeta = newItem.getItemMeta();
				newItemMeta.getPersistentDataContainer().set(customItemNamespaceKey, PersistentDataType.BOOLEAN, true);
				newItemMeta.getPersistentDataContainer().set(customReforgeNamespaceKey, PersistentDataType.BOOLEAN, true);
				newItemMeta.getPersistentDataContainer().set(customItemHealthNamespaceKey, PersistentDataType.DOUBLE, reforge.getHealth());
				newItemMeta.getPersistentDataContainer().set(customItemDamageNamespaceKey, PersistentDataType.DOUBLE, reforge.getDamage());
				newItemMeta.getPersistentDataContainer().set(customItemDefenceNamespaceKey, PersistentDataType.DOUBLE, reforge.getDefence());
				newItemMeta.getPersistentDataContainer().set(customItemStrengthNamespaceKey, PersistentDataType.DOUBLE, reforge.getStrength());
				newItemMeta.getPersistentDataContainer().set(customItemSpeedNamespaceKey, PersistentDataType.DOUBLE, reforge.getSpeed());
				newItemMeta.getPersistentDataContainer().set(customItemCritDamageNamespaceKey, PersistentDataType.DOUBLE, reforge.getCritDamage());
				newItemMeta.getPersistentDataContainer().set(customItemCritChanceNamespaceKey, PersistentDataType.DOUBLE, reforge.getCritChance());
				newItemMeta.getPersistentDataContainer().set(customItemStealthNamespaceKey, PersistentDataType.DOUBLE, reforge.getStealth());
				newItemMeta.getPersistentDataContainer().set(customItemRarityNamespaceKey, PersistentDataType.STRING, reforge.getRarity());
				newItemMeta.getPersistentDataContainer().set(customItemReforgeTypeNamespaceKey, PersistentDataType.STRING, reforge.getType());
				newItemMeta.getPersistentDataContainer().set(customItemCustomLookCodeNamespaceKey, PersistentDataType.INTEGER, reforge.getCustomLookCode());
				newItemMeta.getPersistentDataContainer().set(customItemMinimalLevelForUsageNamespaceKey, PersistentDataType.INTEGER, reforge.getMinimalLevelForUsage());
				newItemMeta.getPersistentDataContainer().set(customItemManaNamespaceKey, PersistentDataType.DOUBLE, reforge.getMana());
				newItemMeta.getPersistentDataContainer().set(customItemRarityUpgradedNamespaceKey, PersistentDataType.BOOLEAN, false);
				newItemMeta.getPersistentDataContainer().set(customItemReforgeNamespaceKey, PersistentDataType.STRING, "None");
				newItemMeta.getPersistentDataContainer().set(customItemNameNamespaceKey, PersistentDataType.STRING, reforge.getName());
				newItemMeta.getPersistentDataContainer().set(customItemReforgeNameNamespaceKey, PersistentDataType.STRING, reforge.getReforgeName());
				newItemMeta.getPersistentDataContainer().set(itemUUIDNamespaceKey, new UUIDType(), uuid);

				newItem.setItemMeta(newItemMeta);
				return newItem;
			}
		}
		return null;
	}


	public static String getItemReforgeType(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemReforgeTypeNamespaceKey, PersistentDataType.STRING);
	}

	public static boolean isItemCustomReforge(ItemStack itemStack) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		if(itemMeta == null) {
			return false;
		}
		return itemMeta.getPersistentDataContainer().get(customReforgeNamespaceKey, PersistentDataType.BOOLEAN);
	}

	public static String getItemReforgeName(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack)) {
			return null;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemReforgeNameNamespaceKey, PersistentDataType.STRING);
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
		if(getItemAbility(itemStack) == null) {
			return "none";
		}
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
		if(itemStack == null || itemStack.getItemMeta() == null || !isItemCustomItem(itemStack)) {
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

	public static boolean isItemReforged(ItemStack itemStack) {
		if(!isItemCustomItem(itemStack) || isItemCustomReforge(itemStack)) {
			return false;
		}
		return itemStack.getItemMeta().getPersistentDataContainer().get(customItemReforgedNamespaceKey, PersistentDataType.BOOLEAN);
	}


	public static boolean copyToNewItem(ItemStack oldItemStack, ItemStack newItemStack) {
		if(!isItemCustomItem(oldItemStack) || isItemCustomReforge(oldItemStack)) {
			return false;
		}
		ItemMeta newItemMeta = oldItemStack.getItemMeta();
		newItemMeta.getPersistentDataContainer().set(customItemNamespaceKey, PersistentDataType.BOOLEAN, isItemCustomItem(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customReforgeNamespaceKey, PersistentDataType.BOOLEAN, isItemCustomReforge(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemHealthNamespaceKey, PersistentDataType.DOUBLE, getItemHealth(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemDamageNamespaceKey, PersistentDataType.DOUBLE, getItemDamage(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemDefenceNamespaceKey, PersistentDataType.DOUBLE, getItemDefence(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemStrengthNamespaceKey, PersistentDataType.DOUBLE, getItemStrength(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemSpeedNamespaceKey, PersistentDataType.DOUBLE, getItemSpeed(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemCritDamageNamespaceKey, PersistentDataType.DOUBLE, getItemCritDamage(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemCritChanceNamespaceKey, PersistentDataType.DOUBLE, getItemCritChance(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemStealthNamespaceKey, PersistentDataType.DOUBLE, getItemStealth(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemAbilityNamespaceKey, PersistentDataType.STRING, getItemAbility(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemFullSetBonusNamespaceKey, PersistentDataType.STRING, getItemFullSetBonus(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemRarityNamespaceKey, PersistentDataType.STRING, getItemRarity(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemCodeNameNamespaceKey, PersistentDataType.STRING, getItemCodeName(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemCustomLookCodeNamespaceKey, PersistentDataType.INTEGER, getItemCustomLookCode(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemTypeNamespaceKey, PersistentDataType.STRING, getItemType(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemReforgeTypeNamespaceKey, PersistentDataType.STRING, getItemReforgeType(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemMinimalLevelForUsageNamespaceKey, PersistentDataType.INTEGER, getItemMinimalLevelForUsage(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemManaNamespaceKey, PersistentDataType.DOUBLE, getItemMana(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemAttackSpeedNamespaceKey, PersistentDataType.DOUBLE, getItemAttackSpeed(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemRarityUpgradedNamespaceKey, PersistentDataType.BOOLEAN, getItemRarityUpgraded(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemReforgeNamespaceKey, PersistentDataType.STRING, getItemReforge(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemNameNamespaceKey, PersistentDataType.STRING, getItemName(oldItemStack));
		newItemMeta.getPersistentDataContainer().set(customItemReforgedNamespaceKey, PersistentDataType.BOOLEAN, isItemReforged(oldItemStack));
		newItemStack.setItemMeta(newItemMeta);
		return true;
	}


	public static boolean isItemCustomItem(ItemStack itemStack) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		if(itemMeta == null) {
			return false;
		}
		return itemMeta.getPersistentDataContainer().has(customItemNamespaceKey, PersistentDataType.BOOLEAN);
	}
}
