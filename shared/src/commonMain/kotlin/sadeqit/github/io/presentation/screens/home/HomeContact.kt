package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeContact(
    isMobile: Boolean,
    onContactClick: () -> Unit,
) {
    val hoverEffect = rememberHoverEffect(
        enableScale = true,
        scale = 1.04f
    )
    HomeReveal {
        HomeContainer(
            modifier = Modifier.padding(
                vertical = AppDimensions.Space48
            )
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(AppDimensions.Space24),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = if (isMobile) {
                                AppDimensions.Space16
                            } else {
                                AppDimensions.Space48
                            },
                            vertical = AppDimensions.Space48
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16)
                ) {
                    Text(
                        text = "پروژه ای در ذهن دارید؟",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "از یک ایده اولیه تا محصولی آماده رشد — کنار شما هستیم تا مسیر فنی را با اطمینان طی کنید.",
                        modifier = Modifier.widthIn(max = 680.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(AppDimensions.Space4))

                    Button(
                        onClick = onContactClick,
                        modifier = Modifier.graphicsLayer {
                            scaleX = hoverEffect.scale
                            scaleY = hoverEffect.scale
                        },
                        interactionSource = hoverEffect.interactionSource,
                        shape = MaterialTheme.shapes.medium,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("در تماس باشیم")
                    }
                }
            }
        }
    }
}