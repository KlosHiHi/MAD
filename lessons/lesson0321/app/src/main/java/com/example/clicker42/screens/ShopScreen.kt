package com.example.clicker42.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clicker42.ApplicationLifetimeObserver
import com.example.clicker42.GameViewModel
import com.example.clicker42.ui.theme.formatNumber
import kotlin.collections.component1
import kotlin.collections.component2

@Composable
fun ShopScreen(vm: GameViewModel) {
    Column(Modifier.fillMaxSize()) {
        vm.upgrades.forEach { (type, upgrade) ->
            Card(Modifier.fillMaxWidth().padding(10.dp).clickable { vm.onUpgrade(upgrade) }) {
                Text(
                    type.title, fontSize = 25.sp,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    "${upgrade.level} ур. ${upgrade.currentValue().formatNumber(2)}",
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    "Стоимость: ${upgrade.currentCost().formatNumber(2)}",
                    modifier = Modifier.padding(5.dp)
                )
            }
            ApplicationLifetimeObserver { vm.saveData() }
        }
    }
}