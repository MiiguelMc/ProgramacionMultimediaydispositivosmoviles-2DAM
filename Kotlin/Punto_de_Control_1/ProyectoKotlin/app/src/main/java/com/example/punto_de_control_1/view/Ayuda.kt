package com.example.punto_de_control_1.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.punto_de_control_1.R

@Composable
fun Ayuda(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Image(
        painter = painterResource(id = R.drawable.fondoayuda),
        contentDescription = context.getString(R.string.DescripcionLogo),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp, alignment = Alignment.CenterVertically
        )

    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = context.getString(R.string.Ayuda), style = MaterialTheme.typography.displaySmall
        )
        Image(
            painter = painterResource(id = R.drawable.nube),
            contentDescription = context.getString(R.string.DescripcionLogo),
            modifier = Modifier.size(50.dp)
        )
        Card() {
            Text(
                text = context.getString(R.string.Problema1),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Justify
            )
            Text(
                text = context.getString(R.string.Problema1Texto),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify

            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.electricidad),
            contentDescription = context.getString(R.string.DescripcionLogo),
            modifier = Modifier.size(50.dp)
        )
        Card() {
            Text(
                text = context.getString(R.string.Problema2),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Justify
            )
            Text(
                text = context.getString(R.string.Problema2Texto),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.perdido),
            contentDescription = context.getString(R.string.DescripcionLogo),
            modifier = Modifier.size(50.dp)
        )
        Card() {
            Text(
                text = context.getString(R.string.Problema3),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Justify
            )
            Text(
                text = context.getString(R.string.Problema3Texto),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.emergencia),
            contentDescription = context.getString(R.string.DescripcionLogo),
            modifier = Modifier.size(50.dp)
        )
        Card() {
            Text(
                text = context.getString(R.string.Problema4),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Justify
            )
            Text(
                text = context.getString(R.string.Problema4Texto),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.molesto),
            contentDescription = context.getString(R.string.DescripcionLogo),
            modifier = Modifier.size(50.dp)
        )
        Card() {
            Text(
                text = context.getString(R.string.Problema5),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Justify
            )
            Text(
                text = context.getString(R.string.Problema5Texto),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify

            )
        }


    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AyudaPreview() {
    Ayuda()
}
