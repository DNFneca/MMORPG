package me.dnfneca.plugin.Commands;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.dnfneca.plugin.Plugin;
import me.dnfneca.plugin.utilities.NPC.MyTrait;
import me.dnfneca.plugin.utilities.managers.Mayors.Mayor;
import me.dnfneca.plugin.utilities.managers.Mayors.util.RunMayorEventRunEvent;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import me.dnfneca.plugin.utilities.managers.Towns.Town;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftOcelot;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.UUID;

import static me.dnfneca.plugin.Plugin.*;
import static org.bukkit.entity.EntityType.PLAYER;

public class test implements CommandExecutor {

//	PacketPlayOutNamedEntitySpawn
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player player) {

			new Town(args[0], player.getLocation(), Integer.valueOf(args[1]), args[2]);

			for (Town town : Towns) {
				player.sendMessage(town.getTownName());
			}

			Statement statement;
			if(connection != null) {
				try {
					statement = connection.createStatement();
					statement.execute("INSERT INTO `towns` SET `Name` = '" + args[0] + "', `x`= '" + (int) player.getLocation().getX() + "', `y`= '" + (int) player.getLocation().getY() + "', `z`= '" + (int) player.getLocation().getZ() + "', `Distance` = " + args[1] + ", `Mayor` = '" + args[2] + "'");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}



		}
		return true;
	}
}
