package me.dnfneca.plugin.utilities.managers.Item;

import java.util.Arrays;

public class RegisterItem {
    public static final String[] RegisteredItems = new String[100];
    public static void RegisterNewItem(String ItemName) {
        int ItemCount = 0, StatCount = 0;
        Object VanjinTata = null;
        for (String s : RegisteredItems) {
            if (s != null) {
                ItemCount++;
            } else {
                break;
            }
        }
        if (ItemCount > 98) {
            ItemCount = 0;
        }
        // Name
        RegisteredItems[ItemCount] = ItemName;
//        // Damage
//        RegisteredItemsStats[0] = Float.valueOf(args[1]);
//        // Strength
//        RegisteredItemsStats[1] = Float.valueOf(args[2]);
//        // Crit Damage
//        RegisteredItemsStats[2] = Float.valueOf(args[3]);
//        // Crit Chance
//        RegisteredItemsStats[3] = Float.valueOf(args[4]);
//        // Mana Cost
//        RegisteredItemsStats[4] = Float.valueOf(args[5]);
//        // Ability Name
//        RegisteredItemsStats[5] = Float.valueOf(args[6]);
//        // Mana
//        RegisteredItemsStats[6] = Float.valueOf(args[7]);
    }
}
