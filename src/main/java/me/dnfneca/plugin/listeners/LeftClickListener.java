// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.scoreboard.Objective;
import org.bukkit.entity.Player;
import org.bukkit.entity.Arrow;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class LeftClickListener implements Listener
{
    @EventHandler
    public void onAttackTry(final PlayerInteractEvent e) {
        final Action action = e.getAction();
        final Player p = e.getPlayer();
        final Objective objective = p.getScoreboard().getObjective("Stats");
        if ((action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) && p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() == Material.BOW) {
            p.launchProjectile((Class)Arrow.class);
        }
    }
}
