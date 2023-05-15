package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;


public class BasicWolf implements Listener {
	public static int MaxHealth = 200;
	public static int Level = 25;
	public static String Type = "Wolf";
	public static String Name = "Wolf";
	public static int Defence = 15;
	public static int Strength = 55;
	public static int Damage = 40;

	static Plugin plugin;

	public BasicWolf(final Plugin plugin) {
		BasicWolf.plugin = plugin;
	}

	public static void createWolf(final Location location) {
		long[] AB1CD = {0};
		long[] AB2CD = {0};
		String[] entities = new String[0];

		final Wolf spider = location.getWorld().spawn(location, Wolf.class);

		spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
		spider.setCustomNameVisible(true);
		final Attributable creatureAt = spider;
		final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		attribute.setBaseValue(100);
		spider.setHealth(100);
		final String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
		final String level = getScores[0];
		spider.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + BasicWolf.Level + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Wolf ");

		new BukkitRunnable() {
			public void run() {
				final int range = 10;
				if (!(spider.isDead())) {
					spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
					if (null == spider.getTarget()) {
						final List<Entity> entityaround;
						List<Player> playerAround;
						entityaround = spider.getNearbyEntities(range, range, range);
						for (final Entity p : entityaround) {
							if (p instanceof Player) {
								final int stealth = ((Player) p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
								if (spider.getLocation().distance(p.getLocation()) < range - range * stealth * 0.01) {
									spider.setTarget((Player) p);


								}
							}
						}
					}
				} else {
					this.cancel();
				}
			}
		}.runTaskTimer(BasicWolf.plugin, 0L, 10L);
	}
}
