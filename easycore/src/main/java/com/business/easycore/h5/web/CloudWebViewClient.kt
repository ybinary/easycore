package com.business.easycore.h5.web

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.annotation.RequiresApi
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewAssetLoader.AssetsPathHandler
import androidx.webkit.WebViewClientCompat
import com.business.easycore.app.CoreApplication
import com.lazy.library.logging.Logcat


/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-23
 */
class CloudWebViewClient : WebViewClientCompat() {

    //支持使用 http(s):// URL 访问本地资源
    private val assetLoader by lazy {
        WebViewAssetLoader.Builder().addPathHandler("/assets/", AssetsPathHandler(CoreApplication.appContext)).build()
    }

    @RequiresApi(21)
    override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest): WebResourceResponse? {
        return assetLoader.shouldInterceptRequest(request.url)
    }

    // for API < 21
    override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
        return assetLoader.shouldInterceptRequest(Uri.parse(url))
    }

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        view.loadUrl(request.url.toString())
        return true
    }

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        // 不要使用super，否则有些手机访问不了，因为包含了一条 handler.cancel()
        // super.onReceivedSslError(view, handler, error);
        // 接受所有网站的证书，忽略SSL错误，执行访问网页
        handler?.proceed()
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        if (view is CloudWebView) {
            view.loadingDialog?.show()
            Logcat.d("dialog","showLoadding")
        }
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        if (view is CloudWebView) {
            view.loadingDialog?.hide()
            Logcat.d("dialog","dismiss")
        }
    }

}