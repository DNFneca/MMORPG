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
			if (null != s.getCodeName() && s.getCodeName().toUpperCase().contains(args[0].toUpperCase())) {
				p.add(s.getCodeName());
			}
			if (s.getAbilityName().toUpperCase().contains(args[0].toUpperCase())) {
				p.add(s.getCodeName());
			}
			if (s.getAbilityCost() != 0 && args[0] != "" && String.valueOf(s.getAbilityCost()).contains(args[0])) {
				p.add(s.getCodeName());
			}
		}
		for (Reforge customReforge : CustomReforges) {
			if (null != customReforge.getCodeName() && customReforge.getCodeName().toUpperCase().contains(args[0].toUpperCase())) {
				p.add(customReforge.getCodeName());
			}
			if (customReforge.getReforgeName().toUpperCase().contains(args[0].toUpperCase())) {
				p.add(customReforge.getCodeName());
			}
		}
		return p;
	}
}
