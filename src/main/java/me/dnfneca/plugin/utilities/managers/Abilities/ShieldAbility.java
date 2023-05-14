// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;

public class ShieldAbility
{
    public static void TrueShieldAbility(final PlayerStats p, final int AmountOfStacks) {
        p.setManaSpent(25.0);
        p.setManaTimer(6);
    }
}
