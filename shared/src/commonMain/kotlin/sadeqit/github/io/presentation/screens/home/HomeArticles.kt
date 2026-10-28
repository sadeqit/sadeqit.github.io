package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeArticles(
    onArticlesClick: () -> Unit,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = AppDimensions.Space48
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space40)
        ) {
            HomeReveal {
                SectionHeader(
                    eyebrow = "RECENT ARTICLES",
                    title = "از چیزهایی که یاد می‌گیرم می‌نویسم",
                    description = "مقالاتی درباره Kotlin، Android، Compose، معماری و تجربه توسعه نرم‌افزار."
                )
            }

            HorizontalCardRow {
                HomeRevealItem(
                    index = 0,
                    isMobile = false
                ) {
                    ArticleCard(
                        modifier = Modifier.width(280.dp),
                        category = "KOTLIN",
                        title = "چرا Clean Code فقط تمیز نوشتن کد نیست؟",
                        onClick = onArticlesClick
                    )
                }

                HomeRevealItem(
                    index = 1,
                    isMobile = false
                ) {
                    ArticleCard(
                        modifier = Modifier.width(280.dp),
                        category = "ANDROID",
                        title = "ساختار پروژه‌های قابل نگهداری در Android",
                        onClick = onArticlesClick
                    )
                }

                HomeRevealItem(
                    index = 2,
                    isMobile = false
                ) {
                    ArticleCard(
                        modifier = Modifier.width(280.dp),
                        category = "COMPOSE",
                        title = "اصول طراحی UI قابل توسعه با Compose",
                        onClick = onArticlesClick
                    )
                }
            }
            HomeReveal {
                OutlinedButton(
                    onClick = onArticlesClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("مشاهده همه مقالات")
                }
            }
        }
    }
}

@Composable
private fun ArticleCard(
    modifier: Modifier = Modifier,
    category: String,
    title: String,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(AppDimensions.Space16),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16)
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "مطالعه مقاله →",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
