package com.example.punto_de_control_1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.example.punto_de_control_1.R

@Composable
fun AcercaDe(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
            alignment = Alignment.CenterVertically
        )

    ) {

        Image(
            painter = painterResource(id = R.drawable.logoacerca),
            contentDescription = context.getString(R.string.DescripcionLogo),
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Text(
            text = context.getString(R.string.Autor),
                    style = MaterialTheme.typography.titleLarge

        )

        Text(
            text = context.getString(R.string.Licencia),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center

        )


    }
}

@Preview
@Composable
fun AcercaDePreview() {
    AcercaDe()
}