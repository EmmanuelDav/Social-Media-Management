package com.ID.loginappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.ID.loginappdemo.SplashFragment.Splash1
import com.ID.loginappdemo.SplashFragment.Splash2
import com.ID.loginappdemo.SplashFragment.Splash3
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen)
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(Splash1())
        pagerAdapter.addFragment(Splash2())
        pagerAdapter.addFragment(Splash3())
        view_pager.adapter = pagerAdapter
    }
}