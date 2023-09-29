package com.singaludra.gofood.frameworks

import android.content.Context
import android.content.SharedPreferences

object LocalFactory {
    private const val SHARED_PREFERENCES_ID = "go-food-preferences"

    fun createSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_ID, Context.MODE_PRIVATE)
    }
}
