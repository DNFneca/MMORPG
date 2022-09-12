package me.dnfneca.plugin.Commands;

import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.network.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import static me.dnfneca.plugin.Plugin.npcs;

public class deleteEveryNPC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            PlayerConnection connection = ((CraftPlayer)p).getHandle().b;
            for (EntityPlayer e : npcs) {
                connection.a(new PacketPlayOutEntityDestroy(e.getBukkitEntity().getEntityId()));
            }
        }
        return true;
    }
}
