package com.olabode.wilson.pytutor.ui.profile

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.api.load
import coil.transform.CircleCropTransformation
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentProfileBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel: ProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userDetails.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Success -> {
                    setUpProfile(result.data)
                }
            }
        })


        binding.signOut.setOnClickListener {
            logOut()
        }

        binding.navigateToRate.setOnClickListener {
            rate(requireContext())
        }

        binding.navigatePrivacy.setOnClickListener {
            privacy()
        }

        binding.achievement.setOnClickListener {

        }

        binding.editProfile.setOnClickListener {

        }

        binding.navigateToFeedback.setOnClickListener {
            sendFeedback()
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
        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToAuthNavigation())
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
                            Uri.parse("http://play.google.com/store/apps/details?id=" + context.packageName)
                    )
            )
        }
    }

    private fun sendFeedback() {
        val intent =
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "whilson03@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject_email))
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.hi_wilsonTech) + "")
        startActivity(Intent.createChooser(intent, getString(R.string.feedback)))
    }

    private fun privacy() {
        val url = "https://whilson03.wixsite.com/wilsontech/post/privacy-policy"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

}