// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import org.bukkit.scoreboard.Objective;
import me.dnfneca.plugin.Plugin;
import org.bukkit.Location;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;

public class Tangle
{
    public static void Tangle(final Player p) {
        final Objective objective = p.getScoreboard().getObjective("Stats");
        objective.getScore("ManaCost").setScore(25);
        objective.getScore("ManaTimer").setScore(6);
        new BukkitRunnable() {
            double distanceTraveled;
            
            public void run() {
                final Location loc = p.getEyeLocation();
                this.distanceTraveled = 0.0;
                while (this.distanceTraveled <= 15.0) {
                    loc.add(loc.getDirection());
                    p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object)new Particle.DustOptions(Color.fromRGB(150, 75, 0), 20.0f));
                    if (HitDetection.HitDetectionStun(loc, 0.2, 150, 2)) {
                        this.cancel();
                        return;
                    }
                    ++this.distanceTraveled;
                }
                this.cancel();
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)Plugin.getInstance(), 4L, 1L);
    }
}
