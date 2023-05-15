package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.GUI.Waystone;
import me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.listeners.PlayerJoin.Players;
import static me.dnfneca.plugin.utilities.GUI.GUI.MainMenu;

public class RightClickListener implements Listener {

	@EventHandler
	public void onAbilityTry(final PlayerInteractEvent e) {
		final Action action = e.getAction();
		final Player p = e.getPlayer();
		if (Action.RIGHT_CLICK_AIR == action || Action.RIGHT_CLICK_BLOCK == action) {
			e.getPlayer().getInventory().getItemInMainHand();
			if (null != p.getInventory().getItemInMainHand().getItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Menu")) {
				e.setCancelled(true);

				MainMenu(p);
				return;
			}
			if (null != e.getClickedBlock() && Material.ANVIL == e.getClickedBlock().getType()) {
				p.sendMessage("Clicked on anvil");
			}
			for (final PlayerStats player : Players) {
				if (p.getUniqueId().equals(player.getUUID())) {
					for (final Item item : CustomItems) {
						System.out.println(item.getName());
						if (item.getName().equals(ChatColor.stripColor(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()))) {
							AbilitiesManager.getAbility(item.getAbility(), player);
						}
					}
				}
			}
//                p.sendMessage("E");
//                p.getScoreboard().getObjective("Stats").getScore("CurrentMana").setScore(p.getScoreboard().getObjective("Stats").getScore("CurrentMana").getScore() - 25);

//            p.sendMessage(action.toString());
		}
	}

	@EventHandler
	public void onEntityClick(final PlayerInteractAtEntityEvent e) {
		if (e.getRightClicked().getCustomName().contains("Waystone")) {
			try {


				final JSONParser parser = new JSONParser();
				final JSONObject data = (JSONObject) parser.parse(
						new FileReader("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8));//path to the JSON file.

				data.keySet().forEach(keyStr -> {
					final Object keyvalue = data.get(keyStr);
					if (keyStr.toString().contains(e.getPlayer().getUniqueId().toString())) {
						final String[] array = keyvalue.toString().split(",");
						int temp = 0;
						for (final String s : array) {
							if (s.contains("Waystone")) temp = 0;
							temp++;
						}
					}
				});

				final JSONArray array = new JSONArray();

				final Object xe = data.get(e.getPlayer().getUniqueId().toString());
				if (null == xe) {
					array.add(e.getRightClicked().getCustomName());
					array.add(e.getPlayer().getLocation().getX());
					array.add(e.getPlayer().getLocation().getY());
					array.add(e.getPlayer().getLocation().getZ());
					final JSONObject jsonObject = data;

					jsonObject.put(e.getPlayer().getUniqueId(), array);
					final FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8);
					file.write(jsonObject.toString());
					file.close();
				} else {
					if (xe.toString().contains(e.getRightClicked().getCustomName())) {
						final String[] waystones = Waystone.getWaystonesNames(e.getPlayer());

					} else {
						final Object Value = data.get(e.getPlayer().getUniqueId().toString());
						array.add(Value);
						array.add(e.getRightClicked().getCustomName());
						array.add(e.getPlayer().getLocation().getX());
						array.add(e.getPlayer().getLocation().getY());
						array.add(e.getPlayer().getLocation().getZ());
						final JSONObject jsonObject = data;
						final JSONObject newJSONObject = data;
						newJSONObject.put(e.getPlayer().getUniqueId().toString(), array);
						final FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8);
						jsonObject.replace(e.getPlayer().getUniqueId(), jsonObject, newJSONObject);
						file.write(jsonObject.toString());
						file.close();
					}
				}

				Waystone.WaystoneMenu(e.getPlayer(), e.getRightClicked().getCustomName());

			} catch (final IOException | ParseException exception) {
				exception.printStackTrace();
			}
//            Object obj = new FileReader("./plugins/MMORPGData/MainData.json");
//            JSONObject object = (JSONObject) obj;
//
//            String name = (String) jsonObject.get(e.getPlayer());
//            System.out.println(name);
//

		}
	}
}


//        e.setCancelled(true);

