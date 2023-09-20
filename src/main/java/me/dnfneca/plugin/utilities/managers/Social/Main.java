package me.dnfneca.plugin.utilities.managers.Social;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.UUID;

import static me.dnfneca.plugin.Plugin.*;

public class Main {
	public static void initConvo(UUID playerUUID, String[] NPCName) {
		Statement statement = null;
		try {
			statement = connection.createStatement();

			statement.execute("ALTER TABLE `" + playerUUID + "` ADD IF NOT EXISTS `" + NPCName[0] + "` INT NOT NULL DEFAULT '0'");
//			statement.execute("INSERT INTO `" + playerUUID + "` IF NOT EXISTS (`xpAmount`, `class`, `DNFneca`) VALUES ('2', 'none', '0');");
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Convo/Conversations/" + NPCName[1] + "/" + NPCName[2] + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			Collection values = data.values();
			String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
			String[] array = edit1.split(",");


			// TODO : make the reading of reputation sql based
			// TODO : remake the sql model if needed
			// TODO : make npc and integrate with the convo system
			// TODO : separate the social and stats system
			// TODO : easily accessible stats with sql

			for(int i = 0; i < array.length; i++) {
				array[i] = array[i].startsWith(" ") ? array[i].substring(1) : array[i] ;
				TextComponent message = new TextComponent(ChatColor.GOLD + "[" + i + "] " + ChatColor.GRAY + array[i]);
				message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/runconversation " + NPCName[1] + " " + (i+1)));
				PlayerStats.getPlayerStats(playerUUID).getPlayer().spigot().sendMessage(message);
			}

		} catch (SQLException | IOException | ParseException e) {
			System.out.println(e);
		}


	}

}
