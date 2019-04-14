package id.luqman.al_matsurat

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.TextView
import id.luqman.al_matsurat.util.Prefs
import org.jetbrains.anko.find

class SettingActivity : AppCompatActivity() {

    private lateinit var arabicSeekbar: SeekBar
    private lateinit var arabicFontSize: TextView
    private lateinit var arabicSampleText: TextView

    private lateinit var translationSeekbar: SeekBar
    private lateinit var translationFontSize: TextView
    private lateinit var translationSampleText: TextView

    private lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pengaturan"

        prefs = Prefs(this)

        arabicSeekbar = find(R.id.seekbar_arabic_size)
        arabicFontSize = find(R.id.font_size_arabic)
        arabicSampleText = find(R.id.sample_text_arabic)

        translationSeekbar = find(R.id.seekbar_translation_size)
        translationFontSize = find(R.id.font_size_translation)
        translationSampleText = find(R.id.sample_text_translation)

        arabicFontSize.text = prefs.arabicSize.toString()
        arabicSampleText.textSize = prefs.arabicSize.toFloat()

        translationFontSize.text = prefs.translationSize.toString()
        translationSampleText.textSize = prefs.translationSize.toFloat()

        arabicSeekbar.progress = prefs.arabicSize
        translationSeekbar.progress = prefs.translationSize

        val typeface = Typeface.createFromAsset(assets, "utsmani.otf")
        arabicSampleText.typeface = typeface

        arabicSeekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                prefs.arabicSize = progress
                arabicFontSize.text = progress.toString()
                arabicSampleText.textSize = progress.toFloat()

            }
        })

        translationSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                prefs.translationSize = progress
                translationFontSize.text = progress.toString()
                translationSampleText.textSize = progress.toFloat()
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
