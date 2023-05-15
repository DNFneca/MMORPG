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

	public static void add(final Player p, final int amountOfXP) {
		try {
			final JSONParser parser = new JSONParser();
			final JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8));//path to the JSON file.
			final int newAmountOfXP = PlayerLevels.getXP(p) + amountOfXP;
			final Object xe = data.get(p.getUniqueId().toString());
			if (null == xe) {
				final JSONObject jsonObject = data;
				jsonObject.put(p.getUniqueId(), amountOfXP);
				final FileWriter file = new FileWriter("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8);
				file.write(jsonObject.toString());
				file.close();
			} else {
				final Object Value = data.get(p.getUniqueId().toString());
				final JSONObject jsonObject = data;
				final JSONObject newJSONObject = data;
				newJSONObject.put(p.getUniqueId().toString(), newAmountOfXP);
				final FileWriter file = new FileWriter("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8);
				jsonObject.replace(p.getUniqueId(), jsonObject, newJSONObject);
				file.write(jsonObject.toString());
				file.close();
			}
		} catch (final IOException | ParseException exception) {
			exception.printStackTrace();
		}
	}

	public static int getXP(final Player p) {
		try {

			final JSONParser parser = new JSONParser();
			final JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Level.json", StandardCharsets.UTF_8));//path to the JSON file.
			int xpAmount = 1;


			if (null != data.get(p.getUniqueId().toString())) {
				xpAmount = Integer.parseInt(String.valueOf(data.get(p.getUniqueId().toString())));
			}

			if (985037 < xpAmount) {
				xpAmount = 985037;
			}

			return xpAmount;

		} catch (final IOException | ParseException e) {
			throw new RuntimeException(e);
		}


	}

	public static int getLevel(final Player p) {

		final int xpAmount = PlayerLevels.getXP(p) + 1;
		int PlayerLevel = 0;

		for (int i = 0; 101 > i; i++) {
			final int Level = (int) Math.round(Math.pow(Math.sqrt((10 * (i * 10))), 3));
			if (Level > xpAmount) {
				PlayerLevel = i;
				break;
			}

		}
		return PlayerLevel;
	}

	public static void setLevel(final Player p, final int level) {

		for (int i = 0; i < level; i++) {
			add(p, PlayerLevels.getLeftXp(p));
		}
	}

	public static int getLeftXp(final Player p) {

		final int xpAmount = PlayerLevels.getXP(p);
		int xpLeft = 0;

		final int i = PlayerLevels.getLevel(p);
		final int Level = (int) Math.round(Math.pow(Math.sqrt((10 * (i * 10))), 3));
		xpLeft = Level - xpAmount;
		return xpLeft;
	}

	public static int getLevelXp(final Player p) {

		final int levelXp;

		final int i = PlayerLevels.getLevel(p);
		final int Level = (int) Math.round(Math.pow(Math.sqrt((10 * (i * 10))), 3));
		levelXp = Level - (int) Math.round(Math.pow(Math.sqrt((10 * ((i - 1) * 10))), 3));

		return levelXp;
	}
}
