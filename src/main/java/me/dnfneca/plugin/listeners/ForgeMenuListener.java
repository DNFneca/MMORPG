package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.managers.Item.CustomItemStack;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Item.Items;
import me.dnfneca.plugin.utilities.managers.Item.Reforge;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.dnfneca.plugin.Plugin.CustomItems;
import static me.dnfneca.plugin.Plugin.CustomReforges;
import static me.dnfneca.plugin.listeners.PlayerJoin.plugin;
import static me.dnfneca.plugin.utilities.managers.Item.Items.getItemReforge;
import static me.dnfneca.plugin.utilities.managers.Item.Items.isItemReforged;

public class ForgeMenuListener implements Listener {


	@EventHandler
	public void onInventoryEvent(InventoryClickEvent e) {
		String InventoryName = e.getView().getTitle();
		if (!(InventoryName.contains("Forge Menu"))) {
			return;
		}
		Player p = (Player) e.getWhoClicked();
		List<String> lore = new ArrayList<>();
		Inventory inv = e.getInventory();
		ItemStack ClickedItem = null;

		try {
			ClickedItem = e.getCurrentItem();
		} catch (Error error) {
		}
		if (null == ClickedItem) {
			return;
		}


		ItemStack none = new ItemStack(Material.BARRIER, 1);
		ItemMeta none_meta = none.getItemMeta();
		none_meta.setDisplayName("Can't reforge this");
		none.setItemMeta(none_meta);

		new BukkitRunnable() {
			@Override
			public void run() {
				ItemStack itemToReforge = e.getInventory().getItem(11);
				ItemStack reforgeStone = e.getInventory().getItem(15);
				if (itemToReforge == null) {
					e.getInventory().setItem(40, none);
				}
				if (reforgeStone == null) {
					e.getInventory().setItem(40, none);
				}

				if(!CustomItemStack.isItemCustomItem(itemToReforge) || CustomItemStack.isItemCustomReforge(itemToReforge)) {
					e.getInventory().setItem(40, none);
				}
				if(!CustomItemStack.isItemCustomItem(reforgeStone) || CustomItemStack.isItemCustomReforge(reforgeStone)) {
					e.getInventory().setItem(40, none);
				}

				ItemStack reforgedItem = itemToReforge.clone();


				if(!CustomItemStack.isItemReforged(itemToReforge)) {
					String reforgeName = CustomItemStack.getItemReforgeName(reforgeStone);
					System.out.println(reforgeName);
					ItemMeta reforgedItemMeta = itemToReforge.getItemMeta();
					String[] itemName = reforgedItemMeta.getDisplayName().split(" ");
					reforgedItemMeta.setDisplayName(reforgeName + " " + reforgedItemMeta.getDisplayName().replace(itemName[0] + " ", ""));
					reforgedItemMeta.getPersistentDataContainer().set(CustomItemStack.customItemReforgeNameNamespaceKey, PersistentDataType.STRING, reforgeName);
					reforgedItemMeta.getPersistentDataContainer().set(CustomItemStack.customItemReforgedNamespaceKey, PersistentDataType.BOOLEAN, true);
					reforgedItem.setItemMeta(reforgedItemMeta);
					e.getInventory().setItem(40, reforgedItem);
					Items.setItemLore(reforgedItem, p);
				} else {
					e.getInventory().setItem(40, none);
				}
//				SetItemStatsLoreInMenu(40, p);
//			for (final String[] s : RegisteredReforges) {
//				if (e.getInventory().getItem(15).getItemMeta().getDisplayName().contains(s[0])) {
//					final String[] check = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//					final ItemStack reforged_item = reforgable_item.clone();
//					final String[] item_name = reforged_item.getItemMeta().getDisplayName().split(" ");
//					System.out.println(item_name[0] + " " + s[1] + " " + item_name[0].contains(s[1]));
//					if (item_name[0].contains(s[1])) {
//						e.getInventory().setItem(40, none);
//						break;
//					}
//					final ItemMeta reforged_item_data = reforged_item.getItemMeta();
//					reforged_item_data.setDisplayName(s[1] + " " + reforged_item.getItemMeta().getDisplayName());
//					reforged_item.setItemMeta(reforged_item_data);
//					e.getInventory().setItem(40, reforged_item);
//					if (Arrays.equals(ForgeMenuListener.GetInventoryReforge(p, 40), check)) {
//						e.getInventory().setItem(40, none);
//					}
//                       ForgeMenuListener.SetItemStatsLoreInMenu(40, p);
//				}
//			}


				if (e.getSlot() == 40 && e.getCurrentItem().getType() != Material.BARRIER) {
					e.getInventory().setItem(11, new ItemStack(Material.AIR, 1));
					e.getInventory().setItem(15, new ItemStack(Material.AIR, 1));
				}
			}
		}.runTaskLater(Plugin.getInstance(), 2);


	}


	@EventHandler
	public void onForgeMenuClose(InventoryCloseEvent e) {
		if (e.getView().getTitle().contains("Forge Menu")) {
			e.getPlayer().getInventory().addItem(e.getInventory().getItem(11));
		}
	}

	public static void SetItemStatsLoreInMenu(int ItemSlot, Player player) {

	}

	public static String[] GetInventoryReforge(Player p, int ItemSlot) {
		String[] data = new String[10];


		ItemStack Item = p.getOpenInventory().getItem(ItemSlot);


		if (null == Item) {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		}
		if (null != Item.getItemMeta()) {
			ItemMeta itemMeta = Item.getItemMeta();
			String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
//            if(Check.ExistingStats(Item.getItemMeta())[7].equals("Armor") || Check.ExistingStats(Item.getItemMeta())[7].equals("Helmet") || Check.ExistingStats(Item.getItemMeta())[7].equals("Chestplate") || Check.ExistingStats(Item.getItemMeta())[7].equals("Leggings") || Check.ExistingStats(Item.getItemMeta())[7].equals("Boots")) {
//                data = DetermineArmorReforge(itemMeta.getDisplayName());
//            } else {
//                data = DetermineReforge(itemMeta.getDisplayName());
//            }

		}
		return data;
	}

}
