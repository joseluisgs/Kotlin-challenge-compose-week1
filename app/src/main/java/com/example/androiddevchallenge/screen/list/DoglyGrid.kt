package com.example.androiddevchallenge.screen.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.data.Dog

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DoglyGrid(modifier: Modifier, dogs: List<Dog>, onItemClick: (Dog) -> Unit) {
    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Fixed(2),
        content = {
            items(dogs.size) { index ->
                DoglyItem(dog = dogs[index], onItemClick = onItemClick)
            }
        })
}