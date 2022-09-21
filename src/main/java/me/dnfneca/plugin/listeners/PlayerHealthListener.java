package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.utilities.managers.Health.PlayerHealth;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

public class PlayerHealthListener implements Listener {
    ArrayList<String> tags = new ArrayList<>();

    @EventHandler
    public void onBowDamage(ProjectileHitEvent e) {
        PlayerHealth.ProjectileHitHealth(e);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        PlayerHealth.PlayerHealth(e);
    }
}
