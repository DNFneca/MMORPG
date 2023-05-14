// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import java.util.List;
import java.util.Arrays;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.ArrayList;
import org.bukkit.entity.Player;

public class LevelsMenu
{
    public static void LevelsMenu(final Player p) {
        final List<String> lore = new ArrayList<String>();
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "Crafting Table");
        final ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        final ItemStack level = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        final ItemStack arrow = new ItemStack(Material.ARROW, 1);
        final ItemMeta arrowmeta = arrow.getItemMeta();
        arrowmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
        arrow.setItemMeta(arrowmeta);
        final ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);
        final int playerLevel = PlayerLevels.getLevel(p);
        final int leftXp = PlayerLevels.getLeftXp(p);
        final int levelXp = PlayerLevels.getLevelXp(p);
        int currentLevelXp = levelXp - leftXp;
        if (currentLevelXp < 0) {
            currentLevelXp = 0;
        }
        final int valueOfSlot = levelXp / 10;
        final int numOfSlots = 10;
        final ItemMeta levelData = level.getItemMeta();
        final ArrayList<String> levelLore = new ArrayList<String>();
        final String[] test = new String[10];
        for (int i = 0; i < numOfSlots; ++i) {
            if (valueOfSlot * i < currentLevelXp) {
                test[i] = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN));
            }
            else {
                test[i] = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY));
            }
        }
        levelLore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.BLUE), playerLevel, Arrays.toString(test).replace("[", "").replace("]", "").replace(",", ""), playerLevel + 1));
        levelLore.add(invokedynamic(makeConcatWithConstants:(II)Ljava/lang/String;, leftXp, currentLevelXp));
        levelData.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
        levelData.setLore((List)levelLore);
        level.setItemMeta(levelData);
        for (int i = 0; i <= 26; ++i) {
            if (i == 13) {
                inv.setItem(i, level);
            }
            else {
                inv.setItem(i, blue_glass);
            }
        }
        p.openInventory(inv);
    }
}
