package com.business.easycore.h5.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.business.easycore.R
import com.business.easycore.databinding.ActivityOptionBinding
import com.business.easycore.h5.H5Api
import com.business.easycore.h5.contact.H5Context
import com.business.easycore.h5.api.H5Service
import com.business.easycore.h5.plugin.media.RecordKtx

class OptionActivity : FragmentActivity(), View.OnClickListener {

    private lateinit var bindingView: ActivityOptionBinding

    private var recordFilePath = ""

    private val recordLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, recordFilePath, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(bindingView.root)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.optionRecording -> {
                var recordKtx = H5Api.launchService(this, H5Service.RECORDING, recordLauncher) as RecordKtx
                recordFilePath = recordKtx.recordFilePath
            }
        }
    }

}