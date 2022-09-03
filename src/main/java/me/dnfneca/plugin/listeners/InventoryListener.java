package me.dnfneca.plugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.dnfneca.plugin.utilities.GUI.GUI.MainMenu;
import static me.dnfneca.plugin.utilities.GUI.GUI.StatsMenu;

public class InventoryListener implements Listener {

    @EventHandler
    public void onItemUse(InventoryEvent e) {
                System.out.println(e);
    }

    @EventHandler
    public void onInventoryEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        List<String> lore = new ArrayList<String>();
//        System.out.println(e.getCurrentItem().getItemMeta().lore());
//        System.out.println(p);
        @Nonnull ItemStack ClickedItem = Objects.requireNonNull(e.getCurrentItem());
        if (ClickedItem != null) {
            if (ClickedItem.getItemMeta() !=null) {
//                System.out.println(ClickedItem);

                //                             Code for an item named "staff"


                if (ClickedItem.getItemMeta().getDisplayName().contains("Menu")) {
//                    p.sendMessage("HOI HOI HOE");
//                System.out.println(p.getAttackCooldown());
                    e.setCancelled(true);

                    MainMenu(p);
                } else if(ClickedItem.getItemMeta().getDisplayName().contains("   ")) {
                    e.setCancelled(true);
                } else if(ClickedItem.getItemMeta().getDisplayName().contains("Stats")) {
                    e.setCancelled(true);

                    StatsMenu(p);
                }
//            System.out.println(lore);
//            System.out.println(ClickedItem.getItemMeta().getLore());
//                p.sendMessage(ClickedItem.getItemMeta().getLore().toString().toLowerCase());
//            System.out.println(ClickedItem.getItemMeta().getLore().toString().toLowerCase());

            }
        }
    }
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        Player p = (Player) e.getPlayer();
//        System.out.println(p.getInventory());
//        p.sendMessage(p.getDisplayName());
//        p.setNoDamageTicks(1000);
    }
    @EventHandler
    public void onInventoryClose(InventoryEvent e) {
//        Player p = (Player) e.;
//        p.sendMessage(p.getDisplayName());
//        p.setNoDamageTicks(0);
        ItemStack[] Items = e.getInventory().getContents();
//        System.out.println(Arrays.toString(Items));
        for (ItemStack i: Items) {
//            System.out.println(i.getItemMeta());
        }
    }
}
