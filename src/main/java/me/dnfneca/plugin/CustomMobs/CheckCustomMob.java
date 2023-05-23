// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.CustomMobs;

import me.dnfneca.plugin.utilities.managers.Stats;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class CheckCustomMob implements Listener {
	public static ArrayList<String> check(final LivingEntity InvolvedEntity) {
		final ArrayList<String> tags = new ArrayList<String>();
		switch (InvolvedEntity.getType()) {
			case SPIDER: {
				if (InvolvedEntity.getCustomName().contains("Spider")) {
					InvolvedEntity.removeScoreboardTag(String.valueOf(InvolvedEntity.getMaxHealth()));
					final double maxHealth = BasicSpider.MaxHealth;
					tags.add(0, String.valueOf(BasicSpider.MaxHealth));
					tags.add(1, String.valueOf(BasicSpider.Damage));
					tags.add(2, String.valueOf(BasicSpider.Strength));
					tags.add(3, String.valueOf(BasicSpider.Defence));
					tags.add(4, Stats.getRandomRarity(InvolvedEntity.getUniqueId()));
					tags.add(5, String.valueOf(BasicSpider.Level));
					tags.add(6, BasicSpider.Type);
					tags.add(7, BasicSpider.Name);
					break;
				}
				break;
			}
			case WOLF: {
				if (InvolvedEntity.getCustomName().contains("Wolf")) {
					InvolvedEntity.removeScoreboardTag(String.valueOf(InvolvedEntity.getMaxHealth()));
					final double maxHealth = BasicWolf.MaxHealth;
					tags.add(0, String.valueOf(BasicWolf.MaxHealth));
					tags.add(1, String.valueOf(BasicWolf.Damage));
					tags.add(2, String.valueOf(BasicWolf.Strength));
					tags.add(3, String.valueOf(BasicWolf.Defence));
					tags.add(4, Stats.getRandomRarity(InvolvedEntity.getUniqueId()));
					tags.add(5, String.valueOf(BasicWolf.Level));
					tags.add(6, BasicWolf.Type);
					tags.add(7, BasicWolf.Name);
					break;
				}
				break;
			}
			case ZOMBIE: {
				if (InvolvedEntity.getCustomName().contains("Dummy")) {
					InvolvedEntity.removeScoreboardTag(String.valueOf(InvolvedEntity.getMaxHealth()));
					final double maxHealth = Dummy.MaxHealth;
					tags.add(0, String.valueOf(Dummy.MaxHealth));
					tags.add(1, String.valueOf(Dummy.Damage));
					tags.add(2, String.valueOf(Dummy.Strength));
					tags.add(3, String.valueOf(Dummy.Defence));
					tags.add(4, Stats.getRandomRarity(InvolvedEntity.getUniqueId()));
					tags.add(5, String.valueOf(Dummy.Level));
					tags.add(6, Dummy.Type);
					tags.add(7, Dummy.Name);
					break;
				}
				break;
			}
			case HUSK: {
				if (InvolvedEntity.getCustomName().contains("Ghoul")) {
					InvolvedEntity.removeScoreboardTag(String.valueOf(InvolvedEntity.getMaxHealth()));
					final double maxHealth = Ghoul.MaxHealth;
					tags.add(0, String.valueOf(Ghoul.MaxHealth));
					tags.add(1, String.valueOf(Ghoul.Damage));
					tags.add(2, String.valueOf(Ghoul.Strength));
					tags.add(3, String.valueOf(Ghoul.Defence));
					tags.add(4, Stats.getRandomRarity(InvolvedEntity.getUniqueId()));
					tags.add(5, String.valueOf(Ghoul.Level));
					tags.add(6, Ghoul.Type);
					tags.add(7, Ghoul.Name);
					break;
				}
				break;
			}
		}
		return tags;
	}

	public static ArrayList<String> attack(final LivingEntity InvolvedEntity, final Player p) {
		final ArrayList<String> tags = new ArrayList<String>();
		if (EntityType.SPIDER == InvolvedEntity.getType()) {
			if (InvolvedEntity.getCustomName().contains("Spider")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
			}
		}
		return tags;
	}
}
