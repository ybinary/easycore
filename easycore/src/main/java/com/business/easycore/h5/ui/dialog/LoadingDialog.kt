package com.business.easycore.h5.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.business.easycore.R

/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-07-24
 */
class LoadingDialog(context: Context) : AlertDialog(context) {

    private val contentView by lazy { LayoutInflater.from(context).inflate(R.layout.dialog_loading, null) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    init {
        setView(contentView)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        //测量view宽高
        val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        contentView.measure(w, h)
        window?.setLayout(contentView.measuredWidth, contentView.measuredHeight)
        // 纵向偏移16dp
        var attributes = window?.attributes
        window?.attributes?.y = -dip2px(16)
        window?.attributes = attributes
    }

    private fun dip2px(pxValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue * scale + 0.5f).toInt()
    }

}