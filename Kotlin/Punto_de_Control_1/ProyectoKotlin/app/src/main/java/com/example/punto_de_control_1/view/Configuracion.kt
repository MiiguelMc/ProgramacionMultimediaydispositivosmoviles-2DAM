package com.example.punto_de_control_1.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.punto_de_control_1.R
import com.example.punto_de_control_1.model.ConfiguracionDataStore
import kotlinx.coroutines.launch

@Composable
fun ConfiguracionScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()


    val configDataStore = remember { ConfiguracionDataStore(context) }


    val checkvalor by configDataStore.checkOptionFlow.collectAsState(initial = false)
    val switchvalor by configDataStore.switchOptionFlow.collectAsState(initial = false)
    val radiovalor by configDataStore.radioOptionFlow.collectAsState(initial = "claro")
    val menuvalor by configDataStore.dropdownOptionFlow.collectAsState(initial = "Español")

    var check by remember { mutableStateOf(false) }
    var switch by remember { mutableStateOf(false) }
    var radio by remember { mutableStateOf("claro") }
    var menu by remember { mutableStateOf("Español") }

    val dropdownItems = listOf("Ingles", "Español", "Portuges")

    LaunchedEffect(checkvalor, switchvalor, radiovalor, menuvalor) {
        check = checkvalor
        switch = switchvalor
        radio = radiovalor
        menu = menuvalor
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Configuración",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,

        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Uso de Datos", fontWeight = FontWeight.Bold)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = check,
                onCheckedChange = { check = it }
            )
            Text(text = stringResource(id = R.string.checkbox))
        }

        Spacer(modifier = Modifier.height(15.dp))
        Spacer(modifier = Modifier.height(15.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),

        ) {
            Text(
                text = stringResource(id = R.string.switch_boton),
                fontSize = 18.sp
            )
            Switch(
                checked = switch,
                onCheckedChange = { switch = it }
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Spacer(modifier = Modifier.height(15.dp))


        Text(
            text = stringResource(id = R.string.radio),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = radio == "claro",
                onClick = { radio = "claro" }
            )
            Text(text = stringResource(id = R.string.radio_opcion1))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = radio == "oscuro",
                onClick = { radio = "oscuro" }
            )
            Text(text = stringResource(id = R.string.radio_opcion2))
        }

        Spacer(modifier = Modifier.height(15.dp))
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Lenguaje", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        var expanded by remember { mutableStateOf(false) }

        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(text = " $menu")
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

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                scope.launch {
                    configDataStore.updateCheckOption(check)
                    configDataStore.updateSwitchOption(switch)
                    configDataStore.updateRadioOption(radio)
                    configDataStore.updateDropdownOption(menu)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.buttom_Guardar),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfiguracionPreview() {
    ConfiguracionScreen()
}