// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AttackListener implements Listener {
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player p) {
			LivingEntity hitEntity = (LivingEntity) e.getEntity();
			if (null != p.getInventory().getItemInMainHand()) {
				ItemStack item = p.getInventory().getItemInMainHand();
				ItemMeta meta = item.getItemMeta();
				if (null == meta) {
					return;
				}
				if (meta.getDisplayName().contains("Sticky")) {
					hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 2));
				}
			}
		}
	}
}
