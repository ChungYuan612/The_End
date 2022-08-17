package net.wenwebworld.Main.Stat

import org.bukkit.ChatColor
import org.bukkit.Location

data class DamageIconShowData(
    val location: Location,
    val damage:Double,
    val color: ChatColor
)
