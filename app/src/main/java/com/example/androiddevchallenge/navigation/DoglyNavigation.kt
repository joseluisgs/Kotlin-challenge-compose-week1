package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screen.detail.DoglyDetailScreen
import com.example.androiddevchallenge.screen.list.DoglyListScreen

const val DOG_LIST = "dog_list"
const val DOG_DETAIL_ARGUMENT = "dog_id"
const val DOG_DETAIL = "dog_detail/{$DOG_DETAIL_ARGUMENT}"

@Composable
fun BuildNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = DOG_LIST
    ) {
        composable(route = DOG_LIST) {
            DoglyListScreen(navController = navController)
        }
        composable(
            route = DOG_DETAIL,
            arguments = listOf(
                navArgument(DOG_DETAIL_ARGUMENT) {
                    type = NavType.IntType
                }
            )
        ) {
            it.arguments?.getInt(DOG_DETAIL_ARGUMENT)?.let { puppyID ->
                DoglyDetailScreen(
                    navController,
                    puppyID
                )
            }
        }
    }
}

fun buildDogDetailRoute(dogId: Int): String = "dog_detail/$dogId"
