// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

<<<<<<< Updated upstream
import java.util.Iterator;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.Plugin;
import java.util.ArrayList;
import java.util.List;
=======
import me.dnfneca.plugin.utilities.managers.Item.Item;
>>>>>>> Stashed changes
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

<<<<<<< Updated upstream
public class itemTabComplete implements TabCompleter
{
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 1) {
            final List<String> p = new ArrayList<String>();
            for (final Item s : Plugin.CustomItems) {
                if (s.getCodeName() != null && s.getCodeName().contains(args[0])) {
=======
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
>>>>>>> Stashed changes
                    p.add(s.getCodeName());
                }
            }
            return p;
        }
        return null;
    }
}
