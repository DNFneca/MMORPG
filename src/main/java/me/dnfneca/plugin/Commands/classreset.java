package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.GUI.GUI;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class classreset implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            if (command.getName().equalsIgnoreCase("classreset")) {
                if (args.length != 0) {
                    NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");
                    Player p = Bukkit.getPlayerExact(args[0]);
                    p.getScoreboard().getObjective("Stats").getScore("Class").setScore(0);
                    p.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 0);

                    GUI.ChooseClassesMenu(p);
                } else if (sender instanceof Player) {
                    NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");
                    Player p = (Player) sender;
                    p.getScoreboard().getObjective("Stats").getScore("Class").setScore(0);
                    p.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 0);
                }
            }
        } else {
            sender.sendMessage("You are not allowed to use this command!");
        }
        return true;
    }
}
