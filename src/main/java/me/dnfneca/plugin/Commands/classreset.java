// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.GUI.GUI;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
<<<<<<< Updated upstream
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
=======
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
>>>>>>> Stashed changes

public class classreset implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender.isOp()) {
<<<<<<< Updated upstream
            if (command.getName().equalsIgnoreCase("classreset") && sender instanceof Player) {
                final Player p = (Player)sender;
                PlayerStats.getPlayerStats(p.getUniqueId()).setClass("none");
                GUI.ChooseClassesMenu(p);
            }
        }
        else {
=======
            if (command.getName().equalsIgnoreCase("classreset")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    PlayerStats.getPlayerStats(p.getUniqueId()).setClass("none");
                    GUI.ChooseClassesMenu(p);
                }
            }

        } else {
>>>>>>> Stashed changes
            sender.sendMessage("You are not allowed to use this command!");
        }
        return true;
    }
}
