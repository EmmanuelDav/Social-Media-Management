package com.ID.loginappdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ID.loginappdemo.Fragment.HomeFragment
import com.ID.loginappdemo.Fragment.PostFragment
import com.ID.loginappdemo.Fragment.moreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView!!.setOnNavigationItemSelectedListener(navigationView)
        openFragment(HomeFragment())
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit();
    }

    private val navigationView = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.home -> {
                openFragment(HomeFragment())
                true
            }
            R.id.allPost -> {
                openFragment(PostFragment())
                true
            }
            R.id.more -> {
                openFragment(moreFragment())
                true
            }
            else -> false
        }
    }

}