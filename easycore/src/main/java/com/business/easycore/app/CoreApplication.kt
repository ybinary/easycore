package com.business.easycore.app

import android.app.Application
import android.util.Log
import androidx.webkit.WebViewCompat
import com.lazy.library.logging.Logcat

/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-23
 */
class CoreApplication : Application() {

    companion object {
        lateinit var appContext: CoreApplication
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        Logcat.initialize(this)
        val webViewPackageInfo = WebViewCompat.getCurrentWebViewPackage(this)
        Log.d("MY_APP_TAG", "WebView version: ${webViewPackageInfo?.versionName}")

    }


}