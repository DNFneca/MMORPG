package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
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
                if(s != null) {
                    if (meta.getDisplayName().contains(s)) {
                        String[] ItemStats = GetStatsString(s);
                        i++;
                        return ItemStats;
                    }
                }
            }
//            if(i == 0) {
//                String[] ItemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//                return ItemStats;
//            }

            if(meta.getDisplayName().contains("Sticky")) {
                data[0] = "10";
                data[1] = "20";
                data[2] = "30";
                data[3] = "10";
                data[4] = "25";
            } else if (meta.getDisplayName().contains("Longsword")) {
                data[0] = "55";
                data[1] = "0";
                data[2] = "40";
                data[3] = "20";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("The Void")) {
                data[0] = "120";
                data[1] = "70";
                data[2] = "55";
                data[3] = "45";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("Holy Iron Sword")) {
                data[0] = "40";
                data[1] = "30";
                data[2] = "15";
                data[3] = "5";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("Mithril Blade")) {
                data[0] = "80";
                data[1] = "65";
                data[2] = "30";
                data[3] = "10";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("Bloodquench")) {
                data[0] = "100";
                data[1] = "75";
                data[2] = "55";
                data[3] = "30";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("Winterthorn")) {
                data[0] = "85";
                data[1] = "60";
                data[2] = "20";
                data[3] = "5";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("Black Sword")) {
                data[0] = "120";
                data[1] = "65";
                data[2] = "40";
                data[3] = "10";
                data[4] = "0";
            } else if (meta.getDisplayName().contains("Unholy Great Sword")) {
                data[0] = "95";
                data[1] = "105";
                data[2] = "35";
                data[3] = "30";
                data[4] = "0";
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
            } else if (meta.getDisplayName().contains("Ghost Reaver")) {
                data[0] = "345";
                data[1] = "220";
                data[2] = "730";
                data[3] = "90";
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



        SetItemStatsLore(item.getItemMeta().getDisplayName(), item);

    }

    public static String ItemRarity(String ItemDisplayName) {
        String Rarity;

        if(ItemDisplayName.contains("Longsword")) {
            Rarity = "Uncommon";
        }else if(ItemDisplayName.contains("Iron Armor") || ItemDisplayName.contains("Mithril Blade") || ItemDisplayName.contains("Bloodquench") || ItemDisplayName.contains("Black Sword") || ItemDisplayName.contains("Unholy Great Sword")) {
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

    public static String ItemRarityExotic() {
        String Rarity;
        Rarity = ChatColor.BLUE + "E" + ChatColor.YELLOW + "x" + ChatColor.GREEN + "o" + ChatColor.DARK_BLUE + ChatColor.DARK_PURPLE + "t" + ChatColor.DARK_AQUA + "i" + ChatColor.DARK_GREEN + "c";
        return Rarity;
    }

    public static String ItemNameExotic(String ItemDisplayName) {
        String Rarity;
        if (ItemDisplayName.contains("[DEV]")) {
            Rarity = ItemDisplayName;
        } else {
            Rarity = ChatColor.DARK_RED + "[DEV] " + ChatColor.AQUA + ItemDisplayName;
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
            case "Uncommon":
                RarityColor = ChatColor.GREEN;
                break;
            default:
                RarityColor = ChatColor.GRAY;
                break;
        }

        return RarityColor;
    }

}

