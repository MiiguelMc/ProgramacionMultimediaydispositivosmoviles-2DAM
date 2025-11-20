package com.example.punto_de_control_1.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConfiguracionDataStore(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("configuracion")

        // Nombres de las claves en la base de datos
        val CLAVE_CHECKBOX = booleanPreferencesKey("clave_checkbox")
        val CLAVE_SWITCH = booleanPreferencesKey("clave_switch")
        val CLAVE_RADIO = stringPreferencesKey("clave_radio")
        val CLAVE_DESPLEGABLE = stringPreferencesKey("clave_desplegable")
    }

    // Flujos para leer los datos (Getters asíncronos)
    val obtenerCheckbox: Flow<Boolean> = context.dataStore.data
        .map { preferencias -> preferencias[CLAVE_CHECKBOX] ?: false }

    val obtenerSwitch: Flow<Boolean> = context.dataStore.data
        .map { preferencias -> preferencias[CLAVE_SWITCH] ?: false }

    val obtenerRadio: Flow<String> = context.dataStore.data
        .map { preferencias -> preferencias[CLAVE_RADIO] ?: "claro" }

    val obtenerDesplegable: Flow<String> = context.dataStore.data
        .map { preferencias -> preferencias[CLAVE_DESPLEGABLE] ?: "español" }

    // Funciones para escribir los datos (Setters)
    suspend fun guardarCheckbox(valor: Boolean) {
        context.dataStore.edit { preferencias -> preferencias[CLAVE_CHECKBOX] = valor }
    }

    suspend fun guardarSwitch(valor: Boolean) {
        context.dataStore.edit { preferencias -> preferencias[CLAVE_SWITCH] = valor }
    }

    suspend fun guardarRadio(valor: String) {
        context.dataStore.edit { preferencias -> preferencias[CLAVE_RADIO] = valor }
    }

    suspend fun guardarDesplegable(valor: String) {
        context.dataStore.edit { preferencias -> preferencias[CLAVE_DESPLEGABLE] = valor }
    }
}