// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Die implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player p) {
			p.sendMessage("You have just killed yourself, good job!");
			p.setHealth(0.0);
		}
		return true;
	}
}
