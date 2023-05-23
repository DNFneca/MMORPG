// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.CustomMobs.MobStats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomMobsAvailable;

public class summonTabComplete implements TabCompleter {
	public List<String> onTabComplete(final CommandSender sender, final Command command, final String label, final String[] args) {
		if (1 == args.length) {
			final List<String> p = new ArrayList<>();
			for (final MobStats s : CustomMobsAvailable) {
				if (null != s.getName()) {
					final String name = s.getName().replace(" ", "_");
					if(name.contains(args[0])) {
						p.add(name);
					}
				}
			}
			return p;
		}
		return null;
	}
}
