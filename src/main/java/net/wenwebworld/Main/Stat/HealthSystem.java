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
            DamageIcon.showIcon(entity.getLocation(), hurt.getDamage(), hurt.getColor());
            break;
        }
        if(cause.equals(EntityDamageEvent.DamageCause.CUSTOM)) return;

        event.setCancelled(true);

    }
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof LivingEntity && event.getEntity() instanceof LivingEntity)) return;
        DamageIconShowData data = Damage((LivingEntity) event.getDamager(), (LivingEntity) event.getEntity());
        DamageIcon.showIcon(data.getLocation(), data.getDamage(), data.getColor());
        event.setCancelled(true);
    }
}
