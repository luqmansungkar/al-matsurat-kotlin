package id.luqman.al_matsurat.fragment

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.luqman.al_matsurat.R
import id.luqman.al_matsurat.data.Page
import id.luqman.al_matsurat.util.Prefs
import org.jetbrains.anko.support.v4.find

class DoaPageFragment: Fragment(){

    private lateinit var prefs: Prefs

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.doa_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        prefs = Prefs(this@DoaPageFragment.context as Context)
        val arabic: TextView = find(R.id.doa_arabic)
        val translation: TextView = find(R.id.doa_translation)

        val args = arguments
        arabic.text = args?.getString("arabic")
        arabic.textSize = prefs.arabicSize.toFloat()

        translation.text = args?.getString("translation")
        translation.textSize = prefs.translationSize.toFloat()

        val typeface = Typeface.createFromAsset(this@DoaPageFragment.context?.assets as AssetManager, "utsmani.otf")
        arabic.typeface = typeface

        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(page: Page): DoaPageFragment {
            val args = Bundle()
            args.putString("title", page.title)
            args.putString("arabic", page.arabic)
            args.putString("translation", page.translation)
            args.putString("repetition", page.repetition)

            val fragment = DoaPageFragment()
            fragment.arguments = args
            return fragment
        }
    }
}