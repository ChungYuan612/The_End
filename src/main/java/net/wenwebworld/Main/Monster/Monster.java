package net.wenwebworld.Main.Monster;

import net.wenwebworld.Main.Stat.Stat;
import org.bukkit.entity.Entity;

public enum Monster {
    ;
    private Stat health = Stat.Health;
    private Stat defense = Stat.Defense;
    private Stat damage = Stat.Damage;
    private String displayName;
    private Entity entity;

    Monster(
            String displayName,
            double maxHealth,
            double defense,
            double damage
    ){
        this.displayName = displayName;
        this.health.setValue(maxHealth);
        this.health.setMaxValue(maxHealth);
        this.defense.setValue(defense);
        this.damage.setValue(damage);
    }

    public void refreshDisplays() {

    }

    public Stat getHealth() {
        return health;
    }

    public Stat getDefense() {
        return defense;
    }

    public Stat getDamage() {
        return damage;
    }

    public String getDisplayName() {
        return displayName;
    }
}
