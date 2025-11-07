package com.example.punto_de_control_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Ayuda(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Column(

        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
            alignment = Alignment.CenterVertically
        )

    ) {
        Text(
            text = "¿Necesitas Ayuda?",
            style = MaterialTheme.typography.displaySmall
        )

            Text(
                text = "1. Problemas con el clima",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = "En las Azores el tiempo puede cambiar rápidamente.\n" +
                        "Si la lluvia o el viento te sorprenden, nuestro equipo te ayudará a reubicar tu tienda o a conseguir refugio temporal.\n" +
                        "También contamos con zonas cubiertas y alquiler de material impermeable para que tu estancia siga siendo cómoda y segura.",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center

            )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "2. Problemas con electricidad o agua",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Si tienes algún inconveniente con la conexión eléctrica o el suministro de agua, avísanos a través de la app o en recepción \n" +
            "Nuestro equipo técnico está disponible las 24 h para resolverlo lo antes posible.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "3. Pérdida de objetos o documentación",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Text(
            text = "¿Has perdido algo importante?\n" +
                    "Disponemos de un servicio de objetos perdidos.\n" +
                    "Solo tienes que registrar el objeto en la app o avisar en recepción.\n" +
                    "Si se trata de documentación, te ayudaremos a contactar con las autoridades locales.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "4. Emergencias médicas",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Text(
            text = "La seguridad de nuestros huéspedes es lo primero.\n" +
                    "Contamos con botiquín y personal con formación básica en primeros auxilios.\n" +
                    "En caso de emergencia grave, te ayudaremos a contactar rápidamente con los servicios sanitarios más cercanos.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center

        )




    }
}

@Preview
@Composable
fun AyudaPreview() {
    Ayuda()
}
/*
*


La seguridad de nuestros huéspedes es lo primero.
Contamos con botiquín y personal con formación básica en primeros auxilios.
En caso de emergencia grave, te ayudaremos a contactar rápidamente con los servicios sanitarios más cercanos.

🔒 6. Seguridad y convivencia

Nuestro camping es un espacio tranquilo y seguro.
Contamos con vigilancia nocturna y normas de convivencia para asegurar el descanso de todos.
Si ocurre algún incidente, puedes reportarlo directamente desde la app o en recepción.

🔧 7. Problemas con el alojamiento o el equipamiento

Si notas algo que no funciona correctamente en tu parcela, tienda o bungalow (como una fuga de agua, una bombilla fundida o un electrodoméstico averiado), notifícalo fácilmente desde la app y nuestro equipo lo solucionará cuanto antes.

🌍 8. Problemas de comunicación o idioma

Nuestro personal habla varios idiomas (portugués, español e inglés) y siempre está dispuesto a ayudarte.
Si tienes dificultades para comunicarte o entender información local, te asistiremos con traducción o recomendaciones.  */