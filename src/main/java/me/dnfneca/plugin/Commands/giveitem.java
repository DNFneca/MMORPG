package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Item.*;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.Plugin.CustomReforges;
import static me.dnfneca.plugin.utilities.managers.Item.Items.setItemLore;

public class giveitem implements CommandExecutor {


	@Override
	public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

		if (sender instanceof Player player) {
			if (player.isOp()) {
				if ("giveitem".equalsIgnoreCase(command.getName())) {
					ItemMeta meta;
					for (Item item : CustomItems) {
						if (args[0].equals(item.getCodeName())) {
							ItemStack givenItem = CustomItemStack.NewItem(item.getCodeName());
							ItemMeta givenItemMeta = givenItem.getItemMeta();
							givenItemMeta.setDisplayName(item.getName());
							givenItemMeta.setCustomModelData(item.getCustomLookCode());
							givenItem.setItemMeta(givenItemMeta);
							setItemLore(givenItem, player);
							player.getInventory().addItem(givenItem);
							return true;
						}
					}
					for (Reforge customReforge : CustomReforges) {
						if (args[0].equals(customReforge.getCodeName())) {
							ItemStack givenItem = CustomItemStack.NewItem(customReforge.getCodeName());
							ItemMeta givenItemMeta = givenItem.getItemMeta();
							givenItemMeta.setCustomModelData(customReforge.getCustomLookCode());
							givenItem.setItemMeta(givenItemMeta);
							setItemLore(givenItem, player);
							player.getInventory().addItem(givenItem);
							return true;
						}
					}
					List<String> searchResult = itemTabComplete.SearchItems(args);
					if(searchResult.size() == 1) {
						String itemCodeName = searchResult.get(0);
						for (Item item : CustomItems) {
							if (itemCodeName.equals(item.getCodeName())) {
								ItemStack givenItem = CustomItemStack.NewItem(item.getCodeName());
								ItemMeta givenItemMeta = givenItem.getItemMeta();
								givenItemMeta.setDisplayName(item.getName());
								givenItemMeta.setCustomModelData(item.getCustomLookCode());
								givenItem.setItemMeta(givenItemMeta);
								setItemLore(givenItem, player);
								player.getInventory().addItem(givenItem);
								return true;
							}
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
