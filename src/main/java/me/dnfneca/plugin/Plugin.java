package me.dnfneca.plugin;

import me.dnfneca.plugin.Commands.*;
import me.dnfneca.plugin.listeners.*;
import me.dnfneca.plugin.utilities.GUI.Waystone;
import me.dnfneca.plugin.utilities.inventory.ItemStats;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicWolf;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Dummy;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Ghoul;
import me.dnfneca.plugin.utilities.managers.Item.RegisterItem;
import me.dnfneca.plugin.utilities.managers.Item.StatsByName;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.File;

public final class Plugin extends JavaPlugin {

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
        this.getCommand("getregistereditems").setExecutor(new GetRegisteredItems());
        this.getCommand("getregisteredreforges").setExecutor(new GetRegisteredReforges());




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
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new LeftClickListener(), this);
        getServer().getPluginManager().registerEvents(new CraftingTableListener(), this);
        getServer().getPluginManager().registerEvents(new DropItemListener(), this);
        getServer().getPluginManager().registerEvents(new ForgeMenuListener(), this);
        getServer().getPluginManager().registerEvents(new Waystone(), this);

//        getServer().getPluginManager().registerEvents(new (this), this);


        // ITEMS


        RegisterItem.RegisterNewItem("Sticky");
        RegisterItem.RegisterNewItem("Wise Man's Hat");
        RegisterItem.RegisterNewItem("Wise Man's Coat");
        RegisterItem.RegisterNewItem("Wise Man's Trousers");
        RegisterItem.RegisterNewItem("Wise Man's Boots");
        RegisterItem.RegisterNewItem("Aspect of the Nether");
        RegisterItem.RegisterNewItem("Eros's Bow");
        RegisterItem.RegisterNewItem("Longsword");
        RegisterItem.RegisterNewItem("The Void");
        RegisterItem.RegisterNewItem("Holy Iron Sword");
        RegisterItem.RegisterNewItem("Mithril Blade");
        RegisterItem.RegisterNewItem("Bloodquench");
        RegisterItem.RegisterNewItem("Winterthorn");
        RegisterItem.RegisterNewItem("Black Sword");
        RegisterItem.RegisterNewItem("Unholy Great Sword");
        RegisterItem.RegisterNewItem("Blunt Sword");
        RegisterItem.RegisterNewItem("Silver Short Sword");
        RegisterItem.RegisterNewItem("Copper Great Sword");
        RegisterItem.RegisterNewItem("Copper Sword");
        RegisterItem.RegisterNewItem("Wand");
        RegisterItem.RegisterNewItem("Short Staff");
        RegisterItem.RegisterNewItem("Silver Staff");
        RegisterItem.RegisterNewItem("Dawn");
        RegisterItem.RegisterNewItem("Cataclysm");
        RegisterItem.RegisterNewItem("Doomblade");
        RegisterItem.RegisterNewItem("Lightbane");
        RegisterItem.RegisterNewItem("Silverlight");
        RegisterItem.RegisterNewItem("Ghost Reaver");

//        JSONObject jsonObject = new JSONObject();
//
//        JSONArray array = new JSONArray();
//        array.add("0");
//        array.add("+20");
//        array.add("+25");
//        array.add("+125");
//        array.add("0");
//
//
//        jsonObject.put("Sticky",array);
//        try {
//            FileWriter file = new FileWriter("./plugins/MMORPGData/MainData.json");
//            file.write(jsonObject.toJSONString());
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//      StatsByMame.SetStats(ItemName, new String[]{Health, Damage, Defence, Strength, Mana, CriticalDamage, CriticalChance, Type, AbilityName, Rarity})
        StatsByName.SetStats("Sticky", new String[]{"0", "+20", "0", "+25", "+125", "0", "0", "Stick", "Fireball", "Common"});
        StatsByName.SetStats("Wise Man's Hat", new String[]{"+20", "0", "+5", "0", "+200", "0", "0", "Helmet", "0", "Epic"});
        StatsByName.SetStats("Wise Man's Coat", new String[]{"+30", "0", "+10", "0", "+200", "0", "0", "Chestplate", "0", "Epic"});
        StatsByName.SetStats("Wise Man's Trousers", new String[]{"+30", "0", "10", "0", "+200", "0", "0", "Leggings", "0", "Epic"});
        StatsByName.SetStats("Wise Man's Boots", new String[]{"+20", "0", "+5", "0", "+200", "0", "0", "Boots", "0", "Epic"});
        StatsByName.SetStats("Aspect of the Nether", new String[]{"0", "+100", "0", "+125", "0", "+200", "+100", "Sword", "0", "Legendary"});
        StatsByName.SetStats("Eros's Bow", new String[]{"0", "+250", "0", "+75", "0", "+350", "+75", "Bow", "0", "Mythic"});
        StatsByName.SetStats("Longsword", new String[]{"0", "+55", "0", "0", "0", "+40", "+20", "Sword", "0", "Uncommon"});
        StatsByName.SetStats("The Void", new String[]{"0", "+120", "0", "+70", "0", "+55", "+45", "Sword", "0", "Rare"});
        StatsByName.SetStats("Holy Iron Sword", new String[]{"0", "+40", "0", "+30", "0", "+15", "+5", "Sword", "0", "Common"});
        StatsByName.SetStats("Mithril Blade", new String[]{"0", "+80", "0", "+65", "0", "+30", "+10", "Sword", "0", "Rare"});
        StatsByName.SetStats("Bloodquench", new String[]{"0", "+100", "0", "+75", "0", "+55", "+30", "Sword", "0", "Rare"});
        StatsByName.SetStats("Winterthorn", new String[]{"0", "+85", "0", "+60", "0", "+20", "+5", "Sword", "0", "Common"});
        StatsByName.SetStats("Black Sword", new String[]{"0", "+120", "0", "+65", "0", "+40", "+10", "Sword", "0", "Rare"});
        StatsByName.SetStats("Unholy Great Sword", new String[]{"0", "+95", "0", "+105", "0", "+35", "+30", "Sword", "0", "Rare"});
        StatsByName.SetStats("Blunt Sword", new String[]{"0", "+40", "0", "+30", "0", "+20", "+10", "Sword", "0", "Common"});
        StatsByName.SetStats("Silver Short Sword", new String[]{"0", "+45", "0", "+40", "0", "+25", "+10", "Sword", "0", "Common"});
        StatsByName.SetStats("Copper Great Sword", new String[]{"0", "+40", "0", "+35", "0", "+20", "+15", "Sword", "0", "Common"});
        StatsByName.SetStats("Copper Sword", new String[]{"0", "+60", "0", "+25", "0", "+35", "+20", "Sword", "0", "Common"});
        StatsByName.SetStats("Wand", new String[]{"0", "+50", "0", "+30", "+25", "+20", "+10", "Stick", "Wave", "Common"});
        StatsByName.SetStats("Short Staff", new String[]{"0", "+45", "0", "+35", "+30", "+30", "+15", "Stick", "0", "Common"});
        StatsByName.SetStats("Silver Staff", new String[]{"0", "+35", "0", "+25", "+40", "+30", "+5", "Stick", "0", "Common"});
        StatsByName.SetStats("Ghost Reaver", new String[]{"0", "+345", "0", "+220", "0", "+730", "+90", "Scythe", "0", "Exotic"});

//      StatsByMame.SetStats(ItemName, new String[]{Health, Damage, Defence, Strength, Mana, CriticalDamage, CriticalChance, Type, AbilityName, Rarity})


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
