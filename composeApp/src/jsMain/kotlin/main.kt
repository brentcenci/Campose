import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import com.brentcodes.campose.components.Card
import com.brentcodes.campose.components.CardWithSideImage
import com.brentcodes.campose.components.Comment
import com.brentcodes.campose.components.CommentStyleTwo
import com.brentcodes.campose.components.ImageCard
import com.brentcodes.campose.components.ImageCardWithBadges
import com.brentcodes.campose.components.ImageCardWithButton
import com.brentcodes.campose.components.StarRatingBar
import com.brentcodes.campose.components.StarRatingPostReview
import com.brentcodes.campose.components.StarRatingReview
import com.brentcodes.campose.components.VideoCard
import com.brentcodes.campose.components.VideoCardYoutubeStyle
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
                            content = "This is sample content, which should be short and sweet."
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
                        "videocardyoutubestyle" -> VideoCardYoutubeStyle(
                            title = "Short Title",
                            authorName = "PewDiePie",
                            authorImage = "https://picsum.photos/100/100",
                            views = "1.5M views ",
                            time = "22 hours ago",
                            length = "12:34",
                            imageUrl = "https://picsum.photos/500/500"
                        )
                        "videocard" -> VideoCard(
                            title = "You won't believe what happens next",
                            summary = "In this video, we try something crazy! Subscribe to make sure you never miss out!",
                            length = "1:23",
                            imageUrl = "https://picsum.photos/500/500",
                            authorName = "CoolVideoGuy42",
                            authorImage = "https://picsum.photos/100/100",
                        )
                    }
                    "reviews" -> when (queryParams.get("component")) {
                        "comment" -> Comment("https://picsum.photos/id/64/100/100")
                        "commentstyletwo" -> CommentStyleTwo(
                            userImage = "https://picsum.photos/100/100",
                            userName = "John Doe"
                        )
                        "starratingbar" -> StarRatingBar(
                                modifier = Modifier
                                    .background(
                                        Color.White,
                                        RoundedCornerShape(20.dp))
                                    .padding(20.dp)
                        )
                        "starratingpostreview" -> StarRatingPostReview(
                            title = "Leave a Review!",
                            subtitle = "Let others know how your experience was with SuperCoolBusiness! Leave a quick review below."
                        )
                        "starratingreview" -> StarRatingReview(
                            name = "Julian Manname",
                            userImage = "https://picsum.photos/100/100",
                            message = "I thoroughly enjoyed this product! The product was so clean and perfectly met my needs. Thanks, Business name!",
                            rating = 3
                        )
                    }
                    else -> {
                        FlowColumn(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                            Card(
                                title = "This is a Title",
                                content = "This is sample content, which should be short and sweet."
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
                            VideoCardYoutubeStyle(
                                title = "Short Title",
                                authorName = "PewDiePie",
                                authorImage = "https://picsum.photos/100/100",
                                views = "1.5M views ",
                                time = "22 hours ago",
                                length = "12:34",
                                imageUrl = "https://picsum.photos/500/500"
                            )
                            VideoCard(
                                title = "You won't believe what happens next",
                                summary = "In this video, we try something crazy! Subscribe to make sure you never miss out!",
                                length = "1:23",
                                imageUrl = "https://picsum.photos/500/500",
                                authorName = "CoolVideoGuy42",
                                authorImage = "https://picsum.photos/100/100",
                            )
                            Comment("https://picsum.photos/id/64/100/100")
                            CommentStyleTwo(
                                userImage = "https://picsum.photos/100/100",
                                userName = "John Doe"
                            )
                            StarRatingBar(
                                modifier = Modifier.background(
                                    Color.White,
                                    RoundedCornerShape(20.dp)
                                ).padding(20.dp)
                            )
                            StarRatingPostReview(
                                title = "Leave a Review!",
                                subtitle = "Let others know how your experience was with SuperCoolBusiness! Leave a quick review below."
                            )
                            StarRatingReview(
                                name = "Julian Manname",
                                userImage = "https://picsum.photos/100/100",
                                message = "I thoroughly enjoyed this product! The product was so clean and perfectly met my needs. Thanks, Business name!",
                                rating = 3
                            )
                        }
                    }
                }
            }
        }
    }
}
