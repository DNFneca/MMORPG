package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setLevel implements CommandExecutor {
	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		final Player player = (Player) sender;
		PlayerLevels.setLevel(player, Integer.parseInt(args[0]));
		return true;
	}
}
