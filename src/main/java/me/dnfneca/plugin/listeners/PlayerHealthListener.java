package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.inventory.ItemStats;
import me.dnfneca.plugin.utilities.managers.Item.Check;
import me.dnfneca.plugin.utilities.managers.Stats;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Objective;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static me.dnfneca.plugin.utilities.managers.CustomMobs.MyCreature.*;
import static org.bukkit.entity.EntityType.PLAYER;

public class PlayerHealthListener implements Listener {
    ArrayList<String> tags = new ArrayList<>();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == PLAYER) {


            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(0);
            Location loc = e.getEntity().getLocation();
            LivingEntity entityHit = (LivingEntity) e.getEntity();
            double maxHealth = entityHit.getMaxHealth();
            String nameColor;
            String[] getScores = entityHit.getScoreboardTags().toArray(new String[10]);
            Player player = (Player) e.getDamager();

            switch (e.getEntityType()) {
                case SPIDER:
                    if (entityHit.getCustomName().contains("Creature")) {
                        entityHit.removeScoreboardTag(String.valueOf(entityHit.getMaxHealth()));
                        maxHealth = MaxHealth;
                        tags.add(0, String.valueOf(MaxHealth));
                        tags.add(1, String.valueOf(Damage));
                        tags.add(2, String.valueOf(Strength));
                        tags.add(3, String.valueOf(Stats.getDefence(e, player, tags, Defence, false)));
                        tags.add(4, Stats.getRandomRarity(entityHit.getUniqueId()));
                        tags.add(5, String.valueOf(Level));
                        tags.add(6, Type);
                        tags.add(7, Name);

//                    entityHit.removeScoreboardTag(String.valueOf(entityHit.getScoreboardTags().equals("Spider")));
                    }
                    break;
            }
            int EffectiveCritDamage = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore();
            int EffectiveCritChance = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritChance").getScore();
            int damage = Integer.parseInt(ItemStats.Weapon(player)[0]);
            double health;
            boolean Roll = Stats.getCritRoll(Double.parseDouble(String.valueOf(EffectiveCritChance)));
//            System.out.println(Roll);
            System.out.println(tags.get(3) + "  " + damage + "  " );
//            System.out.println(player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore());
            if(Roll) {
                if (getScores[0] == null) {
                    double def = Double.parseDouble(tags.get(3));
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    if (tags.size() == 0) {
                        health = maxHealth - damage + damage * ((double) EffectiveCritDamage) * 0.01 / def;
                    } else {
                        health = maxHealth - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / Double.parseDouble(String.valueOf(tags.get(3)));
                    }

                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else if (Double.parseDouble(getScores[0]) == Double.parseDouble(String.valueOf(maxHealth))) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    health = maxHealth - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / Double.parseDouble(String.valueOf(tags.get(3)));
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.removeScoreboardTag(getScores[0]);
                } else {
                    health = Double.parseDouble(getScores[0]) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / Double.parseDouble(String.valueOf(tags.get(3)));
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }
            } else {
                if (getScores[0] == null) {
                    double def = Double.parseDouble(tags.get(3));
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    if (tags.size() == 0) {
                        health = maxHealth - damage / def;
                    } else {
                        health = maxHealth - (damage  / Double.parseDouble(String.valueOf(tags.get(3))));
                    }

                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                } else if (Double.parseDouble(getScores[0]) == Double.parseDouble(String.valueOf(maxHealth))) {
                    entityHit.addScoreboardTag(String.valueOf(maxHealth));
                    health = maxHealth - (damage / Double.parseDouble(String.valueOf(tags.get(3))));
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.addScoreboardTag(String.valueOf(health));
                    entityHit.removeScoreboardTag(String.valueOf(maxHealth));
                    entityHit.removeScoreboardTag(getScores[0]);
                } else {
                    health = Double.parseDouble(getScores[0]) - (damage / Double.parseDouble(String.valueOf(tags.get(3))));
                    entityHit.removeScoreboardTag(getScores[0]);
                    entityHit.removeScoreboardTag(getScores[1]);
                    entityHit.addScoreboardTag(String.valueOf(health));
                }
            }
//            System.out.println(tags.get(3));



            if(player.getItemInHand() != null) {
//                System.out.println(player.getItemInHand());

                String[] data = Check.ExistingStats(player.getItemInHand().getItemMeta());

//                System.out.println(Arrays.toString(data));

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

            if (tags.size() != 0) {

                entityHit.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
            } else {
                entityHit.setCustomName(ChatColor.DARK_GRAY + "" + entityHit.getType() + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(maxHealth) + "❤");
            }
            entityHit.removeScoreboardTag(String.valueOf(maxHealth));

            if (health <= 0) {
//                entityHit.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                entityHit.setCustomName("");
                entityHit.setCustomNameVisible(false);
                entityHit.setHealth(0);
//                entityHit.damage(20, player);
//                entityHit.remove();
            }
////            ScoreboardManager manager = Bukkit.getScoreboardManager();
////            assert manager != null;
////            Scoreboard board = manager.getNewScoreboard();
////            Objective obj = board.registerNewObjective("ServerName", "dummy", "TestServer");
////
//////            obj.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(14);
//////            Score money = obj.getScore(ChatColor.GRAY + "» Strength");
//////            money.setScore(13);
////            int strengthStat = 20;
////            int defenceStat = 5;
////            Score Defence = obj.getScore("Defence");
////            Defence.setScore(13);
////            Defence.getScore();
////
////            obj.getScore(String.valueOf(defenceStat)).setScore(11);
////            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
////            obj.setDisplayName("Stats");
////
////            player.setScoreboard(board);
//                List<String> stats = new ArrayList<String>();
//                int top = Integer.MIN_VALUE;
//                int score;
//                for(String name : Objects.requireNonNull(obj.getScoreboard()).getEntries()) {
//                    score = obj.getScore(name).getScore();
//                    if(score > top) {
//                        stats.clear();
//                        stats.add(name);
//                    } else if(score == top) {
//                        stats.add(name);
//                    }
//                }

//            e.getEntity().getLocation()
        }

        if(e.getEntity().getType() == PLAYER) {
            Player p = (Player) e.getEntity();
            Objective obj = p.getScoreboard().getObjective("Stats");
            LivingEntity entityHit = (LivingEntity) e.getDamager();
            double CurrentHealth = Double.parseDouble(Stats.getStats().get(10));
//            System.out.println(CurrentHealth);
            double maxHealth = entityHit.getMaxHealth();
            switch (entityHit.getType()) {
                case SPIDER:
                    if (entityHit.getCustomName().contains("Creature")) {
                        entityHit.removeScoreboardTag(String.valueOf(entityHit.getMaxHealth()));
                        maxHealth = MaxHealth;
                        tags.add(0, String.valueOf(MaxHealth));
                        tags.add(1, String.valueOf(Damage));
                        tags.add(2, String.valueOf(Strength));
                        tags.add(3, String.valueOf(Stats.getDefence(e, p, tags, Defence, false)));
                        tags.add(4, Stats.getRandomRarity(entityHit.getUniqueId()));
                        tags.add(5, String.valueOf(Level));
                        tags.add(6, Type);
                        tags.add(7, Name);

//                    entityHit.removeScoreboardTag(String.valueOf(entityHit.getScoreboardTags().equals("Spider")));
                    }
                    break;
            }


//            Set<String> tags = e.getDamager().getScoreboardTags();
//            System.out.println(Double.parseDouble(tags.get(1)));
//            System.out.println(CurrentHealth * Double.parseDouble(Stats.getStats().get(1)));
//            Objective obj = p.getScoreboard().getObjective("Stats");
            if(CurrentHealth == obj.getScore("EffectiveHealth").getScore()) {
                CurrentHealth = obj.getScore("EffectiveHealth").getScore() - ((Double.parseDouble(tags.get(1))) * Double.parseDouble(tags.get(2))) / Double.parseDouble(String.valueOf(obj.getScore("EffectiveDefence").getScore()));
            } else {
                CurrentHealth = CurrentHealth - ((Double.parseDouble(tags.get(1))) * Double.parseDouble(tags.get(2))) / Double.parseDouble(String.valueOf(obj.getScore("EffectiveDefence").getScore()));
            }
//            System.out.println(CurrentHealth);
            System.out.println(CurrentHealth);

            Stats.setStats(10, String.valueOf((int) CurrentHealth), obj);
            //            Stats.setStats(10, String.valueOf(CurrentHealth));
            if(CurrentHealth <= 0) {
                p.setHealth(0);
                Stats.setStats(10, String.valueOf(obj.getScore("EffectiveHealth").getScore()), p.getScoreboard().getObjective("Stats"));
            }
        }

        if (!(e.getDamager() instanceof Player)) {
//            Stats.addStats(10, (Integer.parseInt(Stats.getStats().get(0)) -= Integer.parseInt(ItemStats.Weapon()[1])));
            if (e.getDamager().getCustomName() != null) {
                switch (e.getDamager().getType()) {
                    case SPIDER:
                        if (e.getDamager().getCustomName().contains("Creature")) {
                            LivingEntity potEnity = (LivingEntity) e.getEntity();
                            potEnity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
                        }
                        break;


                }
            }
        }
    }
}
