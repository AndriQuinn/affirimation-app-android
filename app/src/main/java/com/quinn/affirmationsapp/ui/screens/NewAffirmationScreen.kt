
package com.quinn.affirmationsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quinn.affirmationsapp.ui.components.NavBar

@Composable
fun NewAffirmationScreen(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
            NavBar()
        }
    ) { innerPadding ->
            NewAffirmationScreen(Modifier.padding(innerPadding))
    }
}

@Composable
fun NewAffirmationBody(modifier: Modifier = Modifier) {
    Column () {

    }
}

@Preview (
    showBackground = true,
    showSystemUi = true,
    name = "New Affirmation Screen"
)
@Composable
fun NewAffirmationScreenPreview() {
    NewAffirmationScreen()
}