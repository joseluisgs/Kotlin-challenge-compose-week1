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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.getDogs
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DoglyItem(dog: Dog, onItemClick: (Dog) -> Unit) {
    Card(
        Modifier
            .padding(8.dp)
            .clickable { onItemClick.invoke(dog) },
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            CoilImage(
                fadeIn = true,
                data = dog.photo,
                contentDescription = "Dog photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(180.dp)
            )
            Text(
                dog.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "${dog.age} years old",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewDoglyItem() {
    DoglyItem(dog = getDogs()[0], onItemClick = {})
}
