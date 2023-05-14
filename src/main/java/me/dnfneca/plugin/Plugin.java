// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import me.dnfneca.plugin.utilities.managers.Item.SetOpenedInventoryItemsLore;
import me.dnfneca.plugin.utilities.GUI.Waystone;
import me.dnfneca.plugin.listeners.ForgeMenuListener;
import me.dnfneca.plugin.listeners.DropItemListener;
import me.dnfneca.plugin.listeners.CraftingTableListener;
import me.dnfneca.plugin.listeners.LeftClickListener;
import me.dnfneca.plugin.listeners.RightClickListener;
import me.dnfneca.plugin.listeners.PlayerLeave;
import me.dnfneca.plugin.listeners.PlayerJoin;
import me.dnfneca.plugin.listeners.PlayerHealthListener;
import me.dnfneca.plugin.listeners.FishingListener;
import me.dnfneca.plugin.listeners.AttackListener;
import me.dnfneca.plugin.listeners.InventoryListener;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Ghoul;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Dummy;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicWolf;
import org.bukkit.event.Listener;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider;
import me.dnfneca.plugin.Commands.setLevel;
import me.dnfneca.plugin.Commands.test;
import me.dnfneca.plugin.Commands.spawnWaystone;
import me.dnfneca.plugin.Commands.GUI;
import me.dnfneca.plugin.Commands.God;
import me.dnfneca.plugin.Commands.classreset;
import me.dnfneca.plugin.Commands.itemTabComplete;
import me.dnfneca.plugin.Commands.giveitem;
import org.bukkit.command.TabCompleter;
import me.dnfneca.plugin.Commands.summonTabComplete;
import org.bukkit.command.CommandExecutor;
import me.dnfneca.plugin.Commands.summonmob;
import java.io.File;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin
{
    public static List<Item> CustomItems;
    public static List<Reforge> CustomReforges;
    
    public void onEnable() {
        final File f = new File("./plugins/MMORPGData");
        if (f.mkdir()) {
            System.out.println("Directory has been created successfully");
        }
        else {
            System.out.println("Directory cannot be created");
        }
        final Plugin instance = this;
        this.getCommand("summonmob").setExecutor((CommandExecutor)new summonmob());
        this.getCommand("summonmob").setTabCompleter((TabCompleter)new summonTabComplete());
        this.getCommand("giveitem").setExecutor((CommandExecutor)new giveitem());
        this.getCommand("giveitem").setTabCompleter((TabCompleter)new itemTabComplete());
        this.getCommand("classreset").setExecutor((CommandExecutor)new classreset());
        this.getCommand("GOD").setExecutor((CommandExecutor)new God());
        this.getCommand("GUI").setExecutor((CommandExecutor)new GUI());
        this.getCommand("spawnWaystone").setExecutor((CommandExecutor)new spawnWaystone());
        this.getCommand("test").setExecutor((CommandExecutor)new test());
        this.getCommand("setLevel").setExecutor((CommandExecutor)new setLevel());
        this.getServer().getPluginManager().registerEvents((Listener)new BasicSpider(this), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new BasicWolf(this), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new Dummy(this), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new Ghoul(this), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new InventoryListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new AttackListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new FishingListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerHealthListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerJoin(this), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerLeave(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new RightClickListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new LeftClickListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new CraftingTableListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new DropItemListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new ForgeMenuListener(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new Waystone(), (org.bukkit.plugin.Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new SetOpenedInventoryItemsLore(), (org.bukkit.plugin.Plugin)this);
        Plugin.CustomItems.add(new Item("ARMOR", 100.0, 0.0, 50.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "none", "Iron Sex", "Rare", Material.IRON_CHESTPLATE, "ARMOR", 0, "Armor", 0));
        Plugin.CustomItems.add(new Item("Sticky", 100.0, 0.0, 50.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "test", "Iron Sex", "Rare", Material.STICK, "STICKY", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Ghost Reaver", 0.0, 345.0, 0.0, 220.0, 0.0, 0.0, 730.0, 90.0, 0.0, "Fireball", "none", "Rare", Material.DIAMOND_HOE, "GHOST_REAVER", 1, "Weapon", 0));
        Plugin.CustomItems.add(new Item("The Oculus", 0.0, 125.0, 0.0, 30.0, 0.0, 0.0, 100.0, 20.0, 0.0, "none", "none", "Rare", Material.IRON_SWORD, "THE_OCOLUS", 0, "Weapon", 10));
        Plugin.CustomItems.add(new Item("Destiny's Song", 0.0, 75.0, 0.0, 50.0, 0.0, 0.0, 50.0, 70.0, 0.0, "none", "none", "Rare", Material.BOW, "DESTINYS_SONG", 0, "Weapon", 12));
        Plugin.CustomItems.add(new Item("Hunting Bow", 0.0, 75.0, 0.0, 100.0, 0.0, 0.0, 50.0, 10.0, 0.0, "none", "none", "Uncommon", Material.BOW, "HUNTING_BOW", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Death's Kiss", 0.0, 140.0, 0.0, 85.0, 0.0, 0.0, 230.0, 45.0, 0.0, "none", "none", "Mythic", Material.BOW, "DEATHS_KISS", 0, "Weapon", 70));
        Plugin.CustomItems.add(new Item("Longblade of Decay", 0.0, 75.0, 0.0, 50.0, 0.0, 0.0, 45.0, 15.0, 0.0, "none", "none", "Uncommon", Material.STONE_SWORD, "LONGBLADE_OF_DECAY", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Void Etcher", 0.0, 150.0, 0.0, 120.0, 0.0, 0.0, 75.0, 55.0, 0.0, "none", "none", "Legendary", Material.DIAMOND_SWORD, "VOID_ETCHER", 0, "Weapon", 50));
        Plugin.CustomItems.add(new Item("Light's Bane", 0.0, 110.0, 0.0, 100.0, 0.0, 0.0, 45.0, 35.0, 0.0, "none", "none", "Rare", Material.IRON_SWORD, "LIGHTS_BANE", 0, "Weapon", 15));
        Plugin.CustomItems.add(new Item("Hermit's Amulet", 25.0, -35.0, 20.0, -5.0, -50.0, 50.0, 0.0, 100.0, -10.0, "none", "none", "Exotic", Material.LEATHER_CHESTPLATE, "PJ_HERM_AMU", 0, "Armor", 0));
        Plugin.CustomItems.add(new Item("Nether's Bane", 0.0, 160.0, 0.0, 120.0, 0.0, 0.0, 75.0, 45.0, 0.0, "none", "none", "Mythic", Material.NETHERITE_SWORD, "NETHERS_BANE", 0, "Weapon", 30));
        Plugin.CustomItems.add(new Item("Willbreaker", 0.0, 80.0, 0.0, 95.0, 0.0, 0.0, 20.0, 25.0, 0.0, "none", "none", "Rare", Material.IRON_SWORD, "WILLBREAKER", 0, "Weapon", 12));
        Plugin.CustomItems.add(new Item("Instigator", -50.0, 100.0, -20.0, 20.0, 5.0, -5.0, 10.0, 10.0, -10.0, "none", "none", "Epic", Material.WOODEN_SWORD, "PJ_INSTI", 0, "Weapon", 35));
        Plugin.CustomItems.add(new Item("Hermit's Helmet", 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E7, 0.0, 0.0, -100.0, "none", "none", "Exotic", Material.LEATHER_HELMET, "PJ_HERM_HELM", 0, "Armor", 0));
        Plugin.CustomItems.add(new Item("Silver Staff", 0.0, 35.0, 0.0, 25.0, 0.0, 20.0, 10.0, 5.0, 0.0, "none", "none", "Common", Material.STICK, "SILVER_STAFF", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Short Bow", 0.0, 25.0, 0.0, 20.0, 20.0, 0.0, 10.0, 25.0, 0.0, "Rapid Fire", "none", "Common", Material.BOW, "SHORT_BOW", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Copper Bow", 0.0, 30.0, 0.0, 25.0, 10.0, 0.0, 15.0, 20.0, 0.0, "none", "none", "Common", Material.BOW, "COPPER_BOW", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Silver Bow", 0.0, 40.0, 0.0, 25.0, 5.0, 0.0, 15.0, 10.0, 25.0, "none", "none", "Common", Material.BOW, "SILVER_BOW", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Shadowsong", 0.0, 130.0, 0.0, 140.0, 0.0, 0.0, 70.0, 55.0, 20.0, "none", "none", "legendary", Material.DIAMOND_SWORD, "SHADOWSONG", 0, "Weapon", 50));
        Plugin.CustomItems.add(new Item("Quicksilver dagger", 0.0, 155.0, 0.0, 115.0, 25.0, 0.0, 0.0, 100.0, 5.0, "none", "none", "legendary", Material.IRON_SWORD, "QUICKSILVER_DAGGER", 0, "Weapon", 50));
        Plugin.CustomItems.add(new Item("Dragonclaw", 0.0, 90.0, 0.0, 65.0, 0.0, 0.0, 25.0, 20.0, 0.0, "none", "none", "uncommon", Material.STONE_SWORD, "DRAGONCLAW", 0, "Weapon", 0));
        Plugin.CustomItems.add(new Item("Sacrificial dagger", 0.0, 115.0, 0.0, 75.0, 0.0, 0.0, 50.0, 55.0, 0.0, "none", "none", "rare", Material.IRON_SWORD, "SACRIFICIAL_DAGGER", 0, "Weapon", 20));
        Plugin.CustomItems.add(new Item("Nights Edge", 0.0, 215.0, 0.0, 135.0, 0.0, 0.0, 70.0, 50.0, 0.0, "none", "none", "legendary", Material.DIAMOND_SWORD, "NIGHTS_EDGE", 0, "Weapon", 60));
        Plugin.CustomItems.add(new Item("Windcaller", 0.0, 110.0, 0.0, 0.0, 0.0, 45.0, 25.0, 40.0, 0.0, "none", "none", "rare", Material.BLAZE_ROD, "WINDCALLER", 0, "Weapon", 35));
        Plugin.CustomReforges.add(new Reforge("Strength Artifact", 10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "Rare", new ItemStack(Material.ARROW).getItemMeta(), "Strong", 0, "Any", 0));
        ItemStats.RegisteredReforges[0][0] = "Strength Artifact";
        ItemStats.RegisteredReforges[0][1] = "Strong";
        ItemStats.RegisteredReforges[1][0] = "Aegis of Zeus";
        ItemStats.RegisteredReforges[1][1] = "Reinforced";
        ItemStats.RegisteredReforges[2][0] = "The Wizards Last Wish";
        ItemStats.RegisteredReforges[2][1] = "Smart";
    }
    
    public void onDisable() {
    }
    
    public static Plugin getInstance() {
        return (Plugin)Bukkit.getServer().getPluginManager().getPlugin("MMORPGCustom");
    }
    
    static {
        Plugin.CustomItems = new ArrayList<Item>();
        Plugin.CustomReforges = new ArrayList<Reforge>();
    }
}
