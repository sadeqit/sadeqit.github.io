package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.ContentPadding),
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space24)
    ) {
        Text(
            text = "سلام، من صادق هستم",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "توسعه‌دهنده نرم‌افزار و علاقه‌مند به ساخت محصولات مدرن و کاربردی",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "در این سایت می‌توانید با پروژه‌ها، مقالات، مهارت‌ها و تجربیات من آشنا شوید.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
        ) {
            Button(
                onClick = {}
            ) {
                Text("مشاهده پروژه‌ها")
            }

            OutlinedButton(
                onClick = {}
            ) {
                Text("مطالعه مقالات")
            }
        }

        HorizontalDivider()

        Text(
            text = "درباره من",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "من روی توسعه نرم‌افزار، طراحی معماری مناسب و ساخت تجربه‌های کاربری ساده و قابل اعتماد تمرکز دارم.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "مهارت‌ها",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Kotlin  •  Android  •  Kotlin Multiplatform  •  Compose Multiplatform  •  Git",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}