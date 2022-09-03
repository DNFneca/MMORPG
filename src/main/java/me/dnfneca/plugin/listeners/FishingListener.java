package me.dnfneca.plugin.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerFishEvent;

import static org.bukkit.Sound.BLOCK_NOTE_BLOCK_BELL;

public class FishingListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerFishEvent e) {

        e.setCancelled(true);

        e.getPlayer().sendMessage(e.getState().toString());
        Player p = e.getPlayer();
        Location pLoc = p.getLocation();
        if (e.getState().name() == "BITE") {
            e.getPlayer().playSound(pLoc, BLOCK_NOTE_BLOCK_BELL, 1, 1);
        }
    }

    @EventHandler
    public void onBlockDestroy(BlockBreakEvent e) {
        if(e.getPlayer().getGameMode() != GameMode.CREATIVE)
        e.setCancelled(true);
    }
    @EventHandler
    public void onPlayerAttackPlayer(EntityDamageByEntityEvent e) {
        if(e.getDamager().getType() == EntityType.PLAYER && e.getEntity().getType() == EntityType.PLAYER)
            e.setCancelled(true);
    }
}