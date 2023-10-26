package me.dnfneca.plugin.utilities.Dungeons.Rooms;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.Dungeons.Dungeon;
import org.bukkit.Location;

import java.io.File;
import java.nio.file.Path;



public class Door {

	private static final File file = new File("./world/generated/mmorpg/structures/");

	private Location location;
	private int direction;

	public Door(Location location, int direction, String type) {
		this.direction = direction;
		this.location = location;
		init(location, direction, type);
	}

	private void init(Location roomLocation, int rotation, String type) {
		Path path = file.toPath().resolve("hallway" + type + ".nbt");

		StructureRotation structureRotation;


		switch (rotation) {
			case 90:
				structureRotation = StructureRotation.ROTATION_90;
				break;
			case -90:
				structureRotation = StructureRotation.ROTATION_270;
				break;
			case 180: case -180:
				structureRotation = StructureRotation.ROTATION_180;
				break;
			default:
				structureRotation = StructureRotation.NONE;
				break;
		}

		StructureBlockLibApi.INSTANCE
				.loadStructure(Plugin.getInstance())
				.at(roomLocation)
				.rotation(structureRotation)
				.loadFromPath(path);

	}

	public int getDirection() {
		return this.direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}
}
