package id.luqman.al_matsurat.data

import android.content.Context
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

object DataHelper{
    fun getDoaPages(context: Context): List<Page>{
        var gson = Gson()

        val inputStreamReader = InputStreamReader(context.assets.open("doa.json"))
        val bufferedReader = BufferedReader(inputStreamReader)

        val inputString = bufferedReader.use { it.readText() }

        var pages = gson.fromJson(inputString, Pages::class.java)

        return pages.pages
    }
}