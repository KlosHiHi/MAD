package com.example.clicker42

import java.math.BigDecimal
import kotlin.math.pow

sealed class UpgradeType(val title: String){
    object ClickMultiplier: UpgradeType("Множитель нажатий")
    object AutoClick: UpgradeType("Автоклик")
    object OfflineIncome: UpgradeType("Пассивный доход")
}

data class Upgrade(
    val type: UpgradeType,
    val level: Int = 0,
    val initialValue: BigDecimal,
    val baseValue: BigDecimal,
    val valueMultiplier: BigDecimal,
    val baseCost: BigDecimal,
    val costMultiplier: BigDecimal,
) {
    fun currentCost(): BigDecimal = baseCost * costMultiplier.pow(level)
    fun currentValue(): BigDecimal = initialValue + baseValue * valueMultiplier.pow(level)

    fun next(): Upgrade = copy(level = level + 1)
}