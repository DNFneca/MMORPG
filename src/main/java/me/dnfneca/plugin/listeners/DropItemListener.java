// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.event.EventHandler;
import me.dnfneca.plugin.utilities.GUI.GUI;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.Listener;

public class DropItemListener implements Listener
{
    @EventHandler
    public void onDropItem(final PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getItemMeta() != null && e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Menu")) {
            e.setCancelled(true);
            GUI.MainMenu(e.getPlayer());
        }
    }
}
