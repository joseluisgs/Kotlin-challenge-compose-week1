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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R

@Composable
fun DoglyToolbar(color: Color) {
    Surface(
        modifier = Modifier
            .background(color)
            .fillMaxWidth()
            .height(56.dp),
        elevation = 8.dp,
        color = color
    ) {
        ConstraintLayout {
            val (imageMenu, text, iconAvatar) = createRefs()
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Main menu",
                tint = Color.White,
                modifier = Modifier
                    .constrainAs(imageMenu) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        centerVerticallyTo(parent)
                    }
                    .height(40.dp)
                    .width(40.dp)
                    .padding(start = 8.dp)
                    .clickable { }
            )
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier
                    .constrainAs(iconAvatar) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        centerVerticallyTo(parent)
                    }
                    .height(40.dp)
                    .width(40.dp)
                    .padding(end = 8.dp)
                    .clickable { }
            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.constrainAs(text) {
                    centerHorizontallyTo(parent)
                    centerVerticallyTo(parent)
                }
            )
        }
    }
}
