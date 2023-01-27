package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;

public class Helix {
    public static void Helix(Player p) {
        Objective objective = p.getScoreboard().getObjective("Stats");
        objective.getScore("ManaCost").setScore(25);
        objective.getScore("ManaTimer").setScore(6);

        new BukkitRunnable() {
            double r, C;

            public void run() {
                r = 2;
                Location loc = p.getLocation();
                for (double y = 0; y <= 50; y += 0.05) {
                    double x = r * Math.cos(y);
                    double z = r * Math.sin(y);
                    loc.add(x, y, z);
                    p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
                    loc.subtract(x, y, z);

                }
                this.cancel();
            }
        }.runTaskTimer(Plugin.getInstance(), 0, 1);
    }
}
