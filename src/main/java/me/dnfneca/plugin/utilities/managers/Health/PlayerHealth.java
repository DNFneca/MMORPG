// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Health;

import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import me.dnfneca.plugin.utilities.managers.CustomMobs.HitEffects.HitEffects;
import me.dnfneca.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import me.dnfneca.plugin.utilities.managers.Stats;
import me.dnfneca.plugin.utilities.managers.CustomMobs.CheckCustomMob;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import java.text.DecimalFormat;
import org.bukkit.event.entity.ProjectileHitEvent;
import java.util.ArrayList;

public class PlayerHealth
{
    static ArrayList<String> tags;
    
    public static void ProjectileHitHealth(final ProjectileHitEvent e) {
        final DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);
        final Location loc = e.getEntity().getLocation();
        final LivingEntity entityHit = (LivingEntity)e.getHitEntity();
        final double maxHealth = entityHit.getMaxHealth();
        final String[] getScores = entityHit.getScoreboardTags().toArray(new String[10]);
        final Player player = (Player)e.getEntity().getShooter();
        PlayerHealth.tags = CheckCustomMob.check(entityHit);
        final int EffectiveCritDamage = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore();
        final int EffectiveCritChance = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritChance").getScore();
        final int Strength = player.getScoreboard().getObjective("Stats").getScore("Strength").getScore();
        final int damage = player.getScoreboard().getObjective("Stats").getScore("CurrentDamage").getScore();
        final boolean Roll = Stats.getCritRoll(Double.parseDouble(String.valueOf(EffectiveCritChance)));
        double health;
        if (Roll) {
            if (getScores[0] == null) {
                entityHit.addScoreboardTag(String.valueOf(maxHealth));
                final double def = Double.parseDouble(PlayerHealth.tags.get(3));
                health = maxHealth - damage / (def / Strength);
                entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                entityHit.addScoreboardTag(String.valueOf(health));
            }
            else {
                health = Double.parseDouble(getScores[0]) - (damage + damage * (double)EffectiveCritDamage * 0.01) / (Double.parseDouble(String.valueOf(PlayerHealth.tags.get(3))) / Strength);
                entityHit.removeScoreboardTag(getScores[0]);
                entityHit.removeScoreboardTag(getScores[1]);
                entityHit.addScoreboardTag(String.valueOf(health));
            }
            e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
            e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
            e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
            e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
        }
        else {
            final double def = Double.parseDouble(PlayerHealth.tags.get(3));
            if (getScores[0] == null) {
                entityHit.addScoreboardTag(String.valueOf(maxHealth));
                health = Integer.parseInt(PlayerHealth.tags.get(0)) - (damage + damage * (double)EffectiveCritDamage * 0.01) / (def / Strength);
                entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                entityHit.addScoreboardTag(String.valueOf(health));
            }
            else {
                health = Double.parseDouble(getScores[0]) - (damage + damage * (double)EffectiveCritDamage * 0.01) / (def / Strength);
                entityHit.removeScoreboardTag(getScores[0]);
                entityHit.removeScoreboardTag(getScores[1]);
                entityHit.addScoreboardTag(String.valueOf(health));
            }
        }
        final String s = PlayerHealth.tags.get(4);
        String nameColor = null;
        switch (s) {
            case "Rare": {
                nameColor = String.valueOf(ChatColor.BLUE);
                break;
            }
            case "Epic": {
                nameColor = String.valueOf(ChatColor.DARK_PURPLE);
                break;
            }
            case "Legendary": {
                nameColor = String.valueOf(ChatColor.GOLD);
                break;
            }
            case "Mythic": {
                nameColor = String.valueOf(ChatColor.RED);
                break;
            }
            default: {
                nameColor = String.valueOf(ChatColor.GRAY);
                break;
            }
        }
        entityHit.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), (String)PlayerHealth.tags.get(5), String.valueOf(ChatColor.DARK_GRAY), nameColor, (String)PlayerHealth.tags.get(7), String.valueOf(ChatColor.RED), df.format(health), String.valueOf(ChatColor.DARK_PURPLE), String.valueOf(ChatColor.RED), df.format(Double.parseDouble(PlayerHealth.tags.get(0)))));
        entityHit.removeScoreboardTag(String.valueOf(maxHealth));
        if (health <= 0.0) {
            entityHit.setCustomName("");
            entityHit.setCustomNameVisible(false);
            entityHit.setHealth(0.0);
        }
    }
    
    public static void PlayerHealth(final EntityDamageByEntityEvent e) {
        if (e.getEntityType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.PLAYER) {
            return;
        }
        if (e.getEntityType() != EntityType.PLAYER) {
            if (e.getDamager().getType() == EntityType.PLAYER) {
                final DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(0);
                final Location loc = e.getEntity().getLocation();
                final LivingEntity entityHit = (LivingEntity)e.getEntity();
                final String[] getScores = entityHit.getScoreboardTags().toArray(new String[10]);
                final Player player = (Player)e.getDamager();
                PlayerHealth.tags = CheckCustomMob.check(entityHit);
                final double maxHealth = Double.parseDouble(PlayerHealth.tags.get(0));
                final int EffectiveCritDamage = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore();
                final int EffectiveCritChance = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritChance").getScore();
                final int Strength = player.getScoreboard().getObjective("Stats").getScore("EffectiveStrength").getScore();
                final int damage = player.getScoreboard().getObjective("Stats").getScore("CurrentDamage").getScore();
                final boolean Roll = Stats.getCritRoll(Double.parseDouble(String.valueOf(EffectiveCritChance)));
                if (player.getInventory().getItemInMainHand().getType() == Material.BOW) {
                    final double def = Double.parseDouble(PlayerHealth.tags.get(3));
                    if (getScores[0] == null) {
                        entityHit.addScoreboardTag(String.valueOf(maxHealth));
                        final double health = maxHealth - damage / (def * 10.0 / Strength);
                        entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                        entityHit.addScoreboardTag(String.valueOf(health));
                    }
                    else {
                        final double health = Double.parseDouble(getScores[0]) - damage / (def * 10.0 / Strength);
                        entityHit.removeScoreboardTag(getScores[0]);
                        entityHit.removeScoreboardTag(getScores[1]);
                        entityHit.addScoreboardTag(String.valueOf(health));
                    }
                    return;
                }
                final double def = Double.parseDouble(PlayerHealth.tags.get(3));
                double health;
                if (Roll) {
                    if (getScores[0] == null) {
                        entityHit.addScoreboardTag(String.valueOf(maxHealth));
                        health = Integer.parseInt(PlayerHealth.tags.get(0)) - (damage + damage * (double)EffectiveCritDamage * 0.01) / (def / Strength);
                        entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                        entityHit.addScoreboardTag(String.valueOf(health));
                    }
                    else {
                        health = Double.parseDouble(getScores[0]) - (damage + damage * (double)EffectiveCritDamage * 0.01) / (def / Strength);
                        entityHit.removeScoreboardTag(getScores[0]);
                        entityHit.removeScoreboardTag(getScores[1]);
                        entityHit.addScoreboardTag(String.valueOf(health));
                    }
                    e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
                    e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
                    e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
                    e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity)e.getEntity()).getEyeLocation(), 5, Math.random() * 2.0, 1.0, Math.random() * 2.0, 0.1);
                }
                else if (getScores[0] == null) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    health = maxHealth - damage * Strength / def;
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                }
                else {
                    health = Double.parseDouble(getScores[0]) - damage / (def / Strength);
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }
                final String s = PlayerHealth.tags.get(4);
                String nameColor = null;
                switch (s) {
                    case "Rare": {
                        nameColor = String.valueOf(ChatColor.BLUE);
                        break;
                    }
                    case "Epic": {
                        nameColor = String.valueOf(ChatColor.DARK_PURPLE);
                        break;
                    }
                    case "Legendary": {
                        nameColor = String.valueOf(ChatColor.GOLD);
                        break;
                    }
                    case "Mythic": {
                        nameColor = String.valueOf(ChatColor.RED);
                        break;
                    }
                    default: {
                        nameColor = String.valueOf(ChatColor.GRAY);
                        break;
                    }
                }
                entityHit.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), (String)PlayerHealth.tags.get(5), String.valueOf(ChatColor.DARK_GRAY), nameColor, (String)PlayerHealth.tags.get(7), String.valueOf(ChatColor.RED), df.format(health), String.valueOf(ChatColor.DARK_PURPLE), String.valueOf(ChatColor.RED), df.format(Double.parseDouble(PlayerHealth.tags.get(0)))));
                entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                if (health <= 0.0) {
                    entityHit.setCustomName((String)null);
                    entityHit.setCustomNameVisible(false);
                    entityHit.setHealth(0.0);
                    Bukkit.getScheduler().runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), () -> entityHit.remove(), 20L);
                }
            }
            return;
        }
        final Player player = (Player)e.getEntity();
        final Score score = player.getScoreboard().getObjective("Stats").getScore("TrueShield");
        if (score.getScore() > 0) {
            score.setScore(score.getScore() - 1);
            return;
        }
        final Objective obj = player.getScoreboard().getObjective("Stats");
        final LivingEntity entityHit = (LivingEntity)e.getDamager();
        PlayerHealth.tags = CheckCustomMob.check(entityHit);
        final int damage2 = Integer.parseInt(PlayerHealth.tags.get(1)) * Integer.parseInt(PlayerHealth.tags.get(5));
        obj.getScore("CurrentHealth").setScore(obj.getScore("CurrentHealth").getScore() - damage2 / obj.getScore("EffectiveDefence").getScore());
        if (obj.getScore("CurrentHealth").getScore() <= 0) {
            player.setHealth(0.0);
            obj.getScore("CurrentHealth").setScore(obj.getScore("EffectiveHealth").getScore());
        }
        if (e.getDamager().getCustomName() != null) {
            HitEffects.mob(e);
        }
    }
    
    static {
        PlayerHealth.tags = new ArrayList<String>();
    }
}
