package me.dnfneca.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(p.isInvulnerable() == true) {
                p.sendMessage("You are no longer ascended");
                p.setAllowFlight(false);
                p.setInvulnerable(false);
            } else {
                p.sendMessage("You have just ascended");
                p.setAllowFlight(true);
                p.setInvulnerable(true);
            }
        }

        return true;
    }
}
