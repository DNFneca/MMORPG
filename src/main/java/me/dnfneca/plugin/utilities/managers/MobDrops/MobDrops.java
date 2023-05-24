package me.dnfneca.plugin.utilities.managers.MobDrops;

import me.dnfneca.plugin.CustomMobs.CustomMobDrops.GenericZombie;
import me.dnfneca.plugin.CustomMobs.CustomMobDrops.Ghoul;
import me.dnfneca.plugin.CustomMobs.MobStats;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;

public class MobDrops {
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
}
