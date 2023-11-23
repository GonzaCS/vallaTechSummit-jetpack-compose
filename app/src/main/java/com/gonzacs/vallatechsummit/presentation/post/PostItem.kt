package com.gonzacs.vallatechsummit.presentation.post

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzacs.vallatechsummit.data.initialPosts
import com.gonzacs.vallatechsummit.data.users
import com.gonzacs.vallatechsummit.domain.Post
import com.gonzacs.vallatechsummit.domain.User
import com.gonzacs.vallatechsummit.ui.theme.VallaTechSummitTheme

@ExperimentalAnimationApi
@Composable
fun PostItem(
    post: Post
) {
    Column {
        var show by remember { mutableStateOf(false) }
        Column(modifier = Modifier.clickable { show = !show }) {
            AuthorInfoSection(author = post.author)
        }
        Column {
            AnimatedVisibility(
                visible = show,
                enter = expandVertically(
                    animationSpec = tween(durationMillis = 1000)
                ), exit = shrinkVertically(
                    animationSpec = tween(durationMillis = 1000)
                )
            ) {
                Column {
                    PostImage(imageId = post.postImageId)
                    IconSection()
                }

            }
        }

    }
}

@Composable
fun IconSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            var fav by remember { mutableStateOf(false) }
            IconToggleButton(checked = fav, onCheckedChange = { fav = it }) {
                val icon = if (fav) Filled.Favorite else Outlined.FavoriteBorder
                val tint = if (fav) Color.Red else MaterialTheme.colorScheme.onBackground
                Icon(
                    imageVector = icon,
                    tint = tint,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Outlined.MailOutline,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Outlined.Share,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
            }
        }
        var star by remember { mutableStateOf(false) }
        IconToggleButton(checked = star, onCheckedChange = { star = it }) {
            val icon = if (star) Filled.Star else Outlined.Star
            val tint = if (star) Color(0xFFD4AF37) else MaterialTheme.colorScheme.onBackground
            Icon(
                imageVector = icon,
                tint = tint,
                contentDescription = null
            )
        }
    }
}

@Composable
fun PostImage(
    imageId: Int
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AuthorInfoSection(
    author: User
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RowImageWithText(
            imageId = author.avatarId,
            text = author.name,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /* TODO */ }
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }
    }
}

@Composable
fun RowImageWithText(
    imageId: Int,
    text: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = imageId),
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier
                .padding(8.dp)
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    VallaTechSummitTheme {
        PostItem(initialPosts.first())
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun PostItemBigPreview() {
    VallaTechSummitTheme() {
        PostItem(initialPosts[1])
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun PostItemDarkPreview() {
    VallaTechSummitTheme(darkTheme = true) {
        PostItem(initialPosts.first())
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorInfoSectionPreview() {
    VallaTechSummitTheme() {
        AuthorInfoSection(users.first())
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorInfoSectionDarkPreview() {
    VallaTechSummitTheme(darkTheme = true) {
        AuthorInfoSection(users.first())
    }
}
