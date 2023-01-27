package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;

public class Fireball {
    public static void Fireball(Player p) {
        Objective objective = p.getScoreboard().getObjective("Stats");
        objective.getScore("ManaCost").setScore(25);
        objective.getScore("ManaTimer").setScore(6);

        new BukkitRunnable() {
            double distanceTraveled;

            public void run() {
                Location loc = p.getEyeLocation();
                for (distanceTraveled = 0; distanceTraveled <= 15; distanceTraveled ++) {
                    loc.add(loc.getDirection());
        //              BLOOD COLOR                  p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(135, 5, 1), 20.0F));
                    p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(255, 51, 21), 20.0F));
                    if(HitDetection.HitDetection(loc, 0.2, 150)) {
                        this.cancel();
                        return;
                    }
                }
                this.cancel();
            }
        }.runTaskTimer(Plugin.getInstance(), 4, 1);
    }
}
