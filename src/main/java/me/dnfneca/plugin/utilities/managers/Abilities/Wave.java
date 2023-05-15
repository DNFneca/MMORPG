package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public enum Wave {
	;

	public static void Wave(final PlayerStats p) {
		p.setManaSpent(25);
		p.setManaTimer(6);

		new BukkitRunnable() {
			double t;

			public void run() {
				this.t += Math.PI / 12;
				final Location loc = p.getPlayer().getLocation();
				for (double phi = 0; 2 * Math.PI >= phi; phi += Math.PI / 2) {
					final double x = 0.3 * (4 * Math.PI - this.t) * Math.cos(this.t + phi);
					final double y = 0.2 * this.t;
					final double z = 0.3 * (4 * Math.PI - this.t) * Math.sin(this.t + phi);
					loc.add(x, y, z);
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
					loc.subtract(x, y, z);

					if (4 * Math.PI <= t) {
						loc.add(x, y, z);
						p.getPlayer().getWorld().spawnParticle(Particle.SNOW_SHOVEL, loc, 10);
						cancel();
					}
				}
			}
		}.runTaskTimer(Plugin.getInstance(), 0, 1);
	}
}
