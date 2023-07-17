package com.example.webviewlearning.core.ui.addlink

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.webviewlearning.core.base.BaseFragment
import com.example.webviewlearning.databinding.FragmentNewLinkBinding

class AddLinkFragment: BaseFragment<FragmentNewLinkBinding>() {
    override fun setupBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewLinkBinding.inflate(layoutInflater,container,false)

    override fun FragmentNewLinkBinding.initializeLayout() {
        button.setOnClickListener {
            AddLinkViewModel(AddLinkFragment()).additem(
                editTextName.text.toString(),
                editTextLink.text.toString(),
                editTextDescription.text.toString()
            )
            requireActivity().finish()
        }
    }
}