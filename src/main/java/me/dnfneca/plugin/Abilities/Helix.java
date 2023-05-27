package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public enum Helix {
	;

	public static boolean Helix(PlayerStats p, float cost) {
		p.removeMana(cost);
		p.setManaSpent(cost);
		p.setManaTimer(6);

		new BukkitRunnable() {
			double r, C;

			public void run() {
				r = 2;
				Location loc = p.getPlayer().getLocation();
				for (double y = 0; 50 >= y; y += 0.05) {
					double x = r * Math.cos(y);
					double z = r * Math.sin(y);
					loc.add(x, y, z);
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
					loc.subtract(x, y, z);

				}
				this.cancel();
			}
		}.runTaskTimer(Plugin.getInstance(), 0, 1);
		return true;
	}
}
