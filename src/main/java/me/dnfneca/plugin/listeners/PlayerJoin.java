package me.dnfneca.plugin.listeners;


import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import me.dnfneca.plugin.utilities.managers.Stats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;




public class PlayerJoin implements Listener{

    static Plugin plugin;
    public PlayerJoin(Plugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String UUID = player.getUniqueId().toString();

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


        if(Stats.getStats().size() == 0) {
            Health.setScore(20);
            Defence.setScore(5);
            Strength.setScore(25);
            CritChance.setScore(0);
            CritDamage.setScore(10);
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
        } else {
            Health.setScore(Integer.parseInt(Stats.getStats().get(0)));
            Defence.setScore(Integer.parseInt(Stats.getStats().get(1)));
            Strength.setScore(Integer.parseInt(Stats.getStats().get(2)));
            CritChance.setScore(Integer.parseInt(Stats.getStats().get(3)));
            CritDamage.setScore(Integer.parseInt(Stats.getStats().get(4)));
            EffectiveStrength.setScore(Integer.parseInt(Stats.getStats().get(2) + ItemStats.Weapon(player)[1]));

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
        }




        System.out.println(Stats.getStats());

        player.setScoreboard(board);

        new BukkitRunnable() {
            @Override
            public void run() {
                EffectiveStrength.setScore(Integer.parseInt(Stats.getStats().get(2)) + Integer.parseInt(ItemStats.Weapon(player)[1]));
            }
        }.runTaskTimer(plugin , 0L, 10L);

    }

}
