package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class ShieldAbility {
    public static void TrueShieldAbility(PlayerStats p, int AmountOfStacks) {
        p.setManaSpent(25);
        p.setManaTimer(6);
    }
}
