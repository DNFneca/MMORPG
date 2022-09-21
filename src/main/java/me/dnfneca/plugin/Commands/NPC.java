package me.dnfneca.plugin.Commands;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.dnfneca.plugin.Plugin;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutNamedEntitySpawn;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.server.network.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.UUID;

import static me.dnfneca.plugin.Plugin.npcs;

public class NPC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
            WorldServer world = ((CraftWorld) Objects.requireNonNull(player.getLocation().getWorld())).getHandle();
            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "12345");
            String texture = "ewogICJ0aW1lc3RhbXAiIDogMTY2MjQ5ODk3Nzg0OSwKICAicHJvZmlsZUlkIiA6ICJiYzRlZGZiNWYzNmM0OGE3YWM5ZjFhMzlkYzIzZjRmOCIsCiAgInByb2ZpbGVOYW1lIiA6ICI4YWNhNjgwYjIyNDYxMzQwIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2MxOGRlZTViZjZlMDMwZTY5YTE2YmU4YTU5ZmJmYTMyMWNmMWI1MGMwOTc0MmE0NGM2NjIxOTZlZmFjOTYyOTYiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==";
            String signiture = "ofjjngH1DpPI6Ca1XVNVYWq61neiFHMv5i5d+EY9gb6WmZdN36FmkUSY/1EImUJ8Y0t0fiKCnzAC/D8gXPB3p5gp7Y24UPGBhVLWPZmUolvhFsOvijVhNa8HxEx3eu3EruVLPLHriwHiLf/RM/hv3EkuPGHpUD+FdBjuROmWdU84cLaWQKACkDBJcwQj+H+hh0tVoqCtTxbHnMCm+Y2rEzGdGOpP4wSvuRZyPP2Xg2gY9iIFBc35Cs/FkhIE4qxcxaLWqJvdo23dGuxetw7zkP8pSMMYE+ldy6lumw2H9d1WeWwoKDcDvftTckW2JqTke0VR7CVQrdxxZxfImZkV7/fuFyve3bj4UaPiP33z4z/9Lrm2xgy6i2l09cTtuKwzPNu/hf/tyKwSnMShMLotwvke7MPMRt94z9RWbuK7UuYIusbER/gvvVBZ92vZcZJvM2tUvMmot73I0h0umgZWeXVHVWDX0aIU1/7dHu7k4UFI1FJZY47RemBjoDJj4mYMZzWwqeGjkfDv+26KZrRumFSDD+o0i9PaiRtbGXKojE/h3trA1jER+pEcDF/Q69DBK7g5SnRpd8Bos1TDr1DlH2UDMrd3SXyna3cIE0A5tRlIE8B1XEeL5Uq47AblhDQNmwo5HY8xX/pFLcQ8P4ZumkyUY+R/KSQvMB8VlIC8XS0=";
            gameProfile.getProperties().put("textures", new Property("textures", texture, signiture));
            EntityPlayer npcPlayer = new EntityPlayer(server, world, gameProfile);
            npcPlayer.b(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
            npcs.add(npcPlayer);
            Location location = npcPlayer.getBukkitEntity().getLocation();
            for(Player p : Bukkit.getOnlinePlayers()) {
                PlayerConnection connection = ((CraftPlayer)p).getHandle().b;
                connection.a(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, npcPlayer));
                connection.a(new PacketPlayOutNamedEntitySpawn(npcPlayer));
//                connection.a(new PacketPlayOutEntityHeadRotation(npcPlayer, (byte) (player.getLocation().getYaw() * 256 / 360)));
            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        location.setDirection(p.getPlayer().getLocation().subtract(location).toVector());
                        PlayerConnection connection = ((CraftPlayer)p).getHandle().b;

                        connection.a(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.e, npcPlayer));
                        connection.a(new PacketPlayOutEntityHeadRotation(npcPlayer, (byte) ((location.getYaw()%360) * 256 / 360)));
                        connection.a(new PacketPlayOutEntity.PacketPlayOutEntityLook(npcPlayer.getBukkitEntity().getEntityId(), (byte) ((location.getYaw()%360) * 256 / 360), (byte) ((location.getPitch()%360) * 256 / 360), true));
                    }
                }
            }.runTaskTimer(Plugin.getInstance(), 0L, 1L);
        }
        return true;
    }
}
