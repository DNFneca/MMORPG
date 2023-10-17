package me.dnfneca.plugin.Commands;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.InventoryConverter;
import me.dnfneca.plugin.utilities.ItemStackType;
import me.dnfneca.plugin.utilities.UUIDType;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import static me.dnfneca.plugin.Plugin.connection;

public class test implements CommandExecutor {

	public static NamespacedKey itemUUIDNamespaceKey = new NamespacedKey(Plugin.getInstance(), "UUID");
	public static NamespacedKey itemMetaUUIDNamespaceKey = new NamespacedKey(Plugin.getInstance(), "Inventory");
//	PacketPlayOutNamedEntitySpawn
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player player) {

			ItemStack item = player.getInventory().getItemInMainHand();

			ItemMeta itemMeta = item.getItemMeta();

			UUID uuid = UUID.randomUUID();

			Inventory inv = Bukkit.createInventory(null, 27, "Bag");

			ItemStack blue_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);

			ItemMeta itemM = blue_glass.getItemMeta();

			itemM.setDisplayName("   ");

			blue_glass.setItemMeta(itemM);

			for (int i = 0; i < 27; i++) {
				inv.setItem(i, blue_glass);
			}




//			for (int i = 0; i < inv.getSize(); i++) {
//				elo = inv.getItem(i);
//			}
//
//			try {
//				elo = JSONConvector.toJSON(blue_glass.toString());
//			} catch (IllegalAccessException e) {
//				throw new RuntimeException(e);
//			}


			itemMeta.getPersistentDataContainer().set(itemUUIDNamespaceKey, new UUIDType(), uuid);
			itemMeta.getPersistentDataContainer().set(itemMetaUUIDNamespaceKey, PersistentDataType.STRING, InventoryConverter.toBase64(inv));

			item.setItemMeta(itemMeta);

		}
		return true;
	}
}
