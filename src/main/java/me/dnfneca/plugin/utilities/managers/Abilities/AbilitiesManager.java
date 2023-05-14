// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;

public class AbilitiesManager
{
    public static void getAbility(final String abilityName, final PlayerStats player) {
        switch (abilityName) {
            case "Wave":
            case "Fireball":
            case "TrueShield":
            case "Helix": {
                if (player.getCurrentMana() < 25.0) {
                    NotEnoughMana(player.getPlayer());
                    break;
                }
                ability(abilityName, player);
                break;
            }
        }
    }
    
    public static void NotEnoughMana(final Player p) {
        p.sendMessage(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
    }
    
    public static void ability(final String AbilityName, final PlayerStats p) {
        switch (AbilityName) {
            case "Wave": {
                Wave.Wave(p);
                break;
            }
            case "Helix": {
                Helix.Helix(p);
                break;
            }
            case "Fireball": {
                Fireball.Fireball(p);
                break;
            }
            case "TrueShield": {
                ShieldAbility.TrueShieldAbility(p, 1);
                break;
            }
        }
    }
}
