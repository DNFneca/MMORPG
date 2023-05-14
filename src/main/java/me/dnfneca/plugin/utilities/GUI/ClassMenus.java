// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.GUI;

<<<<<<< Updated upstream
=======
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
>>>>>>> Stashed changes
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
<<<<<<< Updated upstream
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
=======
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
=======
        critdmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        ItemMeta critcmeta = critchance.getItemMeta();
        critcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta sneakmeta = sneak.getItemMeta();
        critcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        Inventory inv = Bukkit.createInventory(null, 27, "Class Specific Stats");

        PlayerClass = PlayerClass.replace("\"", "");
        switch (PlayerClass) {
            case "Battle Mage":
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
=======
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            }
            case "Viking": {
=======
            case "Viking":
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            }
            case "Sniper": {
=======
            case "Sniper":
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            }
            case "Hunter": {
=======

            case "Hunter":
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            }
            case "Scout": {
=======

            case "Scout":
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            }
            case "Assassin": {
=======


            case "Assassin":
>>>>>>> Stashed changes
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
