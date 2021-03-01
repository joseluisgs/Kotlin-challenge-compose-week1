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
package com.example.androiddevchallenge.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.data.getDogs
import com.example.androiddevchallenge.theme.yellow
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DoglyDetailScreen(navController: NavController, dogId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.detail_title),
                        style = MaterialTheme.typography.h4
                    )
                },
                backgroundColor = yellow,
                contentColor = Color.White,
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = Color.White
                    )
                }
            )
        },
        content = {
            DetailsView(dogId)
        }
    )
}

@Composable
fun DetailsView(dogId: Int) {
    Surface(color = yellow) {
        val dog = getDogs().find { it.id == dogId }
        dog?.let {
            ImageDogDetail(dog = it)
            Box(
                modifier = Modifier
                    .padding(top = 260.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(24.dp),
                    backgroundColor = Color.White,
                    elevation = 10.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        BasicInfo(
                            modifier = Modifier.padding(12.dp),
                            dog = it
                        )
                        AdoptButton()
                    }
                }
            }
        }
    }
}

@Composable
fun ImageDogDetail(dog: Dog) {
    CoilImage(
        data = dog.photo,
        contentDescription = null,
        fadeIn = true,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(350.dp)
    )
}

@Composable
fun BasicInfo(modifier: Modifier, dog: Dog) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Row(
                modifier = Modifier.weight(2f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dog.name,
                    style = MaterialTheme.typography.h3,
                )
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp),
                    painter = if (dog.gender == Gender.Male) {
                        painterResource(id = R.drawable.male)
                    } else {
                        painterResource(id = R.drawable.female)
                    },
                    tint = Color.Gray,
                    contentDescription = null
                )
            }
            FavButton(
                modifier = Modifier.weight(1f)
            )
        }
        Card(
            shape = RoundedCornerShape(6.dp),
            elevation = 8.dp
        ) {
            Text(
                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp),
                text = dog.breed,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray
            )
        }
        Spacer(Modifier.size(3.dp))
        Card(
            shape = RoundedCornerShape(6.dp),
            elevation = 8.dp
        ) {
            Text(
                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp),
                text = "${dog.age} years old",
                style = MaterialTheme.typography.body1,
                color = Color.Gray
            )
        }
        Text(
            text = dog.description,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun AdoptButton() {
    Surface(
        color = MaterialTheme.colors.secondary,
        elevation = 2.dp,
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier
            .height(height = 48.dp)
            .clickable { }
            .fillMaxWidth()
    ) {
        Box {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(id = R.string.detail_adopt),
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun FavButton(modifier: Modifier) {
    val favState = remember { mutableStateOf(false) }
    Icon(
        modifier = modifier
            .size(50.dp)
            .clickable { favState.value = !favState.value },
        imageVector = if (favState.value) {
            Icons.Default.Favorite
        } else {
            Icons.Default.FavoriteBorder
        },
        contentDescription = "Favorite",
        tint = if (favState.value) {
            Color.Red
        } else {
            MaterialTheme.colors.onBackground
        }
    )
}

@Preview
@Composable
fun PreviewDoglyDetail() {
    DoglyDetailScreen(navController = rememberNavController(), dogId = 0)
}
