package me.dnfneca.plugin.utilities.managers.Abilities;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.dnfneca.plugin.utilities.managers.Item.StatsByName.GetStatsString;

public class AbilitiesManager {
    public static void getAbility(ItemStack itemStack, Player player) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        int Mana = player.getScoreboard().getObjective("Stats").getScore("CurrentMana").getScore();
        if(itemMeta != null) {
            String s = GetStatsString(itemMeta.getDisplayName())[8];
            switch (s) {
                case "Wave":
                    if(Mana < 25) {
                        NotEnoughMana(player);
                        break;
                    }
                    ability("Wave", player);
                    break;
                case "Helix":
                    if(Mana < 25) {
                        NotEnoughMana(player);
                        break;
                    }
                    ability("Helix", player);
                    break;
                case "Fireball":
                    if(Mana < 25) {
                        NotEnoughMana(player);
                        break;
                    }
                    ability("Fireball", player);
                    break;
                case "TrueShield":
                    if(Mana < 25) {
                        NotEnoughMana(player);
                        break;
                    }
                    ability("TrueShield", player);
                    break;
            }
        }
    }

    public static void NotEnoughMana(Player p) {
        p.sendMessage(ChatColor.RED + "NOT ENOUGH MANA!");
    }

    public static void ability(String AbilityName, Player p) {
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
