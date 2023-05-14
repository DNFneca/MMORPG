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

public class Wave
{
    public static void Wave(final PlayerStats p) {
        p.setManaSpent(25.0);
        p.setManaTimer(6);
        new BukkitRunnable() {
            double t;
            
            public void run() {
                this.t += 0.2617993877991494;
                final Location loc = p.getPlayer().getLocation();
                for (double phi = 0.0; phi <= 6.283185307179586; phi += 1.5707963267948966) {
                    final double x = 0.3 * (12.566370614359172 - this.t) * Math.cos(this.t + phi);
                    final double y = 0.2 * this.t;
                    final double z = 0.3 * (12.566370614359172 - this.t) * Math.sin(this.t + phi);
                    loc.add(x, y, z);
                    p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object)new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0f));
                    loc.subtract(x, y, z);
                    if (this.t >= 12.566370614359172) {
                        loc.add(x, y, z);
                        p.getPlayer().getWorld().spawnParticle(Particle.SNOW_SHOVEL, loc, 10);
                        this.cancel();
                    }
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)Plugin.getInstance(), 0L, 1L);
    }
}
