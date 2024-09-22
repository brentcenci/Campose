package com.brentcodes.campose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import campose.composeapp.generated.resources.Res
import campose.composeapp.generated.resources.favorite_filled
import campose.composeapp.generated.resources.favorite_outline
import campose.composeapp.generated.resources.favorite_red
import campose.composeapp.generated.resources.list_check
import campose.composeapp.generated.resources.list_plus
import campose.composeapp.generated.resources.pause
import campose.composeapp.generated.resources.pause_filled_white_32
import campose.composeapp.generated.resources.play
import campose.composeapp.generated.resources.play_filled_white_32
import campose.composeapp.generated.resources.repeat
import campose.composeapp.generated.resources.repeat_1
import campose.composeapp.generated.resources.shuffle
import campose.composeapp.generated.resources.skip_back
import campose.composeapp.generated.resources.skip_back_filled
import campose.composeapp.generated.resources.skip_forward
import campose.composeapp.generated.resources.skip_next_filled
import org.jetbrains.compose.resources.painterResource
import kotlin.math.roundToInt

@Composable
fun BasicMusicControls(modifier: Modifier = Modifier) {
    var sliderValue by remember { mutableStateOf(0f) }
    var isPlaying by remember { mutableStateOf(false) }
    var shuffle by remember { mutableStateOf(0) }
    var liked by remember { mutableStateOf(false) }

    Column(modifier = modifier.width(300.dp)) {
        Column {
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { shuffle = (shuffle + 1) % 3 }) {
                Icon(if (shuffle == 0) painterResource(Res.drawable.shuffle) else if (shuffle == 1) painterResource(Res.drawable.repeat) else painterResource(Res.drawable.repeat_1), "Shuffle State" )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.skip_back), "Back")
            }
            IconButton(
                onClick = { isPlaying = !isPlaying},
                colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color(0xFF1140bf), contentColor = Color.White)
            ) {
                Icon(if (isPlaying) painterResource(Res.drawable.pause) else painterResource(Res.drawable.play), "Play or Pause Button")
            }
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.skip_forward), "Forward")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { liked = !liked}) {
                Icon(if (liked) painterResource(Res.drawable.favorite_red) else painterResource(Res.drawable.favorite_outline), "Like", modifier = Modifier.size(24.dp), tint = if (liked) Color(0xFF1140bf) else Color.Black)
            }
        }
    }
}

@Composable
fun ExtendedMusicControls(modifier: Modifier = Modifier, duration: Int = 128, songTitle: String = "Song Title", artist: String = "Artist Name ft. Artist") {
    var sliderValue by remember { mutableStateOf(0f) }
    var isPlaying by remember { mutableStateOf(false) }
    var shuffle by remember { mutableStateOf(0) }
    var inPlaylist by remember { mutableStateOf(false) }

    Column(modifier = modifier.width(300.dp)) {

        Box(modifier = Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center) {
            Column() {
                Text(text = songTitle, fontSize = 40.sp, fontWeight = FontWeight.Bold, maxLines = 1, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                Text(text = artist, maxLines = 1, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }

        }

        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(thumbColor = Color.Black, activeTrackColor = Color(0xFF5f6368))
        )
        Row(modifier = Modifier.fillMaxWidth().offset(y = (-12).dp), verticalAlignment = Alignment.Top) {
            Text(text = "${duration.times(sliderValue).roundToInt().floorDiv(60)}:${duration.times(sliderValue).roundToInt().rem(60).toString().padStart(2, '0')}", fontSize = 12.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "${duration.floorDiv(60)}:${(duration%60).toString().padStart(2, '0')}", fontSize = 12.sp)
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { shuffle = (shuffle + 1) % 3 }) {
                Icon(if (shuffle == 0) painterResource(Res.drawable.shuffle) else if (shuffle == 1) painterResource(Res.drawable.repeat) else painterResource(Res.drawable.repeat_1), "Shuffle State" )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.skip_back_filled), "Back")
            }
            IconButton(
                onClick = { isPlaying = !isPlaying},
                colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.Black, contentColor = Color.White),
                modifier = Modifier.size(48.dp)
            ) {
                Icon(if (isPlaying) painterResource(Res.drawable.pause_filled_white_32) else painterResource(Res.drawable.play_filled_white_32), "Play or Pause Button")
            }
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.skip_next_filled), "Forward")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { inPlaylist = !inPlaylist}) {
                Icon(if (inPlaylist) painterResource(Res.drawable.list_check) else painterResource(Res.drawable.list_plus), "Add to Playlist")
            }
        }
    }
}