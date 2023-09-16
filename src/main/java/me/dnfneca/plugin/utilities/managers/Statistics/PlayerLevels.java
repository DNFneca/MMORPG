package me.dnfneca.plugin.utilities.managers.Statistics;

import me.dnfneca.plugin.utilities.managers.Social.PlayerFiles;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static me.dnfneca.plugin.Plugin.connection;

public enum PlayerLevels {
	;

	public static void add(Player p, int amountOfXP) {
		String xpAmount = PlayerFiles.GetPlayerFileField(p.getUniqueId().toString(), "level")[0];
		amountOfXP = Integer.parseInt(xpAmount) + amountOfXP;
		PlayerStats.getPlayerStats(p.getUniqueId()).setXp(amountOfXP);
	}

	public static int getLevel(Player p) {

		int xpAmount = PlayerStats.getPlayerStats(p.getUniqueId()).getXp() + 1;
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
		PlayerStats.getPlayerStats(p.getUniqueId()).setXp(xpAmount);
	}

	public static int getLeftXp(Player p) {

		int xpAmount = PlayerStats.getPlayerStats(p.getUniqueId()).getXp();
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
