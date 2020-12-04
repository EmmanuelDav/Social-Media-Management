package com.ID.loginappdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.ID.loginappdemo.SplashFragment.Splash1
import com.ID.loginappdemo.SplashFragment.Splash2
import com.ID.loginappdemo.SplashFragment.Splash3
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    var continueButton : MaterialButton ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(Splash1())
        pagerAdapter.addFragment(Splash2())
        pagerAdapter.addFragment(Splash3())
        view_pager!!.adapter = pagerAdapter
        tabDots!!.setupWithViewPager(view_pager)
        tabDots.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == 2) cont.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        continueButton = findViewById<MaterialButton>(R.id.cont)
        continueButton!!.setOnClickListener{
            startActivity(Intent(this@SplashScreen,MainActivity::class.java))
        }
    }
}