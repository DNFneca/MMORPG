package me.dnfneca.plugin.utilities.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum ItemStats {
	;

	public static final String[][] RegisteredReforges = new String[100][2];

//    public static String[] Weapon(PlayerStats p) {
//        String[] data = new String[10];
//        Player player = p.getPlayer();
//
//        int itemSlot = player.getInventory().getHeldItemSlot();
//
//        ItemStack Item = player.getInventory().getItem(itemSlot);
//
//        if(Item == null) {
//            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//        }
//
//
//        if(Check.ExistingStats(Item.getItemMeta())[7].equals("Helmet") || Check.ExistingStats(Item.getItemMeta())[7].equals("Chestplate") || Check.ExistingStats(Item.getItemMeta())[7].equals("Leggings") || Check.ExistingStats(Item.getItemMeta())[7].equals("Boots")) {
//            return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//        }
//
////        if(p.getInventory().getItem(itemSlot) != null && p.getInventory().getItem(itemSlot).getItemMeta() != null) {
////            ItemMeta itemMeta = Item.getItemMeta();
////            data = Check.ExistingStats(itemMeta);
////            if(Check.ExistingStats(itemMeta) == null) {
////                return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
////            } else if (Check.ExistingStats(Item.getItemMeta())[7].equals("Helmet") || Check.ExistingStats(Item.getItemMeta())[7].equals("Chestplate") || Check.ExistingStats(Item.getItemMeta())[7].equals("Leggings") || Check.ExistingStats(Item.getItemMeta())[7].equals("Boots")) {
////                return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
////            }
////        }
//
//
//
//        return data;
//    }

	public static String[] WeaponReforge(final Player p) {
		String[] data = new String[10];
		for (int i = 0; 42 > i; i++) {

		}
		final int itemSlot = p.getInventory().getHeldItemSlot();

		final ItemStack Item = p.getInventory().getItem(itemSlot);

		if (null == Item) {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		}
		if (null != Item.getItemMeta()) {
			final ItemMeta itemMeta = Item.getItemMeta();
			final String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
			data = ItemStats.DetermineReforge(ItemStringArray[0]);
//            System.out.println(data);
		}
		return data;
	}

	public static String[] WeaponReforge(final Player p, final int ItemSlot) {
		String[] data = new String[10];
		String[] data2 = new String[10];
		for (int i = 0; 42 > i; i++) {

		}

		final ItemStack Item = p.getInventory().getItem(ItemSlot);

		if (null == Item) {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		}
		if (null != Item.getItemMeta()) {
			final ItemMeta itemMeta = Item.getItemMeta();
			final String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
			data = ItemStats.DetermineReforge(itemMeta.getDisplayName());
			data2 = ItemStats.DetermineArmorReforge(itemMeta.getDisplayName());
			int i = 0;
			for (final String s : data) {
				data[i] = String.valueOf(Integer.parseInt(s) + Integer.parseInt(data2[i]));
				i++;
			}
//            System.out.println(data);
		}
		return data;
	}

	//            health
	//            damage
	//            defence
	//            strength
	//            mana +
	//            critdamage
	//            critchance
	//            heal per second
	//            Mana Cost
	public static String[] DetermineReforge(final String ItemName) {
		final String[] ItemStringArray = ItemName.split(" ");
		final String PotentialReforge = ItemStringArray[0];

		if (PotentialReforge.contains("Sharp")) {
			return new String[]{"0", "5", "0", "5", "0", "0", "0", "0", "0", "0"};
		} else if (PotentialReforge.contains("Lucky")) {
			return new String[]{"0", "0", "0", "0", "0", "4", "6", "0", "0", "0"};
		} else if (PotentialReforge.contains("Enchanted")) {
			return new String[]{"0", "0", "0", "0", "6", "0", "6", "0", "0", "0"};
		} else if (PotentialReforge.contains("Light")) {
			return new String[]{"0", "-2", "0", "5", "0", "0", "6", "0", "0", "0"};
		} else if (PotentialReforge.contains("Strong")) {
			return new String[]{"0", "15", "0", "7", "0", "0", "0", "0", "0", "0"};
		} else {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		}
	}

	public static String[] DetermineArmorReforge(final String ItemName) {
		final String[] ItemStringArray = ItemName.split(" ");
		final String PotentialReforge = ItemStringArray[0];

		if (PotentialReforge.contains("Reinforced")) {
			return new String[]{"0", "0", "0", "7", "0", "5", "0", "0", "0", "0"};
		} else if (PotentialReforge.contains("Smart")) {
			return new String[]{"0", "-2", "0", "5", "50", "0", "6", "0", "0", "0"};
		} else if (PotentialReforge.contains("Very")) {
			return new String[]{"0", "-2", "0", "5", "100", "0", "6", "0", "0", "0"};
		} else {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		}
	}

	public static String[] Armor(final Player p, final int ItemSlot) {
		final String[] data = new String[10];
		int ArmorSlot = 0;
		switch (ItemSlot) {
			case 1:
				ArmorSlot = 39;
				break;
			case 2:
				ArmorSlot = 38;
				break;
			case 3:
				ArmorSlot = 37;
				break;
			case 4:
				ArmorSlot = 36;
				break;
		}
//        assert ArmorSlot != null;
//        ItemMeta itemSlot = ArmorSlot.getItemMeta();
		final ItemStack Item = p.getInventory().getItem(ArmorSlot);

//        System.out.println(Item + " " + Item.getItemMeta());

		if (null == Item) {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		} else if (null != p.getInventory().getItem(ArmorSlot) && null != p.getInventory().getItem(ArmorSlot).getItemMeta()) {
			final ItemMeta itemMeta = Item.getItemMeta();
//            data = Objects.requireNonNull(Check.ExistingStats(itemMeta));
//            ArmorSlot
		}

		return data;
	}

	public static String[] WeaponEnchantment(final Player p, final int ItemSlot) {
		String[] data = new String[10];
		String[] data2 = new String[10];
		for (int i = 0; 42 > i; i++) {

		}

		final ItemStack Item = p.getInventory().getItem(ItemSlot);

		if (null == Item) {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		}
		if (null != Item.getItemMeta()) {
			final ItemMeta itemMeta = Item.getItemMeta();
			final String[] ItemStringArray = itemMeta.getDisplayName().split(" ");
			data = ItemStats.DetermineReforge(itemMeta.getDisplayName());
			data2 = ItemStats.DetermineArmorReforge(itemMeta.getDisplayName());
			int i = 0;
			for (final String s : data) {
				data[i] = String.valueOf(Integer.parseInt(s) + Integer.parseInt(data2[i]));
				i++;
			}
//            System.out.println(data);
		}
		return data;
	}

	//    TODO make weapon enchantments it's almost done anyways
	public static String[] getWeaponEnchantment(final String itemName) {
		final String[] ItemStringArray = itemName.split(" ");
		final String PotentialReforge = ItemStringArray[0];

		if (PotentialReforge.contains("Sharp")) {
			return new String[]{"0", "5", "0", "5", "0", "0", "0", "0", "0", "0"};
		} else if (PotentialReforge.contains("Lucky")) {
			return new String[]{"0", "0", "0", "0", "0", "4", "6", "0", "0", "0"};
		} else if (PotentialReforge.contains("Enchanted")) {
			return new String[]{"0", "0", "0", "0", "6", "0", "6", "0", "0", "0"};
		} else if (PotentialReforge.contains("Light")) {
			return new String[]{"0", "-2", "0", "5", "0", "0", "6", "0", "0", "0"};
		} else if (PotentialReforge.contains("Strong")) {
			return new String[]{"0", "15", "0", "7", "0", "0", "0", "0", "0", "0"};
		} else {
			return new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		}
	}


//    public static String[] Armor(Player p) {
//
//
//        return get();
//    }
//    public static String[] All(Player p) {
//
//
//        return get();
//    }
}