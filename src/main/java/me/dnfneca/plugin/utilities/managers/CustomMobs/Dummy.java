package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Dummy implements Listener {
	public static int MaxHealth = 10000000;
	public static int Level;
	public static String Type = "Dummy";
	public static String Name = "Dummy";
	public static int Defence = 1;
	public static int Strength;
	public static int Damage;

	static Plugin plugin;

	public Dummy(final Plugin plugin) {
		Dummy.plugin = plugin;
	}

	public static void createDummy(final Location location) {
		long[] AB1CD = {0};
		long[] AB2CD = {0};
		String[] entities = new String[0];

		final Zombie spider = location.getWorld().spawn(location, Zombie.class);

		spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
		spider.setCustomNameVisible(true);
		spider.setAI(false);
		final Attributable creatureAt = spider;
		final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		attribute.setBaseValue(100);
		spider.setHealth(100);
		final String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
		final String level = getScores[0];
		spider.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + Dummy.Level + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Dummy ");


	}
}
