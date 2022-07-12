package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.second_fragment, SecondFragment())
                .commitNow()
        }
    }
}