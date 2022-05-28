package com.example.aaa


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.aaa.databinding.ActivityMainBinding
import com.example.aaa.ui.main.SectionsPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = binding.viewpager
        viewPager.adapter = SectionsPagerAdapter(this)
        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs,viewPager){tab, position ->

            // タブの領域にTextViewを置く為に生成
            val tv = TextView(this)
            when(position){
                0 -> tv.text = "tab1"
                1 -> tv.text = "tab2"
            } // 文言は適当
            // タブにはめ込む
            tab.customView = tv

            // TextViewに押下イベントを入れる。ここで、ダイアログを出す制御
            tv.setOnClickListener {
                AlertDialog.Builder(this)
                    .setTitle("タブ遷移します")
                    .setMessage("切り替えていいですか")
                    .setPositiveButton("OK") { _, _ ->
                        // OKが押されたらタブを切り替える
                        tab.select()
                    }
                    .setNegativeButton("No") { _, _ ->

                    }
                    .show()
            }
        }.attach()
    }
}