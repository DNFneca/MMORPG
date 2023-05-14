package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        PlayerLevels.add(player, 100);

        return true;
    }
}
