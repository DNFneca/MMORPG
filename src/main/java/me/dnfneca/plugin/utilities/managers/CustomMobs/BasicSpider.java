// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.CustomMobs;

import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attributable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import java.util.List;
import java.util.Iterator;
import org.bukkit.entity.FallingBlock;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Spider;
import org.bukkit.Location;
import me.dnfneca.plugin.Plugin;
import org.bukkit.event.Listener;

public class BasicSpider implements Listener
{
    public static int MaxHealth;
    public static int Level;
    public static String Type;
    public static String Name;
    public static int Defence;
    public static int Strength;
    public static int Damage;
    static Plugin plugin;
    
    public BasicSpider(final Plugin plugin) {
        BasicSpider.plugin = plugin;
    }
    
    public static void createSpider(final Location location) {
        final long[] AB1CD = { 0L };
        final long[] AB2CD = { 0L };
        final String[] entities = new String[0];
        final Spider spider = (Spider)location.getWorld().spawn(location, (Class)Spider.class);
        spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
        spider.setCustomNameVisible(true);
        final Attributable creatureAt = (Attributable)spider;
        final AttributeInstance attribute = creatureAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(100.0);
        spider.setHealth(100.0);
        final String[] getScores = spider.getScoreboardTags().toArray(new String[10]);
        final String level = getScores[0];
        spider.setCustomName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.GRAY), BasicSpider.Level, String.valueOf(ChatColor.DARK_GRAY), String.valueOf(ChatColor.RED)));
        new BukkitRunnable() {
            public void run() {
                if (AB1CD[0] >= 0L) {
                    final long[] val$AB1CD = AB1CD;
                    final int n = 0;
                    --val$AB1CD[n];
                }
                if (AB2CD[0] >= 0L) {
                    final long[] val$AB2CD = AB2CD;
                    final int n2 = 0;
                    --val$AB2CD[n2];
                }
                for (final Player p : Bukkit.getOnlinePlayers()) {
                    final List<Entity> e = (List<Entity>)p.getNearbyEntities(1.0, 1.0, 1.0);
                    for (final Entity entity : e) {
                        if (entity.getType() == EntityType.ARMOR_STAND && entity.getScoreboardTags().contains("FallingBlock")) {
                            for (final Entity en : entity.getNearbyEntities(5.0, 5.0, 5.0)) {
                                if (en instanceof Player) {
                                    spider.attack(en);
                                }
                            }
                            entity.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, entity.getLocation(), 5);
                            final FallingBlock fb = entity.getPassengers().get(0);
                            entity.eject();
                            fb.remove();
                            entity.remove();
                        }
                    }
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)BasicSpider.plugin, 0L, 1L);
        new BukkitRunnable() {
            public void run() {
                final int range = 10;
                if (!spider.isDead()) {
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 255));
                    if (spider.getTarget() == null) {
                        final List<Entity> entityaround = (List<Entity>)spider.getNearbyEntities((double)range, (double)range, (double)range);
                        for (final Entity p : entityaround) {
                            if (p instanceof Player) {
                                final int stealth = ((Player)p).getScoreboard().getObjective("Stats").getScore("Stealth").getScore();
                                if (spider.getLocation().distance(p.getLocation()) >= range - range * stealth * 0.01) {
                                    continue;
                                }
                                spider.setTarget((LivingEntity)p);
                            }
                        }
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)BasicSpider.plugin, 0L, 10L);
        new BukkitRunnable() {
            public void run() {
                if (!spider.isDead()) {
                    if (spider.getTarget() != null && AB1CD[0] <= 0L) {
                        final LivingEntity target = spider.getTarget();
                        if (target.getLocation().distanceSquared(spider.getLocation()) > 10.0 && target.getLocation().distanceSquared(spider.getLocation()) < 25.0) {
                            spider.getWorld().playSound(spider.getLocation(), Sound.ENTITY_WITHER_SHOOT, 5.0f, 5.0f);
                            spider.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, spider.getLocation(), 10);
                            spider.setVelocity(target.getLocation().add(0.0, 2.0, 0.0).subtract(spider.getLocation()).toVector().multiply(0.275));
                            AB1CD[0] = 40L;
                        }
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)BasicSpider.plugin, 0L, 20L);
        new BukkitRunnable() {
            public void run() {
                if (!spider.isDead()) {
                    if (spider.getTarget() != null && AB2CD[0] <= 0L) {
                        final LivingEntity target = spider.getTarget();
                        if (target.getLocation().distanceSquared(spider.getLocation()) > 25.0) {
                            spider.getWorld().playSound(spider.getLocation(), Sound.ENTITY_SPIDER_HURT, 5.0f, 5.0f);
                            spider.getWorld().spawnParticle(Particle.SMOKE_NORMAL, spider.getLocation(), 10);
                            final FallingBlock web = spider.getWorld().spawnFallingBlock(spider.getLocation(), Material.COBWEB, (byte)0);
                            web.setGravity(false);
                            web.setInvulnerable(true);
                            final ArmorStand stand = (ArmorStand)spider.getWorld().spawn(spider.getLocation(), (Class)ArmorStand.class);
                            stand.addScoreboardTag("FallingBlock");
                            stand.setInvisible(true);
                            stand.setInvulnerable(true);
                            web.setHurtEntities(true);
                            web.setDropItem(false);
                            stand.addPassenger((Entity)web);
                            stand.setGravity(true);
                            stand.setSilent(true);
                            stand.setVisible(true);
                            stand.setVelocity(target.getLocation().add(0.0, 1.0, 0.0).subtract(spider.getLocation()).toVector().multiply(0.25));
                            AB2CD[0] = 100L;
                        }
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer((org.bukkit.plugin.Plugin)BasicSpider.plugin, 0L, 20L);
    }
    
    public static void HitEffect() {
    }
    
    static {
        BasicSpider.MaxHealth = 200;
        BasicSpider.Level = 75;
        BasicSpider.Type = "Spider";
        BasicSpider.Name = "Spider";
        BasicSpider.Defence = 100;
        BasicSpider.Strength = 20;
        BasicSpider.Damage = 100;
    }
}
