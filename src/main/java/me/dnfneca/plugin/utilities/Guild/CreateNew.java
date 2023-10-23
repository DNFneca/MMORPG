package me.dnfneca.plugin.utilities.Guild;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

import java.awt.*;

public class CreateNew {
	public static void Guild(String Name, String Type) {
		WorldCreator worldCreator = new WorldCreator("my_dimension");
		worldCreator.type(WorldType.FLAT);
		worldCreator.generatorSettings("{\"layers\": [{\"block\": \"stone\", \"height\": 0}, {\"block\": \"grass_block\", \"height\": 0}], \"biome\":\"void\"}");
		worldCreator.generateStructures(false);
		worldCreator.createWorld();

	}

}
