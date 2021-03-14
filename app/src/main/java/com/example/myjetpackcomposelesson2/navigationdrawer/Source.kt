package com.example.myjetpackcomposelesson2.navigationdrawer

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import com.example.myjetpackcomposelesson2.R

fun listOfNavOptionSource() = mutableListOf(
    NavOption(aIcon = Icons.Default.Favorite, "All events"),
    NavOption(aIcon = Icons.Default.Add, "Create new Event"),
    NavOption(aIcon = Icons.Default.Close, "Event's History")
)

fun listOfNavOptionHorizontalSource() = mutableListOf(
    NavOptionHorizontal(aImage = R.drawable.letter_b, "Letter B"),
    NavOptionHorizontal(aImage = R.drawable.letter_e, "Letter E"),
    NavOptionHorizontal(aImage = R.drawable.letter_f, "Letter F")
)