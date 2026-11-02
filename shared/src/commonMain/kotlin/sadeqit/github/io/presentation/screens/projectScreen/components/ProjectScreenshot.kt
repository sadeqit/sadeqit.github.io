package sadeqit.github.io.presentation.screens.projectScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.android_about
import sadeqit.shared.generated.resources.android_air_quality
import sadeqit.shared.generated.resources.android_city_selection
import sadeqit.shared.generated.resources.android_drawer
import sadeqit.shared.generated.resources.android_forecast
import sadeqit.shared.generated.resources.android_home
import sadeqit.shared.generated.resources.android_settings
import sadeqit.shared.generated.resources.dream_01
import sadeqit.shared.generated.resources.dream_02
import sadeqit.shared.generated.resources.dream_03
import sadeqit.shared.generated.resources.dream_04
import sadeqit.shared.generated.resources.dream_05
import sadeqit.shared.generated.resources.dream_06

@Composable
fun ProjectScreenshot(
    name: String,
    modifier: Modifier = Modifier
) {
    val hoverEffect = rememberHoverEffect(
        enableScale = false
    )
    val resource = screenshotResource(name)

    if (resource != null) {
        Card(
            modifier = modifier
                .hoverable(hoverEffect.interactionSource),

            border = BorderStroke(
                width = AppDimensions.BorderThin,
                brush = hoverEffect.borderBrush
            ),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Image(
                painter = painterResource(resource),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

private fun screenshotResource(
    name: String
): DrawableResource? = when (name) {
    "android-about.jpg" -> Res.drawable.android_about
    "android-air-quality.jpg" -> Res.drawable.android_air_quality
    "android-city-selection.jpg" -> Res.drawable.android_city_selection
    "android-drawer.jpg" -> Res.drawable.android_drawer
    "android-forecast.jpg" -> Res.drawable.android_forecast
    "android-home.jpg" -> Res.drawable.android_home
    "android-settings.jpg" -> Res.drawable.android_settings

    "dream-01.png" -> Res.drawable.dream_01
    "dream-02.png" -> Res.drawable.dream_02
    "dream-03.png" -> Res.drawable.dream_03
    "dream-04.png" -> Res.drawable.dream_04
    "dream-05.png" -> Res.drawable.dream_05
    "dream-06.png" -> Res.drawable.dream_06


    else -> null
}
