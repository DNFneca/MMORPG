// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;

public enum Tangle {
	;

	public static void Tangle(Player p) {
		Objective objective = p.getScoreboard().getObjective("Stats");
		objective.getScore("ManaCost").setScore(25);
		objective.getScore("ManaTimer").setScore(6);
		new BukkitRunnable() {
			double distanceTraveled;

			public void run() {
				Location loc = p.getEyeLocation();
				distanceTraveled = 0.0;
				while (15.0 >= this.distanceTraveled) {
					loc.add(loc.getDirection());
					p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object) new Particle.DustOptions(Color.fromRGB(150, 75, 0), 20.0f));
					if (HitDetection.HitDetectionStun(loc, 0.2, 150, 2)) {
						cancel();
						return;
					}
					++distanceTraveled;
				}
				cancel();
			}
		}.runTaskTimer(Plugin.getInstance(), 4L, 1L);
	}
}
