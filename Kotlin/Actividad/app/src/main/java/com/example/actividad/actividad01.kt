package com.example.actividad

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad.ui.theme.ActividadTheme
import com.example.actividad.ui.theme.myShapes


@Composable
fun Ejercicio(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var texto by remember { mutableStateOf(context.getString(R.string.principal)) }
    var primerboton by remember { mutableStateOf(context.getString(R.string.primerboton)) }
    var segundoboton by remember { mutableStateOf(context.getString(R.string.segundoboton)) }
    var pulsarBoton by remember { mutableStateOf(true) }
    var resetBoton by remember { mutableStateOf(false) }
    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(70.dp))
        LazyRow {
            items(10) { index ->
                Card(
                    shape = myShapes.large,
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.padding(16.dp)

                ) {
                    Text(
                        text = context.getString(R.string.Cartas) + " $index",
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }


        Row {
            Text(
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,
                text = texto)
        }

        Row {
            Button(
                onClick = {
                    texto = context.getString(R.string.clickprimerboton)
                    pulsarBoton = false
                    resetBoton = true
                },
                enabled = pulsarBoton
            ) {
                Text(primerboton)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {

                    texto = context.getString(R.string.principal)
                    pulsarBoton = true
                    resetBoton = false
                },
                enabled = resetBoton
            ) {
                Text(segundoboton)
            }
        }
    }
}

@Composable
fun DesplegarBotones(context: Context,
                     pulsado: Boolean,
                     cambiarTextoPrincipal : (String) -> Unit,
                     cambiarPulsado: (Boolean) -> Unit
){

    Row {
        Button(
            onClick = {
               //  texto = context.getString(R.string.clickprimerboton)
                // pulsarBoton = false
                // resetBoton = true
                cambiarPulsado(context.getString(R.string.clickprimerboton))
            },
            enabled = pulsarBoton
        ) {
            Text(primerboton)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = {

                // texto = context.getString(R.string.principal)
                // pulsarBoton = true
                resetBoton = false
            },
            enabled = resetBoton
        ) {
            Text(segundoboton)
        }
    }

}




@Preview (name= "Modo claro ", showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EjercicioPreview(){
    ActividadTheme {
        Ejercicio()
    }
}
@Preview (name= "Modo oscuro ", showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EjercicioPreviewOscuro(){
    ActividadTheme { Ejercicio() }
}
