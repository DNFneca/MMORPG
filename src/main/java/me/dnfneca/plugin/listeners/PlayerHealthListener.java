// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.managers.Health.MobHealth;
import me.dnfneca.plugin.utilities.managers.Health.PlayerHealth;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

public class PlayerHealthListener implements Listener {
	@EventHandler
	public void onBowDamage(ProjectileHitEvent e) {
		if(null != e && null != e.getEntity() && e.getHitEntity() instanceof Player) {
			PlayerHealth.ProjectileHitHealth(e);
		}
		if(null != e && null != e.getEntity() && e.getHitEntity() instanceof LivingEntity) {
			MobHealth.MobProjectileHitHealth(e);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		System.out.println(e.getEntity());
		if(e.getEntity() instanceof Player) {
			PlayerHealth.PlayerHitHealth(e);
		} else {
			MobHealth.MobHitHealth(e);
		}
	}
}
