package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
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
            if (e.getPlayer().getInventory().getItemInMainHand() != null) {
                ItemStats.Weapon(p);
                if(p.getInventory().getItemInMainHand().getItemMeta() == null) {
                    return;
                }
                if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Menu")) {
                    e.setCancelled(true);

                    MainMenu(p);
                }

                if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Sticky") && p.getScoreboard().getObjective("Stats").getScore("CurrentMana").getScore() >= 25) {
//                p.sendMessage("E");
//                p.getScoreboard().getObjective("Stats").getScore("CurrentMana").setScore(p.getScoreboard().getObjective("Stats").getScore("CurrentMana").getScore() - 25);
                    objective.getScore("ManaCost").setScore(25);
                    objective.getScore("ManaTimer").setScore(6);

                    new BukkitRunnable() {
                        double t;

                        public void run() {
                            t += Math.PI / 12;
                            Location loc = p.getLocation();
                            for (double phi = 0; phi <= 2 * Math.PI; phi += Math.PI / 2) {
                                double x = 0.3 * (4 * Math.PI - t) * Math.cos(t + phi);
                                double y = 0.2 * t;
                                double z = 0.3 * (4 * Math.PI - t) * Math.sin(t + phi);
                                loc.add(x, y, z);
                                p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
                                loc.subtract(x, y, z);

                                if (t >= 4 * Math.PI) {
                                    loc.add(x, y, z);
                                    p.getWorld().spawnParticle(Particle.SNOW_SHOVEL, loc, 10);
                                    this.cancel();
                                }
                            }
                        }
                    }.runTaskTimer(Plugin.getInstance(), 0, 1);
                }

//            p.sendMessage(action.toString());
            }
        }
    }
}



//        e.setCancelled(true);

