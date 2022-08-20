package net.wenwebworld.Main;

import net.wenwebworld.Main.Stat.DamageIcon;
import net.wenwebworld.Main.Stat.HealthSystem;
import net.wenwebworld.Main.Stat.LivingEntityStatInit;
import net.wenwebworld.Main.TravelerUI.Traveler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class TheEnd extends JavaPlugin {

    public static HashMap<Player, Traveler> players = new HashMap<>();
    @Override
    public void onEnable() {
        new DamageIcon(this).start();
        getServer().getPluginManager().registerEvents(new HealthSystem(),this);
        getServer().getPluginManager().registerEvents(new LivingEntityStatInit(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
