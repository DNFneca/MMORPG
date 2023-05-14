// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import me.dnfneca.plugin.utilities.GUI.Waystone;
<<<<<<< Updated upstream
import java.io.FileWriter;
=======
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
>>>>>>> Stashed changes
import org.json.simple.JSONArray;
import java.io.Reader;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
<<<<<<< Updated upstream
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.entity.Player;
import me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager;
import org.bukkit.ChatColor;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Material;
import me.dnfneca.plugin.utilities.GUI.GUI;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
=======
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.listeners.PlayerJoin.Players;
import static me.dnfneca.plugin.utilities.GUI.GUI.MainMenu;

public class RightClickListener implements Listener {
>>>>>>> Stashed changes

public class RightClickListener implements Listener
{
    @EventHandler
<<<<<<< Updated upstream
    public void onAbilityTry(final PlayerInteractEvent e) {
        final Action action = e.getAction();
        final Player p = e.getPlayer();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
=======
    public void onAbilityTry(PlayerInteractEvent e) {
        Action action = e.getAction();
        Player p = e.getPlayer();
        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
>>>>>>> Stashed changes
            e.getPlayer().getInventory().getItemInMainHand();
            if (p.getInventory().getItemInMainHand().getItemMeta() != null && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Menu")) {
                e.setCancelled(true);
                GUI.MainMenu(p);
                return;
            }
<<<<<<< Updated upstream
            if (e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.ANVIL) {
                p.sendMessage("Clicked on anvil");
            }
            for (final PlayerStats player : PlayerJoin.Players) {
                if (p.getUniqueId().equals(player.getUUID())) {
                    for (final Item item : Plugin.CustomItems) {
                        System.out.println(item.getName());
                        if (item.getName().equals(ChatColor.stripColor(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()))) {
                            AbilitiesManager.getAbility(item.getAbility(), player);
=======
            if(e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.ANVIL) {
                p.sendMessage("Clicked on anvil");
            }
            for (PlayerStats player : Players) {
                if(p.getUniqueId().equals(player.getUUID())) {
                    for (Item item:CustomItems) {
                        System.out.println(item.getName());
                        if(item.getName().equals(ChatColor.stripColor(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()))) {
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
    public void onEntityClick(PlayerInteractAtEntityEvent e) {
        if(e.getRightClicked().getCustomName().contains("Waystone")) {
            try {







                JSONParser parser = new JSONParser();
                JSONObject data = (JSONObject) parser.parse(
                        new FileReader("./plugins/MMORPGData/Waystones.json"));//path to the JSON file.

                data.keySet().forEach(keyStr -> {
                    Object keyvalue = data.get(keyStr);
                    if(keyStr.toString().contains(e.getPlayer().getUniqueId().toString())) {
                        String[] array = keyvalue.toString().split(",");
                        int temp = 0;
                        for (String s: array) {
                            if(s.contains("Waystone")) temp = 0;
                            temp++;
>>>>>>> Stashed changes
                        }
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void onEntityClick(final PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked().getCustomName().contains("Waystone")) {
            try {
                final JSONParser parser = new JSONParser();
                final JSONObject data = (JSONObject)parser.parse((Reader)new FileReader("./plugins/MMORPGData/Waystones.json"));
                final Object keyvalue;
                String[] array;
                int temp;
                final String[] array3;
                int length;
                int i = 0;
                String s;
                data.keySet().forEach(keyStr -> {
                    keyvalue = data.get(keyStr);
                    if (keyStr.toString().contains(e.getPlayer().getUniqueId().toString())) {
                        array = keyvalue.toString().split(",");
                        temp = 0;
                        for (length = array3.length; i < length; ++i) {
                            s = array3[i];
                            if (s.contains("Waystone")) {
                                temp = 0;
                            }
                            ++temp;
                        }
                    }
                    return;
                });
<<<<<<< Updated upstream
                final JSONArray array2 = new JSONArray();
                final Object xe = data.get((Object)e.getPlayer().getUniqueId().toString());
                if (xe == null) {
                    array2.add((Object)e.getRightClicked().getCustomName());
                    array2.add((Object)e.getPlayer().getLocation().getX());
                    array2.add((Object)e.getPlayer().getLocation().getY());
                    array2.add((Object)e.getPlayer().getLocation().getZ());
                    final JSONObject jsonObject = data;
                    jsonObject.put((Object)e.getPlayer().getUniqueId(), (Object)array2);
                    final FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json");
                    file.write(jsonObject.toString());
                    file.close();
=======
                
                JSONArray array = new JSONArray();

                Object xe = data.get(e.getPlayer().getUniqueId().toString());
                if(xe == null) {
                    array.add(e.getRightClicked().getCustomName());
                    array.add(e.getPlayer().getLocation().getX());
                    array.add(e.getPlayer().getLocation().getY());
                    array.add(e.getPlayer().getLocation().getZ());
                    JSONObject jsonObject = data;

                    jsonObject.put(e.getPlayer().getUniqueId(),array);
                    FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json");
                    file.write(jsonObject.toString());
                    file.close();
                } else {
                    if(xe.toString().contains(e.getRightClicked().getCustomName())) {
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
                        FileWriter file = new FileWriter("./plugins/MMORPGData/Waystones.json");
                        jsonObject.replace(e.getPlayer().getUniqueId(), jsonObject, newJSONObject);
                        file.write(jsonObject.toString());
                        file.close();
                    }
>>>>>>> Stashed changes
                }
                else if (xe.toString().contains(e.getRightClicked().getCustomName())) {
                    Waystone.getWaystonesNames(e.getPlayer());
                }
                else {
                    final Object Value = data.get((Object)e.getPlayer().getUniqueId().toString());
                    array2.add(Value);
                    array2.add((Object)e.getRightClicked().getCustomName());
                    array2.add((Object)e.getPlayer().getLocation().getX());
                    array2.add((Object)e.getPlayer().getLocation().getY());
                    array2.add((Object)e.getPlayer().getLocation().getZ());
                    final JSONObject jsonObject2 = data;
                    final JSONObject newJSONObject = data;
                    newJSONObject.put((Object)e.getPlayer().getUniqueId().toString(), (Object)array2);
                    final FileWriter file2 = new FileWriter("./plugins/MMORPGData/Waystones.json");
                    jsonObject2.replace((Object)e.getPlayer().getUniqueId(), (Object)jsonObject2, (Object)newJSONObject);
                    file2.write(jsonObject2.toString());
                    file2.close();
                }
                Waystone.WaystoneMenu(e.getPlayer(), e.getRightClicked().getCustomName());
            }
            catch (IOException | ParseException ex2) {
                final Exception ex;
                final Exception exception = ex;
                exception.printStackTrace();
            }
        }
    }
}
