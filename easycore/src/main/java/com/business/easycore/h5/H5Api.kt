package com.business.easycore.h5

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.business.easycore.h5.api.H5Service
import com.business.easycore.h5.plugin.ServiceInner
import com.business.easycore.h5.plugin.media.RecordKtx
import com.business.easycore.h5.ui.OptionActivity

/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-23
 */
object H5Api {

    fun loadUrl(context: Context, url: String) {
        var intent = Intent(context, OptionActivity::class.java)
        context.startActivity(intent)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> launchService(context: Context, h5Service: H5Service, launcher: ActivityResultLauncher<T>): ServiceInner {
        var plugin: ServiceInner
        when (h5Service) {
            H5Service.RECORDING -> {
                plugin = RecordKtx()
                plugin.start(context, launcher as ActivityResultLauncher<Intent>)
            }

        }
        return plugin
    }


}