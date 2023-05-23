package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.Plugin.CustomReforges;

public class itemTabComplete implements TabCompleter {
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if (1 == args.length) {
			final List<String> p = new ArrayList<>();
			for (final Item s : CustomItems) {
				if (null != s.getCodeName() && s.getCodeName().contains(args[0])) {
					p.add(s.getCodeName());
				}
			}
			for (final Reforge customReforge : CustomReforges) {
				if(null != customReforge.getName() && customReforge.getName().toUpperCase().replace(" ", "_").contains(args[0])) {
					p.add(customReforge.getName().toUpperCase().replace(" ", "_"));
				}
			}

			return p;
		}
		return null;
	}
}
