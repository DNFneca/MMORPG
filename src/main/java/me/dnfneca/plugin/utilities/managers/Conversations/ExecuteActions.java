package me.dnfneca.plugin.utilities.managers.Conversations;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerFiles;
import org.bukkit.command.CommandSender;

public class ExecuteActions {
	public static void Action(String[] args,String directed_to , CommandSender sender) {
		if(args[0].equals("reputation")) {
			org.bukkit.entity.Player player = (org.bukkit.entity.Player) sender;
			PlayerFiles.SaveToPlayerFile(String.valueOf(player.getUniqueId()), directed_to, args[1]);
		}
	}
}
