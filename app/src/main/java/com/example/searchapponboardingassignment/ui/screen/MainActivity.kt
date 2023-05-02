package com.example.searchapponboardingassignment.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.searchapponboardingassignment.ui.theme.SearchAppOnboardingAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchAppOnboardingAssignmentTheme {
                val viewModel = viewModel<MainViewModel>()
                MainScreen(viewModel = viewModel)
            }
        }
    }
}