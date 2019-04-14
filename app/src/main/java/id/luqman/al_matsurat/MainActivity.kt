package id.luqman.al_matsurat

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.luqman.al_matsurat.adapter.DoaPagerAdapter
import id.luqman.al_matsurat.data.DataHelper
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = DoaPagerAdapter(supportFragmentManager, DataHelper.getDoaPages(this))

        val viewPager: ViewPager = find(R.id.doa_viewpager)
        viewPager.adapter = pagerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
            when(item?.itemId){
                R.id.setting_menu -> {
                    startActivity<SettingActivity>()
                    return true
                }
                R.id.about_menu -> {
                    return true
                }
                else -> return super.onOptionsItemSelected(item)
            }
    }
}
