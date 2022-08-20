package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.meta.ItemMeta;

public class Check {
    public static String[] ExistingStats(ItemMeta meta) {
        String[] data = new String[10];
        if(meta == null) {
            return null;
        } else {


            // [0] damage
            // [1] strength
            // [2] critdamage
            // [3] critchance
            // [4] Mana Cost


            switch (meta.getDisplayName()) {
                case "Sticky":
                    data[0] = "10";
                    data[1] = "20";
                    data[2] = "30";
                    data[3] = "10";
                    data[4] = "0";
                    break;
                default:
                    data[0] = "0";
                    data[1] = "0";
                    data[2] = "0";
                    data[3] = "0";
                    data[4] = "0";
                    data[5] = "0";
                    data[6] = "0";
                    data[7] = "0";
                    data[8] = "0";
                    data[9] = "0";
                    break;
            }

            return data;
        }
    }
}
