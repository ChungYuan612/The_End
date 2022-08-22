package net.wenwebworld.Main.Stat;

import net.wenwebworld.Main.TravelerUI.Traveler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static net.wenwebworld.Main.TheEnd.players;

public class LivingEntityStatInit implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        players.put(event.getPlayer(),new Traveler(event.getPlayer()));
        players.get(event.getPlayer()).getHealth().setOnStatChangeListener(
                stat -> {
                    if(stat.getValue() <=0){
                        event.getPlayer().setHealth(0);
                    }
                });

        event.setJoinMessage("Welcome, " + event.getPlayer().getDisplayName());
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        if(players.containsKey(event.getPlayer()) ){
            players.remove(event.getPlayer());
        }
    }
}
