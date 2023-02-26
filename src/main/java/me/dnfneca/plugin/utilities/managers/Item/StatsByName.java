package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.utilities.inventory.ItemStats;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.dnfneca.plugin.utilities.managers.Item.RegisterItem.RegisteredItems;

public class StatsByName {
    static int i = 0;
    public static final String[] RegisteredItemsStats = new String[1000];

    public static void SetStats(String ItemName, String[] ItemStats) {
        i = 0;
        for (String s : RegisteredItems) {
            i++;
            if(ItemName.contains(s) || s.contains(ItemName)) {
                break;
            }
        }
        int laststat = i * 10, firststat, statI = 0, currentstat;
        if(i == 1) {
            laststat --;
            firststat = laststat - 9;
        } else {
            firststat = laststat - 10;
            laststat --;
        }
        currentstat = firststat;
        while ( currentstat <= laststat ) {
//            System.out.println(currentstat);
//            System.out.println(statI);
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
        int laststat = i * 10, firststat, statI = 0, currentstat;
        if (i == 1) {
            laststat--;
            firststat = laststat - 9;
        } else {
            firststat = laststat - 10;
            laststat--;
        }
        currentstat = firststat;
        while (currentstat <= laststat) {
            currentstat++;
        }
    }
    public static String[] GetStatsString(String ItemName) {
        String[] Stats = new String[10];
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
        int laststat = i * 10, firststat, statI = 0, currentstat;
        firststat = laststat - 10;
        laststat--;
        currentstat = firststat;
        while (currentstat <= laststat) {
            Stats[statI] = RegisteredItemsStats[currentstat];
            currentstat++;
            statI ++;
        }
        return Stats;
    }
    public static void SetItemStatsLore(int ItemSlot, Player player) {
        ItemStack itemStack = player.getInventory().getItem(ItemSlot);
        String ItemName = itemStack.getItemMeta().getDisplayName();
        ArrayList<String> Lore = new ArrayList<>(10);
        String[] ItemStats1 = GetStatsString(ItemName);
        i = 0;
        String Type = null;
        for (i = 0; i < 10; i++) {
            if (ItemStats1 != null && ItemStats1[i] != null) {
                //            health
                //            damage
                //            defence
                //            strength
                //            mana +
                //            critdamage
                //            critchance
                //            heal per second
                //            Mana Cost
                switch (i) {
                    case 0 -> Type = "Health: ";
                    case 1 -> Type = "Damage: ";
                    case 2 -> Type = "Defence: ";
                    case 3 -> Type = "Strength: ";
                    case 4 -> Type = "Mana: ";
                    case 5 -> Type = "Crit Damage: ";
                    case 6 -> Type = "Crit Chance: ";
                    case 7 -> Type = "HPS: ";

                }
                if (player == null) {
                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i]);
                } else {
                    if (i < 7 && (!(ItemStats.WeaponReforge(player, ItemSlot)[i].equals("0")))) {
                        if (!(ItemStats.WeaponReforge(player, ItemSlot)[i].equals("0"))) {
                            if (Integer.parseInt(ItemStats.WeaponReforge(player, ItemSlot)[i]) < 0) {
                                if(i == 5 || i == 6) {
                                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i] + ChatColor.GRAY + " (" + ChatColor.RED + ItemStats.WeaponReforge(player, ItemSlot)[i] + "%" + ChatColor.GRAY + ")");
                                } else {
                                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + ItemStats1[i] + ChatColor.GRAY + " (" + ChatColor.RED + ItemStats.WeaponReforge(player, ItemSlot)[i] + ChatColor.GRAY + ")");
                                }
                            } else {
                                if(i == 5 || i == 6) {
                                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + ItemStats1[i] + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ItemStats.WeaponReforge(player, ItemSlot)[i] + "%" + ChatColor.GRAY + ")");
                                } else {
                                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + ItemStats1[i] + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ItemStats.WeaponReforge(player, ItemSlot)[i] + ChatColor.GRAY + ")");
                                }
                            }
                        }
                    } else if (!(ItemStats1[i].equals("0")) && i < 7) {
                        if (Integer.parseInt(ItemStats.WeaponReforge(player, ItemSlot)[i]) < 0) {
                            if(i == 5 || i == 6) {
                                Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i] + "%");
                            } else {
                                Lore.add(ChatColor.GRAY + Type + ChatColor.RED + ItemStats1[i]);
                            }
                        } else {
                            if(i == 5 || i == 6) {
                                Lore.add(ChatColor.GRAY + Type + ChatColor.RED + ItemStats1[i] + "%");
                            } else {
                                Lore.add(ChatColor.GRAY + Type + ChatColor.RED + ItemStats1[i]);
                            }
                        }
                    }
                }
            }
        }
        if (!(Lore.isEmpty())) {
            ItemMeta item = itemStack.getItemMeta();
            Lore.add("");
            Lore.add(ItemRarity(itemStack, ItemStats1[9]));
            item.setLore(Lore);
            item.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_DYE, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON);
            itemStack.setItemMeta(item);
            ItemNameColour(itemStack, ItemStats1[9]);
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
                case "Exotic":
                    Rarity = ChatColor.LIGHT_PURPLE + Rarity;
                    itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ItemName);
            }

            item.setItemMeta(itemMeta);
        }
        return Rarity;
    }
    public static void ItemNameColour(ItemStack item, String Rarity) {
        ArrayList<String> Lore = new ArrayList<>(7);
        String ItemName = item.getItemMeta().getDisplayName();
        ItemMeta itemMeta = item.getItemMeta();

        String ItemName2 = "" + ItemName.substring(2);

        if(ItemName2.contains("Smart Wise")) {
            ItemName2 = ItemName2.replace("Smart", "");
            ItemName = "Very" + ItemName2;
        }
//        System.out.println(ItemName);

        switch (Rarity) {
            case "Uncommon" -> itemMeta.setDisplayName(ChatColor.GREEN + ItemName);
            case "Rare" -> itemMeta.setDisplayName(ChatColor.BLUE + ItemName);
            case "Epic" -> itemMeta.setDisplayName(ChatColor.DARK_PURPLE + ItemName);
            case "Legendary" -> itemMeta.setDisplayName(ChatColor.GOLD + ItemName);
            case "Mythic" -> itemMeta.setDisplayName(ChatColor.DARK_RED + ItemName);
            case "Exotic" -> itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ItemName);
            default -> itemMeta.setDisplayName(ChatColor.GRAY + ItemName);
        }
            item.setItemMeta(itemMeta);
    }
}
