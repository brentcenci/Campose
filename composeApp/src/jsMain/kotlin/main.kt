import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import com.brentcodes.campose.App
import com.brentcodes.campose.components.Card
import com.brentcodes.campose.components.CardWithSideImage
import com.brentcodes.campose.components.ImageCard
import com.brentcodes.campose.components.ImageCardWithBadges
import com.brentcodes.campose.components.ImageCardWithButton
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.url.URLSearchParams

@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)
fun main() {

    onWasmReady {
        CanvasBasedWindow("Campose") {
            Box(modifier = Modifier.fillMaxSize().background(Color.LightGray.copy(alpha = 0.4f)).padding(20.dp), contentAlignment = Alignment.Center) {
                val queryParams = URLSearchParams(window.location.search)
                when (queryParams.get("category")) {

                    "cards" -> when (queryParams.get("component")) {
                        "basiccard" -> Card(
                            title = "This is a Title",
                            content = "This is sample content, which should be shorxt and sweet."
                        )
                        "imagecard" -> ImageCard(
                            title = "This is a Title",
                            content = "This is the content of the image card, which is short and sweet",
                            imageUrl = "https://picsum.photos/400/400"
                        )
                        "imagecardwithbutton" -> ImageCardWithButton(
                            title = "This is a Title",
                            content = "This is the content of the image card, which is short and sweet",
                            imageUrl = "https://picsum.photos/400/400",
                            buttonText = "Button"
                        )
                        "imagecardwithbadges" -> ImageCardWithBadges(
                            title = "This is a Title",
                            content = "This is the content of the image card, which is short and sweet",
                            imageUrl = "https://picsum.photos/400/400",
                            titleBadge = "SALE",
                            contentBadges = listOf("Cotton", "Linen")
                        )
                        "cardwithsideimage" -> CardWithSideImage(
                            title = "Short Title",
                            content = "Short and sweet content section",
                            imageUrl = "https://picsum.photos/400/400"
                        )
                    }
                    else -> {
                        FlowColumn(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                            Card(
                                title = "This is a Title",
                                content = "This is sample content, which should be shorxt and sweet."
                            )
                            ImageCard(
                                title = "This is a Title",
                                content = "This is the content of the image card, which is short and sweet",
                                imageUrl = "https://picsum.photos/400/400"
                            )
                            ImageCardWithButton(
                                title = "This is a Title",
                                content = "This is the content of the image card, which is short and sweet",
                                imageUrl = "https://picsum.photos/400/400",
                                buttonText = "Button"
                            )
                            ImageCardWithBadges(
                                title = "This is a Title",
                                content = "This is the content of the image card, which is short and sweet",
                                imageUrl = "https://picsum.photos/400/400",
                                titleBadge = "SALE",
                                contentBadges = listOf("Cotton", "Linen")
                            )
                            CardWithSideImage(
                                title = "Short Title",
                                content = "Short and sweet content section",
                                imageUrl = "https://picsum.photos/400/400"
                            )
                        }
                    }
                }
            }
        }
    }
}
