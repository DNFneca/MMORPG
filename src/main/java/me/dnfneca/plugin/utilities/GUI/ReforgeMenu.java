package me.dnfneca.plugin.utilities.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReforgeMenu {
    public static void Open(Player p) {

        String texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjVhNDc1NDYwYjVmOWEzNjc3OTBkZjlkZjViYmJmYmMxMGMwNzlkNDU0OGUzMzgyZGIzNmYzMzY0ZWMwODg0NSJ9fX0=";

        String id = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

        ItemStack VexHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta skullMeta = VexHead.getItemMeta();
//        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID()); // Get a new player profile
        PlayerTextures textures = profile.getTextures();
        URL urlObject = null;

        try {
            urlObject = new URL("https://textures.minecraft.net/texture/b5a475460b5f9a367790df9df5bbbfbc10c079d4548e3382db36f3364ec08845"); // The URL to the skin, for example: https://textures.minecraft.net/texture/4c79ed60d8bce167417b8768d593c88076b0f2f9be8f14f5c8eda58bb0c9db18
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        textures.setSkin(urlObject);


//        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/18813764b2abc94ec3c3bc67b9147c21be850cdf996679703157f4555997ea63");
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwnerProfile(profile); // Set the owning player of the head to the player profile
        head.setItemMeta(meta);







        List<String> lore = new ArrayList<>();


        Inventory inv = Bukkit.createInventory(null, 45, "Forge Menu");

        ItemStack blue_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemStack recipe = new ItemStack(Material.BARRIER, 1);

        ItemMeta data2 = blue_glass.getItemMeta();
        data2.setDisplayName("   ");
        blue_glass.setItemMeta(data2);

        ItemMeta recipedata = recipe.getItemMeta();
        recipedata.setDisplayName("Your recipe will appear here");
        recipe.setItemMeta(recipedata);


        for(int i = 0; i <= 44; i++) {
            if(i == 10 || i == 11 || i == 12 || i == 19 || i == 20 || i == 21 || i == 28 || i == 29 || i == 30){
                inv.setItem(i, new ItemStack(Material.AIR));
            } else if (i == 24) {
                inv.setItem(i, head);
            }else {
                inv.setItem(i, blue_glass);
            }
        }
//        ItemStack clay = new ItemStack(CLAY, 64);
//        ItemMeta clayMeta = clay.getItemMeta();
//        lore.add(ChatColor.DARK_PURPLE + "Staff");
//        clayMeta.setLore(lore);
//        clay.setItemMeta(clayMeta);
//        inv.addItem(clay);
        p.openInventory(inv);
    }
}

//
//
//
//
//
//

//
//

//
//
