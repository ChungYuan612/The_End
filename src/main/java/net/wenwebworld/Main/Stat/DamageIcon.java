package net.wenwebworld.Main.Stat;

import net.wenwebworld.Main.TheEnd;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Consumer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static net.wenwebworld.Main.Const.color;

public class DamageIcon {
    private static DecimalFormat format = new DecimalFormat("#.#");
    private boolean isSetUp = false;
    private TheEnd plugin;

    public DamageIcon(TheEnd plugin) {
        this.plugin = plugin;
        isSetUp = false;
    }

    public void start() {
        if(isSetUp) return;
        new BukkitRunnable(){
            Set<Entity> damageKeySet = damageIcons.keySet();
            List<Entity> removeEntitys = new ArrayList<>();
            @Override
            public void run() {
                for(Entity damageIcon: damageKeySet){
                    int timeLeft = damageIcons.get(damageIcon);
                    if(timeLeft <=0){
                        damageIcon.remove();
                        removeEntitys.add(damageIcon);
                        continue;
                    }
                    timeLeft--;
                    damageIcons.put(damageIcon,timeLeft);
                }
                damageKeySet.removeAll(removeEntitys);
            }
        }.runTaskTimer(plugin,0L,1L);
        isSetUp = true;
    }

    public static HashMap<Entity, Integer> damageIcons = new HashMap<>();

    public static Entity showIcon(Location location, double damage, ChatColor color) {
        return location.getWorld().spawn(
                location.add(getRandomOffset(), 1, getRandomOffset()),
                ArmorStand.class, new Consumer<ArmorStand>() {
                    @Override
                    public void accept(ArmorStand armorStand) {
                        armorStand.setMarker(true);
                        armorStand.setVisible(false);
                        armorStand.setGravity(false);
                        armorStand.setSmall(true);
                        armorStand.setCustomNameVisible(true);
                        armorStand.setCustomName(color(color + format.format(damage)));
                        damageIcons.put(armorStand, 20);
                    }
                }
        );

    }

    public static Entity showIcon(DamageIconShowData data) {
        return data.getLocation().getWorld().spawn(
                data.getLocation().add(getRandomOffset(), 1, getRandomOffset()),
                ArmorStand.class, new Consumer<ArmorStand>() {
                    @Override
                    public void accept(ArmorStand armorStand) {
                        armorStand.setMarker(true);
                        armorStand.setVisible(false);
                        armorStand.setGravity(false);
                        armorStand.setSmall(true);
                        armorStand.setCustomNameVisible(true);
                        armorStand.setCustomName(color(data.getColor() + format.format(data.getDamage())));
                        damageIcons.put(armorStand, 20);
                    }
                }
        );

    }
    private static double getRandomOffset () {
        double temp =  Math.random();
        if (Math.random() > 0.50d) temp *= -1;
        return temp;
    }

    public DecimalFormat getFormat() {
        return format;
    }

    public void setFormat(DecimalFormat format) {
        this.format = format;
    }

    public boolean isSetUp() {
        return isSetUp;
    }

    public void setSetUp(boolean setUp) {
        isSetUp = setUp;
    }

    public TheEnd getPlugin() {
        return plugin;
    }

    public void setPlugin(TheEnd plugin) {
        this.plugin = plugin;
    }
}
