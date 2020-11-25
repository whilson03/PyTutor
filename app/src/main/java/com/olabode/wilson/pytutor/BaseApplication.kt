package com.olabode.wilson.pytutor

import android.app.Application
import android.os.Build
import com.google.android.play.core.missingsplits.MissingSplitsManagerFactory
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


/**
 *   Created by OLABODE WILSON on 7/9/20.
 */

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            if (MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
                return
            }
        }
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }


    }
}