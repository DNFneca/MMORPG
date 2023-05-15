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
	public void onOpenedInventorySetItemLore(final InventoryOpenEvent e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				System.out.println(e.getViewers());
				if (e.getViewers().isEmpty()) {
					cancel();
				}
				SetOpenedInventoryItemsLore.this.setOpenedInventoryItemsLore(e.getInventory());

			}
		}.runTaskTimer(Plugin.getInstance(), 0L, 5L);
	}

	public void setOpenedInventoryItemsLore(final Inventory inventory) {
		final int Slots = inventory.getSize();
		for (int i = 0; i < Slots; i++) {
			if (null != inventory.getItem(i) && null != inventory.getItem(i).getItemMeta() && inventory.getItem(i).hasItemMeta() && inventory.getItem(i).getItemMeta().hasDisplayName()) {
				final ItemMeta meta = inventory.getItem(i).getItemMeta();
				Items.setItemLore(inventory, meta, i);
			}
		}
	}

}
