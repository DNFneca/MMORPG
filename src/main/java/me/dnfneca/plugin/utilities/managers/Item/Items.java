package me.dnfneca.plugin.utilities.managers.Item;


import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
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
import static me.dnfneca.plugin.utilities.managers.Item.ItemAbilityLore.getItemAbilityLore;

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

	public static void setItemLore(ItemStack itemStack) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		String itemName = ChatColor.stripColor(itemMeta.getDisplayName());
		if (itemName.contains("Menu")) {
			return;
		}
		// TODO: FIX LATER

		ChatColor color;
		if (!CustomItemStack.isItemCustomItem(itemStack)) {
			for (Reforge customReforge : CustomReforges) {
				if(customReforge.getName().contains(itemName) && !itemMeta.hasLore()) {
					List<String> Lore = new ArrayList<>();
					switch (customReforge.getRarity()) {
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
					Lore.add("");
					if("Any".equals(customReforge.getType())) {
						Lore.add(ChatColor.GRAY + "When applied to " + ChatColor.DARK_PURPLE + "anything" + ChatColor.GRAY + ": " + color + customReforge.getReforgeName());
					} else if("Staff".equals(customReforge.getType())) {
						Lore.add(ChatColor.GRAY + "When applied to a staff: " + color + customReforge.getReforgeName());
					} else if("Melee".equals(customReforge.getType())) {
						Lore.add(ChatColor.GRAY + "When applied to a melee weapon: " + color + customReforge.getReforgeName());
					} else if("Bow".equals(customReforge.getType())) {
						Lore.add(ChatColor.GRAY + "When applied to a bow: " + color + customReforge.getReforgeName());
					}
					if(0 < customReforge.getHealth()) {
						Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.Health);
					} else if(0 > customReforge.getHealth()) {
						Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.Health).replace("-", ""));
					}
					if (0 < customReforge.getDamage()) {
						Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.Damage);
					} else if (0 > customReforge.Damage) {
						Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.Damage).replace("-", ""));
					}
					if (0 < customReforge.Defence) {
						Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.Defence);
					} else if (0 > customReforge.Defence) {
						Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.Defence).replace("-", ""));
					}
					if (0 < customReforge.Strength) {
						Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.Strength);
					} else if (0 > customReforge.Strength) {
						Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.Strength).replace("-", ""));
					}
					if (0 < customReforge.Speed) {
						Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.Speed);
					} else if (0 > customReforge.Speed) {
						Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.Speed).replace("-", ""));
					}
					if (0 < customReforge.Mana) {
						Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.Mana);
					} else if (0 > customReforge.Speed) {
						Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.Mana).replace("-", ""));
					}
					if (0 < customReforge.CritDamage) {
						Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.CritDamage);
					} else if (0 > customReforge.CritDamage) {
						Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.CritDamage).replace("-", ""));
					}
					if (0 < customReforge.CritChance) {
						Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.CritChance);
					} else if (0 > customReforge.CritChance) {
						Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.CritChance).replace("-", ""));
					}
					if (0 < customReforge.Stealth) {
						Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) customReforge.Stealth);
					} else if (0 > customReforge.Stealth) {
						Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) customReforge.Stealth).replace("-", ""));
					}
					Lore.add("");
					Lore.add(color + customReforge.getRarity());
					itemMeta.setLore(Lore);
					itemMeta.setDisplayName(color + ChatColor.stripColor(itemMeta.getDisplayName()));
					itemStack.setItemMeta(itemMeta);
				}
			}
			return;
		}
		String reforgeName = itemName.replace(CustomItemStack.getItemReforge(itemStack), "");
		Reforge reforge = getCustomReforgeByName(reforgeName.replace(" ", ""));


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

		Lore.add("");


		if (null == reforge) {
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
			if (0 < reforge.Health) {
				if (0 < CustomItemStack.getItemHealth(itemStack)) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemHealth(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Health + ")");
				} else if (0 > CustomItemStack.getItemHealth(itemStack)) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemHealth(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Health + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GRAY + " " + (int) CustomItemStack.getItemHealth(itemStack) + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Health + ")");
				}
			} else if (0 > reforge.Health) {
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
			if (0 < reforge.Damage) {
				if (0 < CustomItemStack.getItemDamage(itemStack)) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDamage(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
				} else if (0 > CustomItemStack.getItemDamage(itemStack)) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDamage(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
				}
			} else if (0 > reforge.Damage) {
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
			if (0 < reforge.Defence) {
				if (0 < CustomItemStack.getItemDefence(itemStack)) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemDefence(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
				} else if (0 > CustomItemStack.getItemDefence(itemStack)) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemDefence(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
				}
			} else if (0 > reforge.Defence) {
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
			if (0 < reforge.Strength) {
				if (0 < CustomItemStack.getItemStrength(itemStack)) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStrength(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
				} else if (0 > CustomItemStack.getItemStrength(itemStack)) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStrength(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
				}
			} else if (0 > reforge.Strength) {
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
			if (0 < reforge.Speed) {
				if (0 < CustomItemStack.getItemSpeed(itemStack)) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemSpeed(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
				} else if (0 > CustomItemStack.getItemSpeed(itemStack)) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemSpeed(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
				}
			} else if (0 > reforge.Speed) {
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
			if (0 < reforge.Mana) {
				if (0 < CustomItemStack.getItemMana(itemStack)) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemMana(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
				} else if (0 > CustomItemStack.getItemMana(itemStack)) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemMana(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
				}
			} else if (0 > reforge.Mana) {
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
			if (0 < reforge.CritDamage) {
				if (0 < CustomItemStack.getItemCritDamage(itemStack)) {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritDamage(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
				} else if (0 > CustomItemStack.getItemCritDamage(itemStack)) {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritDamage(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
				} else {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
				}
			} else if (0 > reforge.CritDamage) {
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
			if (0 < reforge.CritChance) {
				if (0 < CustomItemStack.getItemCritChance(itemStack)) {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemCritChance(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
				} else if (0 > CustomItemStack.getItemCritChance(itemStack)) {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemCritChance(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
				} else {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
				}
			} else if (0 > reforge.CritChance) {
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
			if (0 < reforge.Stealth) {
				if (0 < CustomItemStack.getItemStealth(itemStack)) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) CustomItemStack.getItemStealth(itemStack) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
				} else if (0 > CustomItemStack.getItemStealth(itemStack)) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * CustomItemStack.getItemStealth(itemStack)) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
				}
			} else if (0 > reforge.Stealth) {
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


		if (!"none".equals(CustomItemStack.getItemAbility(itemStack))) {
			getItemAbilityLore(Lore, itemStack);
			if(1 < CustomItemStack.getAbilityName(itemStack).split(" ").length) {
				Lore.add(ChatColor.GRAY + "Mana Cost: " + ChatColor.AQUA + CustomItemStack.getItemAbility(itemStack).split(" ")[1]);
			} else {
				Lore.add(ChatColor.GRAY + "Mana Cost: " + ChatColor.AQUA + "0");
			}
		}
		Lore.add("");
		Lore.add(color + CustomItemStack.getItemRarity(itemStack));
		itemMeta.setLore(Lore);

		if(itemMeta.getDisplayName().equals(itemStack.getItemMeta().getDisplayName()) && itemStack.getItemMeta().getLore().equals(Lore)) {
			return;
		}

		if(0 != CustomItemStack.getItemAttackSpeed(itemStack)) {
			itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "attack_speed", (CustomItemStack.getItemAttackSpeed(itemStack) * 1), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
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
