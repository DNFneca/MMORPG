package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public enum EnchantingMenu {
	;

	public static void Open(Player p) {

		final String texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjVhNDc1NDYwYjVmOWEzNjc3OTBkZjlkZjViYmJmYmMxMGMwNzlkNDU0OGUzMzgyZGIzNmYzMzY0ZWMwODg0NSJ9fX0=";

		final String id = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

		ItemStack VexHead = new ItemStack(Material.PLAYER_HEAD, 1);

		ItemMeta skullMeta = VexHead.getItemMeta();
//        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

		PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID()); // Get a new player profile
		PlayerTextures textures = profile.getTextures();
		URL urlObject = null;

		try {
			urlObject = new URL("https://textures.minecraft.net/texture/b5a475460b5f9a367790df9df5bbbfbc10c079d4548e3382db36f3364ec08845"); // The URL to the skin, for example: https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		textures.setSkin(urlObject);


//        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/18813764b2abc94ec3c3bc67b9147c21be850cdf996679703157f4555997ea63");
		ItemStack head = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta meta = (SkullMeta) head.getItemMeta();
		meta.setOwnerProfile(profile); // Set the owning player of the head to the player profile
		meta.setDisplayName("Strength Artifact");
		head.setItemMeta(meta);


		List<String> lore = new ArrayList<>();


		Inventory inv = Bukkit.createInventory(null, 54, "Forge Menu");

		ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
		ItemStack recipe = new ItemStack(Material.BARRIER, 1);
		ItemStack reforge_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
		ItemStack forge = new ItemStack(Material.BARRIER, 1);

		ItemMeta reforge_glass_data = reforge_glass.getItemMeta();
		reforge_glass_data.setDisplayName("   ");
		reforge_glass.setItemMeta(reforge_glass_data);

		ItemMeta forge_data = forge.getItemMeta();
		forge_data.setDisplayName("Can't reforge this");
		forge.setItemMeta(forge_data);

		ItemMeta data2 = blue_glass.getItemMeta();
		data2.setDisplayName("   ");
		blue_glass.setItemMeta(data2);

		ItemMeta recipedata = recipe.getItemMeta();
		recipedata.setDisplayName("Your recipe will appear here");
		recipe.setItemMeta(recipedata);


		for (int i = 0; 53 >= i; i++) {
			if (11 == i) {
				inv.setItem(11, new ItemStack(Material.AIR));
			} else if (12 == i || 13 == i || 14 == i || 22 == i || 31 == i) {
				inv.setItem(i, reforge_glass);
			} else if (15 == i) {
				inv.setItem(15, head);
			} else if (40 == i) {
				inv.setItem(40, forge);
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
