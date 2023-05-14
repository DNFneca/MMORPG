<<<<<<< Updated upstream
// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import java.io.Reader;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.Listener;

public class PlayerLeave implements Listener
{
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent e) {
        for (final PlayerStats p : PlayerJoin.Players) {
            if (p.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
                try {
                    final JSONParser parser = new JSONParser();
                    final JSONObject data = (JSONObject)parser.parse((Reader)new FileReader("./plugins/MMORPGData/Players.json"));
                    final JSONArray jsonArray = new JSONArray();
                    jsonArray.add((Object)p.getHealth());
                    jsonArray.add((Object)p.getDamage());
                    jsonArray.add((Object)p.getDefence());
                    jsonArray.add((Object)p.getStrength());
                    jsonArray.add((Object)p.getSpeed());
                    jsonArray.add((Object)p.getMana());
                    jsonArray.add((Object)p.getCritDamage());
                    jsonArray.add((Object)p.getCritChance());
                    jsonArray.add((Object)p.getStealth());
                    jsonArray.add((Object)p.getXp());
                    jsonArray.add((Object)p.getPlayerClass().toString().replace("\"", ""));
                    final JSONObject jsonObject = data;
                    jsonObject.remove((Object)p.getUUID().toString());
                    jsonObject.put((Object)p.getUUID(), (Object)jsonArray);
                    System.out.println(p.getHealth());
                    try {
                        final FileWriter file = new FileWriter("./plugins/MMORPGData/Players.json");
                        file.write(jsonObject.toString());
                        file.close();
                    }
                    catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    PlayerJoin.Players.remove(p);
                }
                catch (IOException | ParseException ex4) {
                    final Exception ex3;
                    final Exception ex2 = ex3;
                    throw new RuntimeException(ex2);
                }
            }
        }
=======
package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static me.dnfneca.plugin.listeners.PlayerJoin.Players;

public class PlayerLeave implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        for (PlayerStats p: Players) {
            if (p.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
                try {

                    JSONParser parser = new JSONParser();
                    JSONObject data = (JSONObject) parser.parse(
                            new FileReader("./plugins/MMORPGData/Players.json"));
                    JSONArray jsonArray = new JSONArray();




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
                    jsonArray.add(p.getPlayerClass().toString().replace("\"", ""));


                    JSONObject jsonObject = data;
                    jsonObject.remove(p.getUUID().toString());
                    jsonObject.put(p.getUUID(), jsonArray);
                    System.out.println(p.getHealth());

                    try {
                        FileWriter file = new FileWriter("./plugins/MMORPGData/Players.json");
                        file.write(jsonObject.toString());
                        file.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Players.remove(p);
                    return;
                } catch (IOException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

>>>>>>> Stashed changes
    }
}
