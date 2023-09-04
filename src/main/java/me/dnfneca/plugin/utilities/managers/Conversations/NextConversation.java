package me.dnfneca.plugin.utilities.managers.Conversations;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class NextConversation {
	public static void nextConversation(String[] args, CommandSender sender) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Convo/Conversations/" + args[0] + "/" + args[1] + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			Collection values = data.values();
			String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
			String[] array = edit1.split(",");
			String originalString = args[1];
			for(int i = 1; i <= array.length; i++) {
				TextComponent message = new TextComponent(ChatColor.GOLD + "[" + i + "] " + ChatColor.GRAY + data.get(String.valueOf(i)));


				if(data.get(String.valueOf(i)).equals("Leave")) {
					args[1] = "Leave";
				} else {
					args[1] = originalString.concat("-" + i);
				}
				message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/runconversation " + args[0] + " " + args[1]));

				sender.spigot().sendMessage(message);

			}


		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
