package com.example.webviewlearning.core

import android.app.Application
import com.example.webviewlearning.core.di.provideModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class WebViewApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WebViewApplication)
            androidFileProperties()
            modules(provideModules())
        }
    }
}