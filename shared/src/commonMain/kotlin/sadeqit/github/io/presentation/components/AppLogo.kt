package sadeqit.github.io.presentation.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import sadeqit.github.io.presentation.theme.AppColors.DarkPrimary
import sadeqit.github.io.presentation.theme.AppColors.LightPrimary

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(
        label = "AppLogoColorTransition"
    )

    val animatedColor = infiniteTransition.animateColor(
        initialValue = LightPrimary,
        targetValue = DarkPrimary,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "AppLogoColor"
    )

    Text(
        text = "SADEGH IT",
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        color = animatedColor.value,
        fontWeight = FontWeight.Bold
    )
}