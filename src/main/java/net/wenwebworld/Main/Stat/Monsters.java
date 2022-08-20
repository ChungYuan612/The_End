package net.wenwebworld.Main.Stat;

import org.bukkit.entity.Entity;

public enum Monsters {
    ;
    private Stat health = Stat.Health;
    private Stat maxHealth = Stat.MaxHealth;
    private Stat defense = Stat.Defense;
    private Stat damage = Stat.Damage;
    private String displayName;
    private Entity entity;

    Monsters(
            String displayName,
            double maxHealth,
            double defense,
            double damage
    ){
        this.displayName = displayName;
        this.health.setValue(maxHealth);
        this.maxHealth.setValue(maxHealth);
        this.defense.setValue(defense);
        this.damage.setValue(damage);
    }

    public void refreshDisplays() {

    }

    public Stat getHealth() {
        return health;
    }

    public Stat getMaxHealth() {
        return maxHealth;
    }

    public Stat getDefense() {
        return defense;
    }

    public Stat getDamage() {
        return damage;
    }

}
