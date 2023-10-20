package me.dnfneca.plugin.utilities.managers.Statistics;

import me.dnfneca.plugin.utilities.managers.Item.CustomItemStack;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomItemByName;
import static me.dnfneca.plugin.utilities.managers.Item.Items.getCustomReforgeByName;


public enum PlayerStatCalc {
    ;

    public static void Calculate(PlayerStats p) {

	    if (p.getCurrentHealth() < p.getHealth() && 0 < p.getHealthRegenTime()) {
		    p.setHealthRegenTime(p.getHealthRegenTime() - 1);
	    }


	    if (p.getCurrentMana() < p.getMana() && 0 < p.getManaRegenTime()) {
		    p.setManaRegenTime(p.getManaRegenTime() - 1);
	    }


	    if (0 == p.getHealthRegenTime()) {
		    if (p.getCurrentHealth() - p.getBonusMana() + p.getHealth() * 0.01 > p.getHealth()) {
			    p.setCurrentHealth(p.getHealth());
		    } else {
			    p.setCurrentHealth(p.getCurrentHealth() + p.getBonusHealth() + p.getHealth() * 0.01);
		    }
		    p.setHealthRegenTime(4);
	    }

	    if (0 == p.getManaRegenTime()) {
		    if (p.getCurrentMana() - p.getBonusMana() + p.getMana() * 0.01 > p.getMana()) {
			    p.setCurrentMana(p.getMana());
		    } else {
			    p.setCurrentMana(p.getCurrentMana() + p.getBonusMana() + p.getMana() * 0.01);
		    }
		    p.setManaRegenTime(4);
	    }


	    if(p.getBonusHealthTimer() > 0) {
		    p.setBonusHealthTimer(p.getBonusHealthTimer() - 1);
	    } else if (p.getBonusHealthTimer() < 0) {
		    p.setBonusHealthTimer(0);
		    p.setBonusHealth(0);
	    } else {
		    p.setBonusHealth(0);
	    }

	    if(p.getBonusManaTimer() > 0) {
		    p.setBonusManaTimer(p.getBonusManaTimer() - 1);
	    } else if (p.getBonusManaTimer() < 0) {
		    p.setBonusManaTimer(0);
		    p.setBonusMana(0);
	    } else {
		    p.setBonusMana(0);
	    }

	    updatePlayerActionBar(p);


	}


	public static void updatePlayerActionBar(PlayerStats p) {


		Player player = p.getPlayer();
		if(player == null) {
			return;
		}
		String[] classStats = getPlayerClassStats(p);
		double classHealth = Double.parseDouble(classStats[0]);
		double classDamage = Double.parseDouble(classStats[1]);
		double classDefence = Double.parseDouble(classStats[2]);
		double classStrength = Double.parseDouble(classStats[3]);
		double classSpeed = Double.parseDouble(classStats[4]);
		double classMana = Double.parseDouble(classStats[5]);
		double classCritDamage = Double.parseDouble(classStats[6]);
		double classCritChance = Double.parseDouble(classStats[7]);
		double classStealth = Double.parseDouble(classStats[8]);


		double itemHealth = 0;
		double itemDamage = 0;
		double itemDefence = 0;
		double itemStrength = 0;
		double itemSpeed = 0;
		double itemMana = 0;
		double itemCritDamage = 0;
		double itemCritChance = 0;
		double itemStealth = 0;


		ItemStack itemInMainHand = p.getPlayer().getInventory().getItemInMainHand();

		if(itemInMainHand != null && CustomItemStack.isItemCustomItem(itemInMainHand)) {
			if(CustomItemStack.isItemReforged(itemInMainHand)) {
				itemHealth = CustomItemStack.getItemHealth(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getHealth();
				itemDamage = CustomItemStack.getItemDamage(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getDamage();
				itemDefence = CustomItemStack.getItemDefence(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getDefence();
				itemStrength = CustomItemStack.getItemStrength(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getStrength();
				itemSpeed = CustomItemStack.getItemSpeed(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getSpeed();
				itemMana = CustomItemStack.getItemMana(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getMana();
				itemCritDamage = CustomItemStack.getItemCritDamage(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getCritDamage();
				itemCritChance = CustomItemStack.getItemCritChance(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getCritChance();
				itemStealth = CustomItemStack.getItemStealth(itemInMainHand) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemInMainHand)).getStealth();
			} else {
				itemHealth = CustomItemStack.getItemHealth(itemInMainHand);
				itemDamage = CustomItemStack.getItemDamage(itemInMainHand);
				itemDefence = CustomItemStack.getItemDefence(itemInMainHand);
				itemStrength = CustomItemStack.getItemStrength(itemInMainHand);
				itemSpeed = CustomItemStack.getItemSpeed(itemInMainHand);
				itemMana = CustomItemStack.getItemMana(itemInMainHand);
				itemCritDamage = CustomItemStack.getItemCritDamage(itemInMainHand);
				itemCritChance = CustomItemStack.getItemCritChance(itemInMainHand);
				itemStealth = CustomItemStack.getItemStealth(itemInMainHand);
			}

		}

		double armorHealth = 0;
		double armorDamage = 0;
		double armorDefence = 0;
		double armorStrength = 0;
		double armorSpeed = 0;
		double armorMana = 0;
		double armorCritDamage = 0;
		double armorCritChance = 0;
		double armorStealth = 0;

		for (int i = 36; 39 >= i; i++) {
			ItemStack itemOnPlayer = player.getInventory().getItem(i);
			if (itemOnPlayer != null && CustomItemStack.isItemCustomItem(itemOnPlayer)) {
				if (PlayerStats.getPlayerStats(player.getUniqueId()).getLevel() > CustomItemStack.getItemMinimalLevelForUsage(itemOnPlayer)) {
					if(CustomItemStack.isItemReforged(itemOnPlayer)) {
						armorHealth = CustomItemStack.getItemHealth(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getHealth();
						armorDamage = CustomItemStack.getItemDamage(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getDamage();
						armorDefence = CustomItemStack.getItemDefence(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getDefence();
						armorStrength = CustomItemStack.getItemStrength(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getStrength();
						armorSpeed = CustomItemStack.getItemSpeed(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getSpeed();
						armorMana = CustomItemStack.getItemMana(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getMana();
						armorCritDamage = CustomItemStack.getItemCritDamage(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getCritDamage();
						armorCritChance = CustomItemStack.getItemCritChance(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getCritChance();
						armorStealth = CustomItemStack.getItemStealth(itemOnPlayer) + getCustomReforgeByName(CustomItemStack.getItemReforge(itemOnPlayer)).getStealth();
					} else {
						armorHealth = CustomItemStack.getItemHealth(itemOnPlayer);
						armorDamage = CustomItemStack.getItemDamage(itemOnPlayer);
						armorDefence = CustomItemStack.getItemDefence(itemOnPlayer);
						armorStrength = CustomItemStack.getItemStrength(itemOnPlayer);
						armorSpeed = CustomItemStack.getItemSpeed(itemOnPlayer);
						armorMana = CustomItemStack.getItemMana(itemOnPlayer);
						armorCritDamage = CustomItemStack.getItemCritDamage(itemOnPlayer);
						armorCritChance = CustomItemStack.getItemCritChance(itemOnPlayer);
						armorStealth = CustomItemStack.getItemStealth(itemOnPlayer);
					}
				}
			}
		}


		final double BaseHealth = 100;
		final double BaseDamage = 50;
		final double BaseMana = 100;
		final double BaseDefence = 25;
		final double BaseStrength = 10;
		final double BaseSpeed = 100;
		final double BaseCritDamage = 0;
		final double BaseCritChance = 0;
		final double BaseStealth = 0;


		double levelPercentage = 0;
		for (int i = 0; i < PlayerLevels.getLevel(p.getPlayer()); i++) {
			levelPercentage++;
		}

		levelPercentage = levelPercentage * 0.01 + 1;



		if (p.getHealth() <= p.getCurrentHealth() - p.getBonusHealth()) {
			p.setHealth((BaseHealth + classHealth) * levelPercentage + itemHealth + armorHealth);
			p.setCurrentHealth((BaseHealth + classHealth) * levelPercentage + itemHealth + armorHealth +p.getBonusHealth());
		} else {
			p.setHealth((BaseHealth + classHealth) * levelPercentage + itemHealth + armorHealth);
		}
		if (p.getMana() <= p.getCurrentMana() - p.getBonusMana()) {
			p.setMana((BaseMana + classMana) * levelPercentage + itemMana + armorMana);
			p.setCurrentMana((BaseMana + classMana) * levelPercentage + itemMana + armorMana + p.getBonusMana());
		} else {
			p.setMana((BaseMana + classMana) * levelPercentage + itemMana + armorMana);
		}

		if(p.getStunDuration() > 0) {
			p.setStunDuration(p.getStunDuration() - 1);
			p.setDamage(0);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000, 255, true, false));
		} else if (p.getStunDuration() < 0) {
			p.setStunDuration(0);
			player.removePotionEffect(PotionEffectType.SLOW);
		} else {
			p.setDamage((BaseDamage + classDamage) * levelPercentage + itemDamage + armorDamage);
			player.removePotionEffect(PotionEffectType.SLOW);
		}

		if(p.getCurrentHealth() - p.getBonusHealth() > p.getHealth()) {
			p.setCurrentHealth(p.getHealth() + p.getBonusHealth());
		}

		if(p.getCurrentMana() - p.getBonusMana() > p.getMana()) {
			p.setCurrentMana(p.getMana() + p.getBonusMana());
		}


		p.setDefence((BaseDefence + classDefence) * levelPercentage + itemDefence + armorDefence);
		p.setSpeed(BaseSpeed + classSpeed + itemSpeed + armorSpeed);
		p.getPlayer().setWalkSpeed((float) (p.getSpeed() + itemSpeed + armorSpeed) / 500);
		p.setStrength(BaseStrength + classStrength + itemStrength + armorStrength);
		p.setCritDamage(BaseCritDamage + classCritDamage + itemCritDamage + armorCritDamage + (levelPercentage - 1));
		p.setCritChance(BaseCritChance + classCritChance + itemCritChance + armorCritChance + (levelPercentage - 1));
		p.setStealth(BaseStealth + classStealth + itemStealth + armorStealth);

		double healthPercent = p.getCurrentHealth() / p.getHealth();
		int amountOfHealth = (int) (healthPercent/0.05);
		if(amountOfHealth > 20) {
			player.setHealth(20);
		} else if (amountOfHealth < 0) {
			player.setHealth(0);
		} else {
			player.setHealth(amountOfHealth);
		}




		if(p.getBonusHealth() != 0) {
			if(0 < p.getManaSpent() || 0 < p.getManaTimer()) {
				double OldManaCost = p.getManaSpent();
				player.spigot().sendMessage(
						ChatMessageType.ACTION_BAR,
						new TextComponent(ChatColor.GOLD + "❤ " + (int) p.getCurrentHealth() + ChatColor.GOLD + "/" + ChatColor.GOLD + (int) p.getHealth() + "   " + ChatColor.GREEN + "🛡 " + (int) p.getDefence() + "   " + ChatColor.DARK_AQUA + "-" + (int) OldManaCost + " " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + (int) p.getCurrentMana() + ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
				if (0 < p.getManaTimer())
					p.setManaTimer(p.getManaTimer() - 1);
				if (0 >= p.getManaTimer())
					p.setManaSpent(0);
			} else if(0 > p.getManaTimer()) {
				player.spigot().sendMessage(
						ChatMessageType.ACTION_BAR,
						new TextComponent(ChatColor.GOLD + "❤ " + (int) p.getCurrentHealth() + ChatColor.GOLD + "/" + ChatColor.GOLD + (int) p.getHealth() + "   " + ChatColor.RED + "NOT ENOUGH MANA  " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + (int) p.getCurrentMana() + ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
				if(0 > p.getManaTimer()) {
					p.setManaTimer(p.getManaTimer() + 1);
				}
			} else {
				player.spigot().sendMessage(
						ChatMessageType.ACTION_BAR,
						new TextComponent(ChatColor.GOLD + "❤ " + (int) p.getCurrentHealth() + ChatColor.GOLD + "/" + ChatColor.GOLD + (int) p.getHealth() + "   " + ChatColor.GREEN + "🛡 " + (int) p.getDefence() + "   " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + (int) p.getCurrentMana() + ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
			}
		} else {
			if(0 > p.getManaTimer()) {
			player.spigot().sendMessage(
					ChatMessageType.ACTION_BAR,
					new TextComponent(ChatColor.RED + "❤ " + (int) p.getCurrentHealth() + ChatColor.GRAY + "/" + ChatColor.RED + (int) p.getHealth() + "  " + ChatColor.RED + "NOT ENOUGH MANA  " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + (int) p.getCurrentMana() + ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
				if(0 > p.getManaTimer()) {
					p.setManaTimer(p.getManaTimer() + 1);
				}
			} else if (0 < p.getManaSpent() || 0 < p.getManaTimer()) {
				double OldManaCost = p.getManaSpent();

//                        CurrentMana.setScore(CurrentHealth.getScore() - OldManaCost);
				player.spigot().sendMessage(
						ChatMessageType.ACTION_BAR,
						new TextComponent(ChatColor.RED + "❤ " + (int) p.getCurrentHealth() + ChatColor.GRAY + "/" + ChatColor.RED + (int) p.getHealth() + "   " + ChatColor.GREEN + "🛡 " + (int) p.getDefence() + "   " + ChatColor.DARK_AQUA + "-" + (int) OldManaCost + " " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + (int) p.getCurrentMana() + ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
				if (0 < p.getManaTimer())
					p.setManaTimer(p.getManaTimer() - 1);
				if (0 >= p.getManaTimer())
					p.setManaSpent(0);
			} else {
				player.spigot().sendMessage(
						ChatMessageType.ACTION_BAR,
						new TextComponent(ChatColor.RED + "❤ " + (int) p.getCurrentHealth() + ChatColor.GRAY + "/" + ChatColor.RED + (int) p.getHealth() + "   " + ChatColor.GREEN + "🛡 " + (int) p.getDefence() + "   " + ChatColor.DARK_AQUA + "✎ " + ChatColor.AQUA + (int) p.getCurrentMana() + ChatColor.GRAY + "/" + ChatColor.AQUA + (int) p.getMana()));
			}
		}
	}
	public static String[] getPlayerClassStats(PlayerStats p) {
		String[] classStats = new String[9];
		String className = p.getPlayerClass().replace("\"", "");
		switch (className) {
			case "Battle Mage":
				classStats[0] = "-15";
				classStats[1] = "-10";
				classStats[2] = "10";
				classStats[3] = "0";
				classStats[4] = "0";
				classStats[5] = "25";
				classStats[6] = "20";
				classStats[7] = "0";
				classStats[8] = "0";
				break;
			case "Wizard":
				classStats[0] = "5";
				classStats[1] = "-10";
				classStats[2] = "10";
				classStats[3] = "0";
				classStats[4] = "0";
				classStats[5] = "50";
				classStats[6] = "20";
				classStats[7] = "0";
				classStats[8] = "0";
				break;
			case "Healer":
				classStats[0] = "10";
				classStats[1] = "-10";
				classStats[2] = "-15";
				classStats[3] = "0";
				classStats[4] = "0";
				classStats[5] = "50";
				classStats[6] = "-30";
				classStats[7] = "-10";
				classStats[8] = "0";
				break;
			case "Necromancer":
				classStats[0] = "10";
				classStats[1] = "0";
				classStats[2] = "15";
				classStats[3] = "0";
				classStats[4] = "0";
				classStats[5] = "60";
				classStats[6] = "5";
				classStats[7] = "10";
				classStats[8] = "0";
				break;
			case "Barbarian":
				classStats[0] = "15";
				classStats[1] = "20";
				classStats[2] = "15";
				classStats[3] = "0";
				classStats[4] = "10";
				classStats[5] = "0";
				classStats[6] = "25";
				classStats[7] = "10";
				classStats[8] = "0";
				break;
			case "Samurai":
				classStats[0] = "10";
				classStats[1] = "5";
				classStats[2] = "15";
				classStats[3] = "0";
				classStats[4] = "15";
				classStats[5] = "0";
				classStats[6] = "15";
				classStats[7] = "15";
				classStats[8] = "0";
				break;
			case "Paladin":
				classStats[0] = "15";
				classStats[1] = "10";
				classStats[2] = "20";
				classStats[3] = "0";
				classStats[4] = "0";
				classStats[5] = "0";
				classStats[6] = "15";
				classStats[7] = "10";
				classStats[8] = "0";
				break;
			case "Viking":
				classStats[0] = "10";
				classStats[1] = "15";
				classStats[2] = "5";
				classStats[3] = "20";
				classStats[4] = "20";
				classStats[5] = "0";
				classStats[6] = "25";
				classStats[7] = "20";
				classStats[8] = "0";
				break;
			case "Sniper":
				classStats[0] = "-10";
				classStats[1] = "20";
				classStats[2] = "-5";
				classStats[3] = "0";
				classStats[4] = "15";
				classStats[5] = "0";
				classStats[6] = "5";
				classStats[7] = "25";
				classStats[8] = "10";
				break;
			case "Hunter":
				classStats[0] = "15";
				classStats[1] = "15";
				classStats[2] = "-10";
				classStats[3] = "0";
				classStats[4] = "15";
				classStats[5] = "0";
				classStats[6] = "10";
				classStats[7] = "20";
				classStats[8] = "15";
				break;
			case "Scout":
				classStats[0] = "5";
				classStats[1] = "5";
				classStats[2] = "-15";
				classStats[3] = "0";
				classStats[4] = "30";
				classStats[5] = "0";
				classStats[6] = "5";
				classStats[7] = "10";
				classStats[8] = "5";
				break;
			case "Assassin":
				classStats[0] = "10";
				classStats[1] = "20";
				classStats[2] = "-15";
				classStats[3] = "5";
				classStats[4] = "40";
				classStats[5] = "0";
				classStats[6] = "30";
				classStats[7] = "15";
				classStats[8] = "25";
				break;
			default:
				classStats[0] = "0";
				classStats[1] = "0";
				classStats[2] = "0";
				classStats[3] = "0";
				classStats[4] = "0";
				classStats[5] = "0";
				classStats[6] = "0";
				classStats[7] = "0";
				classStats[8] = "0";
				break;
		}
		return classStats;
	}

	public static String[] getPlayerWeaponStats(Player player) {
		String[] itemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};


		if (null == player.getInventory().getItemInMainHand().getItemMeta()) {
			return itemStats;
		}


		if(!CustomItemStack.isItemCustomItem(player.getInventory().getItemInMainHand())){
			return itemStats;
		}
		if(CustomItemStack.isItemCustomReforge(player.getInventory().getItemInMainHand())){
			return itemStats;
		}

		if (PlayerLevels.getLevel(PlayerStats.getPlayerStats(player.getUniqueId()).getPlayer()) < CustomItemStack.getItemMinimalLevelForUsage(player.getInventory().getItemInMainHand())) {
			return itemStats;
		}

		ItemStack itemInUse = player.getInventory().getItemInMainHand();
		if ("Melee".equals(CustomItemStack.getItemType(itemInUse)) || "Bow".equals(CustomItemStack.getItemType(itemInUse)) || "Staff".equals(CustomItemStack.getItemType(itemInUse))) {
			itemStats[0] = String.valueOf(CustomItemStack.getItemHealth(itemInUse));
			itemStats[1] = String.valueOf(CustomItemStack.getItemDamage(itemInUse));
			itemStats[2] = String.valueOf(CustomItemStack.getItemDefence(itemInUse));
			itemStats[3] = String.valueOf(CustomItemStack.getItemStrength(itemInUse));
			itemStats[4] = String.valueOf(CustomItemStack.getItemSpeed(itemInUse));
			itemStats[5] = String.valueOf(CustomItemStack.getItemMana(itemInUse));
			itemStats[6] = String.valueOf(CustomItemStack.getItemCritDamage(itemInUse));
			itemStats[7] = String.valueOf(CustomItemStack.getItemCritChance(itemInUse));
			itemStats[8] = String.valueOf(CustomItemStack.getItemStealth(itemInUse));
			return itemStats;
		} else {
			return itemStats;
		}
	}

	public static String[] getPlayerCombinedReforgeStats(Player player) {
		String[] itemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};
		if (player.getInventory().getItemInMainHand().hasItemMeta()) {
			String itemName = ChatColor.stripColor(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName());
			if (itemName.contains("Menu")) {
				return itemStats;
			}
			Item item = getCustomItemByName(ChatColor.stripColor(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName()));
			if (null != item && ("Weapon".equals(item.getType()) || "Melee".equals(item.getType()) || "Ranged".equals(item.getType()))) {
				if (PlayerLevels.getLevel(PlayerStats.getPlayerStats(player.getUniqueId()).getPlayer()) > getCustomItemByName(ChatColor.stripColor(PlayerStats.getPlayerStats(player.getUniqueId()).getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName())).getMinimalLevelForUsage()) {
					String reforgeName = itemName.replace(item.getName(), "");
					Reforge reforge = getCustomReforgeByName(reforgeName.replace(" ", ""));
					if (null != reforge) {
						itemStats[0] = String.valueOf(Double.parseDouble(itemStats[0]) + reforge.getHealth());
						itemStats[1] = String.valueOf(Double.parseDouble(itemStats[1]) + reforge.getDamage());
						itemStats[2] = String.valueOf(Double.parseDouble(itemStats[2]) + reforge.getDefence());
						itemStats[3] = String.valueOf(Double.parseDouble(itemStats[3]) + reforge.getStrength());
						itemStats[4] = String.valueOf(Double.parseDouble(itemStats[4]) + reforge.getSpeed());
						itemStats[5] = String.valueOf(Double.parseDouble(itemStats[5]) + reforge.getMana());
						itemStats[6] = String.valueOf(Double.parseDouble(itemStats[6]) + reforge.getCritDamage());
						itemStats[7] = String.valueOf(Double.parseDouble(itemStats[7]) + reforge.getCritChance());
						itemStats[8] = String.valueOf(Double.parseDouble(itemStats[8]) + reforge.getStealth());
					}
				}
			}
		}


		for (int i = 36; 39 >= i; i++) {
			if (null != player.getInventory().getItem(i) && null != player.getInventory().getItem(i).getItemMeta() && null != player.getInventory().getItem(i).getItemMeta().getDisplayName()) {
				Item item = getCustomItemByName(ChatColor.stripColor(player.getInventory().getItem(i).getItemMeta().getDisplayName()));
				if(item != null) {
					if (PlayerLevels.getLevel(PlayerStats.getPlayerStats(player.getUniqueId()).getPlayer()) > getCustomItemByName(ChatColor.stripColor(PlayerStats.getPlayerStats(player.getUniqueId()).getPlayer().getInventory().getItem(i).getItemMeta().getDisplayName())).getMinimalLevelForUsage()) {
						String reforgeName = ChatColor.stripColor(player.getInventory().getItem(i).getItemMeta().getDisplayName()).replace(item.getName(), "");
						Reforge reforge = getCustomReforgeByName(reforgeName.replace(" ", ""));
						if (null != item && null != reforge && "Armor".equals(item.getType())) {
							itemStats[0] = String.valueOf(Double.parseDouble(itemStats[0]) + reforge.getHealth());
							itemStats[1] = String.valueOf(Double.parseDouble(itemStats[1]) + reforge.getDamage());
							itemStats[2] = String.valueOf(Double.parseDouble(itemStats[2]) + reforge.getDefence());
							itemStats[3] = String.valueOf(Double.parseDouble(itemStats[3]) + reforge.getStrength());
							itemStats[4] = String.valueOf(Double.parseDouble(itemStats[4]) + reforge.getSpeed());
							itemStats[5] = String.valueOf(Double.parseDouble(itemStats[5]) + reforge.getMana());
							itemStats[6] = String.valueOf(Double.parseDouble(itemStats[6]) + reforge.getCritDamage());
							itemStats[7] = String.valueOf(Double.parseDouble(itemStats[7]) + reforge.getCritChance());
							itemStats[8] = String.valueOf(Double.parseDouble(itemStats[8]) + reforge.getStealth());
						}
					}
				}
			}
		}
		return itemStats;
	}

	public static String[] getPlayerCombinedArmorStats(Player player) {
		String[] itemStats = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};
		for (int i = 36; 39 >= i; i++) {
			if (null != player.getInventory().getItem(i) && null != player.getInventory().getItem(i).getItemMeta() && null != player.getInventory().getItem(i).getItemMeta().getDisplayName()) {

				Item item = getCustomItemByName(ChatColor.stripColor(player.getInventory().getItem(i).getItemMeta().getDisplayName()));
				if (null != item && "Armor".equals(item.getType())) {
					if (null != player.getInventory().getItem(i) || null != player.getInventory().getItem(i).getItemMeta()) {
						if (PlayerLevels.getLevel(PlayerStats.getPlayerStats(player.getUniqueId()).getPlayer()) > getCustomItemByName(ChatColor.stripColor(PlayerStats.getPlayerStats(player.getUniqueId()).getPlayer().getInventory().getItem(i).getItemMeta().getDisplayName())).getMinimalLevelForUsage()) {
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
				}
			}
		}
		return itemStats;
	}
}

