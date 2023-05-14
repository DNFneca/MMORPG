// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ClassMenus
{
    public static void ClassMenu(final Player p, String PlayerClass) {
        final ItemStack icon = new ItemStack(Material.IRON_SWORD, 1);
        final ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        final ItemStack back = new ItemStack(Material.ARROW, 1);
        final ItemStack health = new ItemStack(Material.PLAYER_HEAD, 1);
        final ItemStack damage = new ItemStack(Material.IRON_SWORD, 1);
        final ItemStack defence = new ItemStack(Material.SHIELD, 1);
        final ItemStack strength = new ItemStack(Material.IRON_AXE, 1);
        final ItemStack speed = new ItemStack(Material.POTION, 1);
        final ItemStack mana = new ItemStack(Material.POTION, 1);
        final ItemStack critdamage = new ItemStack(Material.POTION, 1);
        final ItemStack critchance = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        final ItemStack sneak = new ItemStack(Material.RABBIT_FOOT, 1);
        final ItemMeta data1 = blue_glass.getItemMeta();
        data1.setDisplayName("   ");
        blue_glass.setItemMeta(data1);
        final ItemMeta arrowmeta = back.getItemMeta();
        arrowmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
        back.setItemMeta(arrowmeta);
        final ItemMeta iconmeta = icon.getItemMeta();
        iconmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        final SkullMeta healthdata = (SkullMeta)health.getItemMeta();
        healthdata.setOwningPlayer((OfflinePlayer)p);
        healthdata.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        final ItemMeta damagemeta = damage.getItemMeta();
        damagemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        final ItemMeta defencemeta = defence.getItemMeta();
        defencemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        final ItemMeta strengthmeta = strength.getItemMeta();
        strengthmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        final PotionMeta speedmeta = (PotionMeta)speed.getItemMeta();
        speedmeta.setBasePotionData(new PotionData(PotionType.SPEED));
        speedmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        final PotionMeta manameta = (PotionMeta)mana.getItemMeta();
        manameta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        manameta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        final PotionMeta critdmeta = (PotionMeta)critdamage.getItemMeta();
        critdmeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        critdmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        final ItemMeta critcmeta = critchance.getItemMeta();
        critcmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        final ItemMeta sneakmeta = sneak.getItemMeta();
        critcmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "Class Specific Stats");
        final String replace;
        PlayerClass = (replace = PlayerClass.replace("\"", ""));
        switch (replace) {
            case "Battle Mage": {
                icon.setType(Material.MAGMA_CREAM);
                iconmeta.setDisplayName("Battle Mage");
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                manameta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.AQUA)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int i = 0; i < 27; ++i) {
                    if (i == 4) {
                        inv.setItem(i, icon);
                    }
                    else if (i == 11) {
                        inv.setItem(i, health);
                    }
                    else if (i == 12) {
                        inv.setItem(i, damage);
                    }
                    else if (i == 13) {
                        inv.setItem(i, defence);
                    }
                    else if (i == 14) {
                        inv.setItem(i, mana);
                    }
                    else if (i == 15) {
                        inv.setItem(i, critdamage);
                    }
                    else if (i == inv.getSize() - 9) {
                        inv.setItem(i, back);
                    }
                    else {
                        inv.setItem(i, blue_glass);
                    }
                }
                break;
            }
            case "Wizard": {
                icon.setType(Material.POTION);
                final PotionMeta iconmetaWizard = (PotionMeta)icon.getItemMeta();
                iconmetaWizard.setBasePotionData(new PotionData(PotionType.SPEED));
                iconmetaWizard.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                iconmetaWizard.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                manameta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.AQUA)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                icon.setItemMeta((ItemMeta)iconmetaWizard);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int j = 0; j < 27; ++j) {
                    if (j == 4) {
                        inv.setItem(j, icon);
                    }
                    else if (j == 11) {
                        inv.setItem(j, health);
                    }
                    else if (j == 15) {
                        inv.setItem(j, mana);
                    }
                    else if (j == inv.getSize() - 9) {
                        inv.setItem(j, back);
                    }
                    else {
                        inv.setItem(j, blue_glass);
                    }
                }
                break;
            }
            case "Healer": {
                icon.setType(Material.POTION);
                final PotionMeta iconmetaHealer = (PotionMeta)icon.getItemMeta();
                iconmetaHealer.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL));
                iconmetaHealer.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                iconmetaHealer.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                manameta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.AQUA)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                icon.setItemMeta((ItemMeta)iconmetaHealer);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 14) {
                        inv.setItem(k, mana);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 16) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Necromancer": {
                icon.setType(Material.TOTEM_OF_UNDYING);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                manameta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.AQUA)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 11) {
                        inv.setItem(k, health);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 13) {
                        inv.setItem(k, mana);
                    }
                    else if (k == 14) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Barbarian": {
                icon.setType(Material.NETHERITE_AXE);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 14) {
                        inv.setItem(k, speed);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 16) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Samurai": {
                icon.setType(Material.DIAMOND_SWORD);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 14) {
                        inv.setItem(k, speed);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 16) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Paladin": {
                icon.setType(Material.SHIELD);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 11) {
                        inv.setItem(k, health);
                    }
                    else if (k == 12) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 13) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 14) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Viking": {
                icon.setType(Material.IRON_AXE);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_RED)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                strengthmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 13) {
                        inv.setItem(k, strength);
                    }
                    else if (k == 14) {
                        inv.setItem(k, speed);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 16) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Sniper": {
                icon.setType(Material.CROSSBOW);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE)));
                sneakmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.DARK_GRAY)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 13) {
                        inv.setItem(k, speed);
                    }
                    else if (k == 14) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == 16) {
                        inv.setItem(k, sneak);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Hunter": {
                icon.setType(Material.BOW);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE)));
                sneakmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.DARK_GRAY)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 13) {
                        inv.setItem(k, speed);
                    }
                    else if (k == 14) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == 16) {
                        inv.setItem(k, sneak);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Scout": {
                icon.setType(Material.RABBIT_FOOT);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE)));
                sneakmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.DARK_GRAY)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 13) {
                        inv.setItem(k, speed);
                    }
                    else if (k == 14) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == 16) {
                        inv.setItem(k, sneak);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            case "Assassin": {
                icon.setType(Material.IRON_SWORD);
                iconmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
                healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN)));
                strengthmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED)));
                speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE)));
                sneakmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.DARK_GRAY)));
                icon.setItemMeta(iconmeta);
                health.setItemMeta((ItemMeta)healthdata);
                damage.setItemMeta(damagemeta);
                defence.setItemMeta(defencemeta);
                strength.setItemMeta(strengthmeta);
                speed.setItemMeta((ItemMeta)speedmeta);
                mana.setItemMeta((ItemMeta)manameta);
                critdamage.setItemMeta((ItemMeta)critdmeta);
                critchance.setItemMeta(critcmeta);
                sneak.setItemMeta(sneakmeta);
                for (int k = 0; k < 27; ++k) {
                    if (k == 4) {
                        inv.setItem(k, icon);
                    }
                    else if (k == 10) {
                        inv.setItem(k, health);
                    }
                    else if (k == 11) {
                        inv.setItem(k, damage);
                    }
                    else if (k == 12) {
                        inv.setItem(k, defence);
                    }
                    else if (k == 13) {
                        inv.setItem(k, strength);
                    }
                    else if (k == 14) {
                        inv.setItem(k, speed);
                    }
                    else if (k == 15) {
                        inv.setItem(k, critdamage);
                    }
                    else if (k == 16) {
                        inv.setItem(k, critchance);
                    }
                    else if (k == 22) {
                        inv.setItem(k, sneak);
                    }
                    else if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
            default: {
                for (int k = 0; k < 27; ++k) {
                    if (k == inv.getSize() - 9) {
                        inv.setItem(k, back);
                    }
                    else {
                        inv.setItem(k, blue_glass);
                    }
                }
                break;
            }
        }
        p.openInventory(inv);
    }
}
