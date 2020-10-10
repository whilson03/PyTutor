package com.olabode.wilson.pytutor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */

@Parcelize
data class ExerciseFragment (
        val id: String,
        val title: String,
        val question: String,
        val solution: String
) : Parcelable