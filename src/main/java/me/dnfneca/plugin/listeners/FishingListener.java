// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerFishEvent;

public class FishingListener implements Listener {
	@EventHandler
	public void onRightClick(final PlayerFishEvent e) {
		e.setCancelled(true);
		e.getPlayer().sendMessage(e.getState().toString());
		final Player p = e.getPlayer();
		final Location pLoc = p.getLocation();
		if ("BITE" == e.getState().name()) {
			e.getPlayer().playSound(pLoc, Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 1.0f);
		}
	}

	@EventHandler
	public void onBlockDestroy(final BlockBreakEvent e) {
		if (GameMode.CREATIVE != e.getPlayer().getGameMode()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerAttackPlayer(final EntityDamageByEntityEvent e) {
		if (EntityType.PLAYER == e.getDamager().getType() && EntityType.PLAYER == e.getEntity().getType()) {
			e.setCancelled(true);
		}
	}
}
