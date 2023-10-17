package me.dnfneca.plugin.utilities.managers.Mayors.util;

import me.dnfneca.plugin.utilities.managers.Mayors.Events.Dig;
import me.dnfneca.plugin.utilities.managers.Mayors.MayorEvent;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import me.dnfneca.plugin.utilities.managers.Towns.Town;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Random;

import static me.dnfneca.plugin.Plugin.Digs;
import static me.dnfneca.plugin.Plugin.Towns;

public class RunMayorEventRunEvent {

	public static boolean runEvent(PlayerStats player, Location location) {
		switch(player.getTown().getCityMayor().getMayorEvent().getEventName()) {
			case "Dig":
				new Dig(PlayerStats.getPlayerStats(player.getPlayer().getUniqueId()), location);
				break;
		}
		return false;
	}

	public static boolean checkEvent(PlayerStats player, Location digLocation) {
		Dig dig = null;

		switch(player.getTown().getCityMayor().getMayorEvent().getEventName()) {
			case "Dig":
				for (Dig digg : Digs) {
					if(digg.getPlayer().equals(player.getPlayer())) {
						digg.checkDig(player, digLocation);
						dig = digg;
					}
				}
				if(dig == null) {
					runEvent(player, digLocation);
				}
				break;
		}
		return false;
	}

}
