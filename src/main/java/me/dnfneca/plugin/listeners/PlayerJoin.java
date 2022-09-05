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
            Speed.setScore(1);
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
            Speed.setScore(1);

        }



//        System.out.println(Stats.getStats());

        player.setScoreboard(board);



        Bukkit.getScheduler().runTaskLater(Plugin.getInstance(), new Runnable()  {
            @Override
            public void run() {
                if (Class.getScore() == 0) {
                    ChooseClassesMenu(player);
                    System.out.println(player);
                }
            }
        } , 20L);

        new BukkitRunnable() {
            @Override
            public void run() {
                NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");

            if(playerdata.get(key, PersistentDataType.INTEGER) != null) {
                switch (playerdata.get(key, PersistentDataType.INTEGER)) {
                    case 1:
                        Damage.setScore((int) (25 + 25 * 0.05));
                        Health.setScore((int) (100 - 100 * 0.15));
                        Defence.setScore((int) (5 - 5 * 0.1));
                        Strength.setScore(25);
                        CritChance.setScore((int) (0 + 15));
                        CritDamage.setScore((int) (10 + 5));
                        Mana.setScore((int) (100 + 100 * 0.25));
                        Speed.setScore((int) (1));
                        player.setWalkSpeed((float) (0.2));

                        break;
                    case 2:
                        Damage.setScore((int) (25));
                        Health.setScore((int) (100 + 100 * 0.05));
                        Defence.setScore((int) (5 + 5 * 0.05));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 5);
                        CritDamage.setScore((int) (10 + 5));
                        Mana.setScore((int) (100 + 100 * 0.5));
                        Speed.setScore((int) (1));
                        player.setWalkSpeed((float) (0.2));

                        break;
                    case 3:
                        Damage.setScore((int) (25));
                        Health.setScore((int) (100 - 100 * 0.1));
                        Defence.setScore((int) (5 - 5 * 0.1));
                        Strength.setScore(25);
                        CritChance.setScore(0 - 30);
                        CritDamage.setScore((int) (10 - 10));
                        Mana.setScore((int) (100 + 100 * 0.5));
                        Speed.setScore((int) (1));
                        player.setWalkSpeed((float) (0.2));

                        break;
                    case 4:
                        Damage.setScore((int) (25));
                        Health.setScore((int) (100 - 100 * 0.1));
                        Defence.setScore((int) (5 + 5 * 0.15));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 10);
                        CritDamage.setScore((int) (10 + 5));
                        Mana.setScore((int) (100 + 100 * 0.3));
                        Speed.setScore((int) (1));
                        player.setWalkSpeed((float) (0.2));
                        break;
                    case 5:
                        Damage.setScore((int) (25 + 25*0.20));
                        Health.setScore((int) (100 - 100 * 0.1));
                        Defence.setScore((int) (5 + 5 * 0.35));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 10);
                        CritDamage.setScore((int) (10 + 15));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 - 0.2*0.3));
                        Speed.setScore((int) (1 - 1*0.3));
                        break;
                    case 6:
                        Damage.setScore((int) (25 + 25*0.05));
                        Health.setScore((int) (100 - 100 * 0.15));
                        Defence.setScore((int) (5 + 5 * 0.35));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 15);
                        CritDamage.setScore((int) (10 + 5));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 + 0.2*0.2));
                        Speed.setScore((int) (1 + 1*0.15));
                        break;
                    case 7:
                        Damage.setScore((int) (25 + 25*0.1));
                        Health.setScore((int) (100 + 100 * 0.15));
                        Defence.setScore((int) (5 + 5 * 0.2));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 10);
                        CritDamage.setScore((int) (10 + 15));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 - 0.2*0.2));
                        Speed.setScore((int) (1 - 1*0.1));
                        break;
                    case 8:
                        Damage.setScore((int) (25 + 25*0.15));
                        Health.setScore((int) (100 - 100 * 0.15));
                        Defence.setScore((int) (5 - 5 * 0.05));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 5);
                        CritDamage.setScore((int) (10 + 5));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 + 0.2*0.2));
                        Speed.setScore((int) (1 + 1*0.2));
                        break;
                    case 9:
                        Damage.setScore((int) (25 + 25*0.1));
                        Health.setScore((int) (100 - 100 * 0.15));
                        Defence.setScore((int) (5));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 25);
                        CritDamage.setScore((int) (10 + 5));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 + 0.2*0.15));
                        Speed.setScore((int) (1 + 1*0.2));
                        break;
                    case 10:
                        Damage.setScore((int) (25 + 25*0.15));
                        Health.setScore((int) (100 - 100 * 0.15));
                        Defence.setScore((int) (5 - 5*0.05));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 25);
                        CritDamage.setScore((int) (10 + 10));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 + 0.2*0.25));
                        Speed.setScore((int) (1 + 1*0.2));
                        break;
                    case 11:
                        Damage.setScore((int) (25 + 25*0.05));
                        Health.setScore((int) (100 + 100 * 0.05));
                        Defence.setScore((int) (5 - 5*0.2));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 10);
                        CritDamage.setScore((int) (10 + 5));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 + 0.2*0.3));
                        Speed.setScore((int) (1 + 1*0.2));
                        break;
                    case 12:
                        Damage.setScore((int) (25 + 25*0.25));
                        Health.setScore((int) (100 + 100 * 0.15));
                        Defence.setScore((int) (5 - 5*0.15));
                        Strength.setScore(25);
                        CritChance.setScore(0 + 15);
                        CritDamage.setScore((int) (10 + 30));
                        Mana.setScore((int) (100));
                        player.setWalkSpeed((float) (0.2 + 0.2*0.4));
                        Speed.setScore((int) (1 + 1*0.2));
                        break;
                }
            }


//                player.setWalkSpeed((float) (0.2));


                Objective objective = player.getScoreboard().getObjective("Stats");
                if(objective == null) {
                    return;
                }

                if(objective.getScore("ManaCost").getScore() != 0 || objective.getScore("ManaTimer").getScore() != 0) {

                    int OldManaCost = objective.getScore("ManaCost").getScore();
                    if(ManaTimer.getScore() >= 6) {
                        objective.getScore("CurrentMana").setScore(objective.getScore("CurrentMana").getScore() - objective.getScore("ManaCost").getScore());
                    }

//                    CurrentMana.setScore(CurrentHealth.getScore() - OldManaCost);
                    player.spigot().sendMessage(
                            ChatMessageType.ACTION_BAR,
                            new TextComponent(ChatColor.RED + "❤ " + objective.getScore("CurrentHealth").getScore() + ChatColor.GRAY + "/" + ChatColor.RED + objective.getScore("EffectiveHealth").getScore() + "   " + ChatColor.GREEN + "🛡 " + objective.getScore("EffectiveDefence").getScore() + "   " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + "-" + OldManaCost + " " + objective.getScore("CurrentMana").getScore() + ChatColor.GRAY + "/" + ChatColor.AQUA + objective.getScore("EffectiveMana").getScore()));
                    objective.getScore("ManaTimer").setScore(objective.getScore("ManaTimer").getScore() - 1);
                    if(ManaTimer.getScore() <= 0)
                        ManaCost.setScore(0);
                } else {
                    player.spigot().sendMessage(
                            ChatMessageType.ACTION_BAR,
                            new TextComponent(ChatColor.RED + "❤ " + objective.getScore("CurrentHealth").getScore() + ChatColor.GRAY + "/" + ChatColor.RED + objective.getScore("EffectiveHealth").getScore() + "   " + ChatColor.GREEN + "🛡 " + objective.getScore("EffectiveDefence").getScore() + "   " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + objective.getScore("CurrentMana").getScore() + ChatColor.GRAY + "/" + ChatColor.AQUA + objective.getScore("EffectiveMana").getScore()));
                }
                EffectiveStrength.setScore(Integer.parseInt(Stats.getStats().get(2)) + Integer.parseInt(ItemStats.Weapon(player)[1]));
                EffectiveCritChance.setScore(Integer.parseInt(Stats.getStats().get(3)) + Integer.parseInt(ItemStats.Weapon(player)[3]));
                EffectiveCritDamage.setScore(Integer.parseInt(Stats.getStats().get(4)) + Integer.parseInt(ItemStats.Weapon(player)[2]));

                int OldEffectiveHealth = EffectiveHealth.getScore();

                EffectiveHealth.setScore(Health.getScore() + Integer.parseInt(ItemStats.Armor(player, 1)[0]) + Integer.parseInt(ItemStats.Armor(player, 2)[0]) + Integer.parseInt(ItemStats.Armor(player, 3)[0]) + Integer.parseInt(ItemStats.Armor(player, 4)[0]));

                if(CurrentHealth.getScore() == OldEffectiveHealth) {
                    CurrentHealth.setScore(EffectiveHealth.getScore());
                }
                if(CurrentHealth.getScore() > EffectiveHealth.getScore())
                    CurrentHealth.setScore(EffectiveHealth.getScore());

                if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                    CurrentDamage.setScore(Integer.parseInt(Check.ExistingStats(player.getInventory().getItemInMainHand().getItemMeta())[0]) + Damage.getScore());
                } else {
                    CurrentDamage.setScore(Damage.getScore());
                }

                EffectiveDefence.setScore(Integer.parseInt(Stats.getStats().get(1)) + Integer.parseInt(ItemStats.Armor(player, 1)[1]) + Integer.parseInt(ItemStats.Armor(player, 2)[1]) + Integer.parseInt(ItemStats.Armor(player, 3)[1]) + Integer.parseInt(ItemStats.Armor(player, 4)[1]));

                int OldEffectiveMana = EffectiveMana.getScore();

                EffectiveMana.setScore(objective.getScore("Mana").getScore() + Integer.parseInt(ItemStats.Armor(player, 1)[3]) + Integer.parseInt(ItemStats.Armor(player, 2)[3]) + Integer.parseInt(ItemStats.Armor(player, 3)[3]) + Integer.parseInt(ItemStats.Armor(player, 4)[3]));

                if(CurrentMana.getScore() == OldEffectiveMana) {
                    CurrentMana.setScore(EffectiveMana.getScore());
                }

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
