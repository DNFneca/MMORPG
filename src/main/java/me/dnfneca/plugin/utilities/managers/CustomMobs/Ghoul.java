package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Ghoul implements Listener {
	public static int MaxHealth = 1200;
	public static int Level = 90;
	public static String Type = "Ghoul";
	public static String Name = "Ghoul";
	public static int Defence = 50;
	public static int Strength = 85;
	public static int Damage = 100;

	static Plugin plugin;

	public Ghoul(final Plugin plugin) {
		Ghoul.plugin = plugin;
	}

	public static void createGhoul(final Location location, final Player player) {
		long[] AB1CD = {0};
		long[] AB2CD = {0};
		String[] entities = new String[0];

		final Husk spider = location.getWorld().spawn(location, Husk.class);

		final String texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU3MzMwYzdkNWNkOGEwYTU1YWI5ZTk1MzIxNTM1YWM3YWUzMGZlODM3YzM3ZWE5ZTUzYmVhN2JhMmRlODZiIn19fQ==";

		final String id = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

		final ItemStack VexHead = new ItemStack(Material.PLAYER_HEAD, 1);

		final ItemMeta skullMeta = VexHead.getItemMeta();
//        GameProfile profile = new GameProfile(UUID.randomUUID(), null);


		final PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID()); // Get a new player profile
		final PlayerTextures textures = profile.getTextures();
		URL urlObject = null;


		try {
			urlObject = new URL("https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18"); // The URL to the skin, for example: https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18
		} catch (final MalformedURLException e) {
			e.printStackTrace();
		}
		textures.setSkin(urlObject);


//        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/18813764b2abc94ec3c3bc67b9147c21be850cdf996679703157f4555997ea63");
		final ItemStack head = new ItemStack(Material.PLAYER_HEAD);
		final SkullMeta meta = (SkullMeta) head.getItemMeta();
		meta.setOwnerProfile(profile); // Set the owning player of the head to the player profile
		head.setItemMeta(meta);
		player.getInventory().addItem(head);


		spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
		spider.setCustomNameVisible(true);


		final SkullMeta headMeta = (SkullMeta) VexHead.getItemMeta();
//        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

//        profile.getProperties().put("textures", new Property("textures", id));

		try {
			final Field profileField = headMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(headMeta, profile);
		} catch (final IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}

		VexHead.setItemMeta(headMeta);

		spider.getEquipment().setHelmet(head);
		final Attributable creatureAt = spider;
		final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		attribute.setBaseValue(100);
		spider.setHealth(100);
		final String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
		final String level = getScores[0];
		spider.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + Ghoul.Level + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Ghoul ");

		new BukkitRunnable() {
			public void run() {
				int index = 0;
				final int range = 10;
				if (!(spider.isDead())) {
					spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
					if (null == spider.getTarget()) {
						final List<Entity> entityaround;
						final List<Player> allPlayers = new ArrayList<>();
						entityaround = spider.getNearbyEntities(range, range, range);
						for (final Entity p : entityaround) {
							if (p instanceof Player) {
								final int stealth = ((Player) p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
								final double distance = spider.getLocation().distance(p.getLocation());
								final double stealthRange = range - (double) range * stealth * 0.01;
								if (distance <= stealthRange) {
									allPlayers.add((Player) p);
								}
							}
						}
						for (final Player p : allPlayers) {
							final Player target = allPlayers.get(index);
							if (1 <= index) {
								if (target.getScoreboard().getObjective("Stats").getScore("Health").getScore() < allPlayers.get(index - 1).getScoreboard().getObjective("Stats").getScore("Health").getScore()) {
									spider.setTarget(p);
									p.sendMessage(p.getDisplayName());
								}
							} else {
								spider.setTarget(allPlayers.get(0));
								p.sendMessage(p.getDisplayName());
							}
							index++;
						}
					}
				} else {
					this.cancel();
				}
			}
		}.runTaskTimer(Ghoul.plugin, 0L, 10L);
	}
}
