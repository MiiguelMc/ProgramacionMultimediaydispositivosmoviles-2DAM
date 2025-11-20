package com.example.punto_de_control_1.view

import android.content.res.Configuration
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
import com.example.punto_de_control_1.view.theme.Punto_de_Control_1Theme
import kotlinx.coroutines.launch

@Composable
fun Configuracion() {
    val contexto = LocalContext.current
    val scope = rememberCoroutineScope()

    val misDatos = remember { ConfiguracionDataStore(contexto) }

    val valorGuardadoCheck by misDatos.obtenerCheckbox.collectAsState(initial = false)
    val valorGuardadoSwitch by misDatos.obtenerSwitch.collectAsState(initial = false)
    val valorGuardadoRadio by misDatos.obtenerRadio.collectAsState(initial = "claro")
    val valorGuardadoMenu by misDatos.obtenerDesplegable.collectAsState(initial = "Español")

    var estadoCheck by remember { mutableStateOf(false) }
    var estadoSwitch by remember { mutableStateOf(false) }
    var estadoRadio by remember { mutableStateOf("claro") }
    var estadoMenu by remember { mutableStateOf("Español") }

    val listaIdiomas = listOf("Ingles", "Español", "Portuges")

    LaunchedEffect(valorGuardadoCheck, valorGuardadoSwitch, valorGuardadoRadio, valorGuardadoMenu) {
        estadoCheck = valorGuardadoCheck
        estadoSwitch = valorGuardadoSwitch
        estadoRadio = valorGuardadoRadio
        estadoMenu = valorGuardadoMenu
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

        Text(text = stringResource(id = R.string.usodedatos), fontWeight = FontWeight.Bold)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = estadoCheck,
                onCheckedChange = { estadoCheck = it }
            )
            Text(text = stringResource(id = R.string.checkbox))
        }

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
                checked = estadoSwitch,
                onCheckedChange = { estadoSwitch = it }
            )
        }

        Spacer(modifier = Modifier.height(15.dp))


        Text(
            text = stringResource(id = R.string.radio),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = estadoRadio == "claro",
                onClick = { estadoRadio = "claro" }
            )
            Text(text = stringResource(id = R.string.claro))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = estadoRadio == "oscuro",
                onClick = { estadoRadio = "oscuro" }
            )
            Text(text = stringResource(id = R.string.oscuro))
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = stringResource(id = R.string.idioma), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        var menuExpandido by remember { mutableStateOf(false) }

        Box {
            OutlinedButton(onClick = { menuExpandido = true }) {
                Text(text = " $estadoMenu")
            }
            DropdownMenu(
                expanded = menuExpandido,
                onDismissRequest = { menuExpandido = false }
            ) {
                listaIdiomas.forEach { idioma ->
                    DropdownMenuItem(
                        text = { Text(text = idioma) },
                        onClick = {
                            estadoMenu = idioma
                            menuExpandido = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                scope.launch {
                    misDatos.guardarCheckbox(estadoCheck)
                    misDatos.guardarSwitch(estadoSwitch)
                    misDatos.guardarRadio(estadoRadio)
                    misDatos.guardarDesplegable(estadoMenu)
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

@Preview(uiMode =  Configuration.UI_MODE_NIGHT_YES)
@Composable
fun configuracionPreview() {
    Punto_de_Control_1Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Configuracion()
        }
    }
}
