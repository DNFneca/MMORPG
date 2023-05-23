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
import static me.dnfneca.plugin.utilities.managers.Item.DetermineItemAbility.getItemAbilityLore;

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
		for (final Item customItem : CustomItems) {
			if(ItemName.contains(customItem.getName())) {
				final String reforgeName = ItemName.replace(customItem.getName(), "").replace(" ", "");
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
		for (final Item customItem : CustomItems) {
			if(ItemName.contains(customItem.getName())) {
				final String reforgeName = ItemName.replace(customItem.getName(), "").replace(" ", "");
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

	public static void setItemLore(Inventory inventory, ItemMeta itemMeta, int itemSlot) {
		final ItemMeta originalMeta = itemMeta.clone();
		String itemName = ChatColor.stripColor(itemMeta.getDisplayName());
		if (itemName.contains("Menu")) {
			return;
		}
		Item item = getCustomItemByName(ChatColor.stripColor(itemName));
		ItemStack itemInQ = inventory.getItem(itemSlot);

		ChatColor color;
		if (null == item) {
			for (final Reforge customReforge : CustomReforges) {
				if(customReforge.getName().contains(itemName) && !itemMeta.hasLore()) {
					final List<String> Lore = new ArrayList<>();
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
					itemInQ.setItemMeta(itemMeta);

				}
			}
			return;
		}
		String reforgeName = itemName.replace(item.Name, "");
		Reforge reforge = getCustomReforgeByName(reforgeName.replace(" ", ""));


		if (null != itemInQ && itemInQ.getItemMeta().hasLore() && null == reforge) {
			return;
		}
//
//
//

		switch (item.getRarity()) {
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
			if (0 < item.Health) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Health);
			} else if (0 > item.Health) {
				Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Health).replace("-", ""));
			}
			if (0 < item.Damage) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Damage);
			} else if (0 > item.Damage) {
				Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Damage).replace("-", ""));
			}
			if (0 < item.Defence) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Defence);
			} else if (0 > item.Defence) {
				Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Defence).replace("-", ""));
			}
			if (0 < item.Strength) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Strength);
			} else if (0 > item.Strength) {
				Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Strength).replace("-", ""));
			}
			if (0 < item.Speed) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Speed);
			} else if (0 > item.Speed) {
				Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Speed).replace("-", ""));
			}
			if (0 < item.Mana) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Mana);
			} else if (0 > item.Speed) {
				Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Mana).replace("-", ""));
			}
			if (0 < item.CritDamage) {
				Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritDamage);
			} else if (0 > item.CritDamage) {
				Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.CritDamage).replace("-", ""));
			}
			if (0 < item.CritChance) {
				Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritChance);
			} else if (0 > item.CritChance) {
				Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.CritChance).replace("-", ""));
			}
			if (0 < item.Stealth) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Stealth);
			} else if (0 > item.Stealth) {
				Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Stealth).replace("-", ""));
			}
		} else {
			if (0 < reforge.Health) {
				if (0 < item.Health) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Health + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Health + ")");
				} else if (0 > item.Health) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Health) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Health + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GRAY + " " + (int) item.Health + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Health + ")");
				}
			} else if (0 > reforge.Health) {
				if (0 < item.Health) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Health + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Health) + ")");
				} else if (0 > item.Health) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Health) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Health) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GRAY + " " + (int) item.Health + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Health) + ")");
				}
			} else {
				if (0 < item.Health) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Health);
				} else if (0 > item.Health) {
					Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Health).replace("-", ""));
				}
			}
			if (0 < reforge.Damage) {
				if (0 < item.Damage) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Damage + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
				} else if (0 > item.Damage) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Damage) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
				}
			} else if (0 > reforge.Damage) {
				if (0 < item.Damage) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Damage + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Damage) + ")");
				} else if (0 > item.Damage) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Damage) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Damage) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Damage) + ")");
				}
			} else {
				if (0 < item.Damage) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Damage);
				} else if (0 > item.Damage) {
					Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Damage).replace("-", ""));
				}
			}
			if (0 < reforge.Defence) {
				if (0 < item.Defence) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Defence + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
				} else if (0 > item.Defence) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Defence) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
				}
			} else if (0 > reforge.Defence) {
				if (0 < item.Defence) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Defence + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Defence) + ")");
				} else if (0 > item.Defence) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Defence) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Defence) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Defence) + ")");
				}
			} else {
				if (0 < item.Defence) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Defence);
				} else if (0 > item.Defence) {
					Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Defence).replace("-", ""));
				}
			}
			if (0 < reforge.Strength) {
				if (0 < item.Strength) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Strength + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
				} else if (0 > item.Strength) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Strength) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
				}
			} else if (0 > reforge.Strength) {
				if (0 < item.Strength) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Strength + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Strength) + ")");
				} else if (0 > item.Strength) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Strength) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Strength) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Strength) + ")");
				}
			} else {
				if (0 < item.Strength) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Strength);
				} else if (0 > item.Strength) {
					Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Strength).replace("-", ""));
				}
			}
			if (0 < reforge.Speed) {
				if (0 < item.Speed) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Speed + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
				} else if (0 > item.Speed) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Speed) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
				}
			} else if (0 > reforge.Speed) {
				if (0 < item.Speed) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Speed + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Speed) + ")");
				} else if (0 > item.Speed) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Speed) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Speed) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Speed) + ")");
				}
			} else {
				if (0 < item.Speed) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Speed);
				} else if (0 > item.Speed) {
					Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Speed).replace("-", ""));
				}
			}
			if (0 < reforge.Mana) {
				if (0 < item.Mana) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Mana + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
				} else if (0 > item.Mana) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Mana) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
				}
			} else if (0 > reforge.Mana) {
				if (0 < item.Mana) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Mana + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Mana) + ")");
				} else if (0 > item.Mana) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Mana) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Mana) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Mana) + ")");
				}
			} else {
				if (0 < item.Mana) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Mana);
				} else if (0 > item.Mana) {
					Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Mana).replace("-", ""));
				}
			}
			if (0 < reforge.CritDamage) {
				if (0 < item.CritDamage) {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritDamage + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
				} else if (0 > item.CritDamage) {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritDamage) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
				} else {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
				}
			} else if (0 > reforge.CritDamage) {
				if (0 < item.CritDamage) {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritDamage + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritDamage) + ")");
				} else if (0 > item.CritDamage) {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritDamage) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritDamage) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritDamage) + ")");
				}
			} else {
				if (0 < item.CritDamage) {
					Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritDamage);
				} else if (0 > item.CritDamage) {
					Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.CritDamage).replace("-", ""));
				}
			}
			if (0 < reforge.CritChance) {
				if (0 < item.CritChance) {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritChance + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
				} else if (0 > item.CritChance) {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritChance) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
				} else {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
				}
			} else if (0 > reforge.CritChance) {
				if (0 < item.CritChance) {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritChance + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritChance) + ")");
				} else if (0 > item.CritChance) {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritChance) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritChance) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritChance) + ")");
				}
			} else {
				if (0 < item.CritChance) {
					Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritChance);
				} else if (0 > item.CritChance) {
					Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.CritChance).replace("-", ""));
				}
			}
			if (0 < reforge.Stealth) {
				if (0 < item.Stealth) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Stealth + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
				} else if (0 > item.Stealth) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Stealth) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
				}
			} else if (0 > reforge.Stealth) {
				if (0 < item.Stealth) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Stealth + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Stealth) + ")");
				} else if (0 > item.Stealth) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Stealth) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Stealth) + ")");
				} else {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Stealth) + ")");
				}
			} else {
				if (0 < item.Stealth) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Stealth);
				} else if (0 > item.Stealth) {
					Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf((int) item.Stealth).replace("-", ""));
				}
			}

		}


		if (!"none".equals(item.getAbility())) {
			getItemAbilityLore(Lore, item);
		}

		itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "attack_speed", (item.getAttackSpeed() * 1), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));

//        itemMeta.setAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED = 0);


		Lore.add("");
		Lore.add(color + item.Rarity);
		itemMeta.setLore(Lore);
		if(originalMeta.getDisplayName().equals(itemMeta.getDisplayName())) {
			return;
		}
		if(originalMeta.hasLore())
			if(originalMeta.getLore().equals(Lore)) {
				return;
			}
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		itemInQ.setItemMeta(itemMeta);
	}
}
