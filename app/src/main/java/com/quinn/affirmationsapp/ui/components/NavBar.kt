package com.quinn.affirmationsapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    elements: List< @Composable () -> Unit>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = arrangement,
        modifier = modifier
    ) {
        elements.forEach { elements ->
            elements()
        }
    }
}