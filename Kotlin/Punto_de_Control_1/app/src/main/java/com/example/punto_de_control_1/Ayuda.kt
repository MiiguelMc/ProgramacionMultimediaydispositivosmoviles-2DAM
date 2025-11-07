package com.example.punto_de_control_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Ayuda(modifier: Modifier = Modifier ) {

    val context = LocalContext.current
    Column (

        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp,
            alignment = Alignment.CenterVertically   )

    ) {

        //Image(
          //  painter = painterResource(id = R.drawable.banderaazores),
            //contentDescription = context.getString(R.string.DescripcionLogo),
            //modifier = Modifier
              //  .size(200.dp)
                //.clip(CircleShape)
        //)
        Text(
            text = context.getString(R.string.Autor)
        )

        Text(
            text = context.getString(R.string.Licencia)
        )




    }
}
@Preview
@Composable
fun AyudaPreview() {
    Ayuda()
}