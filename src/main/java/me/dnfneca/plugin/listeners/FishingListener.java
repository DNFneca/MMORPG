// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.GameMode;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.Listener;

public class FishingListener implements Listener
{
    @EventHandler
    public void onRightClick(final PlayerFishEvent e) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(e.getState().toString());
        final Player p = e.getPlayer();
        final Location pLoc = p.getLocation();
        if (e.getState().name() == "BITE") {
            e.getPlayer().playSound(pLoc, Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 1.0f);
        }
    }
    
    @EventHandler
    public void onBlockDestroy(final BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerAttackPlayer(final EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.PLAYER && e.getEntity().getType() == EntityType.PLAYER) {
            e.setCancelled(true);
        }
    }
}
