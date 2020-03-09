package com.github.fernandospr.abandon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AFragment.Listener, BFragment.Listener {

    private val navController: NavController by lazy { findNavController(R.id.mainNavFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onButtonAClick() {
        navController.navigate(R.id.action_to_b)
    }

    override fun onButtonBClick() {
        navController.navigate(R.id.action_to_c)
    }

    override fun onSupportNavigateUp(): Boolean {
        onAbandon()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    override fun onBackPressed() {
        onAbandon()
        super.onBackPressed()
    }

    private fun onAbandon() {
        val abandonListener =
            mainNavFragment.childFragmentManager.primaryNavigationFragment as? AbandonListener
        abandonListener?.onAbandon()
    }
}
