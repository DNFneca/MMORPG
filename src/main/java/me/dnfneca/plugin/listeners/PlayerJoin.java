package me.dnfneca.plugin.listeners;


import me.dnfneca.plugin.Plugin;
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


public class PlayerJoin implements Listener {

	static Plugin plugin;

	public PlayerJoin(Plugin plugin) {
		PlayerJoin.plugin = plugin;
	}



	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
//        System.out.println(Players);
		try {
			JSONArray jsonArray = new JSONArray();
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players.json", StandardCharsets.UTF_8));
			data.keySet().forEach(keyStr -> {
				if (keyStr.toString().equals(e.getPlayer().getUniqueId().toString())) {
					Object keyvalue = data.get(keyStr);
					String[] array = keyvalue.toString().split(",");
					for (String s : array) {
						s = s.replace("[", "").replace("]", "");
						jsonArray.add(s);
					}

				}
			});


			if (!jsonArray.isEmpty()) {
				Players.add(new PlayerStats(e.getPlayer().getUniqueId(),
						Double.parseDouble(jsonArray.get(0).toString()),
						Double.parseDouble(jsonArray.get(1).toString()),
						Double.parseDouble(jsonArray.get(2).toString()),
						Double.parseDouble(jsonArray.get(3).toString()),
						Double.parseDouble(jsonArray.get(4).toString()),
						Double.parseDouble(jsonArray.get(5).toString()),
						Double.parseDouble(jsonArray.get(6).toString()),
						Double.parseDouble(jsonArray.get(7).toString()),
						Double.parseDouble(jsonArray.get(8).toString()),
						Integer.parseInt(jsonArray.get(9).toString()),
						jsonArray.get(10).toString()));
			} else {
				PlayerStats p = new PlayerStats(e.getPlayer().getUniqueId(), 100, 50, 25, 10, 100, 100, 0, 0, 0, 0, "none");
				jsonArray.add(p.getHealth());
				jsonArray.add(p.getDamage());
				jsonArray.add(p.getDefence());
				jsonArray.add(p.getStrength());
				jsonArray.add(p.getSpeed());
				jsonArray.add(p.getMana());
				jsonArray.add(p.getCritDamage());
				jsonArray.add(p.getCritChance());
				jsonArray.add(p.getStealth());
				jsonArray.add(p.getXp());
				jsonArray.add(p.getPlayerClass());


				JSONObject jsonObject = data;

				jsonObject.put(p.getUUID(), jsonArray);

				Players.add(p);

				try {
					FileWriter file = new FileWriter("./plugins/MMORPGData/Players.json", StandardCharsets.UTF_8);
					file.write(jsonObject.toString());
					file.close();
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}

		} catch (IOException | ParseException ex) {
			throw new RuntimeException(ex);
		}
		Player player = e.getPlayer();
		ItemStack MainMenu = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta MenuMeta = MainMenu.getItemMeta();
		MenuMeta.setDisplayName(ChatColor.GRAY + "Menu");
		MenuMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		MainMenu.setItemMeta(MenuMeta);
		player.getInventory().setItem(8, MainMenu);
		for (PlayerStats p : Players) {
			if (p.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
				Bukkit.getScheduler().runTaskLater(Plugin.getInstance(), new Runnable() {
					@Override
					public void run() {
						if (0 == p.getChoiceCD()) {
							ChooseClassesMenu(player);
						}
					}
				}, 20L);

			}
		}

	}
}
