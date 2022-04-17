package com.business.easycore.vmodel

import android.content.Context
import androidx.lifecycle.ViewModel

class MBaseVModel : ViewModel() {

    private var mContext: Context? = null

    private var funContext: (() -> Context)? = null

    fun withContext(function: () -> Context) {
        funContext = function
    }



}