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
			return SearchItems(args);
		}
		return null;
	}

	public static List<String> SearchItems(String[] args) {
		List<String> p = new ArrayList<>();
		for (Item s : CustomItems) {
			if (null != s.getCodeName() && s.getCodeName().contains(args[0])) {
				p.add(s.getCodeName());
			}
			if (s.getAbilityName().toUpperCase().contains(args[0].toUpperCase())) {
				p.add(s.getCodeName());
			}
			if (s.getAbilityCost() != 0 && args[0] != "" && String.valueOf(s.getAbilityCost()).equals(args[0])) {
				p.add(s.getCodeName());
			}
		}
		for (Reforge customReforge : CustomReforges) {
			if(null != customReforge.getName() && customReforge.getName().toUpperCase().replace(" ", "_").contains(args[0])) {
				p.add(customReforge.getName().toUpperCase().replace(" ", "_"));
			}
		}
		return p;
	}
}
