package me.dnfneca.plugin.utilities.managers.Social;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static me.dnfneca.plugin.Plugin.NPCs;

public class ExecuteActions {
	public static void Action(String[] args,String directed_to , CommandSender sender) {
		Player player = (Player) sender;
		if(args[0].equals("reputation")) {
			PlayerFiles.AddDataToPlayerFile(String.valueOf(player.getUniqueId()), args[0], directed_to + " " + args[1]);
		}
	}

//	public static int getPlayerReputation() {
//		INSERT INTO `6a025aa7-802d-37b4-9a9e-d2a5296257fa` (`xpAmount`, `class`, `DNFneca`) VALUES ('2', 'none', '0');
//		UPDATE `6a025aa7-802d-37b4-9a9e-d2a5296257fa` SET `xpAmount`='0',`class`='Asssasin',`DNFneca`='-25' WHERE 1
//	}

	public static boolean Requirements(String argumentsString, CommandSender sender) {
		Player player = (Player) sender;
		PlayerStats playerStats = PlayerStats.getPlayerStats(((Player) sender).getUniqueId());
		String[] individualRequirements = argumentsString.split(",");
		for(int i = 0; i < individualRequirements.length; i++) {
			String[] args = individualRequirements[i].split(" ");
			if(args[0].equals("Level")) {
				if(args[1].equals("<")) {
					if(playerStats.getXp() > Integer.parseInt(args[2])) {
						return false;
					}
				} else {
					if(playerStats.getXp() < Integer.parseInt(args[1])) {
						return false;
					}
				}
			} else if(args[0].equals("reputation")) {
				for(int npcCount = 0; i < NPCs.size() - 1; npcCount++) {
					System.out.println(npcCount);
					if(NPCs.get(npcCount).equals(args[1])) {
						if(PlayerFiles.FieldExists(player.getUniqueId().toString(), "reputation")) {
							String[] reputationArgs = PlayerFiles.GetPlayerFileField(player.getUniqueId().toString(), "reputation");
							for(int reputationsArgsNum = 0; reputationsArgsNum < reputationArgs.length; reputationsArgsNum++) {
								String[] reputationsArguments = reputationArgs[i].split(" ");
								if(reputationsArguments[0].equals(NPCs)) {
									if(args[2].equals("<")) {
										if(Integer.parseInt(args[3]) > Integer.parseInt(reputationsArguments[1])) {
											return false;
										}
									} else {
										if(Integer.parseInt(args[2]) < Integer.parseInt(reputationsArguments[1])) {
											return false;
										}
									}
								}
							}
						} else {
							return false;
						}
					}
				}
			}

		}

		return true;
	}
}
