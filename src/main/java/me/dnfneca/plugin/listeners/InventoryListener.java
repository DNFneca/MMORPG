package me.dnfneca.plugin.listeners;

import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.GUI.Bag;
import me.dnfneca.plugin.utilities.GUI.ClassMenus;
import me.dnfneca.plugin.utilities.GUI.LevelsMenu;
import me.dnfneca.plugin.utilities.GUI.ReforgeMenu;
import me.dnfneca.plugin.utilities.InventoryConverter;
import me.dnfneca.plugin.utilities.managers.Item.*;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static me.dnfneca.plugin.Commands.test.itemMetaUUIDNamespaceKey;
import static me.dnfneca.plugin.Plugin.*;
import static me.dnfneca.plugin.utilities.GUI.GUI.*;
import static me.dnfneca.plugin.utilities.GUI.SubGUI.Menu.*;
import static me.dnfneca.plugin.utilities.InventoryConverter.toBase64;
import static me.dnfneca.plugin.utilities.managers.Statistics.PlayerStatCalc.updatePlayerActionBar;
import static org.bukkit.Bukkit.getPlayer;

public class InventoryListener implements Listener {

	@EventHandler
	public void onInventoryEvent(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		String title = p.getOpenInventory().getTitle();

		if(title.contains("Bag")) {
			ItemMeta itemMeta = p.getInventory().getItemInMainHand().getItemMeta();
			if(itemMeta.getPersistentDataContainer() != null) {
				itemMeta.getPersistentDataContainer().set(itemMetaUUIDNamespaceKey, PersistentDataType.STRING, toBase64(e.getInventory()));
				p.getInventory().getItemInMainHand().setItemMeta(itemMeta);
			}
		}
		if(title.contains("Wand")) {
			ItemMeta itemMeta = p.getInventory().getItemInMainHand().getItemMeta();
			if(itemMeta.getPersistentDataContainer() != null) {
				itemMeta.getPersistentDataContainer().set(itemMetaUUIDNamespaceKey, PersistentDataType.STRING, toBase64(e.getInventory()));
				p.getInventory().getItemInMainHand().setItemMeta(itemMeta);
			}
		}

		if (title.contains("Choose a Class") || title.contains("Choose a Mage Subclass") || title.contains("Choose a Warrior Subclass") || title.contains("Choose a Ranger Subclass") || title.contains("Are you sure. Confirm your class")) {
			for (PlayerStats player : Players) {
				if (player.getUUID().equals(e.getPlayer().getUniqueId())) {
					if (0 == player.getChoiceCD()) {
						new BukkitRunnable() {
							@Override
							public void run() {
								p.sendMessage("Are you sure you don't want to select a class?");
								setClass(p, "none");
								ChooseClassesMenu(p);
							}
						}.runTaskLater(Plugin.getInstance(), 5L);

					}
				}
			}


		}
	}

	@EventHandler
	public void onInventoryEvent(EntityPickupItemEvent e) {
		Player player = (Player) e.getEntity();



	}



	@EventHandler
	public void onInventoryEvent(InventoryOpenEvent e) {
		if(e.getView().getTitle().contains("Wand")) {
			Player player = (Player) e.getPlayer();
			for(Item item : CustomItems) {
				if(player.getInventory().getItemInMainHand().getItemMeta() == null) return;
				List<String> Lore = player.getInventory().getItemInMainHand().getItemMeta().getLore();
				for (String s : Lore) {
					if(s.contains(item.getRarity()) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(item.getName())) {
						String rarity = item.getRarity().toUpperCase();
						Inventory openedInventory = e.getInventory();
						switch (rarity) {
							case "EXOTIC":
								for(int i = 1; i < 27; i++) {
									if(openedInventory.getItem(i) != null && openedInventory.getItem(i).getItemMeta() != null && i != 1 && i != 7 && i != 8 && i != 9 && i != 10 && i != 16 && i != 17 && i != 18 && i != 19 && i != 25 && i != 26 && openedInventory.getItem(i).getItemMeta().getDisplayName().equals("   ")) {
										openedInventory.setItem(i, null);
									}
								}
								break;
							case "UNCOMMON":
								for(int i = 1; i < 27; i++) {
									if(openedInventory.getItem(i) != null && openedInventory.getItem(i).getItemMeta() != null && i != 8 && i != 9 && i != 17 && i != 18 && i != 26 && openedInventory.getItem(i).getItemMeta().getDisplayName().equals("   ")) {
										openedInventory.setItem(i, null);
									}
								}
								break;
							case "RARE":
								for(int i = 0; i < 27 ; i++) {
									if(openedInventory.getItem(i) != null && openedInventory.getItem(i).getItemMeta() != null && openedInventory.getItem(i).getItemMeta().getDisplayName().equals("   ")) {
										openedInventory.setItem(i, null);
									}
								}
								break;
							case "EPIC":
								for(int i = 0; i < 36 ; i++) {
									if(openedInventory.getItem(i) != null && openedInventory.getItem(i).getItemMeta() != null && openedInventory.getItem(i).getItemMeta().getDisplayName().equals("   ")) {
										openedInventory.setItem(i, null);
									}
								}
								break;
							case "LEGENDARY":
								for(int i = 0; i < 45 ; i++) {
									if(openedInventory.getItem(i) != null && openedInventory.getItem(i).getItemMeta() != null && openedInventory.getItem(i).getItemMeta().getDisplayName().equals("   ")) {
										openedInventory.setItem(i, null);
									}
								}
								break;
							case "MYTHIC":
								for(int i = 0; i < 54 ; i++) {
									if(openedInventory.getItem(i) != null && openedInventory.getItem(i).getItemMeta() != null && openedInventory.getItem(i).getItemMeta().getDisplayName().equals("   ")) {
										openedInventory.setItem(i, null);
									}
								}
								break;
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onInventoryEvent(PlayerSwapHandItemsEvent e) {
		Player p = e.getPlayer();
		updatePlayerActionBar(PlayerStats.getPlayerStats(p.getUniqueId()));

		if(p.getInventory().getItemInOffHand().getItemMeta() == null && p.getInventory().getItemInMainHand().getItemMeta() == null) {
			e.setCancelled(true);
			return;
		}
		if(p.getInventory().getItemInMainHand().getType() == Material.NETHER_STAR && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Menu")) {
			e.setCancelled(true);
			return;
		}

		if(CustomItemStack.isItemCustomItem(p.getInventory().getItemInOffHand()) && CustomItemStack.isItemCustomItem(p.getInventory().getItemInMainHand())) {
			if(!CustomItemStack.getItemType(p.getInventory().getItemInOffHand()).equals("Wand") && !CustomItemStack.getItemType(p.getInventory().getItemInMainHand()).equals("Wand")) {
				e.setCancelled(true);
				return;
			}
		}


		if(CustomItemStack.isItemCustomItem(e.getMainHandItem()) && CustomItemStack.getItemType(e.getMainHandItem()).equals("Spell") && PlayerStats.getPlayerStats(p.getUniqueId()).isSpellsActive()) {
			e.setCancelled(true);
			return;
		}

		if(CustomItemStack.isItemCustomItem(e.getOffHandItem()) && CustomItemStack.getItemType(e.getOffHandItem()).equals("Wand") && PlayerStats.getPlayerStats(p.getUniqueId()).isSpellsActive()
		&& CustomItemStack.isItemCustomItem(e.getMainHandItem()) && CustomItemStack.getItemType(e.getMainHandItem()).equals("Spell")) {
			e.setCancelled(true);
			return;
		}

		List<String> lore = new ArrayList<>();
		Inventory inv = p.getInventory();

		ItemStack i = e.getMainHandItem();
		e.setMainHandItem(e.getOffHandItem());
		e.setOffHandItem(i);
		ItemStack offHand = e.getOffHandItem();
		ItemStack mainHand = e.getMainHandItem();


		new BukkitRunnable() {
			@Override
			public void run() {

				boolean found = false;

				if(CustomItemStack.isItemCustomItem(mainHand) && CustomItemStack.getItemType(mainHand).equals("Bag")) {
					Bag.OpenMenu(p);
					e.setCancelled(true);
					return;
				}

				if (PlayerStats.getPlayerStats(p.getUniqueId()).isSpellsActive()) {
					if (CustomItemStack.isItemCustomItem(p.getInventory().getItemInOffHand()) && CustomItemStack.getItemType(p.getInventory().getItemInOffHand()).equals("Wand")) {
						PlayerStats.getPlayerStats(p.getUniqueId()).setSpellsActive(false);
						ShowPlayerHotbar.ShowHotbar(p);
						for(int i = 0; i < 8 ; i++) {
							if(p.getInventory().getItem(i) != null && p.getInventory().getItem(i).equals(offHand)) {
								found = true;
							}
						}
						if(p.getInventory().getItemInMainHand() == null) {
							p.getInventory().setItemInMainHand(offHand);
						} else if(!found) {
							p.getInventory().addItem(offHand);
						}
						SaveHotbarToDB.SaveHotbarToDB(p, p.getInventory());
					}
				} else {
					if (!CustomItemStack.isItemCustomItem(offHand) || (CustomItemStack.isItemCustomItem(offHand) && !CustomItemStack.getItemType(offHand).equals("Wand"))) {
						PlayerStats.getPlayerStats(p.getUniqueId()).setSpellsActive(true);
						SaveHotbarToDB.SaveHotbarToDB(p, p.getInventory());
						p.getInventory().setItemInOffHand(p.getInventory().getItemInMainHand());
						ShowPlayerSpells.ShowSpells(p, 0);
					}
				}
			}
		}.runTaskLater(Plugin.getInstance(), 0);
	}

	@EventHandler
	public void onInventoryEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		List<String> lore = new ArrayList<>();
		Inventory inv = e.getInventory();

		ItemStack offhand = p.getInventory().getItemInOffHand();
		ItemStack mainhand = p.getInventory().getItemInMainHand();
		ItemStack itemInCursor = e.getCurrentItem();

		if(e.getClick().isCreativeAction()) {
			return;
		}

		if(itemInCursor != null && itemInCursor.getItemMeta() != null && CustomItemStack.isItemCustomItem(itemInCursor) && CustomItemStack.getItemType(itemInCursor).equals("Bag") && (e.getClick().isKeyboardClick() || e.getClick().isRightClick())){
			e.setCancelled(true);
			new BukkitRunnable() {
				@Override
				public void run() {
					Bag.OpenMenu(p, itemInCursor);
				}
			}.runTaskLater(Plugin.getInstance(), 0);
			return;
		}

		if(e.getClick().isKeyboardClick() && e.getSlot() == 40) {
			e.setCancelled(true);
			return;
		}

		if(PlayerStats.getPlayerStats(p.getUniqueId()).isSpellsActive() && e.getSlot() == 40) {
//			e.setCancelled(true);
			PlayerStats.getPlayerStats(p.getUniqueId()).setSpellsActive(false);
			ShowPlayerHotbar.ShowHotbar(p, itemInCursor);
			return;
		}

		if(PlayerStats.getPlayerStats(p.getUniqueId()).isSpellsActive() && e.getClick().isKeyboardClick()) {
//			e.setCancelled(true);
//			if(e.getSlot() < 8) {
//				p.getInventory().setItem(e.getSlot(), new ItemStack(Material.AIR));
//				p.getInventory().setItem(e.getSlot(), offhand);
//				p.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
//			}
			PlayerStats.getPlayerStats(p.getUniqueId()).setSpellsActive(false);
			ShowPlayerHotbar.ShowHotbar(p, p.getInventory().getItemInOffHand());
			return;
		}

		if(offhand != null && offhand.getItemMeta() != null && CustomItemStack.isItemCustomItem(offhand) && CustomItemStack.getItemType(offhand).equals("Wand")) {
			if(itemInCursor == offhand) {
				e.setCancelled(true);
				return;
			}
		}

		if(offhand != null && offhand.getItemMeta() != null && CustomItemStack.isItemCustomItem(offhand) && CustomItemStack.getItemType(offhand).equals("Wand")) {
			if(itemInCursor != null && itemInCursor.getItemMeta() != null && CustomItemStack.isItemCustomItem(itemInCursor) && CustomItemStack.getItemType(itemInCursor).equals("Spell")) {
				e.setCancelled(true);
				return;
			}
		}



		if(itemInCursor != null && itemInCursor.getType() != Material.AIR && CustomItemStack.isItemCustomItem(itemInCursor) && !CustomItemStack.getItemType(itemInCursor).equals("Wand") && PlayerStats.getPlayerStats(p.getUniqueId()).isSpellsActive()) {
			if(!CustomItemStack.getItemType(itemInCursor).equals("Bag")) {
				e.setCancelled(true);
				return;
			}
		}

		new BukkitRunnable() {
			@Override
			public void run() {
				if (CustomItemStack.isItemCustomItem(p.getInventory().getItemInOffHand()) && CustomItemStack.getItemType(p.getInventory().getItemInOffHand()).equals("Wand") && !PlayerStats.getPlayerStats(p.getUniqueId()).isSpellsActive()) {
					SaveHotbarToDB.SaveHotbarToDB(p, p.getInventory());
					ShowPlayerSpells.ShowSpells(p, 0);
					PlayerStats.getPlayerStats(p.getUniqueId()).setSpellsActive(true);
				}
			}
		}.runTaskLater(Plugin.getInstance(), 0);


		ItemStack ClickedItem = null;

		try {
			ClickedItem = e.getCurrentItem();
		} catch (Error error) {
		}
		if (null == ClickedItem) {
			return;
		}
		if (null == ClickedItem.getItemMeta()) {
			return;
		}


		if(e.getView().getTitle().contains("Bag")) {
			if(e.getCurrentItem().getItemMeta() == null) return;
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Bag")) {
				e.setCancelled(true);
			}
		}

		if(e.getView().getTitle().contains("Wand")) {
			if(e.getCurrentItem().getItemMeta() == null) return;
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Wand")) {
				e.setCancelled(true);
			}
			if(!CustomItemStack.isItemCustomItem(e.getCurrentItem()) || !(CustomItemStack.isItemCustomItem(e.getCurrentItem()) && CustomItemStack.getItemType(e.getCurrentItem()).equals("Spell"))) {
				e.setCancelled(true);
			}
		}



		if (ClickedItem.getItemMeta().getDisplayName().contains(":")
				|| ClickedItem.getItemMeta().getDisplayName().contains("   ")
				|| ClickedItem.getItemMeta().getDisplayName().contains("Can't reforge this")
				|| ClickedItem.getItemMeta().getDisplayName().contains("Level Progress")) {
			e.setCancelled(true);
			return;
		}
		if (ClickedItem.getItemMeta().getDisplayName().contains("To Forge")) {
			ReforgeMenu.Open(p);
		}
		PlayerStats playerStats = PlayerStats.getPlayerStats(p.getUniqueId());
		if (e.getView().getTitle().contains("Choose a Class")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Mage")) {
				e.setCancelled(true);
				MageSubclassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Warrior")) {
				e.setCancelled(true);
				WarriorSubclassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Ranger")) {
				e.setCancelled(true);
				RangerSubclassMenu(p);
			}
		} else if (e.getView().getTitle().contains("Main Menu")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Class")) {
				e.setCancelled(true);
				ClassMenus.ClassMenu(p, getClass(p));
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Levels")) {
				e.setCancelled(true);
				LevelsMenu.LevelsMenu(p);
			}
		} else if (e.getView().getTitle().contains("Choose a Mage Subclass")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Battle Mage")) {
				e.setCancelled(true);
				setClass(p, "Battle Mage");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Wizard")) {
				e.setCancelled(true);
				setClass(p, "Wizard");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Healer")) {
				e.setCancelled(true);
				setClass(p, "Healer");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Necromancer")) {
				e.setCancelled(true);
				setClass(p, "Necromancer");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
				e.setCancelled(true);
				ChooseClassesMenu(p);
				setClass(p, "none");
			}
		} else if (e.getView().getTitle().contains("Choose a Warrior Subclass")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Barbarian")) {
				e.setCancelled(true);
				setClass(p, "Barbarian");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Samurai")) {
				e.setCancelled(true);
				setClass(p, "Samurai");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Paladin")) {
				e.setCancelled(true);
				setClass(p, "Paladin");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Viking")) {
				e.setCancelled(true);
				setClass(p, "Viking");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
				e.setCancelled(true);
				ChooseClassesMenu(p);
				setClass(p, "none");
			}
		} else if (e.getView().getTitle().contains("Choose a Ranger Subclass")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Sniper")) {
				e.setCancelled(true);
				setClass(p, "Sniper");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Hunter")) {
				e.setCancelled(true);
				setClass(p, "Hunter");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Scout")) {
				e.setCancelled(true);
				setClass(p, "Scout");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Assassin")) {
				e.setCancelled(true);
				setClass(p, "Assassin");
				MenuChoice(p);
				areYouSureClassMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Back")) {
				e.setCancelled(true);
				ChooseClassesMenu(p);
				setClass(p, "none");
			}
		} else if (e.getView().getTitle().contains("Are you sure. Confirm your class")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Yes (You can't choose a different class on this profile)")) {
				e.setCancelled(true);
				setClass(p, getClass(p));
				MenuChoice(p);
				p.closeInventory();
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("No")) {
				e.setCancelled(true);
				setClass(p, "none");
				MenuChoice(p);
				ChooseClassesMenu(p);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Yes")) {
				e.setCancelled(true);
				MenuChoice(p);
				ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
				ItemMeta meta2 = blue_glass.getItemMeta();
				meta2.setDisplayName("   ");
				blue_glass.setItemMeta(meta2);
				ItemStack yes = new ItemStack(Material.GREEN_CONCRETE, 1);
				ItemStack no = new ItemStack(Material.RED_CONCRETE, 1);
				ItemMeta yesmeta = yes.getItemMeta();
				yesmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				yesmeta.setDisplayName(ChatColor.GREEN + "Yes (You can't choose a different class on this profile)");
				yes.setItemMeta(yesmeta);
				ItemMeta nometa = no.getItemMeta();
				nometa.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
				nometa.setDisplayName(ChatColor.GOLD + "No");
				no.setItemMeta(nometa);
				inv = Bukkit.createInventory(null, 27, "Are you sure. Confirm your class");
				for (int i = 0; 27 > i; i++) {
					if (11 == i) {
						inv.setItem(11, yes);
					} else if (15 == i) {
						inv.setItem(15, no);
					} else {
						inv.setItem(i, blue_glass);
					}
				}
				p.openInventory(inv);
			}
		} else if (e.getView().getTitle().contains("Class Specific Stats")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Battle Mage") || ClickedItem.getItemMeta().getDisplayName().contains("Wizard") || ClickedItem.getItemMeta().getDisplayName().contains("Healer") || ClickedItem.getItemMeta().getDisplayName().contains("Necromancer")) {
				e.setCancelled(true);
				ClassMenus.ClassMenu(p, playerStats.getPlayerClass().replace("\"", ""));
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Barbarian") || ClickedItem.getItemMeta().getDisplayName().contains("Samurai") || ClickedItem.getItemMeta().getDisplayName().contains("Paladin") || ClickedItem.getItemMeta().getDisplayName().contains("Viking")) {
				e.setCancelled(true);
				ClassMenus.ClassMenu(p, playerStats.getPlayerClass().replace("\"", ""));
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("Sniper") || ClickedItem.getItemMeta().getDisplayName().contains("Hunter") || ClickedItem.getItemMeta().getDisplayName().contains("Scout") || ClickedItem.getItemMeta().getDisplayName().contains("Assassin")) {
				e.setCancelled(true);
				ClassMenus.ClassMenu(p, playerStats.getPlayerClass().replace("\"", ""));
			}
		} else if (e.getView().getTitle().contains("Crafting Table")) {
			if (ClickedItem.getItemMeta().getDisplayName().contains("Your recipe will appear here")) {
				e.setCancelled(true);
			} else if (ClickedItem.getItemMeta().getDisplayName().contains("To Forge Menu")) {
				ReforgeMenu.Open(p);
			}
		}
		if (ClickedItem.getItemMeta().getDisplayName().contains("Menu")) {
			e.setCancelled(true);
			MainMenu(p);
		} else if (ClickedItem.getItemMeta().getDisplayName().contains("Stats")) {
			e.setCancelled(true);
			StatsMenu(p);
		} else if (ClickedItem.getItemMeta().getDisplayName().contains("Back to Main Menu")) {
			e.setCancelled(true);
			MainMenu(p);
		} else if (ClickedItem.getItemMeta().getDisplayName().contains("Class")) {
			e.setCancelled(true);
		}

	}

	public void setClass(Player p, String Class) {
		for (PlayerStats player : Players) {
			if (player.getUUID().toString().equals(p.getUniqueId().toString())) {
				player.setClass(Class);

			}
		}

	}

	public String getClass(Player p) {
		for (PlayerStats player : Players) {
			if (player.getUUID().toString().equals(p.getUniqueId().toString())) {
				return player.getPlayerClass();
			}
		}
		return null;
	}
}
