package me.dnfneca.plugin.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.Arrays;


public class spawnWaystone implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		if (sender instanceof Player) {
			final Location location = ((Player) sender).getLocation();

			final ArmorStand waystone = location.getWorld().spawn(location, ArmorStand.class);

			waystone.setCustomName(Arrays.toString(args).replace("[", "").replace("]", "") + " Waystone");
			waystone.setInvulnerable(true);
			waystone.setCustomNameVisible(true);
//            waystone.setVisible(false);
		}
		return true;
	}
}
