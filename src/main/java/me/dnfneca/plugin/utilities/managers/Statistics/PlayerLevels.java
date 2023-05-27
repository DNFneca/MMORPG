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
		try {
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8));//path to the JSON file.
			int newAmountOfXP = getXP(p) + amountOfXP;
			Object xe = data.get(p.getUniqueId().toString());
			if (null == xe) {
				JSONObject jsonObject = data;
				jsonObject.put(p.getUniqueId(), amountOfXP);
				FileWriter file = new FileWriter("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8);
				file.write(jsonObject.toString());
				file.close();
			} else {
				Object Value = data.get(p.getUniqueId().toString());
				JSONObject jsonObject = data;
				JSONObject newJSONObject = data;
				newJSONObject.put(p.getUniqueId().toString(), newAmountOfXP);
				FileWriter file = new FileWriter("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8);
				jsonObject.replace(p.getUniqueId(), jsonObject, newJSONObject);
				file.write(jsonObject.toString());
				file.close();
			}
		} catch (IOException | ParseException exception) {
			exception.printStackTrace();
		}
	}

	public static int getXP(Player p) {
		try {

			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8));//path to the JSON file.
			int xpAmount = 1;


			if (null != data.get(p.getUniqueId().toString())) {
				xpAmount = Integer.parseInt(String.valueOf(data.get(p.getUniqueId().toString())));
			}

			if (985037 < xpAmount) {
				xpAmount = 985037;
			}

			return xpAmount;

		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}


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

		for (int i = 0; i < level; i++) {
			add(p, getLeftXp(p));
		}
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
