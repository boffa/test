package com.mobilite.challenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobilite.challenge.R
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.mobilite.core.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    internal var mainFragment: MainFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* if (savedInstanceState == null) {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
             mainFragment =  MainFragment()
            transaction.add(R.id.container, mainFragment!!)
            transaction.commit()
        }
*/
    }

}
