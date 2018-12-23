package id.luqman.al_matsurat.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import id.luqman.al_matsurat.data.Page
import id.luqman.al_matsurat.fragment.DoaPageFragment

class DoaPagerAdapter(fm: FragmentManager, private val pages: List<Page>): FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return DoaPageFragment.newInstance(pages[position])
    }

    override fun getCount(): Int {
        return pages.size
    }

}