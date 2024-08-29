package com.brentcodes.campose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage

@Composable
fun ExpandingHorizontal(
    modifier: Modifier = Modifier,
    imageURL: String = "https://picsum.photos/800/800",
    titles: List<String> = listOf("First", "Second", "Third"),
    subtitles: List<String> = listOf("Live Freely", "Love Life", "Laugh Always"),
    details: List<String> = listOf("This is some sample text where you can describe, in detail, the properties of the card this is attached to. " +
            "You can fill this out so it will only display when the card is clicked.",
        "This is some sample text where you can describe, in detail, the properties of the card this is attached to. " +
                "You can fill this out so it will only display when the card is clicked.",
        "This is some sample text where you can describe, in detail, the properties of the card this is attached to. " +
                "You can fill this out so it will only display when the card is clicked.")
) {
    var expandedIndex by remember { mutableIntStateOf(-1) }
    Row(modifier = modifier) {
        for (value in 0..2) {
            val weight by animateFloatAsState(if (expandedIndex == value) 2f else 1f)
            ExpandingHorizontalItem(
                imageURL = imageURL,
                expanded = expandedIndex == value,
                onClick = {
                    expandedIndex =
                        if (expandedIndex == value) -1 else value
                },
                modifier = Modifier.weight(weight),
                title = titles[value],
                subtitle = subtitles[value],
                details = details[value])
        }
    }
}

@Composable
fun ExpandingHorizontalItem(
    imageURL: String,
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    details: String
) {
    val imageLoader = remember { ImageLoader(context = PlatformContext.INSTANCE) }
    Box(
        modifier = modifier.height(800.dp).padding(10.dp).clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }) {
        AsyncImage(
            model = imageURL,
            contentDescription = "Placeholder",
            imageLoader = imageLoader,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray.copy(alpha = 0.6f)))
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.weight(1f).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    subtitle,
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
            AnimatedVisibility(
                visible = expanded,
                modifier = Modifier.weight(1f),
                exit = ExitTransition.None
            ) {
                if (expanded) Column(
                    modifier = Modifier.fillMaxSize().background(
                        Color.Black.copy(alpha = 0.8f),
                        RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)
                    ).padding(vertical = 60.dp, horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        "Details",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                    Text(
                        details,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Button(onClick = { }) { Text("See more") }
                }
            }
        }
    }
}

/*@Composable
fun ExpandingHorizontalItem(
    imageURL: String,
    expanded: Boolean,
    onClick: () -> Unit,
    index: Int,
    modifier: Modifier = Modifier
) {
    val imageLoader = remember { ImageLoader(context = PlatformContext.INSTANCE) }
    Box(
        modifier = modifier.height(800.dp).padding(10.dp).clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f)) {
                AsyncImage(
                    model = imageURL,
                    contentDescription = "Placeholder",
                    imageLoader = imageLoader,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray.copy(alpha = 0.6f)))
                Column(
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                ) {
                    Text(
                        "Title $index",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "Experience life",
                        color = Color.White,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }
            AnimatedVisibility(
                visible = expanded,
                modifier = Modifier.weight(1f),
                exit = ExitTransition.None
            ) {
                if (expanded) Column(
                    modifier = Modifier.fillMaxSize().background(
                        Color.Black.copy(alpha = 0.8f),
                        RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)
                    ).padding(vertical = 60.dp, horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        "Details",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                    Text(
                        "This is some sample text where you can describe, in detail, the properties of the card this is attached to. " +
                                "You can fill this out so it will only display when the card is clicked.",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = { }) { Text("See more") }
                }
            }
        }
    }
}*/