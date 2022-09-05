package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.CustomMobs.CheckCustomMob;
import me.dnfneca.plugin.utilities.managers.Stats;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Objective;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.bukkit.entity.EntityType.PLAYER;

public class PlayerHealthListener implements Listener {
    ArrayList<String> tags = new ArrayList<>();

    @EventHandler
    public void onBowDamage(ProjectileHitEvent e) {
        System.out.println(e.getHitEntity().getType());
        if (e.getEntity().getShooter().getClass() == CraftPlayer.class) {


            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(0);
            Location loc = e.getEntity().getLocation();
            LivingEntity entityHit = (LivingEntity) e.getHitEntity();
            double maxHealth = entityHit.getMaxHealth();
            String nameColor;
            String[] getScores = entityHit.getScoreboardTags().toArray(new String[10]);
            Player player = (Player) e.getEntity().getShooter();
            tags = CheckCustomMob.check(entityHit);
            int EffectiveCritDamage = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore();
            int EffectiveCritChance = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritChance").getScore();
            int Strength = player.getScoreboard().getObjective("Stats").getScore("Strength").getScore();
            int damage = player.getScoreboard().getObjective("Stats").getScore("CurrentDamage").getScore();
            double health;
            boolean Roll = Stats.getCritRoll(Double.parseDouble(String.valueOf(EffectiveCritChance)));
            if (Roll) {
                if (getScores[0] == null) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
//                    health = maxHealth - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (Double.parseDouble(String.valueOf(tags.get(3)))/Strength);
                    double def = Double.parseDouble(tags.get(3));
                    health = maxHealth - (damage  / (def/Strength));
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else {
                    health = Double.parseDouble(getScores[0]) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (Double.parseDouble(String.valueOf(tags.get(3)))/Strength);
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }

                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);
                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);
                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);
                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getHitEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);



            } else {
                double def = Double.parseDouble(tags.get(3));
                if (getScores[0] == null) {

                    entityHit.addScoreboardTag(String.valueOf(maxHealth));

                    health = Integer.parseInt(tags.get(0)) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (def/Strength);

                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else {
                    health = Double.parseDouble(getScores[0]) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (def/Strength);
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }
            }
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
                    break;
            }


            entityHit.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
            entityHit.removeScoreboardTag(String.valueOf(maxHealth));

            if (health <= 0) {
                entityHit.setCustomName("");
                entityHit.setCustomNameVisible(false);
                entityHit.setHealth(0);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {

        if(e.getEntityType() == PLAYER && e.getDamager().getType() == PLAYER) {
            return;
        }
        if(e.getEntityType() == PLAYER) {
            Player player = (Player) e.getEntity();

            Objective obj = player.getScoreboard().getObjective("Stats");

            LivingEntity entityHit = (LivingEntity) e.getDamager();

            tags = CheckCustomMob.check(entityHit);

            int damage = Integer.parseInt(tags.get(1)) * Integer.parseInt(tags.get(5));

            obj.getScore("CurrentHealth").setScore(obj.getScore("CurrentHealth").getScore() - damage/obj.getScore("EffectiveDefence").getScore());

            if(obj.getScore("CurrentHealth").getScore() <= 0) {
                player.setHealth(0);

                obj.getScore("CurrentHealth").setScore(obj.getScore("EffectiveHealth").getScore());
            }

            return;
        }
        if (e.getDamager().getType() == PLAYER) {


            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(0);
            Location loc = e.getEntity().getLocation();
            LivingEntity entityHit = (LivingEntity) e.getEntity();
            String nameColor;
            String[] getScores = entityHit.getScoreboardTags().toArray(new String[10]);
            Player player = (Player) e.getDamager();
            tags = CheckCustomMob.check(entityHit);
            double maxHealth = Double.parseDouble(tags.get(0));
            int EffectiveCritDamage = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore();
            int EffectiveCritChance = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritChance").getScore();
            int Strength = player.getScoreboard().getObjective("Stats").getScore("Strength").getScore();
            int damage = player.getScoreboard().getObjective("Stats").getScore("CurrentDamage").getScore();
            double health;
            boolean Roll = Stats.getCritRoll(Double.parseDouble(String.valueOf(EffectiveCritChance)));
//            System.out.println(Roll);
//            System.out.println(tags.get(3) + "  " + damage + "  " );
//            System.out.println(player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore());
            if(player.getInventory().getItemInMainHand().getType() == Material.BOW) {
                double def = Double.parseDouble(tags.get(3));
                if (getScores[0] == null) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    health = maxHealth - (damage  / ((def*10)/Strength));

                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else {
                    health = Double.parseDouble(getScores[0]) - (damage / ((def*10)/Strength));
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }
                return;
            }

            double def = Double.parseDouble(tags.get(3));
            if(Roll) {
                if (getScores[0] == null) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));

                    health = Integer.parseInt(tags.get(0)) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (def/Strength);

                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else {
                    health = Double.parseDouble(getScores[0]) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (def/Strength);
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }

                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2 , 1, Math.random() * 2, 0.1);
                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2 , 1, Math.random() * 2, 0.1);
                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2 , 1, Math.random() * 2, 0.1);
                e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2 , 1, Math.random() * 2, 0.1);

            } else {
                if (getScores[0] == null) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                     health = maxHealth - (damage*Strength / def);

                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else {
                    health = Double.parseDouble(getScores[0]) - (damage / (def/Strength));
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }
            }
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
                    break;
            }


            entityHit.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
            entityHit.removeScoreboardTag(String.valueOf(maxHealth));

            if (health <= 0) {
                entityHit.setCustomName(null);
                entityHit.setCustomNameVisible(false);
                entityHit.setHealth(0);

                Bukkit.getScheduler ().runTaskLater (Plugin.getInstance() , () -> entityHit.remove() , 20);

            }
        }

        if (!(e.getDamager() instanceof Player)) {
            if (e.getDamager().getCustomName() != null) {
                switch (e.getDamager().getType()) {
                    case SPIDER:
                        if (e.getDamager().getCustomName().contains("Spider")) {
                            LivingEntity potEnity = (LivingEntity) e.getEntity();
                            potEnity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
                        }
                        break;


                }
            }
        }
    }
}
