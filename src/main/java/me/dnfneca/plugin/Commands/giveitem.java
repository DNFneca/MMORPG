// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import org.bukkit.inventory.meta.ItemMeta;
import java.util.Iterator;
import org.bukkit.inventory.ItemStack;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import javax.annotation.Nonnull;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class giveitem implements CommandExecutor
{
    public boolean onCommand(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            player.sendMessage(args[0]);
            if (player.isOp()) {
                if (command.getName().equalsIgnoreCase("giveitem")) {
                    for (final Item item : Plugin.CustomItems) {
                        if (args[0].equals(item.getCodeName())) {
                            final ItemStack givenItem = new ItemStack(item.getItemMaterial());
                            final ItemMeta givenItemMeta = givenItem.getItemMeta();
                            givenItemMeta.setDisplayName(item.getName());
                            givenItem.setItemMeta(givenItemMeta);
                            player.getInventory().addItem(new ItemStack[] { givenItem });
                        }
                    }
                }
            }
            else {
                player.sendMessage("You are not allowed to use this command!");
            }
        }
        else {
            sender.sendMessage("Only players can use this command!");
        }
        return true;
    }
}
