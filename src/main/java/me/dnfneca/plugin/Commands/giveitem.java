package me.dnfneca.plugin.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

import static me.dnfneca.plugin.utilities.managers.Item.RegisterItem.RegisteredItems;
import static me.dnfneca.plugin.utilities.managers.Item.StatsByName.GetStatsString;

public class giveitem implements CommandExecutor {


    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.isOp()) {
                if(command.getName().equalsIgnoreCase("giveitem")) {
                    ItemStack item = new ItemStack(Material.END_GATEWAY, 1);
                    ItemMeta meta;
                    int i = 0;
                    for (String s: RegisteredItems) {
                        if(s != null) {
                            s = s.toUpperCase().replace(" ", "_");
                            if(args[0].contains(s)) {
                                if(GetStatsString(RegisteredItems[i])[7] == "Sword") {
                                    item.setType(Material.IRON_SWORD);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                } else if (GetStatsString(RegisteredItems[i])[7] == "Bow") {
                                    item.setType(Material.BOW);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                } else if (GetStatsString(RegisteredItems[i])[7] == "Helmet") {
                                    item.setType(Material.LEATHER_HELMET);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                } else if (GetStatsString(RegisteredItems[i])[7] == "Chestplate") {
                                    item.setType(Material.LEATHER_CHESTPLATE);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                } else if (GetStatsString(RegisteredItems[i])[7] == "Leggings") {
                                    item.setType(Material.LEATHER_LEGGINGS);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                } else if (GetStatsString(RegisteredItems[i])[7] == "Boots") {
                                    item.setType(Material.LEATHER_BOOTS);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                } else if (GetStatsString(RegisteredItems[i])[7] == "Stick") {
                                    item.setType(Material.STICK);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                } else if (GetStatsString(RegisteredItems[i])[7] == "Scythe") {
                                    item.setType(Material.DIAMOND_HOE);
                                    meta = item.getItemMeta();
                                    meta.setDisplayName(RegisteredItems[i]);
                                    item.setItemMeta(meta);
                                    ((Player) sender).getInventory().addItem(item);
                                }
                            }
                            i++;
                        }
                    }
                }
            } else {
                player.sendMessage("You are not allowed to use this command!");
            }
        } else {
            sender.sendMessage("Only players can use this command!");
        }
        return true;
    }
}
