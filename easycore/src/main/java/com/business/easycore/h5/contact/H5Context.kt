package com.business.easycore.h5.contact

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.business.easycore.h5.api.H5Service
import com.business.easycore.h5.plugin.ServiceInner
import com.business.easycore.h5.plugin.media.RecordKtx
import com.lazy.library.logging.Logcat
import java.lang.ref.WeakReference

/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-24
 */
internal object H5Context {

    //当前页面context
    lateinit var currentContext: WeakReference<Context>

    var services: HashMap<H5Service, ServiceInner> = hashMapOf()

    //注册Result服务
    fun registService(context: ComponentActivity) {
        context.lifecycle.addObserver(lifecycleObserver)
    }

    private val lifecycleObserver = object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            Logcat.d("onCreate")


        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestory() {
            Logcat.d("onDestory")
        }
    }

}