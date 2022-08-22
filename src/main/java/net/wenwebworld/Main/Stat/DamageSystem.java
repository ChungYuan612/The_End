package net.wenwebworld.Main.Stat;

import net.minecraft.world.item.ItemCooldown;
import net.wenwebworld.Main.TravelerUI.Traveler;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import static net.wenwebworld.Main.TheEnd.players;

public class DamageSystem {
    //因為現在怪物沒有數值才這樣寫
    public static DamageIconShowData Damage(LivingEntity damager, LivingEntity entity){

        if (damager instanceof Player) {
            Player player = (Player) damager;
            Traveler traveler = players.get(player);
            traveler.refreshUIStatForDamage();
            entity.damage(traveler.getDamage().getValue());//這未來要修改

            //System.out.println("damage: "+traveler.getDamage().getValue());

            return new DamageIconShowData(entity.getLocation(), traveler.getDamage().getValue(), ChatColor.RED);
        }else if (entity instanceof Player) {
            Player player = (Player) entity;
            Traveler traveler = players.get(player);
            traveler.getHealth().decreaseValue(5);

            traveler.playHurtAnimation();
            player.sendRawMessage(ChatColor.RED+""+traveler.getHealth().getValue()+"/"+traveler.getMaxHealth());

            return new DamageIconShowData(player.getLocation(), 5, ChatColor.GRAY);
        }
        return new DamageIconShowData(damager.getLocation(), 0, ChatColor.GRAY);
    }

    public static DamageIconShowData Damage(LivingEntity entity, Hurt hurt) {

        //這未來要修改
        if(entity instanceof Player){

            if(players.containsKey((Player)entity)){
                players.get((Player)entity).getHealth().decreaseValue(hurt.getDamage());

                entity.playEffect(EntityEffect.HURT);
            }
        }else {
            entity.damage(hurt.getDamage());//這未來要修改
        }
        return new DamageIconShowData(entity.getLocation(), hurt.getDamage(), hurt.getColor());
    }
}

enum Hurt{
    FIRE(5, ChatColor.GOLD, EntityDamageEvent.DamageCause.FIRE),
    FIRE_TICK(3,ChatColor.GOLD, EntityDamageEvent.DamageCause.FIRE_TICK),
    LAVA(5,ChatColor.GOLD, EntityDamageEvent.DamageCause.LAVA),
    STARVATION(5,ChatColor.DARK_GREEN, EntityDamageEvent.DamageCause.STARVATION),
    HOT_FLOOR(4,ChatColor.RED, EntityDamageEvent.DamageCause.HOT_FLOOR),
    WITHER(5,ChatColor.DARK_GRAY, EntityDamageEvent.DamageCause.WITHER),
    ;
    private double damage;
    private ChatColor color;
    private EntityDamageEvent.DamageCause cause;

    Hurt(int damage, ChatColor color, EntityDamageEvent.DamageCause cause) {
        this.damage = damage;
        this.color = color;
        this.cause = cause;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public ChatColor getColor() {
        return color;
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }

    public EntityDamageEvent.DamageCause getCause() {
        return cause;
    }

    public void setCause(EntityDamageEvent.DamageCause cause) {
        this.cause = cause;
    }
}
