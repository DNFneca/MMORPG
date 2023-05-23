// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.CustomMobs.SpawnMob;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class summonmob implements CommandExecutor {
	public boolean onCommand(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {
		if (sender instanceof final Player player) {
			if (player.isOp()) {
				if ("summonmob".equalsIgnoreCase(command.getName())) {
					SpawnMob.spawnMob(args[0], player.getLocation());
				}
			} else {
				player.sendMessage("You are not allowed to use this command!");
			}
			return true;
		}
		sender.sendMessage("Only players can use this command!");
		return true;
	}
}
