package com.quinn.affirmationsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quinn.affirmationsapp.R
import com.quinn.affirmationsapp.data.model.Affirmation
import com.quinn.affirmationsapp.ui.components.NavBar

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier.statusBarsPadding(),
        topBar = {
            NavBar(
                modifier = Modifier
                    .background(Color(0xFF121212))
                    .fillMaxWidth()
                    .padding(15.dp),
                arrangement = Arrangement.SpaceBetween,
                elements = listOf(
                    { Text(
                        text = stringResource(R.string.collection_topbar_display),
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ) },
                    {
                        Button(
                            onClick = {},
                            contentPadding = PaddingValues(8.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = buttonColors(
                                contentColor = Color(0xFF8154EF),
                                containerColor = Color(0xFF8154EF)
                            )
                        ) {
                            Text(
                                text = stringResource(R.string.add_label_topbar),
                                style = MaterialTheme.typography.labelMedium,
                                color = Color(0xFFFaF7FF),
                                fontSize = 25.sp,
                                modifier = Modifier.padding(0.dp)
                            )
                        }
                    }
                )
            )
        }
    ) { innerPadding ->
        HomeScreenBody(Modifier.padding(innerPadding))
    }
}

@Composable
fun HomeScreenBody(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFF121212))
            .padding(15.dp)
            .fillMaxSize()
    ) {
        AffirmationCard(
            affirmation = Affirmation(
                imagePath = R.drawable.hayase_yuuka_pajama,
                content = "I luv Hayase Yuuka"
            )
        )
    }
}

@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = modifier
                .background(Color(0xFF1e1e1e))
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.star_icon),
                    contentDescription = stringResource(R.string.star_icon_desc),
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.White
                )
                Surface (
                    color = Color(0xFFFB5252),
                    shape = RoundedCornerShape(3.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.minus_icon),
                        contentDescription = stringResource(R.string.minus_icon_desc),
                        modifier = Modifier
                            .padding(5.dp)
                            .size(15.dp)
                        ,
                        tint = Color.White

                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.hayase_yuuka_pajama),
                contentDescription = stringResource(R.string.affirmation_image_desc),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = affirmation.content,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "HomeScreen"
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

