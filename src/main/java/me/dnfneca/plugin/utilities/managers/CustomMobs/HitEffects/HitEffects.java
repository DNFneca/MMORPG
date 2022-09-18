package me.dnfneca.plugin.utilities.managers.CustomMobs.HitEffects;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HitEffects {
    public static void mob(EntityDamageByEntityEvent e) {
        switch (e.getDamager().getType()) {
            case SPIDER:
                if (e.getDamager().getCustomName().contains("Spider")) {
                    LivingEntity potEntity = (LivingEntity) e.getEntity();
                    potEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
                }
                break;
            case WOLF:
                if(e.getDamager().getCustomName().contains("Wolf")) {
                    LivingEntity potEntity = (LivingEntity) e.getEntity();
                    potEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30, 2));
                }


        }
    }
}
