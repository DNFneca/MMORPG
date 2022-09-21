package me.dnfneca.plugin.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

public class item implements CommandExecutor {


    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.isOp()) {
                if(command.getName().equalsIgnoreCase("item")) {
                    ItemStack item = new ItemStack(Material.END_GATEWAY, 1);
                    ItemMeta meta = null;
                    switch (args[0]) {
                        case "ASPECT_OF_THE_NETHER":
                        case "AOTN":
                            item.setType(Material.IRON_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Aspect of the Nether");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "WMSET":
                        case "WISE_MANS_SET":
                            item.setType(Material.LEATHER_HELMET);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Wise Man's Hat");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);

                            item.setType(Material.LEATHER_CHESTPLATE);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Wise Man's Coat");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);

                            item.setType(Material.LEATHER_LEGGINGS);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Wise Man's Trousers");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);

                            item.setType(Material.LEATHER_BOOTS);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Wise Man's Boots");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "IRON_ARMOR_SET":
                        case "IASET":
                            item.setType(Material.IRON_HELMET);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Iron Armor Helmet");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);

                            item.setType(Material.IRON_CHESTPLATE);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Iron Armor Chestplate");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);

                            item.setType(Material.IRON_LEGGINGS);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Iron Armor Leggings");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);

                            item.setType(Material.IRON_BOOTS);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Iron Armor Boots");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "AOTE":
                        case "ASPECT_OF_THE_END":
                            item.setType(Material.DIAMOND_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Aspect of the End");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "STICKY":
                            item.setType(Material.STICK);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Reforged Sticky");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "EROS'S_BOW":
                        case "EROS_BOW":
                        case "EROSS_BOW":
                            item.setType(Material.BOW);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Eros's Bow");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "GHOST_REAVER":
                            item.setType(Material.DIAMOND_HOE);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Ghost Reaver");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "LONGSWORD":
                            item.setType(Material.IRON_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Longsword");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "THE_VOID":
                            item.setType(Material.DIAMOND_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("The Void");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "HOLY_IRON_SWORD":
                            item.setType(Material.IRON_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Holy Iron Sword");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "MITHRIL_BLADE":
                            item.setType(Material.DIAMOND_HOE);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Mithril Blade");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "BLOODQUENCH":
                            item.setType(Material.WOODEN_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Bloodquench");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "WINTERTHORN":
                            item.setType(Material.DIAMOND_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Winterthorn");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "BLACK_SWORD":
                            item.setType(Material.DIAMOND_HOE);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Black Sword");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                        case "UNHOLY_GREAT_SWORD":
                            item.setType(Material.IRON_SWORD);
                            meta = item.getItemMeta();
                            meta.setDisplayName("Unholy Great Sword");
                            item.setItemMeta(meta);
                            ((Player) sender).getInventory().addItem(item);
                            break;
                    }
                }
            } else {
                player.sendMessage("You are not allowed to use this command!");
            }
            return true;
//            Player p = (Player) sender;
//            new CustomEntitiesUtils().spawnEntity(() ->
//                    new CraftCustomZombie((CraftServer) Bukkit.getServer(), new EntityCustomZombie((EntityTypes<? extends EntityZombie>) EntityTypes.be, (World) p.getWorld())), p.getLocation());
        }else {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
    }
}
