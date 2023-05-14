// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.CustomMobs.Ghoul;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Dummy;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicWolf;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import javax.annotation.Nonnull;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class summonmob implements CommandExecutor
{
    public boolean onCommand(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.isOp()) {
                if (command.getName().equalsIgnoreCase("summonmob")) {
                    if (args[0].equalsIgnoreCase("Basic_Spider")) {
                        BasicSpider.createSpider(player.getLocation());
                    }
                    else if (args[0].equalsIgnoreCase("Basic_Wolf")) {
                        BasicWolf.createWolf(player.getLocation());
                    }
                    else if (args[0].equalsIgnoreCase("Dummy")) {
                        Dummy.createDummy(player.getLocation());
                    }
                    else if (args[0].equalsIgnoreCase("Ghoul")) {
                        Ghoul.createGhoul(player.getLocation(), player);
                    }
                }
            }
            else {
                player.sendMessage("You are not allowed to use this command!");
            }
            return true;
        }
        sender.sendMessage("Only players can use this command!");
        return true;
    }
}
