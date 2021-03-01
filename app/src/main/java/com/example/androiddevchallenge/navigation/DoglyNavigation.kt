/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
