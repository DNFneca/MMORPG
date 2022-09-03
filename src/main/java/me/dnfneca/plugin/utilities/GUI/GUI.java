package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {

    public static void MainMenu(Player p) {
        List<String> lore = new ArrayList<>();


        Inventory inv = Bukkit.createInventory(null, 54, "Main Menu");

        ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta data1 = purple_glass.getItemMeta();
        data1.setDisplayName("   ");
        purple_glass.setItemMeta(data1);
        ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);
        ItemMeta headdata = player_head.getItemMeta();
        headdata.setDisplayName(ChatColor.RED + "Stats");
        player_head.setItemMeta(headdata);

        for(int i = 0; i <= 53; i++) {
            if(i <= 8 || i == 11 || i == 15 || i == 20 || i == 24 || i == 36 || i == 40 || i == 44 || i == 45 || i == 49 || i == 53){
                inv.setItem(i, purple_glass);
            } else if (i == 22) {
                inv.setItem(i, player_head);
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
    public static void StatsMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "Main Menu");

        ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta data1 = purple_glass.getItemMeta();
        data1.setDisplayName("   ");
        purple_glass.setItemMeta(data1);
        ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);
        ItemMeta headdata = player_head.getItemMeta();
        headdata.setDisplayName(ChatColor.RED + "Stats");
        player_head.setItemMeta(headdata);

        for(int i = 0; i <= 53; i++) {
            if(i == 45){
                inv.setItem(i, arrow);
            } else if (i <= 2 || i == 6 || i == 7 || i == 8 || i == 9 || i == 17 || i == 18 || i == 26 || i == 27 || i > 41 || i == 35 || i == 36 || i == 37 || i == 38) {
                inv.setItem(i, purple_glass);
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
