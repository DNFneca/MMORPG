// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.inventory;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

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
        final ItemStack Item = p.getInventory().getItem(ArmorSlot);
        if (Item == null) {
            return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
        if (p.getInventory().getItem(ArmorSlot) != null && p.getInventory().getItem(ArmorSlot).getItemMeta() != null) {
            Item.getItemMeta();
        }
        return data;
    }
    
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
