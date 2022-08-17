package net.wenwebworld.Main.Stat;

import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;

public class Traveler extends Creature{

    private Player player;
    Traveler (Player player) {
        this.player = player;
        getDamage().setValue(5);
        this.getHealth().setOnStatChangeListener(new OnStatChangeListener() {
            @Override
            public void onStatChange(Stat stat) {
                if(stat.getValue() <=0){
                    player.setHealth(0);
                }
            }
        });
    }
    public void playHurtAnimation() {
        player.playEffect(EntityEffect.HURT);
    }

}
