package me.dnfneca.plugin.utilities.managers.Abilities;


import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AbilitiesManager {
    public static void getAbility(String abilityName, PlayerStats player) {
            switch (abilityName) {
                case "Wave", "Fireball", "TrueShield", "Helix":
                    if(player.getCurrentMana() < 25) {
                        NotEnoughMana(player.getPlayer());
                        break;
                    }
                    ability(abilityName, player);
                    break;
            }
        }

    public static void NotEnoughMana(Player p) {
        p.sendMessage(ChatColor.RED + "NOT ENOUGH MANA!");
    }

    public static void ability(String AbilityName, PlayerStats p) {
        switch (AbilityName) {
            case "Wave":
                Wave.Wave(p);
                break;
            case "Helix":
                Helix.Helix(p);
                break;
            case "Fireball":
                Fireball.Fireball(p);
                break;
            case "TrueShield":
                ShieldAbility.TrueShieldAbility(p, 1);
        }

    }
}
