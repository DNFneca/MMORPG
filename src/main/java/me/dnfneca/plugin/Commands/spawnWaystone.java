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
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Location location = ((Player) sender).getLocation();

			ArmorStand waystone = location.getWorld().spawn(location, ArmorStand.class);

			waystone.setCustomName(Arrays.toString(args).replace("[", "").replace("]", "") + " Waystone");
			waystone.setInvulnerable(true);
			waystone.setCustomNameVisible(true);
//            waystone.setVisible(false);
		}
		return true;
	}
}
