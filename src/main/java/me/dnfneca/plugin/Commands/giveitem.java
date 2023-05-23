package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.Plugin.CustomReforges;

public class giveitem implements CommandExecutor {


	@Override
	public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

		if (sender instanceof final Player player) {
			player.sendMessage(args[0]);
			if (player.isOp()) {
				if ("giveitem".equalsIgnoreCase(command.getName())) {
					ItemMeta meta;
					for (final Item item : CustomItems) {
						if (args[0].equals(item.getCodeName())) {
							ItemStack givenItem = new ItemStack(item.getItemMaterial());
							ItemMeta givenItemMeta = givenItem.getItemMeta();
							givenItemMeta.setDisplayName(item.getName());
							givenItemMeta.setCustomModelData(item.getCustomLookCode());
							givenItem.setItemMeta(givenItemMeta);
							player.getInventory().addItem(givenItem);
							return true;
						}
					}
					for (final Reforge customReforge : CustomReforges) {
						if (args[0].equals(customReforge.getName().toUpperCase().replace(" ", "_"))) {
							ItemStack givenItem = new ItemStack(customReforge.getReforgeItemStack());
							ItemMeta givenItemMeta = givenItem.getItemMeta();
							givenItemMeta.setCustomModelData(customReforge.getCustomLookCode());
							givenItem.setItemMeta(givenItemMeta);
							player.getInventory().addItem(givenItem);
							return true;
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
