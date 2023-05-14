// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.GUI.GUI;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class classreset implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender.isOp()) {
            if (command.getName().equalsIgnoreCase("classreset") && sender instanceof Player) {
                final Player p = (Player)sender;
                PlayerStats.getPlayerStats(p.getUniqueId()).setClass("none");
                GUI.ChooseClassesMenu(p);
            }
        }
        else {
            sender.sendMessage("You are not allowed to use this command!");
        }
        return true;
    }
}
