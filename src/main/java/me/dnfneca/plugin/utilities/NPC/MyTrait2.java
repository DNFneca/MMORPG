package me.dnfneca.plugin.utilities.NPC;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Social.NextConversation;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.Goal;
import net.citizensnpcs.api.ai.GoalSelector;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitName;
import net.citizensnpcs.api.util.DataKey;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcmonkey.sentinel.SentinelTrait;

import java.util.List;

import static me.dnfneca.plugin.utilities.managers.Health.PlayerHealth.DealDamageToPlayer;

@TraitName("BorderGuard")
public class MyTrait2 extends Trait {
	public MyTrait2() {
		super("BorderGuard");
		plugin = JavaPlugin.getPlugin(Plugin.class);
	}

	Plugin plugin = null;

	boolean SomeSetting = false;

	// see the 'Persistence API' section
	@Persist("BorderGuardsettings")
	boolean automaticallyPersistedSetting = false;

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
	public void lclick(net.citizensnpcs.api.event.NPCLeftClickEvent event) {
		System.out.println(event);
		if (event.getNPC() != this.getNPC()) {
			return;
		}

		event.getClicker().sendMessage("AA");
		SentinelTrait sentinel = npc.getOrAddTrait(SentinelTrait.class);
		sentinel.addTarget(String.valueOf(event.getClicker().getName()));
		//Handle a click on a NPC. The event has a getNPC() method.

	}
	@EventHandler
	public void lclick(net.citizensnpcs.api.event.NPCDamageEntityEvent event) {
		System.out.println(event);
		if (event.getNPC() != this.getNPC()) {
			return;
		}
		DealDamageToPlayer(100, (Player) event.getDamaged(), "Border Guard");

//		event.getClicker().sendMessage("AA");
//		SentinelTrait sentinel = npc.getOrAddTrait(SentinelTrait.class);
//		sentinel.addTarget(String.valueOf(event.getClicker().getName()));
		//Handle a click on a NPC. The event has a getNPC() method.

	}

	// Called every tick
	@Override
	public void run() {
//		if(npc.hasTrait(SentinelTrait.class)) {
//			SentinelTrait sentinel = npc.getOrAddTrait(SentinelTrait.class);
//			System.out.println(npc.getEntity().getUniqueId());
//			Entity thisnpc = npc.getEntity();
//			List<Entity> entityaround;
//			List<Player> playerAround;
//			entityaround = thisnpc.getNearbyEntities(25, 25, 25);
//			for (Entity p : entityaround) {
//				if (p instanceof Player) {
////					int stealth = ((Player) p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
//
//				    if (thisnpc.getLocation().distance(p.getLocation()) < 40 - 40 * 0 * 0.01) {
//						System.out.println(p.getName());
////					sentinel.addTarget(String.valueOf(p));
////
////
//				    }
//				}
//		}
//
//		}
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
