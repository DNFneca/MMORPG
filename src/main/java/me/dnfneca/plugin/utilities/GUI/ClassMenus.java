package me.dnfneca.plugin.utilities.GUI;

import me.dnfneca.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Objective;

public class ClassMenus {
    public static void ClassMenu(Player p, int PlayerClass) {
//        Objective obj = p.getScoreboard().getObjective("Stats");
        NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");
        PersistentDataContainer playerdata = p.getPersistentDataContainer();

        playerdata.set(key, PersistentDataType.INTEGER, PlayerClass);
        Objective obj = p.getScoreboard().getObjective("Stats");

        ItemStack icon = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemStack health = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemStack damage = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack defence = new ItemStack(Material.SHIELD, 1);
        ItemStack strength = new ItemStack(Material.IRON_AXE, 1);
        ItemStack speed = new ItemStack(Material.IRON_AXE, 1);
        ItemStack mana = new ItemStack(Material.POTION, 1);
        ItemStack critdamage = new ItemStack(Material.POTION, 1);
        ItemStack critchance = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemStack sneak = new ItemStack(Material.RABBIT_FOOT, 1);


        ItemMeta arrowmeta = arrow.getItemMeta();
        arrowmeta.setDisplayName(ChatColor.GRAY + "Back to Main Menu");
        arrow.setItemMeta(arrowmeta);

        ItemMeta iconmeta = icon.getItemMeta();
        iconmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta healthdata = health.getItemMeta();
        healthdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);


        ItemMeta damagemeta = damage.getItemMeta();

        damagemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta defencemeta = defence.getItemMeta();
        defencemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta strengthmeta = strength.getItemMeta();
        strengthmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta speedmeta = speed.getItemMeta();
        speedmeta.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "" + obj.getScore("EffectiveHealth").getScore());

        PotionMeta manameta = (PotionMeta) mana.getItemMeta();
        manameta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        manameta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        PotionMeta critdmeta = (PotionMeta) critdamage.getItemMeta();
        critdmeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        critdmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        ItemMeta critcmeta = critchance.getItemMeta();
        critcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        ItemMeta sneakmeta = sneak.getItemMeta();

        Inventory inv = Bukkit.createInventory(null, 27, "Class Specific Stats");


        switch (PlayerClass) {
            case 1:
                icon.setType(Material.MAGMA_CREAM);
                iconmeta.setDisplayName("Battle Mage");
                healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "-15%");
                damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+5%");
                defencemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + "-10%");
                manameta.setDisplayName(ChatColor.GRAY + "Mana: " + ChatColor.AQUA + "+25%");
                critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "+5%");
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
                    } else if (i == 18) {
                        inv.setItem(i, arrow);
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
