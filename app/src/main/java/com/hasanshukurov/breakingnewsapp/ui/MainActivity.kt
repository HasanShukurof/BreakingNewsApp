package com.hasanshukurov.breakingnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.hasanshukurov.breakingnewsapp.R
import com.hasanshukurov.breakingnewsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragmentId) as NavHostFragment
        val controller = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bottomNav,controller)

        controller.addOnDestinationChangedListener{ _,destination,_ ->
            when(destination.id){
                R.id.articleFragment -> {
                    binding.bottomNav.visibility = View.GONE
                }else -> {
                    binding.bottomNav.visibility = View.VISIBLE
                }
            }
        }
    }
}