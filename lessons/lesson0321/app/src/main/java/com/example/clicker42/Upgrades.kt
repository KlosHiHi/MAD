package com.example.clicker42

import kotlin.math.pow

sealed class UpgradeType(val title: String){
    object ClickMultiplier: UpgradeType("Множитель нажатий")
    object AutoClick: UpgradeType("Автоклик")
    object OfflineIncome: UpgradeType("Пассивный доход")
}

data class Upgrade(
    val type: UpgradeType,
    val level: Int = 0,
    val initialValue: Double,
    val baseValue: Double,
    val valueMultiplier: Double,
    val baseCost: Double,
    val costMultiplier: Double,
) {
    fun currentCost(): Double
        = baseCost * costMultiplier.pow(level)

    fun currentValue(): Double
        = initialValue + baseValue * valueMultiplier.pow(level)

    fun next(): Upgrade
        = copy(level = level + 1)

}