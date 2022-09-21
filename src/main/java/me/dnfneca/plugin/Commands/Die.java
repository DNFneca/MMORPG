package me.dnfneca.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Die implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("You have just killed yourself, good job!");
            p.setHealth(0);
        }

        return true;
    }
}
