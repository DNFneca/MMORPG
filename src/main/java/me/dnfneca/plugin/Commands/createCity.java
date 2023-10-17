package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.Towns.Town;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.sql.Statement;

import static me.dnfneca.plugin.Plugin.Towns;
import static me.dnfneca.plugin.Plugin.connection;

public class createCity implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player player) {

			new Town(args[0], player.getLocation(), Integer.valueOf(args[1]), args[2]);

			for (Town town : Towns) {
				player.sendMessage(town.getTownName());
			}

			Statement statement;
			if(connection != null) {
				try {
					statement = connection.createStatement();
					statement.execute("INSERT INTO `towns` SET `Name` = '" + args[0] + "', `x`= '" + (int) player.getLocation().getX() + "', `y`= '" + (int) player.getLocation().getY() + "', `z`= '" + (int) player.getLocation().getZ() + "', `Distance` = " + args[1] + ", `Mayor` = '" + args[2] + "'");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return true;
	}
}
