package com.example.pruebapractica.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebapractica.R


@Composable
fun Listas(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val estadosTareas = remember { mutableStateListOf(false, false, false, false) }
    val tareas = listOf(
        context.getString(R.string.Tarea1),
        context.getString(R.string.Tarea2),
        context.getString(R.string.Tarea3),
        context.getString(R.string.Tarea4)
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(

            text = context.getString(R.string.Titulo)
        )
        LazyColumn() {
            items(tareas.indices.toList()) { index ->
                Card(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Row {
                        Text(
                            text = tareas[index],
                            style = if (estadosTareas[index])
                                TextStyle(textDecoration = TextDecoration.LineThrough)
                            else
                                TextStyle(),
                            modifier = Modifier.padding(10.dp)

                        )
                        Checkbox(
                            checked = estadosTareas[index],
                            onCheckedChange = { estadosTareas[index] = it }
                        )
                    }

                }
            }
        }
    }
}

@Preview(name = "Preview Examen", showBackground = true)
@Composable
fun EjercicioPreview() {
    PruebaPracticaTheme {
        Listas()
    }
}