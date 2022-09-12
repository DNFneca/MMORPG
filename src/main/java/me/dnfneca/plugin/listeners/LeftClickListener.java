package me.dnfneca.plugin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.Objective;

public class LeftClickListener implements Listener {

    @EventHandler
    public void onAttackTry(PlayerInteractEvent e) {
        Action action = e.getAction();
        Player p = e.getPlayer();
        Objective objective = p.getScoreboard().getObjective("Stats");
        if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            if(p.getInventory().getItemInMainHand() != null) {
                if(p.getInventory().getItemInMainHand().getType() == Material.BOW) {
                    p.launchProjectile(Arrow.class);
                }
            }
        }
    }
}
