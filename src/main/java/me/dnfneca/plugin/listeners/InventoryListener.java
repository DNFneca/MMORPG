package me.dnfneca.plugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.bukkit.Material.CLAY;

public class InventoryListener implements Listener {

    @EventHandler
    public void onItemUse(InventoryEvent e) {
                System.out.println(e);
    }

    @EventHandler
    public void onInventoryEvent(InventoryClickEvent e) {
        HumanEntity p = e.getWhoClicked();
        List<String> lore = new ArrayList<String>();
//        System.out.println(e.getCurrentItem().getItemMeta().lore());

        @Nonnull ItemStack ClickedItem = Objects.requireNonNull(e.getCurrentItem());
        if (ClickedItem != null) {
            if (ClickedItem.getItemMeta().hasLore() != false) {


                //                             Code for an item named "staff"


                if (ClickedItem.getItemMeta().getLore().toString().toLowerCase().contains("staff")) {
                    p.sendMessage("HOI HOI HOE");
//                System.out.println(p.getAttackCooldown());
                    MainMenu(e);
                } else if (ClickedItem.getItemMeta().getLore().toString().toLowerCase().contains(" ")) {
                    p.sendMessage("Empty");
//                System.out.println(p.getAttackCooldown());
                }
//            System.out.println(lore);
//            System.out.println(ClickedItem.getItemMeta().getLore());
                p.sendMessage(ClickedItem.getItemMeta().getLore().toString().toLowerCase());
//            System.out.println(ClickedItem.getItemMeta().getLore().toString().toLowerCase());


            }
        }
    }
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        Player p = (Player) e.getPlayer();
        p.sendMessage(p.getDisplayName());
        p.setNoDamageTicks(1000);
    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        p.sendMessage(p.getDisplayName());
        p.setNoDamageTicks(0);
    }
    public void MainMenu(InventoryClickEvent e) {
        HumanEntity p = e.getWhoClicked();
        List<String> lore = new ArrayList<String>();


        Inventory inv = Bukkit.createInventory(null, 54, "Main Menu");


        ItemStack clay = new ItemStack(CLAY, 64);
        ItemMeta clayMeta = clay.getItemMeta();
        lore.add(ChatColor.DARK_PURPLE + "Staff");
        clayMeta.setLore(lore);
        clay.setItemMeta(clayMeta);
        inv.addItem(clay);
        p.openInventory(inv);
    }
}
