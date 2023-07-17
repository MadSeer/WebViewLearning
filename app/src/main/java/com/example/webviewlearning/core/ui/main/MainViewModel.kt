package com.example.webviewlearning.core.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.webviewlearning.core.base.BaseViewModel
import com.example.webviewlearning.core.base.Database
import com.example.webviewlearning.core.base.LinkItem
import com.example.webviewlearning.core.base.LinkModel
import com.example.webviewlearning.databinding.FragmentMainBinding
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : BaseViewModel<MainViewModel.MainState>(), KoinComponent {

    private val database: Database by inject()

    fun getList(){
        val list = database.getAll()
        update {
            state.copy(links = list)
        }
    }

    data class MainState(
        var stateProgress: Boolean = false,
        var links: MutableList<LinkItem> = mutableListOf()
    )

    override val state: MainState
        get() = MainState()
}