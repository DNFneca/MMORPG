package me.dnfneca.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.dnfneca.plugin.utilities.inventory.ItemStats.RegisteredReforges;

public class GetRegisteredReforges implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            for (String[] s: RegisteredReforges) {
                if(s[0] != null) {
                    p.sendMessage(s[0] + ", " + s[1]);
                }
            }
//            System.out.println(Arrays.toString(RegisteredItemsStats));
        }

        return true;
    }
}