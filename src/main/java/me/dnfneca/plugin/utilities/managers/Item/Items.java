// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemFlag;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import java.util.Iterator;
import me.dnfneca.plugin.Plugin;

public class Items
{
    public static Item getCustomItemByName(final String ItemName) {
        for (final Item item : Plugin.CustomItems) {
            if (ItemName.contains(item.Name)) {
                return item;
            }
        }
        return null;
    }
    
    public static Reforge getCustomReforgeByName(final String ItemName) {
        for (final Reforge reforge : Plugin.CustomReforges) {
            if (reforge.getReforgeName().equals(ItemName)) {
                return reforge;
            }
        }
        return null;
    }
    
    public static void setItemLore(final Inventory inventory, final ItemMeta itemMeta, final int itemSlot) {
        final String itemName = ChatColor.stripColor(itemMeta.getDisplayName());
        if (itemName.contains("Menu")) {
            return;
        }
        final Item item = getCustomItemByName(ChatColor.stripColor(itemName));
        final ItemStack itemInQ = inventory.getItem(itemSlot);
        if (item == null) {
            return;
        }
        final String reforgeName = itemName.replace(item.Name, "");
        final Reforge reforge = getCustomReforgeByName(reforgeName.replace(" ", ""));
        if (itemInQ != null && itemInQ.getItemMeta().hasLore() && reforge == null) {
            return;
        }
        final String rarity = item.getRarity();
        ChatColor color = null;
        switch (rarity) {
            case "Rare": {
                color = ChatColor.BLUE;
                break;
            }
            case "Uncommon": {
                color = ChatColor.GREEN;
                break;
            }
            case "Epic": {
                color = ChatColor.DARK_PURPLE;
                break;
            }
            case "Legendary": {
                color = ChatColor.GOLD;
                break;
            }
            case "Mythic": {
                color = ChatColor.DARK_RED;
                break;
            }
            case "Exotic": {
                color = ChatColor.LIGHT_PURPLE;
                break;
            }
            default: {
                color = ChatColor.GRAY;
                break;
            }
        }
        itemMeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(color), itemMeta.getDisplayName()));
        final List<String> Lore = new ArrayList<String>();
        if (reforge == null) {
            if (item.Health > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Health));
            }
            else if (item.Health < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Health).replace("-", "")));
            }
            if (item.Damage > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Damage));
            }
            else if (item.Damage < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Damage).replace("-", "")));
            }
            if (item.Defence > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Defence));
            }
            else if (item.Defence < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Defence).replace("-", "")));
            }
            if (item.Strength > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Strength));
            }
            else if (item.Strength < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Strength).replace("-", "")));
            }
            if (item.Speed > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Speed));
            }
            else if (item.Speed < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Speed).replace("-", "")));
            }
            if (item.Mana > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Mana));
            }
            else if (item.Speed < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Mana).replace("-", "")));
            }
            if (item.CritDamage > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritDamage));
            }
            else if (item.CritDamage < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.CritDamage).replace("-", "")));
            }
            if (item.CritChance > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritChance));
            }
            else if (item.CritChance < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.CritChance).replace("-", "")));
            }
            if (item.Stealth > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Stealth));
            }
            else if (item.Stealth < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Stealth).replace("-", "")));
            }
        }
        else {
            if (reforge.Health > 0.0) {
                if (item.Health > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Health, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Health));
                }
                else if (item.Health < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Health), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Health));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), (int)item.Health, String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Health));
                }
            }
            else if (reforge.Health < 0.0) {
                if (item.Health > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Health, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Health)));
                }
                else if (item.Health < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Health), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Health)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), (int)item.Health, String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Health)));
                }
            }
            else if (item.Health > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Health));
            }
            else if (item.Health < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Health).replace("-", "")));
            }
            if (reforge.Damage > 0.0) {
                if (item.Damage > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Damage, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Damage));
                }
                else if (item.Damage < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Damage), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Damage));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Damage));
                }
            }
            else if (reforge.Damage < 0.0) {
                if (item.Damage > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Damage, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Damage)));
                }
                else if (item.Damage < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Damage), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Damage)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Damage)));
                }
            }
            else if (item.Damage > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Damage));
            }
            else if (item.Damage < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Damage).replace("-", "")));
            }
            if (reforge.Defence > 0.0) {
                if (item.Defence > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Defence, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Defence));
                }
                else if (item.Defence < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Defence), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Defence));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Defence));
                }
            }
            else if (reforge.Defence < 0.0) {
                if (item.Defence > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Defence, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Defence)));
                }
                else if (item.Defence < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Defence), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Defence)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Defence)));
                }
            }
            else if (item.Defence > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Defence));
            }
            else if (item.Defence < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Defence).replace("-", "")));
            }
            if (reforge.Strength > 0.0) {
                if (item.Strength > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Strength, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Strength));
                }
                else if (item.Strength < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Strength), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Strength));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Strength));
                }
            }
            else if (reforge.Strength < 0.0) {
                if (item.Strength > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Strength, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Strength)));
                }
                else if (item.Strength < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Strength), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Strength)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Strength)));
                }
            }
            else if (item.Strength > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Strength));
            }
            else if (item.Strength < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Strength).replace("-", "")));
            }
            if (reforge.Speed > 0.0) {
                if (item.Speed > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Speed, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Speed));
                }
                else if (item.Speed < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Speed), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Speed));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Speed));
                }
            }
            else if (reforge.Speed < 0.0) {
                if (item.Speed > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Speed, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Speed)));
                }
                else if (item.Speed < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Speed), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Speed)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Speed)));
                }
            }
            else if (item.Speed > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Speed));
            }
            else if (item.Speed < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Speed).replace("-", "")));
            }
            if (reforge.Mana > 0.0) {
                if (item.Mana > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Mana, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Mana));
                }
                else if (item.Mana < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Mana), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Mana));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Mana));
                }
            }
            else if (reforge.Mana < 0.0) {
                if (item.Mana > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Mana, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Mana)));
                }
                else if (item.Mana < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Mana), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Mana)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Mana)));
                }
            }
            else if (item.Mana > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Mana));
            }
            else if (item.Mana < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Mana).replace("-", "")));
            }
            if (reforge.CritDamage > 0.0) {
                if (item.CritDamage > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritDamage, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.CritDamage));
                }
                else if (item.CritDamage < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritDamage), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.CritDamage));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.CritDamage));
                }
            }
            else if (reforge.CritDamage < 0.0) {
                if (item.CritDamage > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritDamage, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritDamage)));
                }
                else if (item.CritDamage < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritDamage), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritDamage)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritDamage)));
                }
            }
            else if (item.CritDamage > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritDamage));
            }
            else if (item.CritDamage < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.CritDamage).replace("-", "")));
            }
            if (reforge.CritChance > 0.0) {
                if (item.CritChance > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritChance, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.CritChance));
                }
                else if (item.CritChance < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritChance), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.CritChance));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.CritChance));
                }
            }
            else if (reforge.CritChance < 0.0) {
                if (item.CritChance > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritChance, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritChance)));
                }
                else if (item.CritChance < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritChance), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritChance)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.CritChance)));
                }
            }
            else if (item.CritChance > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.CritChance));
            }
            else if (item.CritChance < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.CritChance).replace("-", "")));
            }
            if (reforge.Stealth > 0.0) {
                if (item.Stealth > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Stealth, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Stealth));
                }
                else if (item.Stealth < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Stealth), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Stealth));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)reforge.Stealth));
                }
            }
            else if (reforge.Stealth < 0.0) {
                if (item.Stealth > 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Stealth, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Stealth)));
                }
                else if (item.Stealth < 0.0) {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Stealth), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Stealth)));
                }
                else {
                    Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), (int)(-1.0 * item.Stealth)));
                }
            }
            else if (item.Stealth > 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GRAY), (int)item.Stealth));
            }
            else if (item.Stealth < 0.0) {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.RED), String.valueOf(ChatColor.GRAY), String.valueOf((int)item.Stealth).replace("-", "")));
            }
        }
        if (!item.getAbility().equals("none")) {
            DetermineItemAbility.getItemAbilityLore(Lore, item);
        }
        Lore.add("");
        Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(color), item.Rarity));
        itemMeta.setLore((List)Lore);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DESTROYS });
        itemInQ.setItemMeta(itemMeta);
    }
}
