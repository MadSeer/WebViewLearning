package com.example.webviewlearning.core.di

import com.example.webviewlearning.core.base.Database
import com.example.webviewlearning.core.ui.addlink.AddLinkViewModel
import com.example.webviewlearning.core.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {
    singleOf(::Database)
}

val viewModelModules = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::AddLinkViewModel)
    /*singleOf(::MainViewModel)
    singleOf(::AddLinkViewModel)*/
}

fun provideModules() = listOf(databaseModule, viewModelModules)
