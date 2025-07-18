package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Waystone implements Listener {
	public static void WaystoneMenu(Player p, String menuName) {
		Inventory inv = Bukkit.createInventory(null, 27, menuName);


		String[] waystoneNames = getWaystonesNames(p);
		int numofWaystones = 0;
		for (String s : waystoneNames) {
			if (null != s) {
				numofWaystones++;
			}
		}

		ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
		ItemStack gray_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);

		ItemStack next = new ItemStack(Material.ARROW, 1);
		ItemStack back = new ItemStack(Material.ARROW, 1);

		ItemMeta nextData = next.getItemMeta();
		nextData.setDisplayName("Next");
		next.setItemMeta(nextData);

		ItemMeta backData = next.getItemMeta();
		backData.setDisplayName("Back");
		back.setItemMeta(backData);

		ItemStack waystone1 = new ItemStack(Material.GRASS_BLOCK, 1);
		ItemStack waystone2 = new ItemStack(Material.GRASS_BLOCK, 1);
		ItemStack waystone3 = new ItemStack(Material.GRASS_BLOCK, 1);
		ItemStack waystone4 = new ItemStack(Material.GRASS_BLOCK, 1);

		if (1 == numofWaystones) {
			waystone2.setType(Material.AIR);
			waystone3.setType(Material.AIR);
			waystone4.setType(Material.AIR);
		} else if (2 == numofWaystones) {
			waystone3.setType(Material.AIR);
			waystone4.setType(Material.AIR);
		} else if (3 == numofWaystones) {
			waystone4.setType(Material.AIR);
		}

		ItemMeta waystone1Data = waystone1.getItemMeta();
		ItemMeta waystone2Data = waystone2.getItemMeta();
		ItemMeta waystone3Data = waystone3.getItemMeta();
		ItemMeta waystone4Data = waystone4.getItemMeta();

		String Page = "1";
		int waystoneNum = 0;

		if (menuName.contains("Page")) {
			String s = menuName;
			String[] sedit1 = s.split(" ");
			Page = sedit1[sedit1.length - 1];
		}
		boolean isPage1 = 1 == Integer.parseInt(Page);

		int temp = 0;

		waystoneNum = Integer.parseInt(Page) * 4 - 4;

		for (; waystoneNum < numofWaystones; waystoneNum++) {
			switch (temp) {
				case 0 -> waystone1Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
				case 1 -> waystone2Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
				case 2 -> waystone3Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
				case 3 -> waystone4Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
			}
			temp++;
		}

		if (1 == temp) {
			waystone2.setType(Material.AIR);
			waystone3.setType(Material.AIR);
			waystone4.setType(Material.AIR);
		} else if (2 == temp) {
			waystone3.setType(Material.AIR);
			waystone4.setType(Material.AIR);
		} else if (3 == temp) {
			waystone4.setType(Material.AIR);
		} else if (0 == temp) {
			waystone1.setType(Material.AIR);
			waystone2.setType(Material.AIR);
			waystone3.setType(Material.AIR);
			waystone4.setType(Material.AIR);
		}

		waystone1.setItemMeta(waystone1Data);
		waystone2.setItemMeta(waystone2Data);
		waystone3.setItemMeta(waystone3Data);
		waystone4.setItemMeta(waystone4Data);

		ItemMeta purple_glassData = purple_glass.getItemMeta();
		purple_glassData.setDisplayName(ChatColor.GRAY + "   ");
		purple_glass.setItemMeta(purple_glassData);

		ItemMeta gray_glassData = gray_glass.getItemMeta();
		gray_glassData.setDisplayName(ChatColor.GRAY + "   ");
		gray_glass.setItemMeta(gray_glassData);

		for (int i = 0; 27 > i; i++) {
			if (0 == i % 2 && !(10 == i || 12 == i || 14 == i || 16 == i)) {
				inv.setItem(i, purple_glass);
			} else if (0 != i % 2) {
				inv.setItem(i, gray_glass);
			}
		}
		if (5 > numofWaystones) {
			for (int i = 0; 27 > i; i++) {

				if (10 == i) {
					inv.setItem(10, waystone1);
				} else if (12 == i) {
					inv.setItem(12, waystone2);
				} else if (14 == i) {
					inv.setItem(14, waystone3);
				} else if (16 == i) {
					inv.setItem(16, waystone4);
				}
			}
		} else {
			for (int i = 0; 27 > i; i++) {

				if (10 == i) {
					inv.setItem(10, waystone1);
				} else if (12 == i) {
					inv.setItem(12, waystone2);
				} else if (14 == i) {
					inv.setItem(14, waystone3);
				} else if (16 == i) {
					inv.setItem(16, waystone4);
				}
			}
			if (4 < temp)
				inv.setItem(26, next);
			if (!isPage1)
				inv.setItem(18, back);
		}

		p.openInventory(inv);

	}

	public static String[][] getWaystones(Player p) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8));//path to the JSON file.

			Object values = data.get(p.getUniqueId().toString());
			String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
			String[] array = edit1.split(",");

			String[][] waypoints = new String[100][100];
			int temp = 0;
			int i = 0, j = 0;
			for (String s : array) {
				if (s.contains("Waystone")) {
					temp = 0;
				}
				switch (temp) {
					case 0, 1, 2 -> {
						waypoints[i][j] = s;
						j++;
					}
					case 3 -> {
						waypoints[i][j] = s;
						i++;
						j = 0;
					}
				}
				temp++;
			}
			return waypoints;
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String[] getWaystonesNames(Player p) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Waystones.json", StandardCharsets.UTF_8));//path to the JSON file.

			Object values = data.get(p.getUniqueId().toString());
			String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
			String[] array = edit1.split(",");

			String[] waystones = new String[100];
			int i = 0;
			for (String s : array) {
				if (s.contains("Waystone")) {
					waystones[i] = s;
					i++;
				}
			}
			return waystones;
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}


	public static String[] findWaystoneByName(Player p, String waystoneName) {
		String[][] playerWaystones = getWaystones(p);
		String[] waystoneLocation = new String[100];
		for (int i = 0; 100 > i; i++) {
			for (int j = 0; 100 > j; j++) {
				if (null != playerWaystones[i][j]) {
					playerWaystones[i][j] = playerWaystones[i][j].strip();
					if (playerWaystones[i][j].contains(waystoneName)) {
						waystoneLocation[0] = playerWaystones[i][j + 1];
						waystoneLocation[1] = playerWaystones[i][j + 2];
						waystoneLocation[2] = playerWaystones[i][j + 3];
					}
				}
			}
		}
		return waystoneLocation;
	}

	@EventHandler
	public void onInventoryEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		List<String> lore = new ArrayList<>();
		Inventory inv = e.getInventory();

		ItemStack ClickedItem = null;

		try {
			ClickedItem = e.getCurrentItem();
		} catch (Error error) {
			System.out.println(error);
		}
		if (null == ClickedItem) {
			return;
		}

		String[] waystoneNames = getWaystonesNames(p);
		int numofWaystones = 0;
		for (String s : waystoneNames) {
			if (null != s) {
				numofWaystones++;
			}
		}


		if (null != ClickedItem.getItemMeta() && null != ClickedItem.getItemMeta().getDisplayName() && ClickedItem.getItemMeta().getDisplayName().contains("Waystone")) {
			int i = 0;
			for (String s : waystoneNames) {
				if (ClickedItem.getItemMeta().getDisplayName().contains(waystoneNames[i])) {
					String[] location = findWaystoneByName(p, waystoneNames[i]);
					Location playerloc = p.getLocation();
					Location standV = new Location(p.getWorld(), Float.parseFloat(location[0]), Float.parseFloat(location[1]), Float.parseFloat(location[2]));
					Vector face = playerloc.toVector().subtract(standV.toVector());
					playerloc.setDirection(face);
					standV.setYaw(playerloc.getYaw());
					p.sendMessage(String.valueOf(playerloc));
//                    standV.setDirection(p.getLocation().toVector().subtract(standV.toVector()));
					p.teleport(standV);

				}
				i++;
			}
		}

		if (null != ClickedItem.getItemMeta() && null != ClickedItem.getItemMeta().getDisplayName() && ClickedItem.getItemMeta().getDisplayName().contains("Next")) {
			int Page = 1;
			String pageName = "";

			if (p.getOpenInventory().getTitle().contains("Page")) {
				String s = p.getOpenInventory().getTitle();
				String[] sedit1 = s.split(" ");
				Page = Integer.parseInt(sedit1[sedit1.length - 1]) + 1;
				for (int i = 0; i < sedit1.length - 1; i++) {
					if (!pageName.isEmpty()) {
						pageName = pageName + " ";
					}
					pageName = pageName + sedit1[i];
				}
			} else {
				Page++;
				pageName = p.getOpenInventory().getTitle();
				pageName = pageName + " Page";
			}

			WaystoneMenu(p, pageName + " " + Page);
		}

		if (null != ClickedItem.getItemMeta() && null != ClickedItem.getItemMeta().getDisplayName() && ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
			int Page = 1;
			String pageName = "";

			if (p.getOpenInventory().getTitle().contains("Page")) {
				String s = p.getOpenInventory().getTitle();
				String[] sedit1 = s.split(" ");
				Page = Integer.parseInt(sedit1[sedit1.length - 1]) - 1;
				for (int i = 0; i < sedit1.length - 1; i++) {
					if (!pageName.isEmpty()) {
						pageName = pageName + " ";
					}
					pageName = pageName + sedit1[i];
				}
			} else {
				Page--;
				pageName = p.getOpenInventory().getTitle();
				pageName = pageName + " Page";
			}

			WaystoneMenu(p, pageName + " " + Page);
		}


	}
}