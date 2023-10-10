package me.dnfneca.plugin.utilities.NPC;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

import java.util.concurrent.atomic.AtomicInteger;

public class util {
	public static NPC getNPCbyName(String Name) {
		AtomicInteger i = new AtomicInteger();
		CitizensAPI.getNPCRegistry().forEach(npc ->
		{
			if(npc.getName().contains(Name)) {
				CitizensAPI.getNPCRegistry().getById(i.get());
			}
			i.getAndIncrement();
		});
		return null;
	}
}
