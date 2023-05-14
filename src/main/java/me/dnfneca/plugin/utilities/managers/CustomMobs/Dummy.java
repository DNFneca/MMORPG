// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.CustomMobs;

import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attributable;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Zombie;
import org.bukkit.Location;
import me.dnfneca.plugin.Plugin;
import org.bukkit.event.Listener;

public class Dummy implements Listener
{
    public static int MaxHealth;
    public static int Level;
    public static String Type;
    public static String Name;
    public static int Defence;
    public static int Strength;
    public static int Damage;
    static Plugin plugin;
    
    public Dummy(final Plugin plugin) {
        Dummy.plugin = plugin;
    }
    
    public static void createDummy(final Location location) {
        final long[] AB1CD = { 0L };
        final long[] AB2CD = { 0L };
        final String[] entities = new String[0];
        final Zombie spider = (Zombie)location.getWorld().spawn(location, (Class)Zombie.class);
        spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
        spider.setCustomNameVisible(true);
        spider.setAI(false);
        final Attributable creatureAt = (Attributable)spider;
        final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(100.0);
        spider.setHealth(100.0);
        final String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
        final String level = getScores[0];
        spider.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), Dummy.Level, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.RED)));
    }
    
    static {
        Dummy.MaxHealth = 10000000;
        Dummy.Level = 0;
        Dummy.Type = "Dummy";
        Dummy.Name = "Dummy";
        Dummy.Defence = 1;
        Dummy.Strength = 0;
        Dummy.Damage = 0;
    }
}
