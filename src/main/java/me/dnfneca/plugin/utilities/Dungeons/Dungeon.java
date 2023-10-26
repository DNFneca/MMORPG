package me.dnfneca.plugin.utilities.Dungeons;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.Dungeons.Rooms.Door;
import me.dnfneca.plugin.utilities.Dungeons.Rooms.Room;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static me.dnfneca.plugin.utilities.Dungeons.Rooms.Room.setStartDoorLocation;


public class Dungeon {

	private final ArrayList<Location> setOfDoors = new ArrayList<>();
	private final ArrayList<Room> setOfRooms = new ArrayList<>();
	private final File file = new File("./world/generated/mmorpg/structures/");

	private Location currentLocation;



	public Dungeon(String type, Location location) {
		switch (type) {
			case "1":
				generateDungeon(1, 1, "1", location);
				break;
			case "2":
				generateDungeon(1, 1, "2", location);
				break;
		}
	}

	private void generateDungeon(int maxRooms, int minRooms, String type, Location startingLocation){


		int numOfRooms = ThreadLocalRandom.current().nextInt(minRooms, maxRooms + 1);

		int generatedNumOfRooms = 0;

		file.listFiles();

		ArrayList<String> poolOfRooms = new ArrayList<>();


		for (File f: file.listFiles()) {
			if(f.getName().contains(type) && !f.getName().contains("hallway")) {
				poolOfRooms.add(f.getName().replace(".nbt", ""));
			}
		}


		currentLocation = startingLocation;

		int currentRotation = 0;

		while (generatedNumOfRooms < numOfRooms) {

			int remainingRooms = numOfRooms - generatedNumOfRooms;

			int randomRoom = ThreadLocalRandom.current().nextInt(0, poolOfRooms.size());
//			Location loc = currentLocation;
//			loc.setZ(loc.getZ() + 1);
//			currentLocation = loc;
			new Room(poolOfRooms.get(randomRoom), currentLocation, this, currentRotation);
			generateRooms(poolOfRooms, poolOfRooms.get(randomRoom), currentLocation, type, currentRotation, 3);
//			for (Door door : Room.getRoomDoors(poolOfRooms.get(randomRoom), currentLocation, this, currentRotation)) {
//				if(generatedNumOfRooms < numOfRooms) {
//
//					int currentRandom = ThreadLocalRandom.current().nextInt(0, poolOfRooms.size());
//
////					System.out.println(currentLocation);
////					Room.setStartDoorLocation(poolOfRooms.get(randomRoom) , currentLocation, this, door);
//					Location temp = generateHallway(type, door.getLocation(), door.getDirection());
//					temp = alignRoom(poolOfRooms.get(currentRandom), temp, door.getDirection());
//					new Room(poolOfRooms.get(currentRandom), temp, this, door.getDirection());
//					Room.getRoomDoors(poolOfRooms.get(currentRandom), temp, this, door.getDirection());
//				}
//			}
			setStartDoorLocation(poolOfRooms.get(randomRoom), currentLocation, this);


//			Room.generateRoom("hallway1", currentLocation, this, currentRotation);
			generatedNumOfRooms++;
//			generateHallways(type, Room.getRoomStartDoor(poolOfRooms.get(randomRoom), currentLocation, this));
//			currentLocation = Room.getRoomDoors("hallway1", currentLocation, this);


		}


	}

	private int generated = 0;

	private void generateRooms(ArrayList<String> poolOfRooms, String roomName, Location currentLocation, String type, int rotation, int amountOfIterations) {
		if(generated >= amountOfIterations) {
			System.out.println("Done");
			return;
		}
		System.out.println("Generating");
		for (Door door : Room.getRoomDoors(roomName, currentLocation, this, rotation)) {
			int currentRandom = ThreadLocalRandom.current().nextInt(0, poolOfRooms.size());

//					System.out.println(currentLocation);
//					Room.setStartDoorLocation(poolOfRooms.get(randomRoom) , currentLocation, this, door);
			Location temp = generateHallway(type, door.getLocation(), door.getDirection());
			temp = alignRoom(poolOfRooms.get(currentRandom), temp, door.getDirection());
			System.out.println(temp);
			new Room(poolOfRooms.get(currentRandom), temp, this, door.getDirection());

			for (Door d : Room.getRoomDoors(poolOfRooms.get(currentRandom), temp, this, door.getDirection())) {
				int newRandom = ThreadLocalRandom.current().nextInt(0, poolOfRooms.size());
				Location t = generateHallway(type, d.getLocation(), d.getDirection());
				t = alignRoom(poolOfRooms.get(newRandom), t, d.getDirection());
				new Room(poolOfRooms.get(newRandom), t, this, d.getDirection());
				generated++;
				generateRooms(poolOfRooms, poolOfRooms.get(newRandom), t, type, door.getDirection(), amountOfIterations);

			}
			generated++;
			generateRooms(poolOfRooms, poolOfRooms.get(currentRandom), temp, type, door.getDirection(), amountOfIterations);
		}
	}

	public ArrayList<Room> getSetOfRooms() {
		return this.setOfRooms;
	}

	public void addToSetOfRooms(Room room) {
		this.setOfRooms.add(room);
	}

	public Location getCurrentLocation() {
		return this.currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public ArrayList<Location> getSetOfDoors() {
		return this.setOfDoors;
	}

	private Location alignRoom(String name, Location location, int rotation) {

		Location setLocation = location;
		switch (name) {
			case "tallroom1": case "room1":
				if(rotation == 90) {
					setLocation.setX(setLocation.getX() + 1);
				} else if(rotation == -90) {
					setLocation.setX(setLocation.getX() - 1);
				} else if(rotation == -180 || rotation == 180) {
					setLocation.setZ(setLocation.getZ() + 1);
				} else {
					setLocation.setZ(setLocation.getZ() - 1);
				}
				return setLocation;
			case "longroom1":
				if(rotation == 90) {
					setLocation.setX(setLocation.getX() + 1);
				} else if(rotation == -90) {
					setLocation.setX(setLocation.getX() - 1);
				} else if(rotation == -180 || rotation == 180) {
					setLocation.setZ(setLocation.getZ() + 1);
				} else {
					setLocation.setZ(setLocation.getZ() - 1);
				}
				return setLocation;
			case "tallroom2": case "room2":
				if(rotation == 90) {
					setLocation.setX(setLocation.getX() + 2);
				} else if(rotation == -90) {
					setLocation.setX(setLocation.getX() - 2);
				} else {
					setLocation.setZ(setLocation.getZ() - 2);
				}
				return setLocation;
			case "longroom2":
				if(rotation == 90) {
					setLocation.setX(setLocation.getX() + 1);
				} else if(rotation == -90) {
					setLocation.setX(setLocation.getX() - 1);
				} else {
					setLocation.setZ(setLocation.getZ() - 1);
				}
				return setLocation;
			default:
				setLocation.setX(setLocation.getX() + 4);
				return setLocation;

		}

//		switch (rotation) {
//			case 90:
//				structureRotation = StructureRotation.ROTATION_90;
//				break;
//			case -90:
//				structureRotation = StructureRotation.ROTATION_270;
//				break;
//			default:
//				structureRotation = StructureRotation.NONE;
//				break;
//		}

	}

	private Location generateHallway(String type, Location location, int rotation) {
		Path path = file.toPath().resolve("hallway" + type + ".nbt");

		Location returnLocation = location;



		switch (rotation) {
			case 90:
				if(type.equals("1")){
					returnLocation.setZ(returnLocation.getZ() + 2);

				} else if(type.equals("2")) {
					returnLocation.setZ(returnLocation.getZ() + 8);
				}
				break;
			case -90:
				if(type.equals("1")){
					returnLocation.setZ(returnLocation.getZ() - 2);

				} else if(type.equals("2")) {
					returnLocation.setZ(returnLocation.getZ() - 8);

				}
				break;
			case 180: case -180:
				if(type.equals("1")){
					returnLocation.setX(returnLocation.getX() - 2);
				} else if(type.equals("2")) {
					returnLocation.setX(returnLocation.getX() - 8);
				}
				break;
			default:
				if(type.equals("1")){
					returnLocation.setX(returnLocation.getX() + 2);
				} else if(type.equals("2")) {
					returnLocation.setX(returnLocation.getX() + 8);
				}

				break;
		}

		return returnLocation;

	}
}
