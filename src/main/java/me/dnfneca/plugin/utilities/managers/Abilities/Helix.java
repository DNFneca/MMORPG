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

public class Helix
{
    public static void Helix(final PlayerStats p) {
        p.setManaSpent(25.0);
        p.setManaTimer(6);
        new BukkitRunnable() {
            double r;
            double C;
            
            public void run() {
                this.r = 2.0;
                final Location loc = p.getPlayer().getLocation();
                for (double y = 0.0; y <= 50.0; y += 0.05) {
                    final double x = this.r * Math.cos(y);
                    final double z = this.r * Math.sin(y);
                    loc.add(x, y, z);
                    p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object)new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0f));
                    loc.subtract(x, y, z);
                }
                this.cancel();
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)Plugin.getInstance(), 0L, 1L);
    }
}
