package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static me.dnfneca.plugin.Plugin.*;
import static me.dnfneca.plugin.utilities.GUI.GUI.ChooseClassesMenu;

public class PlayerLeave implements Listener {
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if(!Players.isEmpty()) {
			for (PlayerStats p : Players) {
				if (p.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
					if(connection != null) {
						Players.remove(p);
						return;
					} else {
						new BukkitRunnable() {
							@Override
							public void run() {
								if (connection != null && !e.getPlayer().isOnline()) {
									Players.remove(p);
									this.cancel();
								}
							}
						}.runTaskTimer(getInstance(), 0L, 20L);
					}
				}
			}
		}
	}
}
