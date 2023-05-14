<<<<<<< Updated upstream
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
=======
package me.dnfneca.plugin.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.Arrays;


public class spawnWaystone implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Location location = ((Player) sender).getLocation();

            ArmorStand waystone = location.getWorld().spawn(location, ArmorStand.class);

            waystone.setCustomName(Arrays.toString(args).replace("[", "").replace("]", "") + " Waystone");
            waystone.setInvulnerable(true);
            waystone.setCustomNameVisible(true);
//            waystone.setVisible(false);
>>>>>>> Stashed changes
        }
        return true;
    }
}
