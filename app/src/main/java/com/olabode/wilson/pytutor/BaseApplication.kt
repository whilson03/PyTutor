package com.olabode.wilson.pytutor

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 *   Created by OLABODE WILSON on 7/9/20.
 */

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}