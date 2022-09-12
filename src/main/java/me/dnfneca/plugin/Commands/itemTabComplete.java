package me.dnfneca.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class itemTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            List<String> p = new ArrayList<>();
            p.add("GHOST_REAVER");
            p.add("EROS'S_BOW");
            p.add("ASPECT_OF_THE_END");
            p.add("IRON_ARMOR_SET");
            p.add("WISE_MANS_SET");
            p.add("ASPECT_OF_THE_NETHER");
            return p;
        }

        return null;
    }
}
