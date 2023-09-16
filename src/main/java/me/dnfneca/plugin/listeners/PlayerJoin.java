package me.dnfneca.plugin.listeners;


import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.*;

import static me.dnfneca.plugin.Plugin.*;
import static me.dnfneca.plugin.utilities.GUI.GUI.ChooseClassesMenu;


public class PlayerJoin implements Listener {

	static Plugin plugin;

	public PlayerJoin(Plugin plugin) {
		PlayerJoin.plugin = plugin;
	}



	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {


		System.out.println(connection == null);

		if(connection == null) {
			System.out.println("asdasasasdasdadaxsdasdadaxdasdasdASDASDASD");
			e.getPlayer().sendMessage("The servers are currently down, countinuing to play like this may couse new data to not be saved.");
		}

		try {
			// below two lines are used for connectivity.
			// mydb is database
			// mydbuser is name of database
			// mydbuser is password of database

			Statement statement;
			if(connection != null) {
				statement = connection.createStatement();
				statement.execute("INSERT IGNORE INTO `userdata` (`xpAmount`, `UUID`, `class`) VALUES ('0', '" + e.getPlayer().getUniqueId() + "', 'none');");
				statement.close();
			}
//
//			if(statement.execute("SELECT `xpAmount` FROM `userdata` WHERE `UUID` = '6a025aa7-802d-37b4-9a9e-d2a5296257fa'")) {
//				results = statement.getResultSet();
//			}
//
//			int idIndex   = results.findColumn("xpAmount");
//			int priceIndex    = results.findColumn("class");
//
//			int item_id;
//			String item_price;
//			while(results.next()){
//				item_id=results.getInt(idIndex);
//				item_price=results.getString(priceIndex);
//				System.out.println(""+item_price);//displaying product price in a jTextField1
//				System.out.println(""+item_id);//displaying product id in a jTextField2
//			}

		} catch (SQLException err) {
			System.out.println(new RuntimeException(err));
		} catch (RuntimeException exception) {
			System.out.println(exception);
		}

		Player player = e.getPlayer();
		String Class = "none";
		Statement statement;
		int xpAmount = 0;

		try {
			if(connection != null) {
				statement = connection.createStatement();
				ResultSet results = null;
				if (statement.execute("SELECT `class` FROM `userdata` WHERE `UUID` = '" + player.getUniqueId() + "'")) {
					results = statement.getResultSet();
					int classIndex = results.findColumn("class");
					while (results.next()) {
						Class = results.getString(classIndex);
					}
				}
				if (statement.execute("SELECT `xpAmount` FROM `userdata` WHERE `UUID` = '" + player.getUniqueId() + "'")) {
					results = statement.getResultSet();
					int xpIndex = results.findColumn("xpAmount");
					while (results.next()) {
						xpAmount = results.getInt(xpIndex);
					}
				}
				statement.close();
			}
		} catch (SQLException err) {
			System.out.println(new RuntimeException(err));
		}
		

		Players.add(new PlayerStats(e.getPlayer().getUniqueId(), 100, 50, 25, 10, 100, 100, 0, 0, 0, 0, xpAmount, Class));


		ItemStack MainMenu = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta MenuMeta = MainMenu.getItemMeta();
		MenuMeta.setDisplayName(ChatColor.GRAY + "Menu");
		MenuMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		MainMenu.setItemMeta(MenuMeta);
		player.getInventory().setItem(8, MainMenu);
		for (PlayerStats playerStats : Players) {
			if (playerStats.getUUID().toString().equals(e.getPlayer().getUniqueId().toString())) {
				Bukkit.getScheduler().runTaskLater(Plugin.getInstance(), new Runnable() {
				@Override
				public void run() {
					if (0 == playerStats.getChoiceCD()) {
						ChooseClassesMenu(player);
					}
				}
			}, 20L);

		}
	}

	}
}
