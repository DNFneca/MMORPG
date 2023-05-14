// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.CustomMobs;

import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attributable;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Wolf;
import org.bukkit.Location;
import me.dnfneca.plugin.Plugin;
import org.bukkit.event.Listener;

public class BasicWolf implements Listener
{
    public static int MaxHealth;
    public static int Level;
    public static String Type;
    public static String Name;
    public static int Defence;
    public static int Strength;
    public static int Damage;
    static Plugin plugin;
    
    public BasicWolf(final Plugin plugin) {
        BasicWolf.plugin = plugin;
    }
    
    public static void createWolf(final Location location) {
        final long[] AB1CD = { 0L };
        final long[] AB2CD = { 0L };
        final String[] entities = new String[0];
        final Wolf spider = (Wolf)location.getWorld().spawn(location, (Class)Wolf.class);
        spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
        spider.setCustomNameVisible(true);
        final Attributable creatureAt = (Attributable)spider;
        final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(100.0);
        spider.setHealth(100.0);
        final String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
        final String level = getScores[0];
        spider.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), BasicWolf.Level, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.RED)));
        new BukkitRunnable() {
            public void run() {
                final int range = 10;
                if (!spider.isDead()) {
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
                    if (spider.getTarget() == null) {
                        final List<Entity> entityaround = (List<Entity>)spider.getNearbyEntities((double)range, (double)range, (double)range);
                        for (final Entity p : entityaround) {
                            if (p instanceof Player) {
                                final int stealth = ((Player)p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
                                if (spider.getLocation().distance(p.getLocation()) >= range - range * stealth * 0.01) {
                                    continue;
                                }
                                spider.setTarget((LivingEntity)p);
                            }
                        }
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)BasicWolf.plugin, 0L, 10L);
    }
    
    static {
        BasicWolf.MaxHealth = 200;
        BasicWolf.Level = 25;
        BasicWolf.Type = "Wolf";
        BasicWolf.Name = "Wolf";
        BasicWolf.Defence = 15;
        BasicWolf.Strength = 55;
        BasicWolf.Damage = 40;
    }
}
