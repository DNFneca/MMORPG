package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Social.ExecuteActions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;

import static me.dnfneca.plugin.utilities.managers.Social.NextConversation.nextConversation;

public class runConversation implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if ("runConversation".equalsIgnoreCase(command.getName())) {
			if (sender instanceof Player p) {
				try {
					JSONParser parser = new JSONParser();
					JSONObject data = (JSONObject) parser.parse(
							new FileReader("./plugins/MMORPGData/Convo/Results/" + args[0] + "/" + args[1] + ".json", StandardCharsets.UTF_8));//path to the JSON file.
					Collection values = data.values();
					String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
					String[] array = edit1.split(",");
					for(int i = 0; i < 100; i++) {
						sender.sendMessage("");
					}

					if(data.get("action") != null){
						String[] arrayList = data.get("action").toString().replace("[", "").replace("]", "").replace("\"", "").replace(" ", "").split(",");
						ExecuteActions.Action(arrayList,data.get("directed_to").toString(),sender);
					}

					p.sendMessage(ChatColor.GREEN + args[0] + ChatColor.GOLD + ": " + ChatColor.WHITE + data.get("answer").toString());

					if(data.get("question").toString().equals("Leave")) {
						return true;
					}

					args[1] = data.get("question").toString();

					nextConversation(args, sender);

				} catch (IOException | ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return true;
	}


}
