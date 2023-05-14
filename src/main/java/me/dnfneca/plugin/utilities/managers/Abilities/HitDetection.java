// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import me.dnfneca.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.ChatColor;
import java.util.Arrays;
import me.dnfneca.plugin.utilities.managers.CustomMobs.CheckCustomMob;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import java.text.DecimalFormat;
import org.bukkit.Location;

public class HitDetection
{
    public static boolean HitDetection(final Location location, final double Distance, final int Damage) {
        final DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);
        final Collection<Entity> NearbyEntities = (Collection<Entity>)location.getWorld().getNearbyEntities(location, Distance, Distance, Distance);
        LivingEntity MobsNearby = null;
        for (final Entity e : NearbyEntities) {
            if (e.getType() != EntityType.PLAYER) {
                MobsNearby = (LivingEntity)e;
                break;
            }
        }
        if (MobsNearby == null) {
            return false;
        }
        final ArrayList<String> tags = CheckCustomMob.check(MobsNearby);
        final double maxHealth = Double.parseDouble(tags.get(0));
        final String[] getScores = MobsNearby.getScoreboardTags().toArray(new String[10]);
        System.out.println(Arrays.toString(getScores));
        double health;
        if (getScores[0] == null) {
            MobsNearby.addScoreboardTag(String.valueOf(Double.parseDouble(tags.get(0))));
            health = maxHealth - Damage;
            MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
            MobsNearby.addScoreboardTag(String.valueOf(health));
        }
        else {
            health = Double.parseDouble(getScores[0]) - Damage;
            MobsNearby.removeScoreboardTag(getScores[0]);
            MobsNearby.removeScoreboardTag(getScores[1]);
            MobsNearby.addScoreboardTag(String.valueOf(health));
        }
        final String s = tags.get(4);
        switch (s) {
            case "Rare": {
                final String nameColor = String.valueOf(ChatColor.BLUE);
                break;
            }
            case "Epic": {
                final String nameColor = String.valueOf(ChatColor.DARK_PURPLE);
                break;
            }
            case "Legendary": {
                final String nameColor = String.valueOf(ChatColor.GOLD);
                break;
            }
            case "Mythic": {
                final String nameColor = String.valueOf(ChatColor.RED);
                break;
            }
            default: {
                final String nameColor = String.valueOf(ChatColor.GRAY);
                MobsNearby.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), (String)tags.get(5), String.valueOf(ChatColor.DARK_GRAY), nameColor, (String)tags.get(7), String.valueOf(ChatColor.RED), df.format(health), String.valueOf(ChatColor.DARK_PURPLE), String.valueOf(ChatColor.RED), df.format(Double.parseDouble(tags.get(0)))));
                MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
                if (health <= 0.0) {
                    MobsNearby.setCustomName((String)null);
                    MobsNearby.setCustomNameVisible(false);
                    MobsNearby.setHealth(0.0);
                    final LivingEntity finalMobsNearby = MobsNearby;
                    new BukkitRunnable() {
                        public void run() {
                            finalMobsNearby.remove();
                        }
                    }.runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), 20L);
                    break;
                }
                break;
            }
        }
        return true;
    }
    
    public static boolean HitDetectionStun(final Location location, final double Distance, final int Damage, int StunDuration) {
        StunDuration *= 20;
        final DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);
        final Collection<Entity> NearbyEntities = (Collection<Entity>)location.getWorld().getNearbyEntities(location, Distance, Distance, Distance);
        LivingEntity MobsNearby = null;
        for (final Entity e : NearbyEntities) {
            if (e.getType() != EntityType.PLAYER) {
                MobsNearby = (LivingEntity)e;
                break;
            }
        }
        if (MobsNearby == null) {
            return false;
        }
        final ArrayList<String> tags = CheckCustomMob.check(MobsNearby);
        final double maxHealth = Double.parseDouble(tags.get(0));
        final String[] getScores = MobsNearby.getScoreboardTags().toArray(new String[10]);
        double health;
        if (getScores[0] == null) {
            MobsNearby.addScoreboardTag(String.valueOf(Double.parseDouble(tags.get(0))));
            health = maxHealth - Damage;
            MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
            MobsNearby.addScoreboardTag(String.valueOf(health));
            MobsNearby.setAI(false);
        }
        else {
            health = Double.parseDouble(getScores[0]) - Damage;
            MobsNearby.removeScoreboardTag(getScores[0]);
            MobsNearby.removeScoreboardTag(getScores[1]);
            MobsNearby.addScoreboardTag(String.valueOf(health));
            MobsNearby.setAI(false);
        }
        final String s = tags.get(4);
        switch (s) {
            case "Rare": {
                final String nameColor = String.valueOf(ChatColor.BLUE);
                break;
            }
            case "Epic": {
                final String nameColor = String.valueOf(ChatColor.DARK_PURPLE);
                break;
            }
            case "Legendary": {
                final String nameColor = String.valueOf(ChatColor.GOLD);
                break;
            }
            case "Mythic": {
                final String nameColor = String.valueOf(ChatColor.RED);
                break;
            }
            default: {
                final String nameColor = String.valueOf(ChatColor.GRAY);
                MobsNearby.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), (String)tags.get(5), String.valueOf(ChatColor.DARK_GRAY), nameColor, (String)tags.get(7), String.valueOf(ChatColor.RED), df.format(health), String.valueOf(ChatColor.DARK_PURPLE), String.valueOf(ChatColor.RED), df.format(Double.parseDouble(tags.get(0)))));
                MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
                if (health <= 0.0) {
                    MobsNearby.setCustomName((String)null);
                    MobsNearby.setCustomNameVisible(false);
                    MobsNearby.setHealth(0.0);
                    final LivingEntity finalMobsNearby = MobsNearby;
                    new BukkitRunnable() {
                        public void run() {
                            finalMobsNearby.remove();
                        }
                    }.runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), 20L);
                }
                final LivingEntity finalMobsNearby2 = MobsNearby;
                new BukkitRunnable() {
                    public void run() {
                        finalMobsNearby2.setAI(true);
                    }
                }.runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), (long)StunDuration);
                break;
            }
        }
        return true;
    }
}
