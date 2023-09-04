package me.dnfneca.plugin.CustomMobs;

import me.dnfneca.plugin.Plugin;
import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;


public class BasicSpider implements Listener {
	public static int MaxHealth = 200;
	public static int Level = 75;
	public static String Type = "Spider";
	public static String Name = "Spider";
	public static int Defence = 100;
	public static int Strength = 20;
	public static int Damage = 100;

	static Plugin plugin;

	public BasicSpider(Plugin plugin) {
		BasicSpider.plugin = plugin;
	}

	public static void createSpider(Location location) {
		long[] AB1CD = {0};
		long[] AB2CD = {0};
		String[] entities = new String[0];

		Spider spider = location.getWorld().spawn(location, Spider.class);

		spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
		spider.setCustomNameVisible(true);
		Attributable creatureAt = spider;
		AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		attribute.setBaseValue(100);
		spider.setHealth(100);
		String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
		String level = getScores[0];
		spider.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + Level + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " Spider ");


		new BukkitRunnable() {

			public void run() {
				if (0 <= AB1CD[0]) {
					AB1CD[0]--;
				}
				if (0 <= AB2CD[0]) {
					AB2CD[0]--;
				}
				for (Player p : Bukkit.getOnlinePlayers()) {
					List<Entity> e = p.getNearbyEntities(1, 1, 1);
					for (Entity entity : e) {
						if (EntityType.ARMOR_STAND == entity.getType()) {
							if (entity.getScoreboardTags().contains("FallingBlock")) {
								for (Entity en : entity.getNearbyEntities(5, 5, 5)) {
									if (en instanceof Player) {
										spider.attack(en);
									}
								}
								entity.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, entity.getLocation(), 5);
								FallingBlock fb = (FallingBlock) entity.getPassengers().get(0);
								entity.eject();
								fb.remove();
								entity.remove();
							}
						}
					}
				}
			}
		}.runTaskTimer(plugin, 0L, 1L);


		new BukkitRunnable() {
			public void run() {
				final int range = 10;
				if (!(spider.isDead())) {
					spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
					if (null == spider.getTarget()) {
						List<Entity> entityaround;
						List<Player> playerAround;
						entityaround = spider.getNearbyEntities(range, range, range);
						for (Entity p : entityaround) {
							if (p instanceof Player) {
								int stealth = ((Player) p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
								if (spider.getLocation().distance(p.getLocation()) < range - range * stealth * 0.01) {
									spider.setTarget((Player) p);

								}
							}
						}
					}
				} else {
					cancel();
				}
			}
		}.runTaskTimer(plugin, 0L, 10L);


		new BukkitRunnable() {
			public void run() {
				if (!(spider.isDead())) {
					if (null != spider.getTarget() && 0 >= AB1CD[0]) {
						LivingEntity target = spider.getTarget();
						if (10 < target.getLocation().distanceSquared(spider.getLocation()) && 25 > target.getLocation().distanceSquared(spider.getLocation())) {
							spider.getWorld().playSound(spider.getLocation(), Sound.ENTITY_WITHER_SHOOT, 5, 5);
							spider.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, spider.getLocation(), 10);
							spider.setVelocity(target.getLocation().add(0, 2, 0).subtract(spider.getLocation()).toVector().multiply(0.275));
							AB1CD[0] = 40;
						}
					}
				} else {
					cancel();
				}
			}
		}.runTaskTimer(plugin, 0L, 20);


		new BukkitRunnable() {
			public void run() {
				if (!(spider.isDead())) {
					if (null != spider.getTarget() && 0 >= AB2CD[0]) {
						LivingEntity target = spider.getTarget();
						if (25 < target.getLocation().distanceSquared(spider.getLocation())) {
							spider.getWorld().playSound(spider.getLocation(), Sound.ENTITY_SPIDER_HURT, 5, 5);
							spider.getWorld().spawnParticle(Particle.SMOKE_NORMAL, spider.getLocation(), 10);
							FallingBlock web = spider.getWorld().spawnFallingBlock(spider.getLocation(), Material.COBWEB, (byte) 0);
							web.setGravity(false);
							web.setInvulnerable(true);
							ArmorStand stand = spider.getWorld().spawn(spider.getLocation(), ArmorStand.class);
							stand.addScoreboardTag("FallingBlock");
							stand.setInvisible(true);
							stand.setInvulnerable(true);
							web.setHurtEntities(true);
							web.setDropItem(false);
							stand.addPassenger(web);
							stand.setGravity(true);
							stand.setSilent(true);
							stand.setVisible(true);
							stand.setVelocity(target.getLocation().add(0, 1, 0).subtract(spider.getLocation()).toVector().multiply(0.25));
							AB2CD[0] = 100;
						}
					}
				} else {
					cancel();
				}
			}
		}.runTaskTimer(plugin, 0L, 20);
	}

	public static void HitEffect() {

	}
}
