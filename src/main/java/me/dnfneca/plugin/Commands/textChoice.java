package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.GUI.GUI;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
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


public class textChoice  implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//		if (sender.isOp()) {
			if ("textchoice".equalsIgnoreCase(command.getName())) {
				if (sender instanceof Player p) {

					try {
						JSONParser parser = new JSONParser();
						JSONObject data = (JSONObject) parser.parse(
								new FileReader("./plugins/MMORPGData/Convo/Conversations/" + args[0] + "/" + args[1] + ".json", StandardCharsets.UTF_8));//path to the JSON file.
						Collection values = data.values();
						String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
						String[] array = edit1.split(",");



						for(int i = 0; i < array.length; i++) {
							TextComponent message = new TextComponent(array[i]);

							message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/runconversation " + args[0] + " " + (i+1)));

							p.spigot().sendMessage(message);

						}



					} catch (IOException | ParseException e) {
						throw new RuntimeException(e);
					}


				}
			}

//		} else {
//			sender.sendMessage("You are not allowed to use this command!");
//		}
		return true;
	}
}