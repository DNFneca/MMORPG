package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.managers.Stats;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static me.dnfneca.plugin.utilities.managers.CustomMobs.MyCreature.*;
import static org.bukkit.entity.EntityType.ARMOR_STAND;
import static org.bukkit.entity.EntityType.PLAYER;

public class MobHealthListener implements Listener {



    @EventHandler
    public void onRightClick(EntityDamageEvent e) {
        if(e.getEntityType() != PLAYER && e.getEntityType() != ARMOR_STAND) {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(0);
            Location loc = e.getEntity().getLocation();
            LivingEntity entityHit = (LivingEntity) e.getEntity();
            double maxHealth = entityHit.getMaxHealth();
            String nameColor;
            String[] getScores = entityHit.getScoreboardTags().toArray(new String[10]);
//        String tagList[] = new String[getScores.length];
//        String[] hpStat = entityHit.getScoreboardTags().toArray(tagList);
            ArrayList<String> tags = new ArrayList<>();
            switch (e.getEntityType()) {
                case SPIDER:
                    if(entityHit.getCustomName().contains("Creature")) {
                        entityHit.removeScoreboardTag(String.valueOf(entityHit.getMaxHealth()));
                        maxHealth = MaxHealth;
                        tags.add(0, String.valueOf(MaxHealth));
                        tags.add(1, String.valueOf(Damage));
                        tags.add(2, String.valueOf(Strength));
                        tags.add(3, String.valueOf(Defence));
                        tags.add(4, Stats.getRandomRarity(entityHit.getUniqueId()));
                        tags.add(5, String.valueOf(Level));
                        tags.add(6, Type);
                        tags.add(7, Name);

//                    System.out.println(tags);
//                    entityHit.removeScoreboardTag(String.valueOf(entityHit.getScoreboardTags().equals("Spider")));
                    }
                    break;
            }

            // Color Codes
            switch (tags.get(4)){
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
                    break;
            }









            if(e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                double health;


                if (getScores[0] == null) {
                    int def = 1;
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    if(tags.size() == 0) {
                        health = maxHealth - e.getDamage()/def;
                    } else {
                        health = maxHealth - (e.getDamage()/Double.parseDouble(tags.get(3)));
                    }

                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else if (Double.parseDouble(getScores[0]) == Double.parseDouble(String.valueOf(maxHealth))) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    health =  maxHealth - (e.getDamage() / Double.parseDouble(tags.get(1)) );
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.removeScoreboardTag(getScores[0]);
                } else {
                    health = Double.parseDouble(getScores[0]) - (e.getDamage() / Double.parseDouble(tags.get(1)));
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));


                }
                double hp = Double.parseDouble(String.valueOf(health));
                entityHit.setCustomNameVisible(true);
                entityHit.setCustomName(null);
                if (tags.size() != 0) {

                    entityHit.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(hp) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
                } else {
                    entityHit.setCustomName(ChatColor.DARK_GRAY + "" + entityHit.getType() + " " + ChatColor.RED + df.format(hp) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(maxHealth) + "❤");
                }
                entityHit.removeScoreboardTag(String.valueOf(maxHealth));

                if(hp <= 0) {
                    entityHit.setCustomNameVisible(false);
                    entityHit.setHealth(0);
                }
            }
        }
    }
}
