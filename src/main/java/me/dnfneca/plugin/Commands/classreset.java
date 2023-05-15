package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.GUI.GUI;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class classreset implements CommandExecutor {
	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		if (sender.isOp()) {
			if ("classreset".equalsIgnoreCase(command.getName())) {
				if (sender instanceof Player p) {
					PlayerStats.getPlayerStats(p.getUniqueId()).setClass("none");
					GUI.ChooseClassesMenu(p);
				}
			}

		} else {
			sender.sendMessage("You are not allowed to use this command!");
		}
		return true;
	}
}
