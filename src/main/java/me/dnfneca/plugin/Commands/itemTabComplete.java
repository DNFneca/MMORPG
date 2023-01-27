package me.dnfneca.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.utilities.managers.Item.RegisterItem.RegisteredItems;

public class itemTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            List<String> p = new ArrayList<>();
            for(String s : RegisteredItems) {
                if(s != null) {
                    s = s.toUpperCase().replace(" ", "_");
                    p.add(s);
                }
            }
            return p;
        }
        return null;
    }
}
