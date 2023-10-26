package me.dnfneca.plugin.Commands;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.Dungeons.Dungeon;
import me.dnfneca.plugin.utilities.Guild.CreateNew;
import me.dnfneca.plugin.utilities.InventoryConverter;
import me.dnfneca.plugin.utilities.ItemStackType;
import me.dnfneca.plugin.utilities.UUIDType;
import me.dnfneca.plugin.utilities.managers.Item.Item;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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

import java.io.IOException;
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

			new Dungeon(args[0], player.getLocation());

//			CreateNew.Guild(args[0], args[1]);


		}
		return true;
	}
}
