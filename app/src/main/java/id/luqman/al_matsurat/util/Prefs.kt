package id.luqman.al_matsurat.util

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context){
    val PREFS_FILENAME = "id.luqman.al_matsurat.prefs"
    val ARABIC_SIZE = "ARABIC_SIZE"
    val TRANSLATION_SIZE = "TRANSLATION_SIZE"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var arabicSize: Int
        get() = prefs.getInt(ARABIC_SIZE, 30)
        set(value) = prefs.edit().putInt(ARABIC_SIZE, value).apply()

    var translationSize: Int
        get() = prefs.getInt(TRANSLATION_SIZE, 20)
        set(value) = prefs.edit().putInt(TRANSLATION_SIZE, value).apply()
}