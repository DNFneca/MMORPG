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
        if(e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            LivingEntity hitEntity = (LivingEntity) e.getEntity();

            if(p.getInventory().getItemInMainHand() != null) {
                ItemStack item = p.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                if(meta.getDisplayName().contains("Sticky")) {
                    hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 2));
                }
            }
        }
//        System.out.println(e.getDamage());
//        System.out.println(e.getDamager());
//        LivingEntity entityHit = (LivingEntity) e.getEntity();
//        double hitHealth = entityHit.getHealth();
//
//
//                //Bukkit.getEntity(UUID.randomUUID());
//        String world = e.getEntity().getWorld().toString();
//        Location loc = e.getDamager().getLocation();
//        System.out.println(loc);
////        LivingEntity entity = (LivingEntity) Bukkit.getWorld(world).spawnEntity(loc, ARMOR_STAND);
////        entity.setCustomName("asd");
//        @NotNull Entity stand = e.getEntity().getWorld().spawnEntity(loc.add(0, 1, 0), ARMOR_STAND);
//        stand.setCustomNameVisible(true);
//        stand.setCustomName(String.valueOf(hitHealth));
//        e.getEntity().addPassenger(stand);
//        entityHit.setMaxHealth(2000);
//        entityHit.setHealth(2000);



    }
}


//        e.setCancelled(true);

