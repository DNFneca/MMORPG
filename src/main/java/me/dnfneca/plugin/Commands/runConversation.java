package me.dnfneca.plugin.Commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
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
import java.util.Collection;

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
					System.out.println(values);
					String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
					String[] array = edit1.split(",");
					for(int i = 0; i < 100; i++) {
						sender.sendMessage("");
					}
					if(data.get("question").toString().equals("Leave")) {
						return true;
					}
					p.sendMessage(data.get("answer").toString());

					args[1] = data.get("question").toString();

					nextConversation(args, sender);

				} catch (IOException | ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return true;
	}

	public static void nextConversation(String[] args, CommandSender sender) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Convo/Conversations/" + args[0] + "/" + args[1] + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			Collection values = data.values();
			System.out.println(values);
			String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
			String[] array = edit1.split(",");
			String originalString = args[1];
			for(int i = 1; i <= array.length; i++) {
				TextComponent message = new TextComponent(String.valueOf(data.get(String.valueOf(i))));


				args[1] = originalString.concat("-" + i);

				message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/runconversation " + args[0] + " " + args[1]));

				sender.spigot().sendMessage(message);

			}


		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
