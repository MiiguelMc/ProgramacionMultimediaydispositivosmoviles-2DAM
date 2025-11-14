package com.example.punto_de_control_1.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.punto_de_control_1.R
import com.example.punto_de_control_1.model.ConfiguracionDataStore
import kotlinx.coroutines.launch

@Composable
fun ConfiguracionScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val configDataStore = ConfiguracionDataStore(context)



    // Observando los valores desde DataStore
    val checkvalor by configDataStore.checkOptionFlow.collectAsState(initial = false)
    val switchvalor by configDataStore.switchOptionFlow.collectAsState(initial = false)
    val radiovalor by configDataStore.radioOptionFlow.collectAsState(initial = "opcion1")
    val menuvalor by configDataStore.dropdownOptionFlow.collectAsState(initial = "item1")

    // States locales (state hoisting)
    var check by remember { mutableStateOf(checkvalor) }
    var switch by remember { mutableStateOf(switchvalor) }
    var radio by remember { mutableStateOf(radiovalor) }
    var menu by remember { mutableStateOf(menuvalor) }

    val dropdownItems = listOf("item1", "item2", "item3")

    Column(modifier = Modifier.padding(16.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = check,
                onCheckedChange = { check = it }
            )
            Text(text = stringResource(id = R.string.checkbox))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = switch,
                onCheckedChange = { switch = it }
            )
            Text(text = stringResource(id = R.string.switch_boton))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            Text(text = stringResource(id = R.string.radio))
            Row {
                RadioButton(
                    selected = radio == "opcion1",
                    onClick = { radio = "opcion1" }
                )
                Text(text = stringResource(id = R.string.radio_opcion1))

                RadioButton(
                    selected = radio == "opcion2",
                    onClick = { radio = "opcion2" }
                )
                Text(text = stringResource(id = R.string.radio_opcion2))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        var expanded by remember { mutableStateOf(false) }

        Box {
            Button(onClick = { expanded = true }) {
                Text(text = menu)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                dropdownItems.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            menu = item
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                configDataStore.updateCheckOption(check)
                configDataStore.updateSwitchOption(switch)
                configDataStore.updateRadioOption(radio)
                configDataStore.updateDropdownOption(menu)
            }
        }) {
            Text(text = stringResource(id = R.string.buttom_Guardar))
        }
    }
}

@Preview
@Composable
fun ConfiguracionPreview() {
    ConfiguracionScreen()
}