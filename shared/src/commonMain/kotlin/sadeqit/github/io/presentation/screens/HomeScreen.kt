package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import sadeqit.github.io.presentation.theme.AppBreakpoints
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeScreen(
    onProjectsClick: () -> Unit,
    onArticlesClick: () -> Unit,
    onAboutClick: () -> Unit,
    onContactClick: () -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            HomeHero(
                isMobile = isMobile,
                onProjectsClick = onProjectsClick,
                onContactClick = onContactClick
            )

            HomeSectionDivider()

            HomeAbout(
                isMobile = isMobile,
                onAboutClick = onAboutClick
            )

            HomeSectionDivider()

            HomeProjects(onProjectsClick = onProjectsClick)

            HomeSectionDivider()

            HomeSkills(isMobile = isMobile)

            HomeSectionDivider()

            HomeArticles(onArticlesClick = onArticlesClick)

            HomeSectionDivider()

            HomeApproach(isMobile = isMobile)

            HomeSectionDivider()

            HomeContact(
                isMobile = isMobile,
                onContactClick = onContactClick
            )
        }
    }
}

/* -------------------------------------------------------------------------- */
/* Hero                                                                       */
/* -------------------------------------------------------------------------- */

@Composable
private fun HomeHero(
    isMobile: Boolean,
    onProjectsClick: () -> Unit,
    onContactClick: () -> Unit,
) {

    HomeContainer(
        modifier = Modifier.padding(
            vertical = if (isMobile) {
                AppDimensions.Space16
            } else {
                AppDimensions.Space32
            }
        )
    ) {
        if (isMobile) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
            ) {
                HeroText(
                    centered = true,
                    onProjectsClick = onProjectsClick,
                    onContactClick = onContactClick
                )

                HeroCodeCard()
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space64),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    HeroText(
                        centered = false,
                        onProjectsClick = onProjectsClick,
                        onContactClick = onContactClick
                    )
                }

                Box(
                    modifier = Modifier.weight(0.9f)
                ) {
                    HeroCodeCard()
                }
            }
        }
    }

}

@Composable
private fun HeroText(
    centered: Boolean,
    onProjectsClick: () -> Unit,
    onContactClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (centered) {
            Alignment.CenterHorizontally
        } else {
            Alignment.Start
        },
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space20)
    ) {
        Text(
            text = "ANDROID & KOTLIN DEVELOPER",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )

        Text(
            text = "نرم‌افزارهایی می‌سازم\nکه برای ماندن ساخته شده‌اند.",
            style = if (centered) {
                MaterialTheme.typography.headlineLarge
            } else {
                MaterialTheme.typography.displayLarge
            },
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )

        Text(
            text = "توسعه‌دهنده نرم‌افزار با تمرکز بر Kotlin، Android و Compose؛ " +
                    "با تمرکز بر ساخت محصولاتی مدرن، قابل اعتماد و قابل توسعه.",
            modifier = Modifier.widthIn(max = 620.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
        ) {
            Button(
                onClick = onProjectsClick,
                shape = MaterialTheme.shapes.medium
            ) {
                Text("پروژه‌های من")
            }

            OutlinedButton(
                onClick = onContactClick,
                shape = MaterialTheme.shapes.medium
            ) {
                Text("تماس با من")
            }
        }
    }
}


/* -------------------------------------------------------------------------- */
/* Hero visual                                                                */
/* -------------------------------------------------------------------------- */

@Composable
private fun HeroCodeCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(AppDimensions.Space24),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppDimensions.Space8
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
                ) {
                    WindowDot(MaterialTheme.colorScheme.error)
                    WindowDot(MaterialTheme.colorScheme.tertiary)
                    WindowDot(MaterialTheme.colorScheme.primary)
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Sadegh IT",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(AppDimensions.Space16))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(AppDimensions.Space20),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
            ) {
                CodeLine("class", " Developer")
                CodeLine("val", " stack = listOf(")
                CodeLine("\"Kotlin\"", ",")
                CodeLine("\"Android\"", ",")
                CodeLine("\"Compose\"", ",")
                CodeLine("\"KMP\"", ",")
                CodeLine(")", "")
            }

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
            ) {
                SkillChip("Kotlin")
                SkillChip("Android")
                SkillChip("Compose")
                SkillChip("KMP")
            }
        }
    }
}

@Composable
private fun WindowDot(color: Color) {
    Box(
        modifier = Modifier
            .widthIn(
                min = AppDimensions.IconSmall,
                max = AppDimensions.IconSmall
            )
            .height(AppDimensions.IconSmall)
            .clip(CircleShape)
            .background(color.copy(alpha = 0.8f))
    )
}

@Composable
private fun CodeLine(
    first: String,
    second: String,
) {
    Row {
        Text(
            text = first,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = second,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

/* -------------------------------------------------------------------------- */
/* Shared section structure                                                    */
/* -------------------------------------------------------------------------- */

@Composable
private fun HomeSectionDivider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.outlineVariant
    )
}

@Composable
private fun HomeContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppDimensions.Space16),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = AppDimensions.ContentMaxWidth)
        ) {
            content()
        }
    }
}

@Composable
private fun SectionHeader(
    eyebrow: String,
    title: String,
    description: String,
    centered: Boolean = false,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (centered) {
            Alignment.CenterHorizontally
        } else {
            Alignment.Start
        },
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
    ) {
        Text(
            text = eyebrow,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )

        Text(
            text = description,
            modifier = Modifier.widthIn(max = 720.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = if (centered) TextAlign.Center else TextAlign.Start
        )
    }
}

/* -------------------------------------------------------------------------- */
/* About                                                                      */
/* -------------------------------------------------------------------------- */

@Composable
private fun HomeAbout(
    isMobile: Boolean,
    onAboutClick: () -> Unit,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = if (isMobile) {
                AppDimensions.Space48
            } else {
                AppDimensions.Space48
            }
        )
    ) {
        if (isMobile) {
            Column(
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space24)
            ) {
                SectionHeader(
                    eyebrow = "ABOUT ME",
                    title = "کد فقط بخشی از کاری است که انجام می‌دهم.",
                    description = "تمرکز من روی ساخت محصولاتی است که علاوه بر ظاهر مناسب، " +
                            "ساختار فنی سالم و قابلیت توسعه داشته باشند."
                )

                OutlinedButton(
                    onClick = onAboutClick,
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("بیشتر درباره من")
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space64),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    SectionHeader(
                        eyebrow = "ABOUT ME",
                        title = "کد فقط بخشی از کاری است که انجام می‌دهم.",
                        description = "تمرکز من روی ساخت محصولاتی است که علاوه بر ظاهر مناسب، " +
                                "ساختار فنی سالم و قابلیت توسعه داشته باشند."
                    )
                }

                Box(
                    modifier = Modifier.weight(0.55f)
                ) {
                    OutlinedButton(
                        onClick = onAboutClick,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("بیشتر درباره من")
                    }
                }
            }
        }
    }
}

/* -------------------------------------------------------------------------- */
/* Projects                                                                   */
/* -------------------------------------------------------------------------- */

@Composable
private fun HomeProjects(
    onProjectsClick: () -> Unit,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = AppDimensions.Space48
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space40)
        ) {
            SectionHeader(
                eyebrow = "SELECTED PROJECTS",
                title = "پروژه‌های منتخب",
                description = "نمونه‌ای از محصولاتی که با تمرکز روی تجربه کاربری، معماری و کیفیت ساخته شده‌اند."
            )

            HorizontalCardRow {
                ProjectCard(
                    modifier = Modifier.width(280.dp),
                    title = "Weatherino",
                    description = "اپلیکیشن هواشناسی مولتی‌پلتفرم با Kotlin Multiplatform و Compose.",
                    tags = listOf("KMP", "Compose", "Ktor"),
                    onClick = onProjectsClick
                )

                ProjectCard(
                    modifier = Modifier.width(280.dp),
                    title = "تعبیر خواب صادق",
                    description = "اپلیکیشن اندرویدی با تمرکز روی تجربه کاربری ساده و سریع.",
                    tags = listOf("Android", "Kotlin", "Compose"),
                    onClick = onProjectsClick
                )

                ProjectCard(
                    modifier = Modifier.width(280.dp),
                    title = "Sadeq IT",
                    description = "وب‌سایت شخصی و حرفه‌ای برای معرفی تجربه، پروژه‌ها و مهارت‌ها.",
                    tags = listOf("Kotlin", "Wasm", "Compose"),
                    onClick = onProjectsClick
                )
            }

            OutlinedButton(
                onClick = onProjectsClick,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("مشاهده همه پروژه‌ها")
            }
        }
    }
}


@Composable
private fun ProjectCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    tags: List<String>,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(AppDimensions.Space16),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppDimensions.Space2
        )
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.Space96 + AppDimensions.Space24)
                    .clip(RoundedCornerShape(AppDimensions.Space12))
                    .background(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.07f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "</>",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.65f),
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
            ) {
                tags.forEach { SkillChip(it) }
            }
        }
    }
}

@Composable
private fun HorizontalCardRow(
    content: @Composable RowScope.() -> Unit,
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onHorizontalDrag = { change, dragAmount ->
                        change.consume()
                        scope.launch {
                            scrollState.scrollBy(dragAmount)
                        }
                    }
                )
            },
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space16),
        content = content
    )
}
/* -------------------------------------------------------------------------- */
/* Skills                                                                     */
/* -------------------------------------------------------------------------- */

@Composable
private fun HomeSkills(
    isMobile: Boolean,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = if (isMobile) {
                AppDimensions.Space48
            } else {
                AppDimensions.Space48
            }
        )
    ) {
        if (isMobile) {
            Column(
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space32)
            ) {
                SectionHeader(
                    eyebrow = "TECH STACK",
                    title = "ابزارهایی که با آن‌ها کار می‌کنم",
                    description = "تمرکز اصلی من روی Kotlin و اکوسیستم مدرن Android است."
                )

                SkillsContent()
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space64),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(0.8f)
                ) {
                    SectionHeader(
                        eyebrow = "TECH STACK",
                        title = "ابزارهایی که با آن‌ها کار می‌کنم",
                        description = "تمرکز اصلی من روی Kotlin و اکوسیستم مدرن Android است."
                    )
                }

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    SkillsContent()
                }
            }
        }
    }
}

@Composable
private fun SkillsContent() {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space12),
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
    ) {
        listOf(
            "Kotlin",
            "Android",
            "Jetpack Compose",
            "Kotlin Multiplatform",
            "Ktor",
            "SQLDelight",
            "Git",
            "Gradle"
        ).forEach {
            SkillChip(it)
        }
    }
}

@Composable
private fun SkillChip(
    text: String,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(AppDimensions.Space8))
            .background(
                MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
            )
            .border(
                width = AppDimensions.BorderThin,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                shape = RoundedCornerShape(AppDimensions.Space8)
            )
            .padding(
                horizontal = AppDimensions.Space12,
                vertical = AppDimensions.Space8
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/* -------------------------------------------------------------------------- */
/* Articles                                                                   */
/* -------------------------------------------------------------------------- */

@Composable
private fun HomeArticles(
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
            SectionHeader(
                eyebrow = "RECENT ARTICLES",
                title = "از چیزهایی که یاد می‌گیرم می‌نویسم",
                description = "مقالاتی درباره Kotlin، Android، Compose، معماری و تجربه توسعه نرم‌افزار."
            )

            HorizontalCardRow {

                ArticleCard(
                    modifier = Modifier.width(280.dp),
                    category = "KOTLIN",
                    title = "چرا Clean Code فقط تمیز نوشتن کد نیست؟",
                    onClick = onArticlesClick
                )

                ArticleCard(
                    modifier = Modifier.width(280.dp),
                    category = "ANDROID",
                    title = "ساختار پروژه‌های قابل نگهداری در Android",
                    onClick = onArticlesClick
                )

                ArticleCard(
                    modifier = Modifier.width(280.dp),
                    category = "COMPOSE",
                    title = "اصول طراحی UI قابل توسعه با Compose",
                    onClick = onArticlesClick
                )
            }
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

/* -------------------------------------------------------------------------- */
/* Approach                                                                   */
/* -------------------------------------------------------------------------- */

private data class ApproachItem(
    val title: String,
    val description: String,
)

private val approachItems = listOf(
    ApproachItem(
        title = "Problem Solving",
        description = "درک دقیق مسئله و نیازهای محصول پیش از پیاده‌سازی؛ تحلیل ریشه‌ای چالش‌ها و تبدیل آن‌ها به راهکارهای فنی مؤثر و قابل اجرا."
    ),
    ApproachItem(
        title = "Architecture",
        description = "طراحی ساختاری ماژولار با مرزبندی شفاف مسئولیت‌ها و مدیریت صحیح وابستگی‌ها، با تمرکز بر توسعه‌پذیری، تست‌پذیری و نگهداری بلندمدت."
    ),
    ApproachItem(
        title = "Clean Code",
        description = "نوشتن کدی خوانا، ساده و قابل فهم با مسئولیت‌های مشخص، نام‌گذاری معنادار و حداقل پیچیدگی؛ کدی که تیم بتواند با اطمینان توسعه دهد."
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
        description = "طراحی با نگاه بلندمدت؛ به‌گونه‌ای که محصول با رشد قابلیت‌ها و پیچیدگی، بدون افزایش کنترل‌نشده بدهی فنی، پایدار و گسترش‌پذیر بماند."
    ),
)

@Composable
private fun HomeApproach(
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
            SectionHeader(
                eyebrow = "HOW I WORK",
                title = "کدنویسی با نگاه محصول",
                description = "هدف فقط تحویل کد نیست؛ هدف ساخت چیزی است که بتواند رشد کند."
            )

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
                                ApproachCard(
                                    modifier = Modifier.weight(1f),
                                    number = (rowIndex * columns + columnIndex + 1)
                                        .toString()
                                        .padStart(2, '0'),
                                    title = item.title,
                                    description = item.description
                                )
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

/* -------------------------------------------------------------------------- */
/* Contact                                                                    */
/* -------------------------------------------------------------------------- */

@Composable
private fun HomeContact(
    isMobile: Boolean,
    onContactClick: () -> Unit,
) {
    HomeContainer(
        modifier = Modifier.padding(
            top = if (isMobile) AppDimensions.Space48 else AppDimensions.Space48,
            bottom = if (isMobile) AppDimensions.Space48 else AppDimensions.Space48
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
                            AppDimensions.Space24
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