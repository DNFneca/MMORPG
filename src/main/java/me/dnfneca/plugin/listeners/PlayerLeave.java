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

    }
}
