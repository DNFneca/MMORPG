package me.dnfneca.plugin.utilities.managers.Mayors.Events;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

import static me.dnfneca.plugin.Plugin.Digs;

public class Dig {

	private Player player;

	private boolean wasDug = false;

	private Location holeLocation;


	public Dig(PlayerStats player, Location digLocation) {
		this.player = player.getPlayer();
		generateDigLocation(digLocation, player);
		Digs.add(this);
	}

	public void checkDig(PlayerStats player, Location clickLocation) {
		if(holeLocation.distance(clickLocation) < 2) {
			player.getPlayer().sendMessage("Mined Dig");
			wasDug = true;
			Digs.remove(this);
			new Dig(player, player.getTown().getCoords());
		}
	}

	public Player getPlayer() {
		return this.player;
	}

	public void createParticles(Location location) {
		new BukkitRunnable() {
			@Override
			public void run() {
				if(wasDug) {
					this.cancel();
				}
				Dig.this.player.spawnParticle(Particle.REDSTONE, location.getBlockX(), location.getBlockY() + 1, location.getBlockZ(), 6, new Particle.DustOptions(Color.fromRGB(255, 10, 0), 4.0F));
			}
		}.runTaskTimer(Plugin.getInstance(), 0L, 5L);
	}


	private Random random = new Random();
	private void generateDigLocation(Location digLocation, PlayerStats player) {
		int x = player.getTown().getCoords().getBlockX();
		int y = player.getTown().getCoords().getBlockY();
		int z = player.getTown().getCoords().getBlockZ();
		x += random.nextInt(player.getTown().getDistance() + player.getTown().getDistance()) - player.getTown().getDistance();
		z += random.nextInt(player.getTown().getDistance() + player.getTown().getDistance()) - player.getTown().getDistance();
		Location newLocation = new Location(digLocation.getWorld(), x, y, z);
		System.out.println(newLocation.distance(PlayerStats.getPlayerStats(getPlayer().getUniqueId()).getTown().getCoords()));
		if (PlayerStats.getPlayerStats(getPlayer().getUniqueId()).getTown().getCoords().distance(newLocation) > player.getTown().getDistance() || newLocation.distance(player.getPlayer().getLocation()) < 20) {
			generateDigLocation(digLocation, player);
			return;
		}
		y = 320;
		while (true) {
			if (newLocation.getBlock().getType() == Material.AIR) {
				newLocation.setY(--y);
			} else if (newLocation.getBlock().getType() == Material.GRASS_BLOCK || newLocation.getBlock().getType() == Material.DIRT) {
				this.player.sendMessage(x + " " + y + " " + z);
				holeLocation = newLocation;
				createParticles(newLocation);
				return;
			} else {
				generateDigLocation(digLocation, player);
				return;
			}
			if (z < -132) {
				return;
			}
		}
	}
}
