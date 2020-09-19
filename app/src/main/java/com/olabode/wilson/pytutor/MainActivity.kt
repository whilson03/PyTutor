package com.olabode.wilson.pytutor


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.olabode.wilson.pytutor.databinding.ActivityMainBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.ui.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var bottomNavigationView: BottomNavigationView
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val toolbar = binding.toolBar
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.fragments_container)

        bottomNavigationView = binding.bottomNavigationView
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.profileFragment))

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnNavigationItemReselectedListener {
            /** NO OPERATION **/
        }


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    toolbar.isVisible = false
                    bottomNavigationView.isVisible = true
                }

                R.id.tutorialTopicsFragment, R.id.viewTutorialsFragment -> {
                    bottomNavigationView.isVisible = false
                    toolbar.isVisible = true
                }

                R.id.loginFragment, R.id.signUpFragment, R.id.lessonCompletionFragment -> {
                    bottomNavigationView.isVisible = false
                    toolbar.isVisible = false
                }
                else -> {
                    bottomNavigationView.isVisible = true
                    toolbar.isVisible = true
                }
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return (Navigation.findNavController(this, R.id.fragments_container).navigateUp()
                || super.onSupportNavigateUp())
    }

}