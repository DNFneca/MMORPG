// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
<<<<<<< Updated upstream

public class ShieldAbility
{
    public static void TrueShieldAbility(final PlayerStats p, final int AmountOfStacks) {
        p.setManaSpent(25.0);
=======
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class ShieldAbility {
    public static void TrueShieldAbility(PlayerStats p, int AmountOfStacks) {
        p.setManaSpent(25);
>>>>>>> Stashed changes
        p.setManaTimer(6);
    }
}
