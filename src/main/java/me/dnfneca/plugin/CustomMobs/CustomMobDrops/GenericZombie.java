package me.dnfneca.plugin.CustomMobs.CustomMobDrops;

import me.dnfneca.plugin.utilities.managers.Item.Items;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static me.dnfneca.plugin.utilities.managers.Item.Items.setItemLore;

public enum GenericZombie {
	;
	private static final Collection<ItemStack> items = new ArrayList<ItemStack>();

    /**
     * @param p the Entity that got killed
     * @param killer the HumanEntity (the player) that killed p
     */
    public static void dropCustomDrops(Entity p, HumanEntity killer) {
//		EnchantingMenu.Open((Player) sender);
        LootContext.Builder builder = new LootContext.Builder(p.getLocation());
        builder.lootedEntity(p);
        builder.lootingModifier(1);
        builder.luck(2);
        builder.killer(killer);
        LootContext lootContext = builder.build();

        Collection<ItemStack> drops = populateLoot(new Random(), lootContext);
        ArrayList<ItemStack> items = (ArrayList<ItemStack>) drops;


        Location location = p.getLocation();
        location.setY(location.getY() - 0.4);

        for (int a = 0; a < items.size(); a++) {
            if(0 < items.get(a).getAmount()) {
                p.getLocation().getWorld().dropItemNaturally(location, items.get(a));
            }
        }

        items.clear();
    }
    private static Collection<ItemStack> populateLoot(Random random, LootContext context) {
        double looting_modifier;
        double luck_modifier;

        int looting_level = context.getLootingModifier();
        if (0 < looting_level) {
            looting_modifier = (Math.pow(looting_level, 0.8) + 2) / 2;
        }
        else {
            looting_modifier = 1;
        }

        double luck_level = context.getLuck();
        if (0 < luck_level) {
            luck_modifier = Math.pow(luck_level, 1.5) / 3;
        }
        else if (0 == luck_level){
            luck_modifier = 1;
        }
        else {
            luck_modifier = 0;
        }
        int random_modifier = random.nextInt(5);
        int item_count = (int) (looting_modifier * luck_modifier * random_modifier);

        int flesh_count;

        if (2 < item_count) {
            flesh_count = item_count;
        }
        else {
            flesh_count = 1;
        }



        ItemStack rotten_flesh = new ItemStack(Material.ROTTEN_FLESH, flesh_count);
        ItemMeta itemMeta = rotten_flesh.getItemMeta();
        itemMeta.setDisplayName("Rotten Flesh");
        rotten_flesh.setItemMeta(itemMeta);
        setItemLore(rotten_flesh);

	    items.add(rotten_flesh);

        return items;
    }
}
