package me.dnfneca.plugin.utilities.managers.Health;

import me.dnfneca.plugin.utilities.managers.CustomMobs.MobStats;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import static me.dnfneca.plugin.listeners.PlayerJoin.CustomMobs;

public class MobHealth {
	public static void MobProjectileHitHealth(ProjectileHitEvent e) {
		MobStats shotPlayer = MobStats.getMob(e.getHitEntity().getUniqueId());
		if(e.getEntity().getShooter() instanceof LivingEntity) {
			LivingEntity shooter = (LivingEntity) e.getEntity().getShooter();
			if(shooter instanceof Player) {
				PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shotPlayerEffectiveHealth = shotPlayerHealth + shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				double damageToDealToPlayer = shooterDamage + shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer) < 0.00) {
					killPlayer((LivingEntity) e.getEntity(), " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName(), shotPlayer);

				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer));

					updatePlayerHealth(shotPlayer);
				}

			} else {
				MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer) < 0.00) {
					killPlayer((LivingEntity) e.getEntity(), " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName(), shotPlayer);

				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer));

					updatePlayerHealth(shotPlayer);
				}


			}
		}

		Entity entityShot = e.getEntity();
		entityShot.remove();
	}

	public static void MobHitHealth(EntityDamageByEntityEvent e) {
		MobStats shotPlayer = MobStats.getMob(e.getEntity().getUniqueId());
		for (MobStats customMob : CustomMobs) {
			System.out.println(customMob.getUUID().equals(shotPlayer.getUUID()));
		}
		if(e.getDamager() instanceof LivingEntity) {
			LivingEntity shooter = (LivingEntity) e.getDamager();
			if(shooter instanceof Player) {
				PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());




				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer))) < 0.00) {
					killPlayer((LivingEntity) e.getEntity(), " was killed by " + playerShooter, shotPlayer);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					updatePlayerHealth(shotPlayer);
				}

			} else {
				MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				System.out.println("Damage " + damageToDealToPlayer);
				System.out.println(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer))) < 0.00) {
					killPlayer((LivingEntity) e.getEntity(), " was killed by " + playerShooter, shotPlayer);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					updatePlayerHealth(shotPlayer);
				}


			}
		}
	}

	//	public static void dealDamagetoPlayer(EntityDamageByEntityEvent e) {
//		LivingEntity damager = (LivingEntity) e.getDamager();
//		damager.getCustomName();
//
//		if (PLAYER == e.getEntityType() && PLAYER == e.getDamager().getType()) {
//			return;
//		}
//		if (PLAYER == e.getEntityType()) {
//			final Player player = (Player) e.getEntity();
//
//			final Score score = player.getScoreboard().getObjective("Stats").getScore("TrueShield");
//			if (0 < score.getScore()) {
//				score.setScore(score.getScore() - 1);
//				return;
//			}
//
//			final Objective obj = player.getScoreboard().getObjective("Stats");
//
//			final LivingEntity entityHit = (LivingEntity) e.getDamager();
//
//			PlayerHealth.tags = CheckCustomMob.check(entityHit);
//
//			final int damage = Integer.parseInt(PlayerHealth.tags.get(1)) * Integer.parseInt(PlayerHealth.tags.get(5));
//
//			obj.getScore("CurrentHealth").setScore(obj.getScore("CurrentHealth").getScore() - damage / obj.getScore("EffectiveDefence").getScore());
//
//			if (0 >= obj.getScore("CurrentHealth").getScore()) {
//				player.setHealth(0);
//
//				obj.getScore("CurrentHealth").setScore(obj.getScore("EffectiveHealth").getScore());
//			}
//
//			if (null != e.getDamager().getCustomName()) {
//				HitEffects.mob(e);
//			}
//
//			return;
//		}
//		if (PLAYER == e.getDamager().getType()) {
//			final Player player;
//
//
//			final DecimalFormat df = new DecimalFormat();
//			df.setMaximumFractionDigits(0);
//			final Location loc = e.getEntity().getLocation();
//			final LivingEntity entityHit = (LivingEntity) e.getEntity();
//			final String nameColor;
//			final String[] getScores = entityHit.getScoreboardTags().toArray(new String[10]);
//			player = (Player) e.getDamager();
//			PlayerHealth.tags = CheckCustomMob.check(entityHit);
//
//			final double maxHealth = Double.parseDouble(PlayerHealth.tags.get(0));
//			final int EffectiveCritDamage = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore();
//			final int EffectiveCritChance = player.getScoreboard().getObjective("Stats").getScore("EffectiveCritChance").getScore();
//			final int Strength = player.getScoreboard().getObjective("Stats").getScore("EffectiveStrength").getScore();
//			final int damage = player.getScoreboard().getObjective("Stats").getScore("CurrentDamage").getScore();
//
//
//			final double health;
//			final boolean Roll = Stats.getCritRoll(Double.parseDouble(String.valueOf(EffectiveCritChance)));
////            System.out.println(Roll);
////            System.out.println(tags.get(3) + "  " + damage + "  " );
////            System.out.println(player.getScoreboard().getObjective("Stats").getScore("EffectiveCritDamage").getScore());
//			if (Material.BOW == player.getInventory().getItemInMainHand().getType()) {
//				final double def = Double.parseDouble(PlayerHealth.tags.get(3));
//				if (null == getScores[0]) {
//					entityHit.addScoreboardTag(String.valueOf(maxHealth));
//					health = maxHealth - (damage / ((def * 10) / Strength));
//
//					entityHit.removeScoreboardTag(String.valueOf(maxHealth));
//					entityHit.addScoreboardTag(String.valueOf(health));
//				} else {
//					health = Double.parseDouble(getScores[0]) - (damage / ((def * 10) / Strength));
//					entityHit.removeScoreboardTag(getScores[0]);
//					entityHit.removeScoreboardTag(getScores[1]);
//					entityHit.addScoreboardTag(String.valueOf(health));
//				}
//				return;
//
//			}
//
//			final double def = Double.parseDouble(PlayerHealth.tags.get(3));
//			if (Roll) {
//				if (null == getScores[0]) {
//					entityHit.addScoreboardTag(String.valueOf(maxHealth));
//
//					health = Integer.parseInt(PlayerHealth.tags.get(0)) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (def / Strength);
//
//					entityHit.removeScoreboardTag(String.valueOf(maxHealth));
//					entityHit.addScoreboardTag(String.valueOf(health));
//				} else {
//					health = Double.parseDouble(getScores[0]) - (damage + damage * ((double) EffectiveCritDamage) * 0.01) / (def / Strength);
//					entityHit.removeScoreboardTag(getScores[0]);
//					entityHit.removeScoreboardTag(getScores[1]);
//					entityHit.addScoreboardTag(String.valueOf(health));
//				}
//
//				e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);
//				e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);
//				e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);
//				e.getEntity().getWorld().spawnParticle(Particle.TOTEM, ((LivingEntity) e.getEntity()).getEyeLocation(), 5, Math.random() * 2, 1, Math.random() * 2, 0.1);
//
//			} else {
//				if (null == getScores[0]) {
//					entityHit.addScoreboardTag(String.valueOf(maxHealth));
//					health = maxHealth - (damage * Strength / def);
//
//					entityHit.removeScoreboardTag(String.valueOf(maxHealth));
//					entityHit.addScoreboardTag(String.valueOf(health));
//				} else {
//					health = Double.parseDouble(getScores[0]) - (damage / (def / Strength));
//					entityHit.removeScoreboardTag(getScores[0]);
//					entityHit.removeScoreboardTag(getScores[1]);
//					entityHit.addScoreboardTag(String.valueOf(health));
//				}
//			}
//			switch (PlayerHealth.tags.get(4)) {
//				case "Rare":
//					nameColor = String.valueOf(ChatColor.BLUE);
//					break;
//				case "Epic":
//					nameColor = String.valueOf(ChatColor.DARK_PURPLE);
//					break;
//				case "Legendary":
//					nameColor = String.valueOf(ChatColor.GOLD);
//					break;
//				case "Mythic":
//					nameColor = String.valueOf(ChatColor.RED);
//					break;
//				default:
//					nameColor = String.valueOf(ChatColor.GRAY);
//					break;
//			}
//
//
//			entityHit.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Lv" + PlayerHealth.tags.get(5) + ChatColor.DARK_GRAY + "]" + " " + nameColor + PlayerHealth.tags.get(7) + " " + ChatColor.RED + df.format(health) + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + df.format(Double.parseDouble(PlayerHealth.tags.get(0))) + "❤");
//			entityHit.removeScoreboardTag(String.valueOf(maxHealth));
//
//			if (0 >= health) {
//				entityHit.setCustomName(null);
//				entityHit.setCustomNameVisible(false);
//				entityHit.setHealth(0);
//
//				Bukkit.getScheduler().runTaskLater(Plugin.getInstance(), () -> entityHit.remove(), 20);
//
//			}
//		}
//	}
	public static void updatePlayerHealth(MobStats p) {
		p.getEntity(p.getUUID()).setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + p.getLevel() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + p.getName() + ChatColor.RED + ChatColor.RED + "❤ " + String.valueOf(p.getCurrentHealth()) + "/" + String.valueOf(p.getHealth()));
	}
	public static void killPlayer(LivingEntity p, String killMessage, MobStats mob) {
		p.remove();
		CustomMobs.remove(mob);
	}
}
