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
package com.example.androiddevchallenge.data

data class Dog(
    val id: Int,
    val name: String,
    val photo: String,
    val age: Int,
    val breed: String,
    val gender: Gender,
    val weight: String,
    val location: String,
    val description: String
)

enum class Gender {
    Male, Female
}

fun getDogs() = listOf(
    Dog(
        id = 0,
        name = "Jack",
        photo = "https://images.dog.ceo/breeds/labrador/n02099712_209.jpg",
        age = 10,
        breed = "Labrador",
        gender = Gender.Male,
        weight = "30kg",
        location = "Madrid",
        description = "Hi there! My name is Jack and I am looking for my forever family. Could that be you?"
    ),
    Dog(
        id = 1,
        name = "Kala",
        photo = "https://images.dog.ceo/breeds/spaniel-cocker/n02102318_11481.jpg",
        age = 2,
        breed = "Spaniel Cocker",
        gender = Gender.Female,
        weight = "20kg",
        location = "Madrid",
        description = "Hi there! My name is Kala and I am looking for my forever family. Could that be you?"
    ),
    Dog(
        id = 2,
        name = "Marea",
        photo = "https://images.dog.ceo/breeds/hound-blood/n02088466_6775.jpg",
        age = 1,
        breed = "Hound Blood",
        gender = Gender.Female,
        weight = "10kg",
        location = "Córdoba",
        description = "Hi there! My name is Marea and I am looking for my forever family. Could that be you?"
    ),
    Dog(
        id = 3,
        name = "Bruta",
        photo = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_1761.jpg",
        age = 12,
        breed = "Bulldog Boston",
        gender = Gender.Female,
        weight = "15kg",
        location = "Madrid",
        description = "Hi there! My name is Bruta and I am looking for my forever family. Could that be you?"
    ),
    Dog(
        id = 4,
        name = "Luki",
        photo = "https://images.dog.ceo/breeds/maltese/n02085936_4713.jpg",
        age = 4,
        breed = "Maltese",
        gender = Gender.Male,
        weight = "8kg",
        location = "Madrid",
        description = "Hi there! My name is Luki and I am looking for my forever family. Could that be you?"
    ),
    Dog(
        id = 5,
        name = "Jara",
        photo = "https://images.dog.ceo/breeds/labrador/n02099712_5261.jpg",
        age = 1,
        breed = "Labrador",
        gender = Gender.Female,
        weight = "5kg",
        location = "Madrid",
        description = "Hi there! My name is Jara and I am looking for my forever family. Could that be you?"
    )
)
