package me.dnfneca.plugin.utilities.managers.Statistics;

import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public enum PlayerLevels {
	;

	public static void add(Player p, int amountOfXP) {
		String xpAmount = PlayerFiles.GetPlayerFileField(p.getUniqueId().toString(), "level")[0];
		amountOfXP = Integer.parseInt(xpAmount) + amountOfXP;
		PlayerFiles.ReplaceExistingPlayerDataToFile(p.getUniqueId().toString(), String.valueOf(amountOfXP), "xpAmount");
	}

	public static void setXp(Player p, int amountOfXP) {
		PlayerFiles.ReplaceExistingPlayerDataToFile(p.getUniqueId().toString(), String.valueOf(amountOfXP), "xpAmount");
	}

	public static int getXP(Player p) {

		int xpAmount = 1;
		if(PlayerFiles.GetPlayerFileField(p.getUniqueId().toString(), "xpAmount") != null) {
			xpAmount = Integer.parseInt(PlayerFiles.GetPlayerFileField(p.getUniqueId().toString(), "xpAmount")[0]);
		}

		if (985037 < xpAmount) {
			xpAmount = 985037;
		}

			return xpAmount;
	}

	public static int getLevel(Player p) {

		int xpAmount = getXP(p) + 1;
		int PlayerLevel = 0;

		for (int i = 0; 101 > i; i++) {
			int Level = (int) Math.round(Math.pow(Math.sqrt((10 * (i * 10))), 3));
			if (Level > xpAmount) {
				PlayerLevel = i;
				break;
			}

		}
		return PlayerLevel;
	}

	public static void setLevel(Player p, int level) {
		level--;
		int xpAmount = (int) Math.round(Math.pow(Math.sqrt((10 * (level * 10))), 3));
		setXp(p, xpAmount);
	}

	public static int getLeftXp(Player p) {

		int xpAmount = getXP(p);
		int xpLeft = 0;

		int i = getLevel(p);
		int Level = (int) Math.round(Math.pow(Math.sqrt((10 * (i * 10))), 3));
		xpLeft = Level - xpAmount;
		return xpLeft;
	}

	public static int getLevelXp(Player p) {

		int levelXp;

		int i = getLevel(p);
		int Level = (int) Math.round(Math.pow(Math.sqrt((10 * (i * 10))), 3));
		levelXp = Level - (int) Math.round(Math.pow(Math.sqrt((10 * ((i - 1) * 10))), 3));

		return levelXp;
	}
}
