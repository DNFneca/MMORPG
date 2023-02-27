package me.dnfneca.plugin.listeners;


import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.classes.PlayerJoinClassAssignation;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import me.dnfneca.plugin.utilities.managers.Item.Check;
import me.dnfneca.plugin.utilities.managers.Statistics.StatCalc;
import me.dnfneca.plugin.utilities.managers.Stats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Objects;

import static me.dnfneca.plugin.utilities.GUI.GUI.ChooseClassesMenu;


public class PlayerJoin implements Listener{

    static Plugin plugin;
    public PlayerJoin(Plugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String UUID = player.getUniqueId().toString();
        ItemStack MainMenu = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta MenuMeta = MainMenu.getItemMeta();
        MenuMeta.setDisplayName(ChatColor.GRAY + "Menu");
        MenuMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        MainMenu.setItemMeta(MenuMeta);
        player.getInventory().setItem(8, MainMenu);
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("Stats", "dummy", "Stats");
        obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
//            obj.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(14);
//            Score money = obj.getScore(ChatColor.GRAY + "» Strength");
//            money.setScore(13);
        Score Health = obj.getScore("Health");
        Score Defence = obj.getScore("Defence");
        Score Strength = obj.getScore("Strength");
        Score CritChance = obj.getScore("CritChance");
        Score CritDamage = obj.getScore("CritDamage");
        Score EffectiveHealth = obj.getScore("EffectiveHealth");
        Score EffectiveDefence = obj.getScore("EffectiveDefence");
        Score EffectiveStrength = obj.getScore("EffectiveStrength");
        Score EffectiveCritChance = obj.getScore("EffectiveCritChance");
        Score EffectiveCritDamage = obj.getScore("EffectiveCritDamage");
        Score CurrentHealth = obj.getScore("CurrentHealth");
        Score Mana = obj.getScore("Mana");
        Score CurrentMana = obj.getScore("CurrentMana");
        Score EffectiveMana = obj.getScore("EffectiveMana");
        Score ManaCost = obj.getScore("ManaCost");
        Score ManaTimer = obj.getScore("ManaTimer");
        Score Damage = obj.getScore("Damage");
        Score CurrentDamage = obj.getScore("CurrentDamage");
        Score Class = obj.getScore("Class");
        Score Speed = obj.getScore("Speed");
        Score EffectiveSpeed = obj.getScore("EffectiveSpeed");
        Score Stealth = obj.getScore("Stealth");
        Score EffectiveStealth = obj.getScore("EffectiveStealth");
        Score ChoiceCD = obj.getScore("ChoiceCD");
        Score TrueShield = obj.getScore("TrueShield");

// TODO make leveling system in role playing game (tod howard) using json just like waystones

        NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");
        PersistentDataContainer playerdata = player.getPersistentDataContainer();
        int playerclass;

        if(!player.hasPlayedBefore()) {
            playerdata.set(key, PersistentDataType.INTEGER, 0);

            playerclass = 0;
        } else {
            if(playerdata.get(key, PersistentDataType.INTEGER) != null) {
                playerclass = playerdata.get(key, PersistentDataType.INTEGER);
//                playerdata.set(key, PersistentDataType.INTEGER, 0);
            } else {
                playerdata.set(key, PersistentDataType.INTEGER, 0);
                playerclass = 0;

            }
        }



        if(Stats.getStats().size() == 0) {

            Damage.setScore(25);
            CurrentDamage.setScore(25);
            Health.setScore(100);
            Defence.setScore(5);
            Strength.setScore(25);
            CritChance.setScore(0);
            CritDamage.setScore(10);
            EffectiveHealth.setScore(100);
            EffectiveDefence.setScore(0);
            EffectiveStrength.setScore(0);
            EffectiveCritChance.setScore(0);
            EffectiveCritDamage.setScore(0);
            CurrentHealth.setScore(100);
            CurrentMana.setScore(100);
            Mana.setScore(100);
            EffectiveMana.setScore(100);
            Class.setScore(playerclass);
            Speed.setScore(100);
            Stealth.setScore(0);
            ChoiceCD.setScore(0);
            TrueShield.setScore(0);

//            EffectiveStrength.setScore(Strength );

            Stats.addStats(0, String.valueOf(obj.getScore("Health").getScore()));
            Stats.addStats(1, String.valueOf(obj.getScore("Defence").getScore()));
            Stats.addStats(2, String.valueOf(obj.getScore("Strength").getScore()));
            Stats.addStats(3, String.valueOf(obj.getScore("CritChance").getScore()));
            Stats.addStats(4, String.valueOf(obj.getScore("CritDamage").getScore()));
            Stats.addStats(5, String.valueOf(obj.getScore("EffectiveHealth").getScore()));
            Stats.addStats(6, String.valueOf(obj.getScore("EffectiveDefence").getScore()));
            Stats.addStats(7, String.valueOf(obj.getScore("EffectiveStrength").getScore()));
            Stats.addStats(8, String.valueOf(obj.getScore("EffectiveCritChance").getScore()));
            Stats.addStats(9, String.valueOf(obj.getScore("EffectiveCritDamage").getScore()));
            Stats.addStats(10, String.valueOf(obj.getScore("CurrentHealth").getScore()));
            Stats.addStats(11, String.valueOf(obj.getScore("Mana").getScore()));
            Stats.addStats(12, String.valueOf(obj.getScore("CurrentMana").getScore()));
            Stats.addStats(13, String.valueOf(obj.getScore("EffectiveMana").getScore()));
            Stats.addStats(14, String.valueOf(obj.getScore("ManaCost").getScore()));
            Stats.addStats(15, String.valueOf(obj.getScore("ManaTimer").getScore()));
            Stats.addStats(16, String.valueOf(obj.getScore("Damage").getScore()));
            Stats.addStats(17, String.valueOf(obj.getScore("CurrentDamage").getScore()));
            Stats.addStats(18, String.valueOf(obj.getScore("Class").getScore()));
            Stats.addStats(19, String.valueOf(obj.getScore("Speed").getScore()));
            Stats.addStats(20, String.valueOf(obj.getScore("Stealth").getScore()));
            Stats.addStats(21, String.valueOf(obj.getScore("TrueShield").getScore()));
        } else {
            Damage.setScore(25);
            CurrentDamage.setScore(25);
            Health.setScore(100);
            Defence.setScore(5);
            Strength.setScore(25);
            CritChance.setScore(0);
            CritDamage.setScore(10);
            EffectiveHealth.setScore(100);
            EffectiveDefence.setScore(0);
            EffectiveStrength.setScore(0);
            EffectiveCritChance.setScore(0);
            EffectiveCritDamage.setScore(0);
            CurrentHealth.setScore(100);
            CurrentMana.setScore(100);
            Mana.setScore(100);
            EffectiveMana.setScore(100);
            Class.setScore(playerclass);
            Speed.setScore(0);
            ChoiceCD.setScore(0);
            TrueShield.setScore(0);

        }



//        System.out.println(Stats.getStats());

        player.setScoreboard(board);



        Bukkit.getScheduler().runTaskLater(Plugin.getInstance(), new Runnable()  {
            @Override
            public void run() {
                if (Class.getScore() == 0) {
                    ChooseClassesMenu(player);
                }
            }
        } , 20L);

        new BukkitRunnable() {
            @Override
            public void run() {
                NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");

            if(playerdata.get(key, PersistentDataType.INTEGER) != null) {
                PlayerJoinClassAssignation.Class(obj, player, playerdata);
            }


//                player.setWalkSpeed((float) (0.2));


                Objective objective = player.getScoreboard().getObjective("Stats");
                if(objective == null) {
                    return;
                }

                StatCalc.Calculate(objective, player);

                int Slots = player.getInventory().getSize();
                for (int i = 0; i < Slots; i++) {
//                    assert player.getInventory().getItem(i).getItemMeta() != null;
                    if(player.getInventory().getItem(i) != null && player.getInventory().getItem(i).getItemMeta() != null) {
                        if (Objects.requireNonNull(Objects.requireNonNull(player.getInventory().getItem(i)).getItemMeta()).hasDisplayName()) {
                            ItemMeta meta = player.getInventory().getItem(i).getItemMeta();
                            assert meta != null;
                            Check.LoreInsert(i, player);
//                            System.out.println(player.getInventory().getItem(i));
                        }
                    }
                }
            }
        }.runTaskTimer(plugin , 0L, 5L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if(((int)(CurrentHealth.getScore() + EffectiveHealth.getScore()*0.01) + Integer.parseInt(ItemStats.Armor(player, 1)[2]) + Integer.parseInt(ItemStats.Armor(player, 2)[2]) + Integer.parseInt(ItemStats.Armor(player, 3)[2]) + Integer.parseInt(ItemStats.Armor(player, 4)[2])) < EffectiveHealth.getScore()) {
                    CurrentHealth.setScore((int) (CurrentHealth.getScore() + EffectiveHealth.getScore() * 0.01) + Integer.parseInt(ItemStats.Armor(player, 1)[2]) + Integer.parseInt(ItemStats.Armor(player, 2)[2]) + Integer.parseInt(ItemStats.Armor(player, 3)[2]) + Integer.parseInt(ItemStats.Armor(player, 4)[2]));
                } else {
                    CurrentHealth.setScore(EffectiveHealth.getScore());
                }

                if(((int)(CurrentMana.getScore() + EffectiveMana.getScore()*0.01)) < EffectiveMana.getScore()) {
//                    player.sendMessage(String.valueOf((int)(CurrentMana.getScore() + EffectiveMana.getScore()*0.01)));
                    CurrentMana.setScore((int) (CurrentMana.getScore() + EffectiveMana.getScore() * 0.01));
                } else {
//                    player.sendMessage(String.valueOf((int)(CurrentMana.getScore() + EffectiveMana.getScore()*0.01)));
                    CurrentMana.setScore(EffectiveMana.getScore());
                }

                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
            }
        }.runTaskTimer(plugin , 0L, 20L);
    }
}
