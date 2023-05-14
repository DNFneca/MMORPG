// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.GUI.CraftingTable;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import javax.annotation.Nonnull;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class GUI implements CommandExecutor
{
    public boolean onCommand(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {
        CraftingTable.MainCraftingInventory((Player)sender);
        return true;
    }
}
