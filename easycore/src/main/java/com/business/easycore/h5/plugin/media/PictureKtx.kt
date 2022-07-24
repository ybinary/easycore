package com.business.easycore.h5.plugin.media

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

/**
 * Note:{ 图片相关 }
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-24
 */
class PictureKtx(var context: Context) {



    fun takePicture(takeLauncher: ActivityResultLauncher<Intent>) {
        var intent = Intent()

        takeLauncher.launch(intent)
    }


}