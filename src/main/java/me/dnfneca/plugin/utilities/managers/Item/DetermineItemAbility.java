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
        }
    }
}
