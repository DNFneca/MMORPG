package me.dnfneca.plugin;

import me.dnfneca.plugin.Commands.*;
import me.dnfneca.plugin.CustomMobs.*;
import me.dnfneca.plugin.listeners.*;
import me.dnfneca.plugin.utilities.GUI.Waystone;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import me.dnfneca.plugin.utilities.managers.Item.SetOpenedInventoryItemsLore;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public final class Plugin extends JavaPlugin {
	public static List<Item> CustomItems = new ArrayList<>();
	public static List<Reforge> CustomReforges = new ArrayList<>();
	public static List<MobStats> CustomMobs = new ArrayList<>();

	public static List<MobStats> CustomMobsAvailable = new ArrayList<>();

	public static List<String> NPCs = new ArrayList<>();
	public static List<PlayerStats> Players = new ArrayList<>();

	public static Connection connection = null;


	@Override
	public void onEnable() {

		ConnectToServer();

		File f = new File("./plugins/MMORPGData");

		if (f.mkdir()) {
			System.out.println("Directory has been created successfully");
		} else {
			System.out.println("Directory cannot be created");
		}

		// TODO crafting
		// TODO fix bugs


		// Plugin startup logic


		Plugin instance = this;

		this.getCommand("summonmob").setExecutor(new @NonNull summonmob());
		this.getCommand("summonmob").setTabCompleter(new summonTabComplete());
		this.getCommand("giveitem").setExecutor(new @NonNull giveitem());
		this.getCommand("giveitem").setTabCompleter(new itemTabComplete());
		this.getCommand("classreset").setExecutor(new @NonNull classreset());
		this.getCommand("GOD").setExecutor(new God());
		this.getCommand("GUI").setExecutor(new GUI());
		this.getCommand("spawnWaystone").setExecutor(new spawnWaystone());
		this.getCommand("test").setExecutor(new test());
		this.getCommand("setLevel").setExecutor(new setLevel());
		this.getCommand("enchantitem").setExecutor(new enchantitem());
		this.getCommand("textchoice").setExecutor(new textChoice());
		this.getCommand("runconversation").setExecutor(new runConversation());

		//  MOBS

		getServer().getPluginManager().registerEvents(new BasicSpider(this), this);
		getServer().getPluginManager().registerEvents(new BasicWolf(this), this);
		getServer().getPluginManager().registerEvents(new Dummy(this), this);


		// EVENTS


		getServer().getPluginManager().registerEvents(new InventoryListener(), this);
		getServer().getPluginManager().registerEvents(new AttackListener(), this);
		getServer().getPluginManager().registerEvents(new FishingListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerHealthListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
		getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
		getServer().getPluginManager().registerEvents(new RightClickListener(), this);
		getServer().getPluginManager().registerEvents(new CraftingTableListener(), this);
		getServer().getPluginManager().registerEvents(new DropItemListener(), this);
		getServer().getPluginManager().registerEvents(new ForgeMenuListener(), this);
		getServer().getPluginManager().registerEvents(new Waystone(), this);
		getServer().getPluginManager().registerEvents(new SetOpenedInventoryItemsLore(), this);

//        getServer().getPluginManager().registerEvents(new (this), this);

		// Classes


		// ITEMS

		initItems.init();

		initReforges.init();

		initMobs.init();

		initNPC.init();



//		ItemStats.RegisteredReforges[0][0] = "Strength Artifact";
//		ItemStats.RegisteredReforges[0][1] = "Strong";
//		ItemStats.RegisteredReforges[1][0] = "Aegis of Zeus";
//		ItemStats.RegisteredReforges[1][1] = "Reinforced";
//		ItemStats.RegisteredReforges[2][0] = "The Wizards Last Wish";
//		ItemStats.RegisteredReforges[2][1] = "Smart";
	}

	@Override
	public void onDisable() {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Plugin getInstance() {
		return (Plugin) Bukkit.getServer().getPluginManager().getPlugin("MMORPGCustom");
	}

	public static void ConnectToServer() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mmorpg",
					"dbuser", "pass");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(new RuntimeException(e));
		}
	}
}
