package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.GUI.CraftingTable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class GUI implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        CraftingTable.MainCraftingInventory((Player) sender);

        return true;
    }
}
