// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import java.util.ArrayList;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.inventory.meta.ItemMeta;
import me.dnfneca.plugin.utilities.GUI.GUI;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Reader;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.bukkit.event.player.PlayerJoinEvent;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import java.util.List;
import me.dnfneca.plugin.Plugin;
import org.bukkit.event.Listener;

public class PlayerJoin implements Listener
{
    static Plugin plugin;
    public static List<PlayerStats> Players;
    
    public PlayerJoin(final Plugin plugin) {
        PlayerJoin.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        try {
            final JSONArray jsonArray = new JSONArray();
            final JSONParser parser = new JSONParser();
            final JSONObject data = (JSONObject)parser.parse((Reader)new FileReader("./plugins/MMORPGData/Players.json"));
            final JSONObject jsonObject2;
            Object keyvalue;
            String[] split;
            String[] array;
            int length;
            int i = 0;
            String s;
            String s2;
            final JSONArray jsonArray2;
            data.keySet().forEach(keyStr -> {
                if (keyStr.toString().equals(e.getPlayer().getUniqueId().toString())) {
                    keyvalue = jsonObject2.get(keyStr);
                    array = (split = keyvalue.toString().split(","));
                    for (length = split.length; i < length; ++i) {
                        s = split[i];
                        s2 = s.replace("[", "").replace("]", "");
                        jsonArray2.add((Object)s2);
                    }
                }
                return;
            });
            if (!jsonArray.isEmpty()) {
                PlayerJoin.Players.add(new PlayerStats(e.getPlayer().getUniqueId(), Double.parseDouble(jsonArray.get(0).toString()), Double.parseDouble(jsonArray.get(1).toString()), Double.parseDouble(jsonArray.get(2).toString()), Double.parseDouble(jsonArray.get(3).toString()), Double.parseDouble(jsonArray.get(4).toString()), Double.parseDouble(jsonArray.get(5).toString()), Double.parseDouble(jsonArray.get(6).toString()), Double.parseDouble(jsonArray.get(7).toString()), Double.parseDouble(jsonArray.get(8).toString()), Integer.parseInt(jsonArray.get(9).toString()), jsonArray.get(10).toString()));
            }
            else {
                final PlayerStats p = new PlayerStats(e.getPlayer().getUniqueId(), 100.0, 50.0, 25.0, 10.0, 100.0, 100.0, 0.0, 0.0, 0.0, 0, "none");
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
                jsonArray.add((Object)p.getPlayerClass());
                final JSONObject jsonObject = data;
                jsonObject.put((Object)p.getUUID(), (Object)jsonArray);
                PlayerJoin.Players.add(p);
                try {
                    final FileWriter file = new FileWriter("./plugins/MMORPGData/Players.json");
                    file.write(jsonObject.toString());
                    file.close();
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        catch (IOException | ParseException ex4) {
            final Exception ex3;
            final Exception ex2 = ex3;
            throw new RuntimeException(ex2);
        }
        final Player player = e.getPlayer();
        final ItemStack MainMenu = new ItemStack(Material.NETHER_STAR, 1);
        final ItemMeta MenuMeta = MainMenu.getItemMeta();
        MenuMeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
        MenuMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        MainMenu.setItemMeta(MenuMeta);
        player.getInventory().setItem(8, MainMenu);
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
        for (final PlayerStats p2 : PlayerJoin.Players) {
            if (p2.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
                Bukkit.getScheduler().runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (p2.getChoiceCD() == 0) {
                            GUI.ChooseClassesMenu(player);
                        }
                    }
                }, 20L);
            }
        }
    }
    
    static {
        PlayerJoin.Players = new ArrayList<PlayerStats>(1000);
    }
}
