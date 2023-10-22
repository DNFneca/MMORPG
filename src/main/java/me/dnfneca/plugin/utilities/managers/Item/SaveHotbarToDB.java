package me.dnfneca.plugin.utilities.managers.Item;

import me.dnfneca.plugin.utilities.InventoryConverter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static me.dnfneca.plugin.Plugin.connection;

public class SaveHotbarToDB {

	public static void SaveHotbarToDB(Player player, Inventory inventory) {
		Statement statement = null;

		Inventory playerInventory = inventory;


		ItemStack[] insert = new ItemStack[8];

		for(int i = 0; i < 8; i++) {
			insert[i] = playerInventory.getItem(i);
		}

		String hotbar = InventoryConverter.itemStackArrayToBase64(insert);

		try {
			statement = connection.createStatement();
			statement.execute("INSERT IGNORE INTO `player inventories` (UUID, Inventory) VALUES ('" + player.getUniqueId() + "','" + hotbar + "')");

			statement.execute("UPDATE `player inventories` SET `Inventory` = '" + hotbar + "' WHERE `UUID` = '" + player.getUniqueId() + "'");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
