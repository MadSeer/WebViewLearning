package com.example.webviewlearning.core.ui.addlink

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.webviewlearning.base.BaseActivity
import com.example.webviewlearning.databinding.ActivityNewLinkBinding

class AddLinkActivity: BaseActivity<ActivityNewLinkBinding>() {
    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = ActivityNewLinkBinding.inflate(inflater,container,false)

    override fun ActivityNewLinkBinding.initializeLayout() {

    }
}