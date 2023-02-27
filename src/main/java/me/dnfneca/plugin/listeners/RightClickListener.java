package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.GUI.Waystone;
import me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.Objective;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static me.dnfneca.plugin.utilities.GUI.GUI.MainMenu;

public class RightClickListener implements Listener {

    @EventHandler
    public void onAbilityTry(PlayerInteractEvent e) {
        Action action = e.getAction();
        Player p = e.getPlayer();
        Objective objective = p.getScoreboard().getObjective("Stats");
//        System.out.println(action);
        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            e.getPlayer().getInventory().getItemInMainHand();
            if (p.getInventory().getItemInMainHand().getItemMeta() != null && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Menu")) {
                e.setCancelled(true);

                MainMenu(p);
                return;
            }
            if(e.getClickedBlock().getType() == Material.ANVIL) {
                p.sendMessage(String.valueOf(e.getClickedBlock().getBlockData()));
            }
            AbilitiesManager.getAbility(e.getPlayer().getInventory().getItemInMainHand(), p);
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
                        new FileReader("./plugins/MMORPGData/MainData.json"));//path to the JSON file.

                data.keySet().forEach(keyStr -> {
                    Object keyvalue = data.get(keyStr);
                    if(keyStr.toString().contains(e.getPlayer().getUniqueId().toString())) {
                        String[] array = keyvalue.toString().split(",");
                        int temp = 0;
                        for (String s: array) {
                            if(s.contains("Waystone")) temp = 0;
                            switch (temp) {
                                case 1:

                            }
                            temp++;
                        }
                    }
                });
                
                JSONArray array = new JSONArray();

                Object xe = data.get(e.getPlayer().getUniqueId().toString());
                if(xe == null) {
                    array.add(e.getRightClicked().getCustomName());
                    array.add(e.getPlayer().getLocation().getX());
                    array.add(e.getPlayer().getLocation().getY());
                    array.add(e.getPlayer().getLocation().getZ());
                    JSONObject jsonObject = data;

                    jsonObject.put(e.getPlayer().getUniqueId(),array);
                    FileWriter file = new FileWriter("./plugins/MMORPGData/MainData.json");
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
                        FileWriter file = new FileWriter("./plugins/MMORPGData/MainData.json");
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
//            System.out.println(name);
//

        }
    }
}



//        e.setCancelled(true);

