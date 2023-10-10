package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import me.dnfneca.plugin.utilities.managers.Towns.Town;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.dnfneca.plugin.Plugin.Towns;

public class PlayerMove implements Listener {
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		for (Town town : Towns) {
			if (e.getPlayer().getLocation().distance(town.getCoords()) > town.getDistance()) {
				PlayerStats p = PlayerStats.getPlayerStats(e.getPlayer().getUniqueId());
				if (p.getTown().equals(town.getTownName())) {
					p.setTown("None");
					p.getPlayer().sendMessage("Left " + town.getTownName());
				}
			} else {
				PlayerStats p = PlayerStats.getPlayerStats(e.getPlayer().getUniqueId());
				if (p.getTown().equals("None")) {
					p.setTown(town.getTownName());
					p.getPlayer().sendMessage("Entered " + town.getTownName());
				}
			}
		}
	}
}
