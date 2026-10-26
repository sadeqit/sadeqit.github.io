package sadeqit.github.io.presentation.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import sadeqit.github.io.presentation.theme.AppColors.DarkPrimary
import sadeqit.github.io.presentation.theme.AppColors.LightPrimary
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun AppFooter() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column {
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outline
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = AppDimensions.ContentMaxWidth)
                    .padding(AppDimensions.ContentPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
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
                    style = MaterialTheme.typography.titleMedium,
                    color = animatedColor.value,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "توسعه نرم‌افزار و فناوری",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "© 2026 SADEGH IT",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}