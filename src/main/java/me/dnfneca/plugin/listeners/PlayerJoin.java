package me.dnfneca.plugin.listeners;


import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.CustomMobs.MobStats;
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

import static me.dnfneca.plugin.utilities.GUI.GUI.ChooseClassesMenu;


public class PlayerJoin implements Listener {

	static Plugin plugin;

	public PlayerJoin(final Plugin plugin) {
		PlayerJoin.plugin = plugin;
	}

	public static List<PlayerStats> Players = new ArrayList<>(1000);
	public static List<MobStats> CustomMobs = new ArrayList<>(10000);


	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {
//        System.out.println(Players);
		try {
			final JSONArray jsonArray = new JSONArray();
			final JSONParser parser = new JSONParser();
			final JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players.json", StandardCharsets.UTF_8));
			data.keySet().forEach(keyStr -> {
				if (keyStr.toString().equals(e.getPlayer().getUniqueId().toString())) {
					final Object keyvalue = data.get(keyStr);
					final String[] array = keyvalue.toString().split(",");
					for (String s : array) {
						s = s.replace("[", "").replace("]", "");
						jsonArray.add(s);
					}

				}
			});


			if (!jsonArray.isEmpty()) {
				PlayerJoin.Players.add(new PlayerStats(e.getPlayer().getUniqueId(),
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
				final PlayerStats p = new PlayerStats(e.getPlayer().getUniqueId(), 100, 50, 25, 10, 100, 100, 0, 0, 0, 0, "none");
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


				final JSONObject jsonObject = data;

				jsonObject.put(p.getUUID(), jsonArray);

				PlayerJoin.Players.add(p);

				try {
					final FileWriter file = new FileWriter("./plugins/MMORPGData/Players.json", StandardCharsets.UTF_8);
					file.write(jsonObject.toString());
					file.close();
				} catch (final IOException ex) {
					throw new RuntimeException(ex);
				}
			}

		} catch (final IOException | ParseException ex) {
			throw new RuntimeException(ex);
		}


//        if(!doesPlayerExist) {
//
//            try {
//                JSONParser parser = new JSONParser();
//                JSONObject data = (JSONObject) parser.parse(
//                    new FileReader("./plugins/MMORPGData/Players.json"));
//
//                data.keySet().forEach(keyStr -> {
//                    Object keyvalue = data.get(keyStr);
//                    if (keyStr.toString().contains(e.getPlayer().getUniqueId().toString())) {
//                        String[] array = keyvalue.toString().split(",");
//                        System.out.println("EE");
//                        System.out.println(array[0]);
//
//                        UUID uuid = UUID.fromString(keyStr.toString());
//
//
//                        PlayerStats playerr = new PlayerStats(uuid,
//                                Double.parseDouble(array[0].replace("[", "")),
//                                Double.parseDouble(array[1]),
//                                Double.parseDouble(array[2]),
//                                Double.parseDouble(array[3]),
//                                Double.parseDouble(array[4]),
//                                Double.parseDouble(array[5]),
//                                Double.parseDouble(array[6]),
//                                Double.parseDouble(array[7]),
//                                Double.parseDouble(array[8]),
//                                Integer.parseInt(array[9]),
//                                "none");
//                        Players.add(playerr);
//                        return;
////                        for (String s : array) {
////                            if (s.contains("Waystone")) temp = 0;
////                            temp++;
////                        }
//                    }
//                });
//                PlayerStats playerr = new PlayerStats(e.getPlayer().getUniqueId(), 100, 25, 5, 25, 100, 100, 0, 0, 0, 0, "none");
//                Players.add(playerr);
//
////                Object xe = data.get(e.getPlayer().getUniqueId().toString());
////                if (xe == null) {
////                    array.add(e.getRightClicked().getCustomName());
////                    array.add(e.getPlayer().getLocation().getX());
////                    array.add(e.getPlayer().getLocation().getY());
////                    array.add(e.getPlayer().getLocation().getZ());
////                    JSONObject jsonObject = data;
////
////                    jsonObject.put(e.getPlayer().getUniqueId(), array);
//
////                } else {
////                    if (xe.toString().contains(e.getRightClicked().getCustomName())) {
////                        String[] waystones = Waystone.getWaystonesNames(e.getPlayer());
////
////                    } else {
////                        Object Value = data.get(e.getPlayer().getUniqueId().toString());
////                        array.add(Value);
////                        array.add(e.getRightClicked().getCustomName());
////                        array.add(e.getPlayer().getLocation().getX());
////                        array.add(e.getPlayer().getLocation().getY());
////                        array.add(e.getPlayer().getLocation().getZ());
////                        JSONObject jsonObject = data;
////                        JSONObject newJSONObject = data;
////                        newJSONObject.put(e.getPlayer().getUniqueId().toString(), array);
////                        FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json");
////                        jsonObject.replace(e.getPlayer().getUniqueId(), jsonObject, newJSONObject);
////                        file.write(jsonObject.toString());
////                        file.close();
////                    }
////                }
//            } catch (IOException | ParseException ex) {
//                throw new RuntimeException(ex);
//            }
//        }

//        PlayerStats playerr = new PlayerStats(e.getPlayer().getUniqueId(), 100, 25, 5, 25, 100, 100, 0, 0, 0, 0, "none");
//        Players.add(playerr);
//        System.out.println(Players);
		final Player player = e.getPlayer();
		final ItemStack MainMenu = new ItemStack(Material.NETHER_STAR, 1);
		final ItemMeta MenuMeta = MainMenu.getItemMeta();
		MenuMeta.setDisplayName(ChatColor.GRAY + "Menu");
		MenuMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		MainMenu.setItemMeta(MenuMeta);
		player.getInventory().setItem(8, MainMenu);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));

		for (final PlayerStats p : PlayerJoin.Players) {
			if (p.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
				Bukkit.getScheduler().runTaskLater(Plugin.getInstance(), new Runnable() {
					@Override
					public void run() {
						if (0 == p.getChoiceCD()) {
							ChooseClassesMenu(player);
						}
					}
				}, 20L);


//                new BukkitRunnable() {
//                    @Override
//                    public void run() {
//                        if(((int)(CurrentHealth.getScore() + EffectiveHealth.getScore()*0.01) + Integer.parseInt(ItemStats.Armor(player, 1)[2]) + Integer.parseInt(ItemStats.Armor(player, 2)[2]) + Integer.parseInt(ItemStats.Armor(player, 3)[2]) + Integer.parseInt(ItemStats.Armor(player, 4)[2])) < EffectiveHealth.getScore()) {
//                            CurrentHealth.setScore((int) (CurrentHealth.getScore() + EffectiveHealth.getScore() * 0.01) + Integer.parseInt(ItemStats.Armor(player, 1)[2]) + Integer.parseInt(ItemStats.Armor(player, 2)[2]) + Integer.parseInt(ItemStats.Armor(player, 3)[2]) + Integer.parseInt(ItemStats.Armor(player, 4)[2]));
//                        } else {
//                            CurrentHealth.setScore(EffectiveHealth.getScore());
//                        }
//
//                        if(((int)(CurrentMana.getScore() + EffectiveMana.getScore()*0.01)) < EffectiveMana.getScore()) {
////                    player.sendMessage(String.valueOf((int)(CurrentMana.getScore() + EffectiveMana.getScore()*0.01)));
//                            CurrentMana.setScore((int) (CurrentMana.getScore() + EffectiveMana.getScore() * 0.01));
//                        } else {
////                    player.sendMessage(String.valueOf((int)(CurrentMana.getScore() + EffectiveMana.getScore()*0.01)));
//                            CurrentMana.setScore(EffectiveMana.getScore());
//                        }
//
//                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
//                    }
//                }.runTaskTimer(plugin , 0L, 20L);

			}
		}

	}
}
