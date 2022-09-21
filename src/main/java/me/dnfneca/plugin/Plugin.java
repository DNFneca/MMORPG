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

        RegisterItem.RegisterNewItem("Sticky");
        RegisterItem.RegisterNewItem("Frozen Heart");
        StatsByName.SetStats("Sticky", new String[]{"1", "2000", "7", "1", "1", "0", "Common"});
        StatsByName.SetStats("Frozen Heart", new String[]{"9", "9", "9", "9", "9", "9", "Mythic"});

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return (Plugin) Bukkit.getServer().getPluginManager().getPlugin("MMORPGCustom");
    }
}
