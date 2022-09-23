package me.dnfneca.plugin.utilities.managers.Crafting;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Recipes {

    public static void get(List<ItemStack> itemList, Inventory inventory) {

        ItemStack recipe = new ItemStack(Material.BARRIER, 1);
        ItemMeta recipedata = recipe.getItemMeta();
        recipedata.setDisplayName("Your recipe will appear here");
        recipe.setItemMeta(recipedata);

        String[] result = getRecipes(itemList);

        if (result == null) {
            inventory.setItem(24, recipe);
            return;
        }

        ItemStack item = getItemStack(result[0]);
        item.setAmount(Integer.parseInt(result[1]));

//        Check.LoreInsert(item.getItemMeta(), item);

        inventory.setItem(24, item);
    }

    public static String[] getRecipes(List<ItemStack> list) {
        switch (list.size()) {
            case 1:
                if (list.get(0).getType() == Material.OAK_WOOD) {
                    return new String[]{"wood", "4"};
                }
                break;
            case 4:
                if(list.get(0).getType() == Material.STICK && list.get(1).getType() == Material.STRING && list.get(2).getType() == Material.STICK && list.get(3).getType() == Material.STICK) {
                    return new String[]{"Eros's Bow", "1"};
                }
            default:
                return null;

        }
        return null;
    }

    public static ItemStack getItemStack(String e) {
        ItemStack recipe = new ItemStack(Material.BARRIER, 1);

        ItemMeta recipedata = recipe.getItemMeta();


        switch (e) {
            case "wood":
                recipedata.setDisplayName("Oak Planks");
                recipe.setType(Material.OAK_PLANKS);
            break;
            case "Eros's Bow":
                recipedata.setDisplayName("Eros's Bow");
                recipe.setType(Material.BOW);
        }
        recipe.setItemMeta(recipedata);

        return recipe;
    }
    public static void ItemTakeOut(String e, Inventory inventory) {
        List<ItemStack> list = new ArrayList<>();
        if(e.contains("Oak Planks")) {
            for (int i = 0; i <= inventory.getSize(); i++) {
                if(i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30) {
                    if(inventory.getItem(i) != null) {
                        inventory.getItem(i).setAmount(inventory.getItem(i).getAmount() - 1);
                    }
                }
            }
        } else if (e.contains("Eros's Bow")) {
            for (int i = 0; i <= inventory.getSize(); i++) {
                if(i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30) {
                    if(inventory.getItem(i) != null) {
                        inventory.getItem(i).setAmount(inventory.getItem(i).getAmount() - 1);
                    }
                }
            }
        }
    }
}
