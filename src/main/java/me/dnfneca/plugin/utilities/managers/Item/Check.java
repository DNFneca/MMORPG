package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import static me.dnfneca.plugin.utilities.managers.Item.RegisterItem.RegisteredItems;
import static me.dnfneca.plugin.utilities.managers.Item.StatsByName.GetStatsString;
import static me.dnfneca.plugin.utilities.managers.Item.StatsByName.SetItemStatsLore;

public class Check {
    public static String[] ExistingStats(ItemMeta meta) {
        String[] data = new String[10];
        if (meta == null) {
            return null;
        } else {


            // [0] damage
            // [1] strength
            // [2] critdamage
            // [3] critchance
            // [4] Mana Cost
            // [5] Mana Plus

            int i = 0;
            for (String s : RegisteredItems) {
                if (s != null) {
                    if (meta.getDisplayName().contains(s)) {
                        String[] ItemStats = GetStatsString(s);
                        i++;
                        return ItemStats;
                    }
                }
            }
            return null;
        }
    }
//
//    public static void LoreInsert(ItemMeta meta, ItemStack item) {
//        SetItemStatsLore(item.getItemMeta().getDisplayName(), item, null);
//    }
    public static void LoreInsert(int ItemSlot, Player player) {
        SetItemStatsLore(ItemSlot, player);
    }

}

