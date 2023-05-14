// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

<<<<<<< Updated upstream
=======
import me.dnfneca.plugin.utilities.managers.Item.Item;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
import static me.dnfneca.plugin.Plugin.CustomItems;

public class giveitem implements CommandExecutor {


    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(args[0]);
            if(player.isOp()) {
                if(command.getName().equalsIgnoreCase("giveitem")) {
                    ItemMeta meta;
                    for (Item item : CustomItems) {
                            if(args[0].equals(item.getCodeName())) {
                                ItemStack givenItem = new ItemStack(item.getItemMaterial());
                                ItemMeta givenItemMeta = givenItem.getItemMeta();
                                givenItemMeta.setDisplayName(item.getName());
                                givenItemMeta.setCustomModelData(item.getCustomLookCode());
                                givenItem.setItemMeta(givenItemMeta);
                                player.getInventory().addItem(givenItem);
                            }
                        }
                    }
            } else {
>>>>>>> Stashed changes
                player.sendMessage("You are not allowed to use this command!");
            }
        }
        else {
            sender.sendMessage("Only players can use this command!");
        }
        return true;
    }
}
