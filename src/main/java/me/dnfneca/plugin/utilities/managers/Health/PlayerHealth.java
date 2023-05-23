package me.dnfneca.plugin.utilities.managers.Health;

import me.dnfneca.plugin.CustomMobs.MobStats;
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

public enum PlayerHealth {
	;

	public static void ProjectileHitHealth(final ProjectileHitEvent e) {
		final PlayerStats shotPlayer = PlayerStats.getPlayerStats(e.getHitEntity().getUniqueId());
		if(e.getEntity().getShooter() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				final PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				final double shotPlayerHealth = shotPlayer.getHealth();
				final double shotPlayerDefence = shotPlayer.getDefence();

				final double shooterStrength = playerShooter.getStrength();
				final double shooterDamage = playerShooter.getDamage();

				final double shotPlayerEffectiveHealth = shotPlayerHealth + shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				final double damageToDealToPlayer = shooterDamage + shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer)) {
					PlayerHealth.killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());

				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer));

					PlayerHealth.updatePlayerHealth(shotPlayer);
				}

			} else {
				final MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				final double shotPlayerHealth = shotPlayer.getHealth();
				final double shotPlayerDefence = shotPlayer.getDefence();

				final double shooterStrength = playerShooter.getStrength();
				final double shooterDamage = playerShooter.getDamage();

				final double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				final double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer)) {
					PlayerHealth.killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());

				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer));

					PlayerHealth.updatePlayerHealth(shotPlayer);
				}


			}
		}

		final Entity entityShot = e.getEntity();
		entityShot.remove();
	}

	public static void PlayerHitHealth(final EntityDamageByEntityEvent e) {
		final PlayerStats shotPlayer = PlayerStats.getPlayerStats(e.getEntity().getUniqueId());
		if(e.getDamager() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				final PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				final double shotPlayerHealth = shotPlayer.getHealth();
				final double shotPlayerDefence = shotPlayer.getDefence();

				final double shooterStrength = playerShooter.getStrength();
				final double shooterDamage = playerShooter.getDamage();

				final double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				final double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer)) {
					PlayerHealth.killPlayer(shotPlayer, " was killed by " + playerShooter);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer));

					PlayerHealth.updatePlayerHealth(shotPlayer);
				}

			} else {
				final MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				final double shotPlayerHealth = shotPlayer.getHealth();
				final double shotPlayerDefence = shotPlayer.getDefence();

				final double shooterStrength = playerShooter.getStrength();
				final double shooterDamage = playerShooter.getDamage();

				final double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				final double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				System.out.println("Damage " + damageToDealToPlayer);
				System.out.println(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
					PlayerHealth.killPlayer(shotPlayer, " was killed by " + playerShooter);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					PlayerHealth.updatePlayerHealth(shotPlayer);
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
	public static void updatePlayerHealth(final PlayerStats p) {
		final Player player = p.getPlayer();
		if (0 != p.getManaSpent() || 0 != p.getManaTimer()) {
			double OldManaCost = p.getManaSpent();

			if (6 <= p.getManaTimer()) {
				p.setCurrentMana(p.getCurrentMana() - p.getManaSpent());
			}
//                    CurrentMana.setScore(CurrentHealth.getScore() - OldManaCost);
			player.spigot().sendMessage(
					ChatMessageType.ACTION_BAR,
					new TextComponent(net.md_5.bungee.api.ChatColor.RED + "❤ " + (int) p.getCurrentHealth() + net.md_5.bungee.api.ChatColor.GRAY + "/" + net.md_5.bungee.api.ChatColor.RED + (int) p.getHealth() + "   " + net.md_5.bungee.api.ChatColor.GREEN + "🛡 " + (int) p.getDefence() + "   " + net.md_5.bungee.api.ChatColor.DARK_AQUA + "✎ " + net.md_5.bungee.api.ChatColor.AQUA + "-" + (int) OldManaCost + " " + (int) p.getCurrentMana() + net.md_5.bungee.api.ChatColor.GRAY + "/" + net.md_5.bungee.api.ChatColor.AQUA + (int) p.getMana()));
			if (0 < p.getManaTimer())
				p.setManaTimer(p.getManaTimer() - 1);
			if (0 >= p.getManaTimer())
				p.setManaSpent(0);
		} else {
			player.spigot().sendMessage(
					ChatMessageType.ACTION_BAR,
					new TextComponent(net.md_5.bungee.api.ChatColor.RED + "❤ " + (int) p.getCurrentHealth() + net.md_5.bungee.api.ChatColor.GRAY + "/" + net.md_5.bungee.api.ChatColor.RED + (int) p.getHealth() + "   " + net.md_5.bungee.api.ChatColor.GREEN + "🛡 " + (int) p.getDefence() + "   " + net.md_5.bungee.api.ChatColor.DARK_AQUA + "✎ " + net.md_5.bungee.api.ChatColor.AQUA + (int) p.getCurrentMana() + net.md_5.bungee.api.ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
		}
	}
	public static void killPlayer(final PlayerStats p, final String killMessage) {
		final Player player = p.getPlayer();
		player.setHealth(0.00);
		Bukkit.getServer().broadcastMessage(player.getDisplayName() + killMessage);
		p.setCurrentHealth(p.getHealth());
		p.setCurrentMana(p.getMana());
	}
}
