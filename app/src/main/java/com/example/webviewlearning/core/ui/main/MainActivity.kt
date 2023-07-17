package com.example.webviewlearning.core.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.webviewlearning.base.BaseActivity
import com.example.webviewlearning.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = ActivityMainBinding.inflate(inflater, container, false)

    override fun ActivityMainBinding.initializeLayout() {

    }

}