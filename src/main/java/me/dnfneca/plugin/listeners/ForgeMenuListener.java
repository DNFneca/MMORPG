// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class ForgeMenuListener implements Listener
{
    @EventHandler
    public void onInventoryEvent(final InventoryClickEvent e) {
        final String InventoryName = e.getView().getTitle();
        if (!InventoryName.contains("Forge Menu")) {
            return;
        }
        final Player p = (Player)e.getWhoClicked();
        final List<String> lore = new ArrayList<String>();
        final Inventory inv = e.getInventory();
        ItemStack ClickedItem = null;
        try {
            ClickedItem = e.getCurrentItem();
        }
        catch (Error error) {
            System.out.println(error);
        }
        if (ClickedItem == null) {
            return;
        }
        new BukkitRunnable() {
            public void run() {
                final boolean isRegistered = false;
                final ItemStack none = new ItemStack(Material.BARRIER, 1);
                final ItemMeta none_meta = none.getItemMeta();
                none_meta.setDisplayName("Can't reforge this");
                none.setItemMeta(none_meta);
                if (!InventoryName.contains("Forge Menu")) {
                    return;
                }
                if (e.getViewers().equals(new ArrayList())) {
                    return;
                }
                final ItemStack reforgable_item = e.getInventory().getItem(11);
                if (reforgable_item == null) {
                    e.getInventory().setItem(40, none);
                }
                if (!isRegistered) {
                    e.getInventory().setItem(40, none);
                }
                if (e.getInventory().getItem(15) == null) {
                    e.getInventory().setItem(40, none);
                }
                for (final String[] s : ItemStats.RegisteredReforges) {
                    if (e.getInventory().getItem(15).getItemMeta().getDisplayName().contains(s[0])) {
                        final String[] check = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
                        final ItemStack reforged_item = reforgable_item.clone();
                        final String[] item_name = reforged_item.getItemMeta().getDisplayName().split(" ");
                        System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;, item_name[0], s[1], item_name[0].contains(s[1])));
                        if (item_name[0].contains(s[1])) {
                            e.getInventory().setItem(40, none);
                            break;
                        }
                        final ItemMeta reforged_item_data = reforged_item.getItemMeta();
                        reforged_item_data.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, s[1], reforged_item.getItemMeta().getDisplayName()));
                        reforged_item.setItemMeta(reforged_item_data);
                        e.getInventory().setItem(40, reforged_item);
                        if (Arrays.equals(ForgeMenuListener.GetInventoryReforge(p, 40), check)) {
                            e.getInventory().setItem(40, none);
                        }
                        ForgeMenuListener.SetItemStatsLoreInMenu(40, p);
                    }
                }
            }
        }.runTaskTimer((Plugin)PlayerJoin.plugin, 0L, 20L);
        if (e.getSlot() == 40 && e.getCurrentItem().getType() != Material.BARRIER) {
            e.getInventory().setItem(11, new ItemStack(Material.AIR, 1));
            e.getInventory().setItem(15, new ItemStack(Material.AIR, 1));
        }
    }
    
    @EventHandler
    public void onForgeMenuClose(final InventoryCloseEvent e) {
        if (e.getView().getTitle().contains("Forge Menu")) {
            e.getPlayer().getInventory().addItem(new ItemStack[] { e.getInventory().getItem(11) });
        }
    }
    
    public static void SetItemStatsLoreInMenu(final int ItemSlot, final Player player) {
    }
    
    public static String[] GetInventoryReforge(final Player p, final int ItemSlot) {
        final String[] data = new String[10];
        final ItemStack Item = p.getOpenInventory().getItem(ItemSlot);
        if (Item == null) {
            return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
        if (Item.getItemMeta() != null) {
            final ItemMeta itemMeta = Item.getItemMeta();
            itemMeta.getDisplayName().split(" ");
        }
        return data;
    }
}
