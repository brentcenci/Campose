import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import com.brentcodes.campose.components.VideoCardYoutubeStyle

fun main() = application {
    Window(
        title = "Campose",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            VideoCardYoutubeStyle(
                title = "Short Title",
                authorName = "PewDiePie",
                authorImage = "https://picsum.photos/100/100",
                views = "1.5M views ",
                time = "22 hours ago",
                length = "12:34",
                imageUrl = "https://picsum.photos/500/500"
            )
        }
    }
}