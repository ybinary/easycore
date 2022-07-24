package com.core.measy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.business.easycore.h5.H5Api
import com.core.measy.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var bootView: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bootView = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bootView.root)

        bootView.mainBtnSearch.setOnClickListener {
            testMethod()
        }
        H5Api.loadUrl(this,"")
    }

    private fun testMethod() {
//        lifecycleScope.launch {
//            var response = NetApiKtx.get(GithubSearch(bootView.mainEditSearch.text.toString()))
//            if (response.isSuccess()) {
//                response.body!!.string()
//            }
//        }
    }

    private var mScope = CoroutineScope(Job() + Dispatchers.Main)

    private suspend fun coroutineTest(): String {
        mScope.launch {

        }
        var result = withContext(Dispatchers.IO) {
            SystemClock.sleep(1000)

            var method = async {
                SystemClock.sleep(1000)
                Log.d("test", "333333")
            }
            method.await()
            Log.d("test", "11111111")
            "test123"
        }
        Log.d("test", "2222222222")
        return result
    }

}
