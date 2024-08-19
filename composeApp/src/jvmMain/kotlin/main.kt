import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.brentcodes.campose.components.Comment
import com.brentcodes.campose.components.MainToggle
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
            Comment(userImage = "https://picsum.photos/100/100")
        }
    }
}