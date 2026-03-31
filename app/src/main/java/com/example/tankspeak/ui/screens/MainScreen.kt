package com.example.tankspeak.ui.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.tankspeak.ui.global.GlobalViewModel
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tankspeak.data.model.Fuel
import com.example.tankspeak.data.model.GasStation
import com.example.tankspeak.data.model.TankReading
import com.example.tankspeak.ui.models.MainViewModel
import com.example.tankspeak.ui.navigation.Screen

@Composable
fun MainScreen(
    navController: NavController,
    globalViewModel: GlobalViewModel
) {
    val viewModel: MainViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Column {
        Text("Gas Stations", style = MaterialTheme.typography.titleMedium)

        // List of Gas Stations
        LazyColumn {
            items(uiState.gasStations) { station: GasStation ->
                Text(
                    text = "${station.name} - ${station.address}",
                    modifier = androidx.compose.ui.Modifier
                        .clickable {
                            viewModel.loadFuels(station.id)
                        }
                        .padding(8.dp)
                )
            }
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

        Text("Fuels", style = MaterialTheme.typography.titleMedium)
        // List of Fuels for selected gas station
        LazyColumn {
            items(uiState.selectedFuels) { fuel: Fuel ->
                Text(
                    text = "${fuel.name} - ${fuel.tankCapacity} L",
                    modifier = androidx.compose.ui.Modifier
                        .clickable {
                            viewModel.loadReadings(fuelId = fuel.id, gasStationId = fuel.id)
                        }
                        .padding(8.dp)
                )
            }
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

        Text("Tank Readings", style = MaterialTheme.typography.titleMedium)
        // List of Tank Readings for selected fuel
        LazyColumn {
            items(uiState.selectedReadings) { reading: TankReading ->
                Text(
                    text = "${reading.tankName} - ${reading.volume} L (added: ${reading.addedVolume ?: 0.0})",
                    modifier = androidx.compose.ui.Modifier.padding(8.dp)
                )
            }
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("another") }
        ) {
            Text("Go to AnotherScreen")
        }

        Button(onClick = { globalViewModel.toggleDarkMode() }) {
            Text("Toggle Dark Mode")
        }
    }

}