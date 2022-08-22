package net.wenwebworld.Main.TravelerUI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static net.wenwebworld.Main.TheEnd.players;

public class PlayerDeath implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if(players.containsKey(player)) {
            Traveler traveler = players.get(player);
            traveler.setPlayerHealth(traveler.getMaxHealth());

        }
    }
}
