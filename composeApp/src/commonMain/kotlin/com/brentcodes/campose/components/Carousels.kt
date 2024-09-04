package com.brentcodes.campose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicCarousel(modifier: Modifier = Modifier) {
    val items = listOf(
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
    )
    val carouselState = rememberCarouselState {items.size}
    HorizontalMultiBrowseCarousel(
        state = carouselState,
        preferredItemWidth = 400.dp,
        itemSpacing = 10.dp
    ) { imageIndex ->
        Box(modifier = Modifier.size(400.dp)) {
            AsyncImage(
                model = items[imageIndex],
                contentDescription = "Carousel item",
                modifier = Modifier.fillMaxSize(),
                imageLoader = ImageLoader(PlatformContext.INSTANCE),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun BasicCarouselPager(modifier: Modifier = Modifier) {
    val items = listOf(
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
        "https://picsum.photos/600",
    )
    val pagerState = rememberPagerState(pageCount = { items.size })
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.height(400.dp).fillMaxWidth()
    ) { imageIndex ->
        AsyncImage(
            model = items[imageIndex],
            contentDescription = "Carousel item",
            modifier = Modifier.fillMaxSize().clickable {  },
            imageLoader = ImageLoader(PlatformContext.INSTANCE),
            contentScale = ContentScale.Crop
        )
    }
}