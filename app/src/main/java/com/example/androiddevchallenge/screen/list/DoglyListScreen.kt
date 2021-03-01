package com.example.androiddevchallenge.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.navigation.buildDogDetailRoute
import com.example.androiddevchallenge.data.getDogs
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