// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Location;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;

public class Fireball
{
    public static void Fireball(final PlayerStats p) {
        p.setManaSpent(25.0);
        p.setManaTimer(6);
        new BukkitRunnable() {
            double distanceTraveled;
            
            public void run() {
                final Location loc = p.getPlayer().getEyeLocation();
                this.distanceTraveled = 0.0;
                while (this.distanceTraveled <= 15.0) {
                    loc.add(loc.getDirection());
                    p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object)new Particle.DustOptions(Color.fromRGB(255, 51, 21), 20.0f));
                    if (HitDetection.HitDetection(loc, 0.2, 150)) {
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
