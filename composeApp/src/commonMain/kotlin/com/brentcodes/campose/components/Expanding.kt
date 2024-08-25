package com.brentcodes.campose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage

@Composable
fun ExpandingHorizontal(modifier: Modifier = Modifier, imageURL: String = "https://picsum.photos/800/800") {
    var expandedIndex by remember { mutableIntStateOf(-1) }
    Row {
        for (value in 0..4) {
            val weight by animateFloatAsState(if (expandedIndex == value) 3f else 1f)
            ExpandingHorizontalItem(imageURL = imageURL, expanded = expandedIndex == value, onClick = { expandedIndex =
                if (expandedIndex == value) -1 else value } , index = value, modifier = Modifier.weight(weight))
        }
    }
}

@Composable
fun ExpandingHorizontalItem(imageURL: String, expanded: Boolean, onClick: () -> Unit, index: Int, modifier: Modifier = Modifier) {
    val imageLoader = remember { ImageLoader(context = PlatformContext.INSTANCE) }
    Box(modifier = modifier.height(800.dp).padding(10.dp).clip(RoundedCornerShape(20.dp))) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f)) {
                AsyncImage(
                    model = imageURL,
                    contentDescription = "Placeholder",
                    imageLoader = imageLoader,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.fillMaxSize().clickable { onClick() }.padding(20.dp)) {
                    Text("This is card $index")
                    Text("Card $index expanded: $expanded")
                }
            }
            AnimatedVisibility(visible = expanded, modifier = Modifier.weight(1f)) {
                if (expanded) Column(modifier = Modifier.fillMaxSize().background(Color.White, RoundedCornerShape(20.dp)).border(1.dp, Color.Black, RoundedCornerShape(20.dp))) {
                    Text("this is the expanded column text")
                }
            }
        }
    }

}