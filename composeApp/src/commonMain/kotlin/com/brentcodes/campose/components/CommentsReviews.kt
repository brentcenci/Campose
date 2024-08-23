package com.brentcodes.campose.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage

@Composable
fun Comment(userImage: String) {
    val imageLoader = remember { ImageLoader(context = PlatformContext.INSTANCE) }
    val textValue = remember { mutableStateOf("") }
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).padding(20.dp)) {
        Column(
            modifier = Modifier.width(400.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.width(400.dp)
            ) {
                AsyncImage(
                    model = userImage,
                    contentDescription = "Placeholder",
                    imageLoader = imageLoader,
                    modifier = Modifier.size(48.dp).clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop
                )
                OutlinedTextField(
                    value = textValue.value,
                    onValueChange = { textValue.value = it },
                    shape = RoundedCornerShape(20.dp),
                    placeholder = { Text("Add comment...") },
                    /*colors = TextFieldDefaults.colors(focusedContainerColor = Color.LightGray.copy(alpha = 0.2f), unfocusedContainerColor = Color.LightGray.copy(alpha=0.4f)),*/
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {}) {
                    Text("Post")
                }
            }
        }
    }
}

@Composable
fun CommentStyleTwo(userImage: String, userName: String) {
    val imageLoader = remember { ImageLoader(context = PlatformContext.INSTANCE) }
    val textValue = remember { mutableStateOf("") }
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).padding(20.dp)) {
        Column(
            modifier = Modifier.width(400.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.width(400.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = userImage,
                    contentDescription = "Placeholder",
                    imageLoader = imageLoader,
                    modifier = Modifier.size(32.dp).clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop
                )
                Text(text = userName, fontSize = 20.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {}) {
                    Text("Post")
                }
            }
            OutlinedTextField(
                value = textValue.value,
                onValueChange = { textValue.value = it },
                shape = RoundedCornerShape(20.dp),
                placeholder = { Text("Add comment...") },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
fun StarRatingBar(
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    ratingState: MutableState<Int> = remember { mutableIntStateOf(1) },
    imageVector: ImageVector = Icons.Default.Star,
    selectedColor: Color = Color.Yellow,
    unselectedColor: Color = Color.LightGray,
    clickable: Boolean = true,
) {
    Row(modifier = modifier) {
        for (value in 1..5) {
            StarIcon(
                size = size,
                ratingState = ratingState,
                imageVector = imageVector,
                ratingValue = value,
                selectedColor = selectedColor,
                unselectedColor = unselectedColor,
                clickable = clickable
            )
        }
    }
}

@Composable
fun StarIcon(
    size: Dp,
    ratingState: MutableState<Int>,
    imageVector: ImageVector,
    ratingValue: Int,
    selectedColor: Color,
    unselectedColor: Color,
    clickable: Boolean = true
) {
    val tint by animateColorAsState(
        targetValue = if (ratingValue <= ratingState.value) selectedColor else unselectedColor,
        label = ""
    )

    Icon(
        imageVector = imageVector,
        contentDescription = null,
        modifier = Modifier
            .size(size)
            .clickable(enabled = clickable) {
                ratingState.value = ratingValue
            },
        tint = tint
    )
}

@Composable
fun StarRatingPostReview(title: String, subtitle: String) {
    val textValue = remember { mutableStateOf("") }
    Box(modifier = Modifier.width(400.dp).background(Color.White, RoundedCornerShape(20.dp)).padding(20.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Text(
                text = title,
                fontSize = 24.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )
            StarRatingBar(modifier = Modifier.align(Alignment.CenterHorizontally), selectedColor = Color.Blue)
            OutlinedTextField(
                value = textValue.value,
                onValueChange = { textValue.value = it },
                shape = RoundedCornerShape(20.dp),
                placeholder = { Text("Leave a comment...") },
                modifier = Modifier.fillMaxWidth(),
            )
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = { }) {
                    Text("Submit Review")
                }
            }
        }
    }
}

@Composable
fun StarRatingReview(name: String, userImage: String, rating: Int, message: String) {
    val imageLoader = remember { ImageLoader(context = PlatformContext.INSTANCE) }
    Box(modifier = Modifier.width(400.dp).background(Color.White, RoundedCornerShape(20.dp)).padding(20.dp)) {
        Row {
            AsyncImage(
                model = userImage,
                contentDescription = "Placeholder",
                imageLoader = imageLoader,
                modifier = Modifier.size(32.dp).clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Crop
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = name, fontWeight = FontWeight.Bold, color = Color.DarkGray)
                StarRatingBar(size = 24.dp, clickable = false, ratingState = remember { mutableIntStateOf(rating) }, selectedColor = Color(255,215,0))
                Text(text = message, color = Color.DarkGray)
            }
        }
    }
}