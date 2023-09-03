package me.dnfneca.plugin.utilities.managers.Health;

import me.dnfneca.plugin.CustomMobs.CustomMobDrops.Ghoul;
import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.utilities.managers.Item.Item;
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
import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomItemByName;
import static me.dnfneca.plugin.utilities.managers.MobDrops.MobDrops.dropMobItems;
import static me.dnfneca.plugin.utilities.managers.MobDrops.MobDrops.dropMobXp;


public enum MobHealth {
	;

	public static void MobProjectileHitHealth(ProjectileHitEvent e) {
		MobStats shotPlayer = MobStats.getMob(e.getHitEntity().getUniqueId());
		if(e.getEntity().getShooter() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
				double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
					killPlayer((LivingEntity) Bukkit.getEntity(shotPlayer.getUUID()), (HumanEntity) shooter, shotPlayer);
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

				if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
					killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
				} else {

					shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

					updatePlayerHealth(shotPlayer);
				}


			}
		}

		Entity entityShot = e.getEntity();
		entityShot.remove();
	}

	public static void MobHitHealth(EntityDamageByEntityEvent e) {
		MobStats shotPlayer = MobStats.getMob(e.getEntity().getUniqueId());
		if(e.getDamager() instanceof LivingEntity shooter) {
			if(shooter instanceof Player) {
				if(((Player) shooter).getInventory().getItemInMainHand() != null  && ((Player) shooter).getInventory().getItemInMainHand().getItemMeta() != null && ((Player) shooter).getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					Item customPlayerItem = getCustomItemByName(((Player) shooter).getInventory().getItemInMainHand().getItemMeta().getDisplayName());
					if (customPlayerItem == null || customPlayerItem.getType() == "Bow") {
						return;
					}

					PlayerStats playerShooter = PlayerStats.getPlayerStats(shooter.getUniqueId());


					double shotPlayerHealth = shotPlayer.getHealth();
					double shotPlayerDefence = shotPlayer.getDefence();

					double shooterStrength = playerShooter.getStrength();
					double shooterDamage = playerShooter.getDamage();

					double shooterCritChance = playerShooter.getCritChance();
					double shooterCritDamage = playerShooter.getCritDamage();

					if (Utilities.getCritRoll(shooterCritChance)) {
						playerShooter.getPlayer().sendMessage("Crit");
						double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
						double damageToDealToPlayer = getCritDamageToDealToPlayer(shooterStrength, shooterDamage, shooterCritDamage);

						if (damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
							killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
						} else {

							shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

							updatePlayerHealth(shotPlayer);
						}
					} else {
						double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
						double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

						if (damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
							killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
						} else {

							shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

							updatePlayerHealth(shotPlayer);
						}
					}
				}
			} else {
				MobStats playerShooter = MobStats.getMob(shooter.getUniqueId());


				double shotPlayerHealth = shotPlayer.getHealth();
				double shotPlayerDefence = shotPlayer.getDefence();

				double shooterStrength = playerShooter.getStrength();
				double shooterDamage = playerShooter.getDamage();

				double shooterCritChance = playerShooter.getCritChance();
				double shooterCritDamage = playerShooter.getCritDamage();



				if(Utilities.getCritRoll(shooterCritChance)) {
					double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = getCritDamageToDealToPlayer(shooterStrength, shooterDamage, shooterCritDamage);

					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
						killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
					} else {

						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));

						updatePlayerHealth(shotPlayer);
					}
				} else {
					double shotPlayerEffectiveHealth = shotPlayerHealth * (shotPlayerDefence * 0.01 + 1);
					double damageToDealToPlayer = shooterDamage * (shooterStrength * 0.01 + 1);

					if(damageToDealToPlayer > shotPlayerEffectiveHealth || 0.00 > (shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)))) {
						killPlayer((LivingEntity) e.getEntity(), (HumanEntity) shooter, shotPlayer);
					} else {
						shotPlayer.setCurrentHealth(shotPlayer.getCurrentHealth() - (shotPlayerEffectiveHealth - (shotPlayerEffectiveHealth - damageToDealToPlayer)));
						updatePlayerHealth(shotPlayer);
					}
				}
			}
		}
	}

	private static double getCritDamageToDealToPlayer(double shooterStrength, double shooterDamage, double shooterCritDamage) {
		return shooterDamage * (shooterStrength * 0.01 + 1) * (shooterCritDamage * 0.01 + 1);
	}

	public static void updatePlayerHealth(MobStats p) {
		MobStats.getEntity(p.getUUID()).setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + p.getLevel() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + p.getName() + ChatColor.RED + ChatColor.RED + "❤ " + p.getCurrentHealth() + "/" + p.getHealth());
	}
	public static void killPlayer(LivingEntity p, HumanEntity shooter, MobStats mob) {
		dropMobItems(p, shooter, mob);
		dropMobXp(p, shooter, mob);
		p.remove();
		CustomMobs.remove(mob);
	}
}
