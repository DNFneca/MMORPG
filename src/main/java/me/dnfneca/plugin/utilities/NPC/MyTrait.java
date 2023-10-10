package me.dnfneca.plugin.utilities.NPC;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Social.Main;
import me.dnfneca.plugin.utilities.managers.Social.NextConversation;
import net.citizensnpcs.api.ai.Goal;
import net.citizensnpcs.api.ai.GoalSelector;
import net.citizensnpcs.api.ai.tree.*;
import net.citizensnpcs.api.event.CitizensEnableEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitName;
import net.citizensnpcs.api.util.DataKey;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

@TraitName("stationaryNPC")
public class MyTrait extends Trait {
	public MyTrait() {
		super("stationaryNPC");
		plugin = JavaPlugin.getPlugin(Plugin.class);
	}

	Plugin plugin = null;

	boolean SomeSetting = false;

	// see the 'Persistence API' section
	@Persist("stationaryNPCsettings") boolean automaticallyPersistedSetting = false;

	// Here you should load up any values you have previously saved (optional).
	// This does NOT get called when applying the trait for the first time, only loading onto an existing npc at server start.
	// This is called AFTER onAttach so you can load defaults in onAttach and they will be overridden here.
	// This is called BEFORE onSpawn, npc.getEntity() will return null.
	public void load(DataKey key) {
		SomeSetting = key.getBoolean("SomeSetting", false);
	}

	// Save settings for this NPC (optional). These values will be persisted to the Citizens saves file

	public void save(DataKey key) {
		key.setBoolean("Somesetting", true);
	}

	// An example event handler. All traits will be registered automatically as Spigot event Listeners
	@EventHandler
	public void rclick(net.citizensnpcs.api.event.NPCRightClickEvent event){
		if(event.getNPC() != this.getNPC()) {
			return;
		}

		event.getClicker().sendMessage("Click");
		event.getClicker().sendMessage(String.valueOf(SomeSetting));
		//Handle a click on a NPC. The event has a getNPC() method.
		NextConversation.nextConversation(new String[]{"1", "start"}, event.getClicker());

	}

	@EventHandler
	public void lclick(net.citizensnpcs.api.event.NPCLeftClickEvent event){
		if(event.getNPC() != this.getNPC()) {
			return;
		}

		event.getClicker().sendMessage("Click");
		event.getClicker().sendMessage(String.valueOf(SomeSetting));
		//Handle a click on a NPC. The event has a getNPC() method.

	}

	// Called every tick
	@Override
	public void run() {
	}

	//Run code when your trait is attached to a NPC.
	//This is called BEFORE onSpawn, so npc.getEntity() will return null
	//This would be a good place to load configurable defaults for new NPCs.
	@Override
	public void onAttach() {
	}

	// Run code when the NPC is despawned. This is called before the entity actually despawns so npc.getEntity() is still valid.
	@Override
	public void onDespawn() {
	}

	//Run code when the NPC is spawned. Note that npc.getEntity() will be null until this method is called.
	//This is called AFTER onAttach and AFTER Load when the server is started.
	@Override
	public void onSpawn() {

	}

	//run code when the NPC is removed. Use this to tear down any repeating tasks.
	@Override
	public void onRemove() {
	}

}

