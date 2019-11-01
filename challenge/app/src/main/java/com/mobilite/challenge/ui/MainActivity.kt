package com.mobilite.challenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobilite.challenge.R
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val fragment =  MainFragment()
        transaction.add(R.id.container,fragment)
        transaction.commit()
    }

}
