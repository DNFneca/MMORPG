package me.dnfneca.plugin.listeners;


import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerFiles;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomMobs;
import static me.dnfneca.plugin.Plugin.Players;
import static me.dnfneca.plugin.utilities.GUI.GUI.ChooseClassesMenu;
import static me.dnfneca.plugin.utilities.managers.Statistics.PlayerFiles.CreatePlayerFile;


public class PlayerJoin implements Listener {

	static Plugin plugin;

	public PlayerJoin(Plugin plugin) {
		PlayerJoin.plugin = plugin;
	}



	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		CreatePlayerFile(e.getPlayer().getUniqueId().toString());
		Player player = e.getPlayer();
		try {

			String Class = "none";
			if (!PlayerFiles.FieldExists(String.valueOf(player.getUniqueId()), "class")) {
				PlayerFiles.AddDataToPlayerFile(String.valueOf(player.getUniqueId()), "class", "none");
			} else {
				Class = PlayerFiles.GetPlayerFileField(String.valueOf(player.getUniqueId()), "class")[0];
			}
			Players.add(new PlayerStats(e.getPlayer().getUniqueId(), 100, 50, 25, 10, 100, 100, 0, 0, 0, 0, Class));

			if(!PlayerFiles.FieldExists(player.getUniqueId().toString(), "xpAmount")){
				PlayerFiles.AddDataToPlayerFile(player.getUniqueId().toString(), "xpAmount", "0");
			}
		} finally {
			ItemStack MainMenu = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta MenuMeta = MainMenu.getItemMeta();
			MenuMeta.setDisplayName(ChatColor.GRAY + "Menu");
			MenuMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			MainMenu.setItemMeta(MenuMeta);
			player.getInventory().setItem(8, MainMenu);
			for (PlayerStats playerStats : Players) {
				if (playerStats.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
					Bukkit.getScheduler().runTaskLater(Plugin.getInstance(), new Runnable() {
						@Override
						public void run() {
							if (0 == playerStats.getChoiceCD()) {
								ChooseClassesMenu(player);
							}
						}
					}, 20L);

				}
			}
		}



	}
}
