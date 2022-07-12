package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, FirstFragment())
                .commitNow()
        }
    }

    fun switchFragment() {
        supportFragmentManager.commit {
            add(R.id.main_browse_fragment, SecondFragment(), "TAG")
        }
        //***************************************************************************************
        //***************************************************************************************
        // *** NOTE: If we start the second fragment in a new activity the problem does not occur
        //***************************************************************************************
        //***************************************************************************************
        // startActivity(Intent(this, SecondActivity::class.java))
    }
}