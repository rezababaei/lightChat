package com.rezababaei.lightchat.utils.bases

import android.app.Application
import androidx.viewbinding.BuildConfig
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BaseApplication :Application(){

    override fun onCreate() {
        super.onCreate()

//        if (BuildConfig.DEBUG){
//            Timber.plant(Timber.DebugTree())
//        }else{
////            Timber.plant(CrashReportingTree())
//        }
    }
}