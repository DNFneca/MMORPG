package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.utilities.managers.Stats;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

import static me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider.*;

public class CheckCustomMob implements Listener {

    public static ArrayList<String> check(LivingEntity InvolvedEntity) {
        double maxHealth;
        ArrayList<String> tags = new ArrayList<>();
        switch (InvolvedEntity.getType()) {
            case SPIDER:
                if (InvolvedEntity.getCustomName().contains("Spider")) {
                    InvolvedEntity.removeScoreboardTag(String.valueOf(InvolvedEntity.getMaxHealth()));
                    maxHealth = MaxHealth;
                    tags.add(0, String.valueOf(MaxHealth));
                    tags.add(1, String.valueOf(Damage));
                    tags.add(2, String.valueOf(Strength));
                    tags.add(3, String.valueOf(Defence));
                    tags.add(4, Stats.getRandomRarity(InvolvedEntity.getUniqueId()));
                    tags.add(5, String.valueOf(Level));
                    tags.add(6, Type);
                    tags.add(7, Name);
                }
                break;
        }
        return tags;
    }

    public static ArrayList<String> attack(LivingEntity InvolvedEntity, Player p) {
        ArrayList<String> tags = new ArrayList<>();
        switch (InvolvedEntity.getType()) {
            case SPIDER:
                if (InvolvedEntity.getCustomName().contains("Spider")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
                }
                break;
        }
        return tags;
    }
}
