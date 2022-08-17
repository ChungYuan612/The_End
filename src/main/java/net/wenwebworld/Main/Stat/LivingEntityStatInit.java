package net.wenwebworld.Main.Stat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static net.wenwebworld.Main.TheEnd.players;

public class LivingEntityStatInit implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        players.put(event.getPlayer(),new Traveler());
        event.setJoinMessage("Welcome, " + event.getPlayer().getDisplayName());
    }
    //@EventHandler
    public void onMobSpawn(){

    }
}
