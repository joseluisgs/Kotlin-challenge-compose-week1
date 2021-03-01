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
package com.example.androiddevchallenge.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.getDogs
import com.example.androiddevchallenge.navigation.buildDogDetailRoute
import com.example.androiddevchallenge.theme.yellow

@Composable
fun DoglyListScreen(navController: NavController) {
    Column(modifier = Modifier.background(yellow)) {
        DoglyToolbar(yellow)
        DoglyGrid(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp),
            dogs = getDogs(),
            onItemClick = { dog -> navController.navigate(buildDogDetailRoute(dog.id)) }
        )
    }
}
