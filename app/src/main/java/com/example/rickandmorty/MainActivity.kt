package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    // In dieser Variable wird der NavController gespeichert
    private lateinit var navController: NavController

    /**
     * Lifecycle Funktion onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hole das navHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // hole den navController aus dem navHostFragment
        navController = navHostFragment.navController

        // Richte die Action bar mit dem NavController ein
        setupActionBarWithNavController(navController)
    }

    /**
     * Diese Funktion wird bei einem Klick auf den zurück Button in der Actionbar aufgerufen
     * und sorgt für die Navigation zurück ins MainFragment
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}