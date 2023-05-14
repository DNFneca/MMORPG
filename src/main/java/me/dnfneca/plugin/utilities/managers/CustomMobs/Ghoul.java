package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Ghoul implements Listener {
    public static int MaxHealth = 1200;
    public static int Level = 90;
    public static String Type = "Ghoul";
    public static String Name = "Ghoul";
    public static int Defence = 50;
    public static int Strength = 85;
    public static int Damage = 100;

    static Plugin plugin;

    public Ghoul(Plugin plugin) {
        this.plugin = plugin;
    }

    public static void createGhoul(Location location, Player player) {
        final long[] AB1CD = {0};
        final long[] AB2CD = {0};
        final String[] entities = new String[0];

        Husk spider = location.getWorld().spawn(location, Husk.class);

        String texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU3MzMwYzdkNWNkOGEwYTU1YWI5ZTk1MzIxNTM1YWM3YWUzMGZlODM3YzM3ZWE5ZTUzYmVhN2JhMmRlODZiIn19fQ==";

        String id = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

        ItemStack VexHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta skullMeta = VexHead.getItemMeta();
//        GameProfile profile = new GameProfile(UUID.randomUUID(), null);


        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID()); // Get a new player profile
        PlayerTextures textures = profile.getTextures();
        URL urlObject = null;


        try {
            urlObject = new URL("https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18"); // The URL to the skin, for example: https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        textures.setSkin(urlObject);


//        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/18813764b2abc94ec3c3bc67b9147c21be850cdf996679703157f4555997ea63");
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwnerProfile(profile); // Set the owning player of the head to the player profile
        head.setItemMeta(meta);
        player.getInventory().addItem(head);




        spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
        spider.setCustomNameVisible(true);


        SkullMeta headMeta = (SkullMeta) VexHead.getItemMeta();
//        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

//        profile.getProperties().put("textures", new Property("textures", id));

        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        VexHead.setItemMeta(headMeta);

        spider.getEquipment().setHelmet(head);
        Attributable creatureAt = spider;
        AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(100);
        spider.setHealth(100);
        String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
        String level = getScores[0];
        spider.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + Level + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Ghoul ");

        new BukkitRunnable() {
            public void run() {
                int index = 0;
                int range = 10;
                if (!(spider.isDead())) {
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
                    if (spider.getTarget() == null) {
                        List<Entity> entityaround;
                        List<Player> allPlayers = new ArrayList<>();
                        entityaround = spider.getNearbyEntities(range, range, range);
                        for (Entity p : entityaround) {
                            if(p instanceof Player) {
                                int stealth = ((Player) p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
                                double distance = spider.getLocation().distance(p.getLocation());
                                double stealthRange = (double)range - (double)range * (double)stealth*0.01;
                                if(distance <= stealthRange) {
                                    allPlayers.add((Player) p);
                                }
                            }
                        }
                        for(Player p : allPlayers) {
                            Player target = allPlayers.get(index);
                            if(index >= 1) {
                                if (target.getScoreboard().getObjective("Stats").getScore("Health").getScore() < allPlayers.get(index - 1).getScoreboard().getObjective("Stats").getScore("Health").getScore()) {
                                    spider.setTarget(p);
                                    p.sendMessage(p.getDisplayName());
                                }
                            } else {
                                spider.setTarget(allPlayers.get(0));
                                p.sendMessage(p.getDisplayName());
                            }
                            index ++;
                        }
                    }
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0L, 10L);
    }
}
