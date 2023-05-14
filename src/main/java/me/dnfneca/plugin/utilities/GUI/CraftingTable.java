// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CraftingTable implements Listener
{
    public static void MainCraftingInventory(final Player p) {
        final List<String> lore = new ArrayList<String>();
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 45, "Crafting Table");
        final ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        final ItemStack recipe = new ItemStack(Material.BARRIER, 1);
        final ItemStack arrow = new ItemStack(Material.ARROW, 1);
        final ItemMeta arrowmeta = arrow.getItemMeta();
        arrowmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
        arrow.setItemMeta(arrowmeta);
        final ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);
        final ItemMeta recipedata = recipe.getItemMeta();
        recipedata.setDisplayName("Your recipe will appear here");
        recipe.setItemMeta(recipedata);
        for (int i = 0; i <= 44; ++i) {
            if (i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30) {
                inv.setItem(i, new ItemStack(Material.AIR));
            }
            else if (i == 24) {
                inv.setItem(i, recipe);
            }
            else if (i == inv.getSize() - 1) {
                inv.setItem(i, arrow);
            }
            else {
                inv.setItem(i, blue_glass);
            }
        }
        p.openInventory(inv);
    }
}
