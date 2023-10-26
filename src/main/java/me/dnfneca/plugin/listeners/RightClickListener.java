package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.GUI.Wand;
import me.dnfneca.plugin.utilities.GUI.Waystone;
import me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager;
import me.dnfneca.plugin.utilities.managers.Item.CustomItemStack;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Mayors.Events.Dig;
import me.dnfneca.plugin.utilities.managers.Mayors.util.RunMayorEventRunEvent;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static me.dnfneca.plugin.Plugin.*;
import static me.dnfneca.plugin.utilities.GUI.GUI.MainMenu;
import static me.dnfneca.plugin.utilities.GUI.Bag.OpenMenu;

public class RightClickListener implements Listener {

	@EventHandler
	public void onAbilityTry(PlayerInteractEvent e) {
		Action action = e.getAction();
		Player p = e.getPlayer();
		if ((Action.RIGHT_CLICK_AIR == action || Action.RIGHT_CLICK_BLOCK == action) && EquipmentSlot.HAND == e.getHand()) {
			PlayerStats playerStats = PlayerStats.getPlayerStats(p.getUniqueId());
			if(CustomItemStack.isItemCustomItem(p.getInventory().getItemInMainHand()) && CustomItemStack.getItemType(p.getInventory().getItemInMainHand()).equals("Bag")) {
				OpenMenu(p);
				e.setCancelled(true);
			}
			if(p.isSneaking() && CustomItemStack.isItemCustomItem(p.getInventory().getItemInMainHand())) {
				if(CustomItemStack.getItemType(p.getInventory().getItemInMainHand()).equals("Wand")) {
					Wand.OpenMenu(p);
					e.setCancelled(true);
				}
			}
//			if(playerStats == null) {
//				p.kickPlayer("Your user has been bugged, contact the server owners and/or admins");
//			}
			if(Action.RIGHT_CLICK_BLOCK == action) {
				if(playerStats.getTown() != null && playerStats.getTown().getCityMayor() != null && playerStats.getTown().getCityMayor().getMayorEvent() != null) {
					for (Dig d:Digs) {
						System.out.println(d.getPlayer());
					}
					RunMayorEventRunEvent.checkEvent(PlayerStats.getPlayerStats(p.getUniqueId()), e.getClickedBlock().getLocation());
				}
			}




			if (null != p.getInventory().getItemInMainHand() && null != p.getInventory().getItemInMainHand().getItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Menu")) {
				e.setCancelled(true);
				MainMenu(p);
				return;
			}



			if (null != e.getClickedBlock() && Material.ANVIL == e.getClickedBlock().getType()) {
				p.sendMessage("Clicked on anvil");
			}





			//ABILITIES


			if (null != p.getInventory().getItemInMainHand() && null != p.getInventory().getItemInMainHand().getItemMeta()) {
				for (PlayerStats player : Players) {
					if (p.getUniqueId().equals(player.getUUID())) {
						for (Item item : CustomItems) {
							if (ChatColor.stripColor(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()).contains(item.getName())) {
								AbilitiesManager.getAbility(item.getAbility().split(" "), player);
							}
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
	public void onEntityClick(PlayerInteractAtEntityEvent e) {
		if (e.getRightClicked().getCustomName().contains("Waystone")) {
			try {


				JSONParser parser = new JSONParser();
				JSONObject data = (JSONObject) parser.parse(
						new FileReader("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8));//path to the JSON file.

				data.keySet().forEach(keyStr -> {
					Object keyvalue = data.get(keyStr);
					if (keyStr.toString().contains(e.getPlayer().getUniqueId().toString())) {
						String[] array = keyvalue.toString().split(",");
						int temp = 0;
						for (String s : array) {
							if (s.contains("Waystone")) temp = 0;
							temp++;
						}
					}
				});

				JSONArray array = new JSONArray();

				Object xe = data.get(e.getPlayer().getUniqueId().toString());
				if (null == xe) {
					array.add(e.getRightClicked().getCustomName());
					array.add(e.getPlayer().getLocation().getX());
					array.add(e.getPlayer().getLocation().getY());
					array.add(e.getPlayer().getLocation().getZ());
					JSONObject jsonObject = data;

					jsonObject.put(e.getPlayer().getUniqueId(), array);
					FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8);
					file.write(jsonObject.toString());
					file.close();
				} else {
					if (xe.toString().contains(e.getRightClicked().getCustomName())) {
						String[] waystones = Waystone.getWaystonesNames(e.getPlayer());

					} else {
						Object Value = data.get(e.getPlayer().getUniqueId().toString());
						array.add(Value);
						array.add(e.getRightClicked().getCustomName());
						array.add(e.getPlayer().getLocation().getX());
						array.add(e.getPlayer().getLocation().getY());
						array.add(e.getPlayer().getLocation().getZ());
						JSONObject jsonObject = data;
						JSONObject newJSONObject = data;
						newJSONObject.put(e.getPlayer().getUniqueId().toString(), array);
						FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8);
						jsonObject.replace(e.getPlayer().getUniqueId(), jsonObject, newJSONObject);
						file.write(jsonObject.toString());
						file.close();
					}
				}

				Waystone.WaystoneMenu(e.getPlayer(), e.getRightClicked().getCustomName());

			} catch (IOException | ParseException exception) {
				exception.printStackTrace();
			}
//            Object obj = new FileReader("./plugins/MMORPGData/MainData.json");
//            JSONObject object = (JSONObject) obj;
//
//            String name = (String) jsonObject.get(e.getPlayer());
//

		}
	}
}


//        e.setCancelled(true);

