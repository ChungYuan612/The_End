package net.wenwebworld.Main.TravelerUI;

import net.wenwebworld.Main.TheEnd;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import static net.wenwebworld.Main.TheEnd.players;

public class PlayerUIHandler {
    private TheEnd plugin;

    public PlayerUIHandler(TheEnd plugin) {
        this.plugin = plugin;
        initActionBar();
    }

    private void initActionBar() {
        new BukkitRunnable(){
            @Override
            public void run() {
                for(Player player : players.keySet()){
                    Traveler traveler = players.get(player);
                    traveler.showUIActionBar();
                }
            }
        }.runTaskTimer(plugin,0L,5L);
    }

}
