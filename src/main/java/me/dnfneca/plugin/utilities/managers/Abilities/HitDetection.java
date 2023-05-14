package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.CustomMobs.CheckCustomMob;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class HitDetection {
    public static boolean HitDetection(Location location, double Distance, int Damage) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);
        Collection<Entity> NearbyEntities = location.getWorld().getNearbyEntities(location, Distance, Distance, Distance);
        LivingEntity MobsNearby = null;
        for (Entity e : NearbyEntities) {
            if (e.getType() != EntityType.PLAYER) {
                MobsNearby = (LivingEntity) e;
                break;
            }
        }
        if (MobsNearby == null) {
            return false;
        } else {
            ArrayList<String> tags = CheckCustomMob.check(MobsNearby);
            double maxHealth = Double.parseDouble(tags.get(0));
            String[] getScores = MobsNearby.getScoreboardTags().toArray(new String[10]);

            System.out.println(Arrays.toString(getScores));

            double health;
            if (getScores[0] == null) {
                MobsNearby.addScoreboardTag(String.valueOf(Double.parseDouble(tags.get(0))));
                health = maxHealth - (Damage);

                MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
                MobsNearby.addScoreboardTag(String.valueOf(health));
            } else {
                health = Double.parseDouble(getScores[0]) - (Damage);
                MobsNearby.removeScoreboardTag(getScores[0]);
                MobsNearby.removeScoreboardTag(getScores[1]);
                MobsNearby.addScoreboardTag(String.valueOf(health));
            }
            String nameColor;
            switch (tags.get(4)) {
                case "Rare":
                    nameColor = String.valueOf(ChatColor.BLUE);
                    break;
                case "Epic":
                    nameColor = String.valueOf(ChatColor.DARK_PURPLE);
                    break;
                case "Legendary":
                    nameColor = String.valueOf(ChatColor.GOLD);
                    break;
                case "Mythic":
                    nameColor = String.valueOf(ChatColor.RED);
                    break;
                default:
                    nameColor = String.valueOf(ChatColor.GRAY);


                    MobsNearby.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
                    MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));

                    if (health <= 0) {
                        MobsNearby.setCustomName(null);
                        MobsNearby.setCustomNameVisible(false);
                        MobsNearby.setHealth(0);

                        LivingEntity finalMobsNearby = MobsNearby;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                finalMobsNearby.remove();
                            }

                        }.runTaskLater(Plugin.getInstance(), 20);
                    }
                }
//        for (Entity e : NearbyEntities) {
//            if(e.getType() != EntityType.PLAYER && e.getType() != EntityType.DROPPED_ITEM && e.getType() != EntityType.ARMOR_STAND) {
//                MobsNearby.add((LivingEntity) e);
//            }
//        }
//        if(!MobsNearby.isEmpty()) {
//            for (Entity e: MobsNearby) {
//                double health = Double.parseDouble(tags.get(0)) - (Damage);
//
//                e.removeScoreboardTag(String.valueOf(tags.get(0)));
//                e.addScoreboardTag(String.valueOf(health));
//                System.out.println(e + ", " + health);
//                return true;
//            }
//        }
//        else {
//            return false;
//        }
            return true;
        }
    }
    public static boolean HitDetectionStun(Location location, double Distance, int Damage, int StunDuration) {
        StunDuration = StunDuration * 20;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);
        Collection<Entity> NearbyEntities = location.getWorld().getNearbyEntities(location, Distance, Distance, Distance);
        LivingEntity MobsNearby = null;
        for (Entity e : NearbyEntities) {
            if (e.getType() != EntityType.PLAYER) {
                MobsNearby = (LivingEntity) e;
                break;
            }
        }
        if (MobsNearby == null) {
            return false;
        } else {
            ArrayList<String> tags = CheckCustomMob.check(MobsNearby);
            double maxHealth = Double.parseDouble(tags.get(0));
            String[] getScores = MobsNearby.getScoreboardTags().toArray(new String[10]);

            double health;
            if (getScores[0] == null) {
                MobsNearby.addScoreboardTag(String.valueOf(Double.parseDouble(tags.get(0))));
                health = maxHealth - (Damage);

                MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
                MobsNearby.addScoreboardTag(String.valueOf(health));
                MobsNearby.setAI(false);
            } else {
                health = Double.parseDouble(getScores[0]) - (Damage);
                MobsNearby.removeScoreboardTag(getScores[0]);
                MobsNearby.removeScoreboardTag(getScores[1]);
                MobsNearby.addScoreboardTag(String.valueOf(health));
                MobsNearby.setAI(false);
            }
            String nameColor;
            switch (tags.get(4)) {
                case "Rare":
                    nameColor = String.valueOf(ChatColor.BLUE);
                    break;
                case "Epic":
                    nameColor = String.valueOf(ChatColor.DARK_PURPLE);
                    break;
                case "Legendary":
                    nameColor = String.valueOf(ChatColor.GOLD);
                    break;
                case "Mythic":
                    nameColor = String.valueOf(ChatColor.RED);
                    break;
                default:
                    nameColor = String.valueOf(ChatColor.GRAY);


                    MobsNearby.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
                    MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));

                    if (health <= 0) {
                        MobsNearby.setCustomName(null);
                        MobsNearby.setCustomNameVisible(false);
                        MobsNearby.setHealth(0);

                        LivingEntity finalMobsNearby = MobsNearby;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                finalMobsNearby.remove();
                            }

                        }.runTaskLater(Plugin.getInstance(), 20);
                    }
                    LivingEntity finalMobsNearby1 = MobsNearby;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            finalMobsNearby1.setAI(true);
                        }
                    }.runTaskLater(Plugin.getInstance(), StunDuration);
            }
//        for (Entity e : NearbyEntities) {
//            if(e.getType() != EntityType.PLAYER && e.getType() != EntityType.DROPPED_ITEM && e.getType() != EntityType.ARMOR_STAND) {
//                MobsNearby.add((LivingEntity) e);
//            }
//        }
//        if(!MobsNearby.isEmpty()) {
//            for (Entity e: MobsNearby) {
//                double health = Double.parseDouble(tags.get(0)) - (Damage);
//
//                e.removeScoreboardTag(String.valueOf(tags.get(0)));
//                e.addScoreboardTag(String.valueOf(health));
//                System.out.println(e + ", " + health);
//                return true;
//            }
//        }
//        else {
//            return false;
//        }
            return true;
        }
    }
}
