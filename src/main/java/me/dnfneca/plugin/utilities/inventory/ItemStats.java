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
            if(Check.ExistingStats(itemMeta) == null) {
                return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
            } else if (Check.ExistingStats(itemMeta)[7].equals("Armor")) {
                return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
            }
        }



        return data;
    }

    public static String[] WeaponReforge(Player p) {
        String[] data = new String[10];
        for (int i = 0; i < 42; i++) {

        }
        int itemSlot = p.getInventory().getHeldItemSlot();

        ItemStack Item = p.getInventory().getItem(itemSlot);

        if(Item == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        }
        if(Item.getItemMeta() != null) {
            ItemMeta itemMeta = Item.getItemMeta();
            String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
            data = DetermineReforge(ItemStringArray[0]);
//            System.out.println(data);
        }
        return data;
    }
    public static String[] WeaponReforge(Player p, int ItemSlot) {
        String[] data = new String[10];
        for (int i = 0; i < 42; i++) {

        }

        ItemStack Item = p.getInventory().getItem(ItemSlot);

        if(Item == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        }
        if(Item.getItemMeta() != null) {
            ItemMeta itemMeta = Item.getItemMeta();
            String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
            data = DetermineReforge(itemMeta.getDisplayName());
//            System.out.println(data);
        }
        return data;
    }
    //            health
    //            damage
    //            defence
    //            strength
    //            mana +
    //            critdamage
    //            critchance
    //            heal per second
    //            Mana Cost
    public static String[] DetermineReforge(String ItemName) {
        String[] ItemStringArray = ItemName.split(" ");
        String PotentialReforge = ItemStringArray[0];

        if (PotentialReforge.contains("Sharp")) {
            return new String[]{"0", "5", "0", "5", "0", "0", "0", "0", "0", "0"};
        } else if (PotentialReforge.contains("Reinforced")) {
            return new String[]{"0", "0", "0", "7", "0", "5", "0", "0", "0", "0"};
        } else if (PotentialReforge.contains("Lucky")) {
            return new String[]{"0", "0", "0", "0", "0", "4", "6", "0", "0", "0"};
        } else if (PotentialReforge.contains("Enchanted")) {
            return new String[]{"0", "0", "0", "0", "6", "0", "6", "0", "0", "0"};
        } else if (PotentialReforge.contains("Light")) {
            return new String[]{"0", "-2", "0", "5", "0", "0", "6", "0", "0", "0"};
        } else if (PotentialReforge.contains("Smart")) {
            return new String[]{"0", "-2", "0", "5", "0", "0", "6", "0", "0", "0"};
        } else if (PotentialReforge.contains("Very")) {
            return new String[]{"0", "-2", "0", "5", "0", "0", "6", "0", "0", "0"};
        } else {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        }
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
            data = Objects.requireNonNull(Check.ExistingStats(itemMeta));
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