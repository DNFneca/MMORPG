package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

import static me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager.HitDetection;

public enum Fireball {
	;

	public static void Fireball(PlayerStats p) {
		p.setManaSpent(25);
		p.setManaTimer(6);

		new BukkitRunnable() {
			double distanceTraveled;

			public void run() {
				Location loc = p.getPlayer().getEyeLocation();
				for (distanceTraveled = 0; 15 >= this.distanceTraveled; distanceTraveled++) {
					loc.add(loc.getDirection());
					//              BLOOD COLOR                  p.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(135, 5, 1), 20.0F));
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, new Particle.DustOptions(Color.fromRGB(255, 51, 21), 20.0F));
					if (HitDetection(loc, 0.2, p)) {
						this.cancel();
						return;
					}
				}
				this.cancel();
			}
		}.runTaskTimer(Plugin.getInstance(), 4, 1);
	}
}
