package com.olabode.wilson.pytutor.ui.learn.basic

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.learn.LearnRepository

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */
class BasicViewModel @ViewModelInject constructor(
        private val learnRepository: LearnRepository
) : ViewModel() {

    val basicTutorials = learnRepository.getAllBasicTutorials().asLiveData()
}