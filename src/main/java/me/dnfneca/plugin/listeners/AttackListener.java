// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.Listener;

public class AttackListener implements Listener
{
    @EventHandler
    public void onHit(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            final LivingEntity hitEntity = (LivingEntity)e.getEntity();
            if (p.getInventory().getItemInMainHand() != null) {
                final ItemStack item = p.getInventory().getItemInMainHand();
                final ItemMeta meta = item.getItemMeta();
                if (meta == null) {
                    return;
                }
                if (meta.getDisplayName().contains("Sticky")) {
                    hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 2));
                }
            }
        }
    }
}
