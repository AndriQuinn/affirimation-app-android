package com.quinn.affirmationsapp.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Card(
    orientation: Orientation,
    background: Color  = Color.Transparent,
    element: List<@Composable () -> Unit>,
) {

    if (orientation == Orientation.Horizontal) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(background)
                .padding(20.dp)
                .fillMaxWidth()

        ) {
            element.forEach { element ->
                element()
                Spacer(Modifier.width(10.dp))
            }
        }
    } else {
        Column (
//            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(background)
                .padding(20.dp)
                .fillMaxWidth()

        ) {
            element.forEach { element ->
                element()
                Spacer(Modifier.width(10.dp))
            }
        }
    }
}