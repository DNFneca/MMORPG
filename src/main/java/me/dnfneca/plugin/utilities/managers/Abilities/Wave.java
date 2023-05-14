// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
<<<<<<< Updated upstream
=======
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
>>>>>>> Stashed changes
import org.bukkit.Location;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
<<<<<<< Updated upstream
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
=======

public class Wave {
    public static void Wave(PlayerStats p) {
        p.setManaSpent(25);
        p.setManaTimer(6);
>>>>>>> Stashed changes

public class Wave
{
    public static void Wave(final PlayerStats p) {
        p.setManaSpent(25.0);
        p.setManaTimer(6);
        new BukkitRunnable() {
            double t;
            
            public void run() {
<<<<<<< Updated upstream
                this.t += 0.2617993877991494;
                final Location loc = p.getPlayer().getLocation();
                for (double phi = 0.0; phi <= 6.283185307179586; phi += 1.5707963267948966) {
                    final double x = 0.3 * (12.566370614359172 - this.t) * Math.cos(this.t + phi);
                    final double y = 0.2 * this.t;
                    final double z = 0.3 * (12.566370614359172 - this.t) * Math.sin(this.t + phi);
                    loc.add(x, y, z);
                    p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object)new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0f));
=======
                t += Math.PI / 12;
                Location loc = p.getPlayer().getLocation();
                for (double phi = 0; phi <= 2 * Math.PI; phi += Math.PI / 2) {
                    double x = 0.3 * (4 * Math.PI - t) * Math.cos(t + phi);
                    double y = 0.2 * t;
                    double z = 0.3 * (4 * Math.PI - t) * Math.sin(t + phi);
                    loc.add(x, y, z);
                    p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
>>>>>>> Stashed changes
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
