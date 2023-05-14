<<<<<<< Updated upstream
// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;
import java.util.List;

public class DetermineItemAbility
{
    public static void getItemAbilityLore(final List<String> Lore, final Item item) {
        Lore.add("");
        final String ability = item.getAbility();
        switch (ability) {
            case "test": {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY), String.valueOf(ChatColor.BLUE)));
                break;
            }
            default: {
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GOLD)));
                Lore.add(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, String.valueOf(ChatColor.GRAY)));
                break;
            }
=======
package me.dnfneca.plugin.utilities.managers.Item;

import org.bukkit.ChatColor;

import java.util.List;

public class DetermineItemAbility {
    public static void getItemAbilityLore(List<String> Lore, Item item) {
        Lore.add("");
        switch (item.getAbility()) {
            case "test":
                Lore.add(ChatColor.GOLD + "RIGHT CLICK: test");
                Lore.add(ChatColor.GRAY + "Ability Description");
                Lore.add(ChatColor.GRAY + "Mana Cost:" + ChatColor.BLUE + " 25");
                break;
            default:
                Lore.add(ChatColor.GOLD + "RIGHT CLICK: Unknown");
                Lore.add(ChatColor.GRAY + "This has an ability (we don't know what it is either)");

>>>>>>> Stashed changes
        }
    }
}
