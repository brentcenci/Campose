package com.brentcodes.campose.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.InternalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage

@OptIn(InternalComposeUiApi::class)
@Composable
fun Card(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.background(Color.Cyan, RoundedCornerShape(20.dp)).width(300.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "https://media.istockphoto.com/id/1147544807/vector/thumbnail-image-vector-graphic.jpg?s=612x612&w=0&k=20&c=rnCKVbdxqkjlcs3xH87-9gocETqpspHFXu5dIGB4wuM=",
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = coil3.PlatformContext.INSTANCE),
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.FillBounds
            )
            Text("This is a card example")
        }
    }
}