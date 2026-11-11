package sadeqit.github.io.presentation.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HoverCard(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    content: @Composable ColumnScope.() -> Unit,
) {
    val hoverEffect = rememberHoverEffect(enableScale = false)

    Card(
        modifier = modifier.hoverable(hoverEffect.interactionSource),
        shape = shape,
        border = BorderStroke(
            width = AppDimensions.BorderThin,
            brush = hoverEffect.borderBrush,
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        content = content,
    )
}