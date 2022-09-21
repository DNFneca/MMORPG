package me.dnfneca.plugin.utilities.inventory;

import me.dnfneca.plugin.utilities.managers.Item.Check;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

import static me.dnfneca.plugin.utilities.managers.Item.Check.*;

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

    public static String[] WeaponReforge(Player p) {
        String[] data = new String[10];

        int itemSlot = p.getInventory().getHeldItemSlot();

        ItemStack Item = p.getInventory().getItem(itemSlot);

        if(Item == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        }

        if(p.getInventory().getItem(itemSlot) != null && p.getInventory().getItem(itemSlot).getItemMeta() != null) {
            ItemMeta itemMeta = Item.getItemMeta();
            String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
            data = DetermineRegorge(ItemStringArray[0]);
//            System.out.println(data);
        }



        return data;
    }

    public static String[] DetermineRegorge(String PotentialReforge) {
        if (PotentialReforge.contains("Reforged")) {
            return new String[]{"0", "2022", "0", "0", "0", "0", "0", "0", "0", "0"};
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
            data = Objects.requireNonNull(Check.ExistingStatsArmor(itemMeta));
//            ArmorSlot
        }

        return data;
    }
    public static void get(ItemMeta meta, ItemStack item) {
        ArrayList<String> Lore = new ArrayList<>();

        // ARMOR

        //            data[0] = health
        //            data[1] = defence
        //            data[2] = heal per second
        //            data[3] = mana

        if(meta.getDisplayName().contains("Iron Armor Boots") || meta.getDisplayName().contains("Iron Armor Helmet")){
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " +10");
            Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +20");
            Lore.add(ChatColor.GRAY + "HPS:" + ChatColor.DARK_GREEN + " +5");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Iron Armor Leggings") || meta.getDisplayName().contains("Iron Armor Chestplate")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " +15");
            Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +25");
            Lore.add(ChatColor.GRAY + "HPS:" + ChatColor.DARK_GREEN + " +7");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        }
        if(meta.getDisplayName().contains("Wise Man's Boots") || meta.getDisplayName().contains("Wise Man's Hat")){
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " +25");
            Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +5");
            Lore.add(ChatColor.GRAY + "HPS:" + ChatColor.DARK_GREEN + " +1");
            Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.AQUA + " +50");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Wise Man's Trousers") || meta.getDisplayName().contains("Wise Man's Coat")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " +30");
            Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +10");
            Lore.add(ChatColor.GRAY + "HPS:" + ChatColor.DARK_GREEN + " +2");
            Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.AQUA + " +75");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        }


        // WEAPON


        // [0] damage
        // [1] strength
        // [2] critdamage
        // [3] critchance
        // [4] Mana Cost


        if (meta.getDisplayName().contains("Sticky")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +10");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +20");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +30%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +30%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Aspect of the Nether")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +100");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +125");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +200%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +100%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Eros's Bow")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +250");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +75");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +350%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +50%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Longsword")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +55");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +40%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +20%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("The Void")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +120");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +70");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +55%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +45%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Holy Iron Sword")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +40");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +30");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +15%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +5%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Mithril Blade")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +80");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +65");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +30%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +10%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Bloodquench")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +100");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +75");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +55%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +30%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Winterthorn")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +85");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +60");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +20%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +5%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Black Sword")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +120");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +65");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +40%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +10%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        } else if (meta.getDisplayName().contains("Unholy Great Sword")) {
            meta.setDisplayName(ItemRarityColor(meta.getDisplayName()) + meta.getDisplayName());
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +95");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +105");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +35%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +30%");
            Lore.add("");
            Lore.add(ItemRarityColor(meta.getDisplayName()) + ItemRarity(meta.getDisplayName()));
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
        }


        // Exotics


        if(meta.getDisplayName().contains("Ghost Reaver")) {
            meta.setDisplayName(ItemNameExotic(meta.getDisplayName()));
            Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " +345");
            Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.DARK_RED + " +220");
            Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +730%");
            Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.DARK_GREEN + " +90%");
            Lore.add("");
            Lore.add(ItemRarityExotic());
            meta.setLore(Lore);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            item.setItemMeta(meta);
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