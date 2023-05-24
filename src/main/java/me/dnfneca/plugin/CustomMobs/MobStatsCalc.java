package me.dnfneca.plugin.CustomMobs;

import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerLevels;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;

import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomItemByName;


public class MobStatsCalc {

	public static void Calculate(final MobStats p) {


		if(null == p) {
			return;
		}


		String[] itemStats = MobStatsCalc.getWeaponStats(p.getMobStats());
		double itemHealth = Double.parseDouble(itemStats[0]);
		double itemDamage = Double.parseDouble(itemStats[1]);
		double itemDefence = Double.parseDouble(itemStats[2]);
		double itemStrength = Double.parseDouble(itemStats[3]);
		double itemSpeed = Double.parseDouble(itemStats[4]);
		double itemCritDamage = Double.parseDouble(itemStats[6]);
		double itemCritChance = Double.parseDouble(itemStats[7]);

		String[] armorStats = MobStatsCalc.getCombinedArmorStats(p.getMobStats());
		double armorHealth = Double.parseDouble(armorStats[0]);
		double armorDamage = Double.parseDouble(armorStats[1]);
		double armorDefence = Double.parseDouble(armorStats[2]);
		double armorStrength = Double.parseDouble(armorStats[3]);
		double armorSpeed = Double.parseDouble(armorStats[4]);
		double armorCritDamage = Double.parseDouble(armorStats[6]);
		double armorCritChance = Double.parseDouble(armorStats[7]);

		final double BaseHealth = p.getBaseHealth();
		final double BaseDamage = p.getBaseDamage();
		final double BaseDefence = p.getBaseDefence();
		final double BaseStrength = p.getBaseStrength();
		final double BaseSpeed = p.getBaseSpeed();
		final double BaseCritDamage = p.getBaseCritDamage();
		final double BaseCritChance = p.getBaseCritChance();


		if (p.getCurrentHealth() < p.getHealth() && 0 < p.getHealthRegenTime()) {
			p.setHealthRegenTime(p.getHealthRegenTime() - 1);
		}


		if (0 == p.getHealthRegenTime()) {
			if (p.getCurrentHealth() + p.getHealth() * 0.01 > p.getHealth()) {
				p.setCurrentHealth(p.getHealth());
			} else {
				p.setCurrentHealth(p.getCurrentHealth() + p.getHealth() * 0.01);
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
			MobStats.getEntity(p.getUUID()).setCustomNameVisible(true);
			MobStats.getEntity(p.getUUID()).setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + p.getLevel() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + p.getName() + ChatColor.RED + "❤" + p.getHealth());
		} else {
			MobStats.getEntity(p.getUUID()).setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + p.getLevel() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + p.getName() + ChatColor.RED + ChatColor.RED + "❤ " + p.getCurrentHealth() + "/" + p.getHealth());
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

	public static String[] getWeaponStats(final MobStats player) {
		String[] itemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};
		final LivingEntity entity = (LivingEntity) Bukkit.getEntity(player.UUID);

		if (null == entity.getEquipment().getItemInMainHand().getItemMeta()) {
			return itemStats;
		}
		Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getItemInMainHand().getItemMeta().getDisplayName()));
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


	public static String[] getCombinedArmorStats(final MobStats player) {
		String[] itemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};
		final LivingEntity entity = (LivingEntity) Bukkit.getEntity(player.UUID);
		if(null != entity.getEquipment().getHelmet() && null != entity.getEquipment().getHelmet().getItemMeta()) {
			final Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getHelmet().getItemMeta().getDisplayName()));
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
			final Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getChestplate().getItemMeta().getDisplayName()));
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
			final Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getLeggings().getItemMeta().getDisplayName()));
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
			final Item item = getCustomItemByName(ChatColor.stripColor(entity.getEquipment().getBoots().getItemMeta().getDisplayName()));
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
