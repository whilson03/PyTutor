package com.olabode.wilson.pytutor

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.databinding.ActivityMainBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UICommunicator {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navController = findNavController(R.id.fragments_container)
        bottomNavigationView = binding.bottomNavigationView

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.homeFragment, R.id.profileFragment))


        NavigationUI.setupWithNavController(bottomNavigationView, navController)


        bottomNavigationView.setOnNavigationItemReselectedListener { /** NO OPERATION **/ }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment,
                R.id.signUpFragment,
                R.id.lessonCompletionFragment,
                R.id.splashScreenFragment,
                R.id.resetPasswordFragment,
                R.id.verifyPasswordFragment,
                R.id.algorithmFragment,
                R.id.listAlgosFragment,
                R.id.exerciseListFragment,
                R.id.exerciseFragment,
                R.id.interpreterFragment,
                R.id.onBoardingFragment,
                R.id.tutorialTopicsFragment,
                R.id.viewTutorialsFragment,
                R.id.codeOutputFragment,
                R.id.allLessonsCompletedFragment
                -> {
                    bottomNavigationView.hide()
                }

                else -> {
                    bottomNavigationView.show()
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

    override fun onNewSnackBarMessage(message: String) {
        Snackbar.make(binding.rootLayout, message, Snackbar.LENGTH_LONG).show()
    }


    override fun onBackPressed() {
        if (navController.currentDestination!!.id == R.id.homeFragment) {
            navController.popBackStack(R.id.mobile_navigation_xml, true)
        }

        super.onBackPressed()
    }
}