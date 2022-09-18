package me.dnfneca.plugin.utilities.managers.Statistics;

import me.dnfneca.plugin.utilities.inventory.ItemStats;
import me.dnfneca.plugin.utilities.managers.Item.Check;
import me.dnfneca.plugin.utilities.managers.Stats;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class StatCalc {
    public static void Calculate(Objective objective, Player player) {
        Score Health = objective.getScore("Health");
        Score EffectiveHealth = objective.getScore("EffectiveHealth");
        Score EffectiveDefence = objective.getScore("EffectiveDefence");
        Score EffectiveStrength = objective.getScore("EffectiveStrength");
        Score EffectiveCritChance = objective.getScore("EffectiveCritChance");
        Score EffectiveCritDamage = objective.getScore("EffectiveCritDamage");
        Score CurrentHealth = objective.getScore("CurrentHealth");
        Score CurrentMana = objective.getScore("CurrentMana");
        Score EffectiveMana = objective.getScore("EffectiveMana");
        Score ManaCost = objective.getScore("ManaCost");
        Score ManaTimer = objective.getScore("ManaTimer");
        Score Damage = objective.getScore("Damage");
        Score CurrentDamage = objective.getScore("CurrentDamage");
        Score EffectiveSpeed = objective.getScore("EffectiveSpeed");




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
        EffectiveStrength.setScore(objective.getScore("Strength").getScore() + Integer.parseInt(ItemStats.Weapon(player)[1]));
        EffectiveCritChance.setScore(objective.getScore("CritChance").getScore() + Integer.parseInt(ItemStats.Weapon(player)[3]));
        EffectiveCritDamage.setScore(objective.getScore("CritDamage").getScore() + Integer.parseInt(ItemStats.Weapon(player)[2]));

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

        EffectiveSpeed.setScore(objective.getScore("Speed").getScore());

        int OldEffectiveMana = EffectiveMana.getScore();

        EffectiveMana.setScore(objective.getScore("Mana").getScore() + Integer.parseInt(ItemStats.Armor(player, 1)[3]) + Integer.parseInt(ItemStats.Armor(player, 2)[3]) + Integer.parseInt(ItemStats.Armor(player, 3)[3]) + Integer.parseInt(ItemStats.Armor(player, 4)[3]));

        if(CurrentMana.getScore() == OldEffectiveMana) {
            CurrentMana.setScore(EffectiveMana.getScore());
        }

    }
}
