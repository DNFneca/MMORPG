package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.GUI.EnchantingMenu;
import me.dnfneca.plugin.utilities.managers.Social.Main;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static me.dnfneca.plugin.Plugin.connection;

public class test implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Main.initConvo(((Player) sender).getUniqueId(), args);


		return true;
	}
}
