package me.dnfneca.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            p.sendMessage(ChatColor.GREEN + "Opening vote menu!");

            try {
                Inventory inv = Bukkit.createInventory(null, 54 , "Pog");

                List<String> lore = new ArrayList<String>();
                for(int i = 1; i < 9; i++) {
                    ItemStack empty = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
                    ItemMeta emptyMeta = empty.getItemMeta();
                    lore.add(ChatColor.DARK_PURPLE + " ");
                    emptyMeta.setLore(lore);
                    empty.setItemMeta(emptyMeta);
                    inv.addItem(empty);
                }
                ItemStack clay = new ItemStack(Material.CLAY, 1);
                ItemMeta clayMeta = clay.getItemMeta();
                lore.add(ChatColor.DARK_PURPLE + "Staff");
                clayMeta.setLore(lore);
                clay.setItemMeta(clayMeta);
                inv.addItem(clay);


                p.openInventory(inv);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }
}
