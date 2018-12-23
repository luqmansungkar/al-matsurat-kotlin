package id.luqman.al_matsurat.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.luqman.al_matsurat.data.Page
import org.jetbrains.anko.support.v4.find
import id.luqman.al_matsurat.R

class DoaPageFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.doa_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val title: TextView = find(R.id.doa_title)
        val arabic: TextView = find(R.id.doa_arabic)
        val translation: TextView = find(R.id.doa_translation)

        val args = arguments
        title.text = args?.getString("title")
        arabic.text = args?.getString("arabic")
        translation.text = args?.getString("translation")
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(page: Page): DoaPageFragment {
            val args = Bundle()
            args.putString("title", page.title)
            args.putString("arabic", page.arabic)
            args.putString("translation", page.translation)
            args.putInt("repetition", page.repetition)

            val fragment = DoaPageFragment()
            fragment.arguments = args
            return fragment
        }
    }
}