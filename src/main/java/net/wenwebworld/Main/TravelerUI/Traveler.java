package net.wenwebworld.Main.TravelerUI;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.wenwebworld.Main.Stat.Stat;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class Traveler {


    private Stat health = Stat.Health;
    private Stat maxHealth = Stat.MaxHealth;
    private Stat attack = Stat.Attack;
    private Stat defense = Stat.Defense;
    private Stat damage = Stat.Damage;

    private Player player;

    public Traveler (Player player) {
        this.player = player;
        getDamage().increaseValue(5);

    }

    private TextComponent actionBarString = new TextComponent("");
    private boolean hasOtherShow=false;
    public void showUIActionBar() {
        actionBarString.setText(Stat.Health.getDisplayHead()+(int)health.getValue()+"/"+maxHealth.getValue());
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,actionBarString);
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
