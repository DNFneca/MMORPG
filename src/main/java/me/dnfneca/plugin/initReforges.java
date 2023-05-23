package me.dnfneca.plugin;

import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import static me.dnfneca.plugin.Plugin.CustomReforges;

public class initReforges {
	public static void init() {


		ItemStack reforgeItemStack = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta reforgeItemMeta = (SkullMeta) reforgeItemStack.getItemMeta();
		reforgeItemMeta.setDisplayName(ChatColor.BLUE + "Strength Artifact");
		PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID()); // Get a new player profile
		PlayerTextures textures = profile.getTextures();
		URL urlObject = null;
		try {
			urlObject = new URL("https://textures.minecraft.net/texture/d8188345dc6a1bf08663385b99f2bd1551a49292a93b84e0a97b917b565bf41a"); // The URL to the skin, for example: https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
		textures.setSkin(urlObject);
		reforgeItemMeta.setOwnerProfile(profile); // Set the owning player of the head to the player profile
		reforgeItemStack.setItemMeta(reforgeItemMeta);
		CustomReforges.add(new Reforge("Strength Artifact",
				10,
				0,
				0,
				0,
				0,
				0,
				0,
				0,
				0,
				"Rare",
				reforgeItemStack,
				"Strong",
				0,
				"Any",
				0));


		reforgeItemStack = new ItemStack(Material.PLAYER_HEAD);
		reforgeItemMeta = (SkullMeta) reforgeItemStack.getItemMeta();
		reforgeItemMeta.setDisplayName(ChatColor.GOLD + "Arnid's Stoat");
		profile = Bukkit.createPlayerProfile(UUID.randomUUID()); // Get a new player profile
		textures = profile.getTextures();
		urlObject = null;
		try {
			urlObject = new URL("https://textures.minecraft.net/texture/d8188345dc6a1bf08663385b99f2bd1551a49292a93b84e0a97b917b565bf41a"); // The URL to the skin, for example: https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
		textures.setSkin(urlObject);
		reforgeItemMeta.setOwnerProfile(profile); // Set the owning player of the head to the player profile
		reforgeItemStack.setItemMeta(reforgeItemMeta);
		CustomReforges.add(new Reforge("Arnid's Stoat",
				0,
				0,
				0,
				0,
				20,
				20,
				0,
				0,
				2,
				"Legendary",
				reforgeItemStack,
				"Enthusiastic",
				0,
				"Any",
				0));


		reforgeItemStack = new ItemStack(Material.PLAYER_HEAD);
		reforgeItemMeta = (SkullMeta) reforgeItemStack.getItemMeta();
		reforgeItemMeta.setDisplayName(ChatColor.GOLD + "Raven's Raven");
		profile = Bukkit.createPlayerProfile(UUID.randomUUID());
		textures = profile.getTextures();
		urlObject = null;
		try {
			urlObject = new URL("https://textures.minecraft.net/texture/d8188345dc6a1bf08663385b99f2bd1551a49292a93b84e0a97b917b565bf41a");
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
		textures.setSkin(urlObject);
		reforgeItemMeta.setOwnerProfile(profile);
		reforgeItemStack.setItemMeta(reforgeItemMeta);
		CustomReforges.add(new Reforge("Raven's Raven",
				20,
				0,
				10,
				0,
				0,
				5,
				0,
				0,
				30,
				"Mythic",
				reforgeItemStack,
				"Ravenous",
				0,
				"Any",
				0));


		reforgeItemStack = new ItemStack(Material.PLAYER_HEAD);
		reforgeItemMeta = (SkullMeta) reforgeItemStack.getItemMeta();
		reforgeItemMeta.setDisplayName(ChatColor.GOLD + "Rainbow's Donkey");
		profile = Bukkit.createPlayerProfile(UUID.randomUUID());
		textures = profile.getTextures();
		urlObject = null;
		try {
			urlObject = new URL("https://textures.minecraft.net/texture/d8188345dc6a1bf08663385b99f2bd1551a49292a93b84e0a97b917b565bf41a");
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
		textures.setSkin(urlObject);
		reforgeItemMeta.setOwnerProfile(profile);
		reforgeItemStack.setItemMeta(reforgeItemMeta);
		CustomReforges.add(new Reforge("Rainbow's Donkey",
				0,
				100,
				0,
				-20,
				-20,
				0,
				0,
				0,
				0,
				"Legendary",
				reforgeItemStack,
				"Assed",
				0,
				"Any",
				0));


		reforgeItemStack = new ItemStack(Material.PLAYER_HEAD);
		reforgeItemMeta = (SkullMeta) reforgeItemStack.getItemMeta();
		reforgeItemMeta.setDisplayName(ChatColor.GOLD + "PJ's Finch");
		profile = Bukkit.createPlayerProfile(UUID.randomUUID());
		textures = profile.getTextures();
		urlObject = null;
		try {
			urlObject = new URL("https://textures.minecraft.net/texture/d8188345dc6a1bf08663385b99f2bd1551a49292a93b84e0a97b917b565bf41a");
		} catch (final MalformedURLException e) {
			throw new RuntimeException(e);
		}
		textures.setSkin(urlObject);
		reforgeItemMeta.setOwnerProfile(profile);
		reforgeItemStack.setItemMeta(reforgeItemMeta);
		CustomReforges.add(new Reforge("PJ's Finch",
				-10,
				-10,
				0,
				0,
				+30,
				+5,
				+5,
				0,
				0,
				"Legendary",
				reforgeItemStack,
				"Savannan",
				0,
				"Any",
				0));

		reforgeItemStack = new ItemStack(Material.FEATHER);
		final ItemMeta reforgeItemMetaNonHead = reforgeItemStack.getItemMeta();
		reforgeItemMetaNonHead.setDisplayName("Corax's Feather");
		reforgeItemStack.setItemMeta(reforgeItemMetaNonHead);
		CustomReforges.add(new Reforge("Corax's Feather",
				25,
				0,
				0,
				0,
				20,
				0,
				0,
				0,
				5,
				"Epic",
				reforgeItemStack,
				"Deadly",
				1,
				"Melee",
				0));




	}
}
