package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

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


            switch (meta.getDisplayName()) {
                case "Sticky":
                    data[0] = "10";
                    data[1] = "20";
                    data[2] = "30";
                    data[3] = "10";

                    break;
            }

            return (String[]) Arrays.stream(data).toArray();
        }
    }
}
