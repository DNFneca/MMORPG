// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Crafting;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public enum Recipes {
	;

	public static void get(List<ItemStack> itemList, Inventory inventory) {
		ItemStack recipe = new ItemStack(Material.BARRIER, 1);
		ItemMeta recipedata = recipe.getItemMeta();
		recipedata.setDisplayName("Your recipe will appear here");
		recipe.setItemMeta(recipedata);
		String[] result = Recipes.getRecipes(itemList);
		if (null == result) {
			inventory.setItem(24, recipe);
			return;
		}
		ItemStack item = Recipes.getItemStack(result[0]);
		item.setAmount(Integer.parseInt(result[1]));
		inventory.setItem(24, item);
	}

	public static String[] getRecipes(List<ItemStack> list) {
		switch (list.size()) {
			case 1: {
				if (Material.OAK_WOOD == list.get(0).getType()) {
					return new String[]{"wood", "4"};
				}
				return null;
			}
			case 4: {
				if (Material.STICK == list.get(0).getType() && Material.STRING == list.get(1).getType() && Material.STICK == list.get(2).getType() && Material.STICK == list.get(3).getType()) {
					return new String[]{"Eros's Bow", "1"};
				}
				break;
			}
		}
		return null;
	}

	public static ItemStack getItemStack(String e) {
		ItemStack recipe = new ItemStack(Material.BARRIER, 1);
		ItemMeta recipedata = recipe.getItemMeta();
		switch (e) {
			case "wood": {
				recipedata.setDisplayName("Oak Planks");
				recipe.setType(Material.OAK_PLANKS);
				break;
			}
			case "Eros's Bow": {
				recipedata.setDisplayName("Eros's Bow");
				recipe.setType(Material.BOW);
				break;
			}
		}
		recipe.setItemMeta(recipedata);
		return recipe;
	}

	public static void ItemTakeOut(String e, Inventory inventory) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		if (e.contains("Oak Planks")) {
			for (int i = 0; i <= inventory.getSize(); ++i) {
				if ((10 == i || 11 == i || 12 == i || 19 == i || 20 == i || 21 == i || 28 == i || 29 == i || 30 == i) && null != inventory.getItem(i)) {
					inventory.getItem(i).setAmount(inventory.getItem(i).getAmount() - 1);
				}
			}
		} else if (e.contains("Eros's Bow")) {
			for (int i = 0; i <= inventory.getSize(); ++i) {
				if ((10 == i || 11 == i || 12 == i || 19 == i || 20 == i || 21 == i || 28 == i || 29 == i || 30 == i) && null != inventory.getItem(i)) {
					inventory.getItem(i).setAmount(inventory.getItem(i).getAmount() - 1);
				}
			}
		}
	}
}
