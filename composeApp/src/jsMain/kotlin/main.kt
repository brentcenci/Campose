import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.CanvasBasedWindow
import campose.composeapp.generated.resources.Res
import campose.composeapp.generated.resources.app
import campose.composeapp.generated.resources.app_dots
import campose.composeapp.generated.resources.dashboard
import com.brentcodes.campose.components.AccessCard
import com.brentcodes.campose.components.BasicAccordion
import com.brentcodes.campose.components.BasicBreadcrumb
import com.brentcodes.campose.components.BasicBreadcrumbWithIcon
import com.brentcodes.campose.components.BasicMusicControls
import com.brentcodes.campose.components.BasicSearchBar
import com.brentcodes.campose.components.BasicSignin
import com.brentcodes.campose.components.BasicSignup
import com.brentcodes.campose.components.BasicToggle
import com.brentcodes.campose.components.BasicToggleWithContent
import com.brentcodes.campose.components.BubbleBreadcrumbs
import com.brentcodes.campose.components.Card
import com.brentcodes.campose.components.CardWithImage
import com.brentcodes.campose.components.CardWithImageAndButton
import com.brentcodes.campose.components.CardWithSideImage
import com.brentcodes.campose.components.Comment
import com.brentcodes.campose.components.CommentStyleTwo
import com.brentcodes.campose.components.ExpandingHorizontal
import com.brentcodes.campose.components.ExtendedMusicControls
import com.brentcodes.campose.components.ImageCard
import com.brentcodes.campose.components.ImageCardWithBadges
import com.brentcodes.campose.components.ImageCardWithButton
import com.brentcodes.campose.components.MainToggle
import com.brentcodes.campose.components.PasswordField
import com.brentcodes.campose.components.PricingCard
import com.brentcodes.campose.components.RoundedSearchBar
import com.brentcodes.campose.components.SaleCard
import com.brentcodes.campose.components.SearchBarWithButton
import com.brentcodes.campose.components.SearchBarWithSuggestions
import com.brentcodes.campose.components.StarRatingBar
import com.brentcodes.campose.components.StarRatingPostReview
import com.brentcodes.campose.components.StarRatingReview
import com.brentcodes.campose.components.UsernameField
import com.brentcodes.campose.components.VideoCard
import com.brentcodes.campose.components.VideoCardYoutubeStyle
import com.brentcodes.campose.components.VolumeControls
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.url.URLSearchParams

@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)
fun main() {

    onWasmReady {
        CanvasBasedWindow("Campose") {
            Box(
                modifier = Modifier.fillMaxSize().background(Color.LightGray.copy(alpha = 0.4f))
                    .padding(20.dp), contentAlignment = Alignment.Center
            ) {
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
                                    RoundedCornerShape(20.dp)
                                )
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

                    "expanding" -> when (queryParams.get("component")) {
                        "expandinghorizontal" -> ExpandingHorizontal()
                    }

                    "accordion" -> when (queryParams.get("component")) {
                        "basicaccordion" -> BasicAccordion()
                    }

                    "toggles" -> when (queryParams.get("component")) {
                        "basictoggle" -> BasicToggle(
                            modifier = Modifier
                                .background(
                                    Color.White,
                                    RoundedCornerShape(20.dp)
                                )
                                .padding(20.dp)
                        )

                        "basictogglewithcontent" -> {
                            val contentState = remember { mutableStateOf(false) }
                            BasicToggleWithContent(
                                modifier = Modifier
                                    .background(
                                        Color.White,
                                        RoundedCornerShape(20.dp)
                                    )
                                    .padding(20.dp),
                                state = contentState,
                                onCheckedChange = { contentState.value = !contentState.value },
                                content = {
                                    val txtColor =
                                        if (!contentState.value) Color.White else Color.DarkGray
                                    val txt = if (!contentState.value) "OFF" else "ON"
                                    Text(text = txt, color = txtColor, fontSize = 20.sp)
                                })
                        }
                    }

                    "breadcrumbs" -> when (queryParams.get("component")) {
                        "basicbreadcrumb" -> {
                            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                                BasicBreadcrumb(
                                    modifier = Modifier.background(
                                        Color.White,
                                        RoundedCornerShape(20.dp)
                                    ).padding(20.dp)
                                )
                                BasicBreadcrumb(
                                    modifier = Modifier.background(
                                        Color.White,
                                        RoundedCornerShape(20.dp)
                                    ).padding(20.dp),
                                    separator = "/",
                                    sections = listOf("Home", "Clothing", "Men's Shirts")
                                )
                            }
                        }

                        "basicbreadcrumbwithicon" -> BasicBreadcrumbWithIcon(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "bubblebreadcrumbs" -> BubbleBreadcrumbs(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp), separator = ">"
                        )
                    }

                    "searchbars" -> when (queryParams.get("component")) {
                        "basicsearchbar" -> BasicSearchBar(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "roundedsearchbar" -> RoundedSearchBar(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "searchbarwithsuggestions" -> SearchBarWithSuggestions(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "searchbarwithbutton" -> SearchBarWithButton(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )
                    }

                    "authentication" -> when (queryParams.get("component")) {
                        "usernamefield" -> UsernameField(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "passwordfield" -> PasswordField(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "basicsignin" -> BasicSignin(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "basicsignup" -> BasicSignup(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )
                    }

                    "mediacontrols" -> when (queryParams.get("component")) {
                        "basicmusiccontrols" -> BasicMusicControls(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "extendedmusiccontrols" -> ExtendedMusicControls(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )

                        "volumecontrols" -> VolumeControls(
                            modifier = Modifier.background(
                                Color.White,
                                RoundedCornerShape(20.dp)
                            ).padding(20.dp)
                        )
                    }

                    else -> {
                        val categoryType = remember { mutableStateOf("test") }
                        FlowRow(modifier = Modifier.align(Alignment.TopCenter)) {
                            for (category in listOf(
                                "cards",
                                "reviews",
                                "expanding",
                                "accordion",
                                "toggles",
                                "breadcrumbs",
                                "carousels",
                                "searchbars",
                                "authentication",
                                "mediacontrols",
                                "test"
                            )) {
                                Button(onClick = {
                                    categoryType.value = category
                                }) { Text(category) }
                            }
                        }
                        FlowColumn(
                            verticalArrangement = Arrangement.spacedBy(20.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            modifier = Modifier.align(
                                Alignment.Center
                            )
                        ) {
                            when (categoryType.value) {
                                "cards" -> {
                                    Card(
                                        title = "This is a Title",
                                        content = "This is sample content, which should be short and sweet."
                                    )
                                    CardWithImage(
                                        title = "This is a Title",
                                        content = "This is the content of the image card, which is short and sweet. You can include a great many details here, or keep it minimal.",
                                        imageUrl = "https://picsum.photos/400/400"
                                    )
                                    CardWithImageAndButton(
                                        title = "This is a Title",
                                        content = "This is the content of the image card, which is short and sweet. You can include a great many details here, or keep it minimal.",
                                        imageUrl = "https://picsum.photos/400/400",
                                        buttonText = "See more"
                                    )
                                    CardWithSideImage(
                                        title = "Short Title",
                                        content = "This is a very short and sweet content section.",
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
                                    PricingCard(
                                        icon = Res.drawable.app,
                                        primaryColor = Color(0xFF2157eb),
                                        forText = "For startups",
                                        planNameText = "Business",
                                        description = "This is a pro plan for small-businesses and startups.",
                                        price = 149,
                                        features = listOf("All analytical features", "Feet pics every Thursday", "Up to 10 team members", "Premium support")
                                    )
                                    SaleCard(imageUrl = "https://picsum.photos/300/300")
                                    AccessCard()
                                }

                                "reviews" -> {
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

                                "expanding" -> {
                                    ExpandingHorizontal()
                                }

                                "accordion" -> {
                                    BasicAccordion()
                                }

                                "toggles" -> {
                                    MainToggle()
                                }

                                "breadcrumbs" -> {
                                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                                        BasicBreadcrumb(
                                            modifier = Modifier.background(
                                                Color.White,
                                                RoundedCornerShape(20.dp)
                                            ).padding(20.dp)
                                        )
                                        BasicBreadcrumb(
                                            modifier = Modifier.background(
                                                Color.White,
                                                RoundedCornerShape(20.dp)
                                            ).padding(20.dp),
                                            separator = "/",
                                            sections = listOf("Home", "Clothing", "Men's Shirts")
                                        )
                                        BasicBreadcrumbWithIcon(
                                            modifier = Modifier.background(
                                                Color.White,
                                                RoundedCornerShape(20.dp)
                                            ).padding(20.dp)
                                        )
                                        BubbleBreadcrumbs(
                                            modifier = Modifier.background(
                                                Color.White,
                                                RoundedCornerShape(20.dp)
                                            ).padding(20.dp), separator = ">"
                                        )
                                    }

                                }

                                "carousels" -> {
                                    val scrollState = rememberScrollState()
                                    val coroutineScope = rememberCoroutineScope()
                                    Row(
                                        modifier = Modifier.horizontalScroll(state = scrollState)
                                            .pointerInput(Unit) {
                                                detectHorizontalDragGestures { _, dragAmount ->
                                                    coroutineScope.launch { scrollState.scrollBy(-dragAmount) }
                                                }
                                            }
                                    ) {
                                        for (index in 1..30) {
                                            Box(
                                                modifier = Modifier.padding(10.dp).size(100.dp)
                                                    .background(Color.Blue)
                                            ) {
                                                Text(text = "$index")
                                            }
                                        }

                                    }
                                }

                                "searchbars" -> {
                                    BasicSearchBar(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    RoundedSearchBar(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    SearchBarWithSuggestions(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    SearchBarWithButton(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                }

                                "authentication" -> {
                                    UsernameField(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    PasswordField(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    BasicSignin(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    BasicSignup(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                }

                                "mediacontrols" -> {
                                    BasicMusicControls(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    ExtendedMusicControls(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                    VolumeControls(
                                        modifier = Modifier.background(
                                            Color.White,
                                            RoundedCornerShape(20.dp)
                                        ).padding(20.dp)
                                    )
                                }

                                "test" -> {
                                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                                        PricingCard(
                                            icon = Res.drawable.app_dots,
                                            primaryColor = Color(0xFF751dc2),
                                            forText = "For individuals",
                                            planNameText = "Basic",
                                            description = "This is a basic plan designed to get you started for personal projects.",
                                            price = 99
                                        )
                                        PricingCard(
                                            icon = Res.drawable.app,
                                            primaryColor = Color(0xFF2157eb),
                                            forText = "For startups",
                                            planNameText = "Business",
                                            description = "This is a pro plan for small-businesses and startups.",
                                            price = 149,
                                            features = listOf("All analytical features", "Feet pics every Thursday", "Up to 10 team members", "Premium support")
                                        )
                                        PricingCard(
                                            icon = Res.drawable.dashboard,
                                            primaryColor = Color(0xFFc21543),
                                            forText = "For big companies",
                                            planNameText = "Enterprise",
                                            description = "This is a professional plan for large-scale use across a large company.",
                                            price = 249,
                                            features = listOf("All analytical features", "Feet pics every Day", "Up to 50 team members", "Dedicated support")
                                        )
                                    }
                                    SaleCard(imageUrl = "https://picsum.photos/300/300")
                                    AccessCard()
                                    CardWithImage(
                                        title = "This is a Title",
                                        content = "This is the content of the image card, which is short and sweet. You can include a great many details here, or keep it minimal.",
                                        imageUrl = "https://picsum.photos/400/400"
                                    )
                                    CardWithImageAndButton(
                                        title = "This is a Title",
                                        content = "This is the content of the image card, which is short and sweet. You can include a great many details here, or keep it minimal.",
                                        imageUrl = "https://picsum.photos/400/400",
                                        buttonText = "See more"
                                    )
                                }

                                else -> {
                                    Text("whoops")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
