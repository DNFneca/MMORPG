package me.dnfneca.plugin.utilities.managers.Mayors.util;

import me.dnfneca.plugin.utilities.managers.Mayors.MayorEvent;
import me.dnfneca.plugin.utilities.managers.Towns.Town;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Random;

import static me.dnfneca.plugin.Plugin.Towns;

public class RunMayorEventRunEvent {

	private static Location location;
	private static int distance;

	public static boolean runEvent(MayorEvent event) {
		for (Town town:Towns) {
			if (town.getCityMayor().getMayorEvent() == event) {
				distance = town.getDistance();
				location = town.getCoords();
			}
		}

		switch(event.getEventName()) {
			case "Dig":
				break;
		}
		return false;
	}

	public static boolean runSingleEvent(MayorEvent event, Player player) {
		for (Town town:Towns) {
			if (town.getCityMayor().getMayorEvent() == event) {
				distance = town.getDistance();
				location = town.getCoords();
			}
		}

		switch(event.getEventName()) {
			case "Dig":
				generateLocation(location, distance, player);
				break;
		}
		return false;
	}

	private static void generateLocation(Location location, int distance, Player player) {
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		x += Math.floor(Math.random() *(distance - distance/(distance/2) + 1) + distance/(distance/2));
		z += Math.floor(Math.random() *(distance - distance/(distance/2) + 1) + distance/(distance/2));
		Location newLocation = new Location(player.getWorld(), x, y, z);
		System.out.println(newLocation.distance(location));
		if (newLocation.distance(location) > distance) {
			generateLocation(location, distance, player);
			return;
		}
		y = 320;
		newLocation.setY(320);
		while(true) {
			if (newLocation.getBlock().getType() == Material.AIR) {
				newLocation.setY(--y);
			} else if (newLocation.getBlock().getType() == Material.GRASS_BLOCK || newLocation.getBlock().getType() == Material.DIRT) {
				player.sendMessage(x + " " + y + " " + z);
				return;
			} else {
				return;
			}
			if(z < -132) {
				return;
			}
		}
	}

}
