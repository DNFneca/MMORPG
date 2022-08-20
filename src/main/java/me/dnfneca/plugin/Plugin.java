package me.dnfneca.plugin;

import me.dnfneca.plugin.Commands.test;
import me.dnfneca.plugin.listeners.*;
import me.dnfneca.plugin.utilities.managers.CustomMobs.MyCreature;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Objects.requireNonNull(this.getCommand("test")).setExecutor(new @NonNull test());
//        Objects.requireNonNull(getCommand("god")).setExecutor(new God());
//        Objects.requireNonNull(getCommand("gui")).setExecutor(new GUI());


        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new AttackListener(), this);
        getServer().getPluginManager().registerEvents(new FishingListener(), this);
        getServer().getPluginManager().registerEvents(new MobHealthListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHealthListener(), this);
        getServer().getPluginManager().registerEvents(new MyCreature(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
//        getServer().getPluginManager().registerEvents(new (this), this);




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
