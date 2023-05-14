package me.dnfneca.plugin;

import me.dnfneca.plugin.Commands.*;
import me.dnfneca.plugin.listeners.*;
import me.dnfneca.plugin.utilities.GUI.Waystone;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicWolf;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Dummy;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Ghoul;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import me.dnfneca.plugin.utilities.managers.Item.SetOpenedInventoryItemsLore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Plugin extends JavaPlugin {
    public static List<Item> CustomItems = new ArrayList<>();
    public static List<Reforge> CustomReforges = new ArrayList<>();


    @Override
    public void onEnable() {

        File f = new File("./plugins/MMORPGData");

        if (f.mkdir()) {
            System.out.println("Directory has been created successfully");
        }
        else {
            System.out.println("Directory cannot be created");
        }


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




        //  MOBS

        getServer().getPluginManager().registerEvents(new BasicSpider(this), this);
        getServer().getPluginManager().registerEvents(new BasicWolf(this), this);
        getServer().getPluginManager().registerEvents(new Dummy(this), this);
        getServer().getPluginManager().registerEvents(new Ghoul(this), this);


        // EVENTS


        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new AttackListener(), this);
        getServer().getPluginManager().registerEvents(new FishingListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHealthListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new LeftClickListener(), this);
        getServer().getPluginManager().registerEvents(new CraftingTableListener(), this);
        getServer().getPluginManager().registerEvents(new DropItemListener(), this);
        getServer().getPluginManager().registerEvents(new ForgeMenuListener(), this);
        getServer().getPluginManager().registerEvents(new Waystone(), this);
        getServer().getPluginManager().registerEvents(new SetOpenedInventoryItemsLore(), this);

//        getServer().getPluginManager().registerEvents(new (this), this);

        // Classes





        // ITEMS

        CustomItems.add(new Item("ARMOR",
                100,
                0,
                50,
                0,
                0,
                0,
                0,
                0,
                0,
                "none",
                "Iron Sex",
                "Rare",
                Material.IRON_CHESTPLATE,
                "ARMOR",
                0,
                "Armor",
                0));

        CustomItems.add(new Item("Sticky",
                100,
                0,
                50,
                0,
                0,
                0,
                0,
                0,
                0,
                "test",
                "Iron Sex",
                "Rare",
                Material.STICK,
                "STICKY",
                0,
                "Weapon",
                0));

        CustomItems.add(new Item("Ghost Reaver",
                0,
                345,
                0,
                220,
                0,
                0,
                730,
                90,
                0,
                "Fireball",
                "none",
                "Rare",
                Material.DIAMOND_HOE,
                "GHOST_REAVER",
                1,
                "Weapon",
                0));




        CustomItems.add(new Item("The Oculus",
                0,
                125,
                0,
                30,
                0,
                0,
                100,
                20,
                0,
                "none",
                "none",
                "Rare",
                Material.IRON_SWORD,
                "THE_OCOLUS",
                0,
                "Weapon",
                10));
        CustomItems.add(new Item("Destiny's Song",
                0,
                +75,
                0,
                +50,
                0,
                0,
                +50,
                +70,
                0,
                "none",
                "none",
                "Rare",
                Material.BOW,
                "DESTINYS_SONG",
                0,
                "Weapon",
                12));
        CustomItems.add(new Item("Hunting Bow",
                0,
                +75,
                0,
                +100,
                0,
                0,
                +50,
                +10,
                0,
                "none",
                "none",
                "Uncommon",
                Material.BOW,
                "HUNTING_BOW",
                0,
                "Weapon",
                0));
        CustomItems.add(new Item("Death's Kiss",
                0,
                +140,
                0,
                +85,
                0,
                0,
                +230,
                +45,
                0,
                "none",
                "none",
                "Mythic",
                Material.BOW,
                "DEATHS_KISS",
                0,
                "Weapon",
                70));

        CustomItems.add(new Item("Longblade of Decay",
                0,
                +75,
                0,
                +50,
                0,
                0,
                +45,
                +15,
                0,
                "none",
                "none",
                "Uncommon",
                Material.STONE_SWORD,
                "LONGBLADE_OF_DECAY",
                0,
                "Weapon",
                0));
        CustomItems.add(new Item("Void Etcher",
                0,
                +150,
                0,
                +120,
                0,
                0,
                +75,
                +55,
                0,
                "none",
                "none",
                "Legendary",
                Material.DIAMOND_SWORD,
                "VOID_ETCHER",
                0,
                "Weapon",
                50));
        CustomItems.add(new Item("Light's Bane",
                0,
                +110,
                0,
                +100,
                0,
                0,
                +45,
                +35,
                0,
                "none",
                "none",
                "Rare",
                Material.IRON_SWORD,
                "LIGHTS_BANE",
                0,
                "Weapon",
                15));
        CustomItems.add(new Item("Hermit's Amulet",
                +25,
                -35,
                +20,
                -5,
                -50,
                +50,
                0,
                +100,
                -10,
                "none",
                "none",
                "Exotic",
                Material.LEATHER_CHESTPLATE,
                "PJ_HERM_AMU",
                0,
                "Armor",
                0));
        CustomItems.add(new Item("Nether's Bane",
                0,
                +160,
                0,
                +120,
                0,
                0,
                +75,
                +45,
                0,
                "none",
                "none",
                "Mythic",
                Material.NETHERITE_SWORD,
                "NETHERS_BANE",
                0,
                "Weapon",
                30));

        CustomItems.add(new Item("Willbreaker",
                0,
                +80,
                0,
                +95,
                0,
                0,
                +20,
                +25,
                0,
                "none",
                "none",
                "Rare",
                Material.IRON_SWORD,
                "WILLBREAKER",
                0,
                "Weapon",
                12));

        CustomItems.add(new Item("Instigator",
                -50,
                +100,
                -20,
                +20,
                +5,
                -5,
                +10,
                +10,
                -10,
                "none",
                "none",
                "Epic",
                Material.WOODEN_SWORD,
                "PJ_INSTI",
                0,
                "Weapon",
                35));

        CustomItems.add(new Item("Hermit's Helmet",
                        0,
                        0,
                        0,
                        0,
                        0,
                        10000000,
                0,
                0,
                -100,
                "none",
                "none",
                "Exotic",
                Material.LEATHER_HELMET,
                "PJ_HERM_HELM",
                0,
                "Armor",
                0));

        CustomItems.add(new Item("Silver Staff",
                +0,
                +35,
                +0,
                +25,
                +0,
                +20,
                +10,
                +5,
                +0,
                "none",
                "none",
                "Common",
                Material.STICK,
                "SILVER_STAFF",
                0,
                "Weapon",
                0));
        CustomItems.add(new Item("Short Bow",
                +0,
                +25,
                +0,
                +20,
                +20,
                +0,
                +10,
                +25,
                +0,
                "Rapid Fire",
                "none",
                "Common",
                Material.BOW,
                "SHORT_BOW",
                0,
                "Weapon",
                0));
        CustomItems.add(new Item("Copper Bow",
                +0,
                +30,
                +0,
                +25,
                +10,
                +0,
                +15,
                +20,
                +0,
                "none",
                "none",
                "Common",
                Material.BOW,
                "COPPER_BOW",
                0,
                "Weapon",
                0));
        CustomItems.add(new Item("Silver Bow",
                +0,
                +40,
                +0,
                +25,
                +5,
                +0,
                +15,
                +10,
                +25,
                "none",
                "none",
                "Common",
                Material.BOW,
                "SILVER_BOW",
                0,
                "Weapon",
                0));
        CustomItems.add(new Item("Shadowsong",
                +0,
                +130,
                +0,
                +140,
                +0,
                +0,
                +70,
                +55,
                +20,
                "none",
                "none",
                "legendary",
                Material.DIAMOND_SWORD,
                "SHADOWSONG",
                0,
                "Weapon",
                50));
        CustomItems.add(new Item("Quicksilver dagger",
                +0,
                +155,
                +0,
                +115,
                +25,
                +0,
                +0,
                +100,
                +5,
                "none",
                "none",
                "legendary",
                Material.IRON_SWORD,
                "QUICKSILVER_DAGGER",
                0,
                "Weapon",
                50));
        CustomItems.add(new Item("Dragonclaw",
                +0,
                +90,
                +0,
                +65,
                +0,
                +0,
                +25,
                +20,
                +0,
                "none",
                "none",
                "uncommon",
                Material.STONE_SWORD,
                "DRAGONCLAW",
                0,
                "Weapon",
                0));
        CustomItems.add(new Item("Sacrificial dagger",
                +0,
                +115,
                +0,
                +75,
                +0,
                +0,
                +50,
                +55,
                +0,
                "none",
                "none",
                "rare",
                Material.IRON_SWORD,
                "SACRIFICIAL_DAGGER",
                0,
                "Weapon",
                20));
        CustomItems.add(new Item("Nights Edge",
                +0,
                +215,
                +0,
                +135,
                +0,
                +0,
                +70,
                +50,
                +0,
                "none",
                "none",
                "legendary",
                Material.DIAMOND_SWORD,
                "NIGHTS_EDGE",
                0,
                "Weapon",
                60));
        CustomItems.add(new Item("Windcaller",
                +0,
                +110,
                +0,
                +0,
                +0,
                +45,
                +25,
                +40,
                +0,
                "none",
                "none",
                "rare",
                Material.BLAZE_ROD,
                "WINDCALLER",
                0,
                "Weapon",
                35));







        CustomReforges.add(new Reforge("Strength Artifact",
                10,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                "Rare",
                new ItemStack(Material.ARROW).getItemMeta(),
                "Strong",
                0,
                "Any",
                0));


        ItemStats.RegisteredReforges[0][0] = "Strength Artifact";
        ItemStats.RegisteredReforges[0][1] = "Strong";
        ItemStats.RegisteredReforges[1][0] = "Aegis of Zeus";
        ItemStats.RegisteredReforges[1][1] = "Reinforced";
        ItemStats.RegisteredReforges[2][0] = "The Wizards Last Wish";
        ItemStats.RegisteredReforges[2][1] = "Smart";
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return (Plugin) Bukkit.getServer().getPluginManager().getPlugin("MMORPGCustom");
    }
}
