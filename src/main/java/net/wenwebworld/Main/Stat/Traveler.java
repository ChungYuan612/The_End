package net.wenwebworld.Main.Stat;

import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;

public class Traveler {
    private Stat health = Stat.Health;
    private Stat maxHealth = Stat.MaxHealth;
    private Stat attack = Stat.Attack;
    private Stat defense = Stat.Defense;
    private Stat damage = Stat.Damage;

    private Player player;
    Traveler (Player player) {
        this.player = player;
        getDamage().increaseValue(5);
    }
    public void playHurtAnimation() {
        player.playEffect(EntityEffect.HURT);
    }


    public Stat getHealth() {
        return health;
    }

    public void setHealth(Stat health) {
        this.health = health;
    }

    public Stat getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Stat maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Stat getDefense() {
        return defense;
    }

    public void setDefense(Stat defense) {
        this.defense = defense;
    }

    public Stat getDamage() {
        return damage;
    }

    public void setDamage(Stat damage) {
        this.damage = damage;
    }

}
