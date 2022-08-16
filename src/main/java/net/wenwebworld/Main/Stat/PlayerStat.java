package net.wenwebworld.Main.Stat;

import org.bukkit.ChatColor;

public enum PlayerStat {
    ;

    private double value;
    private String icon;
    private double baseValue,maxLimit,minLimit;
    private ChatColor statColor;

    PlayerStat(String icon, double baseValue, double maxLimit, double minLimit, ChatColor statColor) {
        this.icon = icon;
        this.baseValue = baseValue;
        this.maxLimit = maxLimit;
        this.minLimit = minLimit;
        this.statColor = statColor;
        value = baseValue;
    }

    public String getIcon() {
        return icon;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public double getMaxLimit() {
        return maxLimit;
    }

    public double getMinLimit() {
        return minLimit;
    }

    public ChatColor getStatColor() {
        return statColor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
