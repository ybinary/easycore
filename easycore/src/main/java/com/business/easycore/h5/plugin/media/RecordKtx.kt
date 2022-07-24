package com.business.easycore.h5.plugin.media

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import cafe.adriel.androidaudiorecorder.AudioRecorderActivity
import cafe.adriel.androidaudiorecorder.model.AudioChannel
import cafe.adriel.androidaudiorecorder.model.AudioSampleRate
import cafe.adriel.androidaudiorecorder.model.AudioSource
import com.business.easycore.R
import com.business.easycore.h5.plugin.ServiceInner


/**
 * Note:{ 录音 }
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-24
 */
class RecordKtx : ServiceInner {

    var recordFilePath = ""

    //开始录音
    fun start(context: Context, recordLauncher: ActivityResultLauncher<Intent>) {
        recordFilePath = "${context.externalCacheDir}/${System.currentTimeMillis()}.waw"
        val intent = Intent(context, AudioRecorderActivity::class.java)
        intent.putExtra("filePath", recordFilePath)
        intent.putExtra("color", ContextCompat.getColor(context, R.color.amber_100))
        intent.putExtra("source", AudioSource.MIC)
        intent.putExtra("channel", AudioChannel.STEREO)
        intent.putExtra("sampleRate", AudioSampleRate.HZ_48000)
        intent.putExtra("autoStart", false)
        intent.putExtra("keepDisplayOn", true)
        recordLauncher.launch(intent)
    }

}