package com.business.easycore.h5.web

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.business.easycore.h5.contact.H5Context
import com.business.easycore.h5.api.H5Service
import com.business.easycore.h5.ui.dialog.LoadingDialog


/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-23
 */
internal class CloudWebView(context: Context, attributeSet: AttributeSet?) :
    WebView(context, attributeSet) {

    private val TAG = "CloudWebView"

    constructor(context: Context) : this(context, null)

    //加载框
    internal var loadingDialog: LoadingDialog = LoadingDialog(context)

    init {
        initSetting()
        if (context is ComponentActivity) {
            context.lifecycle.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                fun onDestory() {
                    //加载null内容->移除->置空
                    loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
                    clearHistory()
                    (parent as ViewGroup).removeView(this@CloudWebView)
                    destroy()
                }
            })
        }
    }

    private fun initSetting() {
        //把进度条加到Webview中
        //允许webView自动匹配应用程序的主题（浅色或深色样式）
        //settings.setAlgorithmicDarkeningAllowed(true)
        //允许WebView从安装在系统中的内容提供程序加载内容。默认启用。
        settings.allowContentAccess = true
        //设置允许文件访问(仅启用或禁用文件系统访问,仍然可以使用 file:///android_asset 和 file:///android_res 访问资产和资源。)
        settings.allowFileAccess = true
        //是否允许在上下文中访问任意本地文件（包括WebView cookie和应用程序私有数据）
        settings.allowFileAccessFromFileURLs = false
        settings.allowUniversalAccessFromFileURLs = false
        //是否支持WebView加载网络图片资源
        settings.blockNetworkImage = false
        settings.blockNetworkLoads = false
        //设置默认缓存模式1
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        //设置默认的固定字体大小(1到72之间的非负整数)
        settings.defaultFontSize = 16
        //设置解码html页面时使用的默认文本编码
        settings.defaultTextEncodingName = "UTF-8"
        //设置是否支持缩放
        settings.setSupportZoom(false)
        //设置是否显示屏幕缩放控件
        settings.displayZoomControls = true
        //设置WebView是否支持使用其内置的缩放机制
        settings.builtInZoomControls = false
        //设置是否支持使用DOM存储API
        settings.domStorageEnabled = true
        settings.databaseEnabled = true
        //设置是否启用地理定位
        settings.setGeolocationEnabled(true)
        //是否支持通过JavaScript函数window.open()打开窗口
        settings.javaScriptCanOpenWindowsAutomatically = true
        //设置WebView支持JavaScript函数
        settings.javaScriptEnabled = true
        //设置WebView自适应屏幕
        settings.useWideViewPort = true
        //设置WebView是否以概览模式加载页面(自动调整至屏幕大小)
        settings.loadWithOverviewMode = true
        //设置混合内容模式(MIXED_CONTENT_ALWAYS_ALLOW，MIXED_CONTENT_COMPATIBILITY_MODE，MIXED_CONTENT_NEVER_ALLOW)
        settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        //设置userAgent
//        settings.userAgentString = "Android"

//        this.addJavascriptInterface(PluginInner(),"")
        if (context is ComponentActivity) {
            H5Context.registService(context as ComponentActivity)
        }
        this.webViewClient = CloudWebViewClient()
    }

}