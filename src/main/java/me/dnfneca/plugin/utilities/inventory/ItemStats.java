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

        ItemStack Item = p.getInventory().getItem(itemSlot);

        if(Item == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        }

        if(p.getInventory().getItem(itemSlot) != null && p.getInventory().getItem(itemSlot).getItemMeta() != null) {
            ItemMeta itemMeta = Item.getItemMeta();
            data = Objects.requireNonNull(Check.ExistingStats(itemMeta));
//            System.out.println(data);
        }



        return data;
    }
    public static String[] Armor(Player p, int ItemSlot) {
        String[] data = new String[10];
        int ArmorSlot = 0;
        switch(ItemSlot) {
            case 1:
                ArmorSlot = 39;
                break;
            case 2:
                ArmorSlot = 38;
                break;
            case 3:
                ArmorSlot = 37;
                break;
            case 4:
                ArmorSlot = 36;
                break;
        }
//        assert ArmorSlot != null;
//        ItemMeta itemSlot = ArmorSlot.getItemMeta();
        ItemStack Item = p.getInventory().getItem(ArmorSlot);

//        System.out.println(Item + " " + Item.getItemMeta());

        if(Item == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        } else if(p.getInventory().getItem(ArmorSlot) != null && p.getInventory().getItem(ArmorSlot).getItemMeta() != null) {
            ItemMeta itemMeta = Item.getItemMeta();
            data = Objects.requireNonNull(Check.ExistingStatsArmor(itemMeta));
//            ArmorSlot
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
