package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public enum LaserPointer {
	;

	public static boolean LaserPointer(PlayerStats p, float cost) {

		new BukkitRunnable() {
			double distanceTraveled;

			public void run() {
				Location loc = p.getPlayer().getEyeLocation();
				Vector vector = loc.getDirection();
				for (distanceTraveled = 0; 10000 > this.distanceTraveled; distanceTraveled++) {
					loc.add(vector);
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 1, new Particle.DustOptions(Color.fromRGB(255, 51, 21), 1.0F));
				}
				this.cancel();
			}
		}.runTaskTimer(Plugin.getInstance(), 4, 1);
		return true;
	}
}
