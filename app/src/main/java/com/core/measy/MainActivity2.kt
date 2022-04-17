package com.core.measy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.business.easycore.app.ActivityTask

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onResume() {
        super.onResume()
        ActivityTask.getAllActivity().forEach {
            Log.d("activity",it::class.java.name)
        }
    }

}