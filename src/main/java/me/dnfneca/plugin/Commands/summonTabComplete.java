package me.dnfneca.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class summonTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            List<String> p = new ArrayList<>();
            p.add("DUMMY");
            p.add("BASIC_WOLF");
            p.add("BASIC_SPIDER");
            p.add("GHOUL");
            return p;
        }

        return null;
    }
}
