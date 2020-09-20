package com.olabode.wilson.pytutor.utils

/**
 *   Created by OLABODE WILSON on 9/19/20.
 */
sealed class LoadingState {
    object Loading : LoadingState()
    object LoadingComplete : LoadingState()
}