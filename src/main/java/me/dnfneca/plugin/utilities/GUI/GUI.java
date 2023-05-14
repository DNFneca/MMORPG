// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.GUI;

import java.util.Iterator;
import me.dnfneca.plugin.Plugin;
<<<<<<< Updated upstream
import org.bukkit.scheduler.BukkitRunnable;
import me.dnfneca.plugin.listeners.PlayerJoin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.inventory.meta.PotionMeta;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.inventory.Inventory;
=======
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.List;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.ArrayList;
import org.bukkit.entity.Player;

<<<<<<< Updated upstream
public class GUI
{
    public static void MainMenu(final Player p) {
        final List<String> lore = new ArrayList<String>();
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "Main Menu");
        final ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        final ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        final ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);
        final ItemStack classes = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        final ItemStack levels = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        final SkullMeta headdata = (SkullMeta)player_head.getItemMeta();
        headdata.setOwningPlayer((OfflinePlayer)p);
        headdata.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        headdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
        player_head.setItemMeta((ItemMeta)headdata);
        final ItemMeta levelsData = levels.getItemMeta();
        levelsData.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.BLUE)));
=======
import static me.dnfneca.plugin.listeners.PlayerJoin.Players;

public class GUI {

    public static void MainMenu(Player p) {
        List<String> lore = new ArrayList<>();


        Inventory inv = Bukkit.createInventory(null, 54, "Main Menu");

        ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemStack classes = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemStack levels = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);

        SkullMeta headdata = (SkullMeta) player_head.getItemMeta();
        headdata.setOwningPlayer(p);
        headdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        headdata.setDisplayName(ChatColor.RED + "Stats");
        player_head.setItemMeta(headdata);

        ItemMeta levelsData = levels.getItemMeta();
        levelsData.setDisplayName(ChatColor.BLUE + "Levels");
>>>>>>> Stashed changes
        levels.setItemMeta(levelsData);
        final LeatherArmorMeta classesdata = (LeatherArmorMeta)classes.getItemMeta();
        classesdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
        classesdata.setColor(Color.PURPLE);
        classesdata.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DYE });
        classes.setItemMeta((ItemMeta)classesdata);
        final ItemMeta data1 = purple_glass.getItemMeta();
        data1.setDisplayName("   ");
        purple_glass.setItemMeta(data1);
        final ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);
        for (int i = 0; i <= 53; ++i) {
            if (i <= 8 || i == 11 || i == 15 || i == 20 || i == 24 || i == 36 || i == 40 || i == 44 || i == 45 || i == 49 || i == 53) {
                inv.setItem(i, purple_glass);
            }
            else if (i == 22) {
                inv.setItem(i, player_head);
            }
            else if (i == 38) {
                inv.setItem(i, classes);
            }
            else if (i == 42) {
                inv.setItem(i, levels);
            }
            else {
                inv.setItem(i, blue_glass);
            }
        }
        p.openInventory(inv);
    }
<<<<<<< Updated upstream
    
    public static void StatsMenu(final Player player) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "Stats");
        final ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        final ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        final ItemStack arrow = new ItemStack(Material.ARROW, 1);
        final ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);
        final ItemStack damage = new ItemStack(Material.IRON_SWORD, 1);
        final ItemStack defence = new ItemStack(Material.SHIELD, 1);
        final ItemStack strength = new ItemStack(Material.IRON_AXE, 1);
        final ItemStack speed = new ItemStack(Material.POTION, 1);
        final ItemStack mana = new ItemStack(Material.POTION, 1);
        final ItemStack critdamage = new ItemStack(Material.POTION, 1);
        final ItemStack critchance = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        final ItemStack stealth = new ItemStack(Material.RABBIT_FOOT, 1);
        final PlayerStats p = PlayerStats.getPlayerStats(player.getUniqueId());
        final SkullMeta healthdata = (SkullMeta)player_head.getItemMeta();
        healthdata.setOwningPlayer((OfflinePlayer)player);
        healthdata.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        healthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), p.getHealth()));
        player_head.setItemMeta((ItemMeta)healthdata);
        final ItemMeta arrowmeta = arrow.getItemMeta();
        arrowmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
        arrow.setItemMeta(arrowmeta);
        final ItemMeta damagemeta = damage.getItemMeta();
        damagemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        damagemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), p.getDamage()));
        damage.setItemMeta(damagemeta);
        final ItemMeta defencemeta = defence.getItemMeta();
        defencemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        defencemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), p.getDefence()));
        defence.setItemMeta(defencemeta);
        final ItemMeta strengthmeta = strength.getItemMeta();
        strengthmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        strengthmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), p.getStrength()));
=======
    public static void StatsMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Stats");


        ItemStack purple_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemStack player_head = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemStack damage = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack defence = new ItemStack(Material.SHIELD, 1);
        ItemStack strength = new ItemStack(Material.IRON_AXE, 1);
        ItemStack speed = new ItemStack(Material.POTION, 1);
        ItemStack mana = new ItemStack(Material.POTION, 1);
        ItemStack critdamage = new ItemStack(Material.POTION, 1);
        ItemStack critchance = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemStack stealth = new ItemStack(Material.RABBIT_FOOT, 1);


        PlayerStats p = PlayerStats.getPlayerStats(player.getUniqueId());

        SkullMeta healthdata = (SkullMeta) player_head.getItemMeta();
        healthdata.setOwningPlayer(player);
        healthdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        healthdata.setDisplayName(ChatColor.GRAY + "Health: " + ChatColor.RED + "" + p.getHealth());
        player_head.setItemMeta(healthdata);


        ItemMeta arrowmeta = arrow.getItemMeta();
        arrowmeta.setDisplayName(ChatColor.GRAY + "Back to Main Menu");
        arrow.setItemMeta(arrowmeta);


        ItemMeta damagemeta = damage.getItemMeta();
        damagemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        damagemeta.setDisplayName(ChatColor.GRAY + "Damage: " + ChatColor.RED + "" + p.getDamage());
        damage.setItemMeta(damagemeta);

        ItemMeta defencemeta = defence.getItemMeta();
        defencemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        defencemeta.setDisplayName(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "" + p.getDefence());
        defence.setItemMeta(defencemeta);

        ItemMeta strengthmeta = strength.getItemMeta();
        strengthmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        strengthmeta.setDisplayName(ChatColor.GRAY + "Strength: " + ChatColor.RED + "" + p.getStrength());
>>>>>>> Stashed changes
        strength.setItemMeta(strengthmeta);
        final PotionMeta speedmeta = (PotionMeta)speed.getItemMeta();
        speedmeta.setBasePotionData(new PotionData(PotionType.SPEED));
<<<<<<< Updated upstream
        speedmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        speedmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.WHITE), p.getSpeed()));
        speed.setItemMeta((ItemMeta)speedmeta);
        final PotionMeta manameta = (PotionMeta)mana.getItemMeta();
        manameta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        manameta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        manameta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.AQUA), p.getMana()));
        mana.setItemMeta((ItemMeta)manameta);
        final PotionMeta critdmeta = (PotionMeta)critdamage.getItemMeta();
        critdmeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        critdmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        critdmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), p.getCritDamage()));
        critdamage.setItemMeta((ItemMeta)critdmeta);
        final ItemMeta critcmeta = critchance.getItemMeta();
        critcmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        critcmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), p.getCritChance()));
        critchance.setItemMeta(critcmeta);
        final ItemMeta stealthdata = stealth.getItemMeta();
        stealthdata.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        stealthdata.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.DARK_GRAY), p.getStealth()));
=======
        speedmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        speedmeta.setDisplayName(ChatColor.GRAY + "Speed: " + ChatColor.WHITE + "" + p.getSpeed());
        speed.setItemMeta(speedmeta);

        PotionMeta manameta = (PotionMeta) mana.getItemMeta();
        manameta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        manameta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        manameta.setDisplayName(ChatColor.GRAY + "Mana: " + ChatColor.AQUA + "" + p.getMana());
        mana.setItemMeta(manameta);

        PotionMeta critdmeta = (PotionMeta) critdamage.getItemMeta();
        critdmeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        critdmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        critdmeta.setDisplayName(ChatColor.GRAY + "Critical Damage: " + ChatColor.RED + "" + p.getCritDamage() + "%");
        critdamage.setItemMeta(critdmeta);

        ItemMeta critcmeta = critchance.getItemMeta();
        critcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        critcmeta.setDisplayName(ChatColor.GRAY + "Critical Chance: " + ChatColor.RED + "" + p.getCritChance() + "%");
        critchance.setItemMeta(critcmeta);

        ItemMeta stealthdata = stealth.getItemMeta();
        stealthdata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stealthdata.setDisplayName(ChatColor.GRAY + "Stealth: " + ChatColor.DARK_GRAY + "" + p.getStealth() + "%");
>>>>>>> Stashed changes
        stealth.setItemMeta(stealthdata);
        final ItemMeta data1 = purple_glass.getItemMeta();
        data1.setDisplayName("   ");
        purple_glass.setItemMeta(data1);
        final ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);
        for (int i = 0; i <= 53; ++i) {
            if (i == 45) {
                inv.setItem(i, arrow);
            }
            else if (i <= 2 || i == 6 || i == 7 || i == 8 || i == 9 || i == 17 || i == 18 || i == 26 || i == 27 || i > 42 || i == 35 || i == 36 || i == 37) {
                inv.setItem(i, purple_glass);
            }
            else if (i == 13) {
                inv.setItem(i, player_head);
            }
            else if (i == 20) {
                inv.setItem(i, damage);
            }
            else if (i == 21) {
                inv.setItem(i, defence);
            }
            else if (i == 22) {
                inv.setItem(i, strength);
            }
            else if (i == 23) {
                inv.setItem(i, speed);
            }
            else if (i == 24) {
                inv.setItem(i, mana);
            }
            else if (i == 30) {
                inv.setItem(i, critdamage);
            }
            else if (i == 31) {
                inv.setItem(i, critchance);
            }
            else if (i == 32) {
                inv.setItem(i, stealth);
            }
            else {
                inv.setItem(i, blue_glass);
            }
        }
<<<<<<< Updated upstream
=======
//        ItemStack clay = new ItemStack(CLAY, 64);
//        ItemMeta clayMeta = clay.getItemMeta();
//        lore.add(ChatColor.DARK_PURPLE + "Staff");
//        clayMeta.setLore(lore);
//        clay.setItemMeta(clayMeta);
//        inv.addItem(clay);
>>>>>>> Stashed changes
        player.openInventory(inv);
    }
    
    public static void ChooseClassesMenu(final Player p) {
        final ItemStack red_glass = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        final ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        final ItemStack green_glass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack mage = new ItemStack(Material.POTION, 1);
        final ItemStack warrior = new ItemStack(Material.IRON_SWORD, 1);
        final ItemStack ranger = new ItemStack(Material.BOW, 1);
        final ItemMeta meta1 = red_glass.getItemMeta();
        meta1.setDisplayName("   ");
        red_glass.setItemMeta(meta1);
        final ItemMeta meta2 = blue_glass.getItemMeta();
        meta2.setDisplayName("   ");
        blue_glass.setItemMeta(meta2);
        final ItemMeta meta3 = green_glass.getItemMeta();
        meta3.setDisplayName("   ");
        green_glass.setItemMeta(meta3);
        final PotionMeta magemeta = (PotionMeta)mage.getItemMeta();
        magemeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        magemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        magemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.AQUA)));
        mage.setItemMeta((ItemMeta)magemeta);
        final ItemMeta warriormeta = warrior.getItemMeta();
        warriormeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        warriormeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
        warrior.setItemMeta(warriormeta);
        final ItemMeta rangermeta = ranger.getItemMeta();
        rangermeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        rangermeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GREEN)));
        ranger.setItemMeta(rangermeta);
        MenuChoice(p);
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "Choose a Class");
        for (int i = 0; i < 28; ++i) {
            if (i < 10 || i == 11 || i == 12 || i == 14 || i == 15 || i == 17 || i > 17) {
                if (i == 0 || i == 1 || i == 2 || i == 9 || i == 11 || i == 18 || i == 19 || i == 20) {
                    inv.setItem(i, blue_glass);
                }
                else if (i == 3 || i == 4 || i == 5 || i == 12 || i == 14 || i == 21 || i == 22 || i == 23) {
                    inv.setItem(i, red_glass);
                }
                else if (i == 6 || i == 7 || i == 8 || i == 15 || i == 17 || i == 24 || i == 25 || i == 26) {
                    inv.setItem(i, green_glass);
                }
            }
            else if (i == 10) {
                inv.setItem(i, mage);
            }
            else if (i == 13) {
                inv.setItem(i, warrior);
            }
            else if (i == 16) {
                inv.setItem(i, ranger);
            }
        }
        p.openInventory(inv);
    }
    
    public static void MageSubclassMenu(final Player p) {
        SubclassMenu(p, 1);
    }
    
    public static void WarriorSubclassMenu(final Player p) {
        SubclassMenu(p, 2);
    }
    
    public static void RangerSubclassMenu(final Player p) {
        SubclassMenu(p, 3);
    }
    
    public static void areYouSureClassMenu(final Player p) {
        final ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        final ItemMeta meta2 = blue_glass.getItemMeta();
        meta2.setDisplayName("   ");
        blue_glass.setItemMeta(meta2);
        final ItemStack yes = new ItemStack(Material.GREEN_CONCRETE, 1);
        final ItemStack no = new ItemStack(Material.RED_CONCRETE, 1);
        final ItemMeta yesmeta = yes.getItemMeta();
        yesmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        yesmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
        yes.setItemMeta(yesmeta);
        final ItemMeta nometa = no.getItemMeta();
        nometa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
        nometa.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
        no.setItemMeta(nometa);
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "Are you sure. Confirm your class");
        for (int i = 0; i < 27; ++i) {
            if (i == 11) {
                inv.setItem(i, yes);
            }
            else if (i == 15) {
                inv.setItem(i, no);
            }
            else {
                inv.setItem(i, blue_glass);
            }
        }
        p.openInventory(inv);
    }
    
    public static void SubclassMenu(final Player p, final int SubclassNumber) {
        MenuChoice(p);
        final ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        final ItemStack back = new ItemStack(Material.ARROW, 1);
        final ItemMeta arrowmeta = back.getItemMeta();
        arrowmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
        back.setItemMeta(arrowmeta);
        Inventory inv = null;
        final ItemMeta meta2 = blue_glass.getItemMeta();
        meta2.setDisplayName("   ");
        blue_glass.setItemMeta(meta2);
        switch (SubclassNumber) {
            case 1: {
                final ItemStack battle_mage = new ItemStack(Material.IRON_SWORD, 1);
                final ItemStack wizard = new ItemStack(Material.POTION, 1);
                final ItemStack healer = new ItemStack(Material.POTION, 1);
                final ItemStack necromancer = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
                final ItemMeta battle_magemeta = battle_mage.getItemMeta();
                battle_magemeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                battle_magemeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
                battle_mage.setItemMeta(battle_magemeta);
                final PotionMeta wizardmeta = (PotionMeta)wizard.getItemMeta();
                wizardmeta.setBasePotionData(new PotionData(PotionType.SPEED));
                wizardmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                wizardmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
                wizard.setItemMeta((ItemMeta)wizardmeta);
                final PotionMeta healermeta = (PotionMeta)healer.getItemMeta();
                healermeta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL));
                healermeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                healermeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
                healer.setItemMeta((ItemMeta)healermeta);
                final ItemMeta necromancermeta = necromancer.getItemMeta();
                necromancermeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                necromancermeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_RED)));
                necromancer.setItemMeta(necromancermeta);
                inv = Bukkit.createInventory((InventoryHolder)null, 27, "Choose a Mage Subclass");
                for (int i = 0; i < 27; ++i) {
                    if (i == 10) {
                        inv.setItem(i, battle_mage);
                    }
                    else if (i == 12) {
                        inv.setItem(i, wizard);
                    }
                    else if (i == 14) {
                        inv.setItem(i, healer);
                    }
                    else if (i == 16) {
                        inv.setItem(i, necromancer);
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
            case 2: {
                final ItemStack barbarian = new ItemStack(Material.NETHERITE_AXE, 1);
                final ItemStack samurai = new ItemStack(Material.DIAMOND_SWORD, 1);
                final ItemStack paladin = new ItemStack(Material.SHIELD, 1);
                final ItemStack viking = new ItemStack(Material.IRON_AXE, 1);
                final ItemMeta barbarianmeta = barbarian.getItemMeta();
                barbarianmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                barbarianmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
                barbarian.setItemMeta(barbarianmeta);
                final ItemMeta samuraimeta = samurai.getItemMeta();
                samuraimeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                samuraimeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
                samurai.setItemMeta(samuraimeta);
                final ItemMeta paladinmeta = paladin.getItemMeta();
                paladinmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                paladinmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
                paladin.setItemMeta(paladinmeta);
                final ItemMeta vikingmeta = viking.getItemMeta();
                vikingmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                vikingmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_RED)));
                viking.setItemMeta(vikingmeta);
                inv = Bukkit.createInventory((InventoryHolder)null, 27, "Choose a Warrior Subclass");
                for (int j = 0; j < 27; ++j) {
                    if (j == 10) {
                        inv.setItem(j, barbarian);
                    }
                    else if (j == 12) {
                        inv.setItem(j, samurai);
                    }
                    else if (j == 14) {
                        inv.setItem(j, paladin);
                    }
                    else if (j == 16) {
                        inv.setItem(j, viking);
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
            case 3: {
                final ItemStack sniper = new ItemStack(Material.CROSSBOW, 1);
                final ItemStack hunter = new ItemStack(Material.BOW, 1);
                final ItemStack scout = new ItemStack(Material.RABBIT_FOOT, 1);
                final ItemStack assassin = new ItemStack(Material.IRON_SWORD, 1);
                final ItemMeta snipermeta = sniper.getItemMeta();
                snipermeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                snipermeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_GRAY)));
                sniper.setItemMeta(snipermeta);
                final ItemMeta huntermeta = hunter.getItemMeta();
                huntermeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                huntermeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.RED)));
                hunter.setItemMeta(huntermeta);
                final ItemMeta scoutmeta = scout.getItemMeta();
                scoutmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS });
                scoutmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GREEN)));
                scout.setItemMeta(scoutmeta);
                final ItemMeta assassinmeta = assassin.getItemMeta();
                assassinmeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                assassinmeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.DARK_RED)));
                assassin.setItemMeta(assassinmeta);
                inv = Bukkit.createInventory((InventoryHolder)null, 27, "Choose a Ranger Subclass");
                for (int k = 0; k < 27; ++k) {
                    if (k == 10) {
                        inv.setItem(k, sniper);
                    }
                    else if (k == 12) {
                        inv.setItem(k, hunter);
                    }
                    else if (k == 14) {
                        inv.setItem(k, scout);
                    }
                    else if (k == 16) {
                        inv.setItem(k, assassin);
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
        }
        p.openInventory(inv);
    }
<<<<<<< Updated upstream
    
    public static void MenuChoice(final Player p) {
        for (final PlayerStats player : PlayerJoin.Players) {
            if (player.getUUID().toString().equals(p.getPlayer().getUniqueId().toString())) {
                player.setChoiceCD(1);
                new BukkitRunnable() {
                    public void run() {
                        player.setChoiceCD(0);
                    }
                }.runTaskLater((org.bukkit.plugin.Plugin)Plugin.getInstance(), 5L);
            }
        }
=======
    public static void MenuChoice(Player p) {
        for (PlayerStats player : Players) {
            if(player.getUUID().toString().equals(p.getPlayer().getUniqueId().toString())) {
                player.setChoiceCD(1);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.setChoiceCD(0);
                    }
                }.runTaskLater(Plugin.getInstance() , 5L);
            }
        }



>>>>>>> Stashed changes
    }
}
