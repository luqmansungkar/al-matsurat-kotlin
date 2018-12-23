package id.luqman.al_matsurat

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import id.luqman.al_matsurat.adapter.DoaPagerAdapter
import id.luqman.al_matsurat.data.DataHelper
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = DoaPagerAdapter(supportFragmentManager, DataHelper.getDoaPages(this))

        val viewPager: ViewPager = find(R.id.doa_viewpager)
        viewPager.adapter = pagerAdapter
    }
}
