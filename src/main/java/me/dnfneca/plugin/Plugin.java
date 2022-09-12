package me.dnfneca.plugin;

import me.dnfneca.plugin.Commands.*;
import me.dnfneca.plugin.listeners.*;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicWolf;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Dummy;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Ghoul;
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

        this.getCommand("summon").setExecutor(new @NonNull summon());
        this.getCommand("summon").setTabCompleter(new summonTabComplete());
        this.getCommand("item").setExecutor(new @NonNull item());
        this.getCommand("item").setTabCompleter(new itemTabComplete());
        this.getCommand("classreset").setExecutor(new @NonNull classreset());
        this.getCommand("NPC").setExecutor(new @NonNull NPC());
        this.getCommand("deleteEveryNPC").setExecutor(new @NonNull deleteEveryNPC());
//        Objects.requireNonNull(getCommand("god")).setExecutor(new God());
//        Objects.requireNonNull(getCommand("gui")).setExecutor(new GUI());



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
//        getServer().getPluginManager().registerEvents(new (this), this);




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return (Plugin) Bukkit.getServer().getPluginManager().getPlugin("MMORPGCustom");
    }
}
