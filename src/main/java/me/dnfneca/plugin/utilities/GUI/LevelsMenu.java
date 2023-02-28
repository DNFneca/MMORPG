package me.dnfneca.plugin.utilities.GUI;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelsMenu {
    public static void LevelsMenu(Player p){
        List<String> lore = new ArrayList<>();


        Inventory inv = Bukkit.createInventory(null, 27, "Crafting Table");

        ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemStack level = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);


        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        ItemMeta arrowmeta = arrow.getItemMeta();
        arrowmeta.setDisplayName(ChatColor.GRAY + "To Forge");
        arrow.setItemMeta(arrowmeta);




        ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);

        int playerLevel = PlayerLevels.getLevel(p);
        int leftXp = PlayerLevels.getLeftXp(p);
        int levelXp = PlayerLevels.getLevelXp(p);
        int currentLevelXp = levelXp-leftXp;


        int valueOfSlot = levelXp/10;
        int numOfSlots = 10;


        ItemMeta levelData = level.getItemMeta();
        ArrayList<String> levelLore = new ArrayList<>();
        String[] test = new String[10];

        for(int i = 0; i<numOfSlots; i++) {
            if(valueOfSlot*i < currentLevelXp) {
                test[i] = ChatColor.GREEN + "||";
            } else {
                test[i] = ChatColor.GRAY + "||";
            }
        }
        levelLore.add(ChatColor.BLUE + "Level " + playerLevel + " : " + Arrays.toString(test).replace("[", "").replace("]", "").replace(",", "") + " " + (playerLevel + 1));
        levelLore.add(leftXp + ", " + valueOfSlot + ", " + currentLevelXp);
        levelData.setDisplayName(ChatColor.GREEN + "Level Progress");
        levelData.setLore(levelLore);
        level.setItemMeta(levelData);


        for(int i = 0; i <= 26; i++) {
            if(i == 13){
                inv.setItem(i, level);
            } else {
                inv.setItem(i, blue_glass);
            }
        }
//        ItemStack clay = new ItemStack(CLAY, 64);
//        ItemMeta clayMeta = clay.getItemMeta();
//        lore.add(ChatColor.DARK_PURPLE + "Staff");
//        clayMeta.setLore(lore);
//        clay.setItemMeta(clayMeta);
//        inv.addItem(clay);
        p.openInventory(inv);
    }
}
