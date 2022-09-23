package me.dnfneca.plugin;

import me.dnfneca.plugin.Commands.*;
import me.dnfneca.plugin.listeners.*;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicWolf;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Dummy;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Ghoul;
import me.dnfneca.plugin.utilities.managers.Item.RegisterItem;
import me.dnfneca.plugin.utilities.managers.Item.StatsByName;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public final class Plugin extends JavaPlugin {

    public static List<EntityPlayer> npcs = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic



        Plugin instance = this;

        this.getCommand("summonmob").setExecutor(new @NonNull summonmob());
        this.getCommand("summonmob").setTabCompleter(new summonTabComplete());
        this.getCommand("item").setExecutor(new @NonNull item());
        this.getCommand("item").setTabCompleter(new itemTabComplete());
        this.getCommand("classreset").setExecutor(new @NonNull classreset());
        this.getCommand("NPC").setExecutor(new @NonNull NPC());
        this.getCommand("deleteEveryNPC").setExecutor(new @NonNull deleteEveryNPC());
//        Objects.requireNonNull(getCommand("god")).setExecutor(new God());
        this.getCommand("GUI").setExecutor(new GUI());
        this.getCommand("getregistereditems").setExecutor(new GetRegisteredItems());



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
//        getServer().getPluginManager().registerEvents(new (this), this);


        // ITEMS




        //            health
        //            damage
        //            defence
        //            strength
        //            mana +
        //            critdamage
        //            critchance
        //            Type
        //            Ab Name
        //            Rarity


        RegisterItem.RegisterNewItem("Sticky");
        RegisterItem.RegisterNewItem("Wise Man's Coat");
        RegisterItem.RegisterNewItem("Wise Man's Hat");
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
        StatsByName.SetStats("Sticky", new String[]{"0", "20", "0", "25", "125", "0", "0", "Weapon", "0", "Common"});
        StatsByName.SetStats("Wise Man's Coat", new String[]{"30", "0", "10", "0", "200", "0", "0", "Armor", "0", "Epic"});
        StatsByName.SetStats("Wise Man's Hat", new String[]{"20", "0", "5", "0", "200", "0", "0", "Armor", "0", "Epic"});
        StatsByName.SetStats("Wise Man's Trousers", new String[]{"30", "0", "10", "0", "200", "0", "0", "Armor", "0", "Epic"});
        StatsByName.SetStats("Wise Man's Boots", new String[]{"20", "0", "5", "0", "200", "0", "0", "Armor", "0", "Epic"});
        StatsByName.SetStats("Aspect of the Nether", new String[]{"0", "100", "0", "125", "0", "200", "100", "Weapon", "0", "Legendary"});
        StatsByName.SetStats("Eros's Bow", new String[]{"0", "250", "0", "75", "0", "350", "75", "Weapon", "0", "Mythic"});
        StatsByName.SetStats("Longsword", new String[]{"0", "55", "0", "0", "0", "40", "20", "Weapon", "0", "Uncommon"});
        StatsByName.SetStats("The Void", new String[]{"0", "120", "0", "70", "0", "55", "45", "Weapon", "0", "Rare"});
        StatsByName.SetStats("Holy Iron Sword", new String[]{"0", "40", "0", "30", "0", "15", "5", "Weapon", "0", "Common"});
        StatsByName.SetStats("Mithril Blade", new String[]{"0", "80", "0", "65", "0", "30", "10", "Weapon", "0", "Rare"});
        StatsByName.SetStats("Bloodquench", new String[]{"0", "100", "0", "75", "0", "55", "30", "Weapon", "0", "Rare"});
        StatsByName.SetStats("Winterthorn", new String[]{"0", "85", "0", "60", "0", "20", "5", "Weapon", "0", "Common"});
        StatsByName.SetStats("Black Sword", new String[]{"0", "120", "0", "65", "0", "40", "10", "Weapon", "0", "Rare"});
        StatsByName.SetStats("Unholy Great Sword", new String[]{"0", "95", "0", "105", "0", "35", "30", "Weapon", "0", "Rare"});



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return (Plugin) Bukkit.getServer().getPluginManager().getPlugin("MMORPGCustom");
    }
}
