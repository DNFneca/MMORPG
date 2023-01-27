package me.dnfneca.plugin.utilities.managers.Abilities;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class ShieldAbility {
    public static void TrueShieldAbility(Player p, int AmountOfStacks) {
        Objective objective = p.getScoreboard().getObjective("Stats");
        objective.getScore("ManaCost").setScore(25);
        objective.getScore("ManaTimer").setScore(6);
        Score score = p.getScoreboard().getObjective("Stats").getScore("TrueShield");
        score.setScore(AmountOfStacks);
    }
}
