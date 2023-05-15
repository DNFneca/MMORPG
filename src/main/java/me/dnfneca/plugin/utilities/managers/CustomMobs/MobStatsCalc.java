package me.dnfneca.plugin.utilities.managers.CustomMobs;

import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import me.dnfneca.plugin.utilities.managers.Statistics.StatCalc;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomItemByName;
import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomReforgeByName;


public class MobStatsCalc {

	public static void Calculate(MobStats p) {





		final String[] itemStats = getWeaponStats(p.getMobStats());
		final double itemHealth = Double.parseDouble(itemStats[0]);
		final double itemDamage = Double.parseDouble(itemStats[1]);
		final double itemDefence = Double.parseDouble(itemStats[2]);
		final double itemStrength = Double.parseDouble(itemStats[3]);
		final double itemSpeed = Double.parseDouble(itemStats[4]);
		final double itemCritDamage = Double.parseDouble(itemStats[6]);
		final double itemCritChance = Double.parseDouble(itemStats[7]);

		final String[] armorStats = getCombinedArmorStats(p.getMobStats());
		final double armorHealth = Double.parseDouble(armorStats[0]);
		final double armorDamage = Double.parseDouble(armorStats[1]);
		final double armorDefence = Double.parseDouble(armorStats[2]);
		final double armorStrength = Double.parseDouble(armorStats[3]);
		final double armorSpeed = Double.parseDouble(armorStats[4]);
		final double armorCritDamage = Double.parseDouble(armorStats[6]);
		final double armorCritChance = Double.parseDouble(armorStats[7]);

		double BaseHealth = p.getBaseHealth();
		double BaseDamage = p.getBaseDamage();
		double BaseDefence = p.getBaseDefence();
		double BaseStrength = p.getBaseStrength();
		double BaseSpeed = p.getBaseSpeed();
		double BaseCritDamage = p.getBaseCritDamage();
		double BaseCritChance = p.getBaseCritChance();


		if (p.getCurrentHealth() < p.getHealth() && 0 < p.getHealthRegenTime()) {
			p.setHealthRegenTime(p.getHealthRegenTime() - 1);
		}


		if (0 == p.getHealthRegenTime()) {
			if (p.getCurrentHealth() + p.getHealth() * 0.1 > p.getHealth()) {
				p.setCurrentHealth(p.getHealth());
			} else {
				p.setCurrentHealth(p.getCurrentHealth() + p.getHealth() * 0.1);
			}
			p.setHealthRegenTime(4);
		}


		if (p.getHealth() == p.getCurrentHealth()) {
			p.setHealth(BaseHealth + itemHealth + armorHealth);
			p.setCurrentHealth(BaseHealth + itemHealth + armorHealth);
		} else {
			p.setHealth(BaseHealth + itemHealth + armorHealth);
		}
		p.setDamage(BaseDamage  + itemDamage + armorDamage);
		p.setDefence(BaseDefence + itemDefence + armorDefence);
		p.setStrength(BaseStrength + itemStrength + armorStrength);
		p.setCritDamage(BaseCritDamage + itemCritDamage + armorCritDamage);
		p.setCritChance(BaseCritChance + itemCritChance + armorCritChance);

		if(p.getHealth() == p.getCurrentHealth()) {
			p.getEntity(p.getUUID()).setCustomNameVisible(true);
			p.getEntity(p.getUUID()).setCustomName(String.valueOf(p.getHealth()));
		} else {
			p.getEntity(p.getUUID()).setCustomName(ChatColor.RED + "❤ " + String.valueOf(p.getCurrentHealth()) + "/" + String.valueOf(p.getHealth()));
		}
	}

	//    double Health;
//    double Damage;
//    double Defence;
//    double Strength;
//    double Speed;
//    double Mana;
//    double CritDamage;
//    double CritChance;
//    double Stealth;

	public static String[] getWeaponStats(MobStats player) {
		final String[] itemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};
		LivingEntity entity = (LivingEntity) Bukkit.getEntity(player.UUID);

		if (null == entity.getEquipment().getItemInMainHand().getItemMeta()) {
			return itemStats;
		}
		final Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getItemInMainHand().getItemMeta().getDisplayName()));
		if (null == item) {
			return itemStats;
		}
		if (PlayerLevels.getLevel(PlayerStats.getPlayerStats(entity.getUniqueId()).getPlayer()) < getCustomItemByName(ChatColor.stripColor(PlayerStats.getPlayerStats(entity.getUniqueId()).getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName())).getMinimalLevelForUsage()) {
			return itemStats;
		}
		if ("Weapon".equals(item.getType())) {
			itemStats[0] = String.valueOf(item.getHealth());
			itemStats[1] = String.valueOf(item.getDamage());
			itemStats[2] = String.valueOf(item.getDefence());
			itemStats[3] = String.valueOf(item.getStrength());
			itemStats[4] = String.valueOf(item.getSpeed());
			itemStats[5] = String.valueOf(item.getMana());
			itemStats[6] = String.valueOf(item.getCritDamage());
			itemStats[7] = String.valueOf(item.getCritChance());
			itemStats[8] = String.valueOf(item.getStealth());
			return itemStats;
		} else {
			return itemStats;
		}
	}


	public static String[] getCombinedArmorStats(MobStats player) {
		final String[] itemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};
		LivingEntity entity = (LivingEntity) Bukkit.getEntity(player.UUID);
		if(null != entity.getEquipment().getHelmet() && null != entity.getEquipment().getHelmet().getItemMeta()) {
			Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getHelmet().getItemMeta().getDisplayName()));
			if (null != item && "Armor".equals(item.getType())) {
				itemStats[0] = String.valueOf(Double.parseDouble(itemStats[0]) + item.getHealth());
				itemStats[1] = String.valueOf(Double.parseDouble(itemStats[1]) + item.getDamage());
				itemStats[2] = String.valueOf(Double.parseDouble(itemStats[2]) + item.getDefence());
				itemStats[3] = String.valueOf(Double.parseDouble(itemStats[3]) + item.getStrength());
				itemStats[4] = String.valueOf(Double.parseDouble(itemStats[4]) + item.getSpeed());
				itemStats[5] = String.valueOf(Double.parseDouble(itemStats[5]) + item.getMana());
				itemStats[6] = String.valueOf(Double.parseDouble(itemStats[6]) + item.getCritDamage());
				itemStats[7] = String.valueOf(Double.parseDouble(itemStats[7]) + item.getCritChance());
				itemStats[8] = String.valueOf(Double.parseDouble(itemStats[8]) + item.getStealth());
			}
		}
		if(null != entity.getEquipment().getChestplate() && null != entity.getEquipment().getChestplate().getItemMeta()) {
			Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getChestplate().getItemMeta().getDisplayName()));
			if (null != item && "Armor".equals(item.getType())) {
				itemStats[0] = String.valueOf(Double.parseDouble(itemStats[0]) + item.getHealth());
				itemStats[1] = String.valueOf(Double.parseDouble(itemStats[1]) + item.getDamage());
				itemStats[2] = String.valueOf(Double.parseDouble(itemStats[2]) + item.getDefence());
				itemStats[3] = String.valueOf(Double.parseDouble(itemStats[3]) + item.getStrength());
				itemStats[4] = String.valueOf(Double.parseDouble(itemStats[4]) + item.getSpeed());
				itemStats[5] = String.valueOf(Double.parseDouble(itemStats[5]) + item.getMana());
				itemStats[6] = String.valueOf(Double.parseDouble(itemStats[6]) + item.getCritDamage());
				itemStats[7] = String.valueOf(Double.parseDouble(itemStats[7]) + item.getCritChance());
				itemStats[8] = String.valueOf(Double.parseDouble(itemStats[8]) + item.getStealth());
			}
		}
		if(null != entity.getEquipment().getLeggings() && null != entity.getEquipment().getLeggings().getItemMeta()) {
			Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getLeggings().getItemMeta().getDisplayName()));
			if (null != item && "Armor".equals(item.getType())) {
				itemStats[0] = String.valueOf(Double.parseDouble(itemStats[0]) + item.getHealth());
				itemStats[1] = String.valueOf(Double.parseDouble(itemStats[1]) + item.getDamage());
				itemStats[2] = String.valueOf(Double.parseDouble(itemStats[2]) + item.getDefence());
				itemStats[3] = String.valueOf(Double.parseDouble(itemStats[3]) + item.getStrength());
				itemStats[4] = String.valueOf(Double.parseDouble(itemStats[4]) + item.getSpeed());
				itemStats[5] = String.valueOf(Double.parseDouble(itemStats[5]) + item.getMana());
				itemStats[6] = String.valueOf(Double.parseDouble(itemStats[6]) + item.getCritDamage());
				itemStats[7] = String.valueOf(Double.parseDouble(itemStats[7]) + item.getCritChance());
				itemStats[8] = String.valueOf(Double.parseDouble(itemStats[8]) + item.getStealth());
			}
		}
		if(null != entity.getEquipment().getBoots() && null != entity.getEquipment().getBoots().getItemMeta()) {
			Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getBoots().getItemMeta().getDisplayName()));
			if (null != item && "Armor".equals(item.getType())) {
				itemStats[0] = String.valueOf(Double.parseDouble(itemStats[0]) + item.getHealth());
				itemStats[1] = String.valueOf(Double.parseDouble(itemStats[1]) + item.getDamage());
				itemStats[2] = String.valueOf(Double.parseDouble(itemStats[2]) + item.getDefence());
				itemStats[3] = String.valueOf(Double.parseDouble(itemStats[3]) + item.getStrength());
				itemStats[4] = String.valueOf(Double.parseDouble(itemStats[4]) + item.getSpeed());
				itemStats[5] = String.valueOf(Double.parseDouble(itemStats[5]) + item.getMana());
				itemStats[6] = String.valueOf(Double.parseDouble(itemStats[6]) + item.getCritDamage());
				itemStats[7] = String.valueOf(Double.parseDouble(itemStats[7]) + item.getCritChance());
				itemStats[8] = String.valueOf(Double.parseDouble(itemStats[8]) + item.getStealth());
			}
		}

		return itemStats;
	}
}
