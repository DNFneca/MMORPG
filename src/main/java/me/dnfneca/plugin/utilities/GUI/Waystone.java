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
import java.util.ArrayList;
import java.util.List;

public class Waystone implements Listener {
    public static void WaystoneMenu(Player p, String menuName) {
        Inventory inv = Bukkit.createInventory(null, 27, menuName);




        String[] waystoneNames = getWaystonesNames(p);
        int numofWaystones = 0;
        for (String s:waystoneNames) {
            if(s != null) {
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

        if(numofWaystones == 1) {
            waystone2.setType(Material.AIR);
            waystone3.setType(Material.AIR);
            waystone4.setType(Material.AIR);
        } else if(numofWaystones == 2) {
            waystone3.setType(Material.AIR);
            waystone4.setType(Material.AIR);
        } else if(numofWaystones == 3) {
            waystone4.setType(Material.AIR);
        }

        ItemMeta waystone1Data = waystone1.getItemMeta();
        ItemMeta waystone2Data = waystone2.getItemMeta();
        ItemMeta waystone3Data = waystone3.getItemMeta();
        ItemMeta waystone4Data = waystone4.getItemMeta();

        String Page = "1";
        int waystoneNum = 0;

        if(menuName.contains("Page")) {
            String s = menuName;
            String[] sedit1 = s.split(" ");
            Page = sedit1[sedit1.length - 1];
        }
        boolean isPage1 = true;
        if(Integer.parseInt(Page) != 1)
            isPage1 = false;

        int temp = 0;

        waystoneNum = Integer.parseInt(Page) * 4 - 4;

        for (; waystoneNum<numofWaystones; waystoneNum++) {
            switch (temp) {
                case 0 -> waystone1Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
                case 1 -> waystone2Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
                case 2 -> waystone3Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
                case 3 -> waystone4Data.setDisplayName(ChatColor.GREEN + waystoneNames[waystoneNum]);
            }
            temp++;
        }

        if(temp == 1) {
            waystone2.setType(Material.AIR);
            waystone3.setType(Material.AIR);
            waystone4.setType(Material.AIR);
        } else if(temp == 2) {
            waystone3.setType(Material.AIR);
            waystone4.setType(Material.AIR);
        } else if(temp == 3) {
            waystone4.setType(Material.AIR);
        } else if (temp == 0) {
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

        for(int i = 0; i < 27; i++) {
            if(i % 2 == 0 && !(i == 10 || i == 12 || i == 14 || i == 16)) {
                inv.setItem(i, purple_glass);
            } else if(i % 2 != 0) {
                inv.setItem(i, gray_glass);
            }
        }
        if(numofWaystones < 5) {
            for(int i = 0; i<27; i++) {

                if(i == 10) {
                    inv.setItem(i, waystone1);
                } else if ( i == 12) {
                    inv.setItem(i, waystone2);
                } else if (i == 14) {
                    inv.setItem(i, waystone3);
                } else if (i == 16) {
                    inv.setItem(i, waystone4);
                }
            }
        } else {
            for(int i = 0; i<27; i++) {

                if(i == 10) {
                    inv.setItem(i, waystone1);
                } else if ( i == 12) {
                    inv.setItem(i, waystone2);
                } else if (i == 14) {
                    inv.setItem(i, waystone3);
                } else if (i == 16) {
                    inv.setItem(i, waystone4);
                }
            }
            if(temp > 4)
                inv.setItem(26, next);
            if(!isPage1)
                inv.setItem(18, back);
        }

        p.openInventory(inv);

    }
    public static String[][] getWaystones(Player p) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader("./plugins/MMORPGData/Waystones.json"));//path to the JSON file.

            Object values = data.get(p.getUniqueId().toString());
            String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
            String[] array = edit1.split(",");

            String[][] waypoints = new String[100][100];
            int temp = 0;
            int i=0, j=0;
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
                        j=0;
                    }
                }
                temp++;
            }
            return waypoints;

//            System.out.println(Arrays.deepToString(waypoints));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getWaystonesNames(Player p) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader("./plugins/MMORPGData/Waystones.json"));//path to the JSON file.

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
//            System.out.println(Arrays.deepToString(waypoints));
//            for (String[] s:waypoints) {
//                for (String ss: s) {
//                    if (ss != null) {
//                        ss = ss.strip();
//                        System.out.println(ss);
//                    }
//                }
//            }
            return waystones;

//            System.out.println(Arrays.deepToString(waypoints));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static String[] findWaystoneByName(Player p, String waystoneName) {
        String[][] playerWaystones = getWaystones(p);
        String[] waystoneLocation = new String[100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (playerWaystones[i][j] != null) {
                    playerWaystones[i][j] = playerWaystones[i][j].strip();
                    if (playerWaystones[i][j].contains(waystoneName)) {
                        waystoneLocation[0] = playerWaystones[i][j+1];
                        waystoneLocation[1] = playerWaystones[i][j+2];
                        waystoneLocation[2] = playerWaystones[i][j+3];
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
        if(ClickedItem == null) {
            return;
        }

        String[] waystoneNames = getWaystonesNames(p);
        int numofWaystones = 0;
        for (String s:waystoneNames) {
            if(s != null) {
                numofWaystones++;
            }
        }


        if(ClickedItem.getItemMeta().getDisplayName().contains("Waystone")) {
            int i=0;
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

        if(ClickedItem.getItemMeta().getDisplayName().contains("Next")) {
            int Page = 1;
            String pageName = "";

            if(p.getOpenInventory().getTitle().contains("Page")) {
                String s = p.getOpenInventory().getTitle();
                String[] sedit1 = s.split(" ");
                Page = Integer.parseInt(sedit1[sedit1.length - 1]) + 1;
                for (int i = 0; i < sedit1.length - 1; i++) {
                    if(!pageName.isEmpty()) {
                         pageName = pageName.concat(" ");
                    }
                    pageName = pageName.concat(sedit1[i]);
                }
            } else {
                Page++;
                pageName = p.getOpenInventory().getTitle();
                pageName = pageName.concat(" Page");
            }

            WaystoneMenu(p, pageName + " " + Page);
        }

        if(ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
            int Page = 1;
            String pageName = "";

            if(p.getOpenInventory().getTitle().contains("Page")) {
                String s = p.getOpenInventory().getTitle();
                String[] sedit1 = s.split(" ");
                Page = Integer.parseInt(sedit1[sedit1.length - 1]) - 1;
                for (int i = 0; i < sedit1.length - 1; i++) {
                    if(!pageName.isEmpty()) {
                        pageName = pageName.concat(" ");
                    }
                    pageName = pageName.concat(sedit1[i]);
                }
            } else {
                Page--;
                pageName = p.getOpenInventory().getTitle();
                pageName = pageName.concat(" Page");
            }

            WaystoneMenu(p, pageName + " " + Page);
        }


    }
}