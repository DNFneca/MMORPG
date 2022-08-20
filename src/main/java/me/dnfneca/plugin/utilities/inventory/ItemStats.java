package me.dnfneca.plugin.utilities.inventory;

import me.dnfneca.plugin.utilities.managers.Item.Check;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ItemStats {
    public static String[] Weapon(Player p) {
        String[] data = new String[10];

        int itemSlot = p.getInventory().getHeldItemSlot();


        if(p.getInventory().getItem(itemSlot) != null && p.getInventory().getItem(itemSlot).getItemMeta() != null) {
            ItemStack Item = p.getInventory().getItem(itemSlot);
            ItemMeta itemMeta = Item.getItemMeta();
            data = Objects.requireNonNull(Check.ExistingStats(itemMeta));
            System.out.println(data);
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
