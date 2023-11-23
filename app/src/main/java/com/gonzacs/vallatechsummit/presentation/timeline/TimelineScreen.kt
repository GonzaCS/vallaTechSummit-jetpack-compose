package com.gonzacs.vallatechsummit.presentation.timeline

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.gonzacs.vallatechsummit.data.initialPosts
import com.gonzacs.vallatechsummit.domain.Post
import com.gonzacs.vallatechsummit.presentation.post.PostItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalAnimationApi
@Composable
fun TimelineScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Row { Text("HoC 2021 Jetpack Compose") } },
                navigationIcon = {},
                actions = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(imageVector = (Icons.Default.Search), contentDescription = null)
                        }
                    )
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* TODO */ },
                text = { Text("Add a new post") },
                icon = { Icon(imageVector = Icons.Outlined.Add, contentDescription = null) })
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        TimelineList(listOfPosts = initialPosts)
    }
}

@ExperimentalAnimationApi
@Composable
fun TimelineList(listOfPosts: List<Post>) {
    LazyColumn {
        items(listOfPosts) { post ->
            PostItem(post = post)
        }
    }
}

