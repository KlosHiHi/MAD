package com.example.labwork16

import android.icu.util.Calendar
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.NumberPicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.isPopupLayout
import com.example.labwork16.ui.theme.Labwork16Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labwork16Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        Row(modifier = Modifier.fillMaxWidth().padding(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(stringResource(R.string.app_name), fontSize = 10.sp)
                            var text by remember { mutableStateOf("") }

                            TextField(
                                text,
                                { text = it },
                                label = { Text(stringResource(R.string.search_string)) },
                                modifier = Modifier.width(235.dp).padding(5.dp),
                                placeholder = { Text(stringResource(R.string.search_string)) },
                                trailingIcon = { Icon(Icons.Filled.Search, contentDescription = "") },
                            )

                            Button({}) {
                                Text(
                                    stringResource(R.string.menu_string),
                                    modifier = Modifier.width(50.dp),
                                    fontSize = 15.sp
                                )
                            }
                        }

                        val calendar = Calendar.getInstance()
                        val hour = calendar.get(Calendar.HOUR_OF_DAY)
                        val minute = calendar.get(Calendar.MINUTE)

                        Text("${pluralStringResource(R.plurals.hours, hour, hour)} ${pluralStringResource(R.plurals.minutes, minute, minute)}",
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 25.sp)

                        Column(modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth()) {
                            val developers = stringArrayResource(R.array.developers)
                            developers.forEach {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(stringResource(R.string.policy_string, it, 2026), fontSize = 10.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Labwork16Theme {
        Box(modifier = Modifier.fillMaxSize().background(colorResource(R.color.cadet_blue))) {
            Row(modifier = Modifier.fillMaxWidth().padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(R.string.app_name), fontSize = 10.sp)
                var text by remember { mutableStateOf("") }

                TextField(
                    text,
                    { text = it },
                    label = { Text(stringResource(R.string.search_string)) },
                    modifier = Modifier.width(dimensionResource(R.dimen.search_field_width)).padding(5.dp).background(colorResource(R.color.light_purple_blue)),
                    placeholder = { Text(stringResource(R.string.search_string)) },
                    trailingIcon = { Icon(Icons.Filled.Search, contentDescription = "") },
                )

                Button({}, modifier = Modifier) {
                    Text(
                        stringResource(R.string.menu_string),
                        modifier = Modifier.width(dimensionResource(R.dimen.menu_button_width))
                            .height(dimensionResource(R.dimen.menu_button_height)),
                        fontSize = 15.sp
                    )
                }
            }

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            Image( Modifier.align(Alignment.Center).width(dimensionResource(R.dimen.image_width))
                .height(dimensionResource(R.dimen.image_height)))

            Text("${pluralStringResource(R.plurals.hours, hour)} ${pluralStringResource(R.plurals.minutes, minute)}",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 25.sp)

            Column(modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth()
                .background(colorResource(R.color.the_bell_of_the_devil))) {
                val developers = stringArrayResource(R.array.developers)
                developers.forEach {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(stringResource(R.string.policy_string, it, 2026), fontSize = 10.sp)
                    }
                }
            }
        }
    }
}