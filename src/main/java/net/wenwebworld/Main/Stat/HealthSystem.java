package net.wenwebworld.Main.Stat;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import static net.wenwebworld.Main.Stat.DamageSystem.Damage;
import static net.wenwebworld.Main.Stat.Stat.Attack;

public class HealthSystem implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        EntityDamageEvent.DamageCause cause = event.getCause();
        Entity entity = event.getEntity();

        if (!(entity instanceof LivingEntity)) return;

        for(Hurt hurt: Hurt.values()) {
            if(!cause.equals(hurt.getCause()))
                continue;
            Damage(cause, (LivingEntity) entity,hurt);
            break;
        }

        event.setCancelled(true);
    }
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof LivingEntity || event.getEntity() instanceof LivingEntity)) return;
        Damage((LivingEntity) event.getDamager(), (LivingEntity) event.getEntity());
        event.setCancelled(true);
    }
}
