package com.example.webviewlearning.core.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webviewlearning.core.base.BaseFragment
import com.example.webviewlearning.core.base.Database
import com.example.webviewlearning.core.ui.WebView.WebViewActivity
import com.example.webviewlearning.core.ui.adapters.MainFragmentRecyclerViewAdapter
import com.example.webviewlearning.core.ui.addlink.AddLinkActivity
import com.example.webviewlearning.databinding.FragmentMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val database: Database by inject()
    private val viewModel: MainViewModel by viewModel()

    override fun setupBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMainBinding.inflate(layoutInflater, container, false)

    override fun FragmentMainBinding.initializeLayout() {
        addlinkbutton.setOnClickListener {
            val intent = Intent(activity, AddLinkActivity::class.java)
            activity?.startActivity(intent)
        }

        viewModel.currentState.observe(viewLifecycleOwner, ::handleList)
        val linkList = database.getAll()

        /*webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl("https://www.google.com.ua/?hl=ru")*/
    }

    override fun onResume() {
        super.onResume()
        viewModel.getList()
    }

    private fun handleList(mainState: MainViewModel.MainState?) {
        val adapter = mainState?.links?.let {
            MainFragmentRecyclerViewAdapter(it) {
                val intent = Intent(context,WebViewActivity::class.java)
                intent.putExtra(LINK, it)
                requireActivity().startActivity(intent)
                /*Bundle().apply {
                    this.putSerializable(LINK,it.convertToLocalItem())
                }*/
            }
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {
        val LINK = "link"
    }


}