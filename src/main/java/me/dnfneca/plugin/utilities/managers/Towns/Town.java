package me.dnfneca.plugin.utilities.managers.Towns;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStatCalc;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import static me.dnfneca.plugin.Plugin.Towns;

public class Town {
	public String TownName;
	public Location coords;

	public int Distance;
	public Town(String TownName, Location coords, int Distance) {
		this.TownName = TownName;
		this.coords = coords;
		this.Distance = Distance;
		main();
	}

	public Location getCoords() {
		return coords;
	}

	public int getDistance() {
		return Distance;
	}

	public String getTownName() {
		return this.TownName;
	}
	private void main() {
		Towns.add(this);
		new BukkitRunnable() {
			@Override
			public void run() {

				double radius = Distance;
				double points = radius * 3.3333;
				Location origin = coords;

				for (int i = 0; i < points; i++) {
					double angle = 2 * Math.PI * i / points;
					Location point = origin.clone().add(radius * Math.sin(angle), 0.0d, radius * Math.cos(angle));
					Bukkit.getOnlinePlayers().forEach((Player player) -> {
						player.spawnParticle(Particle.REDSTONE, point, 6,  new Particle.DustOptions(Color.fromRGB(51, 255, 0), 4.0F));
					});
				}
			}
		}.runTaskTimer(Plugin.getInstance(), 0L, 5L);

	}
}
