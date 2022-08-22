package net.wenwebworld.Main.TravelerUI;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.wenwebworld.Main.Stat.Stat;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;

import static net.wenwebworld.Main.Const.color;

public class Traveler {

    private Stat health = Stat.Health;
    private Stat attack = Stat.Attack;
    private Stat defense = Stat.Defense;
    private Stat damage = Stat.Damage;
    private Stat mana = Stat.Mana;

    private Player player;

    public Traveler (Player player) {
        this.player = player;

    }

    private TextComponent actionBarString = new TextComponent("");
    private boolean hasOtherShow=false;
    public void showUIActionBar() {
        String healthText = health.getColor()+""+(int)health.getValue()+"/"+(int)health.getMaxValue()+Stat.Health.getDisplayHead();
        String mediumText = "   ";
        String manaText = mana.getColor()+""+(int)mana.getValue()+"/"+(int)mana.getMaxValue()+Stat.Mana.getDisplayHead();
        actionBarString.setText(healthText+" "+manaText);
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,actionBarString);
    }

    public void playHurtAnimation() {
        player.playEffect(EntityEffect.HURT);
    }

    public Stat getHealth() {
        return health;
    }

    public void setPlayerHealth(double health) {
        this.health.setValue(health);
    }

    public double getMaxHealth() {
        return health.getMaxValue();
    }

    public Stat getDefense() {
        return defense;
    }

    public Stat getDamage() {
        return damage;
    }


    public void refreshUIStatForDamage() {
        //未來要改
        try{
            if(player.getInventory().getItemInMainHand().equals(new ItemStack(Material.NETHERITE_SWORD))){
                damage.setValue(7);
            }else{
                damage.setValue(1);
            }
        }catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void defaultRegeneration(){
        if(health.getValue() < getMaxHealth()){
            double heal = getMaxHealth()*0.03;
            this.health.increaseValue(heal);
        }
    }
}
