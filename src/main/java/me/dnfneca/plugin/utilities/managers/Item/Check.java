package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

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

            if(meta.getDisplayName().contains("Sticky")) {
                data[0] = "10";
                data[1] = "20";
                data[2] = "30";
                data[3] = "10";
                data[4] = "25";
            } else if (meta.getDisplayName().contains("Aspect of the Nether")) {
                data[0] = "100";
                data[1] = "125";
                data[2] = "200";
                data[3] = "100";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("Eros's Bow")) {
                data[0] = "250";
                data[1] = "75";
                data[2] = "350";
                data[3] = "50";
                data[4] = "0";
            } else {
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
            }

            return data;
        }
    }

    public static String[] ExistingStatsArmor(ItemMeta meta) {
        String[] data = new String[10];
        if (meta == null) {
            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        } else {


//            data[0] = health
//            data[1] = defence
//            data[2] = heal per second
//            data[3] = mana

            if(meta.getDisplayName().contains("Iron Armor Boots") || meta.getDisplayName().contains("Iron Armor Helmet")) {
                data[0] = "10";
                data[1] = "20";
                data[2] = "5";
                data[3] = "0";
            } else if (meta.getDisplayName().contains("Iron Armor Leggings") || meta.getDisplayName().contains("Iron Armor Chestplate")) {
                data[0] = "15";
                data[1] = "25";
                data[2] = "7";
                data[3] = "0";
            } else if (meta.getDisplayName().contains("Wise Man's Boots") || meta.getDisplayName().contains("Wise Man's Hat")) {
                data[0] = "25";
                data[1] = "5";
                data[2] = "1";
                data[3] = "50";
            } else if (meta.getDisplayName().contains("Wise Man's Trousers") || meta.getDisplayName().contains("Wise Man's Coat")) {
                data[0] = "30";
                data[1] = "10";
                data[2] = "2";
                data[3] = "75";
            } else {
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
            }
            return data;
        }
    }

    public static void LoreInsert(ItemMeta meta, ItemStack item) {
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
        }



    }

    public static String ItemRarity(String ItemDisplayName) {
        String Rarity;

        if(ItemDisplayName.contains("Iron Armor")) {
            Rarity = "Rare";
        } else if(ItemDisplayName.contains("Aspect of the Nether")) {
            Rarity = "Legendary";
        } else if(ItemDisplayName.contains("Eros's Bow")) {
            Rarity = "Mythic";
        } else if(ItemDisplayName.contains("Wise Man's")) {
            Rarity = "Epic";
        } else {
            Rarity = "Common";
        }
        return Rarity;
    }

    public static ChatColor ItemRarityColor(String ItemDisplayName) {
        ChatColor RarityColor = null;


        String RarityName = Check.ItemRarity(ItemDisplayName);



        switch (RarityName) {
            case "Mythic":
                RarityColor = ChatColor.DARK_RED;
                break;
            case "Legendary":
                RarityColor = ChatColor.GOLD;
                break;
            case "Epic":
                RarityColor = ChatColor.DARK_PURPLE;
                break;
            case "Rare":
                RarityColor = ChatColor.BLUE;
                break;
            case "Common":
                RarityColor = ChatColor.GRAY;
        }

        return RarityColor;
    }

}

