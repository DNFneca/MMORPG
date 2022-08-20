package me.dnfneca.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static org.bukkit.Material.NETHER_STAR;

public class RightClickListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Action action = e.getAction();
        e.getPlayer().sendMessage(action.toString());
        if(e.getItem() != null) {
            if (Objects.requireNonNull(Objects.requireNonNull(e.getItem().getItemMeta()).getLore()).toString().toLowerCase().contains("gay_ass_sword")) {
                Inventory inv = e.getPlayer().getInventory();
                ItemStack clay = new ItemStack(NETHER_STAR, 1);
                inv.addItem(clay);
            }
        }

        e.getPlayer().sendMessage(e.getItem().getItemMeta().getPersistentDataContainer().toString());
    }
}



//        e.setCancelled(true);

