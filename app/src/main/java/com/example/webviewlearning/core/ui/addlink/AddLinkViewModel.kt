package com.example.webviewlearning.core.ui.addlink

import com.example.webviewlearning.core.base.BaseViewModel
import com.example.webviewlearning.core.base.Database
import com.example.webviewlearning.core.base.LinkModel
import org.koin.java.KoinJavaComponent.inject

class AddLinkViewModel(override val state: AddLinkFragment) : BaseViewModel<AddLinkFragment>() {

    private val database = Database()

    fun additem(name:String,link:String,description:String){
        val item = LinkModel().apply {
            this.name = name
            this.link = link
            this.description = description
        }
        database.addLink(item)
    }
}