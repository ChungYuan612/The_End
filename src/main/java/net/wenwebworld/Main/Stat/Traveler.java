package net.wenwebworld.Main.Stat;

import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;

public class Traveler extends Creature{

    private Player player;
    Traveler (Player player) {
        this.player = player;
        getDamage().setValue(5);
    }
    public void playHurtAnimation() {
        player.playEffect(EntityEffect.HURT);
    }

}
