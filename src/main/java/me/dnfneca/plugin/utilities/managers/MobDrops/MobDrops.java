package me.dnfneca.plugin.utilities.managers.MobDrops;

import me.dnfneca.plugin.CustomMobs.CustomMobDrops.GenericZombie;
import me.dnfneca.plugin.CustomMobs.CustomMobDrops.Ghoul;
import me.dnfneca.plugin.CustomMobs.MobStats;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import static me.dnfneca.plugin.Plugin.CustomMobsAvailable;

public enum MobDrops {
    ;

    public static void dropMobItems(LivingEntity p, HumanEntity shooter, MobStats mob) {
        switch (mob.getName()) {
            case "Ghoul":
            case "Oni":
            case "Ghoul mage":
            case "Ghoul rouge":
                GenericZombie.dropCustomDrops(p, shooter);
                break;
        }
    }

    public static void dropMobXp(LivingEntity p, HumanEntity shooter, MobStats mob) {
        for (MobStats mobStats : CustomMobsAvailable) {
            if(ChatColor.stripColor(mob.getName()).equals(mobStats.getName())) {
                PlayerLevels.add((Player) shooter, mob.getXpDropAmount());
                ((Player) shooter).playSound(shooter.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 3);
            }
        }

    }
}
