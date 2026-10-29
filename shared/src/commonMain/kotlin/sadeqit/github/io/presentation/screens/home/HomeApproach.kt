package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import sadeqit.github.io.presentation.theme.AppDimensions

private data class ApproachItem(
    val title: String,
    val description: String,
)

private val approachItems = listOf(
    ApproachItem(
        title = "Problem Solving",
        description = "درک دقیق مسئله و نیازهای محصول پیش از پیاده‌سازی؛ تحلیل ریشه‌ای چالش‌ها و تبدیل آن‌ها به راهکارهای فنی مؤثر و اجراپذیر."
    ),
    ApproachItem(
        title = "Architecture",
        description = "طراحی ساختاری ماژولار با مرزبندی شفاف مسئولیت‌ها و مدیریت صحیح وابستگی‌ها، با تمرکز بر توسعه‌پذیری، تست‌پذیری و نگهداری بلندمدت."
    ),
    ApproachItem(
        title = "Clean Code",
        description = "نوشتن کدی خوانا، ساده و قابل فهم با مسئولیت‌های مشخص، نام‌گذاری معنادار و حداقل پیچیدگی؛ کدی که بتوان با اطمینان توسعه و نگهداری کرد."
    ),
    ApproachItem(
        title = "SOLID Principles",
        description = "به‌کارگیری عملی اصول SOLID برای کاهش وابستگی، افزایش انعطاف‌پذیری و ایجاد ساختاری که در برابر تغییرات محصول مقاوم باشد."
    ),
    ApproachItem(
        title = "Design Patterns",
        description = "انتخاب آگاهانه الگوهای طراحی متناسب با مسئله، تنها زمانی که ارزش واقعی ایجاد کنند؛ بدون تحمیل پیچیدگی و انتزاع غیرضروری."
    ),
    ApproachItem(
        title = "Testing & Quality",
        description = "طراحی کد تست‌پذیر و توجه به تست، مدیریت خطا، بازبینی کد و کنترل کیفیت، برای کاهش هزینه نگهداری و افزایش اطمینان‌پذیری نرم‌افزار."
    ),
    ApproachItem(
        title = "User-Centered Development",
        description = "تبدیل نیازهای واقعی کاربر به تجربه‌ای ساده و کاربردی؛ در نظر گرفتن UX و رفتار مخاطب هدف به‌عنوان بخشی از تصمیم‌گیری فنی."
    ),
    ApproachItem(
        title = "Scalability & Maintainability",
        description = "طراحی با نگاه بلندمدت؛ به‌ گونه‌ای که محصول با رشد قابلیت‌ ها و پیچیدگی، پایدار و گسترش‌ پذیر بماند."
    ),
)
@Composable
fun HomeApproach(
    isMobile: Boolean,
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
                    eyebrow = "HOW I WORK",
                    title = "اصولی که در توسعه نرم‌افزار دنبال می‌ کنم",
                    description = "از تحلیل مسئله و طراحی معماری تا کیفیت کد و تجربه کاربر — هر تصمیم فنی با هدف ساخت محصولی ساده، پایدار و قابل توسعه گرفته می‌ شود."
                )
            }

            val columns = if (isMobile) 2 else 4
            val spacing = if (isMobile) {
                AppDimensions.Space12
            } else {
                AppDimensions.Space16
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(spacing)
            ) {
                approachItems
                    .chunked(columns)
                    .forEachIndexed { rowIndex, rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(spacing)
                        ) {
                            rowItems.forEachIndexed { columnIndex, item ->

                                Box(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    HomeRevealItem(
                                        index = rowIndex * columns + columnIndex,
                                        isMobile = false
                                    ) {
                                        ApproachCard(
                                            modifier = Modifier.fillMaxWidth(),
                                            number = (rowIndex * columns + columnIndex + 1)
                                                .toString()
                                                .padStart(2, '0'),
                                            title = item.title,
                                            description = item.description
                                        )
                                    }
                                }
                            }

                            repeat(columns - rowItems.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
            }
        }
    }
}

@Composable
private fun ApproachCard(
    modifier: Modifier = Modifier,
    number: String,
    title: String,
    description: String,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(AppDimensions.Space16),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
        ) {
            Text(
                text = number,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = title,

                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}