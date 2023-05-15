package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CraftingTable implements Listener {
	public static void MainCraftingInventory(final Player p) {
		final List<String> lore = new ArrayList<>();


		final Inventory inv = Bukkit.createInventory(null, 45, "Crafting Table");

		final ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
		final ItemStack recipe = new ItemStack(Material.BARRIER, 1);


		final ItemStack arrow = new ItemStack(Material.ARROW, 1);

		final ItemMeta arrowmeta = arrow.getItemMeta();
		arrowmeta.setDisplayName(ChatColor.GRAY + "To Forge");
		arrow.setItemMeta(arrowmeta);


		final ItemMeta data2 = blue_glass.getItemMeta();
		data2.setDisplayName("   ");
		blue_glass.setItemMeta(data2);

		final ItemMeta recipedata = recipe.getItemMeta();
		recipedata.setDisplayName("Your recipe will appear here");
		recipe.setItemMeta(recipedata);


		for (int i = 0; 44 >= i; i++) {
			if (10 == i || 11 == i || 12 == i || 19 == i || 20 == i || 21 == i || 28 == i || 29 == i || 30 == i) {
				inv.setItem(i, new ItemStack(Material.AIR));
			} else if (24 == i) {
				inv.setItem(24, recipe);
			} else if (i == inv.getSize() - 1) {
				inv.setItem(i, arrow);
			} else {
				inv.setItem(i, blue_glass);
			}
		}
//        ItemStack clay = new ItemStack(CLAY, 64);
//        ItemMeta clayMeta = clay.getItemMeta();
//        lore.add(ChatColor.DARK_PURPLE + "Staff");
//        clayMeta.setLore(lore);
//        clay.setItemMeta(clayMeta);
//        inv.addItem(clay);
		p.openInventory(inv);
	}
}
