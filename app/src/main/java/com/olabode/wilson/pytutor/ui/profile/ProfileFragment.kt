package com.olabode.wilson.pytutor.ui.profile

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import coil.api.load
import coil.transform.CircleCropTransformation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentProfileBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.navigateSafe
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.Constants
import com.olabode.wilson.pytutor.utils.Constants.APP_FILE_PROVIDER_NAME
import com.olabode.wilson.pytutor.utils.Constants.FEEDBACK_EMAIL
import com.olabode.wilson.pytutor.utils.Constants.MARKET_BASE_URL
import com.olabode.wilson.pytutor.utils.Constants.PRIVACY_POLICY_LINK
import com.olabode.wilson.pytutor.utils.Constants.REQUEST_IMAGE_CAPTURE
import com.olabode.wilson.pytutor.utils.Constants.REQUEST_IMAGE_FROM_GALLERY
import com.olabode.wilson.pytutor.utils.Constants.UPLOAD_IMAGE_DIALOG_TAG
import com.olabode.wilson.pytutor.utils.Utils
import com.olabode.wilson.pytutor.utils.states.DataState
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import dagger.hilt.android.AndroidEntryPoint
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.size
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.File
import java.io.IOException

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var currentPhotoPath: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userDetails.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Success -> {
                    setUpProfile(result.data)
                }
                else -> {/* no-op */
                }
            }
        })

        binding.signOut.setOnClickListener { logOut() }

        binding.navigateToRate.setOnClickListener { rate(requireContext()) }

        binding.navigateToPrivacy.setOnClickListener { privacy() }

        binding.imageFrame.setOnClickListener { showUploadImageDialog() }

        binding.navigateToFeedback.setOnClickListener { sendFeedback() }
    }

    private fun showUploadImageDialog() {
        val dialog = UploadProfileImageDialog { method ->
            when (method) {
                is ImageUploadMethod.Gallery -> {
                    pickImageFromGallery()
                }

                is ImageUploadMethod.Camera -> {
                    if (hasCameraPermission()) {
                        dispatchTakePictureIntent()
                    } else {
                        requestCameraPermission()
                    }
                }
            }
        }
        parentFragmentManager.let {
            dialog.show(it, UPLOAD_IMAGE_DIALOG_TAG)
        }
    }

    private fun setUpProfile(user: User) {
        binding.username.text = user.fullName
        binding.profileIcon.load(user.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_profile_placeholder)
            transformations(CircleCropTransformation())
            error(R.drawable.ic_profile_placeholder)
        }
    }

    private fun logOut() {
        viewModel.signOut()
        navigateSafe(ProfileFragmentDirections.actionProfileFragmentToAuthNavigation())
    }

    private fun rate(context: Context) {
        val uri: Uri = Uri.parse("market://details?id=" + context.packageName)
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        // To count with Play market back stack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        // To count with Play market back stack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(
                Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )
        try {
            context.startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            context.startActivity(
                    Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(MARKET_BASE_URL + context.packageName)
                    )
            )
        }
    }

    private fun sendFeedback() {
        val intent =
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$FEEDBACK_EMAIL"))
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject_email))
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.hi_wilsonTech) + "")
        startActivity(Intent.createChooser(intent, getString(R.string.feedback)))
    }

    private fun privacy() {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(PRIVACY_POLICY_LINK)
        startActivity(i)
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        val mimeTypes = arrayOf("image/jpeg", "image/png", "image/jpg")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        startActivityForResult(intent, REQUEST_IMAGE_FROM_GALLERY)
    }

    private fun launchImageCrop(uri: Uri) {
        CropImage.activity(uri).setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(400, 400)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .start(requireContext(), this)
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(requireContext().packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    Utils.createImageFile(requireContext())
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    Timber.d(ex)
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    currentPhotoPath = it.absolutePath
                    val photoURI: Uri = FileProvider.getUriForFile(
                            requireContext(),
                            APP_FILE_PROVIDER_NAME,
                            it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_IMAGE_FROM_GALLERY -> {
                if (resultCode == Activity.RESULT_OK) {
                    data?.data?.let { uri ->
                        launchImageCrop(uri)
                    }
                } else {
                    Timber.d("Error Selecting Image From Gallery")
                }
            }

            REQUEST_IMAGE_CAPTURE -> {
                if (resultCode == Activity.RESULT_OK) {
                    launchImageCrop(Uri.fromFile(File(currentPhotoPath)))
                } else {
                    Timber.d("Error Passing Image From Camera")
                }
            }

            CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE -> {
                val result = CropImage.getActivityResult(data)
                if (resultCode == Activity.RESULT_OK) {
                    result.uri?.let { uri ->
                        lifecycleScope.launch {
                            val compressedImageFile = Compressor.compress(
                                    requireContext(),
                                    File(uri.path.toString()), Dispatchers.IO
                            ) {
                                size(Constants.MB_THRESHOLD)
                            }
                            withContext(Dispatchers.Main) {
                                viewModel.updateUserProfileImage(compressedImageFile)
                                        .observe(viewLifecycleOwner, Observer { s ->
                                            setUpProgressImageUploadProgress(s)
                                        })
                            }
                        }
                    }
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Timber.d("ERROR ${result.error}")
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            Constants.REQUEST_CAMERA_PERMISSION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent()
                } else {
                    /* no-op */
                }
            }
        }
    }

    private fun hasCameraPermission(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
        )
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        val shouldProvideRationale = ActivityCompat
                .shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.CAMERA)
        val permission = mutableListOf<String>()
        permission.add(Manifest.permission.CAMERA)

        if (shouldProvideRationale) {
            showPermissionDeniedDialog()
        } else {
            requestPermissions(permission.toTypedArray(), Constants.REQUEST_CAMERA_PERMISSION)
        }
    }

    private fun showPermissionDeniedDialog() {
        MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.permission_denied))
                .setMessage(getString(R.string.camera_rationale_message))
                .setPositiveButton(getString(R.string.app_setting)) { _, _ ->
                    // send to app settings if permission is denied permanently
                    val intent = Intent()
                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    val uri = Uri.fromParts("package", requireContext().packageName, null)
                    intent.data = uri
                    startActivity(intent)
                }
                .setNegativeButton(getString(R.string.cancel), null)
                .show()
    }

    private fun setUpProgressImageUploadProgress(it: DataState<String>) = when (it) {
        is DataState.Success -> {
            binding.profileImageProgress.hide()
            Toast.makeText(context, it.data, Toast.LENGTH_SHORT).show()
        }
        is DataState.Loading -> {
            binding.profileImageProgress.show()
            Toast.makeText(context, getString(R.string.updating), Toast.LENGTH_SHORT).show()
        }
        is DataState.Error -> {
            binding.profileImageProgress.hide()
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
        }
    }
}
