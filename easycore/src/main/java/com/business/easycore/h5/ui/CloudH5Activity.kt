package com.business.easycore.h5.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.business.easycore.databinding.ActivityCloudH5Binding
import com.business.easycore.h5.ui.dialog.LoadingDialog

class CloudH5Activity : FragmentActivity() {

    private lateinit var binding: ActivityCloudH5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCloudH5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.cloudWebView.loadUrl("https://production.jingyiweishi.com/#/login")
    }

    override fun onBackPressed() {
        if (binding.cloudWebView.canGoBack()) {
            binding.cloudWebView.goBack()
        } else super.onBackPressed()
    }

}