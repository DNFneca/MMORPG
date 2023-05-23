// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;

import static me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager.HitDetection;

public enum Tangle {
	;

	public static void Tangle(PlayerStats p) {
		p.setManaSpent(25);
		p.setManaTimer(6);
		new BukkitRunnable() {
			double distanceTraveled;

			public void run() {
				Location loc = p.getPlayer().getEyeLocation();
				this.distanceTraveled = 0.0;
				while (15.0 >= distanceTraveled) {
					loc.add(loc.getDirection());
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object) new Particle.DustOptions(Color.fromRGB(150, 75, 0), 20.0f));
					if (HitDetection(loc, 1, p, 2)){
						this.cancel();
						return;
					}
					++this.distanceTraveled;
				}
				this.cancel();
			}
		}.runTaskTimer(Plugin.getInstance(), 4L, 1L);
	}
}
