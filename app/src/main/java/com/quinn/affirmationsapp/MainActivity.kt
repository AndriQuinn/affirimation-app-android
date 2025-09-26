package com.quinn.affirmationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.quinn.affirmationsapp.ui.theme.AffirmationsAppTheme
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AffirmationsAppTheme {
                AffirmationApp()
            }
        }
    }
}

@Composable
fun AffirmationApp(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    // Navigation address and options
    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = { slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(250)
        )  },
        popEnterTransition = { slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(250)
        ) },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = {-it},
                animationSpec = tween(250)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = {-it},
                animationSpec = tween(250)
            )
        },
        modifier = Modifier.background(Color(0xFF1E1E1E))
    ) {
//        composable("home") { HomeScreen(navController = navController) }
//        composable("addTaskScreen") { AddTaskScreen(navController = navController) }
//        composable(
//            route = "taskInfoScreen/{taskData}",
//            arguments = listOf(navArgument("taskData") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val taskUri = backStackEntry.arguments?.getString("taskData")
//            val taskUriDecoded = Uri.decode(taskUri.toString())
//            val taskData = Json.decodeFromString<TaskNode>(taskUriDecoded)
//
//            TaskInfoScreen(
//                taskNode = taskData,
//                navController = navController
//            )
//        }
    }
}

@Preview(
    name = "Home Screen",
    showSystemUi = true,
    showBackground = true)
@Composable
fun HomeScreenPreview() {
    AffirmationsAppTheme {

    }
}