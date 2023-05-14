// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.inventory.Inventory;
import java.util.List;
import org.bukkit.profile.PlayerTextures;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.inventory.InventoryHolder;
import java.util.ArrayList;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import java.net.MalformedURLException;
import java.net.URL;
import org.bukkit.Bukkit;
import java.util.UUID;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ReforgeMenu
{
    public static void Open(final Player p) {
        final String texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjVhNDc1NDYwYjVmOWEzNjc3OTBkZjlkZjViYmJmYmMxMGMwNzlkNDU0OGUzMzgyZGIzNmYzMzY0ZWMwODg0NSJ9fX0=";
        final String id = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
        final ItemStack VexHead = new ItemStack(Material.PLAYER_HEAD, 1);
        final ItemMeta skullMeta = VexHead.getItemMeta();
        final PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
        final PlayerTextures textures = profile.getTextures();
        URL urlObject = null;
        try {
            urlObject = new URL("https://textures.minecraft.net/texture/b5a475460b5f9a367790df9df5bbbfbc10c079d4548e3382db36f3364ec08845");
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        textures.setSkin(urlObject);
        final ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwnerProfile(profile);
        meta.setDisplayName("Strength Artifact");
        head.setItemMeta((ItemMeta)meta);
        final List<String> lore = new ArrayList<String>();
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "Forge Menu");
        final ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        final ItemStack recipe = new ItemStack(Material.BARRIER, 1);
        final ItemStack reforge_glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        final ItemStack forge = new ItemStack(Material.BARRIER, 1);
        final ItemMeta reforge_glass_data = reforge_glass.getItemMeta();
        reforge_glass_data.setDisplayName("   ");
        reforge_glass.setItemMeta(reforge_glass_data);
        final ItemMeta forge_data = forge.getItemMeta();
        forge_data.setDisplayName("Can't reforge this");
        forge.setItemMeta(forge_data);
        final ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);
        final ItemMeta recipedata = recipe.getItemMeta();
        recipedata.setDisplayName("Your recipe will appear here");
        recipe.setItemMeta(recipedata);
        for (int i = 0; i <= 53; ++i) {
            if (i == 11) {
                inv.setItem(i, new ItemStack(Material.AIR));
            }
            else if (i == 12 || i == 13 || i == 14 || i == 22 || i == 31) {
                inv.setItem(i, reforge_glass);
            }
            else if (i == 15) {
                inv.setItem(i, head);
            }
            else if (i == 40) {
                inv.setItem(i, forge);
            }
            else {
                inv.setItem(i, blue_glass);
            }
        }
        p.openInventory(inv);
    }
}
