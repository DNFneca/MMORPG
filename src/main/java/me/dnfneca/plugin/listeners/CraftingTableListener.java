// 
// Decompiled by Procyon v0.5.36
// 

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
	public void onPlaceItemInCraftingTable(final InventoryClickEvent e) {
		final List<ItemStack> list = new ArrayList<ItemStack>();
		if (e.getView().getTitle().contains("Crafting Table")) {
			if (24 == e.getSlot() && !e.getCurrentItem().getItemMeta().getDisplayName().contains("Your recipe will appear here")) {
				Recipes.ItemTakeOut(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory());
			}
			for (int i = 0; i <= e.getInventory().getSize(); ++i) {
				if (10 == i || 11 == i || 12 == i || 19 == i || 20 == i || 21 == i || 28 == i || 29 == i || 30 == i) {
					final int finalI = i;
					new BukkitRunnable() {
						public void run() {
							if (null != e.getView().getTopInventory().getItem(finalI)) {
								list.add(e.getView().getTopInventory().getItem(finalI));
							}
						}
					}.runTaskLater(Plugin.getInstance(), 2L);
				} else if (45 == i) {
					new BukkitRunnable() {
						public void run() {
							Recipes.get(list, e.getInventory());
						}
					}.runTaskLater(Plugin.getInstance(), 2L);
				}
			}
		}
	}

	@EventHandler
	public void onCraftingTableClose(final InventoryCloseEvent e) {
		final List<ItemStack> Items = new ArrayList<ItemStack>();
		if (e.getView().getTitle().contains("Crafting Table")) {
			for (int i = 0; i <= e.getInventory().getSize(); ++i) {
				if (10 == i || 11 == i || 12 == i || 19 == i || 20 == i || 21 == i || 28 == i || 29 == i || 30 == i) {
					if (null != e.getView().getTopInventory().getItem(i)) {
						Items.add(e.getView().getTopInventory().getItem(i));
					}
				} else if (44 < i) {
					for (final ItemStack item : Items) {
						e.getPlayer().getInventory().addItem(item);
					}
				}
			}
		}
	}
}
