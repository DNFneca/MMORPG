package me.dnfneca.plugin.listeners;

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
			System.out.println(error);
		}
		if (null == ClickedItem) {
			return;
		}


		new BukkitRunnable() {
			@Override
			public void run() {
				final boolean isRegistered = false;

				ItemStack none = new ItemStack(Material.BARRIER, 1);
				ItemMeta none_meta = none.getItemMeta();
				none_meta.setDisplayName("Can't reforge this");
				none.setItemMeta(none_meta);

				if (!(InventoryName.contains("Forge Menu"))) {
					return;
				}
				if (e.getViewers().isEmpty()) {
					return;
				}
				ItemStack reforgable_item = e.getInventory().getItem(11);
				if (null == reforgable_item) e.getInventory().setItem(40, none);

//                for (String s : RegisteredItems) {
//                    if (s != null) {
//                        if (reforgable_item.getItemMeta().getDisplayName().contains(s)) {
//                            isRegistered = true;
//                            break;
//                        }
//
//                    } else e.getInventory().setItem(40, none);
//                }
				if (!isRegistered) e.getInventory().setItem(40, none);


				if (null == e.getInventory().getItem(15)) {
					e.getInventory().setItem(40, none);
				}


				if(null != e.getInventory().getItem(15) && null != e.getInventory().getItem(15).getItemMeta().getDisplayName()) {
					ItemStack reforged_item = reforgable_item.clone();
					if(isItemReforged(e.getInventory().getItem(11).getItemMeta().getDisplayName())) {
						for (Reforge customReforge : CustomReforges) {
							if(customReforge.getName().equals(ChatColor.stripColor(e.getInventory().getItem(15).getItemMeta().getDisplayName()))) {
								if(getItemReforge(e.getInventory().getItem(11).getItemMeta().getDisplayName()).equals(customReforge.getReforgeName())) {
									e.getInventory().setItem(40, none);
								} else {
									ItemMeta reforgedItem = e.getInventory().getItem(11).getItemMeta().clone();
									String[] itemName = reforgedItem.getDisplayName().split(" ");
									reforgedItem.setDisplayName(customReforge.getReforgeName() + " " + reforgedItem.getDisplayName().replace(itemName[0] + " ", ""));
									reforged_item.setItemMeta(reforgedItem);
									e.getInventory().setItem(40, reforged_item);
									Items.setItemLore(e.getInventory(), reforged_item.getItemMeta(), 40);
								}
							}
						}

					} else {
						for (Reforge customReforge : CustomReforges) {
							if(customReforge.getName().equals(ChatColor.stripColor(e.getInventory().getItem(15).getItemMeta().getDisplayName()))) {
								ItemMeta reforgedItem = e.getInventory().getItem(11).getItemMeta().clone();
								reforgedItem.setDisplayName(customReforge.getReforgeName() + " " + reforgedItem.getDisplayName());
								reforged_item.setItemMeta(reforgedItem);
								e.getInventory().setItem(40, reforged_item);
								Items.setItemLore(e.getInventory(), reforged_item.getItemMeta(), 40);
							}
						}

					}
//					SetItemStatsLoreInMenu(40, p);
                }


//				for (final String[] s : RegisteredReforges) {
//					if (e.getInventory().getItem(15).getItemMeta().getDisplayName().contains(s[0])) {
//						final String[] check = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//						final ItemStack reforged_item = reforgable_item.clone();
//						final String[] item_name = reforged_item.getItemMeta().getDisplayName().split(" ");
//						System.out.println(item_name[0] + " " + s[1] + " " + item_name[0].contains(s[1]));
//						if (item_name[0].contains(s[1])) {
//							e.getInventory().setItem(40, none);
//							break;
//						}
//						final ItemMeta reforged_item_data = reforged_item.getItemMeta();
//						reforged_item_data.setDisplayName(s[1] + " " + reforged_item.getItemMeta().getDisplayName());
//						reforged_item.setItemMeta(reforged_item_data);
//						e.getInventory().setItem(40, reforged_item);
//						if (Arrays.equals(ForgeMenuListener.GetInventoryReforge(p, 40), check)) {
//							e.getInventory().setItem(40, none);
//						}
//                        ForgeMenuListener.SetItemStatsLoreInMenu(40, p);
//					}
//				}


			}
		}.runTaskTimer(plugin, 0L, 20L);

		if (40 == e.getSlot() && Material.BARRIER != e.getCurrentItem().getType()) {
			e.getInventory().setItem(11, new ItemStack(Material.AIR, 1));
			e.getInventory().setItem(15, new ItemStack(Material.AIR, 1));
		}


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
