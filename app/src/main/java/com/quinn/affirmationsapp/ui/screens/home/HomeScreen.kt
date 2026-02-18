package com.quinn.affirmationsapp.ui.screens.home

import com.quinn.affirmationsapp.R
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quinn.affirmationsapp.ui.theme.AffirmationsAppTheme
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberAsyncImagePainter
import com.quinn.affirmationsapp.data.model.Affirmation
import com.quinn.affirmationsapp.ui.components.NavBar
import com.quinn.affirmationsapp.ui.theme.Typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.statusBarsPadding(),
        topBar = {
            NavBar(
                left = listOf<@Composable () -> Unit>(
                    { Text(
                        text = "Collection",
                        style = TextStyle(
                            color = Color(0xFFFaF7FF),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            letterSpacing = 1.sp
                        )
                    ) },
                ),
                right = listOf(
                    {
                        Button(
                            onClick = {},
                            contentPadding = PaddingValues(8.dp),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.defaultMinSize(minWidth = 0.dp, minHeight = 0.dp),
                            colors = buttonColors(
                                contentColor = Color(0xFF8154EF),
                                containerColor = Color(0xFF8154EF)
                            )
                        )  {
                            Text(
                                text = "+",
                                style = TextStyle(
                                    color = Color(0xFFFaF7FF),
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 25.sp
                                ),
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
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(0.dp)
                        .size(20.dp)
                )
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color(0xFFFB5252),
                    shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.trash),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                }

            }
            Spacer(Modifier.height(40.dp))
            Image(
                painter = painterResource(R.drawable.hayase_yuuka_pajama),
                contentDescription = "null",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.padding(0.dp)
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = affirmation.content,
                color = Color.White
            )
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

