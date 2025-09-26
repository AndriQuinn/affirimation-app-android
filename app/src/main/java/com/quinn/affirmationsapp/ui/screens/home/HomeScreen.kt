package com.quinn.affirmationsapp.ui.screens.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                        text = "Doing Better",
                        style = TextStyle(
                            color = Color(0xFFFaF7FF),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp,
                            letterSpacing = 2.sp
                        )
                    ) },
                ),
                right = listOf(
                    {
                        Button(
                            onClick = {},
                            contentPadding = PaddingValues(0.dp),
                            shape = RoundedCornerShape(8.dp)
                        )  {
                            Text(
                                text = "+",
                                style = TextStyle(
                                    color = Color(0xFFFaF7FF),
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 25.sp
                                ),
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
            .background(Color(0xFF1E1E1E))
            .padding(15.dp)
            .fillMaxSize()
    ) {

    }
}

@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.background(Color(0xFF474554))
    ) {
        Image (
            painter = rememberAsyncImagePainter(affirmation.imagePath),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Text()
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

