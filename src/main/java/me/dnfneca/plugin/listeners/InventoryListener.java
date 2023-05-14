// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import java.util.List;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import me.dnfneca.plugin.utilities.GUI.LevelsMenu;
import me.dnfneca.plugin.utilities.GUI.ClassMenus;
import me.dnfneca.plugin.utilities.GUI.ReforgeMenu;
import java.util.ArrayList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.GUI.GUI;
import org.bukkit.scheduler.BukkitRunnable;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.Listener;

public class InventoryListener implements Listener
{
    @EventHandler
    public void onInventoryEvent(final InventoryCloseEvent e) {
        final Player p = (Player)e.getPlayer();
        final String title = p.getOpenInventory().getTitle();
        if (title.contains("Choose a Class") || title.contains("Choose a Mage Subclass") || title.contains("Choose a Warrior Subclass") || title.contains("Choose a Ranger Subclass") || title.contains("Are you sure. Confirm your class")) {
            for (final PlayerStats player : PlayerJoin.Players) {
                if (player.getUUID().equals(e.getPlayer().getUniqueId()) && player.getChoiceCD() == 0) {
                    new BukkitRunnable() {
                        public void run() {
                            p.sendMessage("Are you sure you don't want to select a class?");
                            InventoryListener.this.setClass(p, "none");
                            GUI.ChooseClassesMenu(p);
                        }
                    }.runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), 5L);
                }
            }
        }
    }
    
    @EventHandler
    public void onInventoryEvent(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        final List<String> lore = new ArrayList<String>();
        Inventory inv = e.getInventory();
        ItemStack ClickedItem = null;
        try {
            ClickedItem = e.getCurrentItem();
        }
        catch (Error error) {
            System.out.println(error);
        }
        if (ClickedItem == null) {
            return;
        }
        if (ClickedItem != null && ClickedItem.getItemMeta() != null) {
            if (ClickedItem.getItemMeta().getDisplayName().contains(":") || ClickedItem.getItemMeta().getDisplayName().contains("   ") || ClickedItem.getItemMeta().getDisplayName().contains("Can't reforge this") || ClickedItem.getItemMeta().getDisplayName().contains("Level Progress")) {
                e.setCancelled(true);
                return;
            }
            if (ClickedItem.getItemMeta().getDisplayName().contains("To Forge")) {
                ReforgeMenu.Open(p);
            }
            final PlayerStats playerStats = PlayerStats.getPlayerStats(p.getUniqueId());
            if (e.getView().getTitle().contains("Choose a Class")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Mage")) {
                    e.setCancelled(true);
                    GUI.MageSubclassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Warrior")) {
                    e.setCancelled(true);
                    GUI.WarriorSubclassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Ranger")) {
                    e.setCancelled(true);
                    GUI.RangerSubclassMenu(p);
                }
            }
            else if (e.getView().getTitle().contains("Main Menu")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Class")) {
                    e.setCancelled(true);
                    ClassMenus.ClassMenu(p, this.getClass(p));
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Levels")) {
                    e.setCancelled(true);
                    LevelsMenu.LevelsMenu(p);
                }
            }
            else if (e.getView().getTitle().contains("Choose a Mage Subclass")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Battle Mage")) {
                    e.setCancelled(true);
                    this.setClass(p, "Battle Mage");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Wizard")) {
                    e.setCancelled(true);
                    this.setClass(p, "Wizard");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Healer")) {
                    e.setCancelled(true);
                    this.setClass(p, "Healer");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Necromancer")) {
                    e.setCancelled(true);
                    this.setClass(p, "Necromancer");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
                    e.setCancelled(true);
                    GUI.ChooseClassesMenu(p);
                    this.setClass(p, "none");
                }
            }
            else if (e.getView().getTitle().contains("Choose a Warrior Subclass")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Barbarian")) {
                    e.setCancelled(true);
                    System.out.println("Barbarian");
                    p.sendMessage("Barbarian");
                    this.setClass(p, "Barbarian");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Samurai")) {
                    e.setCancelled(true);
                    this.setClass(p, "Samurai");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Paladin")) {
                    e.setCancelled(true);
                    this.setClass(p, "Paladin");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Viking")) {
                    e.setCancelled(true);
                    this.setClass(p, "Viking");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
                    e.setCancelled(true);
                    GUI.ChooseClassesMenu(p);
                    this.setClass(p, "none");
                }
            }
            else if (e.getView().getTitle().contains("Choose a Ranger Subclass")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Sniper")) {
                    e.setCancelled(true);
                    this.setClass(p, "Sniper");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Hunter")) {
                    e.setCancelled(true);
                    this.setClass(p, "Hunter");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Scout")) {
                    e.setCancelled(true);
                    this.setClass(p, "Scout");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Assassin")) {
                    e.setCancelled(true);
                    this.setClass(p, "Assassin");
                    GUI.MenuChoice(p);
                    GUI.areYouSureClassMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
                    e.setCancelled(true);
                    GUI.ChooseClassesMenu(p);
                    this.setClass(p, "none");
                }
            }
            else if (e.getView().getTitle().contains("Are you sure. Confirm your class")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Yes (You can't choose a different class on this profile)")) {
                    e.setCancelled(true);
                    this.setClass(p, this.getClass(p));
                    GUI.MenuChoice(p);
                    p.closeInventory();
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("No")) {
                    e.setCancelled(true);
                    this.setClass(p, "none");
                    GUI.MenuChoice(p);
                    GUI.ChooseClassesMenu(p);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Yes")) {
                    e.setCancelled(true);
                    GUI.MenuChoice(p);
                    final ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
                    final ItemMeta meta2 = blue_glass.getItemMeta();
                    meta2.setDisplayName("   ");
                    blue_glass.setItemMeta(meta2);
                    final ItemStack yes = new ItemStack(Material.GREEN_CONCRETE, 1);
                    final ItemStack no = new ItemStack(Material.RED_CONCRETE, 1);
                    final ItemMeta yesmeta = yes.getItemMeta();
                    yesmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                    yesmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
                    yes.setItemMeta(yesmeta);
                    final ItemMeta nometa = no.getItemMeta();
                    nometa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                    nometa.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
                    no.setItemMeta(nometa);
                    inv = Bukkit.createInventory((InventoryHolder)null, 27, "Are you sure. Confirm your class");
                    for (int i = 0; i < 27; ++i) {
                        if (i == 11) {
                            inv.setItem(i, yes);
                        }
                        else if (i == 15) {
                            inv.setItem(i, no);
                        }
                        else {
                            inv.setItem(i, blue_glass);
                        }
                    }
                    p.openInventory(inv);
                }
            }
            else if (e.getView().getTitle().contains("Class Specific Stats")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Battle Mage") || ClickedItem.getItemMeta().getDisplayName().contains("Wizard") || ClickedItem.getItemMeta().getDisplayName().contains("Healer") || ClickedItem.getItemMeta().getDisplayName().contains("Necromancer")) {
                    e.setCancelled(true);
                    ClassMenus.ClassMenu(p, playerStats.getPlayerClass().replace("\"", ""));
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Barbarian") || ClickedItem.getItemMeta().getDisplayName().contains("Samurai") || ClickedItem.getItemMeta().getDisplayName().contains("Paladin") || ClickedItem.getItemMeta().getDisplayName().contains("Viking")) {
                    e.setCancelled(true);
                    ClassMenus.ClassMenu(p, playerStats.getPlayerClass().replace("\"", ""));
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("Sniper") || ClickedItem.getItemMeta().getDisplayName().contains("Hunter") || ClickedItem.getItemMeta().getDisplayName().contains("Scout") || ClickedItem.getItemMeta().getDisplayName().contains("Assassin")) {
                    e.setCancelled(true);
                    ClassMenus.ClassMenu(p, playerStats.getPlayerClass().replace("\"", ""));
                }
            }
            else if (e.getView().getTitle().contains("Crafting Table")) {
                if (ClickedItem.getItemMeta().getDisplayName().contains("Your recipe will appear here")) {
                    e.setCancelled(true);
                }
                else if (ClickedItem.getItemMeta().getDisplayName().contains("To Forge Menu")) {
                    ReforgeMenu.Open(p);
                }
            }
            if (ClickedItem.getItemMeta().getDisplayName().contains("Menu")) {
                e.setCancelled(true);
                GUI.MainMenu(p);
            }
            else if (ClickedItem.getItemMeta().getDisplayName().contains("Stats")) {
                e.setCancelled(true);
                GUI.StatsMenu(p);
            }
            else if (ClickedItem.getItemMeta().getDisplayName().contains("Back to Main Menu")) {
                e.setCancelled(true);
                GUI.MainMenu(p);
            }
            else if (ClickedItem.getItemMeta().getDisplayName().contains("Class")) {
                e.setCancelled(true);
            }
        }
    }
    
    public void setClass(final Player p, final String Class) {
        for (final PlayerStats player : PlayerJoin.Players) {
            if (player.getUUID().toString().equals(p.getUniqueId().toString())) {
                player.setClass(Class);
            }
        }
    }
    
    public String getClass(final Player p) {
        for (final PlayerStats player : PlayerJoin.Players) {
            if (player.getUUID().toString().equals(p.getUniqueId().toString())) {
                return player.getPlayerClass();
            }
        }
        return null;
    }
}
