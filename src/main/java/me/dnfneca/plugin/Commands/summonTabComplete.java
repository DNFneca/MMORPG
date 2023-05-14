// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class summonTabComplete implements TabCompleter
{
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 1) {
            final List<String> p = new ArrayList<String>();
            p.add("DUMMY");
            p.add("BASIC_WOLF");
            p.add("BASIC_SPIDER");
            p.add("GHOUL");
            return p;
        }
        return null;
    }
}
