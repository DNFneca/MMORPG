// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.GUI.GUI;
import me.dnfneca.plugin.utilities.managers.Mayors.util.RunMayorEventRunEvent;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemListener implements Listener {
	@EventHandler
	public void onDropItem(PlayerDropItemEvent e) {
		if (null != e.getItemDrop().getItemStack().getItemMeta() && e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Menu")) {
			e.setCancelled(true);
			GUI.MainMenu(e.getPlayer());
		}
	}
}
