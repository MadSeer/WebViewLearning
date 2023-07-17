package com.example.webviewlearning.core.ui.WebView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.webviewlearning.base.BaseActivity
import com.example.webviewlearning.core.base.LinkItem
import com.example.webviewlearning.core.base.LinkModel
import com.example.webviewlearning.core.ui.main.MainFragment.Companion.LINK
import com.example.webviewlearning.databinding.ActivityWebViewBinding

class WebViewActivity: BaseActivity<ActivityWebViewBinding>() {

    private var model: LinkItem? = null

    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = ActivityWebViewBinding.inflate(inflater,container,false)


    override fun ActivityWebViewBinding.initializeLayout() {
        model = intent.getParcelableExtra(LINK)
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl(model?.link.toString())
    }
}