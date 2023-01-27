package me.dnfneca.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import static me.dnfneca.plugin.utilities.GUI.GUI.MainMenu;

public class DropItemListener implements Listener {


    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getItemMeta() != null) {
            if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Menu")) {
                e.setCancelled(true);

                MainMenu(e.getPlayer());
            }
        }
    }
}
