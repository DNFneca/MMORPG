package me.dnfneca.plugin.listeners;


import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import me.dnfneca.plugin.utilities.managers.Item.Check;
import me.dnfneca.plugin.utilities.managers.Stats;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Objects;


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


        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("Stats", "dummy", "Stats");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
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
        Score CurrentMana = obj.getScore("CurrentMana");
        Score Mana = obj.getScore("Mana");
        Score EffectiveMana = obj.getScore("EffectiveMana");



        if(Stats.getStats().size() == 0) {
            Health.setScore(100);
            Defence.setScore(5);
            Strength.setScore(25);
            CritChance.setScore(0);
            CritDamage.setScore(10);
            EffectiveHealth.setScore(0);
            EffectiveDefence.setScore(0);
            EffectiveStrength.setScore(0);
            EffectiveCritChance.setScore(0);
            EffectiveCritDamage.setScore(0);
            CurrentHealth.setScore(100);
            CurrentMana.setScore(100);
            Mana.setScore(100);
            EffectiveMana.setScore(100);
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
            Stats.addStats(11, String.valueOf(obj.getScore("CurrentMana").getScore()));
            Stats.addStats(12, String.valueOf(obj.getScore("Mana").getScore()));
            Stats.addStats(13, String.valueOf(obj.getScore("EffectiveMana").getScore()));
        } else {
            Health.setScore(Integer.parseInt(Stats.getStats().get(0)));
            Defence.setScore(Integer.parseInt(Stats.getStats().get(1)));
            Strength.setScore(Integer.parseInt(Stats.getStats().get(2)));
            CritChance.setScore(Integer.parseInt(Stats.getStats().get(3)));
            CritDamage.setScore(Integer.parseInt(Stats.getStats().get(4)));
            EffectiveStrength.setScore(Integer.parseInt(Stats.getStats().get(2) + ItemStats.Weapon(player)[1]));
            CurrentHealth.setScore(Integer.parseInt(Stats.getStats().get(0)));


            Stats.setStats(0, String.valueOf(obj.getScore("Health").getScore()), obj);
            Stats.setStats(1, String.valueOf(obj.getScore("Defence").getScore()), obj);
            Stats.setStats(2, String.valueOf(obj.getScore("Strength").getScore()), obj);
            Stats.setStats(3, String.valueOf(obj.getScore("CritChance").getScore()), obj);
            Stats.setStats(4, String.valueOf(obj.getScore("CritDamage").getScore()), obj);
            Stats.setStats(5, String.valueOf(obj.getScore("EffectiveHealth").getScore()), obj);
            Stats.setStats(6, String.valueOf(obj.getScore("EffectiveDefence").getScore()), obj);
            Stats.setStats(7, String.valueOf(obj.getScore("EffectiveStrength").getScore()), obj);
            Stats.setStats(8, String.valueOf(obj.getScore("EffectiveCritChance").getScore()), obj);
            Stats.setStats(9, String.valueOf(obj.getScore("EffectiveCritDamage").getScore()), obj);
            Stats.setStats(10, String.valueOf(obj.getScore("CurrentHealth").getScore()), obj);
        }




//        System.out.println(Stats.getStats());

        player.setScoreboard(board);

        new BukkitRunnable() {
            @Override
            public void run() {
                player.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.RED + "❤ " + player.getScoreboard().getObjective("Stats").getScore("CurrentHealth").getScore() + ChatColor.GRAY + "/" + ChatColor.RED + obj.getScore("EffectiveHealth").getScore() + "         " + ChatColor.GREEN + "🛡 " + player.getScoreboard().getObjective("Stats").getScore("EffectiveDefence").getScore()));
                EffectiveStrength.setScore(Integer.parseInt(Stats.getStats().get(2)) + Integer.parseInt(ItemStats.Weapon(player)[1]));
                EffectiveCritChance.setScore(Integer.parseInt(Stats.getStats().get(3)) + Integer.parseInt(ItemStats.Weapon(player)[3]));
                EffectiveCritDamage.setScore(Integer.parseInt(Stats.getStats().get(4)) + Integer.parseInt(ItemStats.Weapon(player)[2]));
                EffectiveHealth.setScore(Integer.parseInt(Stats.getStats().get(0)) + Integer.parseInt(ItemStats.Armor(player, 1)[0]) + Integer.parseInt(ItemStats.Armor(player, 2)[0]) + Integer.parseInt(ItemStats.Armor(player, 3)[0]) + Integer.parseInt(ItemStats.Armor(player, 4)[0]));


                EffectiveDefence.setScore(Integer.parseInt(Stats.getStats().get(1)) + Integer.parseInt(ItemStats.Armor(player, 1)[1]) + Integer.parseInt(ItemStats.Armor(player, 2)[1]) + Integer.parseInt(ItemStats.Armor(player, 3)[1]) + Integer.parseInt(ItemStats.Armor(player, 4)[1]));
                int Slots = player.getInventory().getSize();
                for (int i = 0; i < Slots; i++) {
//                    assert player.getInventory().getItem(i).getItemMeta() != null;
                    if(player.getInventory().getItem(i) != null && player.getInventory().getItem(i).getItemMeta() != null) {
                        if (Objects.requireNonNull(Objects.requireNonNull(player.getInventory().getItem(i)).getItemMeta()).hasDisplayName()) {
                            ItemMeta meta = player.getInventory().getItem(i).getItemMeta();
                            assert meta != null;
                            Check.LoreInsert(meta, player.getInventory().getItem(i));
//                            System.out.println(player.getInventory().getItem(i));
                        }
                    }
                }
            }
        }.runTaskTimer(plugin , 0L, 5L);
        new BukkitRunnable() {
            @Override
            public void run() {
                Score OldHealth = CurrentHealth;
                if(((int)(CurrentHealth.getScore() + EffectiveHealth.getScore()*0.01)) < EffectiveHealth.getScore()) {
                    CurrentHealth.setScore((int) (CurrentHealth.getScore() + EffectiveHealth.getScore() * 0.01));
                } else {
                    CurrentHealth.setScore(EffectiveHealth.getScore());
                }
                if(OldHealth.getScore() == EffectiveHealth.getScore()) {
                    CurrentHealth.setScore(EffectiveHealth.getScore());
//                    System.out.println(OldHealth + " " + );
                }
            }
        }.runTaskTimer(plugin , 0L, 20L);
    }
}
