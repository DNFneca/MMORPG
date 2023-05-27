package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import static me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager.HitDetection;

public class Hook {
	public static boolean Hook(PlayerStats p, float cost) {
		p.removeMana(cost);
		p.setManaSpent(cost);
		p.setManaTimer(6);
		new BukkitRunnable() {
			double distanceTraveled;

			public void run() {
				Location loc = p.getPlayer().getEyeLocation();
				this.distanceTraveled = 0.0;
				while (15.0 >= distanceTraveled) {
					loc.add(loc.getDirection());
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 1, new Particle.DustOptions(Color.fromRGB(51, 255, 0), 4.0F));
					LivingEntity MobsNearby = HitDetection(loc, 1, p);
					if (MobsNearby != null) {
						if(MobStats.getMob(MobsNearby.getUniqueId()).setStunDuration(8)) {
							LivingEntity finalMobsNearby = MobsNearby;
							MobsNearby.getWorld().playSound(MobsNearby, Sound.ITEM_ARMOR_EQUIP_CHAIN, 1, 1.5F);
							MobsNearby.getWorld().playSound(MobsNearby, Sound.ENTITY_LEASH_KNOT_PLACE, 1, 1.5F);
							MobsNearby.setVelocity(p.getPlayer().getLocation().getDirection().multiply(-1).normalize());
							p.setCurrentMana(p.getCurrentMana() + cost * 0.75);
							new BukkitRunnable() {

								@Override
								public void run() {
									if(MobsNearby != null && MobStats.getMob(MobsNearby.getUniqueId()) != null  && MobStats.getMob(MobsNearby.getUniqueId()).getStunDuration() <= 0) {
										finalMobsNearby.getWorld().playSound(finalMobsNearby, Sound.BLOCK_CHAIN_BREAK, 10, 2);
									}
								}
							}.runTaskLater(Plugin.getInstance(), (long) (2*20));
						}
						this.cancel();
						return;
					}
					++this.distanceTraveled;
				}
				this.cancel();
			}
		}.runTaskTimer(Plugin.getInstance(), 4L, 1L);
		return true;
	}
}
