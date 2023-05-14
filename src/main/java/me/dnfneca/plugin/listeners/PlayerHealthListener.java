// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.listeners;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import me.dnfneca.plugin.utilities.managers.Health.PlayerHealth;
import org.bukkit.event.entity.ProjectileHitEvent;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class PlayerHealthListener implements Listener
{
    ArrayList<String> tags;
    
    public PlayerHealthListener() {
        this.tags = new ArrayList<String>();
    }
    
    @EventHandler
    public void onBowDamage(final ProjectileHitEvent e) {
        PlayerHealth.ProjectileHitHealth(e);
    }
    
    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent e) {
        PlayerHealth.PlayerHealth(e);
    }
}
