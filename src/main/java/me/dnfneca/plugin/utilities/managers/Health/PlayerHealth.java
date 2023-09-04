package me.dnfneca.plugin.utilities.managers.Health;

import me.dnfneca.plugin.CustomMobs.HitEffects.HitEffects;
import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import static me.dnfneca.plugin.utilities.managers.Statistics.PlayerStatCalc.updatePlayerActionBar;

public enum PlayerHealth {
	;

	public static void ProjectileHitHealth(ProjectileHitEvent e) {
		PlayerStats shotPlayer = PlayerStats.getPlayerStats(e.getHitEntity().getUniqueId());
		if(e.getEntity().getShooter() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();
				double shotPlayerBonusHealth = shotPlayer.getBonusHealth();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shooterCritChance = playerShooter.getCritChance();
				double shooterCritDamage = playerShooter.getCritDamage();

				if(Utilities.getCritRoll(shooterCritChance)) {
					double shotPlayerEffectiveHealth = (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = getCritDamageToDealToPlayer(shooterStrength, shooterDamage, shooterCritDamage);

					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
						killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());
					} else {
						if(shotPlayerBonusHealth - damageToDealToPlayer < 0) {
							shotPlayer.setBonusHealth(0);
							shotPlayer.setBonusHealthTimer(0);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						} else {
							shotPlayer.setBonusHealth(shotPlayerBonusHealth - damageToDealToPlayer);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						}

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerActionBar(shotPlayer);
					}
				} else {
					double shotPlayerEffectiveHealth =  (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);
					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer)) {
						killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());

					} else {
						if(shotPlayerBonusHealth - damageToDealToPlayer < 0) {
							shotPlayer.setBonusHealth(0);
							shotPlayer.setBonusHealthTimer(0);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						} else {
							shotPlayer.setBonusHealth(shotPlayerBonusHealth - damageToDealToPlayer);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						}

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerActionBar(shotPlayer);
					}
				}



			} else {
				MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();
				double shotPlayerBonusHealth = shotPlayer.getBonusHealth();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shooterCritChance = playerShooter.getCritChance();
				double shooterCritDamage = playerShooter.getCritDamage();

				if(Utilities.getCritRoll(shooterCritChance)) {
					double shotPlayerEffectiveHealth =  (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = getCritDamageToDealToPlayer(shooterStrength, shooterDamage, shooterCritDamage);

					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
						killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());
					} else {
						if(shotPlayerBonusHealth - damageToDealToPlayer < 0) {
							shotPlayer.setBonusHealth(0);
							shotPlayer.setBonusHealthTimer(0);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						} else {
							shotPlayer.setBonusHealth(shotPlayerBonusHealth - damageToDealToPlayer);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						}

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerActionBar(shotPlayer);
					}
				} else {
					double shotPlayerEffectiveHealth = (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);
					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer)) {
						killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());

					} else {


						if(shotPlayerBonusHealth - damageToDealToPlayer < 0) {
							shotPlayer.setBonusHealth(0);
							shotPlayer.setBonusHealthTimer(0);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						} else {
							shotPlayer.setBonusHealth(shotPlayerBonusHealth - damageToDealToPlayer);
							damageToDealToPlayer = damageToDealToPlayer - shotPlayerBonusHealth;
						}

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerActionBar(shotPlayer);
					}
				}


			}
		}

		Entity entityShot = e.getEntity();
		entityShot.remove();
	}

	public static void PlayerHitHealth(EntityDamageByEntityEvent e) {
		PlayerStats shotPlayer = PlayerStats.getPlayerStats(e.getEntity().getUniqueId());
		if(e.getDamager() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();
				double shotPlayerBonusHealth = shotPlayer.getBonusHealth();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shooterCritChance = playerShooter.getCritChance();
				double shooterCritDamage = playerShooter.getCritDamage();

				if(Utilities.getCritRoll(shooterCritChance)) {
					double shotPlayerEffectiveHealth = (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = getCritDamageToDealToPlayer(shooterStrength, shooterDamage, shooterCritDamage);

					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
						killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());
					} else {

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerActionBar(shotPlayer);
					}
				} else {
					double shotPlayerEffectiveHealth = (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = shooterDamage + shooterDamage * (shooterStrength * 0.01 + 1);
					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer)) {
						killPlayer(shotPlayer, " was killed by " + ((Player) shooter).getDisplayName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());

					} else {

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - damageToDealToPlayer));

						updatePlayerActionBar(shotPlayer);
					}
				}

			} else {
				MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getCurrentHealth();
				double shotPlayerDefence = shotPlayer.getDefence();
				double shotPlayerBonusHealth = shotPlayer.getBonusHealth();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shooterCritChance = playerShooter.getCritChance();
				double shooterCritDamage = playerShooter.getCritDamage();

				HitEffects.applyMobHitEffect(playerShooter, shotPlayer);

				if(Utilities.getCritRoll(shooterCritChance)) {
					double shotPlayerEffectiveHealth = (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = getCritDamageToDealToPlayer(shooterStrength, shooterDamage, shooterCritDamage);

					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
						if(shooter.getEquipment().getItemInMainHand() == null || shooter.getEquipment().getItemInMainHand().getItemMeta() == null) {
							killPlayer(shotPlayer, " was killed by " + playerShooter.getName());
						} else {
							killPlayer(shotPlayer, " was killed by " + playerShooter.getName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());
						}
					} else {

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerActionBar(shotPlayer);
					}
				} else {
					double shotPlayerEffectiveHealth = (shotPlayerHealth + shotPlayerBonusHealth ) * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);
					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
						if(shooter.getEquipment().getItemInMainHand() == null || shooter.getEquipment().getItemInMainHand().getItemMeta() == null) {
							killPlayer(shotPlayer, " was killed by " + playerShooter.getName());
						} else {
							killPlayer(shotPlayer, " was killed by " + playerShooter.getName() + " with " + shooter.getEquipment().getItemInMainHand().getItemMeta().getDisplayName());
						}
					} else {

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerActionBar(shotPlayer);
					}
				}
			}
		}
	}

	private static double getCritDamageToDealToPlayer(double shooterStrength, double shooterDamage, double shooterCritDamage) {
		return shooterDamage * (shooterStrength * 0.01 + 1) * (shooterCritDamage * 0.01 + 1);
	}
	public static void updatePlayerHealth(PlayerStats p) {
		Player player = p.getPlayer();
		double healthPercent = p.getCurrentHealth() / p.getHealth();

		player.setHealth(healthPercent/0.05);
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
		} else {
			player.spigot().sendMessage(
					ChatMessageType.ACTION_BAR,
					new TextComponent(net.md_5.bungee.api.ChatColor.RED + "❤ " + (int) p.getCurrentHealth() + net.md_5.bungee.api.ChatColor.GRAY + "/" + net.md_5.bungee.api.ChatColor.RED + (int) p.getHealth() + "   " + net.md_5.bungee.api.ChatColor.GREEN + "🛡 " + (int) p.getDefence() + "   " + net.md_5.bungee.api.ChatColor.DARK_AQUA + "✎ " + net.md_5.bungee.api.ChatColor.AQUA + (int) p.getCurrentMana() + net.md_5.bungee.api.ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
		}
	}
	public static void killPlayer(PlayerStats p, String killMessage) {
		Player player = p.getPlayer();
		player.setHealth(0.00);
		Bukkit.getServer().broadcastMessage(player.getDisplayName() + killMessage);
		p.setCurrentHealth(p.getHealth());
		p.setCurrentMana(p.getMana());
	}
}
