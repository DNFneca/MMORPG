package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Item.Item;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomItems;

public class itemTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            List<String> p = new ArrayList<>();
            for(Item s : CustomItems) {
                if(s.getCodeName() != null && s.getCodeName().contains(args[0])) {
                    p.add(s.getCodeName());
                }
            }
            return p;
        }
        return null;
    }
}
