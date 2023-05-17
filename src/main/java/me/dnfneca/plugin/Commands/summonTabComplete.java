// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.CustomMobs.MobStats;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.listeners.PlayerJoin.CustomMobs;

public class summonTabComplete implements TabCompleter {
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if (1 == args.length) {
			List<String> p = new ArrayList<>();
			for (MobStats s : CustomMobs) {
				if (null != s.getName()) {
					String name = s.getName().replace(" ", "_");
					if(name.contains(args[0])) {
						p.add(s.getName());
					}
				}
			}
			return p;
		}
		return null;
	}
}
