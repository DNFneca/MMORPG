package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public enum Helix {
	;

	public static void Helix(final PlayerStats p) {
		p.setManaSpent(25);
		p.setManaTimer(6);

		new BukkitRunnable() {
			double r, C;

			public void run() {
				this.r = 2;
				final Location loc = p.getPlayer().getLocation();
				for (double y = 0; 50 >= y; y += 0.05) {
					final double x = this.r * Math.cos(y);
					final double z = this.r * Math.sin(y);
					loc.add(x, y, z);
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
					loc.subtract(x, y, z);

				}
				cancel();
			}
		}.runTaskTimer(Plugin.getInstance(), 0, 1);
	}
}
