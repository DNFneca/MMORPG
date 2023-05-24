package me.dnfneca.plugin.utilities.managers.Health;

import me.dnfneca.plugin.CustomMobs.CustomMobDrops.Ghoul;
import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import static me.dnfneca.plugin.Plugin.CustomMobs;
import static me.dnfneca.plugin.utilities.managers.MobDrops.MobDrops.dropMobItems;


public enum MobHealth {
	;

	public static void MobProjectileHitHealth(final ProjectileHitEvent e) {
		final MobStats shotPlayer = MobStats.getMob(e.getHitEntity().getUniqueId());
		if(e.getEntity().getShooter() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				final PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				final double shotPlayerHealth = shotPlayer.getHealth();
				final double shotPlayerDefence = shotPlayer.getDefence();

				final double shooterStrength = playerShooter.getStrength();
				final double shooterDamage = playerShooter.getDamage();

				final double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				final double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
					killPlayer((LivingEntity) Bukkit.getEntity(shotPlayer.getUUID()), (HumanEntity) shooter, shotPlayer);
				} else {


					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					updatePlayerHealth(shotPlayer);
				}
			} else {
				final MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				final double shotPlayerHealth = shotPlayer.getHealth();
				final double shotPlayerDefence = shotPlayer.getDefence();

				final double shooterStrength = playerShooter.getStrength();
				final double shooterDamage = playerShooter.getDamage();

				final double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				final double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
					killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					updatePlayerHealth(shotPlayer);
				}


			}
		}

		final Entity entityShot = e.getEntity();
		entityShot.remove();
	}

	public static void MobHitHealth(final EntityDamageByEntityEvent e) {
		final MobStats shotPlayer = MobStats.getMob(e.getEntity().getUniqueId());
		if(e.getDamager() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				final PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				final double shotPlayerHealth = shotPlayer.getHealth();
				final double shotPlayerDefence = shotPlayer.getDefence();

				final double shooterStrength = playerShooter.getStrength();
				final double shooterDamage = playerShooter.getDamage();

				final double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				final double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
					killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					updatePlayerHealth(shotPlayer);
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
					killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					updatePlayerHealth(shotPlayer);
				}


			}
		}
	}
	public static void updatePlayerHealth(final MobStats p) {
		MobStats.getEntity(p.getUUID()).setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + p.getLevel() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + p.getName() + ChatColor.RED + ChatColor.RED + "❤ " + p.getCurrentHealth() + "/" + p.getHealth());
	}
	public static void killPlayer(final LivingEntity p, final HumanEntity shooter, final MobStats mob) {
		dropMobItems(p, shooter, mob);
		p.remove();
		CustomMobs.remove(mob);
	}
}
