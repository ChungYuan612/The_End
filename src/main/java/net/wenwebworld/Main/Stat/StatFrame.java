package net.wenwebworld.Main.Stat;

import org.bukkit.ChatColor;

public interface StatFrame {

    /**
     * @return 數值顯示在UI上的圖案
     */
    String getIcon();

    /**
     * @return 數值顯示在UI的顏色
     */
    ChatColor getColor();

    /**
     * @return UI介面的文字開頭
     */
    String getDisplayHead();

    /**
     * @return 該數值顯示在玩家UI上的字串
     */
    String getDisplayText();

    /**
     * @return 數值範圍的最大值
     */
    double getMaxValue();

    /**
     * @return 數值範圍的最小值
     */
    double getMinValue();

    /**
     * 如果回傳true 該方法仍有效(會減少value至最小範圍)
     *
     * @param value 欲減數值
     * @return 超過數值範圍
     */
    boolean decreaseValue(double value);

    /**
     * 如果回傳true 該方法仍有效(會增加value至最大範圍)
     *
     * @param value 欲加數值
     * @return 超過數值範圍
     */
    boolean increaseValue(double value);

    /**
     * @return 該數值大小
     */
    double getValue();

    /**
     * 設定數值大小
     *
     * @param value 數值
     * @return 是否出錯(超過數值大小)
     */
    boolean setValue(double value);

    /**
     * @return 該數值的單位
     */
    String getUnit();

    /**
     * @return 數值的中文名稱
     */
    String getName();
}

