package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.Objective;

import static me.dnfneca.plugin.utilities.GUI.GUI.MainMenu;

public class RightClickListener implements Listener {

    @EventHandler
    public void onAbilityTry(PlayerInteractEvent e) {
        Action action = e.getAction();
        Player p = e.getPlayer();
        Objective objective = p.getScoreboard().getObjective("Stats");
//        System.out.println(action);
        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            e.getPlayer().getInventory().getItemInMainHand();
            if(p.getInventory().getItemInMainHand().getItemMeta() == null) {
                return;
            }
            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Menu")) {
                e.setCancelled(true);

                MainMenu(p);
            }
            AbilitiesManager.getAbility(e.getPlayer().getInventory().getItemInMainHand(), p);
//                p.sendMessage("E");
//                p.getScoreboard().getObjective("Stats").getScore("CurrentMana").setScore(p.getScoreboard().getObjective("Stats").getScore("CurrentMana").getScore() - 25);

//            p.sendMessage(action.toString());
        }
    }
}



//        e.setCancelled(true);

