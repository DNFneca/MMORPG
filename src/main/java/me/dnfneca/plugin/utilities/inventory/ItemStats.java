// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.inventory;

<<<<<<< Updated upstream
=======
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
>>>>>>> Stashed changes
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

<<<<<<< Updated upstream
public class ItemStats
{
    public static final String[][] RegisteredReforges;
    
    public static String[] WeaponReforge(final Player p) {
        String[] data = new String[10];
        for (int i = 0; i < 42; ++i) {}
        final int itemSlot = p.getInventory().getHeldItemSlot();
        final ItemStack Item = p.getInventory().getItem(itemSlot);
        if (Item == null) {
            return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
        if (Item.getItemMeta() != null) {
            final ItemMeta itemMeta = Item.getItemMeta();
            final String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
=======
public class ItemStats {

    public static final String[][] RegisteredReforges = new String[100][2];

//    public static String[] Weapon(PlayerStats p) {
//        String[] data = new String[10];
//        Player player = p.getPlayer();
//
//        int itemSlot = player.getInventory().getHeldItemSlot();
//
//        ItemStack Item = player.getInventory().getItem(itemSlot);
//
//        if(Item == null) {
//            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//        }
//
//
//        if(Check.ExistingStats(Item.getItemMeta())[7].equals("Helmet") || Check.ExistingStats(Item.getItemMeta())[7].equals("Chestplate") || Check.ExistingStats(Item.getItemMeta())[7].equals("Leggings") || Check.ExistingStats(Item.getItemMeta())[7].equals("Boots")) {
//            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//        }
//
////        if(p.getInventory().getItem(itemSlot) != null && p.getInventory().getItem(itemSlot).getItemMeta() != null) {
////            ItemMeta itemMeta = Item.getItemMeta();
////            data = Check.ExistingStats(itemMeta);
////            if(Check.ExistingStats(itemMeta) == null) {
////                return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
////            } else if (Check.ExistingStats(Item.getItemMeta())[7].equals("Helmet") || Check.ExistingStats(Item.getItemMeta())[7].equals("Chestplate") || Check.ExistingStats(Item.getItemMeta())[7].equals("Leggings") || Check.ExistingStats(Item.getItemMeta())[7].equals("Boots")) {
////                return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
////            }
////        }
//
//
//
//        return data;
//    }

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
>>>>>>> Stashed changes
            data = DetermineReforge(ItemStringArray[0]);
        }
        return data;
    }
    
    public static String[] WeaponReforge(final Player p, final int ItemSlot) {
        String[] data = new String[10];
        String[] data2 = new String[10];
        for (int i = 0; i < 42; ++i) {}
        final ItemStack Item = p.getInventory().getItem(ItemSlot);
        if (Item == null) {
            return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
        if (Item.getItemMeta() != null) {
            final ItemMeta itemMeta = Item.getItemMeta();
            final String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
            data = DetermineReforge(itemMeta.getDisplayName());
            data2 = DetermineArmorReforge(itemMeta.getDisplayName());
            int j = 0;
            for (final String s : data) {
                data[j] = String.valueOf(Integer.parseInt(s) + Integer.parseInt(data2[j]));
                ++j;
            }
        }
        return data;
    }
    
    public static String[] DetermineReforge(final String ItemName) {
        final String[] ItemStringArray = ItemName.split(" ");
        final String PotentialReforge = ItemStringArray[0];
        if (PotentialReforge.contains("Sharp")) {
            return new String[] { "0", "5", "0", "5", "0", "0", "0", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Lucky")) {
            return new String[] { "0", "0", "0", "0", "0", "4", "6", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Enchanted")) {
            return new String[] { "0", "0", "0", "0", "6", "0", "6", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Light")) {
            return new String[] { "0", "-2", "0", "5", "0", "0", "6", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Strong")) {
            return new String[] { "0", "15", "0", "7", "0", "0", "0", "0", "0", "0" };
        }
        return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
    }
    
    public static String[] DetermineArmorReforge(final String ItemName) {
        final String[] ItemStringArray = ItemName.split(" ");
        final String PotentialReforge = ItemStringArray[0];
        if (PotentialReforge.contains("Reinforced")) {
            return new String[] { "0", "0", "0", "7", "0", "5", "0", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Smart")) {
            return new String[] { "0", "-2", "0", "5", "50", "0", "6", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Very")) {
            return new String[] { "0", "-2", "0", "5", "100", "0", "6", "0", "0", "0" };
        }
        return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
    }
    
    public static String[] Armor(final Player p, final int ItemSlot) {
        final String[] data = new String[10];
        int ArmorSlot = 0;
        switch (ItemSlot) {
            case 1: {
                ArmorSlot = 39;
                break;
            }
            case 2: {
                ArmorSlot = 38;
                break;
            }
            case 3: {
                ArmorSlot = 37;
                break;
            }
            case 4: {
                ArmorSlot = 36;
                break;
            }
        }
<<<<<<< Updated upstream
        final ItemStack Item = p.getInventory().getItem(ArmorSlot);
        if (Item == null) {
            return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
        if (p.getInventory().getItem(ArmorSlot) != null && p.getInventory().getItem(ArmorSlot).getItemMeta() != null) {
            Item.getItemMeta();
=======
//        assert ArmorSlot != null;
//        ItemMeta itemSlot = ArmorSlot.getItemMeta();
        ItemStack Item = p.getInventory().getItem(ArmorSlot);

//        System.out.println(Item + " " + Item.getItemMeta());

        if(Item == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        } else if(p.getInventory().getItem(ArmorSlot) != null && p.getInventory().getItem(ArmorSlot).getItemMeta() != null) {
            ItemMeta itemMeta = Item.getItemMeta();
//            data = Objects.requireNonNull(Check.ExistingStats(itemMeta));
//            ArmorSlot
>>>>>>> Stashed changes
        }
        return data;
    }
<<<<<<< Updated upstream
    
    public static String[] WeaponEnchantment(final Player p, final int ItemSlot) {
        String[] data = new String[10];
        String[] data2 = new String[10];
        for (int i = 0; i < 42; ++i) {}
        final ItemStack Item = p.getInventory().getItem(ItemSlot);
        if (Item == null) {
            return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
        if (Item.getItemMeta() != null) {
            final ItemMeta itemMeta = Item.getItemMeta();
            final String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
            data = DetermineReforge(itemMeta.getDisplayName());
            data2 = DetermineArmorReforge(itemMeta.getDisplayName());
            int j = 0;
            for (final String s : data) {
                data[j] = String.valueOf(Integer.parseInt(s) + Integer.parseInt(data2[j]));
                ++j;
            }
        }
        return data;
    }
    
    public static String[] getWeaponEnchantment(final String itemName) {
        final String[] ItemStringArray = itemName.split(" ");
        final String PotentialReforge = ItemStringArray[0];
        if (PotentialReforge.contains("Sharp")) {
            return new String[] { "0", "5", "0", "5", "0", "0", "0", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Lucky")) {
            return new String[] { "0", "0", "0", "0", "0", "4", "6", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Enchanted")) {
            return new String[] { "0", "0", "0", "0", "6", "0", "6", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Light")) {
            return new String[] { "0", "-2", "0", "5", "0", "0", "6", "0", "0", "0" };
        }
        if (PotentialReforge.contains("Strong")) {
            return new String[] { "0", "15", "0", "7", "0", "0", "0", "0", "0", "0" };
        }
        return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
    }
    
    static {
        RegisteredReforges = new String[100][2];
    }
}
=======
    public static String[] WeaponEnchantment(Player p, int ItemSlot) {
        String[] data = new String[10];
        String[] data2 = new String[10];
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
            data2 = DetermineArmorReforge(itemMeta.getDisplayName());
            int i = 0;
            for (String s: data) {
                data[i] = String.valueOf(Integer.parseInt(s) + Integer.parseInt(data2[i]));
                i++;
            }
//            System.out.println(data);
        }
        return data;
    }

//    TODO make weapon enchantments it's almost done anyways
    public static String[] getWeaponEnchantment(String itemName) {
        String[] ItemStringArray = itemName.split(" ");
        String PotentialReforge = ItemStringArray[0];

        if (PotentialReforge.contains("Sharp")) {
            return new String[]{"0", "5", "0", "5", "0", "0", "0", "0", "0", "0"};
        } else if (PotentialReforge.contains("Lucky")) {
            return new String[]{"0", "0", "0", "0", "0", "4", "6", "0", "0", "0"};
        } else if (PotentialReforge.contains("Enchanted")) {
            return new String[]{"0", "0", "0", "0", "6", "0", "6", "0", "0", "0"};
        } else if (PotentialReforge.contains("Light")) {
            return new String[]{"0", "-2", "0", "5", "0", "0", "6", "0", "0", "0"};
        } else if (PotentialReforge.contains("Strong")) {
            return new String[]{"0", "15", "0", "7", "0", "0", "0", "0", "0", "0"};
        } else {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        }
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
>>>>>>> Stashed changes
