<<<<<<< Updated upstream
// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.EventHandler;
import me.dnfneca.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.Listener;

public class SetOpenedInventoryItemsLore implements Listener
{
    @EventHandler
    public void onOpenedInventorySetItemLore(final InventoryOpenEvent e) {
        new BukkitRunnable() {
            public void run() {
                System.out.println(e.getViewers());
                if (e.getViewers().isEmpty()) {
                    this.cancel();
                }
                SetOpenedInventoryItemsLore.this.setOpenedInventoryItemsLore(e.getInventory());
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)Plugin.getInstance(), 0L, 5L);
    }
    
    public void setOpenedInventoryItemsLore(final Inventory inventory) {
        for (int Slots = inventory.getSize(), i = 0; i < Slots; ++i) {
            if (inventory.getItem(i) != null && inventory.getItem(i).getItemMeta() != null && inventory.getItem(i).hasItemMeta() && inventory.getItem(i).getItemMeta().hasDisplayName()) {
                final ItemMeta meta = inventory.getItem(i).getItemMeta();
=======
package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class SetOpenedInventoryItemsLore implements Listener {
    @EventHandler
    public void onOpenedInventorySetItemLore(InventoryOpenEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                System.out.println(e.getViewers());
                if(e.getViewers().isEmpty()) {
                   this.cancel();
                }
                    setOpenedInventoryItemsLore(e.getInventory());

            }
        }.runTaskTimer(Plugin.getInstance(), 0L, 5L);
    }
    public void setOpenedInventoryItemsLore(Inventory inventory) {
        int Slots = inventory.getSize();
        for (int i = 0; i < Slots; i++) {
            if(inventory.getItem(i) != null && inventory.getItem(i).getItemMeta() != null && inventory.getItem(i).hasItemMeta() && inventory.getItem(i).getItemMeta().hasDisplayName()) {
                ItemMeta meta = inventory.getItem(i).getItemMeta();
>>>>>>> Stashed changes
                Items.setItemLore(inventory, meta, i);
            }
        }
    }
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}
