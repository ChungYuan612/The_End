package net.wenwebworld.Main.Stat;

public abstract class Creature {
    private Stat health = Stat.Health;
    private Stat maxHealth = Stat.MaxHealth;
    private Stat defense = Stat.Defense;
    private Stat Damage = Stat.Damage;

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
        return Damage;
    }

    public void setDamage(Stat damage) {
        Damage = damage;
    }
}
