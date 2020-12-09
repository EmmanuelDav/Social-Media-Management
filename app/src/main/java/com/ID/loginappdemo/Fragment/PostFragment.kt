package com.ID.loginappdemo.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.ID.loginappdemo.Fragment.PostFragments.FacebookPosts
import com.ID.loginappdemo.Fragment.PostFragments.InstagramPost
import com.ID.loginappdemo.Fragment.PostFragments.twitterPost
import com.ID.loginappdemo.Models.PagerAdapter
import com.ID.loginappdemo.R
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PostFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_post, container, false)
        viewPager = view.findViewById<ViewPager>(R.id.Pager)
        tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        //Adding tab icon
        tabLayout.addTab(tabLayout.newTab().setText("Facebook"))
        tabLayout.addTab(tabLayout.newTab().setText("Twitter"))
        tabLayout.addTab(tabLayout.newTab().setText("Instagram"))
        val pagerAdapter = PagerAdapter(requireActivity().supportFragmentManager)
        pagerAdapter.addFragment(FacebookPosts())
        pagerAdapter.addFragment(InstagramPost())
        pagerAdapter.addFragment(twitterPost())
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
        return view
    }
}