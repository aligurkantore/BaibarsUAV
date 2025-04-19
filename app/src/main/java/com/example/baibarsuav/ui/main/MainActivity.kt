package com.example.baibarsuav.ui.main

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.baibarsuav.R
import com.example.baibarsuav.databinding.ActivityMainBinding
import com.example.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun setupUI() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

    }
}