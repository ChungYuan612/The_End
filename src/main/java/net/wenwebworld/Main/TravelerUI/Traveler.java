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
    private Stat maxHealth = Stat.MaxHealth;
    private Stat attack = Stat.Attack;
    private Stat defense = Stat.Defense;
    private Stat damage = Stat.Damage;
    private Stat mana = Stat.Mana;
    private Stat maxMana = Stat.MaxMana;

    private Player player;

    public Traveler (Player player) {
        this.player = player;
    }

    private TextComponent actionBarString = new TextComponent("");
    private boolean hasOtherShow=false;
    public void showUIActionBar() {
        String healthText = health.getColor()+""+(int)health.getValue()+"/"+(int)maxHealth.getValue()+Stat.Health.getDisplayHead();
        String mediumText = "";
        String manaText = mana.getColor()+""+(int)mana.getValue()+"/"+(int)maxMana.getValue()+Stat.Mana.getDisplayHead();
        actionBarString.setText(healthText+" "+manaText);
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

    public void setPlayerHealth(double health) {
        this.health.setValue(health);
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

    public void refreshUIStatForDamage() {
        try{
            if(player.getInventory().getItemInMainHand().equals(new ItemStack(Material.NETHERITE_SWORD))){
                damage.setValue(7);
            }else{
                damage.setValue(1);
            }
        }catch (Exception exception) {}
    }
}
