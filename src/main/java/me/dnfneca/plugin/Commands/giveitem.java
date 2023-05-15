package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Item.Item;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

import static me.dnfneca.plugin.Plugin.CustomItems;

public class giveitem implements CommandExecutor {


	@Override
	public boolean onCommand(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {

		if (sender instanceof Player player) {
			player.sendMessage(args[0]);
			if (player.isOp()) {
				if ("giveitem".equalsIgnoreCase(command.getName())) {
					ItemMeta meta;
					for (final Item item : CustomItems) {
						if (args[0].equals(item.getCodeName())) {
							final ItemStack givenItem = new ItemStack(item.getItemMaterial());
							final ItemMeta givenItemMeta = givenItem.getItemMeta();
							givenItemMeta.setDisplayName(item.getName());
							givenItemMeta.setCustomModelData(item.getCustomLookCode());
							givenItem.setItemMeta(givenItemMeta);
							player.getInventory().addItem(givenItem);
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
