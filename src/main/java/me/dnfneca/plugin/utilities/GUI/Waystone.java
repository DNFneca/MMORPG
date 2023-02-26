package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Waystone {
    public static void WaystoneMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "Stats");

        ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);

        SkullMeta healthdata = (SkullMeta) purple_glass.getItemMeta();
        healthdata.setOwningPlayer(p);
        healthdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        healthdata.setDisplayName(ChatColor.GRAY + " E " );
        purple_glass.setItemMeta(healthdata);
        p.openInventory(inv);
    }
    // TODO make a system to determine what waystones the player has unlocked, the location the unlocked them from, make it in a matrix!
}
