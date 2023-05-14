// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

<<<<<<< Updated upstream
=======
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
>>>>>>> Stashed changes
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

<<<<<<< Updated upstream
public class ForgeMenuListener implements Listener
{
=======
import static me.dnfneca.plugin.Plugin.CustomReforges;
import static me.dnfneca.plugin.listeners.PlayerJoin.plugin;
import static me.dnfneca.plugin.utilities.inventory.ItemStats.*;
import static me.dnfneca.plugin.utilities.managers.Item.DetermineItemAbility.getItemAbilityLore;
import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomItemByName;
import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomReforgeByName;

public class ForgeMenuListener implements Listener {


>>>>>>> Stashed changes
    @EventHandler
    public void onInventoryEvent(final InventoryClickEvent e) {
        final String InventoryName = e.getView().getTitle();
        if (!InventoryName.contains("Forge Menu")) {
            return;
        }
        final Player p = (Player)e.getWhoClicked();
        final List<String> lore = new ArrayList<String>();
        final Inventory inv = e.getInventory();
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
        new BukkitRunnable() {
            public void run() {
                final boolean isRegistered = false;
                final ItemStack none = new ItemStack(Material.BARRIER, 1);
                final ItemMeta none_meta = none.getItemMeta();
                none_meta.setDisplayName("Can't reforge this");
                none.setItemMeta(none_meta);
                if (!InventoryName.contains("Forge Menu")) {
                    return;
                }
<<<<<<< Updated upstream
                if (e.getViewers().equals(new ArrayList())) {
                    return;
                }
                final ItemStack reforgable_item = e.getInventory().getItem(11);
                if (reforgable_item == null) {
                    e.getInventory().setItem(40, none);
                }
                if (!isRegistered) {
                    e.getInventory().setItem(40, none);
                }
                if (e.getInventory().getItem(15) == null) {
                    e.getInventory().setItem(40, none);
                }
                for (final String[] s : ItemStats.RegisteredReforges) {
                    if (e.getInventory().getItem(15).getItemMeta().getDisplayName().contains(s[0])) {
                        final String[] check = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
                        final ItemStack reforged_item = reforgable_item.clone();
                        final String[] item_name = reforged_item.getItemMeta().getDisplayName().split(" ");
                        System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;, item_name[0], s[1], item_name[0].contains(s[1])));
                        if (item_name[0].contains(s[1])) {
=======
                if(e.getViewers().isEmpty()) {
                    return;
                }
                ItemStack reforgable_item = e.getInventory().getItem(11);
                if (reforgable_item == null) e.getInventory().setItem(40, none);

//                for (String s : RegisteredItems) {
//                    if (s != null) {
//                        if (reforgable_item.getItemMeta().getDisplayName().contains(s)) {
//                            isRegistered = true;
//                            break;
//                        }
//
//                    } else e.getInventory().setItem(40, none);
//                }
                if(!isRegistered) e.getInventory().setItem(40, none);


                if(e.getInventory().getItem(15) == null) {
                    e.getInventory().setItem(40, none);
                }


                for (Reforge customReforge : CustomReforges) {
                    if(e.getInventory().getItem(15).getItemMeta().getDisplayName().contains(s[0])) {
                        String[] check = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
                        ItemStack reforged_item = reforgable_item.clone();
                        String[] item_name = reforged_item.getItemMeta().getDisplayName().split(" ");
                        System.out.println(item_name[0] + " " + s[1] + " " +item_name[0].contains(s[1]));
                        if(item_name[0].contains(s[1])) {
                            e.getInventory().setItem(40, none);
                            break;
                        }
                        ItemMeta reforged_item_data = reforged_item.getItemMeta();
                        reforged_item_data.setDisplayName(s[1] + " " + reforged_item.getItemMeta().getDisplayName());
                        reforged_item.setItemMeta(reforged_item_data);
                        e.getInventory().setItem(40, reforged_item);
                        if(Arrays.equals(GetInventoryReforge(p, 40), check)) {
                            e.getInventory().setItem(40, none);
                        }
                        SetItemStatsLoreInMenu(40, p);
                    }
                }


                for (String[] s: RegisteredReforges) {
                    if(e.getInventory().getItem(15).getItemMeta().getDisplayName().contains(s[0])) {
                        String[] check = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
                        ItemStack reforged_item = reforgable_item.clone();
                        String[] item_name = reforged_item.getItemMeta().getDisplayName().split(" ");
                        System.out.println(item_name[0] + " " + s[1] + " " +item_name[0].contains(s[1]));
                        if(item_name[0].contains(s[1])) {
>>>>>>> Stashed changes
                            e.getInventory().setItem(40, none);
                            break;
                        }
                        final ItemMeta reforged_item_data = reforged_item.getItemMeta();
                        reforged_item_data.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, s[1], reforged_item.getItemMeta().getDisplayName()));
                        reforged_item.setItemMeta(reforged_item_data);
                        e.getInventory().setItem(40, reforged_item);
                        if (Arrays.equals(ForgeMenuListener.GetInventoryReforge(p, 40), check)) {
                            e.getInventory().setItem(40, none);
                        }
                        ForgeMenuListener.SetItemStatsLoreInMenu(40, p);
                    }
                }
            }
        }.runTaskTimer((Plugin)PlayerJoin.plugin, 0L, 20L);
        if (e.getSlot() == 40 && e.getCurrentItem().getType() != Material.BARRIER) {
            e.getInventory().setItem(11, new ItemStack(Material.AIR, 1));
            e.getInventory().setItem(15, new ItemStack(Material.AIR, 1));
        }
    }
    
    @EventHandler
    public void onForgeMenuClose(final InventoryCloseEvent e) {
        if (e.getView().getTitle().contains("Forge Menu")) {
            e.getPlayer().getInventory().addItem(new ItemStack[] { e.getInventory().getItem(11) });
        }
    }
<<<<<<< Updated upstream
    
    public static void SetItemStatsLoreInMenu(final int ItemSlot, final Player player) {
=======

    public static void SetItemStatsLoreInMenu(Inventory inventory, ItemMeta itemMeta, int itemSlot) {
        String itemName = ChatColor.stripColor(itemMeta.getDisplayName());
        if(itemName.contains("Menu")) {
            return;
        }
        Item item = getCustomItemByName(ChatColor.stripColor(itemName));
        ItemStack itemInQ = inventory.getItem(itemSlot);


        ChatColor color;
        if(item == null) return;
        String reforgeName = itemName.replace(item.Name, "");
        Reforge reforge = getCustomReforgeByName(reforgeName.replace(" ", ""));

        if(itemInQ != null && itemInQ.getItemMeta().hasLore() && reforge == null) {
            return;
        }

        switch (item.getRarity()) {
            case "Rare":
                color = ChatColor.BLUE;
                break;
            case "Uncommon":
                color = ChatColor.GREEN;
                break;
            case "Epic":
                color = ChatColor.DARK_PURPLE;
                break;
            case "Legendary":
                color = ChatColor.GOLD;
                break;
            case "Mythic":
                color = ChatColor.DARK_RED;
                break;
            case "Exotic":
                color = ChatColor.LIGHT_PURPLE;
                break;
            default:
                color = ChatColor.GRAY;
                break;
        }
        itemMeta.setDisplayName(color + itemMeta.getDisplayName());
        List<String> Lore = new ArrayList<>();



        if(reforge == null) {
            if(item.getHealth() > 0) {
                Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getHealth());
            } else if(item.getHealth() < 0) {
                Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.getHealth()).replace("-", ""));
            }
            if(item.getDamage() > 0) {
                Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getDamage());
            } else if(item.getDamage() < 0) {
                Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int)item.getDamage()).replace("-", ""));
            }
            if(item.getDefence() > 0) {
                Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getDefence());
            } else if(item.getDefence() < 0) {
                Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int)item.getDefence()).replace("-", ""));
            }
            if(item.getStrength() > 0) {
                Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getStrength());
            } else if(item.getStrength() < 0) {
                Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int)item.getStrength()).replace("-", ""));
            }
            if(item.getSpeed() > 0) {
                Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getSpeed());
            } else if(item.getSpeed() < 0) {
                Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.getSpeed()).replace("-", ""));
            }
            if(item.getMana() > 0) {
                Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getMana());
            } else if(item.getMana() < 0) {
                Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.getMana()).replace("-", ""));
            }
            if(item.getCritDamage() > 0) {
                Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getCritDamage());
            } else if(item.getCritDamage() < 0) {
                Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.getCritDamage()).replace("-", ""));
            }
            if(item.getCritChance() > 0) {
                Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getCritChance());
            } else if(item.getCritChance() < 0) {
                Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.getCritChance()).replace("-", ""));
            }
            if(item.getStealth() > 0) {
                Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getStealth());
            } else if(item.getStealth() < 0) {
                Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.getStealth()).replace("-", ""));
            }
        } else {
            if(reforge.getHealth() > 0) {
                if(item.getHealth() > 0) {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.getHealth() + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.getHealth() + ")");
                } else if (item.getHealth() < 0) {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.getHealth()) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.getHealth() + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GRAY + " " + (int) item.getHealth() + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.getHealth() + ")");
                }
            } else if(reforge.Health < 0) {
                if(item.Health > 0) {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Health + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Health) + ")");
                } else if (item.Health < 0) {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Health) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Health) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GRAY + " " + (int) item.Health + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Health) + ")");
                }
            } else {
                if(item.Health > 0) {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Health);
                } else if(item.Health < 0) {
                    Lore.add(ChatColor.GRAY + "Health:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.Health).replace("-", ""));
                }
            }
            if(reforge.Damage > 0) {
                if(item.Damage > 0) {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Damage + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
                } else if (item.Damage < 0) {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Damage) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Damage + ")");
                }
            } else if(reforge.Damage < 0) {
                if(item.Damage > 0) {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Damage + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Damage) + ")");
                } else if (item.Damage < 0) {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Damage) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Damage) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Damage) + ")");
                }
            } else {
                if(item.Damage > 0) {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Damage);
                } else if(item.Damage < 0) {
                    Lore.add(ChatColor.GRAY + "Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int)item.Damage).replace("-", ""));
                }
            }
            if(reforge.Defence > 0) {
                if(item.Defence > 0) {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Defence + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
                } else if (item.Defence < 0) {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Defence) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Defence + ")");
                }
            } else if(reforge.Defence < 0) {
                if(item.Defence > 0) {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Defence + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Defence) + ")");
                } else if (item.Defence < 0) {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Defence) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Defence) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Defence) + ")");
                }
            } else {
                if(item.Defence > 0) {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Defence);
                } else if(item.Defence < 0) {
                    Lore.add(ChatColor.GRAY + "Defence:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int)item.Defence).replace("-", ""));
                }
            }
            if(reforge.Strength > 0) {
                if(item.Strength > 0) {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Strength + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
                } else if (item.Strength < 0) {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Strength) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Strength + ")");
                }
            } else if(reforge.Strength < 0) {
                if(item.Strength > 0) {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Strength + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Strength) + ")");
                } else if (item.Strength < 0) {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Strength) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Strength) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Strength) + ")");
                }
            } else {
                if(item.Strength > 0) {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Strength);
                } else if(item.Strength < 0) {
                    Lore.add(ChatColor.GRAY + "Strength:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int)item.Strength).replace("-", ""));
                }
            }
            if(reforge.Speed > 0) {
                if(item.Speed > 0) {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Speed + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
                } else if (item.Speed < 0) {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Speed) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Speed + ")");
                }
            } else if(reforge.Speed < 0) {
                if(item.Speed > 0) {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Speed + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Speed) + ")");
                } else if (item.Speed < 0) {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Speed) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Speed) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Speed) + ")");
                }
            } else {
                if(item.Speed > 0) {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Speed);
                } else if(item.Speed < 0) {
                    Lore.add(ChatColor.GRAY + "Speed:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.Speed).replace("-", ""));
                }
            }
            if(reforge.Mana > 0) {
                if(item.Mana > 0) {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Mana + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
                } else if (item.Mana < 0) {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Mana) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Mana + ")");
                }
            } else if(reforge.Mana < 0) {
                if(item.Mana > 0) {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Mana + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Mana) + ")");
                } else if (item.Mana < 0) {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Mana) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Mana) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Mana) + ")");
                }
            } else {
                if(item.Mana > 0) {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Mana);
                } else if(item.Mana < 0) {
                    Lore.add(ChatColor.GRAY + "Mana:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.Mana).replace("-", ""));
                }
            }
            if(reforge.CritDamage > 0) {
                if(item.CritDamage > 0) {
                    Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritDamage + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
                } else if (item.CritDamage < 0) {
                    Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritDamage) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritDamage + ")");
                }
            } else if(reforge.CritDamage < 0) {
                if(item.CritDamage > 0) {
                    Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritDamage + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.CritDamage) + ")");
                } else if (item.CritDamage < 0) {
                    Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritDamage) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.CritDamage) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "CritDamage:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.CritDamage) + ")");
                }
            } else {
                if(item.CritDamage > 0) {
                    Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritDamage);
                } else if(item.CritDamage < 0) {
                    Lore.add(ChatColor.GRAY + "Critical Damage:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.CritDamage).replace("-", ""));
                }
            }
            if(reforge.CritChance > 0) {
                if(item.CritChance > 0) {
                    Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritChance + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
                } else if (item.CritChance < 0) {
                    Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritChance) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.CritChance + ")");
                }
            } else if(reforge.CritChance < 0) {
                if(item.CritChance > 0) {
                    Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritChance + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.CritChance) + ")");
                } else if (item.CritChance < 0) {
                    Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.CritChance) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.CritChance) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "CritChance:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.CritChance) + ")");
                }
            } else {
                if(item.CritChance > 0) {
                    Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.CritChance);
                } else if(item.CritChance < 0) {
                    Lore.add(ChatColor.GRAY + "Critical Chance:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.CritChance).replace("-", ""));
                }
            }
            if(reforge.Stealth > 0) {
                if(item.Stealth > 0) {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Stealth + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
                } else if (item.Stealth < 0) {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Stealth) + ChatColor.GRAY + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.GREEN + "+" + ChatColor.GRAY + (int) reforge.Stealth + ")");
                }
            } else if(reforge.Stealth < 0) {
                if(item.Stealth > 0) {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Stealth + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Stealth) + ")");
                } else if (item.Stealth < 0) {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + (int) (-1 * item.Stealth) + ChatColor.GRAY + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Stealth) + ")");
                } else {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GRAY + " " + 0 + " (" + ChatColor.RED + " -" + ChatColor.GRAY + (int) ( -1 * item.Stealth) + ")");
                }
            } else {
                if(item.Stealth > 0) {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.GREEN + " +" + ChatColor.GRAY + (int) item.Stealth);
                } else if(item.Stealth < 0) {
                    Lore.add(ChatColor.GRAY + "Stealth:" + ChatColor.RED + " -" + ChatColor.GRAY + String.valueOf( (int) item.Stealth).replace("-", ""));
                }
            }

        }


        if(!item.getAbility().equals("none")) {
            getItemAbilityLore(Lore, item);
        }



        Lore.add("");
        Lore.add(color + item.Rarity);
        itemMeta.setLore(Lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemInQ.setItemMeta(itemMeta);
>>>>>>> Stashed changes
    }
    
    public static String[] GetInventoryReforge(final Player p, final int ItemSlot) {
        final String[] data = new String[10];
        final ItemStack Item = p.getOpenInventory().getItem(ItemSlot);
        if (Item == null) {
            return new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
<<<<<<< Updated upstream
        if (Item.getItemMeta() != null) {
            final ItemMeta itemMeta = Item.getItemMeta();
            itemMeta.getDisplayName().split(" ");
=======
        if(Item.getItemMeta() != null) {
            ItemMeta itemMeta = Item.getItemMeta();
            String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
//            if(Check.ExistingStats(Item.getItemMeta())[7].equals("Armor") || Check.ExistingStats(Item.getItemMeta())[7].equals("Helmet") || Check.ExistingStats(Item.getItemMeta())[7].equals("Chestplate") || Check.ExistingStats(Item.getItemMeta())[7].equals("Leggings") || Check.ExistingStats(Item.getItemMeta())[7].equals("Boots")) {
//                data = DetermineArmorReforge(itemMeta.getDisplayName());
//            } else {
//                data = DetermineReforge(itemMeta.getDisplayName());
//            }

>>>>>>> Stashed changes
        }
        return data;
    }
}
