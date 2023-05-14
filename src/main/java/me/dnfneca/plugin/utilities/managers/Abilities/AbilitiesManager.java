// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
<<<<<<< Updated upstream
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
=======

public class AbilitiesManager {
    public static void getAbility(String abilityName, PlayerStats player) {
            switch (abilityName) {
                case "Wave", "Fireball", "TrueShield", "Helix":
                    if(player.getCurrentMana() < 25) {
                        NotEnoughMana(player.getPlayer());
                        break;
                    }
                    ability(abilityName, player);
>>>>>>> Stashed changes
                    break;
                }
                ability(abilityName, player);
                break;
            }
        }
<<<<<<< Updated upstream
    }
    
    public static void NotEnoughMana(final Player p) {
        p.sendMessage(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
    }
    
    public static void ability(final String AbilityName, final PlayerStats p) {
=======

    public static void NotEnoughMana(Player p) {
        p.sendMessage(ChatColor.RED + "NOT ENOUGH MANA!");
    }

    public static void ability(String AbilityName, PlayerStats p) {
>>>>>>> Stashed changes
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
