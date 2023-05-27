package me.dnfneca.plugin.Abilities;

import me.dnfneca.plugin.utilities.managers.Item.Item;
import me.dnfneca.plugin.utilities.managers.Statistics.PlayerStats;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import static me.dnfneca.plugin.Plugin.CustomItems;

public enum Teleport {
	;

	public static boolean Teleport(PlayerStats p, float distance, float cost) {
		Player player = p.getPlayer();
		Location playerLoc = player.getLocation();
		Location destination = playerLoc.clone().add(playerLoc.getDirection().multiply(distance));
		if(checkForBlocks(playerLoc, destination)) {
			p.removeMana(cost);
			p.setManaSpent(cost);
			p.setManaTimer(6);
			player.teleport(destination);
			player.setVelocity(new Vector(0, 0.1, 0));
			return true;
		} else {
			player.spigot().sendMessage(
					ChatMessageType.SYSTEM,
					new TextComponent(ChatColor.RED + "BLOCKS IN THE WAY"));
			return false;
		}
	}
	private static boolean checkForBlocks(Location loc1, Location loc2) {
		World world = loc1.getWorld();
		Vector direction = loc2.toVector().subtract(loc1.toVector()).normalize();
		double distance = loc1.distance(loc2);
		RayTraceResult result = world.rayTraceBlocks(loc1, direction, distance, FluidCollisionMode.ALWAYS, false);
		return null == result || null == result.getHitBlock();
	}

}
