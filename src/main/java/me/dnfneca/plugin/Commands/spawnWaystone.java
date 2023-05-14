// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import org.bukkit.Location;
import java.util.Arrays;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class spawnWaystone implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Location location = ((Player)sender).getLocation();
            final ArmorStand waystone = (ArmorStand)location.getWorld().spawn(location, (Class)ArmorStand.class);
            waystone.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, Arrays.toString(args).replace("[", "").replace("]", "")));
            waystone.setInvulnerable(true);
            waystone.setCustomNameVisible(true);
        }
        return true;
    }
}
