// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player p) {
			if (p.isInvulnerable()) {
				p.sendMessage("You are no longer ascended");
				p.setAllowFlight(false);
				p.setInvulnerable(false);
			} else {
				p.sendMessage("You have just ascended");
				p.setAllowFlight(true);
				p.setInvulnerable(true);
			}
			PlayerLevels.add(p, 100);
			System.out.println(PlayerLevels.getLevel(p));
		}
		return true;
	}
}
