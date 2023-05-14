package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class ClassMenus {
    public static void ClassMenu(Player p, String PlayerClass) {
//        Objective obj = p.getScoreboard().getObjective("Stats");

        ItemStack icon = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemStack back = new ItemStack(Material.ARROW, 1);
        ItemStack health = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemStack damage = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack defence = new ItemStack(Material.SHIELD, 1);
        ItemStack strength = new ItemStack(Material.IRON_AXE, 1);
        ItemStack speed = new ItemStack(Material.POTION, 1);
        ItemStack mana = new ItemStack(Material.POTION, 1);
        ItemStack critdamage = new ItemStack(Material.POTION, 1);
        ItemStack critchance = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemStack sneak = new ItemStack(Material.RABBIT_FOOT, 1);

        ItemMeta data1 = blue_glass.getItemMeta();
        data1.setDisplayName("   ");
        blue_glass.setItemMeta(data1);

        ItemMeta arrowmeta = back.getItemMeta();
        arrowmeta.setDisplayName(ChatColor.GRAY + "Back to Main Menu");
        back.setItemMeta(arrowmeta);

        ItemMeta iconmeta = icon.getItemMeta();
        iconmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        SkullMeta healthdata = (SkullMeta) health.getItemMeta();
        healthdata.setOwningPlayer(p);
        healthdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);



        ItemMeta damagemeta = damage.getItemMeta();

        damagemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta defencemeta = defence.getItemMeta();
        defencemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta strengthmeta = strength.getItemMeta();
        strengthmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        PotionMeta speedmeta = (PotionMeta) speed.getItemMeta();
        speedmeta.setBasePotionData(new PotionData(PotionType.SPEED));
        speedmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        PotionMeta manameta = (PotionMeta) mana.getItemMeta();
        manameta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        manameta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        PotionMeta critdmeta = (PotionMeta) critdamage.getItemMeta();
        critdmeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        critdmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        ItemMeta critcmeta = critchance.getItemMeta();
        critcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta sneakmeta = sneak.getItemMeta();
        critcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Inventory inv = Bukkit.createInventory(null, 27, "Class Specific Stats");

        PlayerClass = PlayerClass.replace("\"", "");
        switch (PlayerClass) {
            case "Battle Mage":
                icon.setType(Material.MAGMA_CREAM);
                iconmeta.setDisplayName("Battle Mage");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "-15%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+10%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "-10%");
                manameta.setDisplayName(ChatColor.GRAY + "Mana: " + ChatColor.AQUA + "+25%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+20%");
                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);

                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 11) {
                        inv.setItem(i, health);
                    } else if (i == 12) {
                        inv.setItem(i, damage);
                    } else if (i == 13) {
                        inv.setItem(i, defence);
                    } else if (i == 14) {
                        inv.setItem(i, mana);
                    } else if (i == 15) {
                        inv.setItem(i, critdamage);
                    } else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            case "Wizard":
                icon.setType(Material.POTION);
                PotionMeta iconmetaWizard = (PotionMeta) icon.getItemMeta();

                iconmetaWizard.setBasePotionData(new PotionData(PotionType.SPEED));
                iconmetaWizard.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
                iconmetaWizard.setDisplayName(ChatColor.GOLD + "Wizard");

                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+5%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+10%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "-10%");
                manameta.setDisplayName(ChatColor.GRAY + "Mana: " + ChatColor.AQUA + "+50%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+20%");



                icon.setItemMeta(iconmetaWizard);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 11) {
                        inv.setItem(i, health);
                    } else if (i == 15) {
                        inv.setItem(i, mana);
                    }  else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            case "Healer":
                icon.setType(Material.POTION);
                PotionMeta iconmetaHealer = (PotionMeta) icon.getItemMeta();

                iconmetaHealer.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL));
                iconmetaHealer.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
                iconmetaHealer.setDisplayName(ChatColor.RED + "Healer");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+10%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "-15%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "-10%");
                manameta.setDisplayName(ChatColor.GRAY + "Mana: " + ChatColor.AQUA + "+50%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "-30%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "-10%");



                icon.setItemMeta(iconmetaHealer);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 10) {
                        inv.setItem(i, health);
                    } else if (i == 11) {
                        inv.setItem(i, damage);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 14) {
                        inv.setItem(i, mana);
                    } else if (i == 15) {
                        inv.setItem(i, critdamage);
                    } else if (i == 16) {
                        inv.setItem(i, critchance);
                    }  else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            case "Necromancer":
                icon.setType(Material.TOTEM_OF_UNDYING);

                iconmeta.setDisplayName(ChatColor.RED + "Necromancer");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+10%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+15%");
                manameta.setDisplayName(ChatColor.GRAY + "Mana: " + ChatColor.AQUA + "+60%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+5%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+10%");

                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 11) {
                        inv.setItem(i, health);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 13) {
                        inv.setItem(i, mana);
                    } else if (i == 14) {
                        inv.setItem(i, critdamage);
                    } else if (i == 15) {
                        inv.setItem(i, critchance);
                    }  else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            case "Barbarian":
                icon.setType(Material.NETHERITE_AXE);

                iconmeta.setDisplayName(ChatColor.RED + "Barbarian");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+15%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+20%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+15%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+25%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+10%");
                speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "+10%");

                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 10) {
                        inv.setItem(i, health);
                    } else if (i == 11) {
                        inv.setItem(i, damage);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 14) {
                        inv.setItem(i, speed);
                    } else if (i == 15) {
                        inv.setItem(i, critdamage);
                    } else if (i == 16) {
                        inv.setItem(i, critchance);
                    }  else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            case "Samurai":
            icon.setType(Material.DIAMOND_SWORD);

            iconmeta.setDisplayName(ChatColor.GREEN + "Samurai");
            healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+10%");
            damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+5%");
            defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+15%");
            critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+15%");
            critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+15%");
            speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "+15%");

            icon.setItemMeta(iconmeta);
            health.setItemMeta(healthdata);
            damage.setItemMeta(damagemeta);
            defence.setItemMeta(defencemeta);
            strength.setItemMeta(strengthmeta);
            speed.setItemMeta(speedmeta);
            mana.setItemMeta(manameta);
            critdamage.setItemMeta(critdmeta);
            critchance.setItemMeta(critcmeta);
            sneak.setItemMeta(sneakmeta);


            for (int i = 0; i < 27; i++) {
                if (i == 4) {
                    inv.setItem(i, icon);
                } else if (i == 10) {
                    inv.setItem(i, health);
                } else if (i == 11) {
                    inv.setItem(i, damage);
                } else if (i == 12) {
                    inv.setItem(i, defence);
                } else if (i == 14) {
                    inv.setItem(i, speed);
                } else if (i == 15) {
                    inv.setItem(i, critdamage);
                } else if (i == 16) {
                    inv.setItem(i, critchance);
                }  else if (i == inv.getSize()-9) {
                    inv.setItem(i, back);
                } else {
                    inv.setItem(i, blue_glass);
                }
            }
            break;
            case "Paladin":
                icon.setType(Material.SHIELD);

                iconmeta.setDisplayName(ChatColor.GOLD + "Paladin");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+15%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+10%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+20%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+15%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+10%");

                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 11) {
                        inv.setItem(i, health);
                    } else if (i == 12) {
                        inv.setItem(i, damage);
                    } else if (i == 13) {
                        inv.setItem(i, defence);
                    } else if (i == 14) {
                        inv.setItem(i, critdamage);
                    } else if (i == 15) {
                        inv.setItem(i, critchance);
                    }  else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            case "Viking":
                icon.setType(Material.IRON_AXE);

                iconmeta.setDisplayName(ChatColor.DARK_RED + "Viking");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+10%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+15%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+5%");
                strengthmeta.setDisplayName(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+20%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+5%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+20%");
                speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "+20%");

                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 10) {
                        inv.setItem(i, health);
                    } else if (i == 11) {
                        inv.setItem(i, damage);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 13) {
                        inv.setItem(i, strength);
                    } else if (i == 14) {
                        inv.setItem(i, speed);
                    } else if (i == 15) {
                        inv.setItem(i, critdamage);
                    } else if (i == 16) {
                        inv.setItem(i, critchance);
                    }  else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            case "Sniper":
                icon.setType(Material.CROSSBOW);

                iconmeta.setDisplayName(ChatColor.DARK_GRAY + "Sniper");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "-10%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+20%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "-5%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+5%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+25%");
                speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "+15%");
                sneakmeta.setDisplayName(ChatColor.GRAY + "Stealth: " + ChatColor.DARK_GRAY + "+10%");


                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 10) {
                        inv.setItem(i, health);
                    } else if (i == 11) {
                        inv.setItem(i, damage);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 13) {
                        inv.setItem(i, speed);
                    } else if (i == 14) {
                        inv.setItem(i, critdamage);
                    } else if (i == 15) {
                        inv.setItem(i, critchance);
                    } else if (i == 16) {
                        inv.setItem(i, sneak);
                    } else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;

            case "Hunter":
                icon.setType(Material.BOW);

                iconmeta.setDisplayName(ChatColor.RED + "Hunter");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+15%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+15%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "-10%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+10%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+20%");
                speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "+15%");
                sneakmeta.setDisplayName(ChatColor.GRAY + "Stealth: " + ChatColor.DARK_GRAY + "+15%");


                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 10) {
                        inv.setItem(i, health);
                    } else if (i == 11) {
                        inv.setItem(i, damage);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 13) {
                        inv.setItem(i, speed);
                    } else if (i == 14) {
                        inv.setItem(i, critdamage);
                    } else if (i == 15) {
                        inv.setItem(i, critchance);
                    } else if (i == 16) {
                        inv.setItem(i, sneak);
                    } else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;

            case "Scout":
                icon.setType(Material.RABBIT_FOOT);

                iconmeta.setDisplayName(ChatColor.GREEN + "Scout");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+5%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+5%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "-15%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+5%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+10%");
                speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "+30%");
                sneakmeta.setDisplayName(ChatColor.GRAY + "Stealth: " + ChatColor.DARK_GRAY + "+5%");

                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 10) {
                        inv.setItem(i, health);
                    } else if (i == 11) {
                        inv.setItem(i, damage);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 13) {
                        inv.setItem(i, speed);
                    } else if (i == 14) {
                        inv.setItem(i, critdamage);
                    } else if (i == 15) {
                        inv.setItem(i, critchance);
                    } else if (i == 16) {
                        inv.setItem(i, sneak);
                    } else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;


            case "Assassin":
                icon.setType(Material.IRON_SWORD);

                iconmeta.setDisplayName(ChatColor.GREEN + "Assassin");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "+10%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+20%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "-15%");
                strengthmeta.setDisplayName(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+5%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+30%");
                critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "+15%");
                speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "+40%");
                sneakmeta.setDisplayName(ChatColor.GRAY + "Stealth: " + ChatColor.DARK_GRAY + "+25%");

                icon.setItemMeta(iconmeta);
                health.setItemMeta(healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta(speedmeta);
                mana.setItemMeta(manameta);
                critdamage.setItemMeta(critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);


                for (int i = 0; i < 27; i++) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    } else if (i == 10) {
                        inv.setItem(i, health);
                    } else if (i == 11) {
                        inv.setItem(i, damage);
                    } else if (i == 12) {
                        inv.setItem(i, defence);
                    } else if (i == 13) {
                        inv.setItem(i, strength);
                    } else if (i == 14) {
                        inv.setItem(i, speed);
                    } else if (i == 15) {
                        inv.setItem(i, critdamage);
                    } else if (i == 16) {
                        inv.setItem(i, critchance);
                    } else if (i == 22) {
                        inv.setItem(i, sneak);
                    } else if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;




            default:
                for (int i = 0; i < 27; i++) {
                    if (i == inv.getSize()-9) {
                        inv.setItem(i, back);
                    } else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
        }




//            for (int i = 0; i < 27; i++) {
//                if (i == 4) {
//                    inv.setItem(i, icon);
//                } else if (i == 11) {
//                    inv.setItem(i, wizard);
//                } else if (i == 12) {
//                    inv.setItem(i, healer);
//                } else if (i == 13) {
//                    inv.setItem(i, necromancer);
//                } else if (i == 15) {
//                    inv.setItem(i, necromancer);
//                } else if (i == 16) {
//                    inv.setItem(i, necromancer);
//                } else {
//                    inv.setItem(i, blue_glass);
//                }
//            }
//        }

        p.openInventory(inv);

    }
}
