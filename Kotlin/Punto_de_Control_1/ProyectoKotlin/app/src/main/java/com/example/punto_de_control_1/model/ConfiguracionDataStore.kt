package com.example.punto_de_control_1.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConfiguracionDataStore(private val context: Context) {

    companion object {
        // Delegado DataStore para todas las instancias
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("configuracion")

        // Claves de preferencias
        val CHECK_OPTION = booleanPreferencesKey("check_option")
        val SWITCH_OPTION = booleanPreferencesKey("switch_option")
        val RADIO_OPTION = stringPreferencesKey("radio_option")
        val DROPDOWN_OPTION = stringPreferencesKey("dropdown_option")
    }

    // Flujos para leer los valores
    val checkOptionFlow: Flow<Boolean> = context.dataStore.data
        .map { it[CHECK_OPTION] ?: false }

    val switchOptionFlow: Flow<Boolean> = context.dataStore.data
        .map { it[SWITCH_OPTION] ?: false }

    val radioOptionFlow: Flow<String> = context.dataStore.data
        .map { it[RADIO_OPTION] ?: "opcion1" }

    val dropdownOptionFlow: Flow<String> = context.dataStore.data
        .map { it[DROPDOWN_OPTION] ?: "item1" }

    // Métodos para actualizar valores
    suspend fun updateCheckOption(value: Boolean) {
        context.dataStore.edit { it[CHECK_OPTION] = value }
    }

    suspend fun updateSwitchOption(value: Boolean) {
        context.dataStore.edit { it[SWITCH_OPTION] = value }
    }

    suspend fun updateRadioOption(value: String) {
        context.dataStore.edit { it[RADIO_OPTION] = value }
    }

    suspend fun updateDropdownOption(value: String) {
        context.dataStore.edit { it[DROPDOWN_OPTION] = value }
    }
}
