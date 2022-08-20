package me.dnfneca.plugin.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import static org.bukkit.Sound.BLOCK_NOTE_BLOCK_BELL;

public class FishingListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerFishEvent e) {


        e.getPlayer().sendMessage(e.getState().toString());
        Player p = e.getPlayer();
        Location pLoc = p.getLocation();
        if (e.getState().name() == "BITE") {
            e.getPlayer().playSound(pLoc, BLOCK_NOTE_BLOCK_BELL, 1, 1);
        }
    }
}