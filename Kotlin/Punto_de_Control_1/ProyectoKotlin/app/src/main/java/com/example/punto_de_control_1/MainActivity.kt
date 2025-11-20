package com.example.punto_de_control_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.punto_de_control_1.view.AcercaDe
import com.example.punto_de_control_1.view.Ayuda
import com.example.punto_de_control_1.view.PantallaPrincipal
import com.example.punto_de_control_1.view.theme.Punto_de_Control_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Punto_de_Control_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AcercaDe()
                }
            }
        }
    }
}

