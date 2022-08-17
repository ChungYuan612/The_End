package net.wenwebworld.Main.Stat;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public enum Stat implements StatFrame {

    Health("血量", 100, "❤", ChatColor.RED, Integer.MAX_VALUE, 0),
    MaxHealth("血量上限", 100, "❤", ChatColor.RED, Integer.MAX_VALUE, 0),
    Defense("防禦力", 0, "❈", ChatColor.GREEN, Integer.MAX_VALUE, 0),
    Attack("攻擊力", 0, "❁", ChatColor.RED, Short.MAX_VALUE, 0),
    AttackSpeed("攻擊速度", 100, "⚔", ChatColor.AQUA, 200, 0, "%"),
    CritChance("爆擊機率", 5, "☣", ChatColor.YELLOW, 100, -100),
    CritDamage("爆擊傷害", 50, "☠", ChatColor.YELLOW, Short.MAX_VALUE, 0, "%"),
    Speed("速度", 100, "✦", ChatColor.WHITE, 500, 0, "%"),
    HealBouns("治療加成", 0, "❤", ChatColor.LIGHT_PURPLE, Short.MAX_VALUE, 0, "%"),
    Damage("傷害", 0, "❁", ChatColor.RED, Integer.MAX_VALUE, 0),
    //MobDamage("怪物傷害", 0, "❁", ChatColor.RED, Integer.MAX_VALUE, 0),
    Luck("幸運", 0, "✧", ChatColor.DARK_AQUA, Short.MAX_VALUE, 0);

    public static HashMap<Integer,OnStatChangeListener> StatChangeListeners = new HashMap<>();

    private double value;
    private String icon, unit, name;
    private ChatColor color;
    private double max, min;
    private OnStatChangeListener listener;

    Stat(String name, double value, String icon, ChatColor color, double max, double min, String unit) {
        this.name = name;
        this.value = value;
        this.icon = icon;
        this.color = color;
        this.max = max;
        this.min = min;
        this.unit = unit;
    }

    Stat(String name, double value, String icon, ChatColor color, double max, double min) {
        this.name = name;
        this.value = value;
        this.icon = icon;
        this.color = color;
        this.max = max;
        this.min = min;
        this.unit = "";
    }

    public double getValue() {
        return value;
    }

    public boolean setValue(double value) {
        this.value = value;
        notifyStatChange();
        return isOutside();
    }

    @Override
    public boolean decreaseValue(double value) {
        this.value -= value;
        notifyStatChange();
        return isOutside();
    }

    @Override
    public boolean increaseValue(double value) {
        this.value += value;
        notifyStatChange();
        return isOutside();
    }

    @Override
    public String getDisplayHead() {
        return getColor() + getIcon();
    }

    @Override
    public String getDisplayText() {
        return getDisplayHead() + " " + (int) getValue() + " " + getUnit();
    }

    private boolean isOutside() {
        if (value > getMaxValue())
            value = getMaxValue();
        else if (value < getMinValue())
            value = getMinValue();
        else
            return false;
        return true;
    }

    @Override
    public ChatColor getColor() {
        return color;
    }

    @Override
    public double getMaxValue() {
        return max;
    }

    @Override
    public double getMinValue() {
        return min;
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    static List<Stat> getDisplayStats() {
        return Arrays.asList(
                Stat.Health,
                Stat.Defense,
                Stat.Attack,
                Stat.AttackSpeed,
                Stat.CritChance,
                Stat.CritDamage,
                Stat.Speed
        );
    }

    private void notifyStatChange(){
        if(listener !=null)
            listener.onStatChange(this);
    }
    public void setOnStatChangeListener(OnStatChangeListener listener){
        this.listener = listener;
    }
}

interface OnStatChangeListener{
    void onStatChange(Stat stat);
}

