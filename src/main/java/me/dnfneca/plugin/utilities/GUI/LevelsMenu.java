package me.dnfneca.plugin.utilities.GUI;

import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LevelsMenu {
	;

	public static void LevelsMenu(final Player p) {
		final List<String> lore = new ArrayList<>();


		final Inventory inv = Bukkit.createInventory(null, 27, "Crafting Table");

		final ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
		final ItemStack level = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);


		final ItemStack arrow = new ItemStack(Material.ARROW, 1);

		final ItemMeta arrowmeta = arrow.getItemMeta();
		arrowmeta.setDisplayName(ChatColor.GRAY + "To Forge");
		arrow.setItemMeta(arrowmeta);


		final ItemMeta data2 = blue_glass.getItemMeta();
		data2.setDisplayName("   ");
		blue_glass.setItemMeta(data2);

		final int playerLevel = PlayerLevels.getLevel(p);
		final int leftXp = PlayerLevels.getLeftXp(p);
		final int levelXp = PlayerLevels.getLevelXp(p);
		int currentLevelXp = levelXp - leftXp;

		if (0 > currentLevelXp) currentLevelXp = 0;


		final int valueOfSlot = levelXp / 10;
		final int numOfSlots = 10;


		final ItemMeta levelData = level.getItemMeta();
		final ArrayList<String> levelLore = new ArrayList<>();
		final String[] test = new String[10];

		for (int i = 0; i < numOfSlots; i++) {
			if (valueOfSlot * i < currentLevelXp) {
				test[i] = ChatColor.GREEN + "||";
			} else {
				test[i] = ChatColor.GRAY + "||";
			}
		}
		levelLore.add(ChatColor.BLUE + "Level " + playerLevel + " : " + Arrays.toString(test).replace("[", "").replace("]", "").replace(",", "") + " " + (playerLevel + 1));
		levelLore.add(leftXp + "Xp until next level" + ", Amount of xp" + currentLevelXp);
		levelData.setDisplayName(ChatColor.GREEN + "Level Progress");
		levelData.setLore(levelLore);
		level.setItemMeta(levelData);


		for (int i = 0; 26 >= i; i++) {
			if (13 == i) {
				inv.setItem(13, level);
			} else {
				inv.setItem(i, blue_glass);
			}
		}
//        ItemStack clay = new ItemStack(CLAY, 64);
//        ItemMeta clayMeta = clay.getItemMeta();
//        lore.add(ChatColor.DARK_PURPLE + "Staff");
//        clayMeta.setLore(lore);
//        clay.setItemMeta(clayMeta);
//        inv.addItem(clay);
		p.openInventory(inv);
	}
}
