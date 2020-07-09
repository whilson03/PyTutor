package com.olabode.wilson.pytutor

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.google.android.material.navigation.NavigationView
import com.olabode.wilson.pytutor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        drawerLayout = binding.drawerLayout
        navView = binding.navView


        val navController = findNavController(R.id.nav_host_fragment)

        val topLevelDestinations = setOf(R.id.learnFragment)
        appBarConfiguration = AppBarConfiguration(topLevelDestinations, drawerLayout)

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        navView.setNavigationItemSelectedListener(this)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun navigateDestinationFromHost(toDestination: Int) {
        Handler().postDelayed({
            Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(toDestination)
        }, 316)
    }

    private fun isValidDestination(destination: Int): Boolean {
        return destination != Navigation.findNavController(
                this,
                R.id.nav_host_fragment
        ).currentDestination!!.id
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }

}