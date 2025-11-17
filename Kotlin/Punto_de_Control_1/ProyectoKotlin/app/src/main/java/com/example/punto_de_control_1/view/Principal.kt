package com.example.punto_de_control_1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.punto_de_control_1.R

@Composable
fun PantallaPrincipal(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp,
         alignment = Alignment.CenterVertically   )

    ) {
        Text(
            text = context.getString(R.string.TituloCamping),
            style = MaterialTheme.typography.titleLarge
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = context.getString(R.string.DescripcionLogo)
        )
        Card {
         Text(
             text = context.getString(R.string.SobreNosotros)

         )
        }


    }
}