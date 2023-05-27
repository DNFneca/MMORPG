package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public enum Wave {
	;

	public static boolean Wave(PlayerStats p, float cost) {
		p.removeMana(cost);
		p.setManaSpent(cost);
		p.setManaTimer(6);

		new BukkitRunnable() {
			double t;

			public void run() {
				t += Math.PI / 12;
				Location loc = p.getPlayer().getLocation();
				for (double phi = 0; 2 * Math.PI >= phi; phi += Math.PI / 2) {
					double x = 0.3 * (4 * Math.PI - t) * Math.cos(t + phi);
					double y = 0.2 * t;
					double z = 0.3 * (4 * Math.PI - t) * Math.sin(t + phi);
					loc.add(x, y, z);
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
					loc.subtract(x, y, z);

					if (4 * Math.PI <= this.t) {
						loc.add(x, y, z);
						p.getPlayer().getWorld().spawnParticle(Particle.SNOW_SHOVEL, loc, 10);
						this.cancel();
					}
				}
			}
		}.runTaskTimer(Plugin.getInstance(), 0, 1);
		return true;
	}
}
