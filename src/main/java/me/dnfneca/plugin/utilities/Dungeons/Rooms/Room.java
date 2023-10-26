package me.dnfneca.plugin.utilities.Dungeons.Rooms;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.Dungeons.Dungeon;
import org.bukkit.Location;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class Room {

	private static final File file = new File("./world/generated/mmorpg/structures/");

	private Double[] boundries = new Double[3];

	private Location location;

	public Room(String roomName, Location roomLocation, Dungeon dungeon, int rotation) {
		Path path = file.toPath().resolve(roomName + ".nbt");

		StructureRotation structureRotation;


		switch (rotation) {
			case 90:
				structureRotation = StructureRotation.ROTATION_90;
				break;
			case -90:
				structureRotation = StructureRotation.ROTATION_270;
				break;
			case -180: case 180:
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


	public static ArrayList<Door> getRoomDoors(String roomName, Location location, Dungeon dungeon, int rotation) {
		ArrayList<Door> returnList = new ArrayList<>();
		switch (roomName) {
//			case "hallway1":
//				returnList.add(new Door(new Location(location.getWorld(), location.getX() +2, location.getY(), location.getZ()), 0));
//				break;
			case "tallroom1":
				if(rotation == 90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() - 1, location.getY(), location.getZ() + 3), 90, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY(), location.getZ() + 1), 0, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() - 3, location.getY() + 2, location.getZ() + 1), 180, "1"));
				} else if (rotation == -90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY(), location.getZ() - 3), -90, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() - 1, location.getY(), location.getZ() - 1), 180, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 3, location.getY() + 2, location.getZ() - 1), 0, "1"));
				} else if (rotation == -180 || rotation == 180) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY(), location.getZ() + 3), 0, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY(), location.getZ() - 1), +90, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 3, location.getY() + 2, location.getZ() + 1), -90, "1"));
				} else {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 3, location.getY(), location.getZ() + 1), 0, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY(), location.getZ() - 1), -90, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY() + 2, location.getZ() + 3), +90, "1"));
				}

				break;
			case "room1":
				if(rotation == 90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ() + 3), 90, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ() + 1), 0, "1"));
				} else if (rotation == -90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ() - 3), -90, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ() - 1), 180, "1"));
				} else if (rotation == -180 || rotation == 180) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ() + 3), 0, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ() - 1), +90, "1"));
				} else {
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+3, location.getY(), location.getZ() + 1), 0, "1"));
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ() - 1), -90, "1"));
				}

				break;
			case "longroom1":
				if(rotation == 90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() - 1, location.getY(), location.getZ() + 4), 90, "1"));
				} else if (rotation == -90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY(), location.getZ() - 4), -90, "1"));
				} else {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 4, location.getY(), location.getZ()+1), 0, "1"));
				}
				break;
			case "tallroom2":
				if(rotation == 90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() - 2, location.getY() + 7, location.getZ() + 8), 90, "2"));
				} else if (rotation == -90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 2, location.getY() + 7, location.getZ() - 8), -90, "2"));
				} else {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 8, location.getY() + 7, location.getZ() + 2), 0, "2"));
				}

				break;
			case "room2":
				if(rotation == 90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX()-2, location.getY(), location.getZ() - 8), 90, "2"));
				} else if (rotation == -90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+2, location.getY(), location.getZ() + 8), -90, "2"));
				} else {
					returnList.add(new Door(new Location(location.getWorld(), location.getX()+8, location.getY(), location.getZ() + 2), 0, "2"));
				}

				break;
			case "longroom2":
				if(rotation == 90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() - 1, location.getY(), location.getZ() - 9), 90, "2"));
				} else if (rotation == -90) {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 1, location.getY(), location.getZ() + 9), -90, "2"));
				} else {
					returnList.add(new Door(new Location(location.getWorld(), location.getX() + 9, location.getY(), location.getZ() + 1), 0, "2"));
				}
				break;
			default:
				returnList.add(new Door(new Location(location.getWorld(), location.getX()+4, location.getY(), location.getZ()+1), 0, "1"));
				break;
		}
		return returnList;
	}

	public static void setStartDoorLocation(String roomName, Location location, Dungeon dungeon) {
		Location setLocation = location;
		System.out.println(roomName);
		switch (roomName) {
			case "tallroom1": case "room1":
				setLocation.setX(setLocation.getX() + 15);
				dungeon.setCurrentLocation(setLocation);
				break;
			case "longroom1":
				setLocation.setX(setLocation.getX() + 15);
				dungeon.setCurrentLocation(setLocation);
				break;

			default:
				setLocation.setX(setLocation.getX());
				dungeon.setCurrentLocation(setLocation);
				break;
		}
	}
}
