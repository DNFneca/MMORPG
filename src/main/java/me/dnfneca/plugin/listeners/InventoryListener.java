package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.GUI.ClassMenus;
import me.dnfneca.plugin.utilities.classes.AssignClass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.dnfneca.plugin.utilities.GUI.GUI.*;

public class InventoryListener implements Listener {


    @EventHandler
    public void onInventoryEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        List<String> lore = new ArrayList<>();
        Inventory inv = e.getInventory();

        @Nonnull ItemStack ClickedItem = Objects.requireNonNull(e.getCurrentItem());
        if (ClickedItem != null) {
            if (ClickedItem.getItemMeta() !=null) {
//                System.out.println(ClickedItem);


                  if(ClickedItem.getItemMeta().getDisplayName().contains(":") || ClickedItem.getItemMeta().getDisplayName().contains("   ")) {
                    e.setCancelled(true);
                    return;
                  }

                NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");
                PersistentDataContainer playerData = p.getPersistentDataContainer();


                if(e.getView().getTitle().contains("Choose a Class")) {
                     if (ClickedItem.getItemMeta().getDisplayName().contains("Mage")) {
                        e.setCancelled(true);

                        MageSubclassMenu(p);
                     } else if (ClickedItem.getItemMeta().getDisplayName().contains("Warrior")) {
                         e.setCancelled(true);

                         WarriorSubclassMenu(p);
                     } else if (ClickedItem.getItemMeta().getDisplayName().contains("Ranger")) {
                         e.setCancelled(true);

                         RangerSubclassMenu(p);
                     }
                } else if(e.getView().getTitle().contains("Main Menu")) {
                    if (ClickedItem.getItemMeta().getDisplayName().contains("Class")) {
                        e.setCancelled(true);

                        ClassMenus.ClassMenu(p, playerData.get(key, PersistentDataType.INTEGER));
                    }
                } else if (e.getView().getTitle().contains("Choose a Mage Subclass")) {
                    if (ClickedItem.getItemMeta().getDisplayName().contains("Battle Mage")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 1);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Wizard")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 2);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Healer")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 3);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Necromancer")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 4);
                    }
                } else if (e.getView().getTitle().contains("Choose a Warrior Subclass")) {
                    if (ClickedItem.getItemMeta().getDisplayName().contains("Barbarian")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 5);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Samurai")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 6);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Paladin")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 7);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Viking")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 8);
                    }
                } else if (e.getView().getTitle().contains("Choose a Ranger Subclass")) {
                    if (ClickedItem.getItemMeta().getDisplayName().contains("Sniper")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 9);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Hunter")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 10);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Scout")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 11);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Assassin")) {
                        e.setCancelled(true);

                        AssignClass.set(p, 12);
                    }
                } else if (e.getView().getTitle().contains("Are you sure. Confirm")) {
                    if (ClickedItem.getItemMeta().getDisplayName().contains("Yes (You can't choose a different class on this profile)")) {

                        e.setCancelled(true);

                        playerData.set(key, PersistentDataType.INTEGER, p.getScoreboard().getObjective("Stats").getScore("Class").getScore());

                        p.closeInventory();

                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("No")) {
                        e.setCancelled(true);

                        ChooseClassesMenu(p);
                    } else if (ClickedItem.getItemMeta().getDisplayName().contains("Yes")) {
                        e.setCancelled(true);

                        ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);

                        ItemStack yes = new ItemStack(Material.GREEN_CONCRETE, 1);
                        ItemStack no = new ItemStack(Material.RED_CONCRETE, 1);


                        ItemMeta yesmeta = yes.getItemMeta();
                        yesmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        yesmeta.setDisplayName(ChatColor.GREEN + "Yes (You can't choose a different class on this profile)");
                        yes.setItemMeta(yesmeta);

                        ItemMeta nometa = no.getItemMeta();
                        nometa.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
                        nometa.setDisplayName(ChatColor.GOLD + "No");
                        no.setItemMeta(nometa);

                        inv = Bukkit.createInventory(null, 27, "Are you sure. Confirm");

                        for (int i = 0; i < 27; i++) {
                            if (i == 11) {
                                inv.setItem(i, yes);
                            } else if (i == 15) {
                                inv.setItem(i, no);
                            } else {
                                inv.setItem(i, blue_glass);
                            }
                        }
                        p.openInventory(inv);
                    }
                }

                //                             Code for an item named "staff"


                if (ClickedItem.getItemMeta().getDisplayName().contains("Menu")) {
//                    p.sendMessage("HOI HOI HOE");
//                System.out.println(p.getAttackCooldown());
                    e.setCancelled(true);

                    MainMenu(p);
                } else if(ClickedItem.getItemMeta().getDisplayName().contains("Stats")) {
                    e.setCancelled(true);

                    StatsMenu(p);
                } else if(ClickedItem.getItemMeta().getDisplayName().contains("Back to Main Menu")) {
                    e.setCancelled(true);

                    MainMenu(p);
                } else if (ClickedItem.getItemMeta().getDisplayName().contains("Class")) {
                    e.setCancelled(true);


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
