package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.dnfneca.plugin.utilities.managers.Item.RegisterItem.RegisteredItems;

public class StatsByName {
    static int i = 0;
    public static final String[] RegisteredItemsStats = new String[700];

    public static void SetStats(String ItemName, String[] ItemStats) {
        i = 0;
        for (String s : RegisteredItems) {
            i++;
            if(s.equals(ItemName)) {
                break;
            }
        }
        int laststat = i * 7, firststat, statI = 0, currentstat;
        if(i == 1) {
            laststat --;
            firststat = laststat - 6;
        } else {
            firststat = laststat - 7;
        }
        currentstat = firststat;
        while ( currentstat <= laststat ) {
            RegisteredItemsStats[currentstat] = ItemStats[statI];
            currentstat ++;
            statI ++;
        }
    }

    public static void GetStats(String ItemName) {
        i = 0;
        for (String s : RegisteredItems) {
            i++;
            if (s == null)
                break;
            if (s.equals(ItemName)) {
//                System.out.println(s);
                break;
            }
        }
        int laststat = i * 7, firststat, statI = 0, currentstat;
        if (i == 1) {
            laststat--;
            firststat = laststat - 6;
        } else {
            firststat = laststat - 7;
            laststat--;
        }
        currentstat = firststat;
        while (currentstat <= laststat) {
            currentstat++;
        }
    }
    public static String[] GetStatsString(String ItemName) {
        String[] Stats = new String[7];
        i = 0;

        for (String s : RegisteredItems) {
            i++;
            if (s != null) {
                if (ItemName.contains(s)) {
                    break;
                }
            }
        }
        if(i > 99) {
            return null;
        }
        int laststat = i * 7, firststat, statI = 0, currentstat;
        firststat = laststat - 7;
        laststat--;
        currentstat = firststat;
        while (currentstat <= laststat) {
            Stats[statI] = RegisteredItemsStats[currentstat];
            currentstat++;
            statI ++;
        }
        return Stats;
    }
    public static void SetItemStatsLore(String ItemName, ItemStack itemStack) {
        ArrayList<String> Lore = new ArrayList<>(10);
        String[] ItemStats = GetStatsString(ItemName);
        int i = 0;
        String Type = null;
        for (i = 0; i < 7; i++) {
            if(ItemStats != null) {

                switch (i) {
                    case 0 -> Type = "Health: ";
                    case 1 -> Type = "Damage: ";
                    case 2 -> Type = "Strength: ";
                    case 3 -> Type = "Crit Damage: ";
                    case 4 -> Type = "Crit Chance: ";
                }
                if(!ItemStats[i].equals("0") && i != 6) {
                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats[i]);
                }
            }
        }
        if (!(Lore.isEmpty())) {
            ItemMeta item = itemStack.getItemMeta();
            item.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_DYE, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON);
            Lore.add("");
            Lore.add(ItemRarity(itemStack, ItemStats[6]));
            item.setLore(Lore);
            itemStack.setItemMeta(item);
            ItemNameColour(itemStack, ItemStats[6]);
        }
    }
    public static String ItemRarity(ItemStack item, String Rarity) {
        ArrayList<String> Lore = new ArrayList<>(7);
        if(Rarity == null || Rarity.equals("0")) {
            return new String(ChatColor.GRAY + "Common");
        } else {
            String ItemName = item.getItemMeta().getDisplayName();
            ItemMeta itemMeta = item.getItemMeta();

            switch (Rarity) {
                case "Common":
                    Rarity = ChatColor.GRAY + Rarity;
                    itemMeta.setDisplayName(ChatColor.GRAY + ItemName);
                    break;
                case "Uncommon":
                    Rarity = ChatColor.GREEN + Rarity;
                    itemMeta.setDisplayName(ChatColor.GREEN + ItemName);
                    break;
                case "Rare":
                    Rarity = ChatColor.BLUE + Rarity;
                    itemMeta.setDisplayName(ChatColor.BLUE + ItemName);
                    break;
                case "Epic":
                    Rarity = ChatColor.DARK_PURPLE + Rarity;
                    itemMeta.setDisplayName(ChatColor.DARK_PURPLE + ItemName);
                    break;
                case "Legendary":
                    Rarity = ChatColor.GOLD + Rarity;
                    itemMeta.setDisplayName(ChatColor.GOLD + ItemName);
                    break;
                case "Mythic":
                    Rarity = ChatColor.DARK_RED + Rarity;
                    itemMeta.setDisplayName(ChatColor.DARK_RED + ItemName);
                    break;
            }
            item.setItemMeta(itemMeta);

        }
        return Rarity;
    }
    public static void ItemNameColour(ItemStack item, String Rarity) {
        ArrayList<String> Lore = new ArrayList<>(7);
        String ItemName = item.getItemMeta().getDisplayName();
        ItemMeta itemMeta = item.getItemMeta();
        switch (Rarity) {
            case "Uncommon" -> itemMeta.setDisplayName(ChatColor.GREEN + ItemName);
            case "Rare" -> itemMeta.setDisplayName(ChatColor.BLUE + ItemName);
            case "Epic" -> itemMeta.setDisplayName(ChatColor.DARK_PURPLE + ItemName);
            case "Legendary" -> itemMeta.setDisplayName(ChatColor.GOLD + ItemName);
            case "Mythic" -> itemMeta.setDisplayName(ChatColor.DARK_RED + ItemName);
            default -> itemMeta.setDisplayName(ChatColor.GRAY + ItemName);
        }
            item.setItemMeta(itemMeta);
    }
}
