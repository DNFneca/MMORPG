// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import java.util.Iterator;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventHandler;
import me.dnfneca.plugin.Plugin;
import java.util.List;
import org.bukkit.scheduler.BukkitRunnable;
import me.dnfneca.plugin.utilities.managers.Crafting.Recipes;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class CraftingTableListener implements Listener
{
    @EventHandler
    public void onPlaceItemInCraftingTable(final InventoryClickEvent e) {
        final List<ItemStack> list = new ArrayList<ItemStack>();
        if (e.getView().getTitle().contains("Crafting Table")) {
            if (e.getSlot() == 24 && !e.getCurrentItem().getItemMeta().getDisplayName().contains("Your recipe will appear here")) {
                Recipes.ItemTakeOut(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory());
            }
            for (int i = 0; i <= e.getInventory().getSize(); ++i) {
                if (i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30) {
                    final int finalI = i;
                    new BukkitRunnable() {
                        public void run() {
                            if (e.getView().getTopInventory().getItem(finalI) != null) {
                                list.add(e.getView().getTopInventory().getItem(finalI));
                            }
                        }
                    }.runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), 2L);
                }
                else if (i == 45) {
                    new BukkitRunnable() {
                        public void run() {
                            Recipes.get(list, e.getInventory());
                        }
                    }.runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), 2L);
                }
            }
        }
    }
    
    @EventHandler
    public void onCraftingTableClose(final InventoryCloseEvent e) {
        final List<ItemStack> Items = new ArrayList<ItemStack>();
        if (e.getView().getTitle().contains("Crafting Table")) {
            for (int i = 0; i <= e.getInventory().getSize(); ++i) {
                if (i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30) {
                    if (e.getView().getTopInventory().getItem(i) != null) {
                        Items.add(e.getView().getTopInventory().getItem(i));
                    }
                }
                else if (i > 44) {
                    for (final ItemStack item : Items) {
                        e.getPlayer().getInventory().addItem(new ItemStack[] { item });
                    }
                }
            }
        }
    }
}
