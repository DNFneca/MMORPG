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

public class Fireball {
    public static void Fireball(PlayerStats p) {
        p.setManaSpent(25);
        p.setManaTimer(6);
>>>>>>> Stashed changes

public class Fireball
{
    public static void Fireball(final PlayerStats p) {
        p.setManaSpent(25.0);
        p.setManaTimer(6);
        new BukkitRunnable() {
            double distanceTraveled;
            
            public void run() {
<<<<<<< Updated upstream
                final Location loc = p.getPlayer().getEyeLocation();
                this.distanceTraveled = 0.0;
                while (this.distanceTraveled <= 15.0) {
                    loc.add(loc.getDirection());
                    p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object)new Particle.DustOptions(Color.fromRGB(255, 51, 21), 20.0f));
                    if (HitDetection.HitDetection(loc, 0.2, 150)) {
=======
                Location loc = p.getPlayer().getEyeLocation();
                for (distanceTraveled = 0; distanceTraveled <= 15; distanceTraveled ++) {
                    loc.add(loc.getDirection());
        //              BLOOD COLOR                  p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(135, 5, 1), 20.0F));
                    p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(255, 51, 21), 20.0F));
                    if(HitDetection.HitDetection(loc, 0.2, 150)) {
>>>>>>> Stashed changes
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
