package me.dnfneca.plugin.utilities.inventory;

import me.dnfneca.plugin.utilities.managers.Item.Check;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemStats {
    public static String[] Weapon(Player p) {
        String[] data = new String[10];
        if (p.getItemInUse() != null) {
            ItemStack Weapon = p.getItemInUse();
            ItemMeta meta = Weapon.getItemMeta();

            System.out.println(Arrays.toString(Check.ExistingStats(meta)));



            data = Check.ExistingStats(meta);

        }


        return data;
    }
//    public static String[] Armor(Player p) {
//
//
//        return get();
//    }
//    public static String[] All(Player p) {
//
//
//        return get();
//    }
}
