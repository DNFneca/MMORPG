// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;

import java.util.Collection;

import static me.dnfneca.plugin.utilities.managers.Abilities.AbilitiesManager.HitDetection;


public enum Tangle {
	;

	public static boolean Tangle(PlayerStats p, float cost) {
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
					p.getPlayer().getWorld().spawnParticle(Particle.REDSTONE, loc, 10, (Object) new Particle.DustOptions(Color.fromRGB(150, 75, 0), 20.0f));
					LivingEntity MobsNearby = HitDetection(loc, 1, p);
					if (MobsNearby != null){
						if(MobStats.getMob(MobsNearby.getUniqueId()).setStunDuration(8)) {
							LivingEntity finalMobsNearby = MobsNearby;
							MobsNearby.getWorld().playSound(MobsNearby, Sound.ITEM_ARMOR_EQUIP_CHAIN, 10, 1.5F);
							new BukkitRunnable() {

								@Override
								public void run() {
									finalMobsNearby.setAI(true);
									finalMobsNearby.getWorld().playSound(finalMobsNearby, Sound.BLOCK_CHAIN_BREAK, 10, 2);
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
