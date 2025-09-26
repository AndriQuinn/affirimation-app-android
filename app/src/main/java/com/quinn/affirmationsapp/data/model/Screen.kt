package com.quinn.affirmationsapp.data.model

import androidx.compose.runtime.Composable
import com.quinn.affirmationsapp.ui.screens.NewAffirmationScreen
import com.quinn.affirmationsapp.ui.screens.home.HomeScreen

data class Screen(
    val route: String,
    val content: @Composable () -> Unit
)

val screenRegistry = listOf<Screen>(
    Screen (
        route = "home",
        content = { HomeScreen() }
    ),
    Screen (
        route = "new-affirmation",
        content = { NewAffirmationScreen() }
    )
)