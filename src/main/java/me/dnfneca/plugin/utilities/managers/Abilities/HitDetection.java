package me.dnfneca.plugin.utilities.managers.Abilities;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.CustomMobs.CheckCustomMob;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public enum HitDetection {
	;

	public static boolean HitDetection(final Location location, final double Distance, final int Damage) {
		final DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(0);
		final Collection<Entity> NearbyEntities = location.getWorld().getNearbyEntities(location, Distance, Distance, Distance);
		LivingEntity MobsNearby = null;
		for (final Entity e : NearbyEntities) {
			if (EntityType.PLAYER != e.getType()) {
				MobsNearby = (LivingEntity) e;
				break;
			}
		}
		if (null == MobsNearby) {
			return false;
		} else {
			final ArrayList<String> tags = CheckCustomMob.check(MobsNearby);
			final double maxHealth = Double.parseDouble(tags.get(0));
			final String[] getScores = MobsNearby.getScoreboardTags().toArray(new String[10]);

			System.out.println(Arrays.toString(getScores));

			final double health;
			if (null == getScores[0]) {
				MobsNearby.addScoreboardTag(String.valueOf(Double.parseDouble(tags.get(0))));
				health = maxHealth - (Damage);

				MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
				MobsNearby.addScoreboardTag(String.valueOf(health));
			} else {
				health = Double.parseDouble(getScores[0]) - (Damage);
				MobsNearby.removeScoreboardTag(getScores[0]);
				MobsNearby.removeScoreboardTag(getScores[1]);
				MobsNearby.addScoreboardTag(String.valueOf(health));
			}
			final String nameColor;
			switch (tags.get(4)) {
				case "Rare":
					nameColor = String.valueOf(ChatColor.BLUE);
					break;
				case "Epic":
					nameColor = String.valueOf(ChatColor.DARK_PURPLE);
					break;
				case "Legendary":
					nameColor = String.valueOf(ChatColor.GOLD);
					break;
				case "Mythic":
					nameColor = String.valueOf(ChatColor.RED);
					break;
				default:
					nameColor = String.valueOf(ChatColor.GRAY);


					MobsNearby.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
					MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));

					if (0 >= health) {
						MobsNearby.setCustomName(null);
						MobsNearby.setCustomNameVisible(false);
						MobsNearby.setHealth(0);

						final LivingEntity finalMobsNearby = MobsNearby;
						new BukkitRunnable() {

							@Override
							public void run() {
								finalMobsNearby.remove();
							}

						}.runTaskLater(Plugin.getInstance(), 20);
					}
			}
//        for (Entity e : NearbyEntities) {
//            if(e.getType() != EntityType.PLAYER && e.getType() != EntityType.DROPPED_ITEM && e.getType() != EntityType.ARMOR_STAND) {
//                MobsNearby.add((LivingEntity) e);
//            }
//        }
//        if(!MobsNearby.isEmpty()) {
//            for (Entity e: MobsNearby) {
//                double health = Double.parseDouble(tags.get(0)) - (Damage);
//
//                e.removeScoreboardTag(String.valueOf(tags.get(0)));
//                e.addScoreboardTag(String.valueOf(health));
//                System.out.println(e + ", " + health);
//                return true;
//            }
//        }
//        else {
//            return false;
//        }
			return true;
		}
	}

	public static boolean HitDetectionStun(final Location location, final double Distance, final int Damage, int StunDuration) {
		StunDuration = StunDuration * 20;
		final DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(0);
		final Collection<Entity> NearbyEntities = location.getWorld().getNearbyEntities(location, Distance, Distance, Distance);
		LivingEntity MobsNearby = null;
		for (final Entity e : NearbyEntities) {
			if (EntityType.PLAYER != e.getType()) {
				MobsNearby = (LivingEntity) e;
				break;
			}
		}
		if (null == MobsNearby) {
			return false;
		} else {
			final ArrayList<String> tags = CheckCustomMob.check(MobsNearby);
			final double maxHealth = Double.parseDouble(tags.get(0));
			final String[] getScores = MobsNearby.getScoreboardTags().toArray(new String[10]);

			final double health;
			if (null == getScores[0]) {
				MobsNearby.addScoreboardTag(String.valueOf(Double.parseDouble(tags.get(0))));
				health = maxHealth - (Damage);

				MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));
				MobsNearby.addScoreboardTag(String.valueOf(health));
				MobsNearby.setAI(false);
			} else {
				health = Double.parseDouble(getScores[0]) - (Damage);
				MobsNearby.removeScoreboardTag(getScores[0]);
				MobsNearby.removeScoreboardTag(getScores[1]);
				MobsNearby.addScoreboardTag(String.valueOf(health));
				MobsNearby.setAI(false);
			}
			final String nameColor;
			switch (tags.get(4)) {
				case "Rare":
					nameColor = String.valueOf(ChatColor.BLUE);
					break;
				case "Epic":
					nameColor = String.valueOf(ChatColor.DARK_PURPLE);
					break;
				case "Legendary":
					nameColor = String.valueOf(ChatColor.GOLD);
					break;
				case "Mythic":
					nameColor = String.valueOf(ChatColor.RED);
					break;
				default:
					nameColor = String.valueOf(ChatColor.GRAY);


					MobsNearby.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(tags.get(0))) + "❤");
					MobsNearby.removeScoreboardTag(String.valueOf(maxHealth));

					if (0 >= health) {
						MobsNearby.setCustomName(null);
						MobsNearby.setCustomNameVisible(false);
						MobsNearby.setHealth(0);

						final LivingEntity finalMobsNearby = MobsNearby;
						new BukkitRunnable() {

							@Override
							public void run() {
								finalMobsNearby.remove();
							}

						}.runTaskLater(Plugin.getInstance(), 20);
					}
					final LivingEntity finalMobsNearby1 = MobsNearby;
					new BukkitRunnable() {

						@Override
						public void run() {
							finalMobsNearby1.setAI(true);
						}
					}.runTaskLater(Plugin.getInstance(), StunDuration);
			}
//        for (Entity e : NearbyEntities) {
//            if(e.getType() != EntityType.PLAYER && e.getType() != EntityType.DROPPED_ITEM && e.getType() != EntityType.ARMOR_STAND) {
//                MobsNearby.add((LivingEntity) e);
//            }
//        }
//        if(!MobsNearby.isEmpty()) {
//            for (Entity e: MobsNearby) {
//                double health = Double.parseDouble(tags.get(0)) - (Damage);
//
//                e.removeScoreboardTag(String.valueOf(tags.get(0)));
//                e.addScoreboardTag(String.valueOf(health));
//                System.out.println(e + ", " + health);
//                return true;
//            }
//        }
//        else {
//            return false;
//        }
			return true;
		}
	}
}
