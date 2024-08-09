import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.brentcodes.campose.App
import com.brentcodes.campose.components.cards.Card
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.url.URLSearchParams

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    onWasmReady {
        CanvasBasedWindow("Campose") {
            val queryParams = URLSearchParams(window.location.search)
            when (queryParams.get("q")) {
                "test" -> App()
                else -> Card()
            }
        }
    }
}
