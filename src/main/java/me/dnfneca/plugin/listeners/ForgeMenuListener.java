package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.inventory.ItemStats;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.dnfneca.plugin.listeners.PlayerJoin.plugin;
import static me.dnfneca.plugin.utilities.managers.Item.RegisterItem.RegisteredItems;
import static me.dnfneca.plugin.utilities.managers.Item.StatsByName.*;

public class ForgeMenuListener implements Listener {


    @EventHandler
    public void onInventoryEvent(InventoryClickEvent e) {
        String InventoryName = e.getView().getTitle();
        if(!(InventoryName.contains("Forge Menu"))) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        List<String> lore = new ArrayList<>();
        Inventory inv = e.getInventory();
        @Nonnull ItemStack ClickedItem = null;

        try {
            ClickedItem = Objects.requireNonNull(e.getCurrentItem());
        } catch (Error error) {
            System.out.println(error);
        } if(ClickedItem == null) {
            return;
        }


        new BukkitRunnable() {
            @Override
            public void run() {
                boolean isRegistered = false;

                if(!(InventoryName.contains("Forge Menu"))) {
                    return;
                }
                if(e.getViewers().equals(new ArrayList<>())) {
                    return;
                }
                ItemStack reforgable_item = e.getInventory().getItem(11);
                if (reforgable_item == null) return;

                for (String s : RegisteredItems) {
                    if (s != null) {
                        if (reforgable_item.getItemMeta().getDisplayName().contains(s)) {
                            isRegistered = true;
                            break;
                        }

                    } else return;
                }
                if(!isRegistered) return;
                ItemStack reforged_item = reforgable_item.clone();
                ItemMeta reforged_item_data = reforged_item.getItemMeta();
                reforged_item_data.setDisplayName("Strong " + reforged_item.getItemMeta().getDisplayName());
                reforged_item.setItemMeta(reforged_item_data);

                if(e.getInventory().getItem(15).getItemMeta().getDisplayName().contains("Strength")) {
                    e.getInventory().setItem(40, reforged_item);
                }
                SetItemStatsLoreInMenu(40, p);

            }
        }.runTaskTimer(plugin , 0L, 20L);

        if(e.getSlot() == 40 && e.getCurrentItem().getType() != Material.BARRIER) {
            e.getInventory().setItem(11, new ItemStack(Material.AIR, 1));
            e.getInventory().setItem(15, new ItemStack(Material.AIR, 1));
        }



    }

    @EventHandler
    public void onForgeMenuClose(InventoryCloseEvent e) {
        if(e.getView().getTitle().contains("Forge Menu")) {
            PlayerInventory playerInv = e.getPlayer().getInventory();
            e.getPlayer().getInventory().addItem(e.getInventory().getItem(11));
        }
    }

    public static void SetItemStatsLoreInMenu(int ItemSlot, Player player) {
        ItemStack itemStack = player.getOpenInventory().getItem(ItemSlot);
        String ItemName = itemStack.getItemMeta().getDisplayName();
        ArrayList<String> Lore = new ArrayList<>(10);
        String[] ItemStats1 = GetStatsString(ItemName);
        int i = 0;
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
                                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i] + ChatColor.GRAY + " (" + ChatColor.RED + ItemStats.WeaponReforge(player, ItemSlot)[i] + ChatColor.GRAY + ")");
                                }
                            } else {
                                if(i == 5 || i == 6) {
                                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i] + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ItemStats.WeaponReforge(player, ItemSlot)[i] + "%" + ChatColor.GRAY + ")");
                                } else {
                                    Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i] + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ItemStats.WeaponReforge(player, ItemSlot)[i] + ChatColor.GRAY + ")");
                                }
                            }
                        }
                    } else if (!(ItemStats1[i].equals("0")) && i < 7) {
                        if (Integer.parseInt(ItemStats.WeaponReforge(player, ItemSlot)[i]) < 0) {
                            if(i == 5 || i == 6) {
                                Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i] + "%");
                            } else {
                                Lore.add(ChatColor.GRAY + Type + ChatColor.RED + "+" + ItemStats1[i]);
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

}
