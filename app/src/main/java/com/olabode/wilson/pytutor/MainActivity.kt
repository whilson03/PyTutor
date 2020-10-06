package com.olabode.wilson.pytutor

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.olabode.wilson.pytutor.databinding.ActivityMainBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UICommunicator {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navController = findNavController(R.id.fragments_container)

        bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnNavigationItemReselectedListener {
            /** NO OPERATION **/
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    bottomNavigationView.isVisible = true
                }

                R.id.tutorialTopicsFragment, R.id.viewTutorialsFragment -> {
                    bottomNavigationView.isVisible = false
                }

                R.id.loginFragment,
                R.id.signUpFragment,
                R.id.lessonCompletionFragment,
                R.id.splashScreenFragment,
                R.id.resetPasswordFragment,
                R.id.verifyPasswordFragment,
                R.id.algorithmFragment,
                R.id.listAlgosFragment
                -> {
                    bottomNavigationView.isVisible = false
                }

                else -> {
                    bottomNavigationView.isVisible = true
                }
            }
        }
    }

    override fun hideSoftKeyBoard() {
        currentFocus?.let {
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            try {
                inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        }
    }
}