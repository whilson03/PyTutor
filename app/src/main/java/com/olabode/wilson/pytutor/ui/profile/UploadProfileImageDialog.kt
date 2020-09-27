package com.olabode.wilson.pytutor.ui.profile

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.olabode.wilson.pytutor.R

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
class UploadProfileImageDialog(
        private val onItemClicked: (method: ImageUploadMethod) -> Unit
) : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            retainInstance = true
            // Use the Builder class for convenient dialog construction
            val builder = MaterialAlertDialogBuilder(it)
            builder.setTitle(getString(R.string.image_upload_dialog_title))
                    .setItems(R.array.upload_image_source) { _, which ->
                        onItemClicked.invoke(getAction(which))
                        dismiss()
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun getAction(index: Int) = when (index) {
        0 -> ImageUploadMethod.Camera
        else -> ImageUploadMethod.Gallery
    }
}


sealed class ImageUploadMethod {
    object Camera : ImageUploadMethod()
    object Gallery : ImageUploadMethod()
}