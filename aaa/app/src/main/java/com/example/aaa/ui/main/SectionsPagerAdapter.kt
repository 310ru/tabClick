package com.example.aaa.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aaa.MainActivity
import com.example.aaa.R
import com.example.aaa.Tab1
import com.example.aaa.Tab2

//private val TAB_TITLES = arrayOf(
//    R.string.tab_text_1,
//    R.string.tab_text_2
//)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val activity: MainActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment:Fragment? = null
        when(position){
            0 -> fragment = Tab1()
            1 -> fragment = Tab2()
        }
        return fragment!!
    }
}