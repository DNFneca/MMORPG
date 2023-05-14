// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import java.util.Iterator;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.Plugin;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class itemTabComplete implements TabCompleter
{
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 1) {
            final List<String> p = new ArrayList<String>();
            for (final Item s : Plugin.CustomItems) {
                if (s.getCodeName() != null && s.getCodeName().contains(args[0])) {
                    p.add(s.getCodeName());
                }
            }
            return p;
        }
        return null;
    }
}
