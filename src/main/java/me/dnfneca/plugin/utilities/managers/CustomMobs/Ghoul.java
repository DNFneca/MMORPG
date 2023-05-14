// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.CustomMobs;

import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attributable;
import java.lang.reflect.Field;
import org.bukkit.profile.PlayerTextures;
import org.bukkit.profile.PlayerProfile;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity;
import java.util.ArrayList;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import java.net.MalformedURLException;
import java.net.URL;
import org.bukkit.Bukkit;
import java.util.UUID;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import me.dnfneca.plugin.Plugin;
import org.bukkit.event.Listener;

public class Ghoul implements Listener
{
    public static int MaxHealth;
    public static int Level;
    public static String Type;
    public static String Name;
    public static int Defence;
    public static int Strength;
    public static int Damage;
    static Plugin plugin;
    
    public Ghoul(final Plugin plugin) {
        Ghoul.plugin = plugin;
    }
    
    public static void createGhoul(final Location location, final Player player) {
        final long[] AB1CD = { 0L };
        final long[] AB2CD = { 0L };
        final String[] entities = new String[0];
        final Husk spider = (Husk)location.getWorld().spawn(location, (Class)Husk.class);
        final String texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU3MzMwYzdkNWNkOGEwYTU1YWI5ZTk1MzIxNTM1YWM3YWUzMGZlODM3YzM3ZWE5ZTUzYmVhN2JhMmRlODZiIn19fQ==";
        final String id = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
        final ItemStack VexHead = new ItemStack(Material.PLAYER_HEAD, 1);
        final ItemMeta skullMeta = VexHead.getItemMeta();
        final PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
        final PlayerTextures textures = profile.getTextures();
        URL urlObject = null;
        try {
            urlObject = new URL("https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18");
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        textures.setSkin(urlObject);
        final ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwnerProfile(profile);
        head.setItemMeta((ItemMeta)meta);
        player.getInventory().addItem(new ItemStack[] { head });
        spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
        spider.setCustomNameVisible(true);
        final SkullMeta headMeta = (SkullMeta)VexHead.getItemMeta();
        try {
            final Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        }
        catch (IllegalArgumentException | NoSuchFieldException | IllegalAccessException ex2) {
            final Exception ex;
            final Exception e2 = ex;
            e2.printStackTrace();
        }
        VexHead.setItemMeta((ItemMeta)headMeta);
        spider.getEquipment().setHelmet(head);
        final Attributable creatureAt = (Attributable)spider;
        final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(100.0);
        spider.setHealth(100.0);
        final String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
        final String level = getScores[0];
        spider.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), Ghoul.Level, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.RED)));
        new BukkitRunnable() {
            public void run() {
                int index = 0;
                final int range = 10;
                if (!spider.isDead()) {
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
                    if (spider.getTarget() == null) {
                        final List<Player> allPlayers = new ArrayList<Player>();
                        final List<Entity> entityaround = (List<Entity>)spider.getNearbyEntities((double)range, (double)range, (double)range);
                        for (final Entity p : entityaround) {
                            if (p instanceof Player) {
                                final int stealth = ((Player)p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
                                final double distance = spider.getLocation().distance(p.getLocation());
                                final double stealthRange = range - range * (double)stealth * 0.01;
                                if (distance > stealthRange) {
                                    continue;
                                }
                                allPlayers.add((Player)p);
                            }
                        }
                        for (final Player p2 : allPlayers) {
                            final Player target = allPlayers.get(index);
                            if (index >= 1) {
                                if (target.getScoreboard().getObjective("Stats").getScore("Health").getScore() < allPlayers.get(index - 1).getScoreboard().getObjective("Stats").getScore("Health").getScore()) {
                                    spider.setTarget((LivingEntity)p2);
                                    p2.sendMessage(p2.getDisplayName());
                                }
                            }
                            else {
                                spider.setTarget((LivingEntity)allPlayers.get(0));
                                p2.sendMessage(p2.getDisplayName());
                            }
                            ++index;
                        }
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)Ghoul.plugin, 0L, 10L);
    }
    
    static {
        Ghoul.MaxHealth = 1200;
        Ghoul.Level = 90;
        Ghoul.Type = "Ghoul";
        Ghoul.Name = "Ghoul";
        Ghoul.Defence = 50;
        Ghoul.Strength = 85;
        Ghoul.Damage = 100;
    }
}
