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
                case "Aspect of the Nether":
                    data[0] = "100";
                    data[1] = "125";
                    data[2] = "200";
                    data[3] = "100";
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
    public static String[] ExistingStatsArmor (ItemMeta meta, int ItemSlot) {
        String[] data = new String[10];
        if(meta == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        } else {



//            data[0] = health
//            data[1] = defence
//            data[2] = heal per second
//            data[3] = mana





            switch (ItemSlot) {
                case 1:
                    switch (meta.getDisplayName()) {
                        case "Iron Armor":
                            data[0] = "10";
                            data[1] = "20";
                            data[2] = "5";
                            data[3] = "0";
                            break;
                    }
                    break;
                case 4:
                    switch (meta.getDisplayName()) {
                        case "Iron Armor":
                            data[0] = "10";
                            data[1] = "20";
                            data[2] = "30";
                            data[3] = "10";
                            data[4] = "0";
                            break;
                    }
                    break;
                default:
                    switch (meta.getDisplayName()) {
                        case "Iron Armor":
                            data[0] = "15";
                            data[1] = "25";
                            data[2] = "7";
                            data[3] = "0";
                            break;
                    }
                    break;
            }

            return data;
        }
    }
}
