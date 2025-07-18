package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.Plugin;
import org.bukkit.entity.Player;
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
				if (e.getViewers().isEmpty()) {
					this.cancel();
				}
				setOpenedInventoryItemsLore(e.getInventory(), (Player) e.getPlayer());

			}
		}.runTaskTimer(Plugin.getInstance(), 0L, 5L);
	}

	public void setOpenedInventoryItemsLore(Inventory inventory, Player player) {
		int Slots = inventory.getSize();
		for (int i = 0; i < Slots; i++) {
			if (null != inventory.getItem(i) && null != inventory.getItem(i).getItemMeta() && inventory.getItem(i).hasItemMeta() && inventory.getItem(i).getItemMeta().hasDisplayName()) {
				Items.setItemLore(inventory.getItem(i), player);
			}
		}
	}

}
