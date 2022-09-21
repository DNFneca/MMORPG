package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Crafting.Recipes;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class CraftingTableListener implements Listener {

    @EventHandler
    public void onPlaceItemInCraftingTable(InventoryClickEvent e) {
        List<ItemStack> list = new ArrayList<>();
        if(e.getView().getTitle().contains("Crafting Table")) {
            if(e.getSlot() == 24 && !(e.getCurrentItem().getItemMeta().getDisplayName().contains("Your recipe will appear here"))) {
                Recipes.ItemTakeOut(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory());
            }
            for (int i = 0; i <= e.getInventory().getSize(); i++) {
                if(i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30) {
                    int finalI = i;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if(e.getView().getTopInventory().getItem(finalI) != null) {
                                list.add(e.getView().getTopInventory().getItem(finalI));
                                System.out.println(e.getView().getTopInventory().getItem(finalI));
                            }
                        }
                    }.runTaskLater(Plugin.getInstance(), 2);

                } else if ( i == 45) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            System.out.println(list);
                            Recipes.get(list, e.getInventory());
                        }
                    }.runTaskLater(Plugin.getInstance(), 2);
                }
            }
        }
    }

    @EventHandler
    public void onCraftingTableClose(InventoryCloseEvent e) {
        List<ItemStack> Items = new ArrayList<>();
        if(e.getView().getTitle().contains("Crafting Table")) {
            for (int i = 0; i <= e.getInventory().getSize(); i++) {
                if(i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30){
                    if(e.getView().getTopInventory().getItem(i) != null) {
                        Items.add(e.getView().getTopInventory().getItem(i));
                    }
                }
                else if(i > 44) {
                    for(ItemStack item : Items) {
                        e.getPlayer().getInventory().addItem(item);
                    }
                }
            }
        }
    }

}
